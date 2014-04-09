--- $Id: dbinit.txt 1729 2006-11-12 23:03:16Z benalex $

--- Sample Hypersonic SQL compatible schema and data
---
--- All Acegi Security JDBC DAOs can be customised to use a different schema.
--- In addition, the Acegi Security JDBC DAOs do not even need to be used
--- with Acegi Security, and an entirely customised persistence strategy
--- can be employed via standard interfaces (eg in-memory, Hibernate etc).

SET IGNORECASE TRUE;

CREATE TABLE users (
    username VARCHAR(50) NOT NULL PRIMARY KEY,
    password VARCHAR(50) NOT NULL,
    enabled BIT NOT NULL,
    salt varchar(50)
);

CREATE TABLE authorities (
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL
);
CREATE UNIQUE INDEX ix_auth_username ON authorities (username, authority);

ALTER TABLE authorities ADD CONSTRAINT fk_authorities_users foreign key (username) REFERENCES users(username);

