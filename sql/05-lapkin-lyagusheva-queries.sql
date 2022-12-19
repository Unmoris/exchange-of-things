--������
--��������������:
--�������� �������������� ������������� � ������ ������:
SELECT * FROM users --JOIN user_type ON users.user_role = user_type.id JOIN user_status ON users.user_status = user_status.id 
WHERE is_authorized = '1';
--�������� ���������������� ������������� � ������ ������
SELECT * FROM users 
WHERE is_authorized = '0';
--�������� ������������� �� ������������ ������ 
SELECT * FROM users 
WHERE last_login_time = '24-04-1997';

--����������:
--�������� ������ �� �����, ������������� �� ������������ ������
SELECT * FROM requests
WHERE publication_time >= '24-04-1997'
AND publication_time <= '07-11-2022';
--�������� ��������������� �������������
SELECT * FROM users 
WHERE user_status = '2';
--�������� ���� ���������� ������ 
SELECT * FROM requests
WHERE request_status = '3';

--������������
--�������� �����, ������������ �� ����� 
SELECT * FROM items
WHERE item_status = '1';
--�������� ����� ������� �����
SELECT * FROM items
WHERE item_status = '2' AND user_id = '6';
--�������� ������ �� ��� ���� 
SELECT items.* 
FROM requests JOIN items on requests.item_sender = items.id
WHERE user_id = '2' and requests.request_status = '1';

--��������
--���������� user � ��
INSERT INTO users (id, surname, name, patronymic, login, password, is_authorized, last_login_time, user_role, user_status)
VALUES (users_id.NEXTVAL, 'Ivan�v', 'Ivan', 'Ivanovich', 'ivanov',  '1', '1', '24-04-1997', 3, 1);
--���������� ���� � ��
INSERT INTO items (id, title, image, description, publication_time, user_id, item_status, count_view)
VALUES (items_id.NEXTVAL, '������� �����', 'bag.png', '����� ������� �����', '29-09-1999', 1, 1, 2);
--���������� ������ � ��
INSERT INTO requests (id, publication_time, request_status, comment_receiver, item_sender, item_receiver)
VALUES (requests_id.NEXTVAL, '07-11-2022', 1, '������� ����', 1,  4);

--��������� ������� ������������ 
UPDATE users
   SET user_status = '2'
 WHERE id = 1;
 
 UPDATE users
   SET user_role = 1
 WHERE id = 1;
 
 --��������� ������� ������
UPDATE requests
   SET request_status = '3'
 WHERE id = 1;
--��������� ������� ����
UPDATE items
   SET item_status = '3'
 WHERE id = 1;
 
 --��������� ��������� ����
 UPDATE items
   SET user_id = '3'
 WHERE id = 1;
 
--�������� ������������ �� ��
DELETE FROM users
WHERE id = 1;
--�������� ���� �� ��
DELETE FROM items
WHERE id = 1;
--�������� ������ �� ��
DELETE FROM requests
WHERE id = 1;

----------------?????????????
DELETE FROM users
WHERE is_authorized = '1';
    
DELETE FROM items
WHERE item_status = '1';
    
UPDATE items
   SET publication_time = '07-11-2022'
 WHERE id = 1;
 
 UPDATE requests
   SET publication_time = '07-11-2022'
 WHERE id = 1;