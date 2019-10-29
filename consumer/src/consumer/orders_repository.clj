(ns consumer.orders-repository
  (:require [consumer.database :as db])
  (:require [consumer.customers-repository :as customers])
  (:require [consumer.products-repository :as products])
  (:require [honeysql.core :as sql]))

(defn insert [record]
  (let [order-id (:id record)
        customer-id (:customer_id record)
        product-ids (:product_ids record)
        order-date (:created_on record)]
    (do
      (db/execute! (str "INSERT INTO orders (id, customer_id, order_date, created_on) VALUES ('" order-id "','" customer-id "','" order-date "', NOW())"))
      (doseq [product-id product-ids]
        (let [uuid (java.util.UUID/randomUUID)]
          (db/execute! (str "INSERT INTO order_products (id, order_id, product_id) VALUES ('" uuid "','" order-id "','" product-id "')")))))))
    
  
