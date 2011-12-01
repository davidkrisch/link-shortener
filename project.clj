(defproject link-shortener "0.1.0-SNAPSHOT"
            :description "Yet another link shortener. This time in clojure."
            :dependencies [[org.clojure/clojure "1.3.0"]
                           [noir "1.2.2-SNAPSHOT"]
                           [org.hsqldb/hsqldb "2.2.4"]
                           [korma "0.2.1"]
                           [avout "0.5.0"]
                           [zookeeper-clj "0.9.0"]
                           [commons-validator/commons-validator "1.3.1"]
                           [oro/oro "2.0.8"]]
            :dev-dependencies [[drift "1.4.2"]
                               [org.clojure/java.jdbc "0.1.1"]]
            :main link-shortener.server)

