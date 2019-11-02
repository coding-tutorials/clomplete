(ns middleware.http
  (:require [aleph.http :as http])
  (:require [middleware.graphql :as graphql]))

(def port
  (-> (System/getenv "HTTP_PORT")
      (Integer/parseInt)))

(defn handler [request]
  (let [result (graphql/handle-request request)]
    {:status 200
     :body result}))

(defn start []
  (http/start-server handler {:port port}))
