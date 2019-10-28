(defproject producer "0.0.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [ragtime "0.8.0"]
                 [com.zaxxer/HikariCP "3.4.1"]
                 [org.clojure/java.jdbc "0.7.10"]
                 [honeysql "0.9.8"]
                 [mount "0.1.16"]
                 [org.postgresql/postgresql "42.2.5"]]
  :aliases {"migrate"  ["run" "-m" "producer.database-migration/migrate"]
            "start"    ["do" "migrate," "run"]}
  :main ^:skip-aot producer.core)
