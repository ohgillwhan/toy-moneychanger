CREATE DATABASE `MONEY_CHANGER` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE MONEY_CHANGER

CREATE TABLE `currency` (
                            `source` char(3) NOT NULL COMMENT '기준 화폐 ',
                            `destination` char(3) NOT NULL COMMENT '대상 화폐 ',
                            `rate` decimal(12,6) NOT NULL COMMENT '비율 ',
                            PRIMARY KEY (`source`,`destination`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='환율 ';
