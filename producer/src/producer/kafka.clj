(ns producer.kafka
  (:import [java.util Properties])
  (:import [org.apache.kafka.clients.consumer KafkaConsumer])
  (:require [mount.core :as mount]))

(defn kafka-consumer []
  (let [consumer (KafkaConsumer. (doto (Properties.)
                                   (.put "bootstrap.servers" "broker:29092")
                                   (.put "group.id" "orders-generator-consumer")
                                   (.put "key.deserializer" "org.apache.kafka.common.serialization.StringDeserializer")
                                   (.put "value.deserializer" "org.apache.kafka.common.serialization.StringDeserializer")))]
    (.subscribe consumer ["orders"])
    consumer))

(mount/defstate consumer :start (kafka-consumer))

(defn pull-records [count]
  (->> (.poll consumer count)
       (map #(.value %))))
   
