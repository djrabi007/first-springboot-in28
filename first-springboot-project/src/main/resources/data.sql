INSERT INTO SHIPWRECK(ID,CONDITION, DEPTH,DESCRIPTION,LATITUDE,LONGITUDE,NAME,YEAR_DISCOVERED)
VALUES (1,'Titanic',3000,'titanic WS Bug Ship',11.2,11.2,'Titanic',2019);

INSERT INTO SHIPWRECK(ID,CONDITION, DEPTH,DESCRIPTION,LATITUDE,LONGITUDE,NAME,YEAR_DISCOVERED)
VALUES (2,'fair2',2000,'FERARY WS Bug Ship',11.2,11.2,'fERARY',2013);


INSERT INTO SHIPWRECK(ID,CONDITION, DEPTH,DESCRIPTION,LATITUDE,LONGITUDE,NAME,YEAR_DISCOVERED)
VALUES (3,'Harshabardhan',4000,'Harshabardhan WS Bug Ship',11.2,11.2,'Harshabardhan',2013);

INSERT INTO SHIPWRECK(ID,CONDITION, DEPTH,DESCRIPTION,LATITUDE,LONGITUDE,NAME,YEAR_DISCOVERED)
VALUES (4,'RajBordhan',5000,'RajBordhan WS Bug Ship',11.2,11.2,'RajBordhan',2013);


CREATE SCHEMA test_schema AUTHORIZATION sa;

CREATE TABLE test_schema.Persons (
    PersonID int,
    LastName varchar(255),
    FirstName varchar(255),
    Address varchar(255),
    City varchar(255)
);



