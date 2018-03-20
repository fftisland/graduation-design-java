#用户-用户组 映射
CREATE TABLE `user_usergroup_map` (
  `user_id` int(11) NOT NULL,
  `user_group_id` int(11) NOT NULL,
  `create_time` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#用户列表
CREATE TABLE `user_list` (
  `id` int(11) NOT NULL DEFAULT '0',
  `user_name` varchar(128) NOT NULL,
  `email` varchar(128) NOT NULL,
  `role` varchar(128) NOT NULL DEFAULT 'ROLE_NORMAL',
  `count` int(11) NOT NULL DEFAULT '0',
  `last_login_time` timestamp NULL DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#用户组权限列表
CREATE TABLE `user_group_authorities` (
  `user_group_id` int(11) NOT NULL,
  `authority_id` int(11) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#用户组列表
CREATE TABLE `user_group_list` (
  `id` int(11) NOT NULL DEFAULT '0',
  `user_group_name` varchar(128) NOT NULL,
  `user_group_type` varchar(128) NOT NULL,
  `is_build_in` int(11) NOT NULL DEFAULT '0',
  `description` varchar(256) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#权限列表
CREATE TABLE `authority_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `authority` varchar(64) NOT NULL,
  `description` varchar(256) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `authority_UNIQUE` (`authority`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
