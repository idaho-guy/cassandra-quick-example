CREATE KEYSPACE IF NOT EXISTS learning
  WITH REPLICATION = {
   'class' : 'SimpleStrategy',
   'replication_factor' : 1
  };

use learning;

create table person (
    first_name text,
    last_name text,
    kids set<text>,
    id uuid primary key
);

insert into person (id, first_name, last_name, kids) values (uuid(), 'Angelina', 'Jolie',{});
insert into person (id, first_name, last_name, kids) values (d575087f-d531-4835-b821-6a57de52b326, 'Mark', 'Sage',{'Tommy','Emma'});
insert into person (id, first_name, last_name, kids) values (uuid(), 'Margit', 'Sage',{'Mark','Shari'});
insert into person (id, first_name, last_name, kids) values (uuid(), 'Jim', 'Schutt',{'Norma','Janice'});