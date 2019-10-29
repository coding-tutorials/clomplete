(ns producer.kafka
  (:import [java.util Properties])
  (:import [org.apache.kafka.clients.producer KafkaProducer ProducerRecord])
  (:require [mount.core :as mount]))

(defn kafka-producer []
  (KafkaProducer. (doto (Properties.)
                   (.put "bootstrap.servers" "broker:29092")
                   (.put "client.id" "orders-generator")
                   (.put "key.serializer" "org.apache.kafka.common.serialization.StringSerializer")
                   (.put "value.serializer" "org.apache.kafka.common.serialization.StringSerializer"))))

(mount/defstate producer :start (kafka-producer))

(defn send-message [key value]
 (.get (.send producer (ProducerRecord. "orders" key value))))

