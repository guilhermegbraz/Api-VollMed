CREATE TABLE usuarios(
     id BIGINT NOT NULL auto_increment,
     login varchar(100) NOT NULL UNIQUE,
     senha VARCHAR(255) NOT NULL,

     PRIMARY KEY (id)
);
