(ns migrations.001-schema-migrations
  (:use [clojure.contrib.sql :as sql]
        [link-shortener.config :only (dbconfig)]))

(defn 
 ^{:doc "Create the schema_migrations table"}
  create-migrations-table []
  (sql/create-table
    :schema_migrations
    [:version :int]))

(defn 
 ^{:doc "Drop the schema_migrations table"}
  drop-migrations-table []
  (try 
    (sql/drop-table :schema_migrations)
    (catch Exception _)))

(defn
 ^{:doc "Migrates the database up to version 1."}
  up []
  (sql/with-connection dbconfig
        (sql/transaction (create-migrations-table))))
  
(defn
 ^{:doc "Migrates the database down from version 1."}
  down []
  (sql/with-connection dbconfig
        (sql/transaction (drop-migrations-table))))
