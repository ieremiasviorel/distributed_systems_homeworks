INSERT INTO `flight-management-system`.user (id, username, password) VALUES (1, "client", "$2a$10$fwIXMIudFMZn6zCAODQPEezdwCcGTIcZSmydFpfotBaAqwS5xRo/K");
INSERT INTO `flight-management-system`.user (id, username, password) VALUES (2, "admin", "$2a$10$0j7LleSk5ABXMUgwNsvad.JheENgiiTvaSn0JXS5xRCu1b4cosL6S");

INSERT INTO `flight-management-system`.role (id, name) VALUES (1, "CLIENT");
INSERT INTO `flight-management-system`.role (id, name) VALUES (2, "ADMIN");

INSERT INTO `flight-management-system`.user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO `flight-management-system`.user_role (user_id, role_id) VALUES (2, 2);