INSERT INTO "roles" ("id", "name") VALUES (1, 'CLIENT');
INSERT INTO "roles" ("id", "name") VALUES (2, 'ADMIN');

INSERT INTO "users" ("id", "username", "password", "full_name") VALUES (1, 'client', 'pass', 'CLIENT_USER');
INSERT INTO "users" ("id", "username", "password", "full_name") VALUES (2, 'admin', 'pass', 'ADMIN_USER');
INSERT INTO "users" ("id", "username", "password", "full_name") VALUES (3, 'test', 'pass', 'TEST_USER');

INSERT INTO "users_roles" ("user_id", "role_id") VALUES (1, 1);
INSERT INTO "users_roles" ("user_id", "role_id") VALUES (2, 2);
INSERT INTO "users_roles" ("user_id", "role_id") VALUES (3, 1);

INSERT INTO "cities" ("id", "name") VALUES (1, 'Cluj-Napoca');
INSERT INTO "cities" ("id", "name") VALUES (2, 'Brasov');
INSERT INTO "cities" ("id", "name") VALUES (3, 'Sibiu');
INSERT INTO "cities" ("id", "name") VALUES (4, 'Targu-Mures');
INSERT INTO "cities" ("id", "name") VALUES (5, 'Oradea');
INSERT INTO "cities" ("id", "name") VALUES (6, 'Alba-Iulia');
INSERT INTO "cities" ("id", "name") VALUES (7, 'Baia Mare');

INSERT INTO "deliveries" ("id", "origin_city_id", "destination_city_id", "tracked", "route") VALUES (1, 1, 4, true, '2, 3');
INSERT INTO "deliveries" ("id", "origin_city_id", "destination_city_id", "tracked", "route") VALUES (2, 5, 2, true, '4');

INSERT INTO "packages" ("id", "name", "description", "sender_id", "receiver_id", "delivery_id")
	VALUES (1, 'Televizor', '110cm x 50cm x 25cm, 6kg', 1, 3, 1);
INSERT INTO "packages" ("id", "name", "description", "sender_id", "receiver_id", "delivery_id")
	VALUES (2, 'Bicicleta', 'Mountain-bike, Merida, 2015', 3, 1, 2);