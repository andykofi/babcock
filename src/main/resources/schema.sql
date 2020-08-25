CREATE TABLE VEHICLE (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    regnumber VARCHAR(128) NOT NULL,
category VARCHAR(128) NOT NULL,
model VARCHAR(128) NOT NULL,
make VARCHAR(128) NOT NULL,
fueltype VARCHAR(128) NOT NULL,
hiredout Boolean default false,
priceperday DOUBLE NULL,
hiredate DATETIME NULL,
enddate DATETIME NULL,
    PRIMARY KEY (id)
);