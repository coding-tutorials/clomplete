(ns clomplete.database-migration
  (:require [ragtime.jdbc :as jdbc]
            [ragtime.repl :as repl]))

(def db-spec
  {:dbtype "postgresql"
   :host "172.17.0.2"
   :port "5432"
   :dbname "bookstore"
   :user "postgres"
   :password "senha123"})

(defn load-config []
  {:datastore  (jdbc/sql-database db-spec)
   :migrations (jdbc/load-resources "migrations")})

(defn migrate []
  (repl/migrate (load-config)))

(defn rollback []
  (repl/rollback (load-config)))