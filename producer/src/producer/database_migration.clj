(ns producer.database-migration
  (:require [ragtime.jdbc :as jdbc]
            [ragtime.repl :as repl]))

(def db-spec
  {:dbtype "postgresql"
   :host (System/getenv "DATABASE_HOST")
   :port (System/getenv "DATABASE_PORT")
   :dbname (System/getenv "DATABASE_NAME")
   :user (System/getenv "DATABASE_USER")
   :password (System/getenv "DATABASE_PASSWORD")})

(defn- load-config []
  {:datastore  (jdbc/sql-database db-spec)
   :migrations (jdbc/load-resources "migrations")})

(defn migrate []
  (do
    (println "starting migration...")
    (println db-spec)
    (repl/migrate (load-config))
    (println "migration finished")))


(defn rollback []
  (repl/rollback (load-config)))