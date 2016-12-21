/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.7.11-log : Database - quanlidetaikhoahoc
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`quanlidetaikhoahoc` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `quanlidetaikhoahoc`;

/*Table structure for table `danh_gia` */

DROP TABLE IF EXISTS `danh_gia`;

CREATE TABLE `danh_gia` (
  `id` int(11) NOT NULL,
  `ten` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `danh_gia` */

insert  into `danh_gia`(`id`,`ten`) values (1,'Xuất sắc'),(2,'Đạt'),(3,'Tốt'),(4,'Không đạt');

/*Table structure for table `de_tai` */

DROP TABLE IF EXISTS `de_tai`;

CREATE TABLE `de_tai` (
  `id_de_tai` bigint(20) NOT NULL AUTO_INCREMENT,
  `ma_de_tai` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `ten` text COLLATE utf8_unicode_ci NOT NULL,
  `nguoi_dung_id` bigint(20) NOT NULL,
  `mo_ta` text COLLATE utf8_unicode_ci,
  `thoi_gian_bat_dau` date NOT NULL,
  `thoi_gian_ket_thuc` date NOT NULL,
  `loai_de_tai` int(11) NOT NULL,
  `huong_nghien_cuu` int(11) NOT NULL,
  `trang_thai` int(11) DEFAULT NULL,
  `ly_do_huy` text COLLATE utf8_unicode_ci,
  `danh_gia` int(11) DEFAULT NULL,
  `thoi_gian_nghiem_thu` date DEFAULT NULL,
  `nam` int(11) NOT NULL,
  `duyet` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id_de_tai`),
  UNIQUE KEY `ma_de_tai` (`ma_de_tai`),
  KEY `de_tai_ibfk_1` (`nguoi_dung_id`),
  KEY `loai_de_tai` (`loai_de_tai`),
  KEY `huong_nghien_cuu` (`huong_nghien_cuu`),
  KEY `trang_thai` (`trang_thai`),
  KEY `danh_gia` (`danh_gia`),
  FULLTEXT KEY `ten` (`ten`),
  CONSTRAINT `de_tai_ibfk_1` FOREIGN KEY (`nguoi_dung_id`) REFERENCES `nguoi_dung` (`id_nguoi_dung`) ON DELETE CASCADE,
  CONSTRAINT `de_tai_ibfk_2` FOREIGN KEY (`loai_de_tai`) REFERENCES `loai_de_tai` (`id`),
  CONSTRAINT `de_tai_ibfk_3` FOREIGN KEY (`huong_nghien_cuu`) REFERENCES `huong_nghien_cuu` (`id`),
  CONSTRAINT `de_tai_ibfk_4` FOREIGN KEY (`trang_thai`) REFERENCES `trang_thai_de_tai` (`id`),
  CONSTRAINT `de_tai_ibfk_5` FOREIGN KEY (`danh_gia`) REFERENCES `danh_gia` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `de_tai` */

insert  into `de_tai`(`id_de_tai`,`ma_de_tai`,`ten`,`nguoi_dung_id`,`mo_ta`,`thoi_gian_bat_dau`,`thoi_gian_ket_thuc`,`loai_de_tai`,`huong_nghien_cuu`,`trang_thai`,`ly_do_huy`,`danh_gia`,`thoi_gian_nghiem_thu`,`nam`,`duyet`) values (1,'KH1','Xây dựng công cụ mô phỏng các thuật toán định tuyến mạng không dây ứng dụng nghiên cứu khắc phục hố mạng trong môi trường địa hình phức tạp',2,'','2014-01-10','2016-12-12',1,1,1,'',1,'2016-12-23',2013,1),(3,'KH2','Nghiên cứu phát triển giải pháp tích hợp GPS / INS chặt và siêu chặt trong cấu trúc xử lý tín hiệu của bộ thu SDR GPS',2,NULL,'2013-11-10','2016-12-12',2,1,3,NULL,NULL,NULL,2013,1),(4,'KH3','Mạng cảm biến thông minh giám sát môi trường (ISNEM)',3,NULL,'2014-02-10','2016-12-12',3,2,NULL,NULL,NULL,NULL,2013,0),(5,'KH4','Kiểm soát cây trồng dựa trên nền tảng của Internet of Things',2,NULL,'2015-01-10','2016-12-12',3,2,2,NULL,NULL,NULL,2013,1),(6,'KH5','Nghiên cứu xây dựng thuật toán giải quyết bài toán đường đi bao phủ và ứng dụng cho robot lau nhà.',4,NULL,'2015-01-10','2016-12-12',2,2,3,NULL,NULL,NULL,2014,1),(8,'KH6','Tối ưu hóa mô hình kết hợp các đồ thị Markov dạng cây trong bài toán phân đoạn ảnh',5,NULL,'2013-12-03','2016-12-12',1,2,1,NULL,NULL,NULL,2015,1),(9,'KH7','Đề xuất giải pháp tìm kiếm và tra cứu phim sử dụng web ngữ nghĩa',4,NULL,'2013-12-03','2016-12-14',3,2,2,NULL,NULL,NULL,2013,1),(10,'KH8','Nghiên cứu mô hình  bảo mật và giám sát hệ thống thông tin dựa vào phân tích dữ liệu lớn',4,NULL,'2013-12-03','2016-12-14',3,2,NULL,NULL,NULL,NULL,2013,0),(11,'KH9','Xây dựng bộ định tuyến mềm hỗ trợ cục bộ hoá lưu lượng các ứng dụng P2P',4,NULL,'2013-12-03','2016-12-14',2,1,NULL,NULL,NULL,NULL,2013,0),(12,'KH10','Các phương pháp giải quyết bài toán đi chung xe tại các thành phố lớn',5,NULL,'2013-12-03','2016-12-14',2,1,1,NULL,NULL,NULL,2016,1),(13,'KH11','Xây dựng bộ dữ liệu kiểm thử tìm kiếm thông tin tiếng việ',5,NULL,'2013-09-05','2016-12-14',2,1,NULL,NULL,NULL,NULL,2013,0),(14,'KH12','Xây dựng cấu trúc dữ liệu đồ thị thích hợp dùng để giải bài toán phát hiện cộng đồng (community detection) trong mạng xã hội',5,NULL,'2013-09-05','2016-12-14',2,1,NULL,NULL,NULL,NULL,2013,0),(15,'KH13','Nghiên cứu xây dựng hệ thống nhận dạng phương ngữ tiếng Việt sử dụng phương pháp học sâu',5,NULL,'2013-09-05','2016-12-14',2,1,NULL,NULL,NULL,NULL,2013,0),(16,'KH14','Phát hiện và giám sát sự phát triển của hố mạng trong mạng cảm biến không dây',2,NULL,'2013-09-05','2016-12-14',2,1,NULL,NULL,NULL,NULL,2013,0),(17,'KH15','Xây dựng kiến trúc SDN mới trên hạ tầng BK-IoT.',2,NULL,'2013-09-05','2016-12-14',2,1,NULL,NULL,NULL,NULL,2013,0),(18,'KH16','Xây dựng mô hình ngôn ngữ cho tiếng việt sử dụng học sâu trên dữ liệu lớn',2,NULL,'2013-09-05','2016-12-14',2,1,NULL,NULL,NULL,NULL,2014,0),(19,'KH17','Hệ thống quản lý phân công giảng dạy và kê khai khối lượng Viện CNTT&TT',2,NULL,'2013-09-05','2016-12-14',2,1,1,NULL,NULL,NULL,2016,0),(20,'KH18','Nghiên cứu phương pháp biểu diễn hiệu quả nội dung ảnh số cho bài toán gán đa nhãn',2,NULL,'2013-09-05','2016-12-14',2,1,NULL,NULL,NULL,NULL,2014,0),(21,'KH21','Inferring the latent structures in big heterogeneous data',2,NULL,'2016-12-13','2016-12-29',3,2,NULL,NULL,NULL,NULL,2016,0),(22,'KH22','Xây dựng bộ định tuyến mềm hỗ trợ cục bộ hoá lưu lượng các ứng dụng P2P',2,NULL,'2016-12-16','2016-12-31',4,1,NULL,NULL,NULL,NULL,2015,0),(23,'KH23','Nghiên cứu, thiết kế, xây dựng hệ Báo gọi điều dưỡng viên sử dụng công nghệ đối thoại không dây (BK.NurseCall’16)\n',2,NULL,'2016-12-16','2016-12-31',2,1,NULL,NULL,NULL,NULL,2015,0),(24,'KH24','Trí tuệ tính toán, Các hệ thống thích nghi, tiến hoá và dựa trên tri thức',2,NULL,'2016-12-24','2016-12-31',2,2,NULL,NULL,NULL,NULL,2013,0),(25,'KH25',' Nghiên cứu công nghệ điện toán đám mây/Mapreduce (Cloud Computing/ Mapreduce) và ứng dụng trong khai phá thông tin sinh viên tốt nghiệp và cựu sinh viên cho các trường đại học',2,NULL,'2016-12-02','2017-02-04',5,3,NULL,NULL,NULL,NULL,2016,0),(26,'KH26',' Phân tích tự động lỗ hổng bảo mật Web và hỗ trợ  ngăn chặn tấn công ',2,NULL,'2016-12-02','2017-02-04',1,1,NULL,NULL,NULL,NULL,2016,0);

/*Table structure for table `dong_tac_gia` */

DROP TABLE IF EXISTS `dong_tac_gia`;

CREATE TABLE `dong_tac_gia` (
  `ten` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `tac_gia_id` bigint(20) NOT NULL,
  KEY `tac_gia_id` (`tac_gia_id`),
  CONSTRAINT `dong_tac_gia_ibfk_1` FOREIGN KEY (`tac_gia_id`) REFERENCES `nguoi_dung` (`id_nguoi_dung`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `dong_tac_gia` */

insert  into `dong_tac_gia`(`ten`,`tac_gia_id`) values ('Nguyễn Xuân Trọng',2),('Nguyễn Văn Nam',2),('Nguyễn Tuấn Đại',5),('Nguyễn Trung Kiên',5);

/*Table structure for table `huong_nghien_cuu` */

DROP TABLE IF EXISTS `huong_nghien_cuu`;

CREATE TABLE `huong_nghien_cuu` (
  `id` int(11) NOT NULL,
  `ten` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `huong_nghien_cuu` */

insert  into `huong_nghien_cuu`(`id`,`ten`) values (1,'Cơ bản'),(2,'Ứng dụng'),(3,'Sản xuất');

/*Table structure for table `loai_de_tai` */

DROP TABLE IF EXISTS `loai_de_tai`;

CREATE TABLE `loai_de_tai` (
  `id` int(11) NOT NULL,
  `ten` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `loai_de_tai` */

insert  into `loai_de_tai`(`id`,`ten`) values (1,'Cấp bộ'),(2,'Cấp trường'),(3,'Cấp nhà nước'),(4,'Trọng điểm'),(5,'Chương trình quốc gia');

/*Table structure for table `nguoi_dung` */

DROP TABLE IF EXISTS `nguoi_dung`;

CREATE TABLE `nguoi_dung` (
  `id_nguoi_dung` bigint(20) NOT NULL AUTO_INCREMENT,
  `ma_tac_gia` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `mat_khau` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `token` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `ten_tac_gia` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `nghe_nghiep` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sdt` char(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `role` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `active` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id_nguoi_dung`),
  UNIQUE KEY `ma_tac_gia` (`ma_tac_gia`),
  KEY `ten_tac_gia` (`ten_tac_gia`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `nguoi_dung` */

insert  into `nguoi_dung`(`id_nguoi_dung`,`ma_tac_gia`,`mat_khau`,`token`,`ten_tac_gia`,`nghe_nghiep`,`sdt`,`email`,`role`,`active`) values (2,'NCKH1','8dc91c1ca83beb2c4264ecd7fa4ab788','krc1h98p35avjhobmnjhqerh5d790xpq','Nguyễn Hữu Đạt','Sinh Viên','01627 646 153','huudatbk58@gmail.com','USER',1),(3,'NCKH2','338f131ca033ad95eee5827292bdd223','zf6v73hkkwf8jc0kphcjc0egclamux78','Nguyễn Văn Hưng','Giảng viên','094483889','vanhung@gmail.com','USER',1),(4,'NCKH3','33f7e28fb360cf466190487ac769ea26','vlyfo9ad1wghaymr19jybdhi0fugo88l','Lê Văn Thắng','Trợ giảng','0165889374','vanthang@gmail.com','USER',1),(5,'NCKH4','ad91e8e690406ef876b5130f7c2f0079','kr5pl7mv4q0frer3j5hxdsd49twqyn3l','Nguyễn Đức Nam','Sinh viên','0167647389','ducnam@gmail.com','USER',1);

/*Table structure for table `trang_thai_de_tai` */

DROP TABLE IF EXISTS `trang_thai_de_tai`;

CREATE TABLE `trang_thai_de_tai` (
  `id` int(11) NOT NULL,
  `ten` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `trang_thai_de_tai` */

insert  into `trang_thai_de_tai`(`id`,`ten`) values (1,'Chưa thực hiện'),(2,'Đang thực hiện'),(3,'Hoàn thành'),(4,'Đã hủy'),(5,'Hết hạn');

/*Table structure for table `yeu_cau_duyet_de_tai` */

DROP TABLE IF EXISTS `yeu_cau_duyet_de_tai`;

CREATE TABLE `yeu_cau_duyet_de_tai` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nguoi_dung_id` bigint(11) NOT NULL,
  `thoi_gian_tao` date NOT NULL,
  `de_tai_id` bigint(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `nguoi_dung_id` (`nguoi_dung_id`),
  KEY `de_tai_id` (`de_tai_id`),
  CONSTRAINT `yeu_cau_duyet_de_tai_ibfk_1` FOREIGN KEY (`nguoi_dung_id`) REFERENCES `nguoi_dung` (`id_nguoi_dung`),
  CONSTRAINT `yeu_cau_duyet_de_tai_ibfk_2` FOREIGN KEY (`de_tai_id`) REFERENCES `de_tai` (`id_de_tai`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `yeu_cau_duyet_de_tai` */

insert  into `yeu_cau_duyet_de_tai`(`id`,`nguoi_dung_id`,`thoi_gian_tao`,`de_tai_id`) values (2,3,'2016-12-21',4),(3,4,'2016-12-28',10),(4,4,'2016-12-27',11),(5,5,'2016-12-21',13),(6,5,'2016-12-06',10),(7,2,'2016-12-14',18),(8,2,'2016-12-28',17),(9,2,'2017-01-07',19),(10,5,'2017-01-08',14),(11,5,'2017-01-06',15),(12,2,'2016-12-20',23),(13,2,'2016-12-20',24),(14,2,'2016-12-20',25),(15,2,'2016-12-20',26);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
