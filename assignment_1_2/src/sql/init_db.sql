CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`)
);

CREATE TABLE `city` (
  `id` bigint(20) NOT NULL,
  `country` varchar(255) DEFAULT NULL,
  `latitude` float DEFAULT NULL,
  `longitude` float DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `flight` (
  `id` bigint(20) NOT NULL,
  `airplane_type` varchar(255) DEFAULT NULL,
  `arrival_time` datetime DEFAULT NULL,
  `departure_time` datetime DEFAULT NULL,
  `flight_number` varchar(255) DEFAULT NULL,
  `arrival_city` bigint(20) DEFAULT NULL,
  `departure_city` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdulw71h7vbb8hem870i049n73` (`arrival_city`),
  KEY `FKr1fxubqy33rg2k0k8w4936pqx` (`departure_city`)
);