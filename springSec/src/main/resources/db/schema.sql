create table member(
seq int auto_increment primary key,
id varchar(20) not null,
pw varchar(256) not null,
name varchar(20) not null,
power int default 0
);