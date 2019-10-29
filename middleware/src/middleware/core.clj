(ns middleware.core
  (:require [middleware.http :as http]))

(defn -main [& _]
  (http/start)
  (println "ole"))
  

