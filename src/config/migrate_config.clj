(ns config.migrate-config
  (:use [clojure.java.jdbc :as sql]
        [link-shortener.config :only (dbconfig)]))

(defn 
 ^{:doc "Get the current schema migration number"}
  db-version []
  (try 
    (sql/with-connection dbconfig ;; Pull the version number from the schema_migrations table
      (sql/with-query-results res
        ["select version from schema_migrations limit 1"]
        (:version (first res))))
    (catch Exception _ 0))) ;; If there is an exception, return version=0

(defn 
 ^{:doc "Set the current schema migration version"}
  update-db-version [new-version]
  (if (not= 0 new-version)
    (sql/with-connection dbconfig
      (sql/update-or-insert-values 
        :schema_migrations 
        [true] ;; Update every row, there should only be one
        {:version new-version}))))

(defn migrate-config []
  {:directory "/src/migrations"
   :current-version db-version
   :update-version update-db-version})
