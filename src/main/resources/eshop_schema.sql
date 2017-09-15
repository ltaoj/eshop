/*
Navicat MySQL Data Transfer

Source Server         : db
Source Server Version : 50625
Source Host           : localhost:3306
Source Database       : eshop

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2017-09-15 16:41:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `cartitem`
-- ----------------------------
DROP TABLE IF EXISTS `cartitem`;
CREATE TABLE `cartitem` (
  `login_id` varchar(20) NOT NULL,
  `item_id` varchar(20) NOT NULL,
  `quantity` int(11) NOT NULL,
  `unitprice` decimal(10,2) NOT NULL,
  PRIMARY KEY (`login_id`,`item_id`),
  KEY `cart_item_2` (`item_id`),
  CONSTRAINT `cart_item_2` FOREIGN KEY (`item_id`) REFERENCES `item` (`item_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cart_user_1` FOREIGN KEY (`login_id`) REFERENCES `userinfo` (`login_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cartitem
-- ----------------------------

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `category_id` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------

-- ----------------------------
-- Table structure for `harvestaddr`
-- ----------------------------
DROP TABLE IF EXISTS `harvestaddr`;
CREATE TABLE `harvestaddr` (
  `addr_id` int(11) NOT NULL AUTO_INCREMENT,
  `login_id` varchar(20) NOT NULL,
  `alias_name` varchar(20) NOT NULL,
  `province` varchar(20) NOT NULL,
  `city` varchar(20) NOT NULL,
  `district` varchar(20) NOT NULL,
  `detail_addr` varchar(20) NOT NULL,
  `use_default` int(4) DEFAULT '0',
  PRIMARY KEY (`addr_id`),
  KEY `harv_user_1` (`login_id`),
  CONSTRAINT `harv_user_1` FOREIGN KEY (`login_id`) REFERENCES `userinfo` (`login_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of harvestaddr
-- ----------------------------

-- ----------------------------
-- Table structure for `inventory`
-- ----------------------------
DROP TABLE IF EXISTS `inventory`;
CREATE TABLE `inventory` (
  `item_id` varchar(20) NOT NULL,
  `inve_quan` int(11) NOT NULL,
  PRIMARY KEY (`item_id`),
  CONSTRAINT `inven_item_1` FOREIGN KEY (`item_id`) REFERENCES `item` (`item_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of inventory
-- ----------------------------

-- ----------------------------
-- Table structure for `item`
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `item_id` varchar(20) NOT NULL,
  `category_id` varchar(20) NOT NULL,
  `supplier_id` varchar(20) NOT NULL,
  `listprice` decimal(10,2) NOT NULL,
  `unitcost` decimal(10,2) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `isStock` int(4) NOT NULL,
  `attr1` varchar(200) DEFAULT NULL,
  `attr2` varchar(200) DEFAULT NULL,
  `attr3` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`item_id`),
  KEY `item_supplier_1` (`supplier_id`),
  KEY `item_cate_2` (`category_id`),
  CONSTRAINT `item_cate_2` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `item_supplier_1` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`supplier_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item
-- ----------------------------

-- ----------------------------
-- Table structure for `lineitem`
-- ----------------------------
DROP TABLE IF EXISTS `lineitem`;
CREATE TABLE `lineitem` (
  `order_id` varchar(20) NOT NULL,
  `item_id` varchar(20) NOT NULL,
  `quantity` int(11) NOT NULL,
  `unitprice` decimal(10,2) NOT NULL,
  PRIMARY KEY (`order_id`,`item_id`),
  KEY `line_item_2` (`item_id`),
  CONSTRAINT `line_item_2` FOREIGN KEY (`item_id`) REFERENCES `item` (`item_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `line_order_1` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lineitem
-- ----------------------------

-- ----------------------------
-- Table structure for `log`
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(4) NOT NULL,
  `user_id` varchar(20) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`log_id`),
  KEY `log_user_1` (`user_id`),
  CONSTRAINT `log_user_1` FOREIGN KEY (`user_id`) REFERENCES `signon` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `order_id` varchar(20) NOT NULL,
  `order_date` datetime NOT NULL,
  `login_id` varchar(20) NOT NULL,
  `origin_province` varchar(20) NOT NULL,
  `origin_city` varchar(20) NOT NULL,
  `bill_province` varchar(20) NOT NULL,
  `bill_city` varchar(20) NOT NULL,
  `bill_district` varchar(20) NOT NULL,
  `bill_detail_addr` varchar(50) NOT NULL,
  `name` varchar(20) NOT NULL,
  `total_price` decimal(20,0) NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `order_user_1` (`login_id`),
  CONSTRAINT `order_user_1` FOREIGN KEY (`login_id`) REFERENCES `userinfo` (`login_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for `orderstatus`
-- ----------------------------
DROP TABLE IF EXISTS `orderstatus`;
CREATE TABLE `orderstatus` (
  `order_id` varchar(20) NOT NULL,
  `date` datetime NOT NULL,
  `status` int(4) NOT NULL,
  PRIMARY KEY (`order_id`),
  CONSTRAINT `orderstatus_order_1` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderstatus
-- ----------------------------

-- ----------------------------
-- Table structure for `signon`
-- ----------------------------
DROP TABLE IF EXISTS `signon`;
CREATE TABLE `signon` (
  `user_id` varchar(20) NOT NULL,
  `password` varchar(40) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `authorities` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `signon_supplier_2` FOREIGN KEY (`user_id`) REFERENCES `supplier` (`supplier_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `signon_user_1` FOREIGN KEY (`user_id`) REFERENCES `userinfo` (`login_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of signon
-- ----------------------------

-- ----------------------------
-- Table structure for `supplier`
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `supplier_id` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `province` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `sex` int(4) DEFAULT NULL,
  `status` int(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supplier
-- ----------------------------

-- ----------------------------
-- Table structure for `userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `login_id` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `sex` int(4) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `status` int(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`login_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
