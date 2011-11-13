(ns migrations.002-create-link-tables
  (:use [clojure.contrib.sql :as sql]
        [link-shortener.config :only (dbconfig)]))

(defn- create-links-table []
 ^{:doc "Create the links table to store links and their shortened versions"}
  (sql/create-table
    :links
    [:suffix "VARCHAR(64)"]
    [:link "VARCHAR(4096)"]))

(defn- drop-links-table []
 ^{:doc "Drop the links table"}
  (sql/drop-table :links))

(defn
 ^{:doc "Migrates the database up to version 2."}
  up []
  (sql/with-connection dbconfig
        (sql/transaction (create-links-table))))
  
(defn
 ^{:doc "Migrates the database down from version 2."}
  down []
  (sql/with-connection dbconfig
        (sql/transaction (drop-links-table))))
