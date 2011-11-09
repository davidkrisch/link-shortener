(ns migrations.001-schema-migrations
  (:use [clojure.contrib.sql :as sql])
  (:use [link-shortener.db :only (db)]))

(defn 
#^{:doc "Create the schema_migrations table"}
  create-migrations-table []
  (sql/create-table
    :schema_migrations
    [:version :int]))

(defn 
#^{:doc "Drop the schema_migrations table"}
  drop-migrations-table []
  (try 
    (sql/drop-table :schema_migrations)
    (catch Exception _)))

(defn
#^{:doc "Migrates the database up to version 1."}
  up []
  (println "migrations.001-schema-migrations up...")
  (sql/with-connection db
        (sql/transaction (create-migrations-table))))
  
(defn
#^{:doc "Migrates the database down from version 1."}
  down []
  (println "migrations.001-schema-migrations down...")
  (sql/with-connection db
        (sql/transaction (drop-migrations-table))))
