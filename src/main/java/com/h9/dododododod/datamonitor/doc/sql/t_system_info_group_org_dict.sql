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

 Date: 24/03/2024 15:09:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_system_info_group_org_dict
-- ----------------------------
DROP TABLE IF EXISTS `t_system_info_group_org_dict`;
CREATE TABLE `t_system_info_group_org_dict`  (
  `id` bigint(16) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `dict_id` bigint(16) NULL DEFAULT NULL COMMENT '字典id',
  `group_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_system_info_group_org_dict
-- ----------------------------
INSERT INTO `t_system_info_group_org_dict` VALUES (5, 1, 1);
INSERT INTO `t_system_info_group_org_dict` VALUES (6, 2, 1);
INSERT INTO `t_system_info_group_org_dict` VALUES (7, 3, 1);
INSERT INTO `t_system_info_group_org_dict` VALUES (8, 4, 1);
INSERT INTO `t_system_info_group_org_dict` VALUES (9, 1, 2);
INSERT INTO `t_system_info_group_org_dict` VALUES (10, 2, 2);
INSERT INTO `t_system_info_group_org_dict` VALUES (11, 3, 2);
INSERT INTO `t_system_info_group_org_dict` VALUES (12, 4, 2);

SET FOREIGN_KEY_CHECKS = 1;
