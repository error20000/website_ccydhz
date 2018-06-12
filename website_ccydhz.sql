/*
Navicat MySQL Data Transfer

Source Server         : lj
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : website_ccydhz

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2018-06-12 18:36:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `s_active`
-- ----------------------------
DROP TABLE IF EXISTS `s_active`;
CREATE TABLE `s_active` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `date` varchar(20) DEFAULT '' COMMENT '日期  yyyy-MM-dd HH:mm:ss',
  `ip` varchar(255) DEFAULT '' COMMENT 'IP',
  `phone` varchar(255) DEFAULT '' COMMENT '参与人',
  `info` varchar(255) DEFAULT '' COMMENT '附件信息',
  `info1` varchar(255) DEFAULT '' COMMENT '附件信息1',
  `info2` text COMMENT '附件信息2',
  `info3` text COMMENT '附件信息3',
  `info4` text COMMENT '附件信息4',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of s_active
-- ----------------------------

-- ----------------------------
-- Table structure for `s_active_config`
-- ----------------------------
DROP TABLE IF EXISTS `s_active_config`;
CREATE TABLE `s_active_config` (
  `pid` int(11) NOT NULL COMMENT '主键',
  `type` int(11) DEFAULT '0' COMMENT '分类',
  `name` varchar(255) DEFAULT '' COMMENT '名称',
  `painter` varchar(255) DEFAULT '' COMMENT '画师',
  `cv` varchar(255) DEFAULT NULL COMMENT 'CV',
  `ship` varchar(255) DEFAULT '' COMMENT '舰种',
  `star` tinyint(4) DEFAULT '0' COMMENT '星级',
  `pic` text COMMENT '图片',
  `desc` text COMMENT '描述',
  `info` varchar(255) DEFAULT NULL COMMENT '附加信息',
  `sort` int(10) DEFAULT '999' COMMENT '排序',
  `chance` double DEFAULT '0' COMMENT '概率',
  `chance_z` varchar(255) DEFAULT NULL COMMENT '中奖区间',
  `count` int(10) DEFAULT '0' COMMENT '数量  -1  不限',
  PRIMARY KEY (`pid`),
  KEY `ip` (`name`(191),`cv`(191)) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of s_active_config
-- ----------------------------
INSERT INTO `s_active_config` VALUES ('1', '2', 'test11', '', '11', '', '0', '', '', '', '999', null, '', '0');
INSERT INTO `s_active_config` VALUES ('2', '2', 'test22', '', '2233', '', '0', '', '', '', '999', null, '', '0');
INSERT INTO `s_active_config` VALUES ('3', '2', 'test33', '', '33', '', '0', '11111', '', '', '999', null, '', '0');
INSERT INTO `s_active_config` VALUES ('204', '14', '德皇手办', '', '1001', '', '0', null, null, '', '999', null, '[500,502]', '1');
INSERT INTO `s_active_config` VALUES ('205', '14', '采购币*233', '', '1002', '', '0', null, null, '', '999', null, '[10000,10005]', '40');
INSERT INTO `s_active_config` VALUES ('206', '14', '铁血狗周边', '', '1003', '', '0', null, null, '', '999', null, '[15000,15020]', '40');
INSERT INTO `s_active_config` VALUES ('207', '14', '资源大礼包', '', '1004', '', '0', null, null, '', '999', null, '[20000,20004]', '1');
INSERT INTO `s_active_config` VALUES ('208', '14', '抱枕', '', '1005', '', '0', null, null, '', '999', null, '[25000,25004]', '5');
INSERT INTO `s_active_config` VALUES ('209', '14', '官方设定集', '', '1006', '', '0', null, null, '', '999', null, '[30000,30004]', '5');
INSERT INTO `s_active_config` VALUES ('210', '14', 'PS4游戏机', '', '1007', '', '0', null, null, '', '999', null, '[35000,35002]', '0');
INSERT INTO `s_active_config` VALUES ('211', '15', '德皇手办', '', '1001', '', '0', '', '', '', '999', null, '[500,501]', '1');
INSERT INTO `s_active_config` VALUES ('212', '15', '采购币*233', '', '1002', '', '0', '', '', '', '999', null, '[10000,10005]', '20');
INSERT INTO `s_active_config` VALUES ('213', '15', '铁血狗周边', '', '1003', '', '0', '', '', '', '999', null, '[15000,15020]', '5');
INSERT INTO `s_active_config` VALUES ('214', '15', '资源大礼包', '', '1004', '', '0', '', '', '', '999', null, '[20000,20004]', '1');
INSERT INTO `s_active_config` VALUES ('215', '15', '官方设定集', '', '1005', '', '0', '', '', '', '999', null, '[25000,25004]', '1');
INSERT INTO `s_active_config` VALUES ('216', '15', '任天堂switch', '', '1006', '', '0', '', '', '', '999', null, '[30000,30004]', '0');
INSERT INTO `s_active_config` VALUES ('217', '15', '200元京东卡', '', '1007', '', '0', '', '', '', '999', null, '[35000,35004]', '0');

-- ----------------------------
-- Table structure for `s_active_type`
-- ----------------------------
DROP TABLE IF EXISTS `s_active_type`;
CREATE TABLE `s_active_type` (
  `pid` int(10) NOT NULL COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '名称',
  `start` varchar(20) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '开始时间  yyyy-MM-dd HH:mm:ss',
  `end` varchar(20) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '结束时间  yyyy-MM-dd HH:mm:ss',
  `status` tinyint(4) DEFAULT '0' COMMENT '状态   0 -- 关闭  1 --开启',
  `count` int(11) DEFAULT '0' COMMENT '参加次数   小于0 --- 无限',
  `sCount` int(11) DEFAULT '0' COMMENT '分享次数 ',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_active_type
-- ----------------------------
INSERT INTO `s_active_type` VALUES ('1', '预约', '', '2017-08-25 10:00:00', '1', '0', '0');
INSERT INTO `s_active_type` VALUES ('2', '圣捞人形限定大选--A组', '', '', '0', '0', '0');
INSERT INTO `s_active_type` VALUES ('14', '2017周年庆抽奖', '2017-05-03 00:00:00', '2017-05-30 00:00:00', '0', '0', '0');
INSERT INTO `s_active_type` VALUES ('15', '猎兔行动抽奖', '2017-06-17 00:00:00', '2017-06-20 00:00:00', '0', '0', '0');

-- ----------------------------
-- Table structure for `s_bespeak`
-- ----------------------------
DROP TABLE IF EXISTS `s_bespeak`;
CREATE TABLE `s_bespeak` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `date` varchar(20) DEFAULT '' COMMENT '日期',
  `ip` varchar(255) DEFAULT '' COMMENT 'ip',
  `phone` varchar(20) DEFAULT '' COMMENT '手机号',
  `info` varchar(255) DEFAULT '' COMMENT '附加信息',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='预约';

-- ----------------------------
-- Records of s_bespeak
-- ----------------------------

-- ----------------------------
-- Table structure for `s_business`
-- ----------------------------
DROP TABLE IF EXISTS `s_business`;
CREATE TABLE `s_business` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `lang` int(11) DEFAULT '0' COMMENT '语言版本',
  `type` int(11) DEFAULT '0' COMMENT '分类',
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  `icon` text COMMENT '图片',
  `site` text COMMENT '地址',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_business
-- ----------------------------

-- ----------------------------
-- Table structure for `s_business_type`
-- ----------------------------
DROP TABLE IF EXISTS `s_business_type`;
CREATE TABLE `s_business_type` (
  `pid` int(11) NOT NULL DEFAULT '0' COMMENT '主键',
  `lang` int(11) DEFAULT '0' COMMENT '语言版本',
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  `icon` text COMMENT '图片',
  `sort` int(11) DEFAULT '999',
  `home` tinyint(2) DEFAULT '1' COMMENT '首页展示',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_business_type
-- ----------------------------
INSERT INTO `s_business_type` VALUES ('1', '0', '合作媒体', null, '999', '1');

-- ----------------------------
-- Table structure for `s_contact`
-- ----------------------------
DROP TABLE IF EXISTS `s_contact`;
CREATE TABLE `s_contact` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `lang` int(11) DEFAULT '0' COMMENT '语言版本',
  `type` int(11) DEFAULT '0' COMMENT '分类',
  `mark` int(11) DEFAULT '0' COMMENT '社交分类',
  `name` varchar(255) DEFAULT '' COMMENT '名称',
  `value` varchar(255) DEFAULT '' COMMENT '值',
  `site` text COMMENT '地址',
  `pic` text COMMENT '图片',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_contact
-- ----------------------------

-- ----------------------------
-- Table structure for `s_contact_mark`
-- ----------------------------
DROP TABLE IF EXISTS `s_contact_mark`;
CREATE TABLE `s_contact_mark` (
  `pid` int(11) NOT NULL DEFAULT '0' COMMENT '主键',
  `lang` int(11) DEFAULT '0' COMMENT '语言版本',
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_contact_mark
-- ----------------------------
INSERT INTO `s_contact_mark` VALUES ('1', '0', '微信');
INSERT INTO `s_contact_mark` VALUES ('2', '0', '新浪微博');
INSERT INTO `s_contact_mark` VALUES ('3', '0', '腾讯微博');
INSERT INTO `s_contact_mark` VALUES ('4', '0', '百度贴吧');
INSERT INTO `s_contact_mark` VALUES ('5', '0', 'FaceBook');
INSERT INTO `s_contact_mark` VALUES ('6', '0', 'Twitter');
INSERT INTO `s_contact_mark` VALUES ('7', '0', '邮箱');
INSERT INTO `s_contact_mark` VALUES ('8', '0', '电话');
INSERT INTO `s_contact_mark` VALUES ('9', '0', 'QQ');
INSERT INTO `s_contact_mark` VALUES ('10', '0', 'TapTap');

-- ----------------------------
-- Table structure for `s_contact_type`
-- ----------------------------
DROP TABLE IF EXISTS `s_contact_type`;
CREATE TABLE `s_contact_type` (
  `pid` int(11) NOT NULL DEFAULT '0' COMMENT '主键',
  `lang` int(11) DEFAULT '0' COMMENT '语言版本',
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  `icon` text COMMENT '图片',
  `sort` int(11) DEFAULT '999',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_contact_type
-- ----------------------------
INSERT INTO `s_contact_type` VALUES ('1', '0', '游戏', null, '999');
INSERT INTO `s_contact_type` VALUES ('2', '0', '客服', null, '999');

-- ----------------------------
-- Table structure for `s_download`
-- ----------------------------
DROP TABLE IF EXISTS `s_download`;
CREATE TABLE `s_download` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `lang` int(11) DEFAULT '0' COMMENT '语言版本',
  `type` int(11) DEFAULT '0' COMMENT '分类',
  `name` varchar(255) DEFAULT '' COMMENT '下载名称',
  `site` text COMMENT '下载地址',
  `pic` text COMMENT '下载按钮图片',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_download
-- ----------------------------

-- ----------------------------
-- Table structure for `s_download_type`
-- ----------------------------
DROP TABLE IF EXISTS `s_download_type`;
CREATE TABLE `s_download_type` (
  `pid` int(11) NOT NULL DEFAULT '0' COMMENT '主键',
  `lang` int(11) DEFAULT '0' COMMENT '语言版本',
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  `icon` text COMMENT '图片',
  `sort` int(11) DEFAULT '999',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_download_type
-- ----------------------------
INSERT INTO `s_download_type` VALUES ('1', '0', '扫码下载', null, '999');
INSERT INTO `s_download_type` VALUES ('2', '0', 'IOS', null, '999');
INSERT INTO `s_download_type` VALUES ('3', '0', 'Android', null, '999');
INSERT INTO `s_download_type` VALUES ('4', '0', 'TapTap', null, '999');
INSERT INTO `s_download_type` VALUES ('5', '0', 'IOS越狱', null, '999');

-- ----------------------------
-- Table structure for `s_gift_code`
-- ----------------------------
DROP TABLE IF EXISTS `s_gift_code`;
CREATE TABLE `s_gift_code` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `lang` int(10) NOT NULL,
  `code` varchar(200) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL COMMENT '手机领取',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱领取',
  `other` varchar(200) DEFAULT NULL COMMENT '其他方式领取',
  `info` varchar(200) DEFAULT NULL COMMENT '附加信息',
  `date` varchar(20) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL COMMENT '0 -- 未领取， 1 -- 已领取',
  `type` tinyint(2) DEFAULT NULL COMMENT '1 -- pc  2 -- wap',
  `exchange` tinyint(2) DEFAULT '1',
  PRIMARY KEY (`id`,`lang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_gift_code
-- ----------------------------

-- ----------------------------
-- Table structure for `s_heroes`
-- ----------------------------
DROP TABLE IF EXISTS `s_heroes`;
CREATE TABLE `s_heroes` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `lang` int(10) DEFAULT NULL,
  `date` varchar(20) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `type` int(10) DEFAULT NULL COMMENT '分类',
  `star` tinyint(4) DEFAULT NULL COMMENT '星等',
  `level` tinyint(4) DEFAULT NULL COMMENT '等级',
  `img1` text COMMENT '图片',
  `img2` text COMMENT '图片',
  `img3` text COMMENT '图片',
  `word` text COMMENT '描述',
  `story` text COMMENT '背景故事',
  `skill` text COMMENT '技能介绍',
  `attr1` int(10) DEFAULT NULL COMMENT '属性',
  `attr2` int(10) DEFAULT NULL COMMENT '属性',
  `attr3` int(10) DEFAULT NULL COMMENT '属性',
  `attr4` int(10) DEFAULT NULL COMMENT '属性',
  `tags` text COMMENT '标签：多个标签“ , ”分隔。',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_heroes
-- ----------------------------

-- ----------------------------
-- Table structure for `s_heroes_type`
-- ----------------------------
DROP TABLE IF EXISTS `s_heroes_type`;
CREATE TABLE `s_heroes_type` (
  `pid` int(11) NOT NULL DEFAULT '0' COMMENT '主键',
  `lang` int(11) DEFAULT '0' COMMENT '语言版本',
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  `icon` text COMMENT '图片',
  `sort` int(11) DEFAULT '999',
  `home` tinyint(2) DEFAULT '1' COMMENT '首页展示',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_heroes_type
-- ----------------------------

-- ----------------------------
-- Table structure for `s_menu`
-- ----------------------------
DROP TABLE IF EXISTS `s_menu`;
CREATE TABLE `s_menu` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent` int(11) DEFAULT '0' COMMENT '父级pid',
  `name` varchar(20) DEFAULT '' COMMENT '名称',
  `site` varchar(100) DEFAULT '' COMMENT '地址',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_menu
-- ----------------------------
INSERT INTO `s_menu` VALUES ('1', '0', '界面配置', null);
INSERT INTO `s_menu` VALUES ('2', '0', '下载配置', null);
INSERT INTO `s_menu` VALUES ('3', '0', '关注我们', null);
INSERT INTO `s_menu` VALUES ('4', '0', '消息发布', null);
INSERT INTO `s_menu` VALUES ('5', '0', '礼包管理', null);
INSERT INTO `s_menu` VALUES ('6', '0', '游戏音画', null);
INSERT INTO `s_menu` VALUES ('7', '0', '游戏资料', null);
INSERT INTO `s_menu` VALUES ('8', '0', '游戏数据', null);
INSERT INTO `s_menu` VALUES ('9', '0', '合作媒体', null);
INSERT INTO `s_menu` VALUES ('10', '0', '玩家天地', null);
INSERT INTO `s_menu` VALUES ('11', '0', '邮件系统', null);
INSERT INTO `s_menu` VALUES ('12', '0', '短信系统', null);
INSERT INTO `s_menu` VALUES ('13', '0', '媒体管理', null);
INSERT INTO `s_menu` VALUES ('14', '1', 'LOGO', 'html/logo.html');
INSERT INTO `s_menu` VALUES ('15', '1', '背景', 'html/background.html');
INSERT INTO `s_menu` VALUES ('16', '1', '推荐(展示)分类', 'html/recommend_type.html');
INSERT INTO `s_menu` VALUES ('17', '1', '推荐(展示)', 'html/recommend.html');
INSERT INTO `s_menu` VALUES ('18', '1', '其他配置分类', 'html/system_other_type.html');
INSERT INTO `s_menu` VALUES ('19', '1', '其他配置', 'html/system_other.html');
INSERT INTO `s_menu` VALUES ('20', '2', '下载配置', 'html/download.html');
INSERT INTO `s_menu` VALUES ('21', '3', '微博微信分类', 'html/system_type.html');
INSERT INTO `s_menu` VALUES ('22', '3', '微博微信', 'html/system.html');
INSERT INTO `s_menu` VALUES ('23', '3', '邮箱/QQ', 'html/customer.html');
INSERT INTO `s_menu` VALUES ('24', '3', '分享', null);
INSERT INTO `s_menu` VALUES ('25', '4', '消息广告图', 'html/news_pic.html');
INSERT INTO `s_menu` VALUES ('26', '4', '消息分类', 'html/news_type.html');
INSERT INTO `s_menu` VALUES ('27', '4', '消息列表', 'html/news.html');
INSERT INTO `s_menu` VALUES ('28', '5', '礼包广告图', 'html/gift_pic.html');
INSERT INTO `s_menu` VALUES ('29', '5', '礼包列表', 'html/gift.html');
INSERT INTO `s_menu` VALUES ('30', '5', '礼包码', 'html/gift_code.html');
INSERT INTO `s_menu` VALUES ('31', '5', '领取统计', 'html/gift_count.html');
INSERT INTO `s_menu` VALUES ('32', '6', '图集分类', 'html/picture_type.html');
INSERT INTO `s_menu` VALUES ('33', '6', '图集(原画)', 'html/picture.html');
INSERT INTO `s_menu` VALUES ('34', '6', '视频分类', 'html/video_type.html');
INSERT INTO `s_menu` VALUES ('35', '6', '视频', 'html/video.html');
INSERT INTO `s_menu` VALUES ('36', '7', '资料广告图', 'html/resources_pic.html');
INSERT INTO `s_menu` VALUES ('37', '7', '资料分类', 'html/resources_type.html');
INSERT INTO `s_menu` VALUES ('38', '7', '资料详情', 'html/resources.html');
INSERT INTO `s_menu` VALUES ('39', '7', '其他资料', 'html/resources_other.html');
INSERT INTO `s_menu` VALUES ('40', '7', '介绍', 'html/product.html');
INSERT INTO `s_menu` VALUES ('41', '7', '装备分类', 'html/equipment_type.html');
INSERT INTO `s_menu` VALUES ('42', '7', '装备详情', 'html/equipment.html');
INSERT INTO `s_menu` VALUES ('43', '7', '攻略分类', 'html/strategy_type.html');
INSERT INTO `s_menu` VALUES ('44', '7', '攻略详情', 'html/strategy.html');
INSERT INTO `s_menu` VALUES ('45', '7', '英雄分类', 'html/heroes_type.html');
INSERT INTO `s_menu` VALUES ('46', '7', '英雄详情', 'html/heroes.html');
INSERT INTO `s_menu` VALUES ('47', '7', '英雄详情2', 'html/heroes2.html');
INSERT INTO `s_menu` VALUES ('48', '7', '英雄详情3', 'html/heroes3.html');
INSERT INTO `s_menu` VALUES ('49', '8', '服务器配置', 'html/server.html');
INSERT INTO `s_menu` VALUES ('50', '8', '账号转移', 'html/zhuanyi.html');
INSERT INTO `s_menu` VALUES ('51', '8', '数据接口配置', 'html/interfaces.html');
INSERT INTO `s_menu` VALUES ('52', '8', '数据导入', null);
INSERT INTO `s_menu` VALUES ('53', '8', '查询配置', null);
INSERT INTO `s_menu` VALUES ('54', '9', '合作媒体', 'html/business.html');
INSERT INTO `s_menu` VALUES ('55', '11', '邮件配置', 'html/email_config.html');
INSERT INTO `s_menu` VALUES ('56', '11', '统一回执', 'html/email_normal.html');
INSERT INTO `s_menu` VALUES ('57', '11', '发送邮件', 'html/email.html');
INSERT INTO `s_menu` VALUES ('58', '12', '短信配置', 'html/phone_config.html');
INSERT INTO `s_menu` VALUES ('59', '12', '统一回执', 'html/phone_normal.html');
INSERT INTO `s_menu` VALUES ('60', '12', '短信验证码', 'html/phone_code.html');
INSERT INTO `s_menu` VALUES ('61', '12', '发送短信', 'html/phone.html');
INSERT INTO `s_menu` VALUES ('62', '12', '短信日志', 'html/phone_log.html');
INSERT INTO `s_menu` VALUES ('63', '13', '媒体注册', 'html/media.html');
INSERT INTO `s_menu` VALUES ('64', '13', '媒体镜像', 'html/media_clone.html');
INSERT INTO `s_menu` VALUES ('65', '13', '媒体下载', 'html/media_download.html');
INSERT INTO `s_menu` VALUES ('66', '13', '管理图片', 'html/media_pic.html');
INSERT INTO `s_menu` VALUES ('67', '13', '管理新闻', 'html/media_news.html');
INSERT INTO `s_menu` VALUES ('68', '0', '账号管理', '');
INSERT INTO `s_menu` VALUES ('69', '68', '账号', 'html/role.html');
INSERT INTO `s_menu` VALUES ('70', '0', '版本管理', '');
INSERT INTO `s_menu` VALUES ('71', '70', '版本', 'html/lang.html');
INSERT INTO `s_menu` VALUES ('72', '70', '菜单', 'html/menu.html');
INSERT INTO `s_menu` VALUES ('73', '8', '接口日志查询', 'html/interfaces_logs.html');
INSERT INTO `s_menu` VALUES ('74', '8', '兑换查询', 'html/exchange.html');
INSERT INTO `s_menu` VALUES ('75', '8', '活动分类', 'html/active_type.html');
INSERT INTO `s_menu` VALUES ('76', '8', '活动配置', 'html/active_config.html');
INSERT INTO `s_menu` VALUES ('77', '8', '活动记录', 'html/active.html');
INSERT INTO `s_menu` VALUES ('78', '8', '活动统计', 'html/active_count.html');
INSERT INTO `s_menu` VALUES ('79', '10', '活动分类', 'html/player_type.html');
INSERT INTO `s_menu` VALUES ('80', '10', '活动记录', 'html/player.html');
INSERT INTO `s_menu` VALUES ('81', '10', '活动日志', 'html/player_log.html');

-- ----------------------------
-- Table structure for `s_news`
-- ----------------------------
DROP TABLE IF EXISTS `s_news`;
CREATE TABLE `s_news` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `lang` int(11) DEFAULT '0' COMMENT '语言版本',
  `type` int(11) DEFAULT '0' COMMENT '分类',
  `recommend` tinyint(2) DEFAULT '0' COMMENT '推荐：0--否，1--是',
  `illustration` text COMMENT '插图',
  `title` varchar(255) DEFAULT '' COMMENT '标题',
  `title2` varchar(255) DEFAULT '' COMMENT '副标题',
  `date` varchar(20) DEFAULT '' COMMENT '日期',
  `marks` tinyint(2) DEFAULT '0' COMMENT '使用链接：0--否，1--是',
  `site` text COMMENT '链接地址',
  `content` text COMMENT '内容',
  `keywords` text COMMENT '关键字（seo）',
  `description` text COMMENT '描述（seo）',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_news
-- ----------------------------

-- ----------------------------
-- Table structure for `s_news_type`
-- ----------------------------
DROP TABLE IF EXISTS `s_news_type`;
CREATE TABLE `s_news_type` (
  `pid` int(11) NOT NULL DEFAULT '0' COMMENT '主键',
  `lang` int(11) DEFAULT '0' COMMENT '语言版本',
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  `icon` text COMMENT '图片',
  `sort` int(11) DEFAULT '999',
  `home` tinyint(2) DEFAULT '1' COMMENT '首页展示',
  `filter` tinyint(4) DEFAULT '0' COMMENT '是否过滤  0 --否，1--是    适用发布其他渠道的新闻',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_news_type
-- ----------------------------
INSERT INTO `s_news_type` VALUES ('1', '0', '新闻', null, '1', '1', '0');
INSERT INTO `s_news_type` VALUES ('2', '0', '活动', null, '3', '1', '0');
INSERT INTO `s_news_type` VALUES ('3', '0', '公告', null, '2', '1', '0');
INSERT INTO `s_news_type` VALUES ('4', '0', '攻略', null, '4', '1', '0');

-- ----------------------------
-- Table structure for `s_recommend`
-- ----------------------------
DROP TABLE IF EXISTS `s_recommend`;
CREATE TABLE `s_recommend` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `lang` int(11) DEFAULT '0' COMMENT '语言版本',
  `type` int(11) DEFAULT '0' COMMENT '分类',
  `plat` tinyint(2) DEFAULT '0' COMMENT '平台  0：pc，1：mobile',
  `name` varchar(255) DEFAULT '' COMMENT '名称',
  `pic` text COMMENT '图片地址',
  `marks` tinyint(2) DEFAULT '0' COMMENT '启用链接：0 -- 不用； 1 -- 启用消息；2 -- 启用地址',
  `newsId` int(11) DEFAULT '0' COMMENT '消息 id',
  `site` text COMMENT '链接地址',
  `status` tinyint(2) DEFAULT '0' COMMENT '状态：0 --禁用；1 -- 启用',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_recommend
-- ----------------------------

-- ----------------------------
-- Table structure for `s_recommend_type`
-- ----------------------------
DROP TABLE IF EXISTS `s_recommend_type`;
CREATE TABLE `s_recommend_type` (
  `pid` int(11) NOT NULL DEFAULT '0' COMMENT '主键',
  `lang` int(11) DEFAULT '0' COMMENT '语言版本',
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  `icon` text COMMENT '图片',
  `sort` int(11) DEFAULT '999',
  `home` tinyint(2) DEFAULT '1' COMMENT '首页展示',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_recommend_type
-- ----------------------------

-- ----------------------------
-- Table structure for `s_share`
-- ----------------------------
DROP TABLE IF EXISTS `s_share`;
CREATE TABLE `s_share` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `date` varchar(20) DEFAULT '' COMMENT '日期',
  `ip` varchar(255) DEFAULT '' COMMENT 'ip',
  `phone` varchar(20) DEFAULT '' COMMENT '手机号',
  `info` varchar(255) DEFAULT '' COMMENT '附加信息',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='预约';

-- ----------------------------
-- Records of s_share
-- ----------------------------

-- ----------------------------
-- Table structure for `s_strategy`
-- ----------------------------
DROP TABLE IF EXISTS `s_strategy`;
CREATE TABLE `s_strategy` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `lang` int(11) DEFAULT '0' COMMENT '语言版本',
  `type` int(11) DEFAULT '0' COMMENT '分类',
  `recommend` tinyint(2) DEFAULT '0' COMMENT '推荐  0--否，1--是',
  `illustration` text COMMENT '插图',
  `title` varchar(255) DEFAULT '' COMMENT '标题',
  `title2` varchar(255) DEFAULT '' COMMENT '副标题',
  `date` varchar(20) DEFAULT '' COMMENT '日期',
  `marks` tinyint(2) DEFAULT '0' COMMENT '使用链接：0--否，1--是',
  `site` text COMMENT '链接地址',
  `content` text COMMENT '内容',
  `keywords` text COMMENT '关键字（seo）',
  `description` text COMMENT '描述（seo）',
  `description2` text COMMENT '描述 文章、作者类',
  `author` varchar(255) DEFAULT '' COMMENT '作者',
  `highlight` tinyint(2) DEFAULT '0' COMMENT '加精  0--否，1--是',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_strategy
-- ----------------------------

-- ----------------------------
-- Table structure for `s_strategy_type`
-- ----------------------------
DROP TABLE IF EXISTS `s_strategy_type`;
CREATE TABLE `s_strategy_type` (
  `pid` int(11) NOT NULL DEFAULT '0' COMMENT '主键',
  `lang` int(11) DEFAULT '0' COMMENT '语言版本',
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  `icon` text COMMENT '图片',
  `sort` int(11) DEFAULT '999',
  `home` tinyint(2) DEFAULT '1' COMMENT '首页展示',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_strategy_type
-- ----------------------------

-- ----------------------------
-- Table structure for `s_user`
-- ----------------------------
DROP TABLE IF EXISTS `s_user`;
CREATE TABLE `s_user` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT '' COMMENT '用户名',
  `password` varchar(32) DEFAULT '' COMMENT '密码（md5）',
  `admin` tinyint(4) DEFAULT '0' COMMENT '超管  0--否 1--是',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_user
-- ----------------------------
INSERT INTO `s_user` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', '1');

-- ----------------------------
-- Table structure for `s_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `s_user_role`;
CREATE TABLE `s_user_role` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user` int(11) DEFAULT '0' COMMENT '用户id',
  `menu` int(11) DEFAULT '0' COMMENT '用户的菜单id',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=261 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_user_role
-- ----------------------------
INSERT INTO `s_user_role` VALUES ('1', '2', '0');
INSERT INTO `s_user_role` VALUES ('232', '2', '17');
INSERT INTO `s_user_role` VALUES ('233', '2', '2');
INSERT INTO `s_user_role` VALUES ('234', '2', '20');
INSERT INTO `s_user_role` VALUES ('235', '2', '82');
INSERT INTO `s_user_role` VALUES ('236', '2', '22');
INSERT INTO `s_user_role` VALUES ('237', '2', '23');
INSERT INTO `s_user_role` VALUES ('238', '2', '26');
INSERT INTO `s_user_role` VALUES ('239', '2', '27');
INSERT INTO `s_user_role` VALUES ('240', '2', '30');
INSERT INTO `s_user_role` VALUES ('241', '2', '31');
INSERT INTO `s_user_role` VALUES ('242', '2', '33');
INSERT INTO `s_user_role` VALUES ('243', '2', '35');
INSERT INTO `s_user_role` VALUES ('244', '2', '73');
INSERT INTO `s_user_role` VALUES ('245', '2', '75');
INSERT INTO `s_user_role` VALUES ('246', '2', '76');
INSERT INTO `s_user_role` VALUES ('247', '2', '77');
INSERT INTO `s_user_role` VALUES ('248', '2', '78');
INSERT INTO `s_user_role` VALUES ('249', '2', '9');
INSERT INTO `s_user_role` VALUES ('250', '2', '54');
INSERT INTO `s_user_role` VALUES ('251', '2', '10');
INSERT INTO `s_user_role` VALUES ('252', '2', '79');
INSERT INTO `s_user_role` VALUES ('253', '2', '80');
INSERT INTO `s_user_role` VALUES ('254', '2', '81');
INSERT INTO `s_user_role` VALUES ('255', '2', '12');
INSERT INTO `s_user_role` VALUES ('256', '2', '58');
INSERT INTO `s_user_role` VALUES ('257', '2', '59');
INSERT INTO `s_user_role` VALUES ('258', '2', '60');
INSERT INTO `s_user_role` VALUES ('259', '2', '61');
INSERT INTO `s_user_role` VALUES ('260', '2', '62');

-- ----------------------------
-- Table structure for `s_video`
-- ----------------------------
DROP TABLE IF EXISTS `s_video`;
CREATE TABLE `s_video` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `lang` int(11) DEFAULT '0' COMMENT '语言版本',
  `type` int(11) DEFAULT '0' COMMENT '分类',
  `name` varchar(255) DEFAULT '' COMMENT '名称',
  `pic` text COMMENT '封面图片',
  `ogg` text COMMENT 'h5OGG',
  `mp4` text COMMENT 'h5MP4',
  `webm` text COMMENT 'h5WEBM',
  `flash` text COMMENT 'flash',
  `site` text COMMENT '网址',
  `date` varchar(20) DEFAULT '' COMMENT '发布日期',
  `description` text COMMENT '描述',
  `author` varchar(255) DEFAULT '' COMMENT '作者',
  `recommend` tinyint(2) DEFAULT '0' COMMENT '推荐  0--否，1--是',
  `highlight` tinyint(2) DEFAULT '0' COMMENT '加精  0--否，1--是',
  `down` text COMMENT '下载地址',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_video
-- ----------------------------

-- ----------------------------
-- Table structure for `s_video_type`
-- ----------------------------
DROP TABLE IF EXISTS `s_video_type`;
CREATE TABLE `s_video_type` (
  `pid` int(11) NOT NULL DEFAULT '0' COMMENT '主键',
  `lang` int(11) DEFAULT '0' COMMENT '语言版本',
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  `icon` text COMMENT '图片',
  `sort` int(11) DEFAULT '999',
  `home` tinyint(2) DEFAULT '1' COMMENT '首页展示',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_video_type
-- ----------------------------
