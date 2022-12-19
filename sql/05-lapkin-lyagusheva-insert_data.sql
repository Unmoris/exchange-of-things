--�������� ������������������ id �������������
 CREATE SEQUENCE users_id
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
--DROP SEQUENCE users_id;

--�������� ������������������ id �����
  CREATE SEQUENCE items_id
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
--DROP SEQUENCE  items_id;

--�������� ������������������ id ��������
  CREATE SEQUENCE requests_id
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
--DROP SEQUENCE requests_id;

--�������� ����� �������������
INSERT INTO user_type (id, role_name) VALUES (1, '�������������');
INSERT INTO user_type (id, role_name) VALUES (2, '���������');
INSERT INTO user_type (id, role_name) VALUES (3, '������������');

--�������� �������� �������������
INSERT INTO user_status (id, user_status_name) VALUES (1, '�������������');
INSERT INTO user_status (id, user_status_name) VALUES (2, '������������');

--�������� �������� �����
INSERT INTO item_status (id, item_status_name) VALUES (1, '�������');
INSERT INTO item_status (id, item_status_name) VALUES (2, '������');
INSERT INTO item_status (id, item_status_name) VALUES (3, '��������');

--�������� �������� ��������
INSERT INTO request_status (id, request_status_name) VALUES (1, '�������');
INSERT INTO request_status (id, request_status_name) VALUES (2, '���������');
INSERT INTO request_status (id, request_status_name) VALUES (3, '��������');

--���������� ����� ������������� � ��
INSERT INTO users (id, surname, name, patronymic, login, password, is_authorized, last_login_time, user_role, user_status)
VALUES (users_id.NEXTVAL, 'Lyagusheva', 'Mariya', 'Alekseevna', 'lyagusheva',  '1', '1', '07-11-2022', 3, 1);
INSERT INTO users (id, surname, name, patronymic, login, password, is_authorized, last_login_time, user_role, user_status)
VALUES (users_id.NEXTVAL, 'Lapkin', 'Mikhail', 'Ilyich', 'lapkin',  '1', '1', '07-11-2022', 3, 1);
INSERT INTO users (id, surname, name, patronymic, login, password, is_authorized, last_login_time, user_role, user_status)
VALUES (users_id.NEXTVAL, 'Prutskov', 'Alexander', 'Victorovich', 'ivanov',  '1', '1', '07-11-2022', 3, 1);
INSERT INTO users (id, surname, name, patronymic, login, password, is_authorized, last_login_time, user_role, user_status)
VALUES (users_id.NEXTVAL, 'Petrov', 'Petr', 'Petrovich', 'petrov',  '1', '1', '07-11-2022', 3, 1);
INSERT INTO users (id, surname, name, patronymic, login, password, is_authorized, last_login_time, user_role, user_status)
VALUES (users_id.NEXTVAL, 'Ivan�v', 'Ivan', 'Ivanovich', 'ivanov',  '1', '1', '07-11-2022', 3, 1);
INSERT INTO users (id, surname, name, patronymic, login, password, is_authorized, last_login_time, user_role, user_status)
VALUES (users_id.NEXTVAL, 'Petrov', 'Petr', 'Petrovich', 'petrov',  '1', '1', '25-05-1997', 3, 1);
INSERT INTO users (id, surname, name, patronymic, login, password, is_authorized, last_login_time, user_role, user_status)
VALUES (users_id.NEXTVAL, 'Lyagusheva', 'Mariya', 'Alekseevna', 'moderator',  '1', '1', '25-05-1997', 2, 1);
INSERT INTO users (id, surname, name, patronymic, login, password, is_authorized, last_login_time, user_role, user_status)
VALUES (users_id.NEXTVAL, 'Lyagusheva', 'Mariya', 'Alekseevna', 'admin',  '1', '1', '25-05-1997', 1, 1);

--���������� ������� � ��
INSERT INTO items (id, title, image, description, publication_time, user_id, item_status, count_view)
VALUES (items_id.NEXTVAL, '�����', 'bag.png', '����� ������� �����', '24-04-1997', 1, 1, 2);
INSERT INTO items (id, title, image, description, publication_time, user_id, item_status, count_view)
VALUES (items_id.NEXTVAL, '������', 'bagpack.png', '����� �����', '24-04-1997', 2, 1, 2);
INSERT INTO items (id, title, image, description, publication_time, user_id, item_status, count_view)
VALUES (items_id.NEXTVAL, '�����', 'bag.png', '����� �������� �����', '24-04-1997', 3, 1, 2);
INSERT INTO items (id, title, image, description, publication_time, user_id, item_status, count_view)
VALUES (items_id.NEXTVAL, '������', 'bagpack.png', '����� ������ 37 �������', '24-04-1997', 4, 1, 2);
INSERT INTO items (id, title, image, description, publication_time, user_id, item_status, count_view)
VALUES (items_id.NEXTVAL, '�����', 'bag.png', '�� ����� ��������� �����', '24-04-1997', 5, 1, 2);
INSERT INTO items (id, title, image, description, publication_time, user_id, item_status, count_view)
VALUES (items_id.NEXTVAL, '�����', 'bagpack.png', '����� ����� 38 �������', '24-04-1997', 6, 1, 2);


--���������� ������ � ��
INSERT INTO requests (id, publication_time, request_status, comment_receiver, item_sender, item_receiver)
VALUES (requests_id.NEXTVAL, '24-04-1997', 1, '������� ����', 1,  2);
INSERT INTO requests (id, publication_time, request_status, comment_receiver, item_sender, item_receiver)
VALUES (requests_id.NEXTVAL, '24-04-1997', 1, '������� ����', 4,  6);
INSERT INTO requests (id, publication_time, request_status, comment_receiver, item_sender, item_receiver)
VALUES (requests_id.NEXTVAL, '24-04-1997', 1, '������� ����', 3,  5);
INSERT INTO requests (id, publication_time, request_status, comment_receiver, item_sender, item_receiver)
VALUES (requests_id.NEXTVAL, '24-04-1997', 1, '������� ����', 1,  5);
INSERT INTO requests (id, publication_time, request_status, comment_receiver, item_sender, item_receiver)
VALUES (requests_id.NEXTVAL, '24-04-1997', 1, '������� ����', 4,  5);
INSERT INTO requests (id, publication_time, request_status, comment_receiver, item_sender, item_receiver)
VALUES (requests_id.NEXTVAL, '24-04-1997', 1, '������� ����', 2,  3);