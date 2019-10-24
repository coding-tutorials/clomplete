(ns orders-generator.orders-repository
  (:require [clojure.data.json :as json])
  (:require [orders-generator.kafka :as kafka])
  (:require [orders-generator.customers-repository :as customers])
  (:require [orders-generator.products-repository :as products]))
 
(defn insert []
  (let [id (java.util.UUID/randomUUID)
        customer-id (get (customers/get-random-customer-id) :id)
        product-ids (products/get-random-products-ids)
        date (java.time.LocalDateTime/now)]
    (kafka/send-message (str id) (json/write-str {:id (str id)
                                                  :customer_id (str customer-id)
                                                  :product_ids (map (fn [x] (str (get x :id))) product-ids)
                                                  :created_on (str date)}))))
