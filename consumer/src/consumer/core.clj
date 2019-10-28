(ns consumer.core
  (:require [mount.core :as mount])
  (:require [consumer.kafka :as kafka])
  (:require [consumer.orders-repository :as orders]))

(defn run-worker []
  (while true
      (do
        (let [records (kafka/pull-records 5)]
          (doseq [record records]
            (orders/insert record)))
       (Thread/sleep 1000))))

(defn -main [& args]
  (mount/start)
  (run-worker))
    
  

