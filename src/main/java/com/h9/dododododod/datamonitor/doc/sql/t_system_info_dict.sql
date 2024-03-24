/*
 Navicat Premium Data Transfer

 Source Server         : 172.16.1.47_3306
 Source Server Type    : MySQL
 Source Server Version : 50734 (5.7.34)
 Source Host           : 172.16.1.47:3306
 Source Schema         : account

 Target Server Type    : MySQL
 Target Server Version : 50734 (5.7.34)
 File Encoding         : 65001

 Date: 24/03/2024 15:09:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_system_info_dict
-- ----------------------------
DROP TABLE IF EXISTS `t_system_info_dict`;
CREATE TABLE `t_system_info_dict`  (
  `id` bigint(16) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `system_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '系统数据标识',
  `ifo_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_system_info_dict
-- ----------------------------
INSERT INTO `t_system_info_dict` VALUES (1, 'i1', '网络速率');
INSERT INTO `t_system_info_dict` VALUES (2, 'i2', 'CPU使用率');
INSERT INTO `t_system_info_dict` VALUES (3, 'i3', '内存使用率');
INSERT INTO `t_system_info_dict` VALUES (4, 'i4', '硬盘使用率');

SET FOREIGN_KEY_CHECKS = 1;
