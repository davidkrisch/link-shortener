(ns link-shortener.db
  (:use [korma db core]))

(def db {:classname "org.hsqldb.jdbc.JDBCDriver"
         :subprotocol "hsqldb"
         :subname "hsql://localhost:9001/xdb"
         :create false})

(defdb hsql db)
