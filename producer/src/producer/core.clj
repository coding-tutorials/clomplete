(ns producer.core
  (:require [aleph.http :as http]
            [clojure.core.async :as async]))

(def consumer-channel (async/chan))

(defn read-response [something]
  (println (str "result: " something)))

(defn call-consumer []
  (println (type (http/get "https://google.com"))))

(defn run-worker []
  (do
    (dotimes [_ 3] 
      (async/put! consumer-channel (call-consumer) read-response))
    (Thread/sleep 5000)))


(defn -main [& args]
  (while true
    (run-worker)))
