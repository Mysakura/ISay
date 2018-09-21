/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : isay_post

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-09-21 10:44:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for area_label
-- ----------------------------
DROP TABLE IF EXISTS `area_label`;
CREATE TABLE `area_label` (
  `al_id` int(11) NOT NULL AUTO_INCREMENT,
  `al_name` varchar(25) NOT NULL,
  `area_id` int(11) NOT NULL,
  PRIMARY KEY (`al_id`),
  KEY `fk_al_a` (`area_id`),
  CONSTRAINT `fk_al_a` FOREIGN KEY (`area_id`) REFERENCES `work_area` (`area_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=274 DEFAULT CHARSET=utf8 COMMENT='帖子领域对应的标签';

-- ----------------------------
-- Records of area_label
-- ----------------------------
INSERT INTO `area_label` VALUES ('1', 'Java', '1');
INSERT INTO `area_label` VALUES ('2', 'C++', '1');
INSERT INTO `area_label` VALUES ('3', 'PHP', '1');
INSERT INTO `area_label` VALUES ('4', '数据挖掘', '1');
INSERT INTO `area_label` VALUES ('5', '搜索算法', '1');
INSERT INTO `area_label` VALUES ('6', '精准推荐', '1');
INSERT INTO `area_label` VALUES ('7', 'C', '1');
INSERT INTO `area_label` VALUES ('8', 'C#', '1');
INSERT INTO `area_label` VALUES ('9', '全栈工程师', '1');
INSERT INTO `area_label` VALUES ('10', '.NET', '1');
INSERT INTO `area_label` VALUES ('11', 'Hadoop', '1');
INSERT INTO `area_label` VALUES ('12', 'Python', '1');
INSERT INTO `area_label` VALUES ('13', 'Delphi', '1');
INSERT INTO `area_label` VALUES ('14', 'VB', '1');
INSERT INTO `area_label` VALUES ('15', 'Perl', '1');
INSERT INTO `area_label` VALUES ('16', 'Ruby', '1');
INSERT INTO `area_label` VALUES ('17', 'Node.js', '1');
INSERT INTO `area_label` VALUES ('18', 'Go', '1');
INSERT INTO `area_label` VALUES ('19', 'ASP', '1');
INSERT INTO `area_label` VALUES ('20', 'Shell', '1');
INSERT INTO `area_label` VALUES ('21', '后端开发其它', '1');
INSERT INTO `area_label` VALUES ('22', 'web前端', '1');
INSERT INTO `area_label` VALUES ('23', 'Flash', '1');
INSERT INTO `area_label` VALUES ('24', 'html5', '1');
INSERT INTO `area_label` VALUES ('25', 'JavaScript', '1');
INSERT INTO `area_label` VALUES ('26', 'U3D', '1');
INSERT INTO `area_label` VALUES ('27', 'COCOS2D-X', '1');
INSERT INTO `area_label` VALUES ('28', '前端开发其它', '1');
INSERT INTO `area_label` VALUES ('29', 'HTML5', '1');
INSERT INTO `area_label` VALUES ('30', 'Android', '1');
INSERT INTO `area_label` VALUES ('31', 'iOS', '1');
INSERT INTO `area_label` VALUES ('32', 'WP', '1');
INSERT INTO `area_label` VALUES ('33', '移动开发其它', '1');
INSERT INTO `area_label` VALUES ('34', '人工智能', '1');
INSERT INTO `area_label` VALUES ('35', '深度学习', '1');
INSERT INTO `area_label` VALUES ('36', '机器学习', '1');
INSERT INTO `area_label` VALUES ('37', '图像处理', '1');
INSERT INTO `area_label` VALUES ('38', '图像识别', '1');
INSERT INTO `area_label` VALUES ('39', '语音识别', '1');
INSERT INTO `area_label` VALUES ('40', '机器视觉', '1');
INSERT INTO `area_label` VALUES ('41', '算法工程师', '1');
INSERT INTO `area_label` VALUES ('42', '自然语言处理', '1');
INSERT INTO `area_label` VALUES ('43', '测试工程师', '1');
INSERT INTO `area_label` VALUES ('44', '自动化测试', '1');
INSERT INTO `area_label` VALUES ('45', '功能测试', '1');
INSERT INTO `area_label` VALUES ('46', '性能测试', '1');
INSERT INTO `area_label` VALUES ('47', '测试开发', '1');
INSERT INTO `area_label` VALUES ('48', '游戏测试', '1');
INSERT INTO `area_label` VALUES ('49', '白盒测试', '1');
INSERT INTO `area_label` VALUES ('50', '灰盒测试', '1');
INSERT INTO `area_label` VALUES ('51', '黑盒测试', '1');
INSERT INTO `area_label` VALUES ('52', '手机测试', '1');
INSERT INTO `area_label` VALUES ('53', '硬件测试', '1');
INSERT INTO `area_label` VALUES ('54', '测试经理', '1');
INSERT INTO `area_label` VALUES ('55', '测试其它', '1');
INSERT INTO `area_label` VALUES ('56', '运维工程师', '1');
INSERT INTO `area_label` VALUES ('57', '运维开发工程师', '1');
INSERT INTO `area_label` VALUES ('58', '网络工程师', '1');
INSERT INTO `area_label` VALUES ('59', '系统工程师', '1');
INSERT INTO `area_label` VALUES ('60', 'IT支持', '1');
INSERT INTO `area_label` VALUES ('61', 'IDC', '1');
INSERT INTO `area_label` VALUES ('62', 'CDN', '1');
INSERT INTO `area_label` VALUES ('63', 'F5', '1');
INSERT INTO `area_label` VALUES ('64', '系统管理员', '1');
INSERT INTO `area_label` VALUES ('65', '病毒分析', '1');
INSERT INTO `area_label` VALUES ('66', 'WEB安全', '1');
INSERT INTO `area_label` VALUES ('67', '网络安全', '1');
INSERT INTO `area_label` VALUES ('68', '系统安全', '1');
INSERT INTO `area_label` VALUES ('69', '运维经理', '1');
INSERT INTO `area_label` VALUES ('70', '运维其它', '1');
INSERT INTO `area_label` VALUES ('71', 'MySQL', '1');
INSERT INTO `area_label` VALUES ('72', 'SQLServer', '1');
INSERT INTO `area_label` VALUES ('73', 'Oracle', '1');
INSERT INTO `area_label` VALUES ('74', 'DB2', '1');
INSERT INTO `area_label` VALUES ('75', 'MongoDB', '1');
INSERT INTO `area_label` VALUES ('76', 'ETL', '1');
INSERT INTO `area_label` VALUES ('77', 'Hive', '1');
INSERT INTO `area_label` VALUES ('78', '数据仓库', '1');
INSERT INTO `area_label` VALUES ('79', 'DBA其它', '1');
INSERT INTO `area_label` VALUES ('80', '技术经理', '1');
INSERT INTO `area_label` VALUES ('81', '技术总监', '1');
INSERT INTO `area_label` VALUES ('82', '架构师', '1');
INSERT INTO `area_label` VALUES ('83', 'CTO', '1');
INSERT INTO `area_label` VALUES ('84', '运维总监', '1');
INSERT INTO `area_label` VALUES ('85', '技术合伙人', '1');
INSERT INTO `area_label` VALUES ('86', '项目总监', '1');
INSERT INTO `area_label` VALUES ('87', '测试总监', '1');
INSERT INTO `area_label` VALUES ('88', '安全专家', '1');
INSERT INTO `area_label` VALUES ('89', '项目经理', '1');
INSERT INTO `area_label` VALUES ('90', '项目助理', '1');
INSERT INTO `area_label` VALUES ('91', '硬件', '1');
INSERT INTO `area_label` VALUES ('92', '嵌入式', '1');
INSERT INTO `area_label` VALUES ('93', '自动化', '1');
INSERT INTO `area_label` VALUES ('94', '单片机', '1');
INSERT INTO `area_label` VALUES ('95', '电路设计', '1');
INSERT INTO `area_label` VALUES ('96', '驱动开发', '1');
INSERT INTO `area_label` VALUES ('97', '系统集成', '1');
INSERT INTO `area_label` VALUES ('98', 'FPGA开发', '1');
INSERT INTO `area_label` VALUES ('99', 'DSP开发', '1');
INSERT INTO `area_label` VALUES ('100', 'ARM开发', '1');
INSERT INTO `area_label` VALUES ('101', 'PCB工艺', '1');
INSERT INTO `area_label` VALUES ('102', '模具设计', '1');
INSERT INTO `area_label` VALUES ('103', '热传导', '1');
INSERT INTO `area_label` VALUES ('104', '材料工程师', '1');
INSERT INTO `area_label` VALUES ('105', '精益工程师', '1');
INSERT INTO `area_label` VALUES ('106', '射频工程师', '1');
INSERT INTO `area_label` VALUES ('107', '实施工程师', '1');
INSERT INTO `area_label` VALUES ('108', '售前工程师', '1');
INSERT INTO `area_label` VALUES ('109', '售后工程师', '1');
INSERT INTO `area_label` VALUES ('110', 'BI工程师', '1');
INSERT INTO `area_label` VALUES ('111', '产品经理', '2');
INSERT INTO `area_label` VALUES ('112', '网页产品经理', '2');
INSERT INTO `area_label` VALUES ('113', '移动产品经理', '2');
INSERT INTO `area_label` VALUES ('114', '产品助理', '2');
INSERT INTO `area_label` VALUES ('115', '数据产品经理', '2');
INSERT INTO `area_label` VALUES ('116', '电商产品经理', '2');
INSERT INTO `area_label` VALUES ('117', '游戏策划', '2');
INSERT INTO `area_label` VALUES ('118', '产品实习生', '2');
INSERT INTO `area_label` VALUES ('119', '网页产品设计师', '2');
INSERT INTO `area_label` VALUES ('120', '无线产品设计师', '2');
INSERT INTO `area_label` VALUES ('121', '产品部经理', '2');
INSERT INTO `area_label` VALUES ('122', '产品总监', '2');
INSERT INTO `area_label` VALUES ('123', '游戏制作人', '2');
INSERT INTO `area_label` VALUES ('124', '视觉设计师', '3');
INSERT INTO `area_label` VALUES ('125', '网页设计师', '3');
INSERT INTO `area_label` VALUES ('126', 'Flash设计师', '3');
INSERT INTO `area_label` VALUES ('127', 'APP设计师', '3');
INSERT INTO `area_label` VALUES ('128', 'UI设计师', '3');
INSERT INTO `area_label` VALUES ('129', '平面设计师', '3');
INSERT INTO `area_label` VALUES ('130', '美术设计师（2D/3D）', '3');
INSERT INTO `area_label` VALUES ('131', '广告设计师', '3');
INSERT INTO `area_label` VALUES ('132', '多媒体设计师', '3');
INSERT INTO `area_label` VALUES ('133', '原画师', '3');
INSERT INTO `area_label` VALUES ('134', '游戏特效', '3');
INSERT INTO `area_label` VALUES ('135', '游戏界面设计师', '3');
INSERT INTO `area_label` VALUES ('136', '游戏场景', '3');
INSERT INTO `area_label` VALUES ('137', '游戏角色', '3');
INSERT INTO `area_label` VALUES ('138', '游戏动作', '3');
INSERT INTO `area_label` VALUES ('139', '交互设计师', '3');
INSERT INTO `area_label` VALUES ('140', '无线交互设计师', '3');
INSERT INTO `area_label` VALUES ('141', '网页交互设计师', '3');
INSERT INTO `area_label` VALUES ('142', '硬件交互设计师', '3');
INSERT INTO `area_label` VALUES ('143', '数据分析师', '3');
INSERT INTO `area_label` VALUES ('144', '用户研究员', '3');
INSERT INTO `area_label` VALUES ('145', '游戏数值策划', '3');
INSERT INTO `area_label` VALUES ('146', '设计经理/主管', '3');
INSERT INTO `area_label` VALUES ('147', '设计总监', '3');
INSERT INTO `area_label` VALUES ('148', '视觉设计经理/主管', '3');
INSERT INTO `area_label` VALUES ('149', '视觉设计总监', '3');
INSERT INTO `area_label` VALUES ('150', '交互设计经理/主管', '3');
INSERT INTO `area_label` VALUES ('151', '交互设计总监', '3');
INSERT INTO `area_label` VALUES ('152', '用户研究经理/主管', '3');
INSERT INTO `area_label` VALUES ('153', '用户研究总监', '3');
INSERT INTO `area_label` VALUES ('154', '用户运营', '4');
INSERT INTO `area_label` VALUES ('155', '产品运营', '4');
INSERT INTO `area_label` VALUES ('156', '数据运营', '4');
INSERT INTO `area_label` VALUES ('157', '内容运营', '4');
INSERT INTO `area_label` VALUES ('158', '活动运营', '4');
INSERT INTO `area_label` VALUES ('159', '商家运营', '4');
INSERT INTO `area_label` VALUES ('160', '品类运营', '4');
INSERT INTO `area_label` VALUES ('161', '游戏运营', '4');
INSERT INTO `area_label` VALUES ('162', '网络推广', '4');
INSERT INTO `area_label` VALUES ('163', '运营专员', '4');
INSERT INTO `area_label` VALUES ('164', '网店运营', '4');
INSERT INTO `area_label` VALUES ('165', '新媒体运营', '4');
INSERT INTO `area_label` VALUES ('166', '海外运营', '4');
INSERT INTO `area_label` VALUES ('167', '运营经理', '4');
INSERT INTO `area_label` VALUES ('168', '副主编', '4');
INSERT INTO `area_label` VALUES ('169', '内容编辑', '4');
INSERT INTO `area_label` VALUES ('170', '文案策划', '4');
INSERT INTO `area_label` VALUES ('171', '记者', '4');
INSERT INTO `area_label` VALUES ('172', '售前咨询', '4');
INSERT INTO `area_label` VALUES ('173', '售后客服', '4');
INSERT INTO `area_label` VALUES ('174', '淘宝客服', '4');
INSERT INTO `area_label` VALUES ('175', '客服经理', '4');
INSERT INTO `area_label` VALUES ('176', '主编', '4');
INSERT INTO `area_label` VALUES ('177', '运营总监', '4');
INSERT INTO `area_label` VALUES ('178', 'COO', '4');
INSERT INTO `area_label` VALUES ('179', '客服总监', '4');
INSERT INTO `area_label` VALUES ('180', '市场营销', '5');
INSERT INTO `area_label` VALUES ('181', '市场策划', '5');
INSERT INTO `area_label` VALUES ('182', '市场顾问', '5');
INSERT INTO `area_label` VALUES ('183', '市场推广', '5');
INSERT INTO `area_label` VALUES ('184', 'SEO', '5');
INSERT INTO `area_label` VALUES ('185', 'SEM', '5');
INSERT INTO `area_label` VALUES ('186', '商务渠道', '5');
INSERT INTO `area_label` VALUES ('187', '商业数据分析', '5');
INSERT INTO `area_label` VALUES ('188', '活动策划', '5');
INSERT INTO `area_label` VALUES ('189', '网络营销', '5');
INSERT INTO `area_label` VALUES ('190', '海外市场', '5');
INSERT INTO `area_label` VALUES ('191', '政府关系', '5');
INSERT INTO `area_label` VALUES ('192', '媒介经理', '5');
INSERT INTO `area_label` VALUES ('193', '广告协调', '5');
INSERT INTO `area_label` VALUES ('194', '品牌公关', '5');
INSERT INTO `area_label` VALUES ('195', '销售专员', '5');
INSERT INTO `area_label` VALUES ('196', '销售经理', '5');
INSERT INTO `area_label` VALUES ('197', '客户代表', '5');
INSERT INTO `area_label` VALUES ('198', '大客户代表', '5');
INSERT INTO `area_label` VALUES ('199', 'BD经理', '5');
INSERT INTO `area_label` VALUES ('200', '商务渠道', '5');
INSERT INTO `area_label` VALUES ('201', '渠道销售', '5');
INSERT INTO `area_label` VALUES ('202', '代理商销售', '5');
INSERT INTO `area_label` VALUES ('203', '销售助理', '5');
INSERT INTO `area_label` VALUES ('204', '电话销售', '5');
INSERT INTO `area_label` VALUES ('205', '销售顾问', '5');
INSERT INTO `area_label` VALUES ('206', '商品经理', '5');
INSERT INTO `area_label` VALUES ('207', '物流', '5');
INSERT INTO `area_label` VALUES ('208', '仓储', '5');
INSERT INTO `area_label` VALUES ('209', '采购专员', '5');
INSERT INTO `area_label` VALUES ('210', '采购经理', '5');
INSERT INTO `area_label` VALUES ('211', '商品经理', '5');
INSERT INTO `area_label` VALUES ('212', '分析师', '5');
INSERT INTO `area_label` VALUES ('213', '投资顾问', '5');
INSERT INTO `area_label` VALUES ('214', '投资经理', '5');
INSERT INTO `area_label` VALUES ('215', '市场总监', '5');
INSERT INTO `area_label` VALUES ('216', '销售总监', '5');
INSERT INTO `area_label` VALUES ('217', '商务总监', '5');
INSERT INTO `area_label` VALUES ('218', 'CMO', '5');
INSERT INTO `area_label` VALUES ('219', '公关总监', '5');
INSERT INTO `area_label` VALUES ('220', '采购总监', '5');
INSERT INTO `area_label` VALUES ('221', '投资总监', '5');
INSERT INTO `area_label` VALUES ('222', '人力资源', '6');
INSERT INTO `area_label` VALUES ('223', '招聘', '6');
INSERT INTO `area_label` VALUES ('224', 'HRBP', '6');
INSERT INTO `area_label` VALUES ('225', '人事/HR', '6');
INSERT INTO `area_label` VALUES ('226', '培训经理', '6');
INSERT INTO `area_label` VALUES ('227', '薪资福利经理', '6');
INSERT INTO `area_label` VALUES ('228', '绩效考核经理', '6');
INSERT INTO `area_label` VALUES ('229', '员工关系', '6');
INSERT INTO `area_label` VALUES ('230', '助理', '6');
INSERT INTO `area_label` VALUES ('231', '前台', '6');
INSERT INTO `area_label` VALUES ('232', '行政', '6');
INSERT INTO `area_label` VALUES ('233', '总助', '6');
INSERT INTO `area_label` VALUES ('234', '文秘', '6');
INSERT INTO `area_label` VALUES ('235', '会计', '6');
INSERT INTO `area_label` VALUES ('236', '出纳', '6');
INSERT INTO `area_label` VALUES ('237', '财务', '6');
INSERT INTO `area_label` VALUES ('238', '结算', '6');
INSERT INTO `area_label` VALUES ('239', '税务', '6');
INSERT INTO `area_label` VALUES ('240', '审计', '6');
INSERT INTO `area_label` VALUES ('241', '风控', '6');
INSERT INTO `area_label` VALUES ('242', '法务', '6');
INSERT INTO `area_label` VALUES ('243', '律师', '6');
INSERT INTO `area_label` VALUES ('244', '专利', '6');
INSERT INTO `area_label` VALUES ('245', '行政总监/经理', '6');
INSERT INTO `area_label` VALUES ('246', '财务总监/经理', '6');
INSERT INTO `area_label` VALUES ('247', 'HRD/HRM', '6');
INSERT INTO `area_label` VALUES ('248', 'CFO', '6');
INSERT INTO `area_label` VALUES ('249', 'CEO', '6');
INSERT INTO `area_label` VALUES ('250', '投资经理', '7');
INSERT INTO `area_label` VALUES ('251', '分析师', '7');
INSERT INTO `area_label` VALUES ('252', '投资助理', '7');
INSERT INTO `area_label` VALUES ('253', '融资', '7');
INSERT INTO `area_label` VALUES ('254', '并购', '7');
INSERT INTO `area_label` VALUES ('255', '行业研究', '7');
INSERT INTO `area_label` VALUES ('256', '投资者关系', '7');
INSERT INTO `area_label` VALUES ('257', '资产管理', '7');
INSERT INTO `area_label` VALUES ('258', '理财顾问', '7');
INSERT INTO `area_label` VALUES ('259', '交易员', '7');
INSERT INTO `area_label` VALUES ('260', '风控', '7');
INSERT INTO `area_label` VALUES ('261', '资信评估', '7');
INSERT INTO `area_label` VALUES ('262', '合规稽查', '7');
INSERT INTO `area_label` VALUES ('263', '律师', '7');
INSERT INTO `area_label` VALUES ('264', '审计', '7');
INSERT INTO `area_label` VALUES ('265', '法务', '7');
INSERT INTO `area_label` VALUES ('266', '会计', '7');
INSERT INTO `area_label` VALUES ('267', '清算', '7');
INSERT INTO `area_label` VALUES ('268', '投资总监', '7');
INSERT INTO `area_label` VALUES ('269', '融资总监', '7');
INSERT INTO `area_label` VALUES ('270', '并购总监', '7');
INSERT INTO `area_label` VALUES ('271', '风控总监', '7');
INSERT INTO `area_label` VALUES ('272', '副总裁', '7');
INSERT INTO `area_label` VALUES ('273', '区块链开发', '1');

-- ----------------------------
-- Table structure for chat
-- ----------------------------
DROP TABLE IF EXISTS `chat`;
CREATE TABLE `chat` (
  `chat_id` char(20) NOT NULL,
  `chat_content` varchar(255) NOT NULL,
  `chat_time` datetime NOT NULL,
  `chat_user_id` char(32) NOT NULL,
  `is_delete` enum('0','1') NOT NULL DEFAULT '0' COMMENT '''0-未删除；1-已删除''',
  PRIMARY KEY (`chat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='闲聊';

-- ----------------------------
-- Records of chat
-- ----------------------------
INSERT INTO `chat` VALUES ('15266257380081EZMLVH', '和男友一起出门玩，突然感觉肚子不舒服，男友看到我痛苦的表情，关心地问我怎么了？　　我说肚子疼，大概大姨妈来了。　　男朋友沉思片刻认真地问：那你的那份冰淇淋还吃吗？', '2018-05-18 14:42:18', '15248859107335YA2M37', '0');
INSERT INTO `chat` VALUES ('1526625803180U3NM391', '儿子幼儿园要进行亲子活动，我和老公都去了。　　儿子拉着爸爸的手和漂亮的女老师的手，对我说：“妈妈，帮我们一家三口拍张照片好吗？” ', '2018-05-18 14:43:23', '15248859107335YA2M37', '0');
INSERT INTO `chat` VALUES ('152662639694158I3511', '下午在图书馆看书，一个小萝莉就坐在我对面，时不时瞄我一眼。这样持续了一两个小时，我忍不住问她：小朋友，你为什么一直看着我啊？小萝莉怯生生的指了指图书管理员：妈妈叫我注意一下有没有人偷偷拿书走。我觉得你最有可能偷走妈妈的书。……我……我特么想偷走你妈妈！ ', '2018-05-18 14:53:17', '1526179403208IWBRWA6', '0');
INSERT INTO `chat` VALUES ('1526654424032ZRN96DE', '邻居家生了对龙凤胎，我们去道喜。两个小家伙太可爱了，我跟老公说：“老公，你看多好玩，咱也生一对儿吧。”　　老公回道：“据统计，我国双胞胎几率仅千分之五，而龙凤胎是异卵双胎，几率更小。所谓异卵就是我们要孩子那几天，你要同时排两个卵子，还要全部中枪，即使这样，也不能保证……”　　我捂住老公喋喋不休的嘴：', '2018-05-18 22:40:24', '1526179403208IWBRWA6', '1');
INSERT INTO `chat` VALUES ('1526656106585S9QA2QD', '今天一大早父亲突然给我出了个智力题：“你面前有十条巷子，其中九条都布置了杀人的机关，你要怎么做才能活下去？”我摇摇头。父亲平静地说：“很简单，找对巷。”我…… ', '2018-05-18 23:08:27', '1526179403208IWBRWA6', '0');
INSERT INTO `chat` VALUES ('1526656163436MG71888', '女子：“医生，你让我把舌头伸出来，怎么又不看呢？” 医生：“我不是要看你的舌头，而是要你在我开药方时安静点。” ', '2018-05-18 23:09:23', '1526179403208IWBRWA6', '0');
INSERT INTO `chat` VALUES ('15266562002674Y61KTP', '昨天和女神聊天，聊了很多，可是女神总是回复：“呵呵，哦，嗯，奥”，我实在忍不住了便说：“你就不能说些别的嘛。”她回了一句：“我去洗澡了。”顿时我感觉无爱了，所以毅然的选择了离开，留下她独自一人在宾馆。 ', '2018-05-18 23:10:00', '1526179403208IWBRWA6', '0');
INSERT INTO `chat` VALUES ('15266562930684R2S5CI', '今天绑架了一个女的，怕她叫唤，我就用馒头堵住了她的嘴。可是现在已经吃了第十个了她还说要怎么办？我已经没钱买了。', '2018-05-18 23:11:33', '1526179403208IWBRWA6', '0');
INSERT INTO `chat` VALUES ('15266563145543I77T6R', '小时候有一次被人被打到流血，回家后我爸给了我一巴掌，说：“怂货！被打为什么不还手？” 随后我打了我爸一巴掌。 ', '2018-05-18 23:11:55', '1526179403208IWBRWA6', '0');
INSERT INTO `chat` VALUES ('1526656342358PVFE9HH', '睡觉前我活捉了一只蚊子，正准备拍死它，女友阻止了我：“别拍死它，你难道没有想过它也是有家人的吗？” 我一愣：“怎么你对蚊子也这么心软？” 她皱皱眉，道： “你先把它绑起来挂在床头，等它爸妈来救它时，再把它全家一块拍死。” ', '2018-05-18 23:12:22', '1526179403208IWBRWA6', '0');
INSERT INTO `chat` VALUES ('15266565007682LJDXQ9', '手机没话费，因为之前不是丢了钱包，，正在补卡，身上没钱，于是找妹妹帮我冲一下，妹妹可怜巴巴的说，哥，你也知道，我是个学生，穷的一塌糊涂～然后我说，充一百，到时给你五百，嘿，妹妹办事效率还可不是盖的，我刚说完。她就立马给我冲了两百…… ', '2018-05-18 23:15:01', '1526179403208IWBRWA6', '0');

-- ----------------------------
-- Table structure for chat_reply
-- ----------------------------
DROP TABLE IF EXISTS `chat_reply`;
CREATE TABLE `chat_reply` (
  `cr_id` char(20) NOT NULL,
  `cr_content` varchar(255) NOT NULL,
  `cr_time` datetime NOT NULL,
  `cr_chat_id` char(20) NOT NULL,
  `from_user_id` char(32) NOT NULL,
  `to_user_id` char(255) NOT NULL,
  `is_delete` enum('0','1') NOT NULL DEFAULT '0' COMMENT '''0-未删除；1-已删除''',
  PRIMARY KEY (`cr_id`),
  KEY `fk_cr_c` (`cr_chat_id`),
  CONSTRAINT `fk_cr_c` FOREIGN KEY (`cr_chat_id`) REFERENCES `chat` (`chat_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='闲聊回复';

-- ----------------------------
-- Records of chat_reply
-- ----------------------------
INSERT INTO `chat_reply` VALUES ('1526625824887Y1DX964', '哈哈哈', '2018-05-18 14:43:45', '15266257380081EZMLVH', '15248859107335YA2M37', '15248859107335YA2M37', '0');
INSERT INTO `chat_reply` VALUES ('1526626283263KZ8WXG9', '哈哈你个头', '2018-05-18 14:51:23', '15266257380081EZMLVH', '1526179403208IWBRWA6', '15248859107335YA2M37', '0');
INSERT INTO `chat_reply` VALUES ('15266268792598ANMVWF', '我做设计的，经常要和做文案的妹子配合。　　最近做出来的东西有点貌合神离，昨天老板娘说：“你俩要把情感投入进去，你中有我，我中有你，要将对方当做自己的另一半。”　　今天文案妹子辞职了。', '2018-05-18 15:01:19', '1526625803180U3NM391', '1526179403208IWBRWA6', '15248859107335YA2M37', '1');

-- ----------------------------
-- Table structure for classify
-- ----------------------------
DROP TABLE IF EXISTS `classify`;
CREATE TABLE `classify` (
  `classify_id` int(11) NOT NULL AUTO_INCREMENT,
  `classify_name` varchar(25) NOT NULL,
  PRIMARY KEY (`classify_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='帖子分类';

-- ----------------------------
-- Records of classify
-- ----------------------------
INSERT INTO `classify` VALUES ('7', 'advice');
INSERT INTO `classify` VALUES ('8', 'readme');
INSERT INTO `classify` VALUES ('9', 'resource');
INSERT INTO `classify` VALUES ('10', 'question');
INSERT INTO `classify` VALUES ('11', 'interview');
INSERT INTO `classify` VALUES ('12', 'job');

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `company_id` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(25) NOT NULL,
  `good_num` int(11) NOT NULL DEFAULT '0',
  `bad_num` int(11) NOT NULL DEFAULT '0',
  `user_id` char(32) NOT NULL,
  `is_delete` enum('0','1') NOT NULL DEFAULT '0' COMMENT '''0-未删除；1-已删除''',
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='公司';

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES ('1', '深圳丰巢科技', '2', '0', '1526179403208IWBRWA6', '0');
INSERT INTO `company` VALUES ('2', '深圳腾讯科技', '1', '1', '1526179403208IWBRWA6', '0');

-- ----------------------------
-- Table structure for company_label
-- ----------------------------
DROP TABLE IF EXISTS `company_label`;
CREATE TABLE `company_label` (
  `cl_id` int(11) NOT NULL AUTO_INCREMENT,
  `cl_name` varchar(25) NOT NULL,
  `cl_type` enum('0','1') NOT NULL DEFAULT '0' COMMENT '''0-好；1-坏''',
  `company_id` int(11) NOT NULL,
  `user_id` char(32) NOT NULL,
  `is_delete` enum('0','1') NOT NULL DEFAULT '0' COMMENT '''0-未删除；1-已删除''',
  PRIMARY KEY (`cl_id`),
  KEY `fk_cl_c` (`company_id`),
  CONSTRAINT `fk_cl_c` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='公司的标签';

-- ----------------------------
-- Records of company_label
-- ----------------------------
INSERT INTO `company_label` VALUES ('1', '是个好公司', '0', '2', '1526179403208IWBRWA6', '0');
INSERT INTO `company_label` VALUES ('2', '门槛高', '1', '2', '1526179403208IWBRWA6', '0');
INSERT INTO `company_label` VALUES ('3', '公司氛围好', '0', '1', '1526179403208IWBRWA6', '0');
INSERT INTO `company_label` VALUES ('4', '能得到成长', '0', '1', '1526179403208IWBRWA6', '0');

-- ----------------------------
-- Table structure for isay_time_list
-- ----------------------------
DROP TABLE IF EXISTS `isay_time_list`;
CREATE TABLE `isay_time_list` (
  `isay_time` varchar(10) NOT NULL,
  PRIMARY KEY (`isay_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='时间列表，用于左连接查询';

-- ----------------------------
-- Records of isay_time_list
-- ----------------------------
INSERT INTO `isay_time_list` VALUES ('2018-01');
INSERT INTO `isay_time_list` VALUES ('2018-02');
INSERT INTO `isay_time_list` VALUES ('2018-03');
INSERT INTO `isay_time_list` VALUES ('2018-04');
INSERT INTO `isay_time_list` VALUES ('2018-05');
INSERT INTO `isay_time_list` VALUES ('2018-06');
INSERT INTO `isay_time_list` VALUES ('2018-07');
INSERT INTO `isay_time_list` VALUES ('2018-08');
INSERT INTO `isay_time_list` VALUES ('2018-09');
INSERT INTO `isay_time_list` VALUES ('2018-10');
INSERT INTO `isay_time_list` VALUES ('2018-11');
INSERT INTO `isay_time_list` VALUES ('2018-12');
INSERT INTO `isay_time_list` VALUES ('2019-01');
INSERT INTO `isay_time_list` VALUES ('2019-02');
INSERT INTO `isay_time_list` VALUES ('2019-03');
INSERT INTO `isay_time_list` VALUES ('2019-04');
INSERT INTO `isay_time_list` VALUES ('2019-05');
INSERT INTO `isay_time_list` VALUES ('2019-06');
INSERT INTO `isay_time_list` VALUES ('2019-07');
INSERT INTO `isay_time_list` VALUES ('2019-08');
INSERT INTO `isay_time_list` VALUES ('2019-09');
INSERT INTO `isay_time_list` VALUES ('2019-10');
INSERT INTO `isay_time_list` VALUES ('2019-11');
INSERT INTO `isay_time_list` VALUES ('2019-12');

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `post_id` char(32) NOT NULL,
  `post_title` varchar(55) NOT NULL,
  `post_shortcut` varchar(1024) NOT NULL COMMENT '''帖子快照''',
  `post_content` mediumtext NOT NULL,
  `post_markdown` mediumtext NOT NULL,
  `post_cover` varchar(255) NOT NULL,
  `visit_num` int(11) NOT NULL DEFAULT '0',
  `up_num` int(11) NOT NULL DEFAULT '0',
  `down_num` int(11) NOT NULL DEFAULT '0',
  `collection_num` int(11) NOT NULL DEFAULT '0',
  `comment_num` int(11) NOT NULL DEFAULT '0',
  `post_time` datetime NOT NULL,
  `classify_id` int(11) NOT NULL,
  `area_id` int(11) NOT NULL,
  `author_id` char(32) NOT NULL COMMENT '''不在同一个服务，不能外键''',
  `modifier_id` char(32) NOT NULL COMMENT '''修改者，这个字段仅仅针对技能图部分，要记录最后修改的人。除了这个部分，修改者与作者一致''',
  `modify_time` datetime NOT NULL COMMENT '''最后修改时间''',
  `is_delete` enum('0','1') NOT NULL DEFAULT '0' COMMENT '''0-未删除；1-已删除''',
  PRIMARY KEY (`post_id`),
  KEY `fk_p_a` (`area_id`),
  KEY `fk_p_c` (`classify_id`),
  CONSTRAINT `fk_p_a` FOREIGN KEY (`area_id`) REFERENCES `work_area` (`area_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_p_c` FOREIGN KEY (`classify_id`) REFERENCES `classify` (`classify_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='帖子';

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES ('15263640778098G1THID', '再见只是陌生人-庄心妍', '再见只是陌生人 - 庄心妍词：林华勇&赖剑亮\r\n曲：林华勇爱过你 就当你是错的人\r\n有些错 我们都要负责任\r\n是否我爱了 不该爱的人\r\n其实我 想要的并不过分\r\n爱过你 至少我坦诚承认\r\n有些错 我们不用去争论\r\n也许我错过 幸福的时分\r\n这座城 多了个伤心的人\r\n我们爱的难舍难分\r\n爱的奋不顾身\r\n为何再见只是陌生人\r\n夜来得无声 我的心好冷\r\n那绝望比分手更伤人\r\n我们爱的难舍难分\r\n爱的奋不顾身\r\n爱到最后同样不可能\r\n你走得无痕 我的心好疼\r\n该拿什么与眼泪抗衡\r\n爱过你 至少我坦诚承认\r\n有些错 我们不用去争论\r\n也许我错过 ', '<h3 id=\"h3--\"><a name=\"再见只是陌生人 - 庄心妍\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>再见只是陌生人 - 庄心妍</h3><p>词：林华勇&amp;赖剑亮</p>\r\n<p>曲：林华勇<br><img src=\"http://localhost:8080/isay-web/post_photo/1526363644450.jpg\" alt=\"\"><br>爱过你 就当你是错的人</p>\r\n<p>有些错 我们都要负责任</p>\r\n<p>是否我爱了 不该爱的人</p>\r\n<p>其实我 想要的并不过分</p>\r\n<p>爱过你 至少我坦诚承认</p>\r\n<p>有些错 我们不用去争论</p>\r\n<p>也许我错过 幸福的时分</p>\r\n<p>这座城 多了个伤心的人</p>\r\n<p>我们爱的难舍难分</p>\r\n<p>爱的奋不顾身</p>\r\n<p>为何再见只是陌生人</p>\r\n<p>夜来得无声 我的心好冷</p>\r\n<p>那绝望比分手更伤人</p>\r\n<p>我们爱的难舍难分</p>\r\n<p>爱的奋不顾身</p>\r\n<p>爱到最后同样不可能</p>\r\n<p>你走得无痕 我的心好疼</p>\r\n<p>该拿什么与眼泪抗衡</p>\r\n<p>爱过你 至少我坦诚承认</p>\r\n<p>有些错 我们不用去争论</p>\r\n<p>也许我错过 幸福的时分</p>\r\n<p>这座城 多了个伤心的人</p>\r\n<p>我们爱的难舍难分</p>\r\n<p>爱的奋不顾身</p>\r\n<p>为何再见只是陌生人</p>\r\n<p>夜来得无声 我的心好冷</p>\r\n<p>那绝望比分手更伤人</p>\r\n<p>我们爱的难舍难分</p>\r\n<p>爱的奋不顾身</p>\r\n<p>为何再见只是陌生人</p>\r\n<p>你走得无痕 我的心好疼</p>\r\n<p>该拿什么与眼泪抗衡</p>\r\n<p>你走得无痕 我的心好疼</p>\r\n<p>该拿什么与眼泪抗衡</p>\r\n', '###再见只是陌生人 - 庄心妍\r\n\r\n词：林华勇&赖剑亮\r\n\r\n曲：林华勇\r\n![](http://localhost:8080/isay-web/post_photo/1526363644450.jpg)\r\n爱过你 就当你是错的人\r\n\r\n有些错 我们都要负责任\r\n\r\n是否我爱了 不该爱的人\r\n\r\n其实我 想要的并不过分\r\n\r\n爱过你 至少我坦诚承认\r\n\r\n有些错 我们不用去争论\r\n\r\n也许我错过 幸福的时分\r\n\r\n这座城 多了个伤心的人\r\n\r\n我们爱的难舍难分\r\n\r\n爱的奋不顾身\r\n\r\n为何再见只是陌生人\r\n\r\n夜来得无声 我的心好冷\r\n\r\n那绝望比分手更伤人\r\n\r\n我们爱的难舍难分\r\n\r\n爱的奋不顾身\r\n\r\n爱到最后同样不可能\r\n\r\n你走得无痕 我的心好疼\r\n\r\n该拿什么与眼泪抗衡\r\n\r\n爱过你 至少我坦诚承认\r\n\r\n有些错 我们不用去争论\r\n\r\n也许我错过 幸福的时分\r\n\r\n这座城 多了个伤心的人\r\n\r\n我们爱的难舍难分\r\n\r\n爱的奋不顾身\r\n\r\n为何再见只是陌生人\r\n\r\n夜来得无声 我的心好冷\r\n\r\n那绝望比分手更伤人\r\n\r\n我们爱的难舍难分\r\n\r\n爱的奋不顾身\r\n\r\n为何再见只是陌生人\r\n\r\n你走得无痕 我的心好疼\r\n\r\n该拿什么与眼泪抗衡\r\n\r\n你走得无痕 我的心好疼\r\n\r\n该拿什么与眼泪抗衡', 'http://localhost:8080/isay-web/post_photo/1526363644450.jpg', '10', '1', '0', '1', '0', '2018-10-15 14:01:18', '7', '3', '1526179403208IWBRWA6', '1526179403208IWBRWA6', '2018-05-16 22:56:21', '0');
INSERT INTO `post` VALUES ('15266597293265W1UHTQ', 'java技能', 'java\r\n\r\n\r\n业务开发\r\n中间件开发\r\n\r\n\r\n\r\n\r\nSpring\r\n消息队列\r\n\r\n\r\nSpringBoot\r\n数据库中间件\r\n\r\n\r\n\r\n\r\n  Java的桌面程序并不少，其中最为知名的莫过于Eclipse。在Linux和Mac下，Java程序的比例远高于Windows下。  不过，“Java不适合写桌面应用”的说法有一定道理，论调的主要背景是供Windows下使用的企业桌面应用的开发。由于一些历史和定位的原因，对于这种GUI程序的需求，Java的优势不明显，劣势比较明显。  这事还得从Java的传统，“跨平台一致性”说', '<h2 id=\"h2-java\"><a name=\"java\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>java</h2><table>\r\n<thead>\r\n<tr>\r\n<th>业务开发</th>\r\n<th>中间件开发</th>\r\n</tr>\r\n</thead>\r\n<tbody>\r\n<tr>\r\n<td>Spring</td>\r\n<td>消息队列</td>\r\n</tr>\r\n<tr>\r\n<td>SpringBoot</td>\r\n<td>数据库中间件</td>\r\n</tr>\r\n</tbody>\r\n</table>\r\n<p><img src=\"http://localhost:8080/isay-web/post_photo/1526659139117.jpg\" alt=\"\"></p>\r\n<p>  Java的桌面程序并不少，其中最为知名的莫过于Eclipse。在Linux和Mac下，Java程序的比例远高于Windows下。<br>  不过，“Java不适合写桌面应用”的说法有一定道理，论调的主要背景是供Windows下使用的企业桌面应用的开发。由于一些历史和定位的原因，对于这种GUI程序的需求，Java的优势不明显，劣势比较明显。<br>  这事还得从Java的传统，“跨平台一致性”说起。<br>  在写后台逻辑的时候，跨平台是好东西。很多公司都是在Windows下开发，在Linux下部署，方便。<br>  但涉及到GUI的时候，跨平台就成了个“看上去很美”的东西。理论上，我写个窗口，在Windows和Mac下都一样能用，那是多么美好的事啊。但实际上，每个平台提供的GUI控件多多少少有点差别，一坚持跨平台，麻烦就来了，该支持多少控件，怎么支持呢。<br>  一开始，Java的思路是：那简单啊，有原生控件干嘛不用，至于不跨平台的，就不支持呗，又坚持了原则，又回避了问题。这一代的gui库，awt，就此诞生。<br>  因为Java一开始是一根筋想推广Applet的，只是“顺便”也支持本地应用，设计成这样不能说不合适，毕竟，HTML也是同样的思路，只支持几种最基本的控件。<br>  但对于想开发复杂点界面的人来说，就有麻烦了。想来个目录树吧，对不起，不支持；想来个进度条吧，对不起，不支持。旁边放着Delphi和VB这么方便的东西，哥干吗受这气啊。<br>  这样一来，Java自己也觉得说不过去了。但又要跨平台，又要提供丰富的控件支持，那就只有另起炉灶，开始用第二种思路：自己动手、丰衣足食，自己重写一套GUI控件，代替操作系统的原生控件。这一代的gui库，叫做swing。<br>  这也是一个想“彻底”解决问题的思路，但是要付出代价。代价之一就是效率。我们可以参考一下另一个相同思路的产品——flash。为了实现矢量动画，在flash的那个小框里，图是一帧一帧地算出来的。接下来的事情我们都知道了：复杂的flash动画极耗cpu；iPhone说，您太耗电了，俺就不支持了；Adobe说，那好吧，那俺也不费心折腾移动版flash了。<br>  自己画出来的控件毕竟不能跟原生控件比效率，尤其是在早期Java优化还不够完善的时候。而且，自力更生的目的只是为了平台兼容，不是为了更好的效果，这事儿其实怎么想怎么亏。代价之二就是效果。自己画的控件毕竟只是模拟，还是会有细节差别。比如著名的毛玻璃效果，这不是简单套样式就能套出来的。而且，各个平台控件的风格本来就不一样，虽然swing提供了几种外观，但大部分程序出于偷懒或是跨平台一致考虑，还是使用默认外观。默认外观跟平台不一致倒也不是问题，主要是别比平台效果土。我用着win7，一个程序非让我感觉回到xp时代，心里特别添堵。就这样，一帮人商量着，又琢磨出个新思路：做适配。平台有这个控件，就直接用，保证效率；没有，再造轮子，保证可用。就这样，swt问世。eclipse的gui就是基于此。</p>\r\n', '## java\r\n\r\n|   业务开发| 中间件开发  |\r\n| ------------ | ------------ |\r\n|  Spring |  消息队列 |\r\n|  SpringBoot |  数据库中间件 |\r\n\r\n![](http://localhost:8080/isay-web/post_photo/1526659139117.jpg)\r\n\r\n\r\n\r\n\r\n  Java的桌面程序并不少，其中最为知名的莫过于Eclipse。在Linux和Mac下，Java程序的比例远高于Windows下。\r\n  不过，“Java不适合写桌面应用”的说法有一定道理，论调的主要背景是供Windows下使用的企业桌面应用的开发。由于一些历史和定位的原因，对于这种GUI程序的需求，Java的优势不明显，劣势比较明显。\r\n  这事还得从Java的传统，“跨平台一致性”说起。\r\n  在写后台逻辑的时候，跨平台是好东西。很多公司都是在Windows下开发，在Linux下部署，方便。\r\n  但涉及到GUI的时候，跨平台就成了个“看上去很美”的东西。理论上，我写个窗口，在Windows和Mac下都一样能用，那是多么美好的事啊。但实际上，每个平台提供的GUI控件多多少少有点差别，一坚持跨平台，麻烦就来了，该支持多少控件，怎么支持呢。\r\n  一开始，Java的思路是：那简单啊，有原生控件干嘛不用，至于不跨平台的，就不支持呗，又坚持了原则，又回避了问题。这一代的gui库，awt，就此诞生。\r\n  因为Java一开始是一根筋想推广Applet的，只是“顺便”也支持本地应用，设计成这样不能说不合适，毕竟，HTML也是同样的思路，只支持几种最基本的控件。\r\n  但对于想开发复杂点界面的人来说，就有麻烦了。想来个目录树吧，对不起，不支持；想来个进度条吧，对不起，不支持。旁边放着Delphi和VB这么方便的东西，哥干吗受这气啊。\r\n  这样一来，Java自己也觉得说不过去了。但又要跨平台，又要提供丰富的控件支持，那就只有另起炉灶，开始用第二种思路：自己动手、丰衣足食，自己重写一套GUI控件，代替操作系统的原生控件。这一代的gui库，叫做swing。\r\n  这也是一个想“彻底”解决问题的思路，但是要付出代价。代价之一就是效率。我们可以参考一下另一个相同思路的产品——flash。为了实现矢量动画，在flash的那个小框里，图是一帧一帧地算出来的。接下来的事情我们都知道了：复杂的flash动画极耗cpu；iPhone说，您太耗电了，俺就不支持了；Adobe说，那好吧，那俺也不费心折腾移动版flash了。\r\n  自己画出来的控件毕竟不能跟原生控件比效率，尤其是在早期Java优化还不够完善的时候。而且，自力更生的目的只是为了平台兼容，不是为了更好的效果，这事儿其实怎么想怎么亏。代价之二就是效果。自己画的控件毕竟只是模拟，还是会有细节差别。比如著名的毛玻璃效果，这不是简单套样式就能套出来的。而且，各个平台控件的风格本来就不一样，虽然swing提供了几种外观，但大部分程序出于偷懒或是跨平台一致考虑，还是使用默认外观。默认外观跟平台不一致倒也不是问题，主要是别比平台效果土。我用着win7，一个程序非让我感觉回到xp时代，心里特别添堵。就这样，一帮人商量着，又琢磨出个新思路：做适配。平台有这个控件，就直接用，保证效率；没有，再造轮子，保证可用。就这样，swt问世。eclipse的gui就是基于此。', 'http://localhost:8080/isay-web/post_photo/1526659139117.jpg', '34', '0', '0', '0', '1', '2018-10-19 00:08:49', '12', '1', '1526179403208IWBRWA6', '1526179403208IWBRWA6', '2018-05-19 00:08:49', '0');
INSERT INTO `post` VALUES ('1527429937894Q2WZNPE', '区块链将如何重新定义世界', '\r\n区块链技术被认为是继蒸汽机、电力、互联网之后，下一代颠覆性的核心技术。 如果说蒸汽机释放了人们的生产力，电力解决了人们基本的生活需求，互联网彻底改变了信息传递的方式，那么区块链作为构造信任的机器，将可能彻底改变整个人类社会价值传递的方式。\r\n在这篇文章里，我们将用最容易理解的方式，让你在15分钟内了解清楚：\r\n区块链的本质到底是什么？\r\n区块链技术带来的三大巨变。区块链面临的两大技术挑战。\r\n区块链技术未来的发展脉络。\r\n区块链技术的本质到底是什么？\r\n区块链本质上是一个分布式的公共账本，听起来很蒙圈？别', '<p><img src=\"http://localhost:8080/isay-web/post_photo/1527429916285.jpg\" alt=\"\"></p>\r\n<p>区块链技术被认为是继蒸汽机、电力、互联网之后，下一代颠覆性的核心技术。 如果说蒸汽机释放了人们的生产力，电力解决了人们基本的生活需求，互联网彻底改变了信息传递的方式，那么区块链作为构造信任的机器，将可能彻底改变整个人类社会价值传递的方式。</p>\r\n<p>在这篇文章里，我们将用最容易理解的方式，让你在15分钟内了解清楚：</p>\r\n<p>区块链的本质到底是什么？</p>\r\n<p>区块链技术带来的三大巨变。区块链面临的两大技术挑战。</p>\r\n<p>区块链技术未来的发展脉络。</p>\r\n<p>区块链技术的本质到底是什么？</p>\r\n<p>区块链本质上是一个分布式的公共账本，听起来很蒙圈？别急，后面会用最深入浅出的方式来一一解释。任何人都可以对这个公共账本进行核查，但不存在一个单一的用户可以对它进行控制。在区块链系统中的参与者们，会共同维持账本的更新：它只能按照严格的规则和共识来进行修改，这背后有非常精妙的设计。</p>\r\n<p>举个通俗的例子来解释，W先生全家，包括 W 先生，W 夫人，W 爷爷， W 奶奶，各自的账本上都记录了大家的开支。因为 W 先生全家互相不信任。W 先生自己勤勤恳恳每个月养老婆，可W 夫人可能会收到1000块钱却记收到100，那岂不亏大了?</p>\r\n<p>用区块链如何解决这个问题呢？  假如某天 W 先生给了1000块给 W 夫人，他只要在向全家人大吼一声—— W 先生给了 W 夫人1000，请大家在各自的账本上记下“W 先生给了 W 夫人1000”，就OK了。</p>\r\n<p>于是 W 先生全家每个人都成了一个节点，每次 W 先生家的交易都会被每个人（每个节点）记录下来。</p>\r\n<p>每次晚上谁洗了碗（工作量证明）之后就可以在公共账本上结账，而且洗碗还有报酬，必须在前一天大家都公认的账本后面添加新的交易，而且其他人也会参与验证当天的交易。</p>\r\n<p>自然会有人问，能否进行恶意操作来破坏整个区块链系统？比如不承认别人的结果，或者伪造结果怎么办?</p>\r\n<p>比如 W 夫人某天忽然说 W 先生没给她1000，那么全家人都会站起来斥责她。如果 W 夫人某天洗完碗想在结账的时候动手脚，其他参与验证的人也会站起来斥责她（除非她能收买超过一半以上的人），被发现作假会导致她那天的碗就白洗了，报酬也会拿不到，很可能第二天还要继续洗碗。</p>\r\n<p>最后那个公认的账本也只会增加，不会减少。后续加入的家庭成员都会从最长的那个账本那里继续结账。</p>\r\n<p>总结一下，区块链其实很简单，就是一个分布式的公共账本。</p>\r\n<p>别看区块链好像看起来很简单，但区块链可能会给人类社会带来革命性的改变。</p>\r\n<p>第一：机器信任</p>\r\n<p>过去网络上流行“怎么证明我妈是我妈”的新闻，这其实是一个直接用区块链就能解决的问题。</p>\r\n<p>过去，我们的出生证、房产证、婚姻证等，需要一个中心的节点比如政府备书，大家才能承认。但一旦跨国，你就会遇到无穷的麻烦，跨国以后合同和证书可能就失效了，因为缺少全球性的中心节点。</p>\r\n<p>区块链技术不可篡改的特性从根本上改变了中心化的信用创建方式，通过数学原理而非中心化信用机构来低成本地建立信用。我们的出生证、房产证、婚姻证都可以在区块链上公证，变成全球都信任的东西，当然也可以轻松证明 “我妈是我妈”。</p>\r\n<p>人是善变的，而机器是不会撒谎的，区块链有望带领我们从个人信任、制度信任进入到机器信任的时代。</p>\r\n<p>这个意义有多大呢？</p>\r\n<p>回顾历史，人类文明是建立在信任和共识的基础上搭建起合作网络，从而人类成为地球的主宰。</p>\r\n<p>最早智人为什么能够战胜其他人种，从而统一人类？其实是因为语言的出现和讲故事能力的提升，人们能够以极其灵活的方式与陌生人进行大规模的协作，而其他人种因为不具备这种能力，所以无法更高效地聚集起团队，于是很快就分崩离析。</p>\r\n<p>直到今天，互联网也是新一代 “大型合作网络”，互联网上的领袖就是超级信任节点，他们的信任靠的是长时间的积累。</p>\r\n<p>传统金融的合作网络建立在钢筋水泥的大厦上，所以银行都需要盖大楼，让大家相信他们是值得信任的。政治上的信任构建也大体如此，需要大量的成本。</p>\r\n<p>从个人信任进化到制度信任是人类文明的一大进步，制度的产生源于降低交易成本的需求。通过对符合制度规定的行为进行认可与鼓励，对违反制度规定的行为进行惩戒，引导人们将自己的行为控制在一定的范围内，从而达到降低交易成本的目的。</p>\r\n<p>但制度和国家机器等中心节点为我们建立信用的成本偏高，因为需要很多人来维持这个体系。不管哪个时代，需要大量的人来维持的体系成本必然很高。</p>\r\n<p>区块链技术则用代码构建了一个最低成本的信任方式 —— 机器信任，我们不需要相信语言和故事，也不需要有钢筋水泥、中央机构为基础，不需要靠个人领袖背书，只需要知道那些区块链上的代码会执行，也不需要担心制度会被腐败掉，就可以做到互相协作，低成本构建大型合作网络。</p>\r\n<p>机器信任其实是无须信任的信任。人类历史将第一次可以接近零成本建立地球上前所未有的大型合作网络，这必将是一场伟大的群众运动。</p>\r\n<p>第二：价值传递</p>\r\n<p>人类正处于一场从物理世界向虚拟世界迁徙的历史性运动中，而不能否认一个事实，人类的财富也将渐渐往互联网转移，这已经是既成事实。</p>\r\n<p>传统的互联网不是为传递价值而生，互联网上信息的传输，本质是信息的拷贝。而现实中的货币流通要依靠中心化的组织做背书来维护运行，比如微信支付、支付宝、银联等。但现在有哪家公司能活1000年以上的吗？所以，依靠中心化的方式实现价值传递，弊病很多。</p>\r\n<p>而区块链是第一个能够实现价值传递的网络，区块链技术有望带领人类从信息互联网过渡到了价值互联网的伟大时代。</p>\r\n', '![](http://localhost:8080/isay-web/post_photo/1527429916285.jpg)\r\n\r\n区块链技术被认为是继蒸汽机、电力、互联网之后，下一代颠覆性的核心技术。 如果说蒸汽机释放了人们的生产力，电力解决了人们基本的生活需求，互联网彻底改变了信息传递的方式，那么区块链作为构造信任的机器，将可能彻底改变整个人类社会价值传递的方式。\r\n\r\n在这篇文章里，我们将用最容易理解的方式，让你在15分钟内了解清楚：\r\n\r\n区块链的本质到底是什么？\r\n\r\n区块链技术带来的三大巨变。区块链面临的两大技术挑战。\r\n\r\n区块链技术未来的发展脉络。\r\n\r\n区块链技术的本质到底是什么？\r\n\r\n区块链本质上是一个分布式的公共账本，听起来很蒙圈？别急，后面会用最深入浅出的方式来一一解释。任何人都可以对这个公共账本进行核查，但不存在一个单一的用户可以对它进行控制。在区块链系统中的参与者们，会共同维持账本的更新：它只能按照严格的规则和共识来进行修改，这背后有非常精妙的设计。\r\n\r\n举个通俗的例子来解释，W先生全家，包括 W 先生，W 夫人，W 爷爷， W 奶奶，各自的账本上都记录了大家的开支。因为 W 先生全家互相不信任。W 先生自己勤勤恳恳每个月养老婆，可W 夫人可能会收到1000块钱却记收到100，那岂不亏大了?\r\n\r\n用区块链如何解决这个问题呢？  假如某天 W 先生给了1000块给 W 夫人，他只要在向全家人大吼一声—— W 先生给了 W 夫人1000，请大家在各自的账本上记下“W 先生给了 W 夫人1000”，就OK了。\r\n\r\n于是 W 先生全家每个人都成了一个节点，每次 W 先生家的交易都会被每个人（每个节点）记录下来。\r\n\r\n每次晚上谁洗了碗（工作量证明）之后就可以在公共账本上结账，而且洗碗还有报酬，必须在前一天大家都公认的账本后面添加新的交易，而且其他人也会参与验证当天的交易。\r\n\r\n自然会有人问，能否进行恶意操作来破坏整个区块链系统？比如不承认别人的结果，或者伪造结果怎么办?\r\n\r\n比如 W 夫人某天忽然说 W 先生没给她1000，那么全家人都会站起来斥责她。如果 W 夫人某天洗完碗想在结账的时候动手脚，其他参与验证的人也会站起来斥责她（除非她能收买超过一半以上的人），被发现作假会导致她那天的碗就白洗了，报酬也会拿不到，很可能第二天还要继续洗碗。\r\n\r\n最后那个公认的账本也只会增加，不会减少。后续加入的家庭成员都会从最长的那个账本那里继续结账。\r\n\r\n总结一下，区块链其实很简单，就是一个分布式的公共账本。\r\n\r\n别看区块链好像看起来很简单，但区块链可能会给人类社会带来革命性的改变。\r\n\r\n第一：机器信任\r\n\r\n过去网络上流行“怎么证明我妈是我妈”的新闻，这其实是一个直接用区块链就能解决的问题。\r\n\r\n过去，我们的出生证、房产证、婚姻证等，需要一个中心的节点比如政府备书，大家才能承认。但一旦跨国，你就会遇到无穷的麻烦，跨国以后合同和证书可能就失效了，因为缺少全球性的中心节点。\r\n\r\n区块链技术不可篡改的特性从根本上改变了中心化的信用创建方式，通过数学原理而非中心化信用机构来低成本地建立信用。我们的出生证、房产证、婚姻证都可以在区块链上公证，变成全球都信任的东西，当然也可以轻松证明 “我妈是我妈”。\r\n\r\n人是善变的，而机器是不会撒谎的，区块链有望带领我们从个人信任、制度信任进入到机器信任的时代。\r\n\r\n这个意义有多大呢？\r\n\r\n回顾历史，人类文明是建立在信任和共识的基础上搭建起合作网络，从而人类成为地球的主宰。\r\n\r\n最早智人为什么能够战胜其他人种，从而统一人类？其实是因为语言的出现和讲故事能力的提升，人们能够以极其灵活的方式与陌生人进行大规模的协作，而其他人种因为不具备这种能力，所以无法更高效地聚集起团队，于是很快就分崩离析。\r\n\r\n直到今天，互联网也是新一代 “大型合作网络”，互联网上的领袖就是超级信任节点，他们的信任靠的是长时间的积累。\r\n\r\n传统金融的合作网络建立在钢筋水泥的大厦上，所以银行都需要盖大楼，让大家相信他们是值得信任的。政治上的信任构建也大体如此，需要大量的成本。\r\n\r\n从个人信任进化到制度信任是人类文明的一大进步，制度的产生源于降低交易成本的需求。通过对符合制度规定的行为进行认可与鼓励，对违反制度规定的行为进行惩戒，引导人们将自己的行为控制在一定的范围内，从而达到降低交易成本的目的。\r\n\r\n但制度和国家机器等中心节点为我们建立信用的成本偏高，因为需要很多人来维持这个体系。不管哪个时代，需要大量的人来维持的体系成本必然很高。\r\n\r\n区块链技术则用代码构建了一个最低成本的信任方式 —— 机器信任，我们不需要相信语言和故事，也不需要有钢筋水泥、中央机构为基础，不需要靠个人领袖背书，只需要知道那些区块链上的代码会执行，也不需要担心制度会被腐败掉，就可以做到互相协作，低成本构建大型合作网络。\r\n\r\n机器信任其实是无须信任的信任。人类历史将第一次可以接近零成本建立地球上前所未有的大型合作网络，这必将是一场伟大的群众运动。\r\n\r\n第二：价值传递\r\n\r\n人类正处于一场从物理世界向虚拟世界迁徙的历史性运动中，而不能否认一个事实，人类的财富也将渐渐往互联网转移，这已经是既成事实。\r\n\r\n传统的互联网不是为传递价值而生，互联网上信息的传输，本质是信息的拷贝。而现实中的货币流通要依靠中心化的组织做背书来维护运行，比如微信支付、支付宝、银联等。但现在有哪家公司能活1000年以上的吗？所以，依靠中心化的方式实现价值传递，弊病很多。\r\n\r\n而区块链是第一个能够实现价值传递的网络，区块链技术有望带领人类从信息互联网过渡到了价值互联网的伟大时代。\r\n\r\n\r\n', 'http://localhost:8080/isay-web/post_photo/1527429916285.jpg', '10', '0', '0', '0', '2', '2018-10-27 22:05:38', '8', '1', '1526179403208IWBRWA6', '1526179403208IWBRWA6', '2018-09-20 15:14:50', '0');
INSERT INTO `post` VALUES ('1527916252410MNH4GTV', '其实不管你再优秀，总有不喜欢你的人', '\r\n以前我们总是以为自己变得优秀了，那些不喜欢我们的人就会喜欢我们了。现在我们发现，即使我们变得再优秀，那些不喜欢我们的人还是不喜欢我们。\r\n\r\n01\r\n记得我刚进有书的原创群时，那时的原创群是个充满生气的读书写作群。群里的书友在队长小蜜蜂的鞭策下，打卡读书非常认真，作业大多都能按时完成。\r\n后来，因为我的到来，彻底改变了原创群。原本安静的读书群因为我的活跃开始闹腾起来。大多数的书友挺喜欢我的活跃给群带来了欢乐，但也有人讨厌我的闹腾离群而去。\r\n我那时不知道群里有不喜欢我的人，直到有一次，组长告诉你，有一个', '<blockquote>\r\n<p>以前我们总是以为自己变得优秀了，那些不喜欢我们的人就会喜欢我们了。现在我们发现，即使我们变得再优秀，那些不喜欢我们的人还是不喜欢我们。</p>\r\n</blockquote>\r\n<p>01</p>\r\n<p>记得我刚进有书的原创群时，那时的原创群是个充满生气的读书写作群。群里的书友在队长小蜜蜂的鞭策下，打卡读书非常认真，作业大多都能按时完成。</p>\r\n<p>后来，因为我的到来，彻底改变了原创群。原本安静的读书群因为我的活跃开始闹腾起来。大多数的书友挺喜欢我的活跃给群带来了欢乐，但也有人讨厌我的闹腾离群而去。</p>\r\n<p><img src=\"http://localhost:8080/isay-web/post_photo/1527916156056.jpg\" alt=\"\"><br>我那时不知道群里有不喜欢我的人，直到有一次，组长告诉你，有一个书友退群了，走之前和他说了，因为不喜欢我的活跃，所以走了。</p>\r\n<p>我听后不以为然，就对组长说，爱走就走呗，我又不是人民币，谁见了都喜欢。再说，就是优秀的雷总也不一定人人喜欢。他不喜欢和我们随波逐流，就随他去吧！</p>\r\n<p>那时的我，进有书才几个月。一个没多少文化，写的又不咋得的人，凭什么让人喜欢！咱可是有自知之明的人。</p>\r\n<p>02</p>\r\n<p>几年前，想带儿子去商场购买些日用品回来，儿子开始不怎么愿意去。儿子那时才几岁，把他一个人放在家里也不放心，所以我死拽着他上了商场。<br>到了商场门口的时候，他站在门口哭，说不想进去，说商场不好玩。我蹲下去安慰他。</p>\r\n<p>我拿纸巾帮他抹眼泪，安慰他说“乖宝宝，你看看周围这么多玩具商品啊，我们可以一起去玩啊”！</p>\r\n<p>“你们都是骗子，我根本没看到什么好玩的玩具。”</p>\r\n<p>我蹲在他旁边向商场望去，是的，根本就没有好玩的玩具，看到的不过是一群来来往往人员的大腿而已。我抱着他说，走了走了，咱们回去了。</p>\r\n<p>我们总是站在自己的视觉看待这个世界，我们看到的是琳琅满目的商品，而在小孩子的世界里，他们看到的永远都是一群人的腿而已。</p>\r\n<p>我们每个人所处的高度是不一样的，看到的东西，产生的反应也是不一样的。</p>\r\n<p>生活中我们很多人都倾向于评价别人，而不是倾向于理解别人。往往评价别人的时候就是站在自己的角度去评价的。自己觉得自己的观点很牛逼了。其实在别人看来，不过就是一坨屎而已。</p>\r\n<p>从写作这一年多来，有人对于我的文章表示感谢，有人不以为然、嗤之以鼻。其实每个人对优秀的定义并不相同。</p>\r\n', '> 以前我们总是以为自己变得优秀了，那些不喜欢我们的人就会喜欢我们了。现在我们发现，即使我们变得再优秀，那些不喜欢我们的人还是不喜欢我们。\r\n\r\n01\r\n\r\n记得我刚进有书的原创群时，那时的原创群是个充满生气的读书写作群。群里的书友在队长小蜜蜂的鞭策下，打卡读书非常认真，作业大多都能按时完成。\r\n\r\n后来，因为我的到来，彻底改变了原创群。原本安静的读书群因为我的活跃开始闹腾起来。大多数的书友挺喜欢我的活跃给群带来了欢乐，但也有人讨厌我的闹腾离群而去。\r\n\r\n![](http://localhost:8080/isay-web/post_photo/1527916156056.jpg)\r\n我那时不知道群里有不喜欢我的人，直到有一次，组长告诉你，有一个书友退群了，走之前和他说了，因为不喜欢我的活跃，所以走了。\r\n\r\n我听后不以为然，就对组长说，爱走就走呗，我又不是人民币，谁见了都喜欢。再说，就是优秀的雷总也不一定人人喜欢。他不喜欢和我们随波逐流，就随他去吧！\r\n\r\n那时的我，进有书才几个月。一个没多少文化，写的又不咋得的人，凭什么让人喜欢！咱可是有自知之明的人。\r\n\r\n02\r\n\r\n几年前，想带儿子去商场购买些日用品回来，儿子开始不怎么愿意去。儿子那时才几岁，把他一个人放在家里也不放心，所以我死拽着他上了商场。\r\n到了商场门口的时候，他站在门口哭，说不想进去，说商场不好玩。我蹲下去安慰他。\r\n\r\n我拿纸巾帮他抹眼泪，安慰他说“乖宝宝，你看看周围这么多玩具商品啊，我们可以一起去玩啊”！\r\n\r\n“你们都是骗子，我根本没看到什么好玩的玩具。”\r\n\r\n我蹲在他旁边向商场望去，是的，根本就没有好玩的玩具，看到的不过是一群来来往往人员的大腿而已。我抱着他说，走了走了，咱们回去了。\r\n\r\n我们总是站在自己的视觉看待这个世界，我们看到的是琳琅满目的商品，而在小孩子的世界里，他们看到的永远都是一群人的腿而已。\r\n\r\n我们每个人所处的高度是不一样的，看到的东西，产生的反应也是不一样的。\r\n\r\n生活中我们很多人都倾向于评价别人，而不是倾向于理解别人。往往评价别人的时候就是站在自己的角度去评价的。自己觉得自己的观点很牛逼了。其实在别人看来，不过就是一坨屎而已。\r\n\r\n从写作这一年多来，有人对于我的文章表示感谢，有人不以为然、嗤之以鼻。其实每个人对优秀的定义并不相同。\r\n\r\n', 'http://localhost:8080/isay-web/post_photo/1527916156056.jpg', '3', '0', '0', '0', '0', '2018-11-02 13:10:52', '7', '2', '15248859107335YA2M37', '15248859107335YA2M37', '2018-06-02 13:10:52', '0');
INSERT INTO `post` VALUES ('1527916395654TXRYQ47', '产品经理面试到底在面试什么', '本人曾面试产品经理几十次，败绩无数，后也面过一些产品经理，误入此题，上一些感想。\r\n产品经理是一个以软实力为主的岗位，不需要你设计，不需要你写代码，需要你干什么，心里必须有数。把这个说在前面，是要提醒你，产品经理虽然不一定需要你上硬货，但你千万别把面试当做一个扯蛋的过程，虽然“你觉得什么样的产品是好产品？”这样的问题看起来是面试官在和你扯蛋，但是这其实是一个非常专业的问题。首先一定要把产品经理当成一门专业来看待，要把面试当做一个规范的行为来看待，万不可随意瞎扯。\r\n压力测试是给外行的人做的，对于专业', '<p>本人曾面试产品经理几十次，败绩无数，后也面过一些产品经理，误入此题，上一些感想。</p>\r\n<p>产品经理是一个以软实力为主的岗位，不需要你设计，不需要你写代码，需要你干什么，心里必须有数。把这个说在前面，是要提醒你，产品经理虽然不一定需要你上硬货，但你千万别把面试当做一个扯蛋的过程，虽然“你觉得什么样的产品是好产品？”这样的问题看起来是面试官在和你扯蛋，但是这其实是一个非常专业的问题。首先一定要把产品经理当成一门专业来看待，要把面试当做一个规范的行为来看待，万不可随意瞎扯。</p>\r\n<p>压力测试是给外行的人做的，对于专业的人来说，讨论专业的事，任何问题都不要归结于压力测试的思路去。以逻辑和说服力征服对方，产品工作就是一个先自己想明白，再不断说服所有人的过程。</p>\r\n<p>在知乎另外一个关于面试豆瓣产品经理的问题上，我们可以看到一个失败的产品面试过程，失败在哪里，没有人给出解读。产品经理面试经常犯一个错误，就是认为问题没有标准答案，诚然，产品工作中的确没有全对全错，但是面试是一场考试，是考试必定有高下，有高下就必定有标准，接近那个标准的，就是正确答案，远离那个标准的，就是错误答案。面试的过程，就是让自己的回答无限接近标准答案的过程。</p>\r\n<p>回到那个豆瓣面试，里面有一个问题我也曾经常遇到，“Q:你觉得什么样的产品是一个成功的产品？”或者是“成功的产品有什么标准？”。你可以这样答：好玩的产品就是成功的、用户人数多的就是成功的、能为公司赚钱的就是成功的、UI做得漂亮就是成功的。当然从扯蛋的角度看，这样的回答本没有问题，但是如果是产品经理面试，这样的回答要打零分。为什么呢？不要忘记你的身份，是要来面试产品经理，好玩的产品一定成功吗？成功，但这是从用户的角度看问题，用户人数多就成功吗？这仿佛是一个聪明的答案，但其实是很容易被问死的，多少用户算多？用户人数多就一定很成功吗？能为公司赚钱的就是成功，逆推回去没为公司赚钱的就不是好产品吗？许多产品人气很旺但是并不要赚钱，只是用来市场卡位的，这样不算好产品吗？这是运营的思路，不是产品经理的思路。最后一个答案，长得好看的产品，那是美工的思路，也不是产品经理的思路，甚至是易学易用，也只是交互设计师的思路，同样不是产品经理的思路。这些答案我也曾一二三的列出来，自以为得计，但其实都只证明了自己的无知，对产品工作缺乏思考而已。</p>\r\n<p>那什么才是产品经理的思路？对于上面的问题，目前为止我得到的最好的答案，是简单的三条，这三条或许并不是标准答案，但折射出来的道理，可以供每一个想进入产品行列的同仁借鉴：</p>\r\n<ol>\r\n<li><p>一个好的产品，首先要解决用户的需求；</p>\r\n</li><li><p>一个好的产品，其次是要有黏性；</p>\r\n</li><li><p>一个好的产品，要拥有不错的体验。</p>\r\n</li></ol>\r\n<p>什么产品才是一个好的产品，满足以上三条，就是好的产品。这才是产品经理的思维——透过现象看本质，深度解读一个问题，提炼出问题的规律，并用这个规律来指导产品开发设计的行为。产品经理是用脑工作，不是用手。产品经理的三个关键词：需求、黏性、体验，这三个是产品工作中每天都要挂在嘴边，刻在脑海的。</p>\r\n<p>首先说第一条，需求，这是一个产品之所以被称为产品的前提，产品的本质就是用来解决需求的，黏性和体验是之后的事，如果我给你一个空调，八星八钻，黄金面板，极富情怀，最先进的XX工艺，按下按钮就播放你喜欢的音乐，但是我告诉你，它是没有制冷和制热功能的，你觉得它是一个成功的 产品么？所以说，一个好的产品，或者是说成功的产品，一定要首先解决用户的某种需求，或者是更好的解决了别的产品已经解决了的需求，这就是好产品的第一条标准。看起来像废话，但是这就是抽象出来的规律，也是无可辩驳的事实。</p>\r\n<p>第二条，黏性，这是一个成功产品的另一个典型特点。一个成功的产品，一定是不断被用户想起的产品，一旦用户产生了某种需求，就能想起你，这就是一个好的产品。有黏性的产品一定是很好的解决了某种需求，而且做到了竞品没有的高度。用户用了一次就不再使用，说明你的产品并不好，或者说干脆就是定位有了问题。QQ的黏性为什么那么强？为什么中国人喜欢用百度，为什么许多产品看似概念不错，体验也没什么硬伤，却如同昙花一现？就是在培养用户黏性上面没有做好。所以解决了用户某种需求的产品，并不一定就是好产品，还需要被用户不停的想起，从这个角度说，一个漂亮性感、能解决你生理需求的女人和一个能和你相濡以沫让你感受到被爱的女人，谁优谁劣，高下立判。</p>\r\n<p>第三条，优秀的用户体验，这也是一个成功产品的典型特点。我曾以为这是产品经理的全部，后来我才明白，其实所谓优秀的用户体验是交互设计师要考虑的问题，而交互设计只是产品经理工作的小小一环。优秀的用户体验可以为产品加分，但是绝对不是最重要的，想当年互联网草创时期，产品体验一塌糊涂，但是用户依然趋之若鹜，因为你的产品解决了用户的需求，犹如一把普通的锄头，可能既不好看又不省力，但却当之无愧是一个好产品，因为它解决了农民种地的需求，只要农民种地就会重复使用。当然，如果你做了一把漂亮锄头的确是更不错，但是那其实不是最本质的问题。</p>\r\n<p>这三条规律，是一个产品作为一个好产品的根本特点，是三条放之四海而皆准的规律，而不是主观的某种看法或停留在表层的认知，这就是产品经理应有的能力——从复杂的现象中抽象出普世规律，然后利用这个规律指导产品的方向。</p>\r\n', '本人曾面试产品经理几十次，败绩无数，后也面过一些产品经理，误入此题，上一些感想。\r\n\r\n产品经理是一个以软实力为主的岗位，不需要你设计，不需要你写代码，需要你干什么，心里必须有数。把这个说在前面，是要提醒你，产品经理虽然不一定需要你上硬货，但你千万别把面试当做一个扯蛋的过程，虽然“你觉得什么样的产品是好产品？”这样的问题看起来是面试官在和你扯蛋，但是这其实是一个非常专业的问题。首先一定要把产品经理当成一门专业来看待，要把面试当做一个规范的行为来看待，万不可随意瞎扯。\r\n\r\n压力测试是给外行的人做的，对于专业的人来说，讨论专业的事，任何问题都不要归结于压力测试的思路去。以逻辑和说服力征服对方，产品工作就是一个先自己想明白，再不断说服所有人的过程。\r\n\r\n在知乎另外一个关于面试豆瓣产品经理的问题上，我们可以看到一个失败的产品面试过程，失败在哪里，没有人给出解读。产品经理面试经常犯一个错误，就是认为问题没有标准答案，诚然，产品工作中的确没有全对全错，但是面试是一场考试，是考试必定有高下，有高下就必定有标准，接近那个标准的，就是正确答案，远离那个标准的，就是错误答案。面试的过程，就是让自己的回答无限接近标准答案的过程。\r\n\r\n回到那个豆瓣面试，里面有一个问题我也曾经常遇到，“Q:你觉得什么样的产品是一个成功的产品？”或者是“成功的产品有什么标准？”。你可以这样答：好玩的产品就是成功的、用户人数多的就是成功的、能为公司赚钱的就是成功的、UI做得漂亮就是成功的。当然从扯蛋的角度看，这样的回答本没有问题，但是如果是产品经理面试，这样的回答要打零分。为什么呢？不要忘记你的身份，是要来面试产品经理，好玩的产品一定成功吗？成功，但这是从用户的角度看问题，用户人数多就成功吗？这仿佛是一个聪明的答案，但其实是很容易被问死的，多少用户算多？用户人数多就一定很成功吗？能为公司赚钱的就是成功，逆推回去没为公司赚钱的就不是好产品吗？许多产品人气很旺但是并不要赚钱，只是用来市场卡位的，这样不算好产品吗？这是运营的思路，不是产品经理的思路。最后一个答案，长得好看的产品，那是美工的思路，也不是产品经理的思路，甚至是易学易用，也只是交互设计师的思路，同样不是产品经理的思路。这些答案我也曾一二三的列出来，自以为得计，但其实都只证明了自己的无知，对产品工作缺乏思考而已。\r\n\r\n那什么才是产品经理的思路？对于上面的问题，目前为止我得到的最好的答案，是简单的三条，这三条或许并不是标准答案，但折射出来的道理，可以供每一个想进入产品行列的同仁借鉴：\r\n\r\n1. 一个好的产品，首先要解决用户的需求；\r\n\r\n2. 一个好的产品，其次是要有黏性；\r\n\r\n3. 一个好的产品，要拥有不错的体验。\r\n\r\n什么产品才是一个好的产品，满足以上三条，就是好的产品。这才是产品经理的思维——透过现象看本质，深度解读一个问题，提炼出问题的规律，并用这个规律来指导产品开发设计的行为。产品经理是用脑工作，不是用手。产品经理的三个关键词：需求、黏性、体验，这三个是产品工作中每天都要挂在嘴边，刻在脑海的。\r\n\r\n首先说第一条，需求，这是一个产品之所以被称为产品的前提，产品的本质就是用来解决需求的，黏性和体验是之后的事，如果我给你一个空调，八星八钻，黄金面板，极富情怀，最先进的XX工艺，按下按钮就播放你喜欢的音乐，但是我告诉你，它是没有制冷和制热功能的，你觉得它是一个成功的 产品么？所以说，一个好的产品，或者是说成功的产品，一定要首先解决用户的某种需求，或者是更好的解决了别的产品已经解决了的需求，这就是好产品的第一条标准。看起来像废话，但是这就是抽象出来的规律，也是无可辩驳的事实。\r\n\r\n第二条，黏性，这是一个成功产品的另一个典型特点。一个成功的产品，一定是不断被用户想起的产品，一旦用户产生了某种需求，就能想起你，这就是一个好的产品。有黏性的产品一定是很好的解决了某种需求，而且做到了竞品没有的高度。用户用了一次就不再使用，说明你的产品并不好，或者说干脆就是定位有了问题。QQ的黏性为什么那么强？为什么中国人喜欢用百度，为什么许多产品看似概念不错，体验也没什么硬伤，却如同昙花一现？就是在培养用户黏性上面没有做好。所以解决了用户某种需求的产品，并不一定就是好产品，还需要被用户不停的想起，从这个角度说，一个漂亮性感、能解决你生理需求的女人和一个能和你相濡以沫让你感受到被爱的女人，谁优谁劣，高下立判。\r\n\r\n第三条，优秀的用户体验，这也是一个成功产品的典型特点。我曾以为这是产品经理的全部，后来我才明白，其实所谓优秀的用户体验是交互设计师要考虑的问题，而交互设计只是产品经理工作的小小一环。优秀的用户体验可以为产品加分，但是绝对不是最重要的，想当年互联网草创时期，产品体验一塌糊涂，但是用户依然趋之若鹜，因为你的产品解决了用户的需求，犹如一把普通的锄头，可能既不好看又不省力，但却当之无愧是一个好产品，因为它解决了农民种地的需求，只要农民种地就会重复使用。当然，如果你做了一把漂亮锄头的确是更不错，但是那其实不是最本质的问题。\r\n\r\n这三条规律，是一个产品作为一个好产品的根本特点，是三条放之四海而皆准的规律，而不是主观的某种看法或停留在表层的认知，这就是产品经理应有的能力——从复杂的现象中抽象出普世规律，然后利用这个规律指导产品的方向。\r\n\r\n', '', '2', '0', '0', '0', '0', '2018-11-02 13:13:16', '7', '2', '15248859107335YA2M37', '15248859107335YA2M37', '2018-06-02 13:13:16', '0');
INSERT INTO `post` VALUES ('1527916595358VXADVSK', '原画师要具备哪些特点？原画师要掌握那些知识？', '现在很多朋友都在学习原画，昨天小编分享了零基础朋友在学习原画的时间该怎么去学习?零基础学习原画的技巧，今天小编为大家带来的是我们成为了一名原画师要具备哪些特点？原画师又要掌握哪些基础的知识呢？今天小编带你走进原画师的世界。\r\n原画师必须具备的特点：\r\n1）具有较高的审美素养，较强的视觉感受功能里和视觉表现能力；\r\n2）掌握动漫画的基本原理和基础理论，并能在实践中融会贯通；\r\n3）掌握动漫画的各种表现语言和表现技巧，有较强的专业设计能力和创造能力；\r\n4）能熟练运用计算机进行专业的辅助设计和创作。\r\n\r\n原画师', '<p>现在很多朋友都在学习原画，昨天小编分享了零基础朋友在学习原画的时间该怎么去学习?零基础学习原画的技巧，今天小编为大家带来的是我们成为了一名原画师要具备哪些特点？原画师又要掌握哪些基础的知识呢？今天小编带你走进原画师的世界。<br><img src=\"http://localhost:8080/isay-web/post_photo/1527916477574.jpg\" alt=\"\"></p>\r\n<p>原画师必须具备的特点：</p>\r\n<p>1）具有较高的审美素养，较强的视觉感受功能里和视觉表现能力；</p>\r\n<p>2）掌握动漫画的基本原理和基础理论，并能在实践中融会贯通；</p>\r\n<p>3）掌握动漫画的各种表现语言和表现技巧，有较强的专业设计能力和创造能力；</p>\r\n<p>4）能熟练运用计算机进行专业的辅助设计和创作。</p>\r\n<p><img src=\"http://localhost:8080/isay-web/post_photo/1527916531493.jpg\" alt=\"\"></p>\r\n<p>原画师需要掌握的知识：</p>\r\n<p>一、美术基础</p>\r\n<p>美术基础这个是最基本的，大家都知道原画中的基础有多重要，在原画中你的基础的厚度决定你未来的高度，所以，美术基础有多重要不用说大家也知道，我们要通过对角色的姿势进行绘制，人体结构的把握，通过基础的线条练习加强对形体轮廓的勾勒、对色彩理论的了解和色彩运用的方法、讲解构图法则、技巧、构图方式、透视，在实际中掌握方法与技巧、熟悉Photoshop等基本软件操作，然后进行命题创作。</p>\r\n<p>二、角色设计</p>\r\n<p>对一名原画师来说，角色设计是一名原画师必须要知道的知识，这个就像美术基础一样，学习角色搭配相应的服饰、道具、以及纹理，还有基本的表现手法。了解原画的设计流程，把握色性格、身份特点，将角色应用自如。</p>\r\n<p>三、场景设计</p>\r\n<p>在原画师设计完角色之后，就是场景设计，在加上之前的基础，这三个对原画师来说是至关重要的。场景设计是要学习不同时代、不同民族、不同文化背景下的建筑设计风格及元素运用技巧，如何运用笔刷已达到更快更出色的效果。学习不同风格场景的设计理念，如何搭建一个自己想要的世界。学习如何通过光影、色彩布局和细节等来创造具有恐惧感、视觉冲击力的概念场景。</p>\r\n', '现在很多朋友都在学习原画，昨天小编分享了零基础朋友在学习原画的时间该怎么去学习?零基础学习原画的技巧，今天小编为大家带来的是我们成为了一名原画师要具备哪些特点？原画师又要掌握哪些基础的知识呢？今天小编带你走进原画师的世界。\r\n![](http://localhost:8080/isay-web/post_photo/1527916477574.jpg)\r\n\r\n原画师必须具备的特点：\r\n\r\n1）具有较高的审美素养，较强的视觉感受功能里和视觉表现能力；\r\n\r\n2）掌握动漫画的基本原理和基础理论，并能在实践中融会贯通；\r\n\r\n3）掌握动漫画的各种表现语言和表现技巧，有较强的专业设计能力和创造能力；\r\n\r\n4）能熟练运用计算机进行专业的辅助设计和创作。\r\n\r\n![](http://localhost:8080/isay-web/post_photo/1527916531493.jpg)\r\n\r\n原画师需要掌握的知识：\r\n\r\n一、美术基础\r\n\r\n美术基础这个是最基本的，大家都知道原画中的基础有多重要，在原画中你的基础的厚度决定你未来的高度，所以，美术基础有多重要不用说大家也知道，我们要通过对角色的姿势进行绘制，人体结构的把握，通过基础的线条练习加强对形体轮廓的勾勒、对色彩理论的了解和色彩运用的方法、讲解构图法则、技巧、构图方式、透视，在实际中掌握方法与技巧、熟悉Photoshop等基本软件操作，然后进行命题创作。\r\n\r\n二、角色设计\r\n\r\n对一名原画师来说，角色设计是一名原画师必须要知道的知识，这个就像美术基础一样，学习角色搭配相应的服饰、道具、以及纹理，还有基本的表现手法。了解原画的设计流程，把握色性格、身份特点，将角色应用自如。\r\n\r\n三、场景设计\r\n\r\n在原画师设计完角色之后，就是场景设计，在加上之前的基础，这三个对原画师来说是至关重要的。场景设计是要学习不同时代、不同民族、不同文化背景下的建筑设计风格及元素运用技巧，如何运用笔刷已达到更快更出色的效果。学习不同风格场景的设计理念，如何搭建一个自己想要的世界。学习如何通过光影、色彩布局和细节等来创造具有恐惧感、视觉冲击力的概念场景。\r\n\r\n', 'http://localhost:8080/isay-web/post_photo/1527916477574.jpg', '4', '0', '0', '0', '1', '2018-11-02 13:16:35', '7', '3', '15248859107335YA2M37', '15248859107335YA2M37', '2018-06-02 13:16:35', '0');
INSERT INTO `post` VALUES ('1527916795652ZR8W1S3', '【供应链金融】一文全面深度分析供应链金融精华', '不同的行业，不同的方式，不同的速度，相同的却是双向的渗透和融合。供应链金融正是产业资本与金融资本跨界的融合。或迅疾如风、或激烈如火、或柔韧如水，跨界融合，正孕育全新的商业逻辑和投资机会。\r\n供应链金融作为产业模式升级的自然演化，“从产业中来，到金融中去”，具有深厚的行业根基，颠覆了传统金融“基于金融而金融”的范式，打开另一扇窗，兼具金融的爆发力和产业的持久性。\r\n如何评价供应链金融的业务质量？我们提出五维模型：大产业、弱上下游、强控制力、低成本与高杠杆、标准化。大产业是指产业空间大，不易触碰天花板；', '<p>不同的行业，不同的方式，不同的速度，相同的却是双向的渗透和融合。供应链金融正是产业资本与金融资本跨界的融合。或迅疾如风、或激烈如火、或柔韧如水，跨界融合，正孕育全新的商业逻辑和投资机会。</p>\r\n<p>供应链金融作为产业模式升级的自然演化，“从产业中来，到金融中去”，具有深厚的行业根基，颠覆了传统金融“基于金融而金融”的范式，打开另一扇窗，兼具金融的爆发力和产业的持久性。</p>\r\n<h3 id=\"h3--\"><a name=\"如何评价供应链金融的业务质量？\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>如何评价供应链金融的业务质量？</h3><p>我们提出五维模型：大产业、弱上下游、强控制力、低成本与高杠杆、标准化。大产业是指产业空间大，不易触碰天花板；弱上下游是指客户端中，至少有一环较为弱势，无法从银行获得廉价资金；强控制力是指线上具有真实交易数据和征信、线下拥有物流仓储作后盾，从而控制风险；低成本是指资金的成本低，让供应链金融有利可图而又不过度增加融资方负担，高杠杆是一定本金投入能撬动较大资产体量；标准化是指用于融资的抵押品（抵押）相对标准化，有公允市场，即便出险，也能快速出清。如果同时具备五大要素，则供应链金融水到渠成。</p>\r\n<p>潜在标的有哪些？看下文！根据五维模型，大宗商品、行业或区域龙头、行业信息化服务商、电商平台、专业市场等五大领域是供应链金融的沃土。</p>\r\n<h3 id=\"h3-1-\"><a name=\"1. 抢滩金融服务空白\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>1. 抢滩金融服务空白</h3><p>中小企业融资难一直是社会顽疾，在经济换挡期，尤为如此。扩大再生产，要么通过内生式积累，要么借道民间高利贷。年化8%-20%之间的融资成本，成为传统金融的盲点，也因此成为金融创新的主战场。</p>\r\n<p>供应链金融最大创新在于填补8%-20%的融资利率空白，打开中小企业融资阀门。理论上银行是中小企业最理想的融资对像，成本在6%-8%之间。但从收益风险配比角度看，银行更愿意将资金大门向大型企业敞开，而不愿承受过高风险。</p>\r\n<p>中小企业被迫转向民间借贷，而民间借贷的平均利率在27%左右，高企的融资成本挤压了中小企业的生存空间，减少了中小企业的投资，不利于整个供应链的发展。</p>\r\n<p>8%-20%融资服务的空白，背后折射的是金融服务的结构性缺失，以及社会资本对中小企业所要求的不合理的过高风险补偿。</p>\r\n<p>和传统非银机构相比,供应链金融具备太多优势：</p>\r\n<p>1）供应链金融依托在产业多年的浸淫，风控端天然具备优势；</p>\r\n<p>2）如果说非银机构做的是纯粹金融，则供应链金融则是在试图构建金融生态；</p>\r\n<p>3）在供应链金融体系中，各非银机构均成为体系中一部分；</p>\r\n<p>4）供应链金融本质上属于大数据金融，延展性更佳。</p>\r\n<h3 id=\"h3-2-\"><a name=\"2. 痛点孕育变革\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>2. 痛点孕育变革</h3><p>宏观经济下行大背景下，中小企业生存状况堪忧，尤其是融资难问题更为突出。一直以来，由于信用缺失、固定资产等抵押担保品少、财务信息不透明等，中小企业的融资是个顽疾，近年来尽管国家出台了多项舒缓中小企业融资难的举措，但银行等主流资金供应方惜贷现象仍未有效改善，中小企业要么通过内生积累，要么高成本通过非银行金融机构获得资金。</p>\r\n<p>中小企业痛点：融资难、融资贵、融资乱、融资险。多层次金融市场的缺失，使得中小企业暴露于无主流金融机构覆盖的尴尬境地，中小企业融资也多是“富贵险中求”，融资成本高企，且相应金融服务机构散、乱，对中小企业稳定经营造成重大影响。</p>\r\n<p>从另一方面讲，针对中小企业的金融服务仍是一片尚未被充分开发的大市场，新的金融模式、新的技术应用都可能彻底启动行业崛起阀门。</p>\r\n<p>除了融资难，中小企业资金亦受到行业挤占：</p>\r\n<p>1）营收账款总规模超16万亿。以供应链上游企业为例，截止2012年应收账款余额已经达到16.6万亿，中小企业现金压力巨大；</p>\r\n<p>2）赊销期的延长。根据《2014科法斯中国企业信用风险报告》，2013年31.7%的企业赊销期大于60天，明显高于2012年20.3%的企业占比，总体信用进一步恶化的趋势非常明显。</p>\r\n<h3 id=\"h3-3-\"><a name=\"3. 核心企业“转型痛”\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>3. 核心企业“转型痛”</h3><p>中国正处于经济的换挡期，行业产能过程、转型压力自不必多讲，但就产业中企业来讲，由于自身优劣势禀赋不同，在转型大潮中表现出不同的诉求。小部分掌握了产业核心资源的企业，希望利用金融业务将其在行业中长期建立起来的优势变现；大部分中小微企业则对解决融资问题具有更强的偏好。</p>\r\n<p>无疑，供应链金融对整个产业链的再升级都是战略级突破口。</p>\r\n<p>产能过剩已经成为行业性趋势，核心企业亦未能幸免。如：1）粗钢产能利用率2014年降到最低点70%，产能严重过剩；2）截至2015年1月，工业企业利润总额累计同比负增长4.23%，盈利能力持续下滑。在行业性大趋势下，核心企业盈利能力也大幅下降。</p>\r\n<h3 id=\"h3-4-\"><a name=\"4. 直击痛点，多方共赢\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>4. 直击痛点，多方共赢</h3><p>行业层面无阻力，供应链金融的生长将极为舒展。行业趋势总是向阻力最小的方向发展，供应链金融无论对于核心企业还是中小微企业，乃至物流企业都具备明显的益处，利益的产生并非存量之间的博弈，而是增量的创造。同时互联网的发展更为供应链金融提供了难得的时代背景，多方共赢提供充足动力。</p>\r\n<p>供应链金融如何开展？结论极其简洁：核心企业的“转型痛”创造供给，中小企业的“融资痛”创造需求，而两者的碰撞必将催生出新的蓝海业务。</p>\r\n', '不同的行业，不同的方式，不同的速度，相同的却是双向的渗透和融合。供应链金融正是产业资本与金融资本跨界的融合。或迅疾如风、或激烈如火、或柔韧如水，跨界融合，正孕育全新的商业逻辑和投资机会。\r\n\r\n供应链金融作为产业模式升级的自然演化，“从产业中来，到金融中去”，具有深厚的行业根基，颠覆了传统金融“基于金融而金融”的范式，打开另一扇窗，兼具金融的爆发力和产业的持久性。\r\n\r\n### 如何评价供应链金融的业务质量？\r\n\r\n我们提出五维模型：大产业、弱上下游、强控制力、低成本与高杠杆、标准化。大产业是指产业空间大，不易触碰天花板；弱上下游是指客户端中，至少有一环较为弱势，无法从银行获得廉价资金；强控制力是指线上具有真实交易数据和征信、线下拥有物流仓储作后盾，从而控制风险；低成本是指资金的成本低，让供应链金融有利可图而又不过度增加融资方负担，高杠杆是一定本金投入能撬动较大资产体量；标准化是指用于融资的抵押品（抵押）相对标准化，有公允市场，即便出险，也能快速出清。如果同时具备五大要素，则供应链金融水到渠成。\r\n\r\n潜在标的有哪些？看下文！根据五维模型，大宗商品、行业或区域龙头、行业信息化服务商、电商平台、专业市场等五大领域是供应链金融的沃土。\r\n\r\n### 1. 抢滩金融服务空白\r\n\r\n中小企业融资难一直是社会顽疾，在经济换挡期，尤为如此。扩大再生产，要么通过内生式积累，要么借道民间高利贷。年化8%-20%之间的融资成本，成为传统金融的盲点，也因此成为金融创新的主战场。\r\n\r\n供应链金融最大创新在于填补8%-20%的融资利率空白，打开中小企业融资阀门。理论上银行是中小企业最理想的融资对像，成本在6%-8%之间。但从收益风险配比角度看，银行更愿意将资金大门向大型企业敞开，而不愿承受过高风险。\r\n\r\n中小企业被迫转向民间借贷，而民间借贷的平均利率在27%左右，高企的融资成本挤压了中小企业的生存空间，减少了中小企业的投资，不利于整个供应链的发展。\r\n\r\n8%-20%融资服务的空白，背后折射的是金融服务的结构性缺失，以及社会资本对中小企业所要求的不合理的过高风险补偿。\r\n\r\n和传统非银机构相比,供应链金融具备太多优势：\r\n\r\n1）供应链金融依托在产业多年的浸淫，风控端天然具备优势；\r\n\r\n2）如果说非银机构做的是纯粹金融，则供应链金融则是在试图构建金融生态；\r\n\r\n3）在供应链金融体系中，各非银机构均成为体系中一部分；\r\n\r\n4）供应链金融本质上属于大数据金融，延展性更佳。\r\n\r\n### 2. 痛点孕育变革\r\n\r\n宏观经济下行大背景下，中小企业生存状况堪忧，尤其是融资难问题更为突出。一直以来，由于信用缺失、固定资产等抵押担保品少、财务信息不透明等，中小企业的融资是个顽疾，近年来尽管国家出台了多项舒缓中小企业融资难的举措，但银行等主流资金供应方惜贷现象仍未有效改善，中小企业要么通过内生积累，要么高成本通过非银行金融机构获得资金。\r\n\r\n中小企业痛点：融资难、融资贵、融资乱、融资险。多层次金融市场的缺失，使得中小企业暴露于无主流金融机构覆盖的尴尬境地，中小企业融资也多是“富贵险中求”，融资成本高企，且相应金融服务机构散、乱，对中小企业稳定经营造成重大影响。\r\n\r\n从另一方面讲，针对中小企业的金融服务仍是一片尚未被充分开发的大市场，新的金融模式、新的技术应用都可能彻底启动行业崛起阀门。\r\n\r\n除了融资难，中小企业资金亦受到行业挤占：\r\n\r\n1）营收账款总规模超16万亿。以供应链上游企业为例，截止2012年应收账款余额已经达到16.6万亿，中小企业现金压力巨大；\r\n\r\n2）赊销期的延长。根据《2014科法斯中国企业信用风险报告》，2013年31.7%的企业赊销期大于60天，明显高于2012年20.3%的企业占比，总体信用进一步恶化的趋势非常明显。\r\n\r\n### 3. 核心企业“转型痛”\r\n\r\n中国正处于经济的换挡期，行业产能过程、转型压力自不必多讲，但就产业中企业来讲，由于自身优劣势禀赋不同，在转型大潮中表现出不同的诉求。小部分掌握了产业核心资源的企业，希望利用金融业务将其在行业中长期建立起来的优势变现；大部分中小微企业则对解决融资问题具有更强的偏好。\r\n\r\n无疑，供应链金融对整个产业链的再升级都是战略级突破口。\r\n\r\n产能过剩已经成为行业性趋势，核心企业亦未能幸免。如：1）粗钢产能利用率2014年降到最低点70%，产能严重过剩；2）截至2015年1月，工业企业利润总额累计同比负增长4.23%，盈利能力持续下滑。在行业性大趋势下，核心企业盈利能力也大幅下降。\r\n\r\n### 4. 直击痛点，多方共赢\r\n\r\n行业层面无阻力，供应链金融的生长将极为舒展。行业趋势总是向阻力最小的方向发展，供应链金融无论对于核心企业还是中小微企业，乃至物流企业都具备明显的益处，利益的产生并非存量之间的博弈，而是增量的创造。同时互联网的发展更为供应链金融提供了难得的时代背景，多方共赢提供充足动力。\r\n\r\n供应链金融如何开展？结论极其简洁：核心企业的“转型痛”创造供给，中小企业的“融资痛”创造需求，而两者的碰撞必将催生出新的蓝海业务。\r\n\r\n', '', '2', '0', '0', '0', '0', '2018-11-02 13:19:56', '7', '7', '15248859107335YA2M37', '15248859107335YA2M37', '2018-06-02 13:19:56', '0');
INSERT INTO `post` VALUES ('1528255724866WGPRAGI', '2018校招笔试真题汇总 ', '科大讯飞：2018秋招笔试科大讯飞java笔试试题https://www.nowcoder.com/discuss/67684?type=2&order=3&pos=13&page=0\r\n锐捷：2018秋招锐捷笔试试题https://www.nowcoder.com/discuss/67760?type=2&order=3&pos=8&page=0锐捷2018秋招笔试题https://www.nowcoder.com/discuss/80796?type=2&order=3&pos=30&page', '<p>科大讯飞：<br>2018秋招笔试科大讯飞java笔试试题<br><a href=\"https://www.nowcoder.com/discuss/67684?type=2&amp;order=3&amp;pos=13&amp;page=0\">https://www.nowcoder.com/discuss/67684?type=2&amp;order=3&amp;pos=13&amp;page=0</a></p>\r\n<p>锐捷：<br>2018秋招锐捷笔试试题<br><a href=\"https://www.nowcoder.com/discuss/67760?type=2&amp;order=3&amp;pos=8&amp;page=0\">https://www.nowcoder.com/discuss/67760?type=2&amp;order=3&amp;pos=8&amp;page=0</a><br>锐捷2018秋招笔试题<br><a href=\"https://www.nowcoder.com/discuss/80796?type=2&amp;order=3&amp;pos=30&amp;page=0\">https://www.nowcoder.com/discuss/80796?type=2&amp;order=3&amp;pos=30&amp;page=0</a></p>\r\n<p>58同城：<br>58同城2018秋招前端笔试试题分享</p>\r\n<p><a href=\"https://www.nowcoder.com/discuss/67508?type=2&amp;order=3&amp;pos=21&amp;page=1\">https://www.nowcoder.com/discuss/67508?type=2&amp;order=3&amp;pos=21&amp;page=1</a></p>\r\n<p>2018秋招58同城笔试题分享</p>\r\n<p><a href=\"https://www.nowcoder.com/discuss/69136?type=0&amp;order=3&amp;pos=6&amp;page=0\">https://www.nowcoder.com/discuss/69136?type=0&amp;order=3&amp;pos=6&amp;page=0</a></p>\r\n<p>阿里巴巴：<br>2018秋招阿里巴巴java笔试试题<br><a href=\"https://www.nowcoder.com/discuss/67379?type=2&amp;order=3&amp;pos=29&amp;page=1\">https://www.nowcoder.com/discuss/67379?type=2&amp;order=3&amp;pos=29&amp;page=1</a><br>阿里巴巴2018秋招正式试题<br><a href=\"https://www.nowcoder.com/discuss/79947?type=2&amp;order=3&amp;pos=103&amp;page=1\">https://www.nowcoder.com/discuss/79947?type=2&amp;order=3&amp;pos=103&amp;page=1</a></p>\r\n<p>途牛：<br>2018秋招途牛笔试试题分享，期待春招offer！<br><a href=\"https://www.nowcoder.com/discuss/68700?type=0&amp;order=3&amp;pos=6&amp;page=0\">https://www.nowcoder.com/discuss/68700?type=0&amp;order=3&amp;pos=6&amp;page=0</a></p>\r\n<p>饿了么：<br>饿了么2018秋招笔试前端试题</p>\r\n<p><a href=\"https://www.nowcoder.com/discuss/68831?type=0&amp;order=3&amp;pos=7&amp;page=0\">https://www.nowcoder.com/discuss/68831?type=0&amp;order=3&amp;pos=7&amp;page=0</a></p>\r\n<p>360<br><a href=\"https://www.nowcoder.com/discuss/68965?type=0&amp;order=3&amp;pos=8&amp;page=0\">https://www.nowcoder.com/discuss/68965?type=0&amp;order=3&amp;pos=8&amp;page=0</a></p>\r\n<p>2018秋招360笔试题分享，求春招offer</p>\r\n<p><a href=\"https://www.nowcoder.com/discuss/69239?type=2&amp;order=3&amp;pos=7&amp;page=0\">https://www.nowcoder.com/discuss/69239?type=2&amp;order=3&amp;pos=7&amp;page=0</a></p>\r\n<p>freelwheel<br>2018秋招freewheel java笔试题，祝大家春招好运</p>\r\n<p><a href=\"https://www.nowcoder.com/discuss/69430?type=0&amp;order=3&amp;pos=6&amp;page=0\">https://www.nowcoder.com/discuss/69430?type=0&amp;order=3&amp;pos=6&amp;page=0</a></p>\r\n<p>哔哩哔哩<br><a href=\"https://www.nowcoder.com/discuss/69560?type=0&amp;order=3&amp;pos=6&amp;page=0\">https://www.nowcoder.com/discuss/69560?type=0&amp;order=3&amp;pos=6&amp;page=0</a><br>bilibili 2018秋招试题<br><a href=\"https://www.nowcoder.com/discuss/79943?type=2&amp;order=3&amp;pos=105&amp;page=1\">https://www.nowcoder.com/discuss/79943?type=2&amp;order=3&amp;pos=105&amp;page=1</a></p>\r\n<p>贝贝<br>贝贝2018秋招测评题，已拿offer</p>\r\n<p><a href=\"https://www.nowcoder.com/discuss/70106?type=0&amp;order=3&amp;pos=6&amp;page=0\">https://www.nowcoder.com/discuss/70106?type=0&amp;order=3&amp;pos=6&amp;page=0</a><br>分享求好运~2018秋招贝贝客户端笔试题<br><a href=\"https://www.nowcoder.com/discuss/70519\">https://www.nowcoder.com/discuss/70519</a></p>\r\n<p>多益网络<br>多益2018秋招笔试题，回馈大家</p>\r\n<p><a href=\"https://www.nowcoder.com/discuss/70676?type=0&amp;order=3&amp;pos=7&amp;page=0\">https://www.nowcoder.com/discuss/70676?type=0&amp;order=3&amp;pos=7&amp;page=0</a></p>\r\n<p>多益网络2018秋招试题</p>\r\n<p><a href=\"https://www.nowcoder.com/discuss/71073?type=0&amp;order=3&amp;pos=6&amp;page=0\">https://www.nowcoder.com/discuss/71073?type=0&amp;order=3&amp;pos=6&amp;page=0</a></p>\r\n<p>2018秋招多益网络iq测试题（一）</p>\r\n<p><a href=\"https://www.nowcoder.com/discuss/78012\">https://www.nowcoder.com/discuss/78012</a></p>\r\n<p>2018秋招多益网络iq测试题（二）</p>\r\n<p><a href=\"https://www.nowcoder.com/discuss/78164?type=2&amp;order=3&amp;pos=16&amp;page=0\">https://www.nowcoder.com/discuss/78164?type=2&amp;order=3&amp;pos=16&amp;page=0</a></p>\r\n<p>今日头条<br>2018秋招今日头条测评题，分享给大家~</p>\r\n<p><a href=\"https://www.nowcoder.com/discuss/72131?type=0&amp;order=3&amp;pos=6&amp;page=0\">https://www.nowcoder.com/discuss/72131?type=0&amp;order=3&amp;pos=6&amp;page=0</a></p>\r\n<p>今日头条2018校招测试开发方向（第一批）</p>\r\n<p><a href=\"https://www.nowcoder.com/test/8537290/summary\">https://www.nowcoder.com/test/8537290/summary</a></p>\r\n<p>今日头条2018校招算法方向（第一批）<br><a href=\"https://www.nowcoder.com/test/8537279/summary\">https://www.nowcoder.com/test/8537279/summary</a></p>\r\n<p>今日头条2018校招大数据方向（第一批）</p>\r\n<p><a href=\"https://www.nowcoder.com/test/8537283/summary\">https://www.nowcoder.com/test/8537283/summary</a></p>\r\n<p>今日头条2018校招测试开发方向（第二批）</p>\r\n<p><a href=\"https://www.nowcoder.com/test/8537269/summary\">https://www.nowcoder.com/test/8537269/summary</a></p>\r\n<p>今日头条2018校招Android方向（第二批）</p>\r\n<p><a href=\"https://www.nowcoder.com/test/8537261/summary\">https://www.nowcoder.com/test/8537261/summary</a></p>\r\n<p>今日头条2018校招ios方向（第二批）</p>\r\n<p><a href=\"https://www.nowcoder.com/test/8537251/summary\">https://www.nowcoder.com/test/8537251/summary</a></p>\r\n<p>今日头条2018校招前端方向（第二批）</p>\r\n<p><a href=\"https://www.nowcoder.com/test/8537237/summary\">https://www.nowcoder.com/test/8537237/summary</a></p>\r\n<p>今日头条2018校招算法方向（第二批）</p>\r\n<p><a href=\"https://www.nowcoder.com/test/8537228/summary\">https://www.nowcoder.com/test/8537228/summary</a></p>\r\n<p>今日头条2018校招大数据方向（第二批）</p>\r\n<p><a href=\"https://www.nowcoder.com/test/8537218/summary\">https://www.nowcoder.com/test/8537218/summary</a></p>\r\n<p>今日头条2018校招后端方向（第二批）</p>\r\n<p><a href=\"https://www.nowcoder.com/test/8537209/summary\">https://www.nowcoder.com/test/8537209/summary</a></p>\r\n<p>今日头条2018校招后端方向（第三批）</p>\r\n<p><a href=\"https://www.nowcoder.com/test/8537140/summary\">https://www.nowcoder.com/test/8537140/summary</a></p>\r\n<p>今日头条2018校招ios方向（第三批）<br><a href=\"https://www.nowcoder.com/test/8537129/summary\">https://www.nowcoder.com/test/8537129/summary</a></p>\r\n<p>今日头条2018校招大数据方向（第三批）<br><a href=\"https://www.nowcoder.com/test/8537109/summary\">https://www.nowcoder.com/test/8537109/summary</a></p>\r\n<p>今日头条2018校招前端方向（第三批）</p>\r\n<p><a href=\"https://www.nowcoder.com/test/8537093/summary\">https://www.nowcoder.com/test/8537093/summary</a></p>\r\n<p>今日头条2018校招Android方向（第三批）</p>\r\n<p><a href=\"https://www.nowcoder.com/test/8537072/summary\">https://www.nowcoder.com/test/8537072/summary</a></p>\r\n<p>今日头条2018校招算法方向（第三批）<br><a href=\"https://www.nowcoder.com/test/8537068/summary\">https://www.nowcoder.com/test/8537068/summary</a></p>\r\n<p>今日头条2018校招测试开发方向（第三批）<br><a href=\"https://www.nowcoder.com/test/8537047/summary\">https://www.nowcoder.com/test/8537047/summary</a></p>\r\n<p>今日头条2018校招Android方向（第四批）</p>\r\n<p><a href=\"https://www.nowcoder.com/test/8537041/summary\">https://www.nowcoder.com/test/8537041/summary</a></p>\r\n<p>今日头条2018校招后端方向（第四批）</p>\r\n<p><a href=\"https://www.nowcoder.com/test/8537039/summary\">https://www.nowcoder.com/test/8537039/summary</a></p>\r\n<p>今日头条2018校招算法方向（第四批）</p>\r\n<p><a href=\"https://www.nowcoder.com/test/8537023/summary\">https://www.nowcoder.com/test/8537023/summary</a></p>\r\n<p>今日头条2018招聘测试开发方向（第四批）</p>\r\n<p><a href=\"https://www.nowcoder.com/test/8536903/summary\">https://www.nowcoder.com/test/8536903/summary</a></p>\r\n<p>今日头条2018校招iOS方向（第四批）</p>\r\n<p><a href=\"https://www.nowcoder.com/test/8536763/summary\">https://www.nowcoder.com/test/8536763/summary</a></p>\r\n<p>今日头条2018校招大数据方向（第四批）</p>\r\n<p><a href=\"https://www.nowcoder.com/test/8536722/summary\">https://www.nowcoder.com/test/8536722/summary</a></p>\r\n<p>今日头条2018校招前端方向（第四批）</p>\r\n<p><a href=\"https://www.nowcoder.com/test/8536639/summary\">https://www.nowcoder.com/test/8536639/summary</a></p>\r\n<p>链家<br>2018秋招链家前端笔试题，晚上考试加油</p>\r\n<p><a href=\"https://www.nowcoder.com/discuss/72559?type=0&amp;order=3&amp;pos=6&amp;page=0\">https://www.nowcoder.com/discuss/72559?type=0&amp;order=3&amp;pos=6&amp;page=0</a></p>\r\n<p>链家2018秋招java笔试题</p>\r\n<p><a href=\"https://www.nowcoder.com/discuss/78509\">https://www.nowcoder.com/discuss/78509</a></p>\r\n<p>去哪儿<br>去哪儿2018秋招前端笔试题，求好运</p>\r\n<p><a href=\"https://www.nowcoder.com/discuss/73058?type=0&amp;order=3&amp;pos=8&amp;page=0\">https://www.nowcoder.com/discuss/73058?type=0&amp;order=3&amp;pos=8&amp;page=0</a><br>去哪儿2018秋招笔试试题<br><a href=\"https://www.nowcoder.com/discuss/80134?type=2&amp;order=3&amp;pos=89&amp;page=0\">https://www.nowcoder.com/discuss/80134?type=2&amp;order=3&amp;pos=89&amp;page=0</a><br>去哪儿 2018校招 软件开发工程师在线考试<br><a href=\"https://www.nowcoder.com/discuss/80136?type=2&amp;order=3&amp;pos=88&amp;page=0\">https://www.nowcoder.com/discuss/80136?type=2&amp;order=3&amp;pos=88&amp;page=0</a></p>\r\n<p>酷狗<br>酷狗java2018秋招笔试题目，谢谢大家捧场</p>\r\n<p><a href=\"https://www.nowcoder.com/discuss/73425?type=2&amp;order=3&amp;pos=8&amp;page=0\">https://www.nowcoder.com/discuss/73425?type=2&amp;order=3&amp;pos=8&amp;page=0</a></p>\r\n<p>联想<br>联想2018秋招java笔试题目，牛客奖品在向我招手~</p>\r\n<p><a href=\"https://www.nowcoder.com/discuss/75053?type=2&amp;order=3&amp;pos=9&amp;page=0\">https://www.nowcoder.com/discuss/75053?type=2&amp;order=3&amp;pos=9&amp;page=0</a></p>\r\n<p>绿盟科技<br>回馈帖：2018秋招绿盟科技测试题</p>\r\n<p><a href=\"https://www.nowcoder.com/discuss/75403\">https://www.nowcoder.com/discuss/75403</a></p>\r\n<p>绿盟科技2018秋招测评</p>\r\n<p><a href=\"https://www.nowcoder.com/discuss/78791?type=2&amp;order=3&amp;pos=19&amp;page=1\">https://www.nowcoder.com/discuss/78791?type=2&amp;order=3&amp;pos=19&amp;page=1</a></p>\r\n<p>美图<br>美图2018秋招java笔试题</p>\r\n<p><a href=\"https://www.nowcoder.com/discuss/78792?type=2&amp;order=3&amp;pos=18&amp;page=1\">https://www.nowcoder.com/discuss/78792?type=2&amp;order=3&amp;pos=18&amp;page=1</a></p>\r\n<p>美图2018秋招客户端测试题</p>\r\n<p><a href=\"https://www.nowcoder.com/discuss/78793?type=2&amp;order=3&amp;pos=17&amp;page=1\">https://www.nowcoder.com/discuss/78793?type=2&amp;order=3&amp;pos=17&amp;page=1</a></p>\r\n<p>美图2018秋招前端试题</p>\r\n<p><a href=\"https://www.nowcoder.com/discuss/78838?type=2&amp;order=3&amp;pos=15&amp;page=1\">https://www.nowcoder.com/discuss/78838?type=2&amp;order=3&amp;pos=15&amp;page=1</a></p>\r\n<p>美团<br>美团点评2018秋招笔试题<br><a href=\"https://www.nowcoder.com/discuss/79070?type=2&amp;order=3&amp;pos=63&amp;page=0\">https://www.nowcoder.com/discuss/79070?type=2&amp;order=3&amp;pos=63&amp;page=0</a></p>\r\n<p>美团点评2018秋招笔试题<br><a href=\"https://www.nowcoder.com/discuss/79070?type=2&amp;order=3&amp;pos=63&amp;page=0\">https://www.nowcoder.com/discuss/79070?type=2&amp;order=3&amp;pos=63&amp;page=0</a><br>美团点评2018秋招测评题目<br><a href=\"https://www.nowcoder.com/discuss/79277?type=2&amp;order=3&amp;pos=52&amp;page=1\">https://www.nowcoder.com/discuss/79277?type=2&amp;order=3&amp;pos=52&amp;page=1</a><br>美团点评2018秋招前端测评<br><a href=\"https://www.nowcoder.com/discuss/79279?type=2&amp;order=3&amp;pos=51&amp;page=1\">https://www.nowcoder.com/discuss/79279?type=2&amp;order=3&amp;pos=51&amp;page=1</a><br>美团点评2018秋招正式题目<br><a href=\"https://www.nowcoder.com/discuss/79393?type=2&amp;order=3&amp;pos=44&amp;page=0\">https://www.nowcoder.com/discuss/79393?type=2&amp;order=3&amp;pos=44&amp;page=0</a></p>\r\n<p>盛大游戏<br>盛大游戏2018秋招Java笔试题<br><a href=\"https://www.nowcoder.com/discuss/79398?type=2&amp;order=3&amp;pos=43&amp;page=0\">https://www.nowcoder.com/discuss/79398?type=2&amp;order=3&amp;pos=43&amp;page=0</a></p>\r\n<p>艺龙<br>艺龙2018秋招Java笔试题<br><a href=\"https://www.nowcoder.com/discuss/79634?type=2&amp;order=3&amp;pos=23&amp;page=0\">https://www.nowcoder.com/discuss/79634?type=2&amp;order=3&amp;pos=23&amp;page=0</a><br>艺龙2018秋招前端试题<br><a href=\"https://www.nowcoder.com/discuss/79635?type=2&amp;order=3&amp;pos=22&amp;page=0\">https://www.nowcoder.com/discuss/79635?type=2&amp;order=3&amp;pos=22&amp;page=0</a></p>\r\n<p>猪八戒<br>猪八戒2018秋招Java笔试<br><a href=\"https://www.nowcoder.com/discuss/79730?type=2&amp;order=3&amp;pos=16&amp;page=0\">https://www.nowcoder.com/discuss/79730?type=2&amp;order=3&amp;pos=16&amp;page=0</a><br>猪八戒2018秋招前端试题<br><a href=\"https://www.nowcoder.com/discuss/79732?type=2&amp;order=3&amp;pos=15&amp;page=1\">https://www.nowcoder.com/discuss/79732?type=2&amp;order=3&amp;pos=15&amp;page=1</a></p>\r\n<p>eBay<br>eBay2018秋招Java试题<br><a href=\"https://www.nowcoder.com/discuss/79945?type=2&amp;order=3&amp;pos=104&amp;page=0\">https://www.nowcoder.com/discuss/79945?type=2&amp;order=3&amp;pos=104&amp;page=0</a></p>\r\n<p>高新兴<br>高新兴 2018秋招笔试试题<br><a href=\"https://www.nowcoder.com/discuss/80137?type=2&amp;order=3&amp;pos=87&amp;page=1\">https://www.nowcoder.com/discuss/80137?type=2&amp;order=3&amp;pos=87&amp;page=1</a></p>\r\n<p>百度<br>百度2018秋招客户端试题</p>\r\n<p><a href=\"https://www.nowcoder.com/discuss/80355?type=2&amp;order=3&amp;pos=67&amp;page=0\">https://www.nowcoder.com/discuss/80355?type=2&amp;order=3&amp;pos=67&amp;page=0</a></p>\r\n<p>百度2018秋招产品运营笔试试卷问答题</p>\r\n<p><a href=\"https://www.nowcoder.com/test/10613730/summary\">https://www.nowcoder.com/test/10613730/summary</a></p>\r\n<p>趣店<br>趣店2018秋招笔试题目<br><a href=\"https://www.nowcoder.com/discuss/80554?type=2&amp;order=3&amp;pos=50&amp;page=0\">https://www.nowcoder.com/discuss/80554?type=2&amp;order=3&amp;pos=50&amp;page=0</a></p>\r\n<p>神州付<br>神州付2018秋招笔试试题<br><a href=\"https://www.nowcoder.com/discuss/80884?type=2&amp;order=3&amp;pos=18&amp;page=1\">https://www.nowcoder.com/discuss/80884?type=2&amp;order=3&amp;pos=18&amp;page=1</a></p>\r\n<p>搜狗<br>搜狗2018秋招前端试题</p>\r\n<p><a href=\"https://www.nowcoder.com/discuss/80975?type=2&amp;order=3&amp;pos=11&amp;page=0\">https://www.nowcoder.com/discuss/80975?type=2&amp;order=3&amp;pos=11&amp;page=0</a><br>搜狗2018秋招Java笔试试题<br><a href=\"https://www.nowcoder.com/discuss/81137?type=2&amp;order=3&amp;pos=123&amp;page=1\">https://www.nowcoder.com/discuss/81137?type=2&amp;order=3&amp;pos=123&amp;page=1</a><br>搜狗2018秋招Java笔试题<br><a href=\"https://www.nowcoder.com/discuss/81135?type=2&amp;order=3&amp;pos=124&amp;page=0\">https://www.nowcoder.com/discuss/81135?type=2&amp;order=3&amp;pos=124&amp;page=0</a><br>搜狗2018秋招Java客户端试题<br><a href=\"https://www.nowcoder.com/discuss/81449?type=2&amp;order=3&amp;pos=94&amp;page=0\">https://www.nowcoder.com/discuss/81449?type=2&amp;order=3&amp;pos=94&amp;page=0</a></p>\r\n<p>搜狐<br>搜狐2018秋招第一批-社交产品中心-设计类试卷</p>\r\n<p><a href=\"https://www.nowcoder.com/test/10614549/summary\">https://www.nowcoder.com/test/10614549/summary</a></p>\r\n<p>搜狐2018秋招第一批-社交产品中心-狐友产品专员及邮箱产品经理</p>\r\n<p><a href=\"https://www.nowcoder.com/test/10614529/summary\">https://www.nowcoder.com/test/10614529/summary</a></p>\r\n<p>搜狐2018秋招第一批-搜狐媒体产品类试卷</p>\r\n<p><a href=\"https://www.nowcoder.com/test/10614456/summary\">https://www.nowcoder.com/test/10614456/summary</a></p>\r\n<p>搜狐2018秋招第一批-搜狐媒体内容运营类试卷</p>\r\n<p><a href=\"https://www.nowcoder.com/test/10614439/summary\">https://www.nowcoder.com/test/10614439/summary</a></p>\r\n<p>搜狐2018秋招第一批-搜狐焦点非技术类试卷</p>\r\n<p><a href=\"https://www.nowcoder.com/test/10614388/summary\">https://www.nowcoder.com/test/10614388/summary</a></p>\r\n<p>搜狐2018秋招第一批-社交产品中心-狐友运营专员及产品经理运营方向试卷</p>\r\n<p><a href=\"https://www.nowcoder.com/test/10614281/summary\">https://www.nowcoder.com/test/10614281/summary</a></p>\r\n<p>搜狐2018秋招第一批社交产品中心-内容运营专员试卷</p>\r\n<p><a href=\"https://www.nowcoder.com/test/10614250/summary\">https://www.nowcoder.com/test/10614250/summary</a></p>\r\n<p>搜狐2018秋招技术类试卷</p>\r\n<p><a href=\"https://www.nowcoder.com/test/10614057/summary\">https://www.nowcoder.com/test/10614057/summary</a></p>\r\n<p>搜狐2018秋招第二批-社交产品中心-狐友产品专员及邮箱产品经理</p>\r\n<p><a href=\"https://www.nowcoder.com/test/10618056/summary\">https://www.nowcoder.com/test/10618056/summary</a></p>\r\n<p>搜狐2018秋招第二批-社交产品中心-狐友运营专员及产品经理运营</p>\r\n<p><a href=\"https://www.nowcoder.com/test/10617860/summary\">https://www.nowcoder.com/test/10617860/summary</a></p>\r\n<p>搜狐2018秋招第二批-社交产品中心-内容运营专员试卷</p>\r\n<p><a href=\"https://www.nowcoder.com/test/10617841/summary\">https://www.nowcoder.com/test/10617841/summary</a></p>\r\n<p>搜狐2018秋招第二批-社交产品中心-设计类试卷</p>\r\n<p><a href=\"https://www.nowcoder.com/test/10617827/summary\">https://www.nowcoder.com/test/10617827/summary</a></p>\r\n<p>搜狐2018秋招第二批-社交产品中心-测试工程师试卷</p>\r\n<p><a href=\"https://www.nowcoder.com/test/10617815/summary\">https://www.nowcoder.com/test/10617815/summary</a></p>\r\n<p>搜狐2018秋招第二批-搜狐媒体内容运营类试卷</p>\r\n<p><a href=\"https://www.nowcoder.com/test/10617729/summary\">https://www.nowcoder.com/test/10617729/summary</a></p>\r\n<p>搜狐2018秋招第二批-搜狐媒体产品类试卷</p>\r\n<p><a href=\"https://www.nowcoder.com/test/10617688/summary\">https://www.nowcoder.com/test/10617688/summary</a></p>\r\n<p>搜狐2018秋招第二批-技术类试卷</p>\r\n<p><a href=\"https://www.nowcoder.com/test/10617414/summary\">https://www.nowcoder.com/test/10617414/summary</a></p>\r\n<p>搜狐畅游<br>搜狐畅游18届游戏开发实习生笔试题20170705</p>\r\n<p><a href=\"https://www.nowcoder.com/test/10695324/summary\">https://www.nowcoder.com/test/10695324/summary</a></p>\r\n<p>搜狐畅游18届游戏开发实习生笔试题20170526</p>\r\n<p><a href=\"https://www.nowcoder.com/test/10695402/summary\">https://www.nowcoder.com/test/10695402/summary</a></p>\r\n<p>搜狐畅游2018校招笔试题-游戏开发工程师（C#、C++）<br><a href=\"https://www.nowcoder.com/test/10695109/summary\">https://www.nowcoder.com/test/10695109/summary</a></p>\r\n<p>搜狐畅游2018校招笔试题-游戏开发工程师（java）</p>\r\n<p><a href=\"https://www.nowcoder.com/test/10694989/summary\">https://www.nowcoder.com/test/10694989/summary</a></p>\r\n<p>搜狐畅游2018系统策划非游戏基础题部分A卷（测试）</p>\r\n<p><a href=\"https://www.nowcoder.com/test/8209575/summary\">https://www.nowcoder.com/test/8209575/summary</a></p>\r\n<p>搜狐畅游2018游戏系统策划非游戏基础部分题笔试试卷—B卷</p>\r\n<p><a href=\"https://www.nowcoder.com/test/8209615/summary\">https://www.nowcoder.com/test/8209615/summary</a></p>\r\n<p>搜狐畅游2018游戏开发工程师（C++ C#）非游戏基础题部分笔试</p>\r\n<p><a href=\"https://www.nowcoder.com/test/8209507/summary\">https://www.nowcoder.com/test/8209507/summary</a></p>\r\n<p>搜狐畅游2018游戏开发工程师（Java）非游戏基础题部分笔试试卷</p>\r\n<p><a href=\"https://www.nowcoder.com/test/8209441/summary\">https://www.nowcoder.com/test/8209441/summary</a></p>\r\n<p>搜狐畅游2018游戏数值策划非游戏基础题部分 笔试试卷—A卷</p>\r\n<p><a href=\"https://www.nowcoder.com/test/8209247/summary\">https://www.nowcoder.com/test/8209247/summary</a></p>\r\n<p>搜狐畅游2018游戏数值策划非游戏基础题部分 笔试试卷—B卷<br><a href=\"https://www.nowcoder.com/test/8209291/summary\">https://www.nowcoder.com/test/8209291/summary</a></p>\r\n<p>搜狐畅游2018游戏剧情策划非游戏基础题部分笔试试卷<br><a href=\"https://www.nowcoder.com/test/8207543/summary\">https://www.nowcoder.com/test/8207543/summary</a></p>\r\n', '\r\n\r\n科大讯飞：\r\n2018秋招笔试科大讯飞java笔试试题\r\nhttps://www.nowcoder.com/discuss/67684?type=2&order=3&pos=13&page=0\r\n\r\n锐捷：\r\n2018秋招锐捷笔试试题\r\nhttps://www.nowcoder.com/discuss/67760?type=2&order=3&pos=8&page=0\r\n锐捷2018秋招笔试题\r\nhttps://www.nowcoder.com/discuss/80796?type=2&order=3&pos=30&page=0\r\n\r\n58同城：\r\n58同城2018秋招前端笔试试题分享\r\n\r\nhttps://www.nowcoder.com/discuss/67508?type=2&order=3&pos=21&page=1\r\n\r\n2018秋招58同城笔试题分享\r\n\r\nhttps://www.nowcoder.com/discuss/69136?type=0&order=3&pos=6&page=0\r\n\r\n阿里巴巴：\r\n2018秋招阿里巴巴java笔试试题\r\nhttps://www.nowcoder.com/discuss/67379?type=2&order=3&pos=29&page=1\r\n阿里巴巴2018秋招正式试题\r\nhttps://www.nowcoder.com/discuss/79947?type=2&order=3&pos=103&page=1\r\n\r\n途牛：\r\n2018秋招途牛笔试试题分享，期待春招offer！\r\nhttps://www.nowcoder.com/discuss/68700?type=0&order=3&pos=6&page=0\r\n\r\n饿了么：\r\n饿了么2018秋招笔试前端试题\r\n\r\nhttps://www.nowcoder.com/discuss/68831?type=0&order=3&pos=7&page=0\r\n\r\n360\r\nhttps://www.nowcoder.com/discuss/68965?type=0&order=3&pos=8&page=0\r\n\r\n2018秋招360笔试题分享，求春招offer\r\n\r\nhttps://www.nowcoder.com/discuss/69239?type=2&order=3&pos=7&page=0\r\n\r\nfreelwheel\r\n2018秋招freewheel java笔试题，祝大家春招好运\r\n\r\nhttps://www.nowcoder.com/discuss/69430?type=0&order=3&pos=6&page=0\r\n\r\n哔哩哔哩\r\nhttps://www.nowcoder.com/discuss/69560?type=0&order=3&pos=6&page=0\r\nbilibili 2018秋招试题\r\nhttps://www.nowcoder.com/discuss/79943?type=2&order=3&pos=105&page=1\r\n\r\n贝贝\r\n贝贝2018秋招测评题，已拿offer\r\n\r\nhttps://www.nowcoder.com/discuss/70106?type=0&order=3&pos=6&page=0\r\n分享求好运~2018秋招贝贝客户端笔试题\r\nhttps://www.nowcoder.com/discuss/70519\r\n\r\n多益网络\r\n多益2018秋招笔试题，回馈大家\r\n\r\nhttps://www.nowcoder.com/discuss/70676?type=0&order=3&pos=7&page=0\r\n\r\n多益网络2018秋招试题\r\n\r\nhttps://www.nowcoder.com/discuss/71073?type=0&order=3&pos=6&page=0\r\n\r\n2018秋招多益网络iq测试题（一）\r\n\r\nhttps://www.nowcoder.com/discuss/78012\r\n\r\n2018秋招多益网络iq测试题（二）\r\n\r\nhttps://www.nowcoder.com/discuss/78164?type=2&order=3&pos=16&page=0\r\n\r\n今日头条\r\n2018秋招今日头条测评题，分享给大家~\r\n\r\nhttps://www.nowcoder.com/discuss/72131?type=0&order=3&pos=6&page=0\r\n\r\n今日头条2018校招测试开发方向（第一批）\r\n\r\nhttps://www.nowcoder.com/test/8537290/summary\r\n\r\n今日头条2018校招算法方向（第一批）\r\nhttps://www.nowcoder.com/test/8537279/summary\r\n\r\n今日头条2018校招大数据方向（第一批）\r\n\r\nhttps://www.nowcoder.com/test/8537283/summary\r\n\r\n今日头条2018校招测试开发方向（第二批）\r\n\r\nhttps://www.nowcoder.com/test/8537269/summary\r\n\r\n今日头条2018校招Android方向（第二批）\r\n\r\nhttps://www.nowcoder.com/test/8537261/summary\r\n\r\n今日头条2018校招ios方向（第二批）\r\n\r\nhttps://www.nowcoder.com/test/8537251/summary\r\n\r\n今日头条2018校招前端方向（第二批）\r\n\r\nhttps://www.nowcoder.com/test/8537237/summary\r\n\r\n今日头条2018校招算法方向（第二批）\r\n\r\nhttps://www.nowcoder.com/test/8537228/summary\r\n\r\n今日头条2018校招大数据方向（第二批）\r\n\r\nhttps://www.nowcoder.com/test/8537218/summary\r\n\r\n今日头条2018校招后端方向（第二批）\r\n\r\nhttps://www.nowcoder.com/test/8537209/summary\r\n\r\n今日头条2018校招后端方向（第三批）\r\n\r\nhttps://www.nowcoder.com/test/8537140/summary\r\n\r\n今日头条2018校招ios方向（第三批）\r\nhttps://www.nowcoder.com/test/8537129/summary\r\n\r\n今日头条2018校招大数据方向（第三批）\r\nhttps://www.nowcoder.com/test/8537109/summary\r\n\r\n今日头条2018校招前端方向（第三批）\r\n\r\nhttps://www.nowcoder.com/test/8537093/summary\r\n\r\n今日头条2018校招Android方向（第三批）\r\n\r\nhttps://www.nowcoder.com/test/8537072/summary\r\n\r\n今日头条2018校招算法方向（第三批）\r\nhttps://www.nowcoder.com/test/8537068/summary\r\n\r\n今日头条2018校招测试开发方向（第三批）\r\nhttps://www.nowcoder.com/test/8537047/summary\r\n\r\n今日头条2018校招Android方向（第四批）\r\n\r\nhttps://www.nowcoder.com/test/8537041/summary\r\n\r\n今日头条2018校招后端方向（第四批）\r\n\r\nhttps://www.nowcoder.com/test/8537039/summary\r\n\r\n今日头条2018校招算法方向（第四批）\r\n\r\nhttps://www.nowcoder.com/test/8537023/summary\r\n\r\n今日头条2018招聘测试开发方向（第四批）\r\n\r\nhttps://www.nowcoder.com/test/8536903/summary\r\n\r\n今日头条2018校招iOS方向（第四批）\r\n\r\nhttps://www.nowcoder.com/test/8536763/summary\r\n\r\n今日头条2018校招大数据方向（第四批）\r\n\r\nhttps://www.nowcoder.com/test/8536722/summary\r\n\r\n今日头条2018校招前端方向（第四批）\r\n\r\nhttps://www.nowcoder.com/test/8536639/summary\r\n\r\n链家\r\n2018秋招链家前端笔试题，晚上考试加油\r\n\r\nhttps://www.nowcoder.com/discuss/72559?type=0&order=3&pos=6&page=0\r\n\r\n链家2018秋招java笔试题\r\n\r\nhttps://www.nowcoder.com/discuss/78509\r\n\r\n去哪儿\r\n去哪儿2018秋招前端笔试题，求好运\r\n\r\nhttps://www.nowcoder.com/discuss/73058?type=0&order=3&pos=8&page=0\r\n去哪儿2018秋招笔试试题\r\nhttps://www.nowcoder.com/discuss/80134?type=2&order=3&pos=89&page=0\r\n去哪儿 2018校招 软件开发工程师在线考试\r\nhttps://www.nowcoder.com/discuss/80136?type=2&order=3&pos=88&page=0\r\n\r\n酷狗\r\n酷狗java2018秋招笔试题目，谢谢大家捧场\r\n\r\nhttps://www.nowcoder.com/discuss/73425?type=2&order=3&pos=8&page=0\r\n\r\n联想\r\n联想2018秋招java笔试题目，牛客奖品在向我招手~\r\n\r\nhttps://www.nowcoder.com/discuss/75053?type=2&order=3&pos=9&page=0\r\n\r\n绿盟科技\r\n回馈帖：2018秋招绿盟科技测试题\r\n\r\nhttps://www.nowcoder.com/discuss/75403\r\n\r\n绿盟科技2018秋招测评\r\n\r\nhttps://www.nowcoder.com/discuss/78791?type=2&order=3&pos=19&page=1\r\n\r\n美图\r\n美图2018秋招java笔试题\r\n\r\nhttps://www.nowcoder.com/discuss/78792?type=2&order=3&pos=18&page=1\r\n\r\n美图2018秋招客户端测试题\r\n\r\nhttps://www.nowcoder.com/discuss/78793?type=2&order=3&pos=17&page=1\r\n\r\n美图2018秋招前端试题\r\n\r\nhttps://www.nowcoder.com/discuss/78838?type=2&order=3&pos=15&page=1\r\n\r\n美团\r\n美团点评2018秋招笔试题\r\nhttps://www.nowcoder.com/discuss/79070?type=2&order=3&pos=63&page=0\r\n\r\n美团点评2018秋招笔试题\r\nhttps://www.nowcoder.com/discuss/79070?type=2&order=3&pos=63&page=0\r\n美团点评2018秋招测评题目\r\nhttps://www.nowcoder.com/discuss/79277?type=2&order=3&pos=52&page=1\r\n美团点评2018秋招前端测评\r\nhttps://www.nowcoder.com/discuss/79279?type=2&order=3&pos=51&page=1\r\n美团点评2018秋招正式题目\r\nhttps://www.nowcoder.com/discuss/79393?type=2&order=3&pos=44&page=0\r\n\r\n盛大游戏\r\n盛大游戏2018秋招Java笔试题\r\nhttps://www.nowcoder.com/discuss/79398?type=2&order=3&pos=43&page=0\r\n\r\n艺龙\r\n艺龙2018秋招Java笔试题\r\nhttps://www.nowcoder.com/discuss/79634?type=2&order=3&pos=23&page=0\r\n艺龙2018秋招前端试题\r\nhttps://www.nowcoder.com/discuss/79635?type=2&order=3&pos=22&page=0\r\n\r\n猪八戒\r\n猪八戒2018秋招Java笔试\r\nhttps://www.nowcoder.com/discuss/79730?type=2&order=3&pos=16&page=0\r\n猪八戒2018秋招前端试题\r\nhttps://www.nowcoder.com/discuss/79732?type=2&order=3&pos=15&page=1\r\n\r\neBay\r\neBay2018秋招Java试题\r\nhttps://www.nowcoder.com/discuss/79945?type=2&order=3&pos=104&page=0\r\n\r\n高新兴\r\n高新兴 2018秋招笔试试题\r\nhttps://www.nowcoder.com/discuss/80137?type=2&order=3&pos=87&page=1\r\n\r\n百度\r\n百度2018秋招客户端试题\r\n\r\nhttps://www.nowcoder.com/discuss/80355?type=2&order=3&pos=67&page=0\r\n\r\n百度2018秋招产品运营笔试试卷问答题\r\n\r\nhttps://www.nowcoder.com/test/10613730/summary\r\n\r\n趣店\r\n趣店2018秋招笔试题目\r\nhttps://www.nowcoder.com/discuss/80554?type=2&order=3&pos=50&page=0\r\n\r\n神州付\r\n神州付2018秋招笔试试题\r\nhttps://www.nowcoder.com/discuss/80884?type=2&order=3&pos=18&page=1\r\n\r\n搜狗\r\n搜狗2018秋招前端试题\r\n\r\nhttps://www.nowcoder.com/discuss/80975?type=2&order=3&pos=11&page=0\r\n搜狗2018秋招Java笔试试题\r\nhttps://www.nowcoder.com/discuss/81137?type=2&order=3&pos=123&page=1\r\n搜狗2018秋招Java笔试题\r\nhttps://www.nowcoder.com/discuss/81135?type=2&order=3&pos=124&page=0\r\n搜狗2018秋招Java客户端试题\r\nhttps://www.nowcoder.com/discuss/81449?type=2&order=3&pos=94&page=0\r\n\r\n搜狐\r\n搜狐2018秋招第一批-社交产品中心-设计类试卷\r\n\r\nhttps://www.nowcoder.com/test/10614549/summary\r\n\r\n搜狐2018秋招第一批-社交产品中心-狐友产品专员及邮箱产品经理\r\n\r\nhttps://www.nowcoder.com/test/10614529/summary\r\n\r\n搜狐2018秋招第一批-搜狐媒体产品类试卷\r\n\r\nhttps://www.nowcoder.com/test/10614456/summary\r\n\r\n搜狐2018秋招第一批-搜狐媒体内容运营类试卷\r\n\r\nhttps://www.nowcoder.com/test/10614439/summary\r\n\r\n搜狐2018秋招第一批-搜狐焦点非技术类试卷\r\n\r\nhttps://www.nowcoder.com/test/10614388/summary\r\n\r\n搜狐2018秋招第一批-社交产品中心-狐友运营专员及产品经理运营方向试卷\r\n\r\nhttps://www.nowcoder.com/test/10614281/summary\r\n\r\n搜狐2018秋招第一批社交产品中心-内容运营专员试卷\r\n\r\nhttps://www.nowcoder.com/test/10614250/summary\r\n\r\n搜狐2018秋招技术类试卷\r\n\r\nhttps://www.nowcoder.com/test/10614057/summary\r\n\r\n搜狐2018秋招第二批-社交产品中心-狐友产品专员及邮箱产品经理\r\n\r\nhttps://www.nowcoder.com/test/10618056/summary\r\n\r\n搜狐2018秋招第二批-社交产品中心-狐友运营专员及产品经理运营\r\n\r\nhttps://www.nowcoder.com/test/10617860/summary\r\n\r\n搜狐2018秋招第二批-社交产品中心-内容运营专员试卷\r\n\r\nhttps://www.nowcoder.com/test/10617841/summary\r\n\r\n搜狐2018秋招第二批-社交产品中心-设计类试卷\r\n\r\nhttps://www.nowcoder.com/test/10617827/summary\r\n\r\n搜狐2018秋招第二批-社交产品中心-测试工程师试卷\r\n\r\nhttps://www.nowcoder.com/test/10617815/summary\r\n\r\n搜狐2018秋招第二批-搜狐媒体内容运营类试卷\r\n\r\nhttps://www.nowcoder.com/test/10617729/summary\r\n\r\n搜狐2018秋招第二批-搜狐媒体产品类试卷\r\n\r\nhttps://www.nowcoder.com/test/10617688/summary\r\n\r\n搜狐2018秋招第二批-技术类试卷\r\n\r\nhttps://www.nowcoder.com/test/10617414/summary\r\n\r\n搜狐畅游\r\n搜狐畅游18届游戏开发实习生笔试题20170705\r\n\r\nhttps://www.nowcoder.com/test/10695324/summary\r\n\r\n搜狐畅游18届游戏开发实习生笔试题20170526\r\n\r\nhttps://www.nowcoder.com/test/10695402/summary\r\n\r\n搜狐畅游2018校招笔试题-游戏开发工程师（C#、C++）\r\nhttps://www.nowcoder.com/test/10695109/summary\r\n\r\n搜狐畅游2018校招笔试题-游戏开发工程师（java）\r\n\r\nhttps://www.nowcoder.com/test/10694989/summary\r\n\r\n搜狐畅游2018系统策划非游戏基础题部分A卷（测试）\r\n\r\nhttps://www.nowcoder.com/test/8209575/summary\r\n\r\n搜狐畅游2018游戏系统策划非游戏基础部分题笔试试卷—B卷\r\n\r\nhttps://www.nowcoder.com/test/8209615/summary\r\n\r\n搜狐畅游2018游戏开发工程师（C++ C#）非游戏基础题部分笔试\r\n\r\nhttps://www.nowcoder.com/test/8209507/summary\r\n\r\n搜狐畅游2018游戏开发工程师（Java）非游戏基础题部分笔试试卷\r\n\r\nhttps://www.nowcoder.com/test/8209441/summary\r\n\r\n搜狐畅游2018游戏数值策划非游戏基础题部分 笔试试卷—A卷\r\n\r\nhttps://www.nowcoder.com/test/8209247/summary\r\n\r\n搜狐畅游2018游戏数值策划非游戏基础题部分 笔试试卷—B卷\r\nhttps://www.nowcoder.com/test/8209291/summary\r\n\r\n搜狐畅游2018游戏剧情策划非游戏基础题部分笔试试卷\r\nhttps://www.nowcoder.com/test/8207543/summary', '', '3', '0', '0', '0', '0', '2018-11-06 11:28:45', '9', '1', '1526179403208IWBRWA6', '1526179403208IWBRWA6', '2018-06-06 11:28:45', '0');
INSERT INTO `post` VALUES ('1528255993638XBM8D6Y', '手绘--叶子，叶子', '\r\n叶子确也很美呀～\r\n\r\n', '<p><img src=\"http://localhost:8080/isay-web/post_photo/1528255971119.jpg\" alt=\"\"></p>\r\n<p>叶子确也很美呀～</p>\r\n<p><img src=\"http://localhost:8080/isay-web/post_photo/1528255979736.jpg\" alt=\"\"></p>\r\n', '![](http://localhost:8080/isay-web/post_photo/1528255971119.jpg)\r\n\r\n叶子确也很美呀～\r\n\r\n![](http://localhost:8080/isay-web/post_photo/1528255979736.jpg)', 'http://localhost:8080/isay-web/post_photo/1528255971119.jpg', '6', '0', '0', '0', '1', '2018-11-06 11:33:14', '12', '3', '1526179403208IWBRWA6', '1526179403208IWBRWA6', '2018-06-06 11:33:14', '0');
INSERT INTO `post` VALUES ('1537496128436X4XGLNE', '涂山苏苏', '涂山苏苏，中国漫画《狐妖小红娘》及其衍生作品中的女主角。呆萌迷糊的小狐妖，总是携带各种零食。法力低微，总是被评价为笨蛋蠢货，所以一直有个心愿就是成为一名正式红线仙来证明自己是真正的狐妖。实际上，涂山苏苏是涂山红红失去妖力和记忆而变成的女孩。在一气道盟和涂山的安排下，与白月初相遇并联手解决红线仙的任务。\r\n\r\n', '<h2 id=\"h2--\"><a name=\"涂山苏苏，中国漫画《狐妖小红娘》及其衍生作品中的女主角。\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>涂山苏苏，中国漫画《狐妖小红娘》及其衍生作品中的女主角。</h2><p>呆萌迷糊的小狐妖，总是携带各种零食。法力低微，总是被评价为笨蛋蠢货，所以一直有个心愿就是成为一名正式红线仙来证明自己是真正的狐妖。实际上，涂山苏苏是涂山红红失去妖力和记忆而变成的女孩。在一气道盟和涂山的安排下，与白月初相遇并联手解决红线仙的任务。</p>\r\n<p><img src=\"http://localhost:8080/isay-web/post_photo/1537495971160.jpg\" alt=\"\"></p>\r\n', '## 涂山苏苏，中国漫画《狐妖小红娘》及其衍生作品中的女主角。\r\n呆萌迷糊的小狐妖，总是携带各种零食。法力低微，总是被评价为笨蛋蠢货，所以一直有个心愿就是成为一名正式红线仙来证明自己是真正的狐妖。实际上，涂山苏苏是涂山红红失去妖力和记忆而变成的女孩。在一气道盟和涂山的安排下，与白月初相遇并联手解决红线仙的任务。\r\n\r\n![](http://localhost:8080/isay-web/post_photo/1537495971160.jpg)', 'http://localhost:8080/isay-web/post_photo/1537495971160.jpg', '0', '0', '0', '0', '0', '2018-09-21 10:15:28', '9', '3', '1526179403208IWBRWA6', '1526179403208IWBRWA6', '2018-09-21 10:15:28', '0');

-- ----------------------------
-- Table structure for post_comment
-- ----------------------------
DROP TABLE IF EXISTS `post_comment`;
CREATE TABLE `post_comment` (
  `comment_id` char(20) NOT NULL,
  `comment_content` varchar(1024) NOT NULL,
  `comment_time` datetime NOT NULL,
  `post_id` char(32) NOT NULL,
  `user_id` char(32) NOT NULL,
  `reply_num` int(11) NOT NULL DEFAULT '0',
  `is_delete` enum('0','1') NOT NULL DEFAULT '0' COMMENT '''0-未删除；1-已删除''',
  PRIMARY KEY (`comment_id`),
  KEY `fk_pc_p` (`post_id`),
  CONSTRAINT `fk_pc_p` FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='帖子评论';

-- ----------------------------
-- Records of post_comment
-- ----------------------------
INSERT INTO `post_comment` VALUES ('1526736373389DR5DUHJ', '<img class=\"mr-img\" src=\"http://localhost:8080/isay-web/comment_photo/1526736371689.jpg\">', '2018-05-19 21:26:13', '15266597293265W1UHTQ', '15248859107335YA2M37', '0', '0');
INSERT INTO `post_comment` VALUES ('1527578599093G3XM5FN', '我觉得你写的很好！！', '2018-05-29 15:23:19', '1527429937894Q2WZNPE', '15248859107335YA2M37', '0', '0');
INSERT INTO `post_comment` VALUES ('1527578674026AKW42KF', '加个好友先？', '2018-05-29 15:24:34', '1527429937894Q2WZNPE', '15248859107335YA2M37', '0', '0');
INSERT INTO `post_comment` VALUES ('1527928399690EFAGWDH', '原画师很厉害<img class=\"mr-img\" src=\"http://localhost:8080/isay-web/comment_photo/1527928398356.jpg\">', '2018-06-02 16:33:20', '1527916595358VXADVSK', '1526179403208IWBRWA6', '0', '0');
INSERT INTO `post_comment` VALUES ('1528256417452UU53V64', '喜欢叶子<img class=\"mr-img\" src=\"http://localhost:8080/isay-web/comment_photo/1528256416297.gif\">', '2018-06-06 11:40:17', '1528255993638XBM8D6Y', '15248859107335YA2M37', '0', '0');

-- ----------------------------
-- Table structure for post_label
-- ----------------------------
DROP TABLE IF EXISTS `post_label`;
CREATE TABLE `post_label` (
  `post_id` char(32) NOT NULL,
  `al_id` int(11) NOT NULL,
  PRIMARY KEY (`post_id`,`al_id`),
  KEY `fk_pl_l` (`al_id`),
  CONSTRAINT `fk_pl_l` FOREIGN KEY (`al_id`) REFERENCES `area_label` (`al_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_pl_p` FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post_label
-- ----------------------------
INSERT INTO `post_label` VALUES ('15266597293265W1UHTQ', '1');
INSERT INTO `post_label` VALUES ('1528255724866WGPRAGI', '1');
INSERT INTO `post_label` VALUES ('1528255724866WGPRAGI', '2');
INSERT INTO `post_label` VALUES ('1527429937894Q2WZNPE', '3');
INSERT INTO `post_label` VALUES ('1527429937894Q2WZNPE', '4');
INSERT INTO `post_label` VALUES ('1528255724866WGPRAGI', '7');
INSERT INTO `post_label` VALUES ('1528255724866WGPRAGI', '21');
INSERT INTO `post_label` VALUES ('1527429937894Q2WZNPE', '34');
INSERT INTO `post_label` VALUES ('1527916395654TXRYQ47', '111');
INSERT INTO `post_label` VALUES ('1527916252410MNH4GTV', '117');
INSERT INTO `post_label` VALUES ('15263640778098G1THID', '124');
INSERT INTO `post_label` VALUES ('1537496128436X4XGLNE', '124');
INSERT INTO `post_label` VALUES ('15263640778098G1THID', '128');
INSERT INTO `post_label` VALUES ('15263640778098G1THID', '133');
INSERT INTO `post_label` VALUES ('1527916595358VXADVSK', '133');
INSERT INTO `post_label` VALUES ('1528255993638XBM8D6Y', '133');
INSERT INTO `post_label` VALUES ('1527916595358VXADVSK', '137');
INSERT INTO `post_label` VALUES ('1527916795652ZR8W1S3', '250');
INSERT INTO `post_label` VALUES ('1527916795652ZR8W1S3', '251');

-- ----------------------------
-- Table structure for post_reply
-- ----------------------------
DROP TABLE IF EXISTS `post_reply`;
CREATE TABLE `post_reply` (
  `reply_id` char(20) NOT NULL,
  `reply_content` varchar(1024) NOT NULL,
  `reply_time` datetime NOT NULL,
  `from_user_id` char(32) NOT NULL,
  `to_user_id` char(32) NOT NULL,
  `comment_id` char(20) NOT NULL,
  `is_delete` enum('0','1') NOT NULL DEFAULT '0' COMMENT '''0-未删除；1-已删除''',
  PRIMARY KEY (`reply_id`),
  KEY `fk_pr_c` (`comment_id`),
  CONSTRAINT `fk_pr_c` FOREIGN KEY (`comment_id`) REFERENCES `post_comment` (`comment_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='帖子评论回复';

-- ----------------------------
-- Records of post_reply
-- ----------------------------

-- ----------------------------
-- Table structure for post_share
-- ----------------------------
DROP TABLE IF EXISTS `post_share`;
CREATE TABLE `post_share` (
  `share_id` int(11) NOT NULL AUTO_INCREMENT,
  `post_id` char(32) NOT NULL COMMENT '原帖子id',
  `post_content` mediumtext NOT NULL,
  `post_markdown` mediumtext NOT NULL,
  `author_id` char(32) NOT NULL COMMENT '不在同一个服务，不能外键',
  `post_time` datetime NOT NULL,
  `modify_time` datetime NOT NULL COMMENT '最后修改时间',
  `is_delete` enum('0','1') NOT NULL DEFAULT '0' COMMENT '0-未删除；1-已删除',
  PRIMARY KEY (`share_id`),
  KEY `fk_share` (`post_id`),
  CONSTRAINT `fk_share` FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='共享帖子-修改即添加';

-- ----------------------------
-- Records of post_share
-- ----------------------------
INSERT INTO `post_share` VALUES ('1', '15266597293265W1UHTQ', '<h2 id=\"h2-java\"><a name=\"java\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>java</h2><ol>\r\n<li>go入门</li><li>程序结构</li><li>基本数据</li><li>复合数据类型</li><li>结构体和方法</li><li>包和封装</li><li>面向对象&amp;面向接口</li><li>函数式编程</li><li>错误处理和资源管理</li><li>测试与性能</li><li>goroutine</li><li>channel</li><li>http及其标准库</li><li>mysql</li><li>ElasticSearch</li></ol>\r\n<p><img src=\"http://localhost:8080/isay-web/post_photo/1526659139117.jpg\" alt=\"\"></p>\r\n<p>You should use the <code>strong</code> tag.</p>\r\n<pre><code>if p.visualization_dbg==1\r\n    mySubplot(2,1,5,1,im_patch_cf,&#39;FG+BG&#39;,&#39;gray&#39;);\r\n    mySubplot(2,1,5,2,likelihood_map,&#39;obj.likelihood&#39;,&#39;parula&#39;);\r\n    mySubplot(2,1,5,3,response_cf,&#39;CF response&#39;,&#39;parula&#39;);\r\n    mySubplot(2,1,5,4,response_pwp,&#39;center likelihood&#39;,&#39;parula&#39;);\r\n    mySubplot(2,1,5,5,response,&#39;merged response&#39;,&#39;parula&#39;);\r\n    drawnow\r\nend\r\n</code></pre><p>  Java的桌面程序并不少，其中最为知名的莫过于Eclipse。在Linux和Mac下，Java程序的比例远高于Windows下。<br>  不过，“Java不适合写桌面应用”的说法有一定道理，论调的主要背景是供Windows下使用的企业桌面应用的开发。由于一些历史和定位的原因，对于这种GUI程序的需求，Java的优势不明显，劣势比较明显。<br>  这事还得从Java的传统，“跨平台一致性”说起。<br>  在写后台逻辑的时候，跨平台是好东西。很多公司都是在Windows下开发，在Linux下部署，方便。<br>  但涉及到GUI的时候，跨平台就成了个“看上去很美”的东西。理论上，我写个窗口，在Windows和Mac下都一样能用，那是多么美好的事啊。但实际上，每个平台提供的GUI控件多多少少有点差别，一坚持跨平台，麻烦就来了，该支持多少控件，怎么支持呢。<br>  一开始，Java的思路是：那简单啊，有原生控件干嘛不用，至于不跨平台的，就不支持呗，又坚持了原则，又回避了问题。这一代的gui库，awt，就此诞生。<br>  因为Java一开始是一根筋想推广Applet的，只是“顺便”也支持本地应用，设计成这样不能说不合适，毕竟，HTML也是同样的思路，只支持几种最基本的控件。<br>  但对于想开发复杂点界面的人来说，就有麻烦了。想来个目录树吧，对不起，不支持；想来个进度条吧，对不起，不支持。旁边放着Delphi和VB这么方便的东西，哥干吗受这气啊。<br>  这样一来，Java自己也觉得说不过去了。但又要跨平台，又要提供丰富的控件支持，那就只有另起炉灶，开始用第二种思路：自己动手、丰衣足食，自己重写一套GUI控件，代替操作系统的原生控件。这一代的gui库，叫做swing。<br>  这也是一个想“彻底”解决问题的思路，但是要付出代价。代价之一就是效率。我们可以参考一下另一个相同思路的产品——flash。为了实现矢量动画，在flash的那个小框里，图是一帧一帧地算出来的。接下来的事情我们都知道了：复杂的flash动画极耗cpu；iPhone说，您太耗电了，俺就不支持了；Adobe说，那好吧，那俺也不费心折腾移动版flash了。<br>  自己画出来的控件毕竟不能跟原生控件比效率，尤其是在早期Java优化还不够完善的时候。而且，自力更生的目的只是为了平台兼容，不是为了更好的效果，这事儿其实怎么想怎么亏。代价之二就是效果。自己画的控件毕竟只是模拟，还是会有细节差别。比如著名的毛玻璃效果，这不是简单套样式就能套出来的。而且，各个平台控件的风格本来就不一样，虽然swing提供了几种外观，但大部分程序出于偷懒或是跨平台一致考虑，还是使用默认外观。默认外观跟平台不一致倒也不是问题，主要是别比平台效果土。我用着win7，一个程序非让我感觉回到xp时代，心里特别添堵。就这样，一帮人商量着，又琢磨出个新思路：做适配。平台有这个控件，就直接用，保证效率；没有，再造轮子，保证可用。就这样，swt问世。eclipse的gui就是基于此。</p>\r\n', '## java\r\n\r\n1. go入门\r\n2. 程序结构\r\n3. 基本数据\r\n4. 复合数据类型\r\n5. 结构体和方法\r\n6. 包和封装\r\n7. 面向对象&面向接口\r\n8. 函数式编程\r\n9. 错误处理和资源管理\r\n10. 测试与性能\r\n11. goroutine\r\n12. channel\r\n13. http及其标准库\r\n14. mysql\r\n15. ElasticSearch\r\n\r\n![](http://localhost:8080/isay-web/post_photo/1526659139117.jpg)\r\n\r\n\r\n\r\nYou should use the `strong` tag.\r\n```\r\nif p.visualization_dbg==1\r\n    mySubplot(2,1,5,1,im_patch_cf,\'FG+BG\',\'gray\');\r\n    mySubplot(2,1,5,2,likelihood_map,\'obj.likelihood\',\'parula\');\r\n    mySubplot(2,1,5,3,response_cf,\'CF response\',\'parula\');\r\n    mySubplot(2,1,5,4,response_pwp,\'center likelihood\',\'parula\');\r\n    mySubplot(2,1,5,5,response,\'merged response\',\'parula\');\r\n    drawnow\r\nend\r\n```\r\n\r\n  Java的桌面程序并不少，其中最为知名的莫过于Eclipse。在Linux和Mac下，Java程序的比例远高于Windows下。\r\n  不过，“Java不适合写桌面应用”的说法有一定道理，论调的主要背景是供Windows下使用的企业桌面应用的开发。由于一些历史和定位的原因，对于这种GUI程序的需求，Java的优势不明显，劣势比较明显。\r\n  这事还得从Java的传统，“跨平台一致性”说起。\r\n  在写后台逻辑的时候，跨平台是好东西。很多公司都是在Windows下开发，在Linux下部署，方便。\r\n  但涉及到GUI的时候，跨平台就成了个“看上去很美”的东西。理论上，我写个窗口，在Windows和Mac下都一样能用，那是多么美好的事啊。但实际上，每个平台提供的GUI控件多多少少有点差别，一坚持跨平台，麻烦就来了，该支持多少控件，怎么支持呢。\r\n  一开始，Java的思路是：那简单啊，有原生控件干嘛不用，至于不跨平台的，就不支持呗，又坚持了原则，又回避了问题。这一代的gui库，awt，就此诞生。\r\n  因为Java一开始是一根筋想推广Applet的，只是“顺便”也支持本地应用，设计成这样不能说不合适，毕竟，HTML也是同样的思路，只支持几种最基本的控件。\r\n  但对于想开发复杂点界面的人来说，就有麻烦了。想来个目录树吧，对不起，不支持；想来个进度条吧，对不起，不支持。旁边放着Delphi和VB这么方便的东西，哥干吗受这气啊。\r\n  这样一来，Java自己也觉得说不过去了。但又要跨平台，又要提供丰富的控件支持，那就只有另起炉灶，开始用第二种思路：自己动手、丰衣足食，自己重写一套GUI控件，代替操作系统的原生控件。这一代的gui库，叫做swing。\r\n  这也是一个想“彻底”解决问题的思路，但是要付出代价。代价之一就是效率。我们可以参考一下另一个相同思路的产品——flash。为了实现矢量动画，在flash的那个小框里，图是一帧一帧地算出来的。接下来的事情我们都知道了：复杂的flash动画极耗cpu；iPhone说，您太耗电了，俺就不支持了；Adobe说，那好吧，那俺也不费心折腾移动版flash了。\r\n  自己画出来的控件毕竟不能跟原生控件比效率，尤其是在早期Java优化还不够完善的时候。而且，自力更生的目的只是为了平台兼容，不是为了更好的效果，这事儿其实怎么想怎么亏。代价之二就是效果。自己画的控件毕竟只是模拟，还是会有细节差别。比如著名的毛玻璃效果，这不是简单套样式就能套出来的。而且，各个平台控件的风格本来就不一样，虽然swing提供了几种外观，但大部分程序出于偷懒或是跨平台一致考虑，还是使用默认外观。默认外观跟平台不一致倒也不是问题，主要是别比平台效果土。我用着win7，一个程序非让我感觉回到xp时代，心里特别添堵。就这样，一帮人商量着，又琢磨出个新思路：做适配。平台有这个控件，就直接用，保证效率；没有，再造轮子，保证可用。就这样，swt问世。eclipse的gui就是基于此。', '15248859107335YA2M37', '2018-05-19 21:05:43', '2018-05-19 21:24:48', '0');
INSERT INTO `post_share` VALUES ('2', '1528255993638XBM8D6Y', '<p><img src=\"http://localhost:8080/isay-web/post_photo/1528255971119.jpg\" alt=\"\"></p>\r\n<p>叶子确也很美呀～</p>\r\n<p><img src=\"http://localhost:8080/isay-web/post_photo/1528255979736.jpg\" alt=\"\"></p>\r\n<p>如果偶遇到美丽的事物，一朵娇艳的花，一株高拔的树，一只清雅的茶杯，一方古朴的砚台，哪怕一棵青翠的小草或一只红蜻蜓恰巧飞过你的眼前，如果，你喜欢，请不要吝惜你的赞美。</p>\r\n<p>如果碰到有趣的事，可爱的人，或在墙角晒太阳的漂亮野猫，如果，你有心动，也请不要吝惜你的赞美。</p>\r\n<p>虽然萍水相逢，又一别天涯。虽然只在驻足凝眸的霎那，但它们将记得这一刻你给予的赞美。</p>\r\n<p>赞美令美更美。</p>\r\n<p><img src=\"http://localhost:8080/isay-web/post_photo/1528256241363.jpg\" alt=\"\"></p>\r\n', '![](http://localhost:8080/isay-web/post_photo/1528255971119.jpg)\r\n\r\n叶子确也很美呀～\r\n\r\n![](http://localhost:8080/isay-web/post_photo/1528255979736.jpg)\r\n\r\n\r\n如果偶遇到美丽的事物，一朵娇艳的花，一株高拔的树，一只清雅的茶杯，一方古朴的砚台，哪怕一棵青翠的小草或一只红蜻蜓恰巧飞过你的眼前，如果，你喜欢，请不要吝惜你的赞美。\r\n\r\n如果碰到有趣的事，可爱的人，或在墙角晒太阳的漂亮野猫，如果，你有心动，也请不要吝惜你的赞美。\r\n\r\n虽然萍水相逢，又一别天涯。虽然只在驻足凝眸的霎那，但它们将记得这一刻你给予的赞美。\r\n\r\n赞美令美更美。\r\n\r\n![](http://localhost:8080/isay-web/post_photo/1528256241363.jpg)', '15248859107335YA2M37', '2018-06-06 11:37:27', '2018-06-06 11:37:27', '0');

-- ----------------------------
-- Table structure for post_up_down
-- ----------------------------
DROP TABLE IF EXISTS `post_up_down`;
CREATE TABLE `post_up_down` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID，自增',
  `post_id` char(20) NOT NULL COMMENT 't帖子id',
  `user_id` char(20) NOT NULL COMMENT '用户',
  `type` enum('1','2') NOT NULL DEFAULT '1' COMMENT '1-赞成；2-反对',
  PRIMARY KEY (`id`),
  KEY `fk_ud_post` (`post_id`),
  CONSTRAINT `fk_ud_post` FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='帖子：赞成或者反对的记录';

-- ----------------------------
-- Records of post_up_down
-- ----------------------------
INSERT INTO `post_up_down` VALUES ('2', '15263640778098G1THID', '15248859107335YA2M37', '1');

-- ----------------------------
-- Table structure for solr_post
-- ----------------------------
DROP TABLE IF EXISTS `solr_post`;
CREATE TABLE `solr_post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sp_id` char(20) NOT NULL,
  `sp_title` varchar(255) NOT NULL,
  `sp_content` mediumtext NOT NULL,
  `sp_cover` varchar(255) NOT NULL,
  `sp_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_sp` (`sp_id`),
  CONSTRAINT `fk_sp` FOREIGN KEY (`sp_id`) REFERENCES `post` (`post_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='给solr查询用的数据，添加，更新，删除要同步';

-- ----------------------------
-- Records of solr_post
-- ----------------------------
INSERT INTO `solr_post` VALUES ('1', '1527429937894Q2WZNPE', '区块链将如何重新定义世界', '\r\n区块链技术被认为是继蒸汽机、电力、互联网之后，下一代颠覆性的核心技术。 如果说蒸汽机释放了人们的生产力，电力解决了人们基本的生活需求，互联网彻底改变了信息传递的方式，那么区块链作为构造信任的机器，将可能彻底改变整个人类社会价值传递的方式。\r\n在这篇文章里，我们将用最容易理解的方式，让你在15分钟内了解清楚：\r\n区块链的本质到底是什么？\r\n区块链技术带来的三大巨变。区块链面临的两大技术挑战。\r\n区块链技术未来的发展脉络。\r\n区块链技术的本质到底是什么？\r\n区块链本质上是一个分布式的公共账本，听起来很蒙圈？别急，后面会用最深入浅出的方式来一一解释。任何人都可以对这个公共账本进行核查，但不存在一个单一的用户可以对它进行控制。在区块链系统中的参与者们，会共同维持账本的更新：它只能按照严格的规则和共识来进行修改，这背后有非常精妙的设计。\r\n举个通俗的例子来解释，W先生全家，包括 W 先生，W 夫人，W 爷爷， W 奶奶，各自的账本上都记录了大家的开支。因为 W 先生全家互相不信任。W 先生自己勤勤恳恳每个月养老婆，可W 夫人可能会收到1000块钱却记收到100，那岂不亏大了?\r\n用区块链如何解决这个问题呢？  假如某天 W 先生给了1000块给 W 夫人，他只要在向全家人大吼一声—— W 先生给了 W 夫人1000，请大家在各自的账本上记下“W 先生给了 W 夫人1000”，就OK了。\r\n于是 W 先生全家每个人都成了一个节点，每次 W 先生家的交易都会被每个人（每个节点）记录下来。\r\n每次晚上谁洗了碗（工作量证明）之后就可以在公共账本上结账，而且洗碗还有报酬，必须在前一天大家都公认的账本后面添加新的交易，而且其他人也会参与验证当天的交易。\r\n自然会有人问，能否进行恶意操作来破坏整个区块链系统？比如不承认别人的结果，或者伪造结果怎么办?\r\n比如 W 夫人某天忽然说 W 先生没给她1000，那么全家人都会站起来斥责她。如果 W 夫人某天洗完碗想在结账的时候动手脚，其他参与验证的人也会站起来斥责她（除非她能收买超过一半以上的人），被发现作假会导致她那天的碗就白洗了，报酬也会拿不到，很可能第二天还要继续洗碗。\r\n最后那个公认的账本也只会增加，不会减少。后续加入的家庭成员都会从最长的那个账本那里继续结账。\r\n总结一下，区块链其实很简单，就是一个分布式的公共账本。\r\n别看区块链好像看起来很简单，但区块链可能会给人类社会带来革命性的改变。\r\n第一：机器信任\r\n过去网络上流行“怎么证明我妈是我妈”的新闻，这其实是一个直接用区块链就能解决的问题。\r\n过去，我们的出生证、房产证、婚姻证等，需要一个中心的节点比如政府备书，大家才能承认。但一旦跨国，你就会遇到无穷的麻烦，跨国以后合同和证书可能就失效了，因为缺少全球性的中心节点。\r\n区块链技术不可篡改的特性从根本上改变了中心化的信用创建方式，通过数学原理而非中心化信用机构来低成本地建立信用。我们的出生证、房产证、婚姻证都可以在区块链上公证，变成全球都信任的东西，当然也可以轻松证明 “我妈是我妈”。\r\n人是善变的，而机器是不会撒谎的，区块链有望带领我们从个人信任、制度信任进入到机器信任的时代。\r\n这个意义有多大呢？\r\n回顾历史，人类文明是建立在信任和共识的基础上搭建起合作网络，从而人类成为地球的主宰。\r\n最早智人为什么能够战胜其他人种，从而统一人类？其实是因为语言的出现和讲故事能力的提升，人们能够以极其灵活的方式与陌生人进行大规模的协作，而其他人种因为不具备这种能力，所以无法更高效地聚集起团队，于是很快就分崩离析。\r\n直到今天，互联网也是新一代 “大型合作网络”，互联网上的领袖就是超级信任节点，他们的信任靠的是长时间的积累。\r\n传统金融的合作网络建立在钢筋水泥的大厦上，所以银行都需要盖大楼，让大家相信他们是值得信任的。政治上的信任构建也大体如此，需要大量的成本。\r\n从个人信任进化到制度信任是人类文明的一大进步，制度的产生源于降低交易成本的需求。通过对符合制度规定的行为进行认可与鼓励，对违反制度规定的行为进行惩戒，引导人们将自己的行为控制在一定的范围内，从而达到降低交易成本的目的。\r\n但制度和国家机器等中心节点为我们建立信用的成本偏高，因为需要很多人来维持这个体系。不管哪个时代，需要大量的人来维持的体系成本必然很高。\r\n区块链技术则用代码构建了一个最低成本的信任方式 —— 机器信任，我们不需要相信语言和故事，也不需要有钢筋水泥、中央机构为基础，不需要靠个人领袖背书，只需要知道那些区块链上的代码会执行，也不需要担心制度会被腐败掉，就可以做到互相协作，低成本构建大型合作网络。\r\n机器信任其实是无须信任的信任。人类历史将第一次可以接近零成本建立地球上前所未有的大型合作网络，这必将是一场伟大的群众运动。\r\n第二：价值传递\r\n人类正处于一场从物理世界向虚拟世界迁徙的历史性运动中，而不能否认一个事实，人类的财富也将渐渐往互联网转移，这已经是既成事实。\r\n传统的互联网不是为传递价值而生，互联网上信息的传输，本质是信息的拷贝。而现实中的货币流通要依靠中心化的组织做背书来维护运行，比如微信支付、支付宝、银联等。但现在有哪家公司能活1000年以上的吗？所以，依靠中心化的方式实现价值传递，弊病很多。\r\n而区块链是第一个能够实现价值传递的网络，区块链技术有望带领人类从信息互联网过渡到了价值互联网的伟大时代。\r\n', 'http://localhost:8080/isay-web/post_photo/1527429916285.jpg', '2018-09-20 15:14:50');
INSERT INTO `solr_post` VALUES ('2', '1527916252410MNH4GTV', '其实不管你再优秀，总有不喜欢你的人', '\r\n以前我们总是以为自己变得优秀了，那些不喜欢我们的人就会喜欢我们了。现在我们发现，即使我们变得再优秀，那些不喜欢我们的人还是不喜欢我们。\r\n\r\n01\r\n记得我刚进有书的原创群时，那时的原创群是个充满生气的读书写作群。群里的书友在队长小蜜蜂的鞭策下，打卡读书非常认真，作业大多都能按时完成。\r\n后来，因为我的到来，彻底改变了原创群。原本安静的读书群因为我的活跃开始闹腾起来。大多数的书友挺喜欢我的活跃给群带来了欢乐，但也有人讨厌我的闹腾离群而去。\r\n我那时不知道群里有不喜欢我的人，直到有一次，组长告诉你，有一个书友退群了，走之前和他说了，因为不喜欢我的活跃，所以走了。\r\n我听后不以为然，就对组长说，爱走就走呗，我又不是人民币，谁见了都喜欢。再说，就是优秀的雷总也不一定人人喜欢。他不喜欢和我们随波逐流，就随他去吧！\r\n那时的我，进有书才几个月。一个没多少文化，写的又不咋得的人，凭什么让人喜欢！咱可是有自知之明的人。\r\n02\r\n几年前，想带儿子去商场购买些日用品回来，儿子开始不怎么愿意去。儿子那时才几岁，把他一个人放在家里也不放心，所以我死拽着他上了商场。到了商场门口的时候，他站在门口哭，说不想进去，说商场不好玩。我蹲下去安慰他。\r\n我拿纸巾帮他抹眼泪，安慰他说“乖宝宝，你看看周围这么多玩具商品啊，我们可以一起去玩啊”！\r\n“你们都是骗子，我根本没看到什么好玩的玩具。”\r\n我蹲在他旁边向商场望去，是的，根本就没有好玩的玩具，看到的不过是一群来来往往人员的大腿而已。我抱着他说，走了走了，咱们回去了。\r\n我们总是站在自己的视觉看待这个世界，我们看到的是琳琅满目的商品，而在小孩子的世界里，他们看到的永远都是一群人的腿而已。\r\n我们每个人所处的高度是不一样的，看到的东西，产生的反应也是不一样的。\r\n生活中我们很多人都倾向于评价别人，而不是倾向于理解别人。往往评价别人的时候就是站在自己的角度去评价的。自己觉得自己的观点很牛逼了。其实在别人看来，不过就是一坨屎而已。\r\n从写作这一年多来，有人对于我的文章表示感谢，有人不以为然、嗤之以鼻。其实每个人对优秀的定义并不相同。\r\n', 'http://localhost:8080/isay-web/post_photo/1527916156056.jpg', '2018-06-02 13:10:52');
INSERT INTO `solr_post` VALUES ('3', '1527916395654TXRYQ47', '产品经理面试到底在面试什么', '本人曾面试产品经理几十次，败绩无数，后也面过一些产品经理，误入此题，上一些感想。\r\n产品经理是一个以软实力为主的岗位，不需要你设计，不需要你写代码，需要你干什么，心里必须有数。把这个说在前面，是要提醒你，产品经理虽然不一定需要你上硬货，但你千万别把面试当做一个扯蛋的过程，虽然“你觉得什么样的产品是好产品？”这样的问题看起来是面试官在和你扯蛋，但是这其实是一个非常专业的问题。首先一定要把产品经理当成一门专业来看待，要把面试当做一个规范的行为来看待，万不可随意瞎扯。\r\n压力测试是给外行的人做的，对于专业的人来说，讨论专业的事，任何问题都不要归结于压力测试的思路去。以逻辑和说服力征服对方，产品工作就是一个先自己想明白，再不断说服所有人的过程。\r\n在知乎另外一个关于面试豆瓣产品经理的问题上，我们可以看到一个失败的产品面试过程，失败在哪里，没有人给出解读。产品经理面试经常犯一个错误，就是认为问题没有标准答案，诚然，产品工作中的确没有全对全错，但是面试是一场考试，是考试必定有高下，有高下就必定有标准，接近那个标准的，就是正确答案，远离那个标准的，就是错误答案。面试的过程，就是让自己的回答无限接近标准答案的过程。\r\n回到那个豆瓣面试，里面有一个问题我也曾经常遇到，“Q:你觉得什么样的产品是一个成功的产品？”或者是“成功的产品有什么标准？”。你可以这样答：好玩的产品就是成功的、用户人数多的就是成功的、能为公司赚钱的就是成功的、UI做得漂亮就是成功的。当然从扯蛋的角度看，这样的回答本没有问题，但是如果是产品经理面试，这样的回答要打零分。为什么呢？不要忘记你的身份，是要来面试产品经理，好玩的产品一定成功吗？成功，但这是从用户的角度看问题，用户人数多就成功吗？这仿佛是一个聪明的答案，但其实是很容易被问死的，多少用户算多？用户人数多就一定很成功吗？能为公司赚钱的就是成功，逆推回去没为公司赚钱的就不是好产品吗？许多产品人气很旺但是并不要赚钱，只是用来市场卡位的，这样不算好产品吗？这是运营的思路，不是产品经理的思路。最后一个答案，长得好看的产品，那是美工的思路，也不是产品经理的思路，甚至是易学易用，也只是交互设计师的思路，同样不是产品经理的思路。这些答案我也曾一二三的列出来，自以为得计，但其实都只证明了自己的无知，对产品工作缺乏思考而已。\r\n那什么才是产品经理的思路？对于上面的问题，目前为止我得到的最好的答案，是简单的三条，这三条或许并不是标准答案，但折射出来的道理，可以供每一个想进入产品行列的同仁借鉴：\r\n\r\n一个好的产品，首先要解决用户的需求；\r\n一个好的产品，其次是要有黏性；\r\n一个好的产品，要拥有不错的体验。\r\n\r\n什么产品才是一个好的产品，满足以上三条，就是好的产品。这才是产品经理的思维——透过现象看本质，深度解读一个问题，提炼出问题的规律，并用这个规律来指导产品开发设计的行为。产品经理是用脑工作，不是用手。产品经理的三个关键词：需求、黏性、体验，这三个是产品工作中每天都要挂在嘴边，刻在脑海的。\r\n首先说第一条，需求，这是一个产品之所以被称为产品的前提，产品的本质就是用来解决需求的，黏性和体验是之后的事，如果我给你一个空调，八星八钻，黄金面板，极富情怀，最先进的XX工艺，按下按钮就播放你喜欢的音乐，但是我告诉你，它是没有制冷和制热功能的，你觉得它是一个成功的 产品么？所以说，一个好的产品，或者是说成功的产品，一定要首先解决用户的某种需求，或者是更好的解决了别的产品已经解决了的需求，这就是好产品的第一条标准。看起来像废话，但是这就是抽象出来的规律，也是无可辩驳的事实。\r\n第二条，黏性，这是一个成功产品的另一个典型特点。一个成功的产品，一定是不断被用户想起的产品，一旦用户产生了某种需求，就能想起你，这就是一个好的产品。有黏性的产品一定是很好的解决了某种需求，而且做到了竞品没有的高度。用户用了一次就不再使用，说明你的产品并不好，或者说干脆就是定位有了问题。QQ的黏性为什么那么强？为什么中国人喜欢用百度，为什么许多产品看似概念不错，体验也没什么硬伤，却如同昙花一现？就是在培养用户黏性上面没有做好。所以解决了用户某种需求的产品，并不一定就是好产品，还需要被用户不停的想起，从这个角度说，一个漂亮性感、能解决你生理需求的女人和一个能和你相濡以沫让你感受到被爱的女人，谁优谁劣，高下立判。\r\n第三条，优秀的用户体验，这也是一个成功产品的典型特点。我曾以为这是产品经理的全部，后来我才明白，其实所谓优秀的用户体验是交互设计师要考虑的问题，而交互设计只是产品经理工作的小小一环。优秀的用户体验可以为产品加分，但是绝对不是最重要的，想当年互联网草创时期，产品体验一塌糊涂，但是用户依然趋之若鹜，因为你的产品解决了用户的需求，犹如一把普通的锄头，可能既不好看又不省力，但却当之无愧是一个好产品，因为它解决了农民种地的需求，只要农民种地就会重复使用。当然，如果你做了一把漂亮锄头的确是更不错，但是那其实不是最本质的问题。\r\n这三条规律，是一个产品作为一个好产品的根本特点，是三条放之四海而皆准的规律，而不是主观的某种看法或停留在表层的认知，这就是产品经理应有的能力——从复杂的现象中抽象出普世规律，然后利用这个规律指导产品的方向。\r\n', '', '2018-06-02 13:13:16');
INSERT INTO `solr_post` VALUES ('4', '1527916595358VXADVSK', '原画师要具备哪些特点？原画师要掌握那些知识？', '现在很多朋友都在学习原画，昨天小编分享了零基础朋友在学习原画的时间该怎么去学习?零基础学习原画的技巧，今天小编为大家带来的是我们成为了一名原画师要具备哪些特点？原画师又要掌握哪些基础的知识呢？今天小编带你走进原画师的世界。\r\n原画师必须具备的特点：\r\n1）具有较高的审美素养，较强的视觉感受功能里和视觉表现能力；\r\n2）掌握动漫画的基本原理和基础理论，并能在实践中融会贯通；\r\n3）掌握动漫画的各种表现语言和表现技巧，有较强的专业设计能力和创造能力；\r\n4）能熟练运用计算机进行专业的辅助设计和创作。\r\n\r\n原画师需要掌握的知识：\r\n一、美术基础\r\n美术基础这个是最基本的，大家都知道原画中的基础有多重要，在原画中你的基础的厚度决定你未来的高度，所以，美术基础有多重要不用说大家也知道，我们要通过对角色的姿势进行绘制，人体结构的把握，通过基础的线条练习加强对形体轮廓的勾勒、对色彩理论的了解和色彩运用的方法、讲解构图法则、技巧、构图方式、透视，在实际中掌握方法与技巧、熟悉Photoshop等基本软件操作，然后进行命题创作。\r\n二、角色设计\r\n对一名原画师来说，角色设计是一名原画师必须要知道的知识，这个就像美术基础一样，学习角色搭配相应的服饰、道具、以及纹理，还有基本的表现手法。了解原画的设计流程，把握色性格、身份特点，将角色应用自如。\r\n三、场景设计\r\n在原画师设计完角色之后，就是场景设计，在加上之前的基础，这三个对原画师来说是至关重要的。场景设计是要学习不同时代、不同民族、不同文化背景下的建筑设计风格及元素运用技巧，如何运用笔刷已达到更快更出色的效果。学习不同风格场景的设计理念，如何搭建一个自己想要的世界。学习如何通过光影、色彩布局和细节等来创造具有恐惧感、视觉冲击力的概念场景。\r\n', 'http://localhost:8080/isay-web/post_photo/1527916477574.jpg', '2018-06-02 13:16:35');
INSERT INTO `solr_post` VALUES ('5', '1527916795652ZR8W1S3', '【供应链金融】一文全面深度分析供应链金融精华', '不同的行业，不同的方式，不同的速度，相同的却是双向的渗透和融合。供应链金融正是产业资本与金融资本跨界的融合。或迅疾如风、或激烈如火、或柔韧如水，跨界融合，正孕育全新的商业逻辑和投资机会。\r\n供应链金融作为产业模式升级的自然演化，“从产业中来，到金融中去”，具有深厚的行业根基，颠覆了传统金融“基于金融而金融”的范式，打开另一扇窗，兼具金融的爆发力和产业的持久性。\r\n如何评价供应链金融的业务质量？我们提出五维模型：大产业、弱上下游、强控制力、低成本与高杠杆、标准化。大产业是指产业空间大，不易触碰天花板；弱上下游是指客户端中，至少有一环较为弱势，无法从银行获得廉价资金；强控制力是指线上具有真实交易数据和征信、线下拥有物流仓储作后盾，从而控制风险；低成本是指资金的成本低，让供应链金融有利可图而又不过度增加融资方负担，高杠杆是一定本金投入能撬动较大资产体量；标准化是指用于融资的抵押品（抵押）相对标准化，有公允市场，即便出险，也能快速出清。如果同时具备五大要素，则供应链金融水到渠成。\r\n潜在标的有哪些？看下文！根据五维模型，大宗商品、行业或区域龙头、行业信息化服务商、电商平台、专业市场等五大领域是供应链金融的沃土。\r\n1. 抢滩金融服务空白中小企业融资难一直是社会顽疾，在经济换挡期，尤为如此。扩大再生产，要么通过内生式积累，要么借道民间高利贷。年化8%-20%之间的融资成本，成为传统金融的盲点，也因此成为金融创新的主战场。\r\n供应链金融最大创新在于填补8%-20%的融资利率空白，打开中小企业融资阀门。理论上银行是中小企业最理想的融资对像，成本在6%-8%之间。但从收益风险配比角度看，银行更愿意将资金大门向大型企业敞开，而不愿承受过高风险。\r\n中小企业被迫转向民间借贷，而民间借贷的平均利率在27%左右，高企的融资成本挤压了中小企业的生存空间，减少了中小企业的投资，不利于整个供应链的发展。\r\n8%-20%融资服务的空白，背后折射的是金融服务的结构性缺失，以及社会资本对中小企业所要求的不合理的过高风险补偿。\r\n和传统非银机构相比,供应链金融具备太多优势：\r\n1）供应链金融依托在产业多年的浸淫，风控端天然具备优势；\r\n2）如果说非银机构做的是纯粹金融，则供应链金融则是在试图构建金融生态；\r\n3）在供应链金融体系中，各非银机构均成为体系中一部分；\r\n4）供应链金融本质上属于大数据金融，延展性更佳。\r\n2. 痛点孕育变革宏观经济下行大背景下，中小企业生存状况堪忧，尤其是融资难问题更为突出。一直以来，由于信用缺失、固定资产等抵押担保品少、财务信息不透明等，中小企业的融资是个顽疾，近年来尽管国家出台了多项舒缓中小企业融资难的举措，但银行等主流资金供应方惜贷现象仍未有效改善，中小企业要么通过内生积累，要么高成本通过非银行金融机构获得资金。\r\n中小企业痛点：融资难、融资贵、融资乱、融资险。多层次金融市场的缺失，使得中小企业暴露于无主流金融机构覆盖的尴尬境地，中小企业融资也多是“富贵险中求”，融资成本高企，且相应金融服务机构散、乱，对中小企业稳定经营造成重大影响。\r\n从另一方面讲，针对中小企业的金融服务仍是一片尚未被充分开发的大市场，新的金融模式、新的技术应用都可能彻底启动行业崛起阀门。\r\n除了融资难，中小企业资金亦受到行业挤占：\r\n1）营收账款总规模超16万亿。以供应链上游企业为例，截止2012年应收账款余额已经达到16.6万亿，中小企业现金压力巨大；\r\n2）赊销期的延长。根据《2014科法斯中国企业信用风险报告》，2013年31.7%的企业赊销期大于60天，明显高于2012年20.3%的企业占比，总体信用进一步恶化的趋势非常明显。\r\n3. 核心企业“转型痛”中国正处于经济的换挡期，行业产能过程、转型压力自不必多讲，但就产业中企业来讲，由于自身优劣势禀赋不同，在转型大潮中表现出不同的诉求。小部分掌握了产业核心资源的企业，希望利用金融业务将其在行业中长期建立起来的优势变现；大部分中小微企业则对解决融资问题具有更强的偏好。\r\n无疑，供应链金融对整个产业链的再升级都是战略级突破口。\r\n产能过剩已经成为行业性趋势，核心企业亦未能幸免。如：1）粗钢产能利用率2014年降到最低点70%，产能严重过剩；2）截至2015年1月，工业企业利润总额累计同比负增长4.23%，盈利能力持续下滑。在行业性大趋势下，核心企业盈利能力也大幅下降。\r\n4. 直击痛点，多方共赢行业层面无阻力，供应链金融的生长将极为舒展。行业趋势总是向阻力最小的方向发展，供应链金融无论对于核心企业还是中小微企业，乃至物流企业都具备明显的益处，利益的产生并非存量之间的博弈，而是增量的创造。同时互联网的发展更为供应链金融提供了难得的时代背景，多方共赢提供充足动力。\r\n供应链金融如何开展？结论极其简洁：核心企业的“转型痛”创造供给，中小企业的“融资痛”创造需求，而两者的碰撞必将催生出新的蓝海业务。\r\n', '', '2018-06-02 13:19:56');
INSERT INTO `solr_post` VALUES ('6', '1528255724866WGPRAGI', '2018校招笔试真题汇总 ', '科大讯飞：2018秋招笔试科大讯飞java笔试试题https://www.nowcoder.com/discuss/67684?type=2&order=3&pos=13&page=0\r\n锐捷：2018秋招锐捷笔试试题https://www.nowcoder.com/discuss/67760?type=2&order=3&pos=8&page=0锐捷2018秋招笔试题https://www.nowcoder.com/discuss/80796?type=2&order=3&pos=30&page=0\r\n58同城：58同城2018秋招前端笔试试题分享\r\nhttps://www.nowcoder.com/discuss/67508?type=2&order=3&pos=21&page=1\r\n2018秋招58同城笔试题分享\r\nhttps://www.nowcoder.com/discuss/69136?type=0&order=3&pos=6&page=0\r\n阿里巴巴：2018秋招阿里巴巴java笔试试题https://www.nowcoder.com/discuss/67379?type=2&order=3&pos=29&page=1阿里巴巴2018秋招正式试题https://www.nowcoder.com/discuss/79947?type=2&order=3&pos=103&page=1\r\n途牛：2018秋招途牛笔试试题分享，期待春招offer！https://www.nowcoder.com/discuss/68700?type=0&order=3&pos=6&page=0\r\n饿了么：饿了么2018秋招笔试前端试题\r\nhttps://www.nowcoder.com/discuss/68831?type=0&order=3&pos=7&page=0\r\n360https://www.nowcoder.com/discuss/68965?type=0&order=3&pos=8&page=0\r\n2018秋招360笔试题分享，求春招offer\r\nhttps://www.nowcoder.com/discuss/69239?type=2&order=3&pos=7&page=0\r\nfreelwheel2018秋招freewheel java笔试题，祝大家春招好运\r\nhttps://www.nowcoder.com/discuss/69430?type=0&order=3&pos=6&page=0\r\n哔哩哔哩https://www.nowcoder.com/discuss/69560?type=0&order=3&pos=6&page=0bilibili 2018秋招试题https://www.nowcoder.com/discuss/79943?type=2&order=3&pos=105&page=1\r\n贝贝贝贝2018秋招测评题，已拿offer\r\nhttps://www.nowcoder.com/discuss/70106?type=0&order=3&pos=6&page=0分享求好运~2018秋招贝贝客户端笔试题https://www.nowcoder.com/discuss/70519\r\n多益网络多益2018秋招笔试题，回馈大家\r\nhttps://www.nowcoder.com/discuss/70676?type=0&order=3&pos=7&page=0\r\n多益网络2018秋招试题\r\nhttps://www.nowcoder.com/discuss/71073?type=0&order=3&pos=6&page=0\r\n2018秋招多益网络iq测试题（一）\r\nhttps://www.nowcoder.com/discuss/78012\r\n2018秋招多益网络iq测试题（二）\r\nhttps://www.nowcoder.com/discuss/78164?type=2&order=3&pos=16&page=0\r\n今日头条2018秋招今日头条测评题，分享给大家~\r\nhttps://www.nowcoder.com/discuss/72131?type=0&order=3&pos=6&page=0\r\n今日头条2018校招测试开发方向（第一批）\r\nhttps://www.nowcoder.com/test/8537290/summary\r\n今日头条2018校招算法方向（第一批）https://www.nowcoder.com/test/8537279/summary\r\n今日头条2018校招大数据方向（第一批）\r\nhttps://www.nowcoder.com/test/8537283/summary\r\n今日头条2018校招测试开发方向（第二批）\r\nhttps://www.nowcoder.com/test/8537269/summary\r\n今日头条2018校招Android方向（第二批）\r\nhttps://www.nowcoder.com/test/8537261/summary\r\n今日头条2018校招ios方向（第二批）\r\nhttps://www.nowcoder.com/test/8537251/summary\r\n今日头条2018校招前端方向（第二批）\r\nhttps://www.nowcoder.com/test/8537237/summary\r\n今日头条2018校招算法方向（第二批）\r\nhttps://www.nowcoder.com/test/8537228/summary\r\n今日头条2018校招大数据方向（第二批）\r\nhttps://www.nowcoder.com/test/8537218/summary\r\n今日头条2018校招后端方向（第二批）\r\nhttps://www.nowcoder.com/test/8537209/summary\r\n今日头条2018校招后端方向（第三批）\r\nhttps://www.nowcoder.com/test/8537140/summary\r\n今日头条2018校招ios方向（第三批）https://www.nowcoder.com/test/8537129/summary\r\n今日头条2018校招大数据方向（第三批）https://www.nowcoder.com/test/8537109/summary\r\n今日头条2018校招前端方向（第三批）\r\nhttps://www.nowcoder.com/test/8537093/summary\r\n今日头条2018校招Android方向（第三批）\r\nhttps://www.nowcoder.com/test/8537072/summary\r\n今日头条2018校招算法方向（第三批）https://www.nowcoder.com/test/8537068/summary\r\n今日头条2018校招测试开发方向（第三批）https://www.nowcoder.com/test/8537047/summary\r\n今日头条2018校招Android方向（第四批）\r\nhttps://www.nowcoder.com/test/8537041/summary\r\n今日头条2018校招后端方向（第四批）\r\nhttps://www.nowcoder.com/test/8537039/summary\r\n今日头条2018校招算法方向（第四批）\r\nhttps://www.nowcoder.com/test/8537023/summary\r\n今日头条2018招聘测试开发方向（第四批）\r\nhttps://www.nowcoder.com/test/8536903/summary\r\n今日头条2018校招iOS方向（第四批）\r\nhttps://www.nowcoder.com/test/8536763/summary\r\n今日头条2018校招大数据方向（第四批）\r\nhttps://www.nowcoder.com/test/8536722/summary\r\n今日头条2018校招前端方向（第四批）\r\nhttps://www.nowcoder.com/test/8536639/summary\r\n链家2018秋招链家前端笔试题，晚上考试加油\r\nhttps://www.nowcoder.com/discuss/72559?type=0&order=3&pos=6&page=0\r\n链家2018秋招java笔试题\r\nhttps://www.nowcoder.com/discuss/78509\r\n去哪儿去哪儿2018秋招前端笔试题，求好运\r\nhttps://www.nowcoder.com/discuss/73058?type=0&order=3&pos=8&page=0去哪儿2018秋招笔试试题https://www.nowcoder.com/discuss/80134?type=2&order=3&pos=89&page=0去哪儿 2018校招 软件开发工程师在线考试https://www.nowcoder.com/discuss/80136?type=2&order=3&pos=88&page=0\r\n酷狗酷狗java2018秋招笔试题目，谢谢大家捧场\r\nhttps://www.nowcoder.com/discuss/73425?type=2&order=3&pos=8&page=0\r\n联想联想2018秋招java笔试题目，牛客奖品在向我招手~\r\nhttps://www.nowcoder.com/discuss/75053?type=2&order=3&pos=9&page=0\r\n绿盟科技回馈帖：2018秋招绿盟科技测试题\r\nhttps://www.nowcoder.com/discuss/75403\r\n绿盟科技2018秋招测评\r\nhttps://www.nowcoder.com/discuss/78791?type=2&order=3&pos=19&page=1\r\n美图美图2018秋招java笔试题\r\nhttps://www.nowcoder.com/discuss/78792?type=2&order=3&pos=18&page=1\r\n美图2018秋招客户端测试题\r\nhttps://www.nowcoder.com/discuss/78793?type=2&order=3&pos=17&page=1\r\n美图2018秋招前端试题\r\nhttps://www.nowcoder.com/discuss/78838?type=2&order=3&pos=15&page=1\r\n美团美团点评2018秋招笔试题https://www.nowcoder.com/discuss/79070?type=2&order=3&pos=63&page=0\r\n美团点评2018秋招笔试题https://www.nowcoder.com/discuss/79070?type=2&order=3&pos=63&page=0美团点评2018秋招测评题目https://www.nowcoder.com/discuss/79277?type=2&order=3&pos=52&page=1美团点评2018秋招前端测评https://www.nowcoder.com/discuss/79279?type=2&order=3&pos=51&page=1美团点评2018秋招正式题目https://www.nowcoder.com/discuss/79393?type=2&order=3&pos=44&page=0\r\n盛大游戏盛大游戏2018秋招Java笔试题https://www.nowcoder.com/discuss/79398?type=2&order=3&pos=43&page=0\r\n艺龙艺龙2018秋招Java笔试题https://www.nowcoder.com/discuss/79634?type=2&order=3&pos=23&page=0艺龙2018秋招前端试题https://www.nowcoder.com/discuss/79635?type=2&order=3&pos=22&page=0\r\n猪八戒猪八戒2018秋招Java笔试https://www.nowcoder.com/discuss/79730?type=2&order=3&pos=16&page=0猪八戒2018秋招前端试题https://www.nowcoder.com/discuss/79732?type=2&order=3&pos=15&page=1\r\neBayeBay2018秋招Java试题https://www.nowcoder.com/discuss/79945?type=2&order=3&pos=104&page=0\r\n高新兴高新兴 2018秋招笔试试题https://www.nowcoder.com/discuss/80137?type=2&order=3&pos=87&page=1\r\n百度百度2018秋招客户端试题\r\nhttps://www.nowcoder.com/discuss/80355?type=2&order=3&pos=67&page=0\r\n百度2018秋招产品运营笔试试卷问答题\r\nhttps://www.nowcoder.com/test/10613730/summary\r\n趣店趣店2018秋招笔试题目https://www.nowcoder.com/discuss/80554?type=2&order=3&pos=50&page=0\r\n神州付神州付2018秋招笔试试题https://www.nowcoder.com/discuss/80884?type=2&order=3&pos=18&page=1\r\n搜狗搜狗2018秋招前端试题\r\nhttps://www.nowcoder.com/discuss/80975?type=2&order=3&pos=11&page=0搜狗2018秋招Java笔试试题https://www.nowcoder.com/discuss/81137?type=2&order=3&pos=123&page=1搜狗2018秋招Java笔试题https://www.nowcoder.com/discuss/81135?type=2&order=3&pos=124&page=0搜狗2018秋招Java客户端试题https://www.nowcoder.com/discuss/81449?type=2&order=3&pos=94&page=0\r\n搜狐搜狐2018秋招第一批-社交产品中心-设计类试卷\r\nhttps://www.nowcoder.com/test/10614549/summary\r\n搜狐2018秋招第一批-社交产品中心-狐友产品专员及邮箱产品经理\r\nhttps://www.nowcoder.com/test/10614529/summary\r\n搜狐2018秋招第一批-搜狐媒体产品类试卷\r\nhttps://www.nowcoder.com/test/10614456/summary\r\n搜狐2018秋招第一批-搜狐媒体内容运营类试卷\r\nhttps://www.nowcoder.com/test/10614439/summary\r\n搜狐2018秋招第一批-搜狐焦点非技术类试卷\r\nhttps://www.nowcoder.com/test/10614388/summary\r\n搜狐2018秋招第一批-社交产品中心-狐友运营专员及产品经理运营方向试卷\r\nhttps://www.nowcoder.com/test/10614281/summary\r\n搜狐2018秋招第一批社交产品中心-内容运营专员试卷\r\nhttps://www.nowcoder.com/test/10614250/summary\r\n搜狐2018秋招技术类试卷\r\nhttps://www.nowcoder.com/test/10614057/summary\r\n搜狐2018秋招第二批-社交产品中心-狐友产品专员及邮箱产品经理\r\nhttps://www.nowcoder.com/test/10618056/summary\r\n搜狐2018秋招第二批-社交产品中心-狐友运营专员及产品经理运营\r\nhttps://www.nowcoder.com/test/10617860/summary\r\n搜狐2018秋招第二批-社交产品中心-内容运营专员试卷\r\nhttps://www.nowcoder.com/test/10617841/summary\r\n搜狐2018秋招第二批-社交产品中心-设计类试卷\r\nhttps://www.nowcoder.com/test/10617827/summary\r\n搜狐2018秋招第二批-社交产品中心-测试工程师试卷\r\nhttps://www.nowcoder.com/test/10617815/summary\r\n搜狐2018秋招第二批-搜狐媒体内容运营类试卷\r\nhttps://www.nowcoder.com/test/10617729/summary\r\n搜狐2018秋招第二批-搜狐媒体产品类试卷\r\nhttps://www.nowcoder.com/test/10617688/summary\r\n搜狐2018秋招第二批-技术类试卷\r\nhttps://www.nowcoder.com/test/10617414/summary\r\n搜狐畅游搜狐畅游18届游戏开发实习生笔试题20170705\r\nhttps://www.nowcoder.com/test/10695324/summary\r\n搜狐畅游18届游戏开发实习生笔试题20170526\r\nhttps://www.nowcoder.com/test/10695402/summary\r\n搜狐畅游2018校招笔试题-游戏开发工程师（C#、C++）https://www.nowcoder.com/test/10695109/summary\r\n搜狐畅游2018校招笔试题-游戏开发工程师（java）\r\nhttps://www.nowcoder.com/test/10694989/summary\r\n搜狐畅游2018系统策划非游戏基础题部分A卷（测试）\r\nhttps://www.nowcoder.com/test/8209575/summary\r\n搜狐畅游2018游戏系统策划非游戏基础部分题笔试试卷—B卷\r\nhttps://www.nowcoder.com/test/8209615/summary\r\n搜狐畅游2018游戏开发工程师（C++ C#）非游戏基础题部分笔试\r\nhttps://www.nowcoder.com/test/8209507/summary\r\n搜狐畅游2018游戏开发工程师（Java）非游戏基础题部分笔试试卷\r\nhttps://www.nowcoder.com/test/8209441/summary\r\n搜狐畅游2018游戏数值策划非游戏基础题部分 笔试试卷—A卷\r\nhttps://www.nowcoder.com/test/8209247/summary\r\n搜狐畅游2018游戏数值策划非游戏基础题部分 笔试试卷—B卷https://www.nowcoder.com/test/8209291/summary\r\n搜狐畅游2018游戏剧情策划非游戏基础题部分笔试试卷https://www.nowcoder.com/test/8207543/summary\r\n', '', '2018-06-06 11:28:45');
INSERT INTO `solr_post` VALUES ('7', '1528255993638XBM8D6Y', '手绘--叶子，叶子', '\r\n叶子确也很美呀～\r\n\r\n', 'http://localhost:8080/isay-web/post_photo/1528255971119.jpg', '2018-06-06 11:33:14');
INSERT INTO `solr_post` VALUES ('8', '1537496128436X4XGLNE', '涂山苏苏', '涂山苏苏，中国漫画《狐妖小红娘》及其衍生作品中的女主角。呆萌迷糊的小狐妖，总是携带各种零食。法力低微，总是被评价为笨蛋蠢货，所以一直有个心愿就是成为一名正式红线仙来证明自己是真正的狐妖。实际上，涂山苏苏是涂山红红失去妖力和记忆而变成的女孩。在一气道盟和涂山的安排下，与白月初相遇并联手解决红线仙的任务。\r\n\r\n', 'http://localhost:8080/isay-web/post_photo/1537495971160.jpg', '2018-09-21 10:15:28');

-- ----------------------------
-- Table structure for throw_pot
-- ----------------------------
DROP TABLE IF EXISTS `throw_pot`;
CREATE TABLE `throw_pot` (
  `pot_area_id` int(11) NOT NULL,
  `flower_num` int(11) NOT NULL DEFAULT '0',
  `hammer_num` int(11) NOT NULL DEFAULT '0',
  `pot_num` int(11) NOT NULL DEFAULT '0',
  `agent_num` int(11) NOT NULL DEFAULT '0',
  `hat_num` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`pot_area_id`),
  CONSTRAINT `fk_tp_a` FOREIGN KEY (`pot_area_id`) REFERENCES `work_area` (`area_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='甩锅';

-- ----------------------------
-- Records of throw_pot
-- ----------------------------

-- ----------------------------
-- Table structure for throw_pot_detail
-- ----------------------------
DROP TABLE IF EXISTS `throw_pot_detail`;
CREATE TABLE `throw_pot_detail` (
  `tpd_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` char(32) NOT NULL,
  `from_area_id` int(11) NOT NULL,
  `to_area_id` int(11) NOT NULL,
  `gift` enum('1','2','3','4','5') NOT NULL DEFAULT '1' COMMENT '''花，锤，锅，人，帽''',
  `tpd_time` datetime NOT NULL,
  PRIMARY KEY (`tpd_id`),
  KEY `fk_tpd_f` (`from_area_id`),
  KEY `fk_tpd_t` (`to_area_id`),
  CONSTRAINT `fk_tpd_f` FOREIGN KEY (`from_area_id`) REFERENCES `work_area` (`area_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tpd_t` FOREIGN KEY (`to_area_id`) REFERENCES `work_area` (`area_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='甩锅详情';

-- ----------------------------
-- Records of throw_pot_detail
-- ----------------------------

-- ----------------------------
-- Table structure for vote
-- ----------------------------
DROP TABLE IF EXISTS `vote`;
CREATE TABLE `vote` (
  `vote_id` char(20) NOT NULL,
  `vote_content` varchar(1024) NOT NULL,
  `vote_time` datetime NOT NULL,
  `user_id` char(32) NOT NULL,
  `is_delete` enum('0','1') NOT NULL DEFAULT '0' COMMENT '''0-未删除；1-已删除''',
  `area_id` int(11) NOT NULL,
  PRIMARY KEY (`vote_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='投票';

-- ----------------------------
-- Records of vote
-- ----------------------------
INSERT INTO `vote` VALUES ('15239372439769694TCW', '芙蓉雨 - 刘珂矣\r\n词：刘珂矣/百慕三石\r\n曲：刘珂矣/百慕三石\r\n编曲：刘珂矣\r\n藕花香染檐牙\r\n惹那诗人纵步随她\r\n佩声微琴声儿退\r\n斗胆了一池眉叶丹砂\r\n画船开心随他\r\n谁不作美偏起风沙\r\n倚蓬窗月色轻晃\r\n偶闻得渔翁一席话\r\n试问多一份情又怎地\r\n站在别人的雨季\r\n淋湿自己空弹一出戏\r\n空望他功成名就又怎地\r\n豆腐换成金羽衣\r\n岂不知你已在画里\r\n画船开心随他\r\n谁不作美偏起风沙\r\n倚蓬窗月色轻晃\r\n偶闻得渔翁一席话\r\n试问多一份情又怎地\r\n站在别人的雨季\r\n淋湿自己空弹一出戏\r\n空望他功成名就又怎地\r\n豆腐换成金羽衣\r\n岂不知你已在画里\r\n多一份情又怎地\r\n站在别人的雨季\r\n淋湿自己空弹一出戏\r\n空望他功成名就又怎地\r\n豆腐换成金羽衣\r\n岂不知你已在画里\r\n这一搭莲蓬子落地几回迷\r\n', '2018-04-17 11:54:04', '1526179403208IWBRWA6', '0', '1');
INSERT INTO `vote` VALUES ('1523945155899PUQJ11M', '我是真的爱上你 - 王杰\r\n词：汤小康/刘杰胜\r\n曲：汤小康\r\n你有一双会说话的眼睛\r\n你有善解人意的心\r\n不知天高地厚的我\r\n你的微笑总是让我为你着迷\r\n你有一双深情的眼睛\r\n你有融化冰雪的魔力\r\n从来不敢奢求的我\r\n你的美丽总是让我躲不过去\r\n什么原因你的发香 总挥之不去\r\n我的世界 什么时候\r\n开始昼夜难分\r\n翻天覆地来去都是因为想你\r\n喔 偷偷的爱上你\r\n却不敢告诉你\r\n因为我知道我给不到你要的东西\r\n喔 只能偷偷的爱上你\r\n只能偷偷看着你\r\n总是没勇气\r\n总说不出我是真的爱上你\r\n你有一双深情的眼睛 oh\r\n你有融化冰雪的魔力 oh\r\n从来不敢奢求的我\r\n你的美丽总是让我躲不过去\r\n什么原因你的发香 总挥之不去\r\n我的世界 什么时候\r\n开始昼夜难分\r\n翻天覆地来去都是因为想你\r\n喔 偷偷的爱上你\r\n却不敢告诉你\r\n因为我知道我给不到你要的东西\r\n喔 只能偷偷的爱上你\r\n只能偷偷看着你\r\n总是没勇气\r\n总说不出我是真的爱上你\r\n喔 偷偷的爱上你\r\n却不敢告诉你\r\n因为我知道我给不到你要的东西\r\n喔 只能偷偷的爱上你\r\n只能偷偷看着你\r\n总是没勇气\r\n总说不出我是真的爱上你\r\n', '2018-04-17 14:05:56', '1526179403208IWBRWA6', '0', '2');
INSERT INTO `vote` VALUES ('1526543982195TE2VFLT', '设计是把一种设想通过合理的规划、周密的计划、通过各种感觉形式传达出来的过程。人类通过劳动改造世界，创造文明，创造物质财富和精神财富，而最基础、最主要的创造活动是造物。设计便是造物活动进行预先的计划，可以把任何造物活动的计划技术和计划过程理解为设计。', '2018-05-17 15:59:42', '15248859107335YA2M37', '0', '3');
INSERT INTO `vote` VALUES ('1526627057330JHYNIFD', '<span style=\"color: rgb(128, 128, 128); font-family: -apple-system, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, &quot;Source Han Sans SC&quot;, &quot;Noto Sans CJK SC&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 15px; white-space: pre-wrap;\">据国外媒体报道，受监管收紧担忧影响，周二比特币价格一度大跌25%，自去年12月初以来首次跌破11000美元关口。</span>', '2018-05-18 15:04:17', '1526179403208IWBRWA6', '0', '5');

-- ----------------------------
-- Table structure for voter
-- ----------------------------
DROP TABLE IF EXISTS `voter`;
CREATE TABLE `voter` (
  `voter_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` char(32) NOT NULL,
  `vi_id` int(11) NOT NULL,
  `vote_id` char(20) NOT NULL COMMENT '''添加此栏位，是为了确保每个用户只能投每个Vote中的一个投票项''',
  PRIMARY KEY (`voter_id`),
  KEY `fk_v_vi` (`vi_id`),
  KEY `fk_v_v` (`vote_id`),
  CONSTRAINT `fk_v_v` FOREIGN KEY (`vote_id`) REFERENCES `vote` (`vote_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_v_vi` FOREIGN KEY (`vi_id`) REFERENCES `vote_item` (`vi_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='投票者';

-- ----------------------------
-- Records of voter
-- ----------------------------
INSERT INTO `voter` VALUES ('2', '1526179403208IWBRWA6', '1', '15239372439769694TCW');
INSERT INTO `voter` VALUES ('3', '1526179403208IWBRWA6', '5', '1523945155899PUQJ11M');
INSERT INTO `voter` VALUES ('4', '1526179403208IWBRWA6', '7', '1526543982195TE2VFLT');
INSERT INTO `voter` VALUES ('5', '1526179403208IWBRWA6', '11', '1526627057330JHYNIFD');

-- ----------------------------
-- Table structure for vote_item
-- ----------------------------
DROP TABLE IF EXISTS `vote_item`;
CREATE TABLE `vote_item` (
  `vi_id` int(11) NOT NULL AUTO_INCREMENT,
  `vi_content` varchar(255) NOT NULL,
  `vote_num` int(11) NOT NULL,
  `vote_id` char(20) NOT NULL,
  PRIMARY KEY (`vi_id`),
  KEY `fk_vi_v` (`vote_id`),
  CONSTRAINT `fk_vi_v` FOREIGN KEY (`vote_id`) REFERENCES `vote` (`vote_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='投票选项';

-- ----------------------------
-- Records of vote_item
-- ----------------------------
INSERT INTO `vote_item` VALUES ('1', '好喜欢这首歌！！听到这歌曲就被带入了意境！好美的歌曲！！', '1', '15239372439769694TCW');
INSERT INTO `vote_item` VALUES ('2', '听到这个美女唱歌都有一种想翩翩起舞的感觉', '0', '15239372439769694TCW');
INSERT INTO `vote_item` VALUES ('3', '喜欢古风歌的味道！清新脱俗', '0', '15239372439769694TCW');
INSERT INTO `vote_item` VALUES ('4', '最近一直在听王杰的歌。他最火的那段时间，我没有留下任何回忆的样子奇怪的是，以前你根本听不懂，也不喜欢的歌曲，到了一定的时间节点，有了一定的人生阅历之后，你瞬间就听懂了这些歌曲里面表达的心声歌曲从来都不会过时，但岁月无法常驻而我只相信时过境迁之后真情永驻', '0', '1523945155899PUQJ11M');
INSERT INTO `vote_item` VALUES ('5', '不知道怎么形容王杰 并不是有多喜欢他 但是他这几首歌（我是真的爱上你 谁明浪子心等）总是可以让人单曲循环 听完一遍迫不及待的再来一遍', '1', '1523945155899PUQJ11M');
INSERT INTO `vote_item` VALUES ('6', '这个歌杰哥唱的很投入，歌词也很有故事，不愧是，作日的浪子，今天的巨星，明天的传奇', '0', '1523945155899PUQJ11M');
INSERT INTO `vote_item` VALUES ('7', '赞成', '1', '1526543982195TE2VFLT');
INSERT INTO `vote_item` VALUES ('8', '反对', '0', '1526543982195TE2VFLT');
INSERT INTO `vote_item` VALUES ('9', '中立', '0', '1526543982195TE2VFLT');
INSERT INTO `vote_item` VALUES ('10', '依然抱有希望', '0', '1526627057330JHYNIFD');
INSERT INTO `vote_item` VALUES ('11', '不看好', '1', '1526627057330JHYNIFD');

-- ----------------------------
-- Table structure for work_area
-- ----------------------------
DROP TABLE IF EXISTS `work_area`;
CREATE TABLE `work_area` (
  `area_id` int(11) NOT NULL AUTO_INCREMENT,
  `area_name` varchar(25) NOT NULL,
  PRIMARY KEY (`area_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='帖子领域';

-- ----------------------------
-- Records of work_area
-- ----------------------------
INSERT INTO `work_area` VALUES ('1', '技术');
INSERT INTO `work_area` VALUES ('2', '产品');
INSERT INTO `work_area` VALUES ('3', '设计');
INSERT INTO `work_area` VALUES ('4', '运营');
INSERT INTO `work_area` VALUES ('5', '市场');
INSERT INTO `work_area` VALUES ('6', '职能');
INSERT INTO `work_area` VALUES ('7', '金融');
DROP TRIGGER IF EXISTS `trigger_label`;
DELIMITER ;;
CREATE TRIGGER `trigger_label` AFTER INSERT ON `company_label` FOR EACH ROW begin

declare g int;
declare b int;

set g = (select good_num from company where company_id = new.company_id);
set b = (select bad_num from company where company_id = new.company_id);

if new.cl_type = '0' then
update company set good_num = g+1 where company_id = new.company_id;
else
update company set bad_num = b+1 where company_id = new.company_id;
end if;

end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `trigger_p_c`;
DELIMITER ;;
CREATE TRIGGER `trigger_p_c` AFTER INSERT ON `post_comment` FOR EACH ROW begin

declare c int;
set c = (select comment_num from post where post_id = new.post_id);
update post set comment_num = c+1 where post_id = new.post_id;

end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `trigger_p_r`;
DELIMITER ;;
CREATE TRIGGER `trigger_p_r` AFTER INSERT ON `post_reply` FOR EACH ROW begin

declare c int;
set c = (select reply_num from post_comment where comment_id = new.comment_id);
update post_comment set reply_num = c+1 where comment_id = new.comment_id;

end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `tpd_trigger`;
DELIMITER ;;
CREATE TRIGGER `tpd_trigger` AFTER INSERT ON `throw_pot_detail` FOR EACH ROW begin

declare c int;

set c = (select gift from throw_pot_detail where tpd_id = new.tpd_id);

if c = 1 then
update throw_pot set flower_num = flower_num+1 where pot_area_id = new.from_area_id;
elseif c = 2 then
update throw_pot set hammer_num = hammer_num+1 where pot_area_id = new.from_area_id;
elseif c = 3 then
update throw_pot set pot_num = pot_num+1 where pot_area_id = new.from_area_id;
elseif c = 4 then
update throw_pot set agent_num = agent_num+1 where pot_area_id = new.from_area_id;
else
update throw_pot set hat_num = hat_num+1 where pot_area_id = new.from_area_id;
end if;

end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `voter_trigger`;
DELIMITER ;;
CREATE TRIGGER `voter_trigger` AFTER INSERT ON `voter` FOR EACH ROW begin

update vote_item set vote_num = vote_num + 1 where vi_id = new.vi_id;

end
;;
DELIMITER ;
