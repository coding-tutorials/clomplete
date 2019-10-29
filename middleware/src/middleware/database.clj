(ns middleware.database
  (:import [com.zaxxer.hikari HikariDataSource])
  (:require [mount.core :as mount])
  (:require [clojure.java.jdbc :as jdbc]))

(def db-spec
  {:dbtype "postgresql"
   :host (System/getenv "DATABASE_HOST")
   :port (System/getenv "DATABASE_PORT")
   :dbname (System/getenv "DATABASE_NAME")
   :user (System/getenv "DATABASE_USER")
   :password (System/getenv "DATABASE_PASSWORD")})
   
(defn jdbc-string []
  (str "jdbc:postgresql://" (:host db-spec) ":" (:port db-spec) "/" (:dbname db-spec)))

(defn connect-to-database []
 (let [ds (HikariDataSource.)]
   (doto ds
     (.setJdbcUrl (jdbc-string))
     (.setUsername (:user db-spec))
     (.setPassword (:password db-spec)))))

(mount/defstate connection :start (connect-to-database))

(defn query [statement]
  (let [c (.getConnection connection)
        s (jdbc/prepare-statement c (first statement))
        result (jdbc/query c [s])]
    (.close c)
    result))


