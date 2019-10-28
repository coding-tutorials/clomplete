(ns consumer.core
  (:require [mount.core :as mount])
  (:require [consumer.kafka :as kafka]))

(defn run-worker []
  (while true
     (do
       (let [records (kafka/pull-records 5)]
         (println records))
       (Thread/sleep 1000))))

(defn -main [& args]
  (mount/start)
  (run-worker))
    
  

