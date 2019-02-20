/*
Navicat MySQL Data Transfer

Source Server         : lj
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : website_ccydhz

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2019-02-20 16:55:07
*/

SET FOREIGN_KEY_CHECKS=0;


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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of s_background
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of s_contact
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of s_menu
-- ----------------------------


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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

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
  `name` varchar(100) DEFAULT '' COMMENT '名称',
  `site` varchar(255) DEFAULT '' COMMENT '网址',
  `pic` varchar(255) DEFAULT '' COMMENT '图片  按钮/二维码',
  `status` tinyint(4) DEFAULT '0' COMMENT '状态  0：禁用，1：启用',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of s_picture
-- ----------------------------


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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

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
  `mark` tinyint(4) DEFAULT '0' COMMENT '类型  0：视频，1：音频',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of s_video_type
-- ----------------------------
INSERT INTO `s_video_type` VALUES ('1', '官网首页视频', '0');
INSERT INTO `s_video_type` VALUES ('2', '同人影视', '0');
INSERT INTO `s_video_type` VALUES ('3', '音乐', '1');
