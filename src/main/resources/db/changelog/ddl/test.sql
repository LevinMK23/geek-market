--liquibase formatted sql

--changeset mikelevin:create_test_table
create table test (
    data text
);

--changeset mikelevin:add column id
alter table test
    add id serial;