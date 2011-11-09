# link-shortener

A link shortener written as a learning tool for clojure, ring, noir,
drift (migrations), and hsqldb

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
2. Download dependencies

    ```bash
    lein deps
    ```
2. Run the migrations

    ```bash
    lein migrate -version 1
    ```
3. Download dependencies and run the server

    ```bash
    lein run
    ```

## License

Copyright (C) 2011 David Krisch

Distributed under the Eclipse Public License, the same as Clojure.

