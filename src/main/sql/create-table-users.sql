CREATE TABLE `users` (
                         `u_id` int NOT NULL AUTO_INCREMENT,
                         `first_name` varchar(45) DEFAULT NULL,
                         `last_name` varchar(45) DEFAULT NULL,
                         `username` varchar(45) DEFAULT NULL,
                         `password` varchar(45) DEFAULT NULL,
                         `email` varchar(45) DEFAULT NULL,
                         `date_of_birth` date DEFAULT NULL,
                         PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
