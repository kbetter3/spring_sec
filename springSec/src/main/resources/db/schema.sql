create table member(
seq int auto_increment primary key,
id varchar(20) not null unique,
pw varchar(256) not null,
name varchar(20) not null,
power int default 0
);

insert into member(id, pw, name, power) values('master', '$2a$10$HcMKNtKCU6/iNsUxGzEqoO7Vy32enEIa58eP4WRbWjP7Ig0WlyPFW', 'admin', 1);
insert into member(id, pw, name) values('user01', '$2a$10$OneZQYQHicB5DpIY3FjD4eLW1vlJFLZmmBx5wIV7WeaQ9defRUiFe', 'user01');
insert into member(id, pw, name) values('user02', '$2a$10$OneZQYQHicB5DpIY3FjD4eLW1vlJFLZmmBx5wIV7WeaQ9defRUiFe', 'user02');