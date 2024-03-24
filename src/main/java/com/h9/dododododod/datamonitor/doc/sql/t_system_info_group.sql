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

 Date: 24/03/2024 15:09:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_system_info_group
-- ----------------------------
DROP TABLE IF EXISTS `t_system_info_group`;
CREATE TABLE `t_system_info_group`  (
  `id` bigint(16) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `group_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `show_id` int(11) NULL DEFAULT NULL COMMENT '展示id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_system_info_group
-- ----------------------------
INSERT INTO `t_system_info_group` VALUES (1, '1号主机系统属性', 1);
INSERT INTO `t_system_info_group` VALUES (2, '2号主机系统属性', 1);

SET FOREIGN_KEY_CHECKS = 1;
