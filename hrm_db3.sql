/*
 Navicat Premium Data Transfer

 Source Server         : Totoro
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : hrm_db3

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 18/05/2020 10:33:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dept_inf
-- ----------------------------
DROP TABLE IF EXISTS `dept_inf`;
CREATE TABLE `dept_inf`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `REMARK` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept_inf
-- ----------------------------
INSERT INTO `dept_inf` VALUES (1, '打杂', '123');
INSERT INTO `dept_inf` VALUES (2, '运营部', '运营部');
INSERT INTO `dept_inf` VALUES (3, '财务部', '财务部');
INSERT INTO `dept_inf` VALUES (5, '总公办', '总公办');
INSERT INTO `dept_inf` VALUES (6, '市场部', '市场部');
INSERT INTO `dept_inf` VALUES (7, '教学部', '教学部');

-- ----------------------------
-- Table structure for document_inf
-- ----------------------------
DROP TABLE IF EXISTS `document_inf`;
CREATE TABLE `document_inf`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `filename` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `filetype` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `filebytes` longblob NOT NULL,
  `REMARK` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATE_DATE` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `USER_ID` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `FK_DOCUMENT_USER`(`USER_ID`) USING BTREE,
  CONSTRAINT `FK_DOCUMENT_USER` FOREIGN KEY (`USER_ID`) REFERENCES `user_inf` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for employee_inf
-- ----------------------------
DROP TABLE IF EXISTS `employee_inf`;
CREATE TABLE `employee_inf`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DEPT_ID` int(11) NOT NULL,
  `JOB_ID` int(11) NOT NULL,
  `NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CARD_ID` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ADDRESS` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `POST_CODE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TEL` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PHONE` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `QQ_NUM` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EMAIL` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `SEX` int(11) NOT NULL DEFAULT 1,
  `PARTY` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BIRTHDAY` datetime(0) NULL DEFAULT NULL,
  `RACE` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EDUCATION` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SPECIALITY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `HOBBY` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `REMARK` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATE_DATE` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `FK_EMP_DEPT`(`DEPT_ID`) USING BTREE,
  INDEX `FK_EMP_JOB`(`JOB_ID`) USING BTREE,
  CONSTRAINT `FK_EMP_DEPT` FOREIGN KEY (`DEPT_ID`) REFERENCES `dept_inf` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_EMP_JOB` FOREIGN KEY (`JOB_ID`) REFERENCES `job_inf` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee_inf
-- ----------------------------
INSERT INTO `employee_inf` VALUES (1, 1, 8, '爱丽丝', '4328011988', '广州天河', '510000', '020-77777777', '13902001111', '36750066', '251425887@qq.com', 0, '愤青', '1980-01-01 00:00:00', '满', '本科', '美声', '唱歌', '四大天王', '2016-03-14 11:35:18');
INSERT INTO `employee_inf` VALUES (3, 1, 2, 'bb', '432801197711251038', '广州', '510000', '020-99999999', '13907351532', '36750064', '36750064@qq.com', 1, '党员', '1977-11-25 00:00:00', '汉', '本科', '计算机', '爬山', '无', '2016-07-14 09:54:52');
INSERT INTO `employee_inf` VALUES (4, 1, 2, 'bb', '432801197711251038', '广州', '510000', '020-99999999', '13907351532', '36750064', '36750064@qq.com', 1, '党员', '1977-11-25 00:00:00', '汉', '本科', '计算机', '爬山', '无', '2016-07-14 09:54:52');
INSERT INTO `employee_inf` VALUES (5, 1, 2, 'bb', '432801197711251038', '广州', '510000', '020-99999999', '13907351532', '36750064', '36750064@qq.com', 1, '党员', '1977-11-25 00:00:00', '汉', '本科', '计算机', '爬山', '无', '2016-07-14 09:54:52');
INSERT INTO `employee_inf` VALUES (6, 1, 2, 'bb', '432801197711251038', '广州', '510000', '020-99999999', '13907351532', '36750064', '36750064@qq.com', 1, '党员', '1977-11-25 00:00:00', '汉', '本科', '计算机', '爬山', '无', '2016-07-14 09:54:52');
INSERT INTO `employee_inf` VALUES (7, 1, 2, 'bb', '432801197711251038', '广州', '510000', '020-99999999', '13907351532', '36750064', '36750064@qq.com', 1, '党员', '1977-11-25 00:00:00', '汉', '本科', '计算机', '爬山', '无', '2016-07-14 09:54:52');
INSERT INTO `employee_inf` VALUES (8, 1, 2, 'bb', '432801197711251038', '广州', '510000', '020-99999999', '13907351532', '36750064', '36750064@qq.com', 1, '党员', '1977-11-25 00:00:00', '汉', '本科', '计算机', '爬山', '无', '2016-07-14 09:54:52');
INSERT INTO `employee_inf` VALUES (9, 1, 2, 'bb', '432801197711251038', '广州', '510000', '020-99999999', '13907351532', '36750064', '36750064@qq.com', 1, '党员', '1977-11-25 00:00:00', '汉', '本科', '计算机', '爬山', '无', '2016-07-14 09:54:52');
INSERT INTO `employee_inf` VALUES (10, 5, 8, 'bb', '432801197711251038', '广州3', '510000', '020-99999999', '13907351532', '36750064', '36750064@qq.com', 1, '党员', '1977-11-25 00:00:00', '汉', '本科', '计算机', '爬山', '无', '2016-07-14 09:54:52');
INSERT INTO `employee_inf` VALUES (12, 1, 1, '粪青', '123456', ' 天安门', NULL, ' 020-123456', '13800138000', NULL, '123456@qq.com', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-01-30 00:04:00');
INSERT INTO `employee_inf` VALUES (13, 1, 8, '粪青', '123456', ' 天安门', NULL, ' 020-123456', '13800138000', NULL, '123456@qq.com', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-01-30 00:04:00');
INSERT INTO `employee_inf` VALUES (15, 1, 1, '粪青', '123456', ' 天安门', NULL, ' 020-123456', '13800138000', NULL, '123456@qq.com', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-01-30 00:04:00');
INSERT INTO `employee_inf` VALUES (16, 1, 1, '123', '123456', ' 天安门', NULL, ' 020-123456', '13800138000', NULL, '123456@qq.com', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-01-30 00:04:00');

-- ----------------------------
-- Table structure for job_inf
-- ----------------------------
DROP TABLE IF EXISTS `job_inf`;
CREATE TABLE `job_inf`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `REMARK` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of job_inf
-- ----------------------------
INSERT INTO `job_inf` VALUES (1, '打杂', '123');
INSERT INTO `job_inf` VALUES (2, 'Java开发工程师', 'Java开发工程师');
INSERT INTO `job_inf` VALUES (3, 'Java中级开发工程师', 'Java中级开发工程师');
INSERT INTO `job_inf` VALUES (4, 'Java高级开发工程师', 'Java高级开发工程师');
INSERT INTO `job_inf` VALUES (5, '系统管理员', '系统管理员');
INSERT INTO `job_inf` VALUES (6, '架构师', '架构师');
INSERT INTO `job_inf` VALUES (7, '主管', '主管');
INSERT INTO `job_inf` VALUES (8, '经理', '经理');
INSERT INTO `job_inf` VALUES (9, '总经理', '总经理');

-- ----------------------------
-- Table structure for menu_inf
-- ----------------------------
DROP TABLE IF EXISTS `menu_inf`;
CREATE TABLE `menu_inf`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '菜单名称',
  `parent_id` int(11) NOT NULL COMMENT '菜单父级ID',
  `url` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu_inf
-- ----------------------------
INSERT INTO `menu_inf` VALUES (1, '用户管理', 0, '');
INSERT INTO `menu_inf` VALUES (2, '部门管理', 0, '');
INSERT INTO `menu_inf` VALUES (3, '职位管理', 0, '');
INSERT INTO `menu_inf` VALUES (4, '用户列表', 1, 'Users');
INSERT INTO `menu_inf` VALUES (5, '添加用户', 1, 'AddUser');
INSERT INTO `menu_inf` VALUES (6, '添加部门', 2, 'AddJob');
INSERT INTO `menu_inf` VALUES (7, '部门列表', 2, '1');
INSERT INTO `menu_inf` VALUES (8, '职位列表', 3, NULL);
INSERT INTO `menu_inf` VALUES (9, '添加职位', 3, NULL);

-- ----------------------------
-- Table structure for user_inf
-- ----------------------------
DROP TABLE IF EXISTS `user_inf`;
CREATE TABLE `user_inf`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `PASSWORD` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `STATUS` int(11) NOT NULL DEFAULT 1,
  `createdate` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_inf
-- ----------------------------
INSERT INTO `user_inf` VALUES (18, 'admin', '123456', 1, '2020-01-01 00:05:00', '3434');
INSERT INTO `user_inf` VALUES (19, 'admin', '123456', 1, '2020-01-01 00:05:00', '3434');
INSERT INTO `user_inf` VALUES (21, 'admin', '1234565', 1, '2020-01-01 00:05:00', '3434');
INSERT INTO `user_inf` VALUES (22, 'admin', '123456', 1, '2020-01-01 00:05:00', '3434');
INSERT INTO `user_inf` VALUES (23, 'admin', '123456', 1, '2020-01-01 00:05:00', '3434');
INSERT INTO `user_inf` VALUES (26, 'admin', '123456', 1, '2020-01-01 00:05:00', '3434');
INSERT INTO `user_inf` VALUES (27, 'test', '123', 1, '2020-05-02 12:38:45', '123');
INSERT INTO `user_inf` VALUES (28, ' admin', ' 123456', 1, '2020-01-03 00:05:00', ' 3434');
INSERT INTO `user_inf` VALUES (29, '424', '56', 1, '2020-01-05 00:05:00', '424');

SET FOREIGN_KEY_CHECKS = 1;
