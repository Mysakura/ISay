/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : isay_user

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-09-21 10:44:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for fans
-- ----------------------------
DROP TABLE IF EXISTS `fans`;
CREATE TABLE `fans` (
  `fans_id` int(11) NOT NULL AUTO_INCREMENT,
  `master_id` char(32) NOT NULL COMMENT '''主人，被关注''',
  `follower_id` char(32) NOT NULL COMMENT '''粉丝''',
  `time` datetime NOT NULL COMMENT '关注时间',
  PRIMARY KEY (`fans_id`),
  KEY `fk_f_m` (`master_id`),
  KEY `fk_f_f` (`follower_id`),
  CONSTRAINT `fk_f_f` FOREIGN KEY (`follower_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_f_m` FOREIGN KEY (`master_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='中间表-粉丝表';

-- ----------------------------
-- Records of fans
-- ----------------------------
INSERT INTO `fans` VALUES ('1', '15248859107335YA2M37', '1524882743767ZSN4LPZ', '2018-05-03 14:33:37');
INSERT INTO `fans` VALUES ('2', '1524882743767ZSN4LPZ', '15248859107335YA2M37', '2018-05-03 14:33:49');
INSERT INTO `fans` VALUES ('4', '1524885559971ICDBCEZ', '15248859107335YA2M37', '2018-05-13 10:17:09');
INSERT INTO `fans` VALUES ('5', '15248859107335YA2M37', '1526179403208IWBRWA6', '2018-05-13 10:52:12');
INSERT INTO `fans` VALUES ('6', '1526179403208IWBRWA6', '15248859107335YA2M37', '2018-06-02 13:22:03');

-- ----------------------------
-- Table structure for personal_letter
-- ----------------------------
DROP TABLE IF EXISTS `personal_letter`;
CREATE TABLE `personal_letter` (
  `letter_id` char(20) NOT NULL,
  `person_a_id` char(32) NOT NULL,
  `person_b_id` char(32) NOT NULL,
  `last_time` datetime NOT NULL,
  PRIMARY KEY (`letter_id`),
  KEY `fk_pl_a` (`person_a_id`),
  KEY `fk_pl_b` (`person_b_id`),
  CONSTRAINT `fk_pl_a` FOREIGN KEY (`person_a_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_pl_b` FOREIGN KEY (`person_b_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='私信表-一个人可以私信多个人，多个人也可以私信同一个人';

-- ----------------------------
-- Records of personal_letter
-- ----------------------------
INSERT INTO `personal_letter` VALUES ('1526178761436W162MF7', '15248859107335YA2M37', '1524885559971ICDBCEZ', '2018-05-13 10:36:32');
INSERT INTO `personal_letter` VALUES ('1526179960110YW4S5PM', '1526179403208IWBRWA6', '15248859107335YA2M37', '2018-06-02 16:35:05');

-- ----------------------------
-- Table structure for personal_letter_content
-- ----------------------------
DROP TABLE IF EXISTS `personal_letter_content`;
CREATE TABLE `personal_letter_content` (
  `lc_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '‘每一条私信消息，id自增’',
  `letter_id` char(20) NOT NULL,
  `sender_id` char(32) NOT NULL,
  `receiver_id` char(32) NOT NULL,
  `letter_content` varchar(255) NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`lc_id`),
  KEY `fk_lc_l` (`letter_id`),
  KEY `fk_lc_s` (`sender_id`),
  KEY `fl_lc_r` (`receiver_id`),
  CONSTRAINT `fk_lc_l` FOREIGN KEY (`letter_id`) REFERENCES `personal_letter` (`letter_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_lc_s` FOREIGN KEY (`sender_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fl_lc_r` FOREIGN KEY (`receiver_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='具体私信信息表';

-- ----------------------------
-- Records of personal_letter_content
-- ----------------------------
INSERT INTO `personal_letter_content` VALUES ('1', '1526178761436W162MF7', '15248859107335YA2M37', '1524885559971ICDBCEZ', 'Hello！你好！！', '2018-05-13 10:32:41');
INSERT INTO `personal_letter_content` VALUES ('2', '1526178761436W162MF7', '15248859107335YA2M37', '1524885559971ICDBCEZ', 'Hello！收到我的消息了吗？', '2018-05-13 10:36:32');
INSERT INTO `personal_letter_content` VALUES ('3', '1526179960110YW4S5PM', '1526179403208IWBRWA6', '15248859107335YA2M37', '我有好多问题要问你！', '2018-05-13 10:52:40');
INSERT INTO `personal_letter_content` VALUES ('4', '1526179960110YW4S5PM', '15248859107335YA2M37', '1526179403208IWBRWA6', '我会尽快解决共享session多次存取redis的问题', '2018-05-13 17:34:07');
INSERT INTO `personal_letter_content` VALUES ('5', '1526179960110YW4S5PM', '15248859107335YA2M37', '1526179403208IWBRWA6', '我把最近的工作忙完', '2018-05-13 17:34:53');
INSERT INTO `personal_letter_content` VALUES ('6', '1526179960110YW4S5PM', '1526179403208IWBRWA6', '15248859107335YA2M37', '好的，我等你的消息', '2018-05-13 18:23:48');
INSERT INTO `personal_letter_content` VALUES ('7', '1526179960110YW4S5PM', '15248859107335YA2M37', '1526179403208IWBRWA6', '我很快就要忙完了', '2018-05-18 14:12:16');
INSERT INTO `personal_letter_content` VALUES ('8', '1526179960110YW4S5PM', '15248859107335YA2M37', '1526179403208IWBRWA6', 'Hello！！你在干啥呢？论文写完了没', '2018-05-29 15:22:12');
INSERT INTO `personal_letter_content` VALUES ('9', '1526179960110YW4S5PM', '1526179403208IWBRWA6', '15248859107335YA2M37', '写完啦写完啦，重复率18.3%', '2018-06-02 16:35:05');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` char(20) NOT NULL,
  `role_name` varchar(25) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表：用户，管理员（查看，删除）';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'user');
INSERT INTO `role` VALUES ('2', 'admin');
INSERT INTO `role` VALUES ('3', 'AdminAll');
INSERT INTO `role` VALUES ('4', 'AdminUpdate');

-- ----------------------------
-- Table structure for system_message
-- ----------------------------
DROP TABLE IF EXISTS `system_message`;
CREATE TABLE `system_message` (
  `msg_id` char(20) NOT NULL,
  `user_id` char(32) NOT NULL,
  `msg_content` varchar(1024) NOT NULL,
  `msg_time` datetime NOT NULL,
  PRIMARY KEY (`msg_id`),
  KEY `fk_msg_u` (`user_id`),
  CONSTRAINT `fk_msg_u` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统消息';

-- ----------------------------
-- Records of system_message
-- ----------------------------
INSERT INTO `system_message` VALUES ('1527578531650U5GK4ZJ', '1526179403208IWBRWA6', '<a class=\'sys-user\' href=\'/isay-web/user/15248859107335YA2M37\'>Mary</a>私信了你<span class=\'sys-content\'>Hello！！你在干啥呢？论文写完了没</span><span class=\'sys-time\'>2018-05-29 15:22:11</span>', '2018-05-29 15:22:12');
INSERT INTO `system_message` VALUES ('1527578674026Z9MP4WT', '1526179403208IWBRWA6', '<a class=\'sys-user\' href=\'/isay-web/user/15248859107335YA2M37\'>Mary</a>评论了你的帖子<a class=\'sys-post\' href=\'/isay-web/card/post_details/1527429937894Q2WZNPE\'>《区块链将如何重新定义世界-董昕杰》</a><span class=\'sys-time\'>2018-05-29 15:24:34</span>', '2018-05-29 15:24:34');
INSERT INTO `system_message` VALUES ('1527578766893DK1RHHL', '15248859107335YA2M37', '<a class=\'sys-user\' href=\'/isay-web/user/15248859107335YA2M37\'>Mary</a>在帖子<a class=\'sys-post\' href=\'/isay-web/card/post_details/15219428645587F69LA7\'>《秋风落叶 - 姜玉阳》</a>中回复了你<span class=\'sys-time\'>2018-05-29 15:26:06</span>', '2018-05-29 15:26:07');
INSERT INTO `system_message` VALUES ('15275798225451CWMEXI', '15248859107335YA2M37', '<a class=\'sys-user\' href=\'/isay-web/user/15248859107335YA2M37\'>Mary</a>评论了你的帖子<a class=\'sys-post\' href=\'/isay-web/card/post_details/15252536191316ZJXASD\'>《postTitle-12》</a><span class=\'sys-time\'>2018-05-29 15:43:42</span>', '2018-05-29 15:43:43');
INSERT INTO `system_message` VALUES ('1527928399690HJMKG51', '15248859107335YA2M37', '<a class=\'sys-user\' href=\'/isay-web/user/1526179403208IWBRWA6\'>世界上最快的男人</a>评论了你的帖子<a class=\'sys-post\' href=\'/isay-web/card/post_details/1527916595358VXADVSK\'>《原画师要具备哪些特点？原画师要掌握那些知识？》</a><span class=\'sys-time\'>2018-06-02 16:33:19</span>', '2018-06-02 16:33:20');
INSERT INTO `system_message` VALUES ('1527928505443U9R4KXT', '15248859107335YA2M37', '<a class=\'sys-user\' href=\'/isay-web/user/1526179403208IWBRWA6\'>世界上最快的男人</a>私信了你<span class=\'sys-content\'>写完啦写完啦，重复率18.3%</span><span class=\'sys-time\'>2018-06-02 16:35:05</span>', '2018-06-02 16:35:05');
INSERT INTO `system_message` VALUES ('1528256417452FPQF113', '1526179403208IWBRWA6', '<a class=\'sys-user\' href=\'/isay-web/user/15248859107335YA2M37\'>Mary</a>评论了你的帖子<a class=\'sys-post\' href=\'/isay-web/card/post_details/1528255993638XBM8D6Y\'>《手绘--叶子，叶子》</a><span class=\'sys-time\'>2018-06-06 11:40:17</span>', '2018-06-06 11:40:17');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` char(32) NOT NULL,
  `user_email` varchar(25) NOT NULL,
  `password` varchar(32) NOT NULL,
  `user_name` varchar(25) NOT NULL,
  `user_sex` enum('保密','男','女') NOT NULL DEFAULT '保密',
  `user_photo` varchar(255) NOT NULL DEFAULT 'user_photo/default.jpg',
  `user_bg` varchar(255) NOT NULL DEFAULT 'css/icon/default-userbg.jpg',
  `user_alipay` varchar(255) NOT NULL DEFAULT '',
  `user_vxin` varchar(255) NOT NULL DEFAULT '',
  `user_graduate` varchar(25) NOT NULL DEFAULT '学校保密',
  `user_job` varchar(25) NOT NULL DEFAULT '职业保密',
  `user_company` varchar(25) NOT NULL DEFAULT '公司保密',
  `work_place` varchar(25) NOT NULL DEFAULT '城市保密',
  `user_shield` enum('0','1') NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1524882743767ZSN4LPZ', '12345678@qq.com', 'icui4cu', 'TomAndJerry', '保密', 'user_photo/default.jpg', 'css/icon/default-userbg.jpg', '', '', '牛B学校', '牛B职业', '牛B公司', '牛B城市', '0');
INSERT INTO `user` VALUES ('1524885559971ICDBCEZ', '3110320052@qq.com', '08c338d3da018a238251a662e9f122a2', '闹着玩的', '保密', 'user_photo/default.jpg', 'css/icon/default-userbg.jpg', '', '', '牛B学校', '牛B职业', '牛B公司', '牛B城市', '1');
INSERT INTO `user` VALUES ('15248859107335YA2M37', '3110320051@qq.com', '08c338d3da018a238251a662e9f122a2', 'Mary', '女', 'user_photo/1525937566187.jpg', 'user_photo/1525839432538.jpg', 'pay_photo/alipay.jpg', 'pay_photo/vxin.png', '河北工程大学', '研发工程师', '丰巢科技', '深圳', '0');
INSERT INTO `user` VALUES ('1526179403208IWBRWA6', '123456@qq.com', '84947c33b70073b371572e75e92f786b', '世界上最快的男人', '男', 'user_photo/1526179814672.jpg', 'user_photo/1526179572957.jpg', 'pay_photo/1526179489733.jpg', 'pay_photo/1526179753393.png', '哈佛大学', 'java开发', '谷歌', '纽约', '0');
INSERT INTO `user` VALUES ('15272637788528PJXTJT', '850070324@qq.com', 'db0bcaeafb01d649f02d07ea79a56464', '一只小毛驴', '保密', 'user_photo/default.jpg', 'css/icon/default-userbg.jpg', '', '', '牛B学校', '牛B职业', '牛B公司', '牛B城市', '0');
INSERT INTO `user` VALUES ('1528510462012IAZGJMA', '2364730958@qq.com', 'cb2959b7309989003fc7572e14f8b8e0', '杨大屌', '保密', 'user_photo/default.jpg', 'css/icon/default-userbg.jpg', '', '', '牛B学校', '牛B职业', '牛B公司', '牛B城市', '1');

-- ----------------------------
-- Table structure for user_collection
-- ----------------------------
DROP TABLE IF EXISTS `user_collection`;
CREATE TABLE `user_collection` (
  `collection_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '''用户收藏的文章，自动递增''',
  `user_id` char(32) NOT NULL,
  `post_id` char(32) NOT NULL COMMENT '''数据独立，不能外键''',
  PRIMARY KEY (`collection_id`),
  KEY `fk_c_u` (`user_id`),
  CONSTRAINT `fk_c_u` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='中间表-用户收藏-一个用户收藏多个文章，一个文章可以被多个用户收藏';

-- ----------------------------
-- Records of user_collection
-- ----------------------------
INSERT INTO `user_collection` VALUES ('1', '15248859107335YA2M37', '15219428645587F69LA7');
INSERT INTO `user_collection` VALUES ('4', '15248859107335YA2M37', '15263640778098G1THID');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` char(32) NOT NULL,
  `role_id` char(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ur_u` (`user_id`),
  KEY `fk_ur_r` (`role_id`),
  CONSTRAINT `fk_ur_r` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_ur_u` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='中间表-用户对应的角色';

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1524882743767ZSN4LPZ', '1');
INSERT INTO `user_role` VALUES ('2', '1524885559971ICDBCEZ', '1');
INSERT INTO `user_role` VALUES ('3', '15248859107335YA2M37', '1');
INSERT INTO `user_role` VALUES ('4', '1526179403208IWBRWA6', '1');
INSERT INTO `user_role` VALUES ('5', '1526179403208IWBRWA6', '2');
INSERT INTO `user_role` VALUES ('6', '15272637788528PJXTJT', '1');
INSERT INTO `user_role` VALUES ('7', '1524885559971ICDBCEZ', '2');
INSERT INTO `user_role` VALUES ('8', '1524882743767ZSN4LPZ', '2');
INSERT INTO `user_role` VALUES ('9', '1528510462012IAZGJMA', '1');
DROP TRIGGER IF EXISTS `plc_trigger`;
DELIMITER ;;
CREATE TRIGGER `plc_trigger` AFTER INSERT ON `personal_letter_content` FOR EACH ROW begin

declare t datetime;

set t = (select time from personal_letter_content where lc_id = new.lc_id);

update personal_letter set last_time = t where letter_id = new.letter_id;

end
;;
DELIMITER ;
