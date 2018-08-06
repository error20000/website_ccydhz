/*
Navicat MySQL Data Transfer

Source Server         : lj
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : website_ccydhz

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2018-08-06 18:38:58
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
  `info` varchar(255) DEFAULT '' COMMENT '附件信息',
  `info2` varchar(255) DEFAULT '' COMMENT '附加信息2',
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
  `name` varchar(255) DEFAULT '' COMMENT '名称',
  `start` varchar(20) DEFAULT '' COMMENT '开始时间  yyyy-MM-dd HH:mm:ss',
  `end` varchar(20) DEFAULT '' COMMENT '结束时间  yyyy-MM-dd HH:mm:ss',
  `status` tinyint(4) DEFAULT '0' COMMENT '状态   0 -- 关闭  1 --开启',
  `count` int(11) DEFAULT '0' COMMENT '参加次数   小于0 --- 无限',
  `sCount` int(11) DEFAULT '0' COMMENT '每次分享获得的次数 ',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of s_active_type
-- ----------------------------
INSERT INTO `s_active_type` VALUES ('2', '扭蛋', '', '', '1', '1', '5');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='预约';

-- ----------------------------
-- Records of s_bespeak
-- ----------------------------

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
INSERT INTO `s_bespeak_config` VALUES ('1', '预约', '', '2017-08-25 10:00:00', '1', '0');

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
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_business_type
-- ----------------------------
INSERT INTO `s_business_type` VALUES ('1', '合作媒体');
INSERT INTO `s_business_type` VALUES ('2', '友情链接');

-- ----------------------------
-- Table structure for `s_contact`
-- ----------------------------
DROP TABLE IF EXISTS `s_contact`;
CREATE TABLE `s_contact` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `type` int(11) DEFAULT '0' COMMENT '分类',
  `label` int(11) DEFAULT '0' COMMENT '社交分类',
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  `value` varchar(255) DEFAULT '' COMMENT '值',
  `site` varchar(255) DEFAULT '' COMMENT '地址',
  `pic` varchar(255) DEFAULT '' COMMENT '图片',
  `sort` int(11) DEFAULT '999' COMMENT '排序',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_contact
-- ----------------------------

-- ----------------------------
-- Table structure for `s_contact_label`
-- ----------------------------
DROP TABLE IF EXISTS `s_contact_label`;
CREATE TABLE `s_contact_label` (
  `pid` int(11) NOT NULL DEFAULT '0' COMMENT '主键',
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_contact_label
-- ----------------------------
INSERT INTO `s_contact_label` VALUES ('1', '微信');
INSERT INTO `s_contact_label` VALUES ('2', '新浪微博');
INSERT INTO `s_contact_label` VALUES ('3', '腾讯微博');
INSERT INTO `s_contact_label` VALUES ('4', '百度贴吧');
INSERT INTO `s_contact_label` VALUES ('5', 'FaceBook');
INSERT INTO `s_contact_label` VALUES ('6', 'Twitter');
INSERT INTO `s_contact_label` VALUES ('7', '邮箱');
INSERT INTO `s_contact_label` VALUES ('8', '电话');
INSERT INTO `s_contact_label` VALUES ('9', 'QQ');
INSERT INTO `s_contact_label` VALUES ('10', 'TapTap');

-- ----------------------------
-- Table structure for `s_contact_type`
-- ----------------------------
DROP TABLE IF EXISTS `s_contact_type`;
CREATE TABLE `s_contact_type` (
  `pid` int(11) NOT NULL DEFAULT '0' COMMENT '主键',
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_contact_type
-- ----------------------------
INSERT INTO `s_contact_type` VALUES ('1', '游戏');
INSERT INTO `s_contact_type` VALUES ('2', '客服');

-- ----------------------------
-- Table structure for `s_download`
-- ----------------------------
DROP TABLE IF EXISTS `s_download`;
CREATE TABLE `s_download` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `type` int(11) DEFAULT '0' COMMENT '分类',
  `name` varchar(100) DEFAULT '' COMMENT '下载名称',
  `site` varchar(255) DEFAULT '' COMMENT '下载地址',
  `pic` varchar(255) DEFAULT '' COMMENT '下载按钮图片',
  `sort` int(11) DEFAULT '999' COMMENT '排序',
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
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
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
  `sort` int(11) DEFAULT '999' COMMENT '排序',
  PRIMARY KEY (`pid`)
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
  `name` varchar(100) DEFAULT '' COMMENT '名称',
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
  `site` varchar(255) DEFAULT '' COMMENT '地址',
  `icon` varchar(255) DEFAULT '' COMMENT '图标',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;

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
  `recommend` tinyint(2) DEFAULT '0' COMMENT '推荐：0--否，1--是',
  `illustration` varchar(255) DEFAULT '' COMMENT '插图',
  `title` varchar(255) DEFAULT '' COMMENT '标题',
  `title2` varchar(255) DEFAULT '' COMMENT '副标题',
  `date` varchar(20) DEFAULT '' COMMENT '日期',
  `marks` tinyint(2) DEFAULT '0' COMMENT '使用链接：0--否，1--是',
  `site` varchar(255) DEFAULT '' COMMENT '链接地址',
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
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  `icon` varchar(255) DEFAULT '' COMMENT '图片',
  `sort` int(11) DEFAULT '999' COMMENT '排序',
  `home` tinyint(2) DEFAULT '1' COMMENT '首页展示',
  `filter` tinyint(4) DEFAULT '0' COMMENT '是否过滤  0 --否，1--是    适用发布其他渠道的新闻',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_news_type
-- ----------------------------
INSERT INTO `s_news_type` VALUES ('1', '新闻', null, '1', '1', '0');
INSERT INTO `s_news_type` VALUES ('2', '活动', null, '3', '1', '0');
INSERT INTO `s_news_type` VALUES ('3', '公告', null, '2', '1', '0');
INSERT INTO `s_news_type` VALUES ('4', '攻略', null, '4', '1', '0');

-- ----------------------------
-- Table structure for `s_picture`
-- ----------------------------
DROP TABLE IF EXISTS `s_picture`;
CREATE TABLE `s_picture` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `type` int(11) DEFAULT '0' COMMENT '分类',
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  `pic` varchar(255) DEFAULT '' COMMENT '图片地址',
  `date` varchar(20) DEFAULT '' COMMENT '日期',
  `description` text COMMENT '描述',
  `down` varchar(255) DEFAULT '' COMMENT '下载地址',
  `author` varchar(100) DEFAULT '' COMMENT '作者',
  `recommend` tinyint(2) DEFAULT '0' COMMENT '推荐  0--否，1--是',
  `highlight` tinyint(2) DEFAULT '0' COMMENT '加精  0--否，1--是',
  `sort` int(11) DEFAULT '999' COMMENT '排序',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_picture
-- ----------------------------
INSERT INTO `s_picture` VALUES ('1', '3', '铁血工造', '../CKFinderJava/1/files/005Emp0igw1f5udvcu1uvj31kw28g4f4.jpg', '', '呀嗬，我就是建筑师哦~', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('5', '3', '战术少女', '../CKFinderJava/1/files/6c8acad8gw1f5udab15yjj20rs0jmgoq.jpg', '', 'NTW-20', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('6', '3', '同人绘图', '../CKFinderJava/1/files/0068Xz9bgw1f5ud7ran59j30u70joafl.jpg', '', '', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('7', '3', '同人绘图', '../CKFinderJava/1/files/6c577879jw1f5ud3g6kizj21kw148451.jpg', '', '', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('8', '3', '同人绘图', '../CKFinderJava/1/files/9baf001bgw1f5uex15vbnj21jk15xqcb.jpg', '', '', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('9', '3', '同人绘图', '../CKFinderJava/1/files/005Xr8PEgw1f5vw422uc5j31kw0l8qg0.jpg', '', '', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('10', '5', '登录壁纸', '../CKFinderJava/1/files/1%20(1).jpg', '', '誓约烙印', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('11', '5', '登录壁纸', '../CKFinderJava/1/files/1%20(2).png', '', '404小队', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('12', '5', '登录壁纸', '../CKFinderJava/1/files/1%20(1).png', '', 'AR小队', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('13', '5', '登录壁纸', '../CKFinderJava/1/files/1%20(2).jpg', '', '万圣节', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('23', '5', '登录壁纸', '../CKFinderJava/1/files/lihuang.jpg', '', '英皇德皇', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('24', '5', '登录壁纸', '../CKFinderJava/1/files/dongh.jpg', '', '冬日战争版本', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('25', '5', '节日壁纸', '../CKFinderJava/1/files/ump.jpg', '', 'UMP姐妹情人节', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('26', '5', '登录壁纸', '../CKFinderJava/1/files/shengdan(1).jpg', '', '圣诞节', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('27', '5', '手机壁纸', '../CKFinderJava/1/files/9A91.jpg', '', '9A91', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('28', '5', '手机壁纸', '../CKFinderJava/1/files/KP31.jpg', '', '索米', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('29', '5', '手机壁纸', '../CKFinderJava/1/files/mk2.jpg', '', '维尔德', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('30', '5', '手机壁纸', '../CKFinderJava/1/files/ump45.jpg', '', 'UMP45', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('31', '3', '国际象棋', '../CKFinderJava/1/files/01.jpg', '', '维尔德与格林娜小姐~', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('32', '3', '万圣节的WA2000', '../CKFinderJava/1/files/006tSrspgw1f9ilrllyiuj31kw28gahb.jpg', '', '阴影沙发上的少女', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('34', '3', 'UMP9的万圣节祝福', '../CKFinderJava/1/files/010.jpg', '', '指挥官，不给糖就捣蛋哦~', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('35', '3', '婚纱WA2000', '../CKFinderJava/1/files/011.jpg', '', '指挥官，我这个样子……好看吗？', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('36', '3', '婚纱PPK', '../CKFinderJava/1/files/012.jpg', '', '嗯哼哼，你在期待什么呢？', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('37', '3', '战火', '../CKFinderJava/1/files/013.png', '', '为什么……要来保护我呢？', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('38', '3', '少女前线！', '../CKFinderJava/1/files/014.png', '', '战火中的少女', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('39', '3', '春天的田野', '../CKFinderJava/1/files/015.jpg', '', '指挥官，春田能为您做什么，请随时吩咐。', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('40', '3', '废墟与少女', '../CKFinderJava/1/files/016.jpg', '', '我们在这里，我们不会离开你。', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('41', '3', '战场上的97式', '../CKFinderJava/1/files/017.jpg', '', '我，即是您的武器。', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('42', '3', '格里芬小酒馆', '../CKFinderJava/1/files/018.jpg', '', '要一起喝吗？', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('43', '3', '格里芬厨房', '../CKFinderJava/1/files/019.jpg', '', '指挥官，今天要吃点什么呢？', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('44', '3', '婚纱FAL', '../CKFinderJava/1/files/020.jpg', '', '幸福的誓约', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('45', '3', 'G41', '../CKFinderJava/1/files/021.jpg', '', '主人，有想做的事吗？', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('46', '3', '万圣节HK416', '../CKFinderJava/1/files/022.jpg', '', '好看吗？', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('47', '3', '日常', '../CKFinderJava/1/files/024.jpg', '', '索米与波波沙', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('48', '3', '誓约烙印', '../CKFinderJava/1/files/025.jpg', '', '婚纱李恩菲尔德', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('49', '3', '宁静日常', '../CKFinderJava/1/files/026.jpg', '', '小酒馆中的M1加兰德', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('50', '3', '誓约烙印', '../CKFinderJava/1/files/027.jpg', '', 'M4A1', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('51', '3', '誓约烙印', '../CKFinderJava/1/files/028.jpg', '', '内格夫', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('52', '3', '誓约烙印', '../CKFinderJava/1/files/029.jpg', '', 'NTW-20', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('53', '3', '宁静日常', '../CKFinderJava/1/files/03.jpg', '', '拒绝偷吃~', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('54', '3', '誓约烙印', '../CKFinderJava/1/files/030.jpg', '', 'PK', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('55', '3', '战场剪影', '../CKFinderJava/1/files/031.jpg', '', '95式与97式', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('56', '3', '伤痕累累的心', '../CKFinderJava/1/files/032.jpg', '', 'M4A1', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('57', '3', '404 NOT FOUND', '../CKFinderJava/1/files/033.jpg', '', '404 NOT FOUND', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('58', '3', '格里芬小酒馆', '../CKFinderJava/1/files/034.jpg', '', 'KS-23与格林娜小姐', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('59', '3', '战术少女', '../CKFinderJava/1/files/035.jpg', '', 'AR15', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('60', '3', '誓约烙印', '../CKFinderJava/1/files/036.jpg', '', 'SV-98', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('61', '3', '誓约烙印', '../CKFinderJava/1/files/037.jpg', '', '汤姆森', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('62', '3', '誓约烙印', '../CKFinderJava/1/files/038.jpg', '', 'kirakira的汤姆森~', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('63', '3', '誓约烙印', '../CKFinderJava/1/files/039.jpg', '', 'TAR-21', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('64', '3', '宁静日常', '../CKFinderJava/1/files/04.jpg', '', '56-1式的胖次被抢走了……', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('65', '3', '年夜迎春', '../CKFinderJava/1/files/040.jpg', '', '97式与95式', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('66', '3', '誓约烙印', '../CKFinderJava/1/files/041.jpg', '', 'UMP9', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('67', '3', '宁静日常', '../CKFinderJava/1/files/042.jpg', '', 'UMP45', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('68', '3', '宁静……澡堂？', '../CKFinderJava/1/files/043.jpg', '', 'UMP9与UMP45', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('69', '3', '浪漫春日', '../CKFinderJava/1/files/044.jpg', '', 'UMP9与UMP45', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('70', '3', '宁静日常', '../CKFinderJava/1/files/045.jpg', '', 'VICTOR冲锋枪', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('71', '3', '夏日海滩', '../CKFinderJava/1/files/046.jpg', '', 'WA2000', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('72', '3', '战术少女', '../CKFinderJava/1/files/047.jpg', '', '索米❤', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('73', '3', '宁静日常', '../CKFinderJava/1/files/049.jpg', '', '春田', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('74', '3', '战术少女', '../CKFinderJava/1/files/05.jpg', '', 'P7', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('75', '3', '一点也不宁静的日常', '../CKFinderJava/1/files/050.jpg', '', 'MK23和司登', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('76', '3', '格里芬小酒馆', '../CKFinderJava/1/files/051.jpg', '', 'Mk48与格林娜小姐~', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('77', '3', '宁静日常', '../CKFinderJava/1/files/052.png', '', '热热闹闹的格里芬', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('78', '3', '战术少女', '../CKFinderJava/1/files/06.jpg', '', '56-1式', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('80', '3', '誓约烙印', '../CKFinderJava/1/files/07.jpg', '', 'Kar98k', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('81', '3', '誓约烙印', '../CKFinderJava/1/files/08.png', '', 'Kar98k', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('82', '3', '格里芬小酒馆', '../CKFinderJava/1/files/09.jpg', '', '79式与格林娜小姐', '', '', '0', '0', '999');
INSERT INTO `s_picture` VALUES ('83', '7', 'test', '../CKFinderJava/1/files/09.jpg', '', '', '', '', '0', '0', '999');

-- ----------------------------
-- Table structure for `s_picture_type`
-- ----------------------------
DROP TABLE IF EXISTS `s_picture_type`;
CREATE TABLE `s_picture_type` (
  `pid` int(11) NOT NULL COMMENT '主键',
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_picture_type
-- ----------------------------
INSERT INTO `s_picture_type` VALUES ('1', '游戏原画');
INSERT INTO `s_picture_type` VALUES ('2', '游戏壁纸');
INSERT INTO `s_picture_type` VALUES ('3', '同人作品');
INSERT INTO `s_picture_type` VALUES ('4', 'COS作品');

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
  `site` varchar(255) DEFAULT NULL COMMENT '链接地址',
  `status` tinyint(2) DEFAULT '0' COMMENT '状态：0 --禁用；1 -- 启用',
  `sort` int(11) DEFAULT '999' COMMENT '排序',
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
  `name` varchar(100) DEFAULT '' COMMENT '名称',
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
  `type` int(11) DEFAULT '0' COMMENT '分类',
  `recommend` tinyint(2) DEFAULT '0' COMMENT '推荐  0--否，1--是',
  `illustration` varchar(255) DEFAULT '' COMMENT '插图',
  `title` varchar(255) DEFAULT '' COMMENT '标题',
  `title2` varchar(255) DEFAULT '' COMMENT '副标题',
  `date` varchar(20) DEFAULT '' COMMENT '日期',
  `marks` tinyint(2) DEFAULT '0' COMMENT '使用链接：0--否，1--是',
  `site` varchar(255) DEFAULT '' COMMENT '链接地址',
  `content` text COMMENT '内容',
  `keywords` text COMMENT '关键字（seo）',
  `description` text COMMENT '描述（seo）',
  `author` varchar(255) DEFAULT '' COMMENT '作者',
  `description2` text COMMENT '描述 文章、作者类',
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
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  `icon` varchar(255) DEFAULT '' COMMENT '图片',
  `sort` int(11) DEFAULT '999' COMMENT '排序',
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
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` varchar(20) DEFAULT '' COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8 DEFAULT '' COMMENT '密码（md5）',
  `system` tinyint(4) DEFAULT '0' COMMENT '超管  0--否 1--是',
  `status` tinyint(4) DEFAULT '0' COMMENT '状态  0--禁用 1--启用',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

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
  `ogg` varchar(255) DEFAULT '' COMMENT 'h5OGG',
  `mp4` varchar(255) DEFAULT '' COMMENT 'h5MP4',
  `webm` varchar(255) DEFAULT '' COMMENT 'h5WEBM',
  `flash` varchar(255) DEFAULT '' COMMENT 'flash',
  `site` varchar(255) DEFAULT '' COMMENT '网址',
  `date` varchar(20) DEFAULT '' COMMENT '发布日期',
  `description` text COMMENT '描述',
  `author` varchar(255) DEFAULT '' COMMENT '作者',
  `recommend` tinyint(2) DEFAULT '0' COMMENT '推荐  0--否，1--是',
  `highlight` tinyint(2) DEFAULT '0' COMMENT '加精  0--否，1--是',
  `down` varchar(255) DEFAULT '' COMMENT '下载地址',
  `sort` int(11) DEFAULT '999' COMMENT '排序',
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
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_video_type
-- ----------------------------
INSERT INTO `s_video_type` VALUES ('1', '官网首页视频');
