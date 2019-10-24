(ns producer.orders-repository
  (:require [producer.database :as db])
  (:require [producer.customers-repository :as customers])
  (:require [producer.products-repository :as products])
  (:require [honeysql.core :as sql]))

(defn insert []
  (let [order-id (java.util.UUID/randomUUID)
        customer-id (get (customers/get-random-customer-id) :id)
        product-ids (products/get-random-products-ids)
        date (java.time.LocalDateTime/now)]
    (do
      (db/execute! (str "INSERT INTO orders (id, customer_id, created_on) VALUES ('" order-id "','" customer-id "','" date "')"))
      (doseq [product-id product-ids]
        (let [uuid (java.util.UUID/randomUUID)]
          (db/execute! (str "INSERT INTO order_products (id, order_id, product_id) VALUES ('" uuid "','" order-id "','" (get product-id :id) "')")))))))
    
  
