/*
Navicat MySQL Data Transfer

Source Server         : lj
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : website_ccydhz

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2018-08-30 18:01:48
*/

SET FOREIGN_KEY_CHECKS=0;

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
