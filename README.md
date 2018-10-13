# cassandra-quick-example
Demo of some data access of cassandra with some datastax libraries.

Do the following to get Cassandra working on your machine:

* Download [Cassandra](http://cassandra.apache.org/) and install
* Start up Cassandra: "cassandra -f" will start it up in the foreground so you don't forget about it
* Add the [datastax](https://github.com/idaho-guy/cassandra-quick-example/commit/4df638f097be037d661e48ce4a84b2d7e307a691) dependencies to your project
* In order to create a table you can use, you first need to create a [keyspace](https://github.com/idaho-guy/cassandra-quick-example/blob/master/person-create.cql#L1)
* Then you can create you table and insert data into it; running this [script](https://github.com/idaho-guy/cassandra-quick-example/blob/master/person-create.cql) will create the keyspace, table, and load the data
* To run the file included in this project (in includes creation of the keyspace, table and table population), run the following command: "cqlsh -f person-create.cql"

The java example has and example of
* Usage of a mapper for querying [individual records and collections](https://github.com/idaho-guy/cassandra-quick-example/blob/master/src/main/java/com/sage/app/Cassandra.java#L29) using the [Person](https://github.com/idaho-guy/cassandra-quick-example/blob/master/src/main/java/com/sage/model/Person.java#L10) model The annotations on Person are
  * @Table
  * @Column (required if the column name in the db is different then the name of the field on the Model)
  * @PartitionKey
* Doing an [Insert](https://github.com/idaho-guy/cassandra-quick-example/blob/master/src/main/java/com/sage/app/Cassandra.java#L62) with a mapper
* Using a [QueryBuilder and ResultSet](https://github.com/idaho-guy/cassandra-quick-example/blob/master/src/main/java/com/sage/app/Cassandra.java#L46)

I just put this together so I would have some notes to remember a video I just watched on Safari Books Online: [Mastering Cassandra Essentials](https://www.safaribooksonline.com/videos/mastering-cassandra-essentials/9781491994122). Just trying to get a feel for what Cassandra is about.




