(defproject producer "0.0.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 ;[org.clojure/core.async "0.4.500"]
                 ;[aleph "0.4.6"]
                 [ragtime "0.8.0"]
                 ;[org.clojure/java.jdbc "0.5.8"]
                 [org.postgresql/postgresql "42.2.5"]]
  :aliases {"migrate"  ["run" "-m" "producer.database-migration/migrate"]
            "start"    ["do" "migrate," "run"]}
  :main ^:skip-aot producer.core)
