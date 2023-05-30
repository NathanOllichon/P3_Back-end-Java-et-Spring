-- CREATE TABLE `USERS` (
--   `id` integer PRIMARY KEY AUTO_INCREMENT,
--   `email` varchar(255),
--   `name` varchar(255),
--   `password` varchar(255),
--   `created_at` timestamp,
--   `updated_at` timestamp
-- );

-- CREATE TABLE `RENTALS` (
--   `id` integer PRIMARY KEY AUTO_INCREMENT,
--   `name` varchar(255),
--   `surface` numeric,
--   `price` numeric,
--   `picture` varchar(255),
--   `description` varchar(2000),
--   `owner_id` integer NOT NULL,
--   `created_at` timestamp,
--   `updated_at` timestamp
-- );

-- CREATE TABLE `MESSAGES` (
--   `id` integer PRIMARY KEY AUTO_INCREMENT,
--   `rental_id` integer,
--   `user_id` integer,
--   `message` varchar(2000),
--   `created_at` timestamp,
--   `updated_at` timestamp
-- );

-- CREATE UNIQUE INDEX `USERS_index` ON `USERS` (`email`);
-- CREATE INDEX `fk_owner_id_Trentals_index` ON `RENTALS` (`owner_id`);
-- CREATE INDEX `fk_user_id_Tmessages_index` ON `MESSAGES` (`user_id`);
-- CREATE INDEX `fk_rental_id_Tmessages_index` ON `MESSAGES` (`rental_id`);

-- ALTER TABLE `USERS` ADD FOREIGN KEY (`id`) REFERENCES `RENTALS` (`owner_id`);

-- ALTER TABLE `USERS` ADD FOREIGN KEY (`id`) REFERENCES `MESSAGES` (`user_id`);

-- ALTER TABLE `RENTALS` ADD FOREIGN KEY (`id`) REFERENCES `MESSAGES` (`rental_id`);

-- ALTER TABLE `USERS` DROP  FOREIGN KEY 'users_ibfk_1';
-- ALTER TABLE `USERS` DROP  FOREIGN KEY 'users_ibfk_2';
-- ALTER TABLE `USERS` DROP  FOREIGN KEY 'users_ibfk_3';
-- ALTER TABLE `USERS` DROP  FOREIGN KEY 'users_ibfk_4';
-- ALTER TABLE `RENTALS` DROP  FOREIGN KEY 'rentals_ibfk_1';
-- ALTER TABLE `RENTALS` DROP  FOREIGN KEY 'rentals_ibfk_2';
