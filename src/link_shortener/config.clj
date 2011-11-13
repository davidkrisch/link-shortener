(ns link-shortener.config)

(def shortened-prefix "http://localhost:8080/")

(def dbconfig
  {:classname "org.hsqldb.jdbc.JDBCDriver"
   :subprotocol "hsqldb"
   :subname "hsql://localhost:9001/xdb"
   :create false})
