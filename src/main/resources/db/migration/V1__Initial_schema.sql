drop table if exists book;
CREATE TABLE book (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    version integer NOT NULL,
    author varchar(255) NOT NULL,
    isbn   varchar(255) unique NOT NULL,
    price float8 NOT NULL,
    title varchar(255) NOT NULL,
    created_date timestamp NOT NULL,
    last_modified_date timestamp NOT NULL
);