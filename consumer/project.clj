(defproject consumer "0.0.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [ragtime "0.8.0"]
                 [com.zaxxer/HikariCP "3.4.1"]
                 [org.clojure/java.jdbc "0.7.10"]
                 [honeysql "0.9.8"]
                 [mount "0.1.16"]
                 [org.clojure/data.json "0.2.6"]
                 [org.apache.kafka/kafka-clients "2.3.0"]
                 [org.postgresql/postgresql "42.2.5"]]
  :aliases {"migrate"  ["run" "-m" "consumer.database-migration/migrate"]
            "start"    ["do" "migrate," "run"]}
  :main ^:skip-aot consumer.core)
