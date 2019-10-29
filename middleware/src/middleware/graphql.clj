(ns middleware.graphql
  "Contains custom resolvers and a function to provide the full schema."
  (:require
    [clojure.java.io :as io]
    [com.walmartlabs.lacinia.util :as util]
    [com.walmartlabs.lacinia.schema :as schema]
    [clojure.edn :as edn]))

(defn ole [context args value]
 (println "ola"))

(defn resolver-map
  []
  {:query/customer-by-id ole})

(defn load-schema
  []
  (-> (io/resource "graphql-schema.edn")
      slurp
      edn/read-string
      (util/attach-resolvers (resolver-map))
      schema/compile))

(def schema (load-schema))

(defn handle-request [request]
  (println "ope"))
