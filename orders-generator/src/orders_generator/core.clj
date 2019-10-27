(ns orders-generator.core
  (:require [mount.core :as mount])
  (:require [orders-generator.orders-repository :as orders]))

(defn -main [& args]
  (mount/start)
  (while true
    (do
      (println "will create")
      (let [resilt (orders/insert)]
        (println resilt))
      (println "order created")
      (Thread/sleep 500))))
    
  

