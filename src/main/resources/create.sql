CREATE DATABASE wildlife_tracker;

\c wildlife_tracker
CREATE TABLE animals (name varchar , id int);
DROP DATABASE wildlife_tracker_test;
CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;
CREATE TABLE sightings (rangerName varchar , id int , locationName varchar ,);
DROP DATABASE wildlife_tracker_test;
CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;


