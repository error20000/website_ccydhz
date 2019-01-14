/*
Navicat MySQL Data Transfer

Source Server         : lj
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : website_ccydhz

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2019-01-14 18:38:25
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
  `config` int(11) DEFAULT '0' COMMENT '奖励pid',
  `info` varchar(255) DEFAULT '' COMMENT '附加信息',
  `info2` varchar(255) DEFAULT '' COMMENT '附加信息2',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of s_active
-- ----------------------------

-- ----------------------------
-- Table structure for `s_active_code`
-- ----------------------------
DROP TABLE IF EXISTS `s_active_code`;
CREATE TABLE `s_active_code` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `config` int(11) DEFAULT '0' COMMENT '分类',
  `code` varchar(100) DEFAULT '' COMMENT '码',
  `other` varchar(100) DEFAULT '' COMMENT '领取人',
  `info` varchar(200) DEFAULT '' COMMENT '附加信息',
  `date` varchar(20) DEFAULT '' COMMENT '日期',
  `status` tinyint(4) DEFAULT '0' COMMENT '状态   0 -- 未领取， 1 -- 已领取',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of s_active_code
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
  `cv` varchar(255) DEFAULT '' COMMENT 'CV',
  `ship` varchar(255) DEFAULT '' COMMENT '舰种',
  `star` tinyint(4) DEFAULT '0' COMMENT '星级',
  `pic` varchar(255) DEFAULT '' COMMENT '图片',
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
INSERT INTO `s_active_config` VALUES ('1', '2', '11', '', '', '', '0', '', '', '', '999', '1', '', '0');

-- ----------------------------
-- Table structure for `s_active_type`
-- ----------------------------
DROP TABLE IF EXISTS `s_active_type`;
CREATE TABLE `s_active_type` (
  `pid` int(10) NOT NULL COMMENT '主键',
  `name` varchar(255) DEFAULT '' COMMENT '名称',
  `start` varchar(20) DEFAULT '' COMMENT '开始时间  yyyy-MM-dd HH:mm:ss',
  `end` varchar(20) DEFAULT '' COMMENT '结束时间  yyyy-MM-dd HH:mm:ss',
  `status` tinyint(4) DEFAULT '0' COMMENT '状态   0 -- 关闭  1 --开启',
  `count` int(11) DEFAULT '0' COMMENT '参加次数   小于0 --- 无限',
  `scount` int(11) DEFAULT '0' COMMENT '每次分享获得的次数 ',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of s_active_type
-- ----------------------------
INSERT INTO `s_active_type` VALUES ('2', '扭蛋', '', '', '1', '5', '5');

-- ----------------------------
-- Table structure for `s_background`
-- ----------------------------
DROP TABLE IF EXISTS `s_background`;
CREATE TABLE `s_background` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  `logo` varchar(255) DEFAULT '' COMMENT 'LOGO',
  `pic1` varchar(255) DEFAULT '' COMMENT '首页背景',
  `pic2` varchar(255) DEFAULT '' COMMENT '二级页背景',
  `pic3` varchar(255) DEFAULT '' COMMENT '三级页背景',
  `pic4` varchar(255) DEFAULT '' COMMENT '四级页背景',
  `status` tinyint(4) DEFAULT '0' COMMENT '状态  0：禁用，1：启用',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of s_background
-- ----------------------------

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
  `info2` varchar(255) DEFAULT '' COMMENT '附加信息2',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='预约';

-- ----------------------------
-- Records of s_bespeak
-- ----------------------------
INSERT INTO `s_bespeak` VALUES ('1', '2018-09-16 10:00:00', '', '', '', '');
INSERT INTO `s_bespeak` VALUES ('2', '2018-09-15 10:00:00', '', '', '', '');
INSERT INTO `s_bespeak` VALUES ('3', '2018-09-17 10:00:00', '', '', '', '');

-- ----------------------------
-- Table structure for `s_bespeak_config`
-- ----------------------------
DROP TABLE IF EXISTS `s_bespeak_config`;
CREATE TABLE `s_bespeak_config` (
  `pid` int(10) NOT NULL COMMENT '主键',
  `name` varchar(255) DEFAULT '' COMMENT '名称',
  `start` varchar(20) DEFAULT '' COMMENT '开始时间  yyyy-MM-dd HH:mm:ss',
  `end` varchar(20) DEFAULT '' COMMENT '结束时间  yyyy-MM-dd HH:mm:ss',
  `status` tinyint(4) DEFAULT '0' COMMENT '状态   0 -- 关闭  1 --开启',
  `offset` int(11) DEFAULT '0' COMMENT '偏移量',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of s_bespeak_config
-- ----------------------------
INSERT INTO `s_bespeak_config` VALUES ('1', '预约', null, '2018-09-25 10:00:00', '1', '1000');

-- ----------------------------
-- Table structure for `s_business`
-- ----------------------------
DROP TABLE IF EXISTS `s_business`;
CREATE TABLE `s_business` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `type` int(11) DEFAULT '0' COMMENT '分类',
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  `icon` varchar(255) DEFAULT '' COMMENT '图片',
  `site` varchar(255) DEFAULT '' COMMENT '地址',
  `sort` int(11) DEFAULT '999' COMMENT '排序',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of s_business
-- ----------------------------

-- ----------------------------
-- Table structure for `s_business_type`
-- ----------------------------
DROP TABLE IF EXISTS `s_business_type`;
CREATE TABLE `s_business_type` (
  `pid` int(11) NOT NULL DEFAULT '0' COMMENT '主键',
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of s_business_type
-- ----------------------------

-- ----------------------------
-- Table structure for `s_contact`
-- ----------------------------
DROP TABLE IF EXISTS `s_contact`;
CREATE TABLE `s_contact` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `type` int(11) DEFAULT '0' COMMENT '分类',
  `config` int(11) DEFAULT '0' COMMENT '社交配置',
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  `value` varchar(255) DEFAULT '' COMMENT '值',
  `site` varchar(255) DEFAULT '' COMMENT '地址',
  `pic` varchar(255) DEFAULT '' COMMENT '图片',
  `sort` int(11) DEFAULT '999' COMMENT '排序',
  `wjs` text COMMENT '网页代码',
  `ijs` text COMMENT 'iphone代码',
  `ajs` text COMMENT 'android代码',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of s_contact
-- ----------------------------
INSERT INTO `s_contact` VALUES ('1', '1', '2', 'test33', 'test333', '3333', '20190111/20190111155359175097.jpg', '999', '<script>\n		var _hmt = _hmt || [];\n		(function() {\n		  var hm = document.createElement(\"script\");\n		  hm.src = \"//hm.baidu.com/hm.js?43c6af90fcc372e0d4dd1bd19e42d52c\";\n		  var s = document.getElementsByTagName(\"script\")[0]; \n		  s.parentNode.insertBefore(hm, s);\n		})();\n		</script>', '<script>\n		var _hmt = _hmt || [];\n		(function() {\n		  var hm = document.createElement(\"script\");\n		  hm.src = \"//hm.baidu.com/hm.js?43c6af90fcc372e0d4dd1bd19e42d52c\";\n		  var s = document.getElementsByTagName(\"script\")[0]; \n		  s.parentNode.insertBefore(hm, s);\n		})();\n		</script>', '<script>\n		var _hmt = _hmt || [];\n		(function() {\n		  var hm = document.createElement(\"script\");\n		  hm.src = \"//hm.baidu.com/hm.js?43c6af90fcc372e0d4dd1bd19e42d52c\";\n		  var s = document.getElementsByTagName(\"script\")[0]; \n		  s.parentNode.insertBefore(hm, s);\n		})();\n		</script>');
INSERT INTO `s_contact` VALUES ('2', '1', '2', 'dddd', '123456789', '', '', '999', '', '', '');

-- ----------------------------
-- Table structure for `s_contact_config`
-- ----------------------------
DROP TABLE IF EXISTS `s_contact_config`;
CREATE TABLE `s_contact_config` (
  `pid` int(11) NOT NULL DEFAULT '0' COMMENT '主键',
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of s_contact_config
-- ----------------------------
INSERT INTO `s_contact_config` VALUES ('1', '微信');
INSERT INTO `s_contact_config` VALUES ('2', 'QQ');
INSERT INTO `s_contact_config` VALUES ('3', '新浪微博');
INSERT INTO `s_contact_config` VALUES ('4', '百度贴吧');
INSERT INTO `s_contact_config` VALUES ('5', 'FaceBook');
INSERT INTO `s_contact_config` VALUES ('6', 'Twitter');
INSERT INTO `s_contact_config` VALUES ('7', '邮箱');
INSERT INTO `s_contact_config` VALUES ('8', '电话');
INSERT INTO `s_contact_config` VALUES ('9', 'TapTap');
INSERT INTO `s_contact_config` VALUES ('10', '论坛');

-- ----------------------------
-- Table structure for `s_contact_type`
-- ----------------------------
DROP TABLE IF EXISTS `s_contact_type`;
CREATE TABLE `s_contact_type` (
  `pid` int(11) NOT NULL DEFAULT '0' COMMENT '主键',
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of s_contact_type
-- ----------------------------
INSERT INTO `s_contact_type` VALUES ('1', '游戏');

-- ----------------------------
-- Table structure for `s_download`
-- ----------------------------
DROP TABLE IF EXISTS `s_download`;
CREATE TABLE `s_download` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `type` int(11) DEFAULT '0' COMMENT '分类',
  `name` varchar(100) DEFAULT '' COMMENT '下载名称',
  `site` varchar(255) DEFAULT '' COMMENT '下载地址',
  `pic` varchar(255) DEFAULT '' COMMENT '下载图片  按钮/二维码',
  `sort` int(11) DEFAULT '999' COMMENT '排序',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of s_download
-- ----------------------------
INSERT INTO `s_download` VALUES ('1', '3', 'test', 'http://www.baidu.com', '', '999');
INSERT INTO `s_download` VALUES ('2', '2', 'testssss', 'http://www.qq.com', '20190111/201901111429576463544.jpg', '999');
INSERT INTO `s_download` VALUES ('3', '1', 'test', '', '20190111/201901111432130801764.jpg', '999');

-- ----------------------------
-- Table structure for `s_download_type`
-- ----------------------------
DROP TABLE IF EXISTS `s_download_type`;
CREATE TABLE `s_download_type` (
  `pid` int(11) NOT NULL DEFAULT '0' COMMENT '主键',
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of s_download_type
-- ----------------------------
INSERT INTO `s_download_type` VALUES ('1', '扫码下载');
INSERT INTO `s_download_type` VALUES ('2', 'IOS');
INSERT INTO `s_download_type` VALUES ('3', 'Android');
INSERT INTO `s_download_type` VALUES ('4', 'TapTap');
INSERT INTO `s_download_type` VALUES ('5', 'IOS越狱');

-- ----------------------------
-- Table structure for `s_heroes`
-- ----------------------------
DROP TABLE IF EXISTS `s_heroes`;
CREATE TABLE `s_heroes` (
  `pid` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `date` varchar(20) DEFAULT '' COMMENT '日期',
  `type` int(10) DEFAULT '0' COMMENT '舰种',
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  `painter` varchar(255) DEFAULT '' COMMENT '画师',
  `cv` varchar(255) DEFAULT '' COMMENT 'CV',
  `audio` varchar(255) DEFAULT '' COMMENT '音频',
  `star` tinyint(4) DEFAULT '0' COMMENT '星级',
  `desc` varchar(255) DEFAULT '' COMMENT '简介',
  `status` tinyint(4) DEFAULT '0' COMMENT '状态  0：禁用，1：启用',
  `sort` int(11) DEFAULT '999' COMMENT '排序',
  `sname1` varchar(255) DEFAULT '' COMMENT '技能一名称',
  `sicon1` varchar(255) DEFAULT '' COMMENT '技能一图标',
  `sdesc1` varchar(255) DEFAULT '' COMMENT '技能一描述',
  `sname2` varchar(255) DEFAULT '' COMMENT '技能二名称',
  `sicon2` varchar(255) DEFAULT '' COMMENT '技能二图标',
  `sdesc2` varchar(255) DEFAULT '' COMMENT '技能二描述',
  `sname3` varchar(255) DEFAULT '' COMMENT '技能三名称',
  `sicon3` varchar(255) DEFAULT '' COMMENT '技能三图标',
  `sdesc3` varchar(255) DEFAULT '' COMMENT '技能三描述',
  `sname4` varchar(255) DEFAULT '' COMMENT '技能四名称',
  `sicon4` varchar(255) DEFAULT '' COMMENT '技能四图标',
  `sdesc4` varchar(255) DEFAULT '' COMMENT '技能四描述',
  `icon` varchar(255) DEFAULT '' COMMENT '头像',
  `img1` varchar(255) DEFAULT '' COMMENT 'PC图片一',
  `img2` varchar(255) DEFAULT '' COMMENT 'PC图片二',
  `img3` varchar(255) DEFAULT '' COMMENT '移动图片一',
  `img4` varchar(255) DEFAULT '' COMMENT '移动图片二',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of s_heroes
-- ----------------------------
INSERT INTO `s_heroes` VALUES ('1', '2019-01-14 16:01:47', '2', '11', '21', '31', '20190114/201901141600444656109.jpg', '4', '41', '1', '999', '111', '20190114/201901141601023697524.jpg', '131', '211', '221', '231', '311', '321', '331', '411', '421', '431', '20190114/201901141601443276685.jpg', '21', '31', '41', '51');

-- ----------------------------
-- Table structure for `s_heroes_type`
-- ----------------------------
DROP TABLE IF EXISTS `s_heroes_type`;
CREATE TABLE `s_heroes_type` (
  `pid` int(11) NOT NULL DEFAULT '0' COMMENT '主键',
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of s_heroes_type
-- ----------------------------
INSERT INTO `s_heroes_type` VALUES ('1', '战列舰');
INSERT INTO `s_heroes_type` VALUES ('2', '驱逐舰');
INSERT INTO `s_heroes_type` VALUES ('3', '巡洋舰');
INSERT INTO `s_heroes_type` VALUES ('4', '航空母舰');
INSERT INTO `s_heroes_type` VALUES ('5', '潜艇');

-- ----------------------------
-- Table structure for `s_menu`
-- ----------------------------
DROP TABLE IF EXISTS `s_menu`;
CREATE TABLE `s_menu` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent` int(11) DEFAULT '0' COMMENT '父级pid',
  `name` varchar(20) DEFAULT '' COMMENT '名称',
  `site` varchar(255) DEFAULT '' COMMENT '地址',
  `icon` varchar(255) DEFAULT '' COMMENT '图标',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of s_menu
-- ----------------------------
INSERT INTO `s_menu` VALUES ('1', '0', '界面配置', null, '');
INSERT INTO `s_menu` VALUES ('2', '0', '下载配置', null, '');
INSERT INTO `s_menu` VALUES ('3', '0', '关注我们', null, '');
INSERT INTO `s_menu` VALUES ('4', '0', '消息发布', null, '');
INSERT INTO `s_menu` VALUES ('5', '0', '礼包管理', null, '');
INSERT INTO `s_menu` VALUES ('6', '0', '游戏音画', null, '');
INSERT INTO `s_menu` VALUES ('7', '0', '游戏资料', null, '');
INSERT INTO `s_menu` VALUES ('8', '0', '游戏数据', null, '');
INSERT INTO `s_menu` VALUES ('9', '0', '合作媒体', null, '');
INSERT INTO `s_menu` VALUES ('10', '0', '玩家天地', null, '');
INSERT INTO `s_menu` VALUES ('11', '0', '邮件系统', null, '');
INSERT INTO `s_menu` VALUES ('12', '0', '短信系统', null, '');
INSERT INTO `s_menu` VALUES ('13', '0', '媒体管理', null, '');
INSERT INTO `s_menu` VALUES ('14', '1', 'LOGO', 'html/logo.html', '');
INSERT INTO `s_menu` VALUES ('15', '1', '背景', 'html/background.html', '');
INSERT INTO `s_menu` VALUES ('16', '1', '推荐(展示)分类', 'html/recommend_type.html', '');
INSERT INTO `s_menu` VALUES ('17', '1', '推荐(展示)', 'html/recommend.html', '');
INSERT INTO `s_menu` VALUES ('18', '1', '其他配置分类', 'html/system_other_type.html', '');
INSERT INTO `s_menu` VALUES ('19', '1', '其他配置', 'html/system_other.html', '');
INSERT INTO `s_menu` VALUES ('20', '2', '下载配置', 'html/download.html', '');
INSERT INTO `s_menu` VALUES ('21', '3', '微博微信分类', 'html/system_type.html', '');
INSERT INTO `s_menu` VALUES ('22', '3', '微博微信', 'html/system.html', '');
INSERT INTO `s_menu` VALUES ('23', '3', '邮箱/QQ', 'html/customer.html', '');
INSERT INTO `s_menu` VALUES ('24', '3', '分享', null, '');
INSERT INTO `s_menu` VALUES ('25', '4', '消息广告图', 'html/news_pic.html', '');
INSERT INTO `s_menu` VALUES ('26', '4', '消息分类', 'html/news_type.html', '');
INSERT INTO `s_menu` VALUES ('27', '4', '消息列表', 'html/news.html', '');
INSERT INTO `s_menu` VALUES ('28', '5', '礼包广告图', 'html/gift_pic.html', '');
INSERT INTO `s_menu` VALUES ('29', '5', '礼包列表', 'html/gift.html', '');
INSERT INTO `s_menu` VALUES ('30', '5', '礼包码', 'html/gift_code.html', '');
INSERT INTO `s_menu` VALUES ('31', '5', '领取统计', 'html/gift_count.html', '');
INSERT INTO `s_menu` VALUES ('32', '6', '图集分类', 'html/picture_type.html', '');
INSERT INTO `s_menu` VALUES ('33', '6', '图集(原画)', 'html/picture.html', '');
INSERT INTO `s_menu` VALUES ('34', '6', '视频分类', 'html/video_type.html', '');
INSERT INTO `s_menu` VALUES ('35', '6', '视频', 'html/video.html', '');
INSERT INTO `s_menu` VALUES ('36', '7', '资料广告图', 'html/resources_pic.html', '');
INSERT INTO `s_menu` VALUES ('37', '7', '资料分类', 'html/resources_type.html', '');
INSERT INTO `s_menu` VALUES ('38', '7', '资料详情', 'html/resources.html', '');
INSERT INTO `s_menu` VALUES ('39', '7', '其他资料', 'html/resources_other.html', '');
INSERT INTO `s_menu` VALUES ('40', '7', '介绍', 'html/product.html', '');
INSERT INTO `s_menu` VALUES ('41', '7', '装备分类', 'html/equipment_type.html', '');
INSERT INTO `s_menu` VALUES ('42', '7', '装备详情', 'html/equipment.html', '');
INSERT INTO `s_menu` VALUES ('43', '7', '攻略分类', 'html/strategy_type.html', '');
INSERT INTO `s_menu` VALUES ('44', '7', '攻略详情', 'html/strategy.html', '');
INSERT INTO `s_menu` VALUES ('45', '7', '英雄分类', 'html/heroes_type.html', '');
INSERT INTO `s_menu` VALUES ('46', '7', '英雄详情', 'html/heroes.html', '');
INSERT INTO `s_menu` VALUES ('47', '7', '英雄详情2', 'html/heroes2.html', '');
INSERT INTO `s_menu` VALUES ('48', '7', '英雄详情3', 'html/heroes3.html', '');
INSERT INTO `s_menu` VALUES ('49', '8', '服务器配置', 'html/server.html', '');
INSERT INTO `s_menu` VALUES ('50', '8', '账号转移', 'html/zhuanyi.html', '');
INSERT INTO `s_menu` VALUES ('51', '8', '数据接口配置', 'html/interfaces.html', '');
INSERT INTO `s_menu` VALUES ('52', '8', '数据导入', null, '');
INSERT INTO `s_menu` VALUES ('53', '8', '查询配置', null, '');
INSERT INTO `s_menu` VALUES ('54', '9', '合作媒体', 'html/business.html', '');
INSERT INTO `s_menu` VALUES ('55', '11', '邮件配置', 'html/email_config.html', '');
INSERT INTO `s_menu` VALUES ('56', '11', '统一回执', 'html/email_normal.html', '');
INSERT INTO `s_menu` VALUES ('57', '11', '发送邮件', 'html/email.html', '');
INSERT INTO `s_menu` VALUES ('58', '12', '短信配置', 'html/phone_config.html', '');
INSERT INTO `s_menu` VALUES ('59', '12', '统一回执', 'html/phone_normal.html', '');
INSERT INTO `s_menu` VALUES ('60', '12', '短信验证码', 'html/phone_code.html', '');
INSERT INTO `s_menu` VALUES ('61', '12', '发送短信', 'html/phone.html', '');
INSERT INTO `s_menu` VALUES ('62', '12', '短信日志', 'html/phone_log.html', '');
INSERT INTO `s_menu` VALUES ('63', '13', '媒体注册', 'html/media.html', '');
INSERT INTO `s_menu` VALUES ('64', '13', '媒体镜像', 'html/media_clone.html', '');
INSERT INTO `s_menu` VALUES ('65', '13', '媒体下载', 'html/media_download.html', '');
INSERT INTO `s_menu` VALUES ('66', '13', '管理图片', 'html/media_pic.html', '');
INSERT INTO `s_menu` VALUES ('67', '13', '管理新闻', 'html/media_news.html', '');
INSERT INTO `s_menu` VALUES ('68', '0', '账号管理', '', '');
INSERT INTO `s_menu` VALUES ('69', '68', '账号', 'html/role.html', '');
INSERT INTO `s_menu` VALUES ('70', '0', '版本管理', '', '');
INSERT INTO `s_menu` VALUES ('71', '70', '版本', 'html/lang.html', '');
INSERT INTO `s_menu` VALUES ('72', '70', '菜单', 'html/menu.html', '');
INSERT INTO `s_menu` VALUES ('73', '8', '接口日志查询', 'html/interfaces_logs.html', '');
INSERT INTO `s_menu` VALUES ('74', '8', '兑换查询', 'html/exchange.html', '');
INSERT INTO `s_menu` VALUES ('75', '8', '活动分类', 'html/active_type.html', '');
INSERT INTO `s_menu` VALUES ('76', '8', '活动配置', 'html/active_config.html', '');
INSERT INTO `s_menu` VALUES ('77', '8', '活动记录', 'html/active.html', '');
INSERT INTO `s_menu` VALUES ('78', '8', '活动统计', 'html/active_count.html', '');
INSERT INTO `s_menu` VALUES ('79', '10', '活动分类', 'html/player_type.html', '');
INSERT INTO `s_menu` VALUES ('80', '10', '活动记录', 'html/player.html', '');
INSERT INTO `s_menu` VALUES ('81', '10', '活动日志', 'html/player_log.html', '');

-- ----------------------------
-- Table structure for `s_news`
-- ----------------------------
DROP TABLE IF EXISTS `s_news`;
CREATE TABLE `s_news` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `type` int(11) DEFAULT '0' COMMENT '分类',
  `recommend` tinyint(4) DEFAULT '0' COMMENT '推荐  0--否，1--是',
  `illustration` varchar(255) DEFAULT '' COMMENT '插图',
  `title` varchar(255) DEFAULT '' COMMENT '标题',
  `subtitle` varchar(255) DEFAULT '' COMMENT '副标题',
  `date` varchar(20) DEFAULT '' COMMENT '日期  yyyy-MM-dd HH:mm:ss',
  `mark` tinyint(4) DEFAULT '0' COMMENT '使用链接   0--否，1--是',
  `site` varchar(255) DEFAULT '' COMMENT '链接地址',
  `content` text COMMENT '内容',
  `keywords` text COMMENT '关键字 （seo）',
  `description` text COMMENT '描述 （seo）',
  `status` tinyint(4) DEFAULT '0' COMMENT '状态  0：禁用，1：启用',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of s_news
-- ----------------------------
INSERT INTO `s_news` VALUES ('1', '1', '0', 'test', '6月14日例行维护公告', 'test', '2019-01-09 14:41:56', '0', null, '<p>test</p>', null, null, '1');
INSERT INTO `s_news` VALUES ('2', '1', '0', '20190109/201901091514489065054.jpg', '5月21日使用外挂的处罚公告及冻结账号名单', null, '2019-01-09 15:15:50', '0', null, '<p>sdfsdfsf</p><p>dsfsdf</p><p>sdf</p><p>sdf</p><p>sdf</p><p>s</p><p>df</p><p>sd</p><p>f</p><p>xcxcxcxcxcxcxcxc</p>', null, null, '1');
INSERT INTO `s_news` VALUES ('3', '1', '0', null, '全民约礼！《少女前线》安卓腾讯应用宝预约盛大开启', '全民约礼！《少女前线》安卓腾讯应用宝预约盛大开启', '2019-01-09 15:43:24', '0', null, '<p class=\"ql-align-center\"><br/></p><p class=\"ql-align-center\">sdfsf</p><p class=\"ql-align-center\"><br/></p><p class=\"ql-align-center\">dsfs</p><p class=\"ql-align-center\">fs<img src=\"/20190109/201901091544453664544.jpg\"/></p><p class=\"ql-align-center\">df</p><p class=\"ql-align-center\">sd</p><p class=\"ql-align-center\">f</p><p class=\"ql-align-center\">s</p><p class=\"ql-align-center\">fs</p><p class=\"ql-align-center\"><br/></p><p class=\"ql-align-center\"><img src=\"/20190109/20190109154319593016.jpg\"/></p><p class=\"ql-align-center\"><br/></p><p class=\"ql-align-center\">sfsfsfsdfsfa</p>', null, null, '0');
INSERT INTO `s_news` VALUES ('4', '1', '0', null, 'test', 'test', '2019-01-09 15:48:06', '0', null, '<p>tetstst</p><p><br/></p><p>setst<img src=\"/20190109/201901091548028915540.jpg\"/></p><p>dfsdfsdfsdfsdf</p><p>sdfsdfsdf</p><p>sdfsdfsd</p><p><br/></p><p>df</p><p>sf</p><p>sdf</p><p>sdf</p><p>sd</p><p>fs</p><p>df</p><p>s</p><p>a</p><p><br/></p><p><img src=\"/20190109/201901091548376633246.jpg\" width=\"741\" height=\"805\"/></p><p><br/></p><p>sd</p><p>fd</p><p><br/></p><p>f</p><p><br/></p><p>fffffffffffffffffffffffffffffffsdsdf sdfasdfsdfs</p><p>dfsd</p><p>f</p><p>sdf</p><p>sd</p><p>f</p><p>sd</p><p><br/></p>', null, null, '0');
INSERT INTO `s_news` VALUES ('6', '1', '0', '', '', '', '2019-01-10 17:01:42', '0', '', '<p style=\"text-align: center;\">123</p>', '', '', '0');
INSERT INTO `s_news` VALUES ('7', '1', '0', 'eeee', 'eee', 'eee', '2019-01-14 00:35:37', '1', 'eeeeee', '', '', '', '1');
INSERT INTO `s_news` VALUES ('8', '1', '0', 'ww', 'ww', 'ww', '2019-01-14 00:38:46', '1', 'wwww', null, null, null, '1');

-- ----------------------------
-- Table structure for `s_news_type`
-- ----------------------------
DROP TABLE IF EXISTS `s_news_type`;
CREATE TABLE `s_news_type` (
  `pid` int(11) NOT NULL DEFAULT '0' COMMENT '主键',
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  `icon` varchar(255) DEFAULT '' COMMENT '图片',
  `sort` int(11) DEFAULT '999' COMMENT '排序',
  `home` tinyint(4) DEFAULT '1' COMMENT '首页展示  0：否，1：是',
  `filter` tinyint(4) DEFAULT '0' COMMENT '是否过滤  0 --否，1--是    适用发布其他渠道的新闻',
  `status` tinyint(4) DEFAULT '0' COMMENT '状态  0：禁用，1：启用',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of s_news_type
-- ----------------------------
INSERT INTO `s_news_type` VALUES ('1', '新闻', null, '1', '1', '0', '1');
INSERT INTO `s_news_type` VALUES ('2', '活动', null, '3', '1', '0', '1');
INSERT INTO `s_news_type` VALUES ('3', '公告', null, '2', '1', '0', '1');
INSERT INTO `s_news_type` VALUES ('4', '攻略', null, '4', '1', '0', '1');

-- ----------------------------
-- Table structure for `s_other`
-- ----------------------------
DROP TABLE IF EXISTS `s_other`;
CREATE TABLE `s_other` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `type` int(11) DEFAULT '0' COMMENT '分类',
  `name` varchar(100) DEFAULT '' COMMENT '下载名称',
  `site` varchar(255) DEFAULT '' COMMENT '下载地址',
  `pic` varchar(255) DEFAULT '' COMMENT '下载图片  按钮/二维码',
  `status` tinyint(4) DEFAULT '0' COMMENT '状态  0：禁用，1：启用',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of s_other
-- ----------------------------

-- ----------------------------
-- Table structure for `s_other_type`
-- ----------------------------
DROP TABLE IF EXISTS `s_other_type`;
CREATE TABLE `s_other_type` (
  `pid` int(11) NOT NULL DEFAULT '0' COMMENT '主键',
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of s_other_type
-- ----------------------------
INSERT INTO `s_other_type` VALUES ('1', '游戏服务');

-- ----------------------------
-- Table structure for `s_picture`
-- ----------------------------
DROP TABLE IF EXISTS `s_picture`;
CREATE TABLE `s_picture` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `type` int(11) DEFAULT '0' COMMENT '分类',
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  `pic` varchar(255) DEFAULT '' COMMENT '原图地址',
  `pich` varchar(255) DEFAULT '' COMMENT '首页缩略图',
  `picl` varchar(255) DEFAULT '' COMMENT '列表页缩略图',
  `date` varchar(20) DEFAULT '' COMMENT '日期',
  `description` varchar(255) DEFAULT '' COMMENT '描述',
  `down` varchar(255) DEFAULT '' COMMENT '下载地址',
  `author` varchar(100) DEFAULT '' COMMENT '作者',
  `recommend` tinyint(2) DEFAULT '0' COMMENT '推荐  0--否，1--是',
  `highlight` tinyint(2) DEFAULT '0' COMMENT '加精  0--否，1--是',
  `sort` int(11) DEFAULT '999' COMMENT '排序',
  `status` tinyint(4) DEFAULT '0' COMMENT '状态   0：禁用，1：启用',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of s_picture
-- ----------------------------
INSERT INTO `s_picture` VALUES ('1', '1', 'test', 'ttt', 'tt', 'tt', '2019-01-12 23:02:54', 't', 't', 'tttt', '1', '1', '999', '1');
INSERT INTO `s_picture` VALUES ('2', '1', 'rr', 'rr', 'rr', 'rrr', '2019-01-12 23:03:25', 'rr', 'rr', 'rr', '0', '0', '999', '0');

-- ----------------------------
-- Table structure for `s_picture_type`
-- ----------------------------
DROP TABLE IF EXISTS `s_picture_type`;
CREATE TABLE `s_picture_type` (
  `pid` int(11) NOT NULL COMMENT '主键',
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of s_picture_type
-- ----------------------------
INSERT INTO `s_picture_type` VALUES ('1', 'COSPLAY');
INSERT INTO `s_picture_type` VALUES ('2', '同人漫画');
INSERT INTO `s_picture_type` VALUES ('3', '壁纸（PC）');
INSERT INTO `s_picture_type` VALUES ('4', '壁纸（手机）');
INSERT INTO `s_picture_type` VALUES ('5', '头像');

-- ----------------------------
-- Table structure for `s_recommend`
-- ----------------------------
DROP TABLE IF EXISTS `s_recommend`;
CREATE TABLE `s_recommend` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `type` int(11) DEFAULT '0' COMMENT '分类',
  `plat` tinyint(2) DEFAULT '0' COMMENT '平台  0：pc，1：mobile',
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  `pic` varchar(255) DEFAULT '' COMMENT '图片地址',
  `marks` tinyint(2) DEFAULT '0' COMMENT '启用链接：0 -- 不用； 1 -- 启用消息；2 -- 启用地址',
  `newsId` int(11) DEFAULT '0' COMMENT '消息 id',
  `site` varchar(255) DEFAULT '' COMMENT '链接地址',
  `status` tinyint(2) DEFAULT '0' COMMENT '状态：0 --禁用；1 -- 启用',
  `sort` int(11) DEFAULT '999' COMMENT '排序',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of s_recommend
-- ----------------------------
INSERT INTO `s_recommend` VALUES ('1', '1', '0', 'test', 'test', '0', '0', '', '1', '999');
INSERT INTO `s_recommend` VALUES ('2', '1', '0', 'tes33', 'ttttt', '1', '3', '', '1', '999');
INSERT INTO `s_recommend` VALUES ('3', '1', '0', 'testtt', 'eeee', '2', '0', 'http://www.baidu.com', '1', '999');
INSERT INTO `s_recommend` VALUES ('4', '1', '1', '11111111111', '1111111', '0', '0', '', '1', '999');
INSERT INTO `s_recommend` VALUES ('5', '1', '1', '2222222', '22222', '1', '2', '', '1', '999');
INSERT INTO `s_recommend` VALUES ('6', '1', '1', '3333333', '33', '2', '0', 'qq.com', '1', '999');
INSERT INTO `s_recommend` VALUES ('8', '1', '0', 'testest', 'testestset', '0', '0', '', '0', '999');

-- ----------------------------
-- Table structure for `s_recommend_type`
-- ----------------------------
DROP TABLE IF EXISTS `s_recommend_type`;
CREATE TABLE `s_recommend_type` (
  `pid` int(11) NOT NULL DEFAULT '0' COMMENT '主键',
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of s_recommend_type
-- ----------------------------
INSERT INTO `s_recommend_type` VALUES ('1', '首页新闻栏滚动图');

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
  `type` int(11) DEFAULT '0' COMMENT '分类',
  `recommend` tinyint(2) DEFAULT '0' COMMENT '推荐  0--否，1--是',
  `illustration` varchar(255) DEFAULT '' COMMENT '插图',
  `title` varchar(255) DEFAULT '' COMMENT '标题',
  `subtitle` varchar(255) DEFAULT '' COMMENT '副标题',
  `date` varchar(20) DEFAULT '' COMMENT '日期',
  `mark` tinyint(2) DEFAULT '0' COMMENT '使用链接：0--否，1--是',
  `site` varchar(255) DEFAULT '' COMMENT '链接地址',
  `content` text COMMENT '内容',
  `keywords` text COMMENT '关键字（seo）',
  `description` text COMMENT '描述（seo）',
  `author` varchar(255) DEFAULT '' COMMENT '作者',
  `desc` text COMMENT '描述 文章、作者类',
  `highlight` tinyint(2) DEFAULT '0' COMMENT '加精  0--否，1--是',
  `status` tinyint(4) DEFAULT '0' COMMENT '状态  0：禁用，1：启用',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of s_strategy
-- ----------------------------
INSERT INTO `s_strategy` VALUES ('1', '1', '0', 'test', 'test', 'test', '2019-01-14 01:28:43', '1', 'test', null, null, null, 'test', 'test', '1', '1');
INSERT INTO `s_strategy` VALUES ('2', '1', '1', 'ttt', 'test', 'sstt', '2019-01-14 01:29:01', '0', '', '<p>tttt</p>', '', '', 'ttt', 'ttt', '1', '1');
INSERT INTO `s_strategy` VALUES ('3', '1', '1', 'ssss', 'test', 'eesss', '2019-01-01 00:00:00', '0', '', '<p>ssssssssssssss</p>', 'sssss,ssss,sss', 'ssssssss,sssss,ssssss', 'ssss', 'sssssssss', '1', '0');

-- ----------------------------
-- Table structure for `s_strategy_type`
-- ----------------------------
DROP TABLE IF EXISTS `s_strategy_type`;
CREATE TABLE `s_strategy_type` (
  `pid` int(11) NOT NULL DEFAULT '0' COMMENT '主键',
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  `icon` varchar(255) DEFAULT '' COMMENT '图片',
  `sort` int(11) DEFAULT '999' COMMENT '排序',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of s_strategy_type
-- ----------------------------
INSERT INTO `s_strategy_type` VALUES ('1', '同人文学', null, '999');

-- ----------------------------
-- Table structure for `s_user`
-- ----------------------------
DROP TABLE IF EXISTS `s_user`;
CREATE TABLE `s_user` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` varchar(20) DEFAULT '' COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8 DEFAULT '' COMMENT '密码（md5）',
  `system` tinyint(4) DEFAULT '0' COMMENT '超管  0--否 1--是',
  `status` tinyint(4) DEFAULT '0' COMMENT '状态  0--禁用 1--启用',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of s_user
-- ----------------------------
INSERT INTO `s_user` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', '1', '1');

-- ----------------------------
-- Table structure for `s_user_menu`
-- ----------------------------
DROP TABLE IF EXISTS `s_user_menu`;
CREATE TABLE `s_user_menu` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user` int(11) DEFAULT '0' COMMENT '用户id',
  `menu` int(11) DEFAULT '0' COMMENT '用户的菜单id',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=261 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of s_user_menu
-- ----------------------------
INSERT INTO `s_user_menu` VALUES ('1', '2', '0');
INSERT INTO `s_user_menu` VALUES ('232', '2', '17');
INSERT INTO `s_user_menu` VALUES ('233', '2', '2');
INSERT INTO `s_user_menu` VALUES ('234', '2', '20');
INSERT INTO `s_user_menu` VALUES ('235', '2', '82');
INSERT INTO `s_user_menu` VALUES ('236', '2', '22');
INSERT INTO `s_user_menu` VALUES ('237', '2', '23');
INSERT INTO `s_user_menu` VALUES ('238', '2', '26');
INSERT INTO `s_user_menu` VALUES ('239', '2', '27');
INSERT INTO `s_user_menu` VALUES ('240', '2', '30');
INSERT INTO `s_user_menu` VALUES ('241', '2', '31');
INSERT INTO `s_user_menu` VALUES ('242', '2', '33');
INSERT INTO `s_user_menu` VALUES ('243', '2', '35');
INSERT INTO `s_user_menu` VALUES ('244', '2', '73');
INSERT INTO `s_user_menu` VALUES ('245', '2', '75');
INSERT INTO `s_user_menu` VALUES ('246', '2', '76');
INSERT INTO `s_user_menu` VALUES ('247', '2', '77');
INSERT INTO `s_user_menu` VALUES ('248', '2', '78');
INSERT INTO `s_user_menu` VALUES ('249', '2', '9');
INSERT INTO `s_user_menu` VALUES ('250', '2', '54');
INSERT INTO `s_user_menu` VALUES ('251', '2', '10');
INSERT INTO `s_user_menu` VALUES ('252', '2', '79');
INSERT INTO `s_user_menu` VALUES ('253', '2', '80');
INSERT INTO `s_user_menu` VALUES ('254', '2', '81');
INSERT INTO `s_user_menu` VALUES ('255', '2', '12');
INSERT INTO `s_user_menu` VALUES ('256', '2', '58');
INSERT INTO `s_user_menu` VALUES ('257', '2', '59');
INSERT INTO `s_user_menu` VALUES ('258', '2', '60');
INSERT INTO `s_user_menu` VALUES ('259', '2', '61');
INSERT INTO `s_user_menu` VALUES ('260', '2', '62');

-- ----------------------------
-- Table structure for `s_video`
-- ----------------------------
DROP TABLE IF EXISTS `s_video`;
CREATE TABLE `s_video` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `type` int(11) DEFAULT '0' COMMENT '分类',
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  `pic` varchar(255) DEFAULT '' COMMENT '封面图片',
  `mark` tinyint(4) DEFAULT '0' COMMENT '类型  0：视频，1：音频',
  `ogg` varchar(255) DEFAULT '' COMMENT 'OGG',
  `mp4` varchar(255) DEFAULT '' COMMENT 'MP4',
  `webm` varchar(255) DEFAULT '' COMMENT 'WEBM',
  `flash` varchar(255) DEFAULT '' COMMENT 'flash',
  `video` varchar(255) DEFAULT '' COMMENT '视频网址',
  `mp3` varchar(255) DEFAULT '' COMMENT 'MP3',
  `wav` varchar(255) DEFAULT '' COMMENT 'WAV',
  `audio` varchar(255) DEFAULT '' COMMENT '音频网址',
  `date` varchar(20) DEFAULT '' COMMENT '发布日期',
  `description` text COMMENT '描述',
  `author` varchar(255) DEFAULT '' COMMENT '作者',
  `recommend` tinyint(2) DEFAULT '0' COMMENT '推荐  0--否，1--是',
  `highlight` tinyint(2) DEFAULT '0' COMMENT '加精  0--否，1--是',
  `down` varchar(255) DEFAULT '' COMMENT '下载地址',
  `sort` int(11) DEFAULT '999' COMMENT '排序',
  `status` tinyint(4) DEFAULT '0' COMMENT '状态   0：禁用，1：启用',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of s_video
-- ----------------------------
INSERT INTO `s_video` VALUES ('1', '1', 'test', 'ttt', '0', 'tt', 'tt', 'tt', 'tt', 'ttt', null, null, null, null, 'tt', 'tt', '1', '1', 'tt', '999', '1');
INSERT INTO `s_video` VALUES ('2', '2', 'ee2', 'ee2', '0', 'ee2', 'ee2', 'ee2', 'ee2', 'ee2', null, null, null, null, 'ee2', 'ee2', '0', '0', 'ee2', '999', '0');
INSERT INTO `s_video` VALUES ('3', '3', 'dd', 'dd', '1', '', '', '', '', '', 'dd', 'dd', 'dd', '', 'dd', 'dd', '1', '1', 'dd', '999', '1');
INSERT INTO `s_video` VALUES ('4', '1', '', '', '0', '', '', '', '', '', '', '', '', '2019-01-14 00:04:39', '', '', '0', '0', '', '999', '0');

-- ----------------------------
-- Table structure for `s_video_type`
-- ----------------------------
DROP TABLE IF EXISTS `s_video_type`;
CREATE TABLE `s_video_type` (
  `pid` int(11) NOT NULL DEFAULT '0' COMMENT '主键',
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  `mark` tinyint(4) DEFAULT '0' COMMENT '类型  0：视频，1：音频',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of s_video_type
-- ----------------------------
INSERT INTO `s_video_type` VALUES ('1', '官网首页视频', '0');
INSERT INTO `s_video_type` VALUES ('2', '同人影视', '0');
INSERT INTO `s_video_type` VALUES ('3', '音乐', '1');
