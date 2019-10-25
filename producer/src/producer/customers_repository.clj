(ns producer.customers-repository
  (:require [producer.database :as db])
  (:require [honeysql.core :as sql]))

(defn get-random-customer-id []
  (first
    (db/query
      (sql/format {:select [:id]
                   :from [:customers]
                   :where [:= :deleted_on nil]
                   :order-by [:%random]
                   :limit :1}))))

    
  
