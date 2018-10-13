package com.sage.app;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import com.datastax.driver.mapping.Result;
import com.sage.model.Person;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Cassandra {

    private final Cluster cluster;
    private final Session session;

    public Cassandra() {
        cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        session = cluster.connect("learning");
    }

    private void demoMapper() {
        System.out.println("demoMapper");
        MappingManager manager = new MappingManager(session);
        Mapper<Person> mapper = manager.mapper(Person.class);
        ResultSet rs = session.execute("select * from person");
        Result<Person> persons = mapper.map(rs);
        Person person = mapper.get(UUID.fromString("d575087f-d531-4835-b821-6a57de52b326"));
        System.out.println("\tSingle " + person);
        System.out.println("\tAll Persons");

        for (Person p : persons) {
            System.out.println("\t" + p);
        }


    }

    private void demoQueryBuilder() {
        System.out.println("demoQueryBuilder");
        Select selectFromPerson = QueryBuilder.select().all().from("learning", "person");
        ResultSet rs = session.execute(selectFromPerson);
        rs.forEach(c -> {
            System.out.println(String.format("\tPerson: %s is %s %s", c.getUUID("id"), c.getString("first_name"), c.getString("last_name")));
            Set<String> kids = c.getSet("kids", String.class);
            if (!kids.isEmpty()) {

                System.out.println(String.format("\t\t%s's kids are %s", c.getString("first_name"), kids));
            }
        });


    }

    private void demoInsertWithMapper() {
        System.out.println("demoInsertWithMapper");
        MappingManager manager = new MappingManager(session);
        Mapper<Person> mapper = manager.mapper(Person.class);

        Person biff = new Person("Biff", "Jones", UUID.randomUUID(), new HashSet<>(Arrays.asList("Julie, Biff Jr.")));
        mapper.save(biff);

        for (Person p : mapper.map(session.execute("select * from person"))) {
            System.out.println("\t" + p);
        }


    }

    public static void main(String[] args) {
        Cassandra cassandra = new Cassandra();
        try {
            cassandra.demoMapper();
            cassandra.demoQueryBuilder();
            cassandra.demoInsertWithMapper();
        } finally {
            cassandra.cluster.close();
        }

    }


}
