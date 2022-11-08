--ОТЧЕТЫ
--Администраторы:
--Просмотр авторизованных пользователей в данный момент:
SELECT * FROM users 
WHERE is_authorized = '1';
--Просмотр неавторизованных пользователей в данный момент
SELECT * FROM users 
WHERE is_authorized = '0';
--Просмотр пользователей за определенный период 
SELECT * FROM users 
WHERE last_login_time = '24-04-1997';

--Модераторы:
--Просмотр заявок на обмен, произведенных за определенный период
SELECT * FROM requests
WHERE publication_time >= '24-04-1997'
AND publication_time <= '07-11-2022';
--Просмотр заблокированных пользователей
SELECT * FROM users 
WHERE user_status = '2';
--Просмотр всех отмененных заявок 
SELECT * FROM requests
WHERE request_status = '3';

--Пользователи
--Просмотр вещей, выставленных на обмен 
SELECT * FROM items
WHERE item_status = '1';
--Просмотр своих скрытых вещей
SELECT * FROM items
WHERE item_status = '2' AND user_id = '1';
--Просмотр заявок на его вещи 
SELECT items.* 
FROM requests JOIN items on requests.item_sender = items.id
WHERE user_id = '1' and requests.request_status = '1';

--ДЕЙСТВИЯ
--Добавления user в БД
INSERT INTO users (id, surname, name, patronymic, login, password, is_authorized, last_login_time, user_role, user_status)
VALUES (users_id.NEXTVAL, 'Ivanоv', 'Ivan', 'Ivanovich', 'ivanov',  '1', '1', '24-04-1997', 3, 1);
--Добавление вещи в БД
INSERT INTO items (id, title, image, description, publication_time, user_id, item_status, count_view)
VALUES (items_id.NEXTVAL, 'Большая Сумка', 'bag.png', 'Новая большая сумка', '29-09-1999', 1, 1, 2);
--Добавление заявки в БД
INSERT INTO requests (id, publication_time, request_status, comment_receiver, item_sender, item_receiver)
VALUES (requests_id.NEXTVAL, '07-11-2022', 1, 'Обменяю вещь', 1,  4);

--Изменение статуса пользователя 
UPDATE users
   SET user_status = '2'
 WHERE id = 1;
 --Изменение статуса заявки
UPDATE requests
   SET request_status = '2'
 WHERE id = 1;
--Изменение статуса вещи
UPDATE items
   SET item_status = '3'
 WHERE id = 1;
 
 --Изменение владельца вещи
 UPDATE items
   SET user_id = '3'
 WHERE id = 1;
 
--Удаление пользователя из БД
DELETE FROM users
WHERE id = 1;
--Удаление вещи из БД
DELETE FROM items
WHERE id = 1;
--Удаление заявки из БД
DELETE FROM requests
WHERE id = 1;

DELETE
FROM
    users
WHERE
    is_authorized = '1';
    
DELETE
FROM
    items
WHERE
    item_status = '1';
    
UPDATE items
   SET publication_time = '07-11-2022'
 WHERE id = 1;
 
 UPDATE requests
   SET publication_time = '07-11-2022'
 WHERE id = 1;