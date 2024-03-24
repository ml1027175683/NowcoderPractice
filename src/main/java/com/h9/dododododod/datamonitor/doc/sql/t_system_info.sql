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

 Date: 24/03/2024 15:08:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_system_info
-- ----------------------------
DROP TABLE IF EXISTS `t_system_info`;
CREATE TABLE `t_system_info`  (
  `id` bigint(16) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `group_id` bigint(16) NULL DEFAULT NULL COMMENT '数据分组id',
  `data_info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'json数据',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_system_info
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
