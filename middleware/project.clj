(defproject producer "0.0.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [com.zaxxer/HikariCP "3.4.1"]
                 [org.clojure/java.jdbc "0.7.10"]
                 [honeysql "0.9.8"]
                 [mount "0.1.16"]
                 [aleph "0.4.6"]
                 [com.walmartlabs/lacinia "0.35.0"]
                 [org.clojure/data.json "0.2.6"]
                 [org.postgresql/postgresql "42.2.5"]]
  :main ^:skip-aot middleware.core)
