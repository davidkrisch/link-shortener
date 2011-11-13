(ns link-shortener.db
  (:use [korma db core]
        [link-shortener.config :only (dbconfig)]))

(defdb hsql dbconfig)

(defentity links
  (table :links)
  (entity-fields :suffix :link)
  (database hsql))

(defn add-link [suffix link]
  (insert links
    (values {:suffix suffix :link link})))

(defn get-link [suffix]
  (:LINK (last 
    (select links 
      (where {:suffix suffix})
      (fields :link)))))
