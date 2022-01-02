DROP TABLE howtos IF EXISTS;
CREATE TABLE howtos (
id            INTEGER            NOT NULL AUTO_INCREMENT PRIMARY KEY,
name          VARCHAR            NOT NULL,
description   VARCHAR            NOT NULL,
category      VARCHAR            NOT NULL,
complexity    VARCHAR            NOT NULL
);
