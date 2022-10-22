create table type_users(
    id int,
    name varchar(30),
    constraint type_users_pk PRIMARY KEY (id)
    );

create table users(
id int primary key,
surname varchar(50),
name varchar(50),
patronymic varchar(50),
login varchar(50),
password varchar(50),
auth boolean,
last_time_auth date,
type  int,
constraint users_pk PRIMARY KEY (id),
constraint type_users_type_users_fk foreign key (type) references type_users(id)
);

create table item(
id int primary key,
title varchar(50),
image varchar(250),
count_view int,
user int,
description text null,
time_publication date,
constraint item_pk PRIMARY KEY (id),
constraint user_item_users_fk foreign key (user) references users(id)
);
 
create table status(
    id int,
    name varchar(30),
    constraint status_pk PRIMARY KEY (id)
);

create table request(
id int primary key,
status int,
comment text null,
item_sender int,
item_receiver int,
time_publication date,
constraint request_pk PRIMARY KEY (id),
constraint status_request_status_fk foreign key (status) references status(id),
constraint item_sender_request_item_fk foreign key (item_sender) references item(id),
constraint item_receiver_request_item_fk foreign key (item_receiver) references item(id)
);




