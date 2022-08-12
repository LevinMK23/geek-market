--liquibase formatted sql

--changeset mikelevin:add_data
insert into test (data) values('Hello world')