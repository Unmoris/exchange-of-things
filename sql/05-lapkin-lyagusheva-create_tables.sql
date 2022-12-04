--создание таблицы Типы пользователей
create table user_type(
    id int not null,
    role_name varchar(30) not null,
    constraint user_type_pk PRIMARY KEY (id)
    );
    
--создание таблицы Статусы пользователей
create table user_status(
    id int not null,
     user_status_name varchar(30) not null,
    constraint user_status_name_pk PRIMARY KEY (id)
);
    
--создание таблицы Пользователи
create table users(
id int not null,
surname varchar(50),
name varchar(50),
patronymic varchar(50),
login varchar(50) not null,
password varchar(50) not null,
is_authorized char(1) not null,
last_login_time date not null,
user_role int not null,
user_status int not null,
constraint users_pk PRIMARY KEY (id),
constraint role_name_user_role_fk foreign key (user_role) references user_type(id),
constraint user_status_users_fk foreign key (user_status) references user_status(id)
);

--создание таблицы Статусы вещей
create table item_status(
    id int not null,
    item_status_name varchar(30) not null,
    constraint item_status_name_pk PRIMARY KEY (id)
);

--создание таблицы Вещи
create table items(
id int not null,
title varchar(50) not null,
image varchar(250),
description varchar(1000) null,
publication_time date not null,
user_id int not null,
item_status int not null,
count_view int not null,
constraint items_pk PRIMARY KEY (id),
constraint user_items_users_fk foreign key (user_id) references users(id),
constraint item_status_items_fk foreign key (item_status) references item_status(id)
);

--создание таблицы Статусы заявок
create table request_status(
    id int not null,
    request_status_name varchar(30) not null,
    constraint request_status_name_pk PRIMARY KEY (id)
);  

--создание таблицы Заявки
create table requests(
id int not null,
publication_time date not null,
request_status int not null,
comment_receiver varchar(1000) null,
item_sender int not null,
item_receiver int not null,
constraint requests_pk PRIMARY KEY (id),
constraint status_request_status_fk foreign key (request_status) references request_status(id),
constraint item_sender_request_item_fk foreign key (item_sender) references items(id),
constraint item_receiver_request_item_fk foreign key (item_receiver) references items(id)
);

select * 
from requests INNER JOIN items ON requests.item_sender = items.id JOIN items ON requests.item_receiver = items.id
