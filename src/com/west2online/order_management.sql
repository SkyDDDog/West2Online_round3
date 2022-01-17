/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.27 : Database - order_management
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`order_management` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `order_management`;

/*Table structure for table `good_order` */

DROP TABLE IF EXISTS `good_order`;

CREATE TABLE `good_order` (
  `order_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `order_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单编号',
  `good_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名',
  `order_time` datetime NOT NULL COMMENT '下单时间',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;

/*Data for the table `good_order` */

insert  into `good_order`(`order_id`,`order_no`,`good_no`,`order_time`) values (1,'2396494622572225863','6901234567892','2021-12-25 19:18:30'),(2,'2396494622573225861','10029146173677','2022-01-01 00:00:00'),(3,'2396494623573225861','100023292730','2022-01-03 02:21:55'),(4,'2396494622575225861','100023485352','2021-11-18 08:10:47'),(5,'2496494622573225861','100022009684','2021-11-08 23:50:14'),(6,'2396496622573225861','100022009684','2022-01-01 19:23:38');

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `good_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `good_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品编号',
  `good_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名',
  `good_price` decimal(10,2) NOT NULL COMMENT '商品价格',
  PRIMARY KEY (`good_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;

/*Data for the table `goods` */

insert  into `goods`(`good_id`,`good_no`,`good_name`,`good_price`) values (1,'6901234567892','R9000p','7999.00'),(2,'10029146173677','R9000k','10999.00'),(3,'100023292730','RTX3060TI','5699.00'),(4,'100023485352','RTX3070Super','6799.00'),(5,'100022009684','RTX3070TI','7999.00'),(6,'100016724434','MacBook Pro','12699.00');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
