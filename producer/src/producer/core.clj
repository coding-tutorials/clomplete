(ns producer.core
  (:require [mount.core :as mount])
  (:require [producer.orders-repository :as orders]))
  ;(:require [producer.products-repository :as products-repository]))
  ; (:require [aleph.http :as http]
  ;           [clojure.core.async :as async]))

; (def consumer-channel (async/chan))

; (defn read-response [something]
;   (println (str "result: " something)))

; (defn call-consumer []
;   (println (type (http/get "https://google.com"))))

(defn run-worker []
  (while true
     (do
       (orders/insert)
       (println "order created")
       (Thread/sleep 1000))))

(defn -main [& args]
  (mount/start)
  (run-worker))
    
  

