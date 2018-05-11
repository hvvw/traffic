/*
Navicat MySQL Data Transfer

Source Server         : remote
Source Server Version : 50721
Source Host           : 119.23.34.80:3306
Source Database       : traffic

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-05-08 21:00:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_agency
-- ----------------------------
DROP TABLE IF EXISTS `t_agency`;
CREATE TABLE `t_agency` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `lat` double DEFAULT NULL,
  `lng` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for t_facilities
-- ----------------------------
DROP TABLE IF EXISTS `t_facilities`;
CREATE TABLE `t_facilities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `lat` double DEFAULT NULL,
  `lng` double DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `load_id` int(11) DEFAULT NULL,
  `display` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for t_load
-- ----------------------------
DROP TABLE IF EXISTS `t_load`;
CREATE TABLE `t_load` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '道路名字',
  `tech_level` int(11) DEFAULT NULL COMMENT '道路等级',
  `lane` int(11) DEFAULT NULL COMMENT '车道数量',
  `pavement_type` varchar(255) DEFAULT NULL COMMENT '路面类型',
  `pavement_width` int(11) DEFAULT NULL COMMENT '路面宽度',
  `subgrade_width` int(11) DEFAULT NULL COMMENT '路基宽度',
  `create_time` datetime DEFAULT NULL,
  `display` int(11) DEFAULT '1',
  `center_point_lat` double DEFAULT NULL COMMENT '中心坐标',
  `center_point_lng` double DEFAULT NULL COMMENT '中心坐标',
  `show_level` int(11) DEFAULT NULL COMMENT '展示等级',
  `agency_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for t_maintenance
-- ----------------------------
DROP TABLE IF EXISTS `t_maintenance`;
CREATE TABLE `t_maintenance` (
  `id` int(11) NOT NULL,
  `center_point_lat` double DEFAULT NULL,
  `center_point_lng` double DEFAULT NULL,
  `load_id` int(11) DEFAULT NULL,
  `load_name` varchar(255) DEFAULT NULL,
  `display` tinyint(1) DEFAULT NULL,
  `situation` varchar(255) DEFAULT NULL,
  `disease` varchar(255) DEFAULT NULL,
  `afforested_area` double DEFAULT NULL,
  `plant_variety` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for t_point
-- ----------------------------
DROP TABLE IF EXISTS `t_point`;
CREATE TABLE `t_point` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lng` double DEFAULT NULL COMMENT '经度',
  `lat` double DEFAULT NULL COMMENT '维度',
  `type` varchar(255) DEFAULT NULL COMMENT '坐标类型',
  `p_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for t_structure
-- ----------------------------
DROP TABLE IF EXISTS `t_structure`;
CREATE TABLE `t_structure` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `lat` double DEFAULT NULL,
  `lng` double DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `load_id` int(11) DEFAULT NULL,
  `display` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
