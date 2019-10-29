(ns middleware.products-repository
  (:require [honeysql.core :as sql])
  (:require [middleware.database :as db]))

(defn get-random-products-ids []
  (let [count-sql (first (sql/format {:select [:%count.*]
                                      :from [:products]}))]
    (db/query
      (sql/format {:select [:id]
                   :from [:products]
                   :where [:= :deleted_on nil]
                   :order-by [:%random]
                   :limit (keyword (str "RANDOM () * (" count-sql ") + 1"))}))))
    
  
