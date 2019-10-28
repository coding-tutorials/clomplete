(ns producer.core
  (:require [mount.core :as mount])
  (:require [producer.orders-repository :as orders]))

(defn -main [& _]
  (mount/start)
  (while true
    (do
      (println "will create")
      (let [resilt (orders/insert)]
        (println resilt))
      (println "order created")
      (Thread/sleep 500))))
    
  

