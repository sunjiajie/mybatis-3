create  table user (
    id int,
    create_time varchar(20),
    name  varchar(20),
    password  varchar(20),
    phone  varchar(20),
    nick_name  varchar(20),
    primary key (id)
);


insert into user (id, create_time, name, password, phone, nick_name) values(1, '2020-01-01 11:11:11','sjj','passwordtest','111',   'Diesel');
insert into user (id, create_time, name, password, phone, nick_name) values(2, '2020-01-01 11:11:11','sjj','passwordtest','111',    null);
insert into user (id, create_time, name, password, phone, nick_name) values(3, '2020-01-01 11:11:11','sjj','passwordtest','111', 'Diesel');
insert into user (id, create_time, name, password, phone, nick_name) values(4, '2020-01-01 11:11:11','sjj','passwordtest','111', 'Gas');

