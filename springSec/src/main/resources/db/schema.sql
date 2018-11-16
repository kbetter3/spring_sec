create table member(
seq int auto_increment primary key,
id varchar(20) not null,
pw varchar(256) not null,
name varchar(20) not null,
power int default 0
);

insert into member(id, pw, name, power) values('master', '$2a$10$fpe6LhyDy2dQV1.VIfHx5.axjY9fyBhDwek42r46kP4OFbo7Pjo8.', 'admin01', 1);
insert into member(id, pw, name) values('user', '$2a$10$QOWh6Fdez0EukWrasuQpNeZw0PKW5QiaSl.siBc5U1Y0X4uYjqRk6', 'user01');