

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(0) NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `real_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sex` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `time` datetime(6) NULL DEFAULT NULL,
  `birthday` datetime(6) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, '1009', 'pan123', 'JJ', 'Female', NULL, '2001-06-12 00:00:00.000000');

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `did` int(0) NOT NULL,
  `dept_no` int(0) NULL DEFAULT NULL,
  `dept_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`did`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (1, 2001, 'Development Department');
INSERT INTO `dept` VALUES (2, 2002, 'Testing Department');
INSERT INTO `dept` VALUES (3, 2003, 'Art Department');

-- ----------------------------
-- Table structure for history
-- ----------------------------
DROP TABLE IF EXISTS `history`;
CREATE TABLE `history`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` int(0) NULL DEFAULT NULL,
  `type` tinyint(0) NULL DEFAULT NULL,
  `to_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `time` datetime(6) NULL DEFAULT NULL,
  `money` double(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of history
-- ----------------------------
INSERT INTO `history` VALUES (2, 1, 0, NULL, '2022-07-11 21:00:01.000000', NULL);
INSERT INTO `history` VALUES (3, 1, 0, NULL, '2022-07-12 08:57:14.000000', NULL);
INSERT INTO `history` VALUES (4, 1, 0, NULL, '2022-07-12 09:01:02.000000', NULL);
INSERT INTO `history` VALUES (5, 1, 3, '1008', '2022-07-12 09:10:16.000000', 200.00);
INSERT INTO `history` VALUES (6, 1, 3, '888', '2022-07-12 09:16:00.000000', 500.00);
INSERT INTO `history` VALUES (7, 1, 3, '1008', '2022-07-12 09:16:12.000000', 400.00);
INSERT INTO `history` VALUES (8, 2, 3, '1008', '2022-07-12 09:24:16.000000', 100.00);
INSERT INTO `history` VALUES (9, 1, 3, '1008', '2022-06-01 11:13:54.000000', 100.00);
INSERT INTO `history` VALUES (10, 1, 1, NULL, '2022-07-12 13:16:30.000000', 200.00);
INSERT INTO `history` VALUES (11, 1, 2, NULL, '2022-07-12 13:16:47.000000', 300.00);
INSERT INTO `history` VALUES (13, 2, 0, NULL, '2022-07-13 18:56:25.000000', NULL);
INSERT INTO `history` VALUES (14, 2, 1, NULL, '2022-07-13 18:56:47.000000', 100.00);
INSERT INTO `history` VALUES (15, 2, 1, NULL, '2022-07-13 19:00:35.000000', 500.00);
INSERT INTO `history` VALUES (16, 2, 2, NULL, '2022-07-13 19:00:50.000000', 500.00);
INSERT INTO `history` VALUES (17, 2, 3, '1008', '2022-07-13 19:01:20.000000', 20000.00);
INSERT INTO `history` VALUES (18, 1, 1, NULL, '2022-07-13 19:19:00.000000', 200.00);
INSERT INTO `history` VALUES (19, 59, 1, NULL, '2023-02-20 12:02:18.000000', 20.00);
INSERT INTO `history` VALUES (20, 59, 3, '1111', '2023-02-20 12:02:59.000000', 20.00);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `card_no` int(0) NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `real_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sex` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `balance` double NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  `birthday` datetime(6) NULL DEFAULT NULL,
  `did` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `card_no`(`card_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 1001, '123', 'Tom Smiths', 'Male', 1812, '2022-07-10 16:53:40', '2022-07-10 16:53:40.000000', 1);
INSERT INTO `user` VALUES (26, 1111, '123', 'Smiths', 'Male', 6686, '2021-10-09 19:19:19', '2021-10-08 18:18:18.000000', 3);
INSERT INTO `user` VALUES (27, 1112, '12321', 'dwa', 'Male', 6666, '2021-10-09 19:19:19', '2021-10-08 18:18:18.000000', 2);
INSERT INTO `user` VALUES (37, 1113, 'dwada', 'Frank Kim', 'Male', 1321321, '2021-10-09 19:19:19', '2021-10-08 18:18:18.000000', 2);
INSERT INTO `user` VALUES (59, 1080, '123', 'JJ', 'Female', 520, '2023-02-20 11:57:30', '2001-06-12 00:00:00.000000', NULL);

SET FOREIGN_KEY_CHECKS = 1;
