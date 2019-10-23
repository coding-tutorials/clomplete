(defproject producer "0.0.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/core.async "0.4.500"]
                 [aleph "0.4.6"]
                 [ragtime "0.8.0"]]
  :aliases {"migrate"  ["run" "-m" "clomplete.database-migration/migrate"]}
  :main ^:skip-aot producer.core)
