/*
Navicat MySQL Data Transfer

Source Server         : chomolungma
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : cdp

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2019-01-21 17:25:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_account
-- ----------------------------
DROP TABLE IF EXISTS `sys_account`;
CREATE TABLE `sys_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(255) DEFAULT NULL COMMENT '创建人',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_user` varchar(255) DEFAULT NULL COMMENT '修改人',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `user_password` varchar(255) DEFAULT NULL COMMENT '用户密码',
  `status` varchar(255) DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_account
-- ----------------------------
INSERT INTO `sys_account` VALUES ('1', null, null, '2019-01-21 14:34:06', null, 'abc', '21218cca77804d2ba1922c33e0151105', '0');
INSERT INTO `sys_account` VALUES ('2', null, null, '2019-01-21 14:34:07', null, 'abc', '21218cca77804d2ba1922c33e0151105', '0');
INSERT INTO `sys_account` VALUES ('3', null, null, '2019-01-21 14:33:54', null, 'admin', '21218cca77804d2ba1922c33e0151105', '0');
INSERT INTO `sys_account` VALUES ('4', '2019-01-21 09:51:43', null, null, null, 'admin', 'e10adc3949ba59abbe56e057f20f883e', '0');
INSERT INTO `sys_account` VALUES ('5', '2019-01-21 09:57:38', null, null, null, 'admin', 'e10adc3949ba59abbe56e057f20f883e', '0');

-- ----------------------------
-- Table structure for sys_org
-- ----------------------------
DROP TABLE IF EXISTS `sys_org`;
CREATE TABLE `sys_org` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(255) DEFAULT NULL COMMENT '创建人',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_user` varchar(255) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织表';

-- ----------------------------
-- Records of sys_org
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` int(11) DEFAULT NULL COMMENT '创建人',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_user` int(11) DEFAULT NULL COMMENT '修改人',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `gender` varchar(255) DEFAULT NULL COMMENT '性别',
  `tel` varchar(255) DEFAULT NULL COMMENT '座机',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机',
  `addr` varchar(255) DEFAULT NULL COMMENT '住址',
  `company` varchar(255) DEFAULT NULL COMMENT '公司',
  `status` char(2) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '2018-12-30 01:00:00', '2', '0000-00-00 00:00:00', '3', 'kushu001', '123456', null, null, null, null, '1');
INSERT INTO `sys_user` VALUES ('2', '2018-12-30 01:00:00', null, '2018-12-30 01:00:00', '2', 'test', '123456', null, null, null, null, '2');
