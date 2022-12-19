--создание последовательности id пользователей
 CREATE SEQUENCE users_id
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
--DROP SEQUENCE users_id;

--создание последовательности id вещей
  CREATE SEQUENCE items_id
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
--DROP SEQUENCE  items_id;

--создание последовательности id запросов
  CREATE SEQUENCE requests_id
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
--DROP SEQUENCE requests_id;

--Создание ролей пользователей
INSERT INTO user_type (id, role_name) VALUES (1, 'Администратор');
INSERT INTO user_type (id, role_name) VALUES (2, 'Модератор');
INSERT INTO user_type (id, role_name) VALUES (3, 'Пользователь');

--Создание статусов пользователей
INSERT INTO user_status (id, user_status_name) VALUES (1, 'Разблокирован');
INSERT INTO user_status (id, user_status_name) VALUES (2, 'Заблокирован');

--Создание статусов вещей
INSERT INTO item_status (id, item_status_name) VALUES (1, 'Открыта');
INSERT INTO item_status (id, item_status_name) VALUES (2, 'Скрыта');
INSERT INTO item_status (id, item_status_name) VALUES (3, 'Обменена');

--Создание статусов запросов
INSERT INTO request_status (id, request_status_name) VALUES (1, 'Активна');
INSERT INTO request_status (id, request_status_name) VALUES (2, 'Завершена');
INSERT INTO request_status (id, request_status_name) VALUES (3, 'Отменена');

--Добавление новых пользователей в БД
INSERT INTO users (id, surname, name, patronymic, login, password, is_authorized, last_login_time, user_role, user_status)
VALUES (users_id.NEXTVAL, 'Lyagusheva', 'Mariya', 'Alekseevna', 'lyagusheva',  '1', '1', '07-11-2022', 3, 1);
INSERT INTO users (id, surname, name, patronymic, login, password, is_authorized, last_login_time, user_role, user_status)
VALUES (users_id.NEXTVAL, 'Lapkin', 'Mikhail', 'Ilyich', 'lapkin',  '1', '1', '07-11-2022', 3, 1);
INSERT INTO users (id, surname, name, patronymic, login, password, is_authorized, last_login_time, user_role, user_status)
VALUES (users_id.NEXTVAL, 'Prutskov', 'Alexander', 'Victorovich', 'ivanov',  '1', '1', '07-11-2022', 3, 1);
INSERT INTO users (id, surname, name, patronymic, login, password, is_authorized, last_login_time, user_role, user_status)
VALUES (users_id.NEXTVAL, 'Petrov', 'Petr', 'Petrovich', 'petrov',  '1', '1', '07-11-2022', 3, 1);
INSERT INTO users (id, surname, name, patronymic, login, password, is_authorized, last_login_time, user_role, user_status)
VALUES (users_id.NEXTVAL, 'Ivanоv', 'Ivan', 'Ivanovich', 'ivanov',  '1', '1', '07-11-2022', 3, 1);
INSERT INTO users (id, surname, name, patronymic, login, password, is_authorized, last_login_time, user_role, user_status)
VALUES (users_id.NEXTVAL, 'Petrov', 'Petr', 'Petrovich', 'petrov',  '1', '1', '25-05-1997', 3, 1);
INSERT INTO users (id, surname, name, patronymic, login, password, is_authorized, last_login_time, user_role, user_status)
VALUES (users_id.NEXTVAL, 'Lyagusheva', 'Mariya', 'Alekseevna', 'moderator',  '1', '1', '25-05-1997', 2, 1);
INSERT INTO users (id, surname, name, patronymic, login, password, is_authorized, last_login_time, user_role, user_status)
VALUES (users_id.NEXTVAL, 'Lyagusheva', 'Mariya', 'Alekseevna', 'admin',  '1', '1', '25-05-1997', 1, 1);

--Добавление товаров в БД
INSERT INTO items (id, title, image, description, publication_time, user_id, item_status, count_view)
VALUES (items_id.NEXTVAL, 'Сумка', 'bag.png', 'Новая большая сумка', '24-04-1997', 1, 1, 2);
INSERT INTO items (id, title, image, description, publication_time, user_id, item_status, count_view)
VALUES (items_id.NEXTVAL, 'Рюкзак', 'bagpack.png', 'Новая сумка', '24-04-1997', 2, 1, 2);
INSERT INTO items (id, title, image, description, publication_time, user_id, item_status, count_view)
VALUES (items_id.NEXTVAL, 'Кофта', 'bag.png', 'Новая красивая кофта', '24-04-1997', 3, 1, 2);
INSERT INTO items (id, title, image, description, publication_time, user_id, item_status, count_view)
VALUES (items_id.NEXTVAL, 'Сапоги', 'bagpack.png', 'Новые сапоги 37 размера', '24-04-1997', 4, 1, 2);
INSERT INTO items (id, title, image, description, publication_time, user_id, item_status, count_view)
VALUES (items_id.NEXTVAL, 'Сумка', 'bag.png', 'Не новая маленькая сумка', '24-04-1997', 5, 1, 2);
INSERT INTO items (id, title, image, description, publication_time, user_id, item_status, count_view)
VALUES (items_id.NEXTVAL, 'Туфли', 'bagpack.png', 'Новые туфли 38 размера', '24-04-1997', 6, 1, 2);


--Добавление заявок в БД
INSERT INTO requests (id, publication_time, request_status, comment_receiver, item_sender, item_receiver)
VALUES (requests_id.NEXTVAL, '24-04-1997', 1, 'Обменяю вещь', 1,  2);
INSERT INTO requests (id, publication_time, request_status, comment_receiver, item_sender, item_receiver)
VALUES (requests_id.NEXTVAL, '24-04-1997', 1, 'Обменяю вещь', 4,  6);
INSERT INTO requests (id, publication_time, request_status, comment_receiver, item_sender, item_receiver)
VALUES (requests_id.NEXTVAL, '24-04-1997', 1, 'Обменяю вещь', 3,  5);
INSERT INTO requests (id, publication_time, request_status, comment_receiver, item_sender, item_receiver)
VALUES (requests_id.NEXTVAL, '24-04-1997', 1, 'Обменяю вещь', 1,  5);
INSERT INTO requests (id, publication_time, request_status, comment_receiver, item_sender, item_receiver)
VALUES (requests_id.NEXTVAL, '24-04-1997', 1, 'Обменяю вещь', 4,  5);
INSERT INTO requests (id, publication_time, request_status, comment_receiver, item_sender, item_receiver)
VALUES (requests_id.NEXTVAL, '24-04-1997', 1, 'Обменяю вещь', 2,  3);