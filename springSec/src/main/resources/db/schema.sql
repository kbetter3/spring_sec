create table member(
seq int auto_increment primary key,
id varchar(20) not null unique,
pw varchar(256) not null,
name varchar(20) not null,
power int default 0
);

insert into member(id, pw, name, power) values('master', 'admin', 'admin', 1);
insert into member(id, pw, name) values('user01', 'asdf', 'user01');
insert into member(id, pw, name) values('user02', 'asdf', 'user02');