# cassandra-quick-example
Demo of some data access of cassandra with some datastax libraries.

Do the following to get Cassandra working on your machine:

* Download [Cassandra](http://cassandra.apache.org/)
* Start up Cassandra: "cassandra -f" will start it up in the foreground so you don't forget about it
* Add the [datastax](https://github.com/idaho-guy/cassandra-quick-example/commit/4df638f097be037d661e48ce4a84b2d7e307a691) dependencies to your project
* In order to create a table you can use, you first need to create a [keyspace](https://github.com/idaho-guy/cassandra-quick-example/blob/master/person-create.cql#L1)
* Then you can create you table and insert data into it.
* To run the file included in this project (in includes creation of the keyspace, table and table population), run the following command: cqlsh -f person-create.cql




