CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `mobileno` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `salt` varchar(255) NOT NULL,
  `sex` smallint(6) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_mobile` (`mobileno`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;