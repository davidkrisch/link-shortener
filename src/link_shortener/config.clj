(ns link-shortener.config
  (:require [zookeeper :as zk]))

(def shortened-prefix "http://localhost:8080/")

(def dbconfig
  {:classname "org.hsqldb.jdbc.JDBCDriver"
   :subprotocol "hsqldb"
   :subname "hsql://localhost:9001/xdb"
   :create false})

(def zkclient (zk/connect "127.0.0.1"))
