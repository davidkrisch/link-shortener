(defproject link-shortener "0.1.0-SNAPSHOT"
            :description "Yet another link shortener. This time in clojure."
            :dependencies [[org.clojure/clojure "1.2.1"]
                           [noir "1.0.0"]
                           [org.hsqldb/hsqldb "2.2.4"]
                           [korma "0.2.1"]
                           [commons-validator/commons-validator "1.3.1"]]
            :dev-dependencies [[drift "1.2.3"]]
            :main link-shortener.server)

