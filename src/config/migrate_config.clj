(ns config.migrate-config
  (:use [clojure.contrib.sql :as sql])
  (:use [link-shortener.db :only (db)]))

(defn 
#^{:doc "Get the current schema migration number"}
  db-version []
  (try 
    (sql/with-connection db ;; Pull the version number from the schema_migrations table
      (sql/with-query-results res
        ["select version from schema_migrations limit 1"]
        (:version (first res))))
    (catch Exception _ 0))) ;; If there is an exception, return version=0

(defn 
#^{:doc "Set the current schema migration version"}
  update-db-version [new-version]
  (if (not= 0 new-version)
    (sql/with-connection db
      (sql/insert-values :schema_migrations [:version] [new-version]))))

(defn migrate-config []
  {:directory "/src/migrations"
   :current-version db-version
   :update-version update-db-version})
