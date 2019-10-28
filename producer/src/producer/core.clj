(ns producer.core
  (:require [mount.core :as mount])
  (:require [producer.orders-repository :as orders]))

(defn run-worker []
  (while true
     (do
       (orders/insert)
       (println "order created")
       (Thread/sleep 1000))))

(defn -main [& args]
  (mount/start)
  (run-worker))
    
  

