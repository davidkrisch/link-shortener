# link-shortener

A link shortener written as a learning tool for clojure, ring, noir,
drift (migrations), and hsqldb

This is very much a work in progress.  There is nothing functional about it, yet.

## Prerequisites

1. Download hsqldb 2.2.5
2. Install clojure
3. Install leiningen

## Usage

1. Run the database

    ```bash
    java -cp ../hsqldb/lib/hsqldb.jar org.hsqldb.server.Server \
         --database.0 file:mydb --dbname.0 xdb
    ```
2. Run Zookeeper

    Create the config file conf/zoo.cfg by copying conf/zoo_sample.cfg.

    ````bash
    ./bin/zkServer.sh start
    ````
2. Download dependencies

    ```bash
    lein deps
    ```
2. Run the tests

    ```bash
    lein test
    ```
2. Run the migrations

    ```bash
    lein migrate -version 1
    ```
3. Run the server

    ```bash
    lein run
    ```

## License

Copyright (C) 2011 David Krisch

Distributed under the Eclipse Public License, the same as Clojure.

