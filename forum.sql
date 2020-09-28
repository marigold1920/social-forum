-- MySQL dump 10.13  Distrib 8.0.21, for Linux (x86_64)
--
-- Host: localhost    Database: forum
-- ------------------------------------------------------
-- Server version	8.0.21-0ubuntu0.20.04.4

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `email` varchar(50) NOT NULL,
  `password` varchar(256) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `status` varchar(10) DEFAULT 'New',
  `role_id` varchar(20) NOT NULL,
  PRIMARY KEY (`email`),
  KEY `fk_account_role_idx` (`role_id`),
  CONSTRAINT `fk_account_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('abc@gmail.com','73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=','Victor','New','MEMBER'),('hoangloi669@gmail.com','jZae727K08KaOmKSgOaGzww/XVqGr/PKEgIMkjrcbJI=','Victor','New','MEMBER'),('marigold1920@gmail.com','73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=','Victor Nguyễn','New','MEMBER'),('michael@gmail.com','73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=','Victor Nguyễn','New','MEMBER'),('victorng.dev@gmail.com','73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=','Victor','New','MEMBER');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article` (
  `article_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `description` text,
  `content` text,
  `image` varchar(100) DEFAULT NULL,
  `published_date` date NOT NULL,
  `status` varchar(20) NOT NULL DEFAULT 'ACTIVE',
  `owner` varchar(50) NOT NULL,
  PRIMARY KEY (`article_id`),
  KEY `fk_article_status_idx` (`status`),
  CONSTRAINT `fk_article_status` FOREIGN KEY (`status`) REFERENCES `article_status` (`status_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (1,'Đào tạo (Training) – Đâu là thời điểm bạn cần trải nghiệm?','Để thành công, bạn cần quan tâm đến việc tự thúc đẩy, phát triển những kỹ năng.','Để thành công, bạn cần quan tâm đến việc tự thúc đẩy, phát triển những kỹ năng. Trong  quá trình đó, Training, Coaching, Mentoring là ba điều các bạn cần quan tâm nhất. Cả 3 đều được phát sinh từ nhu cầu muốn trải nghiệm của mỗi cá nhân. Với bài viết hôm nay, TopDev phân tích về thời điểm lý tưởng nhất để bạn bắt đầu training cũng như những tip để quá trình training đạt hiệu quả nhất.<p/>Nhu cầu training sẽ được đáp ứng khi bản thân bạn mong muốn mình được học hỏi, phát triển thêm. Bạn cần được đào tạo hiểu chuyên sâu một vấn đề nào đó. Hoặc đơn giản, bạn cần update lại các kiến thức một cách bài bản hơn. Từ đó, bạn có những nền tảng vững chắc. Điều này giúp bạn đảm bảo các vấn đề được thu nhận và truyền tải một cách khoa học.<p/>Giá trị thật sự của việc đào tạo không đơn thuần chỉ dừng lại ở việc truyển tải – tiếp thu; dẫn dắt, định hướng – thực hành; mà điều quan trọng, bạn phải cảm nhận được sự thay đổi. Đó là những hiệu quả thực tế từ việc vận dụng các bài học vào công việc, lĩnh vực mà bạn theo đuổi. Điều đó không phải ai cũng có thể làm được. Và đó được xem là một thách thức lớn đấy!','TrainingDaotao.png','2020-01-15','ACTIVE','1'),(2,'13 IDE trên trình duyệt tốt nhất mọi lập trình viên nên biết','Bạn đang phát triển các ứng dụng web thì môi trường bạn sử dụng phải\n                                thuận tiện và dễ sử dụng.','Nhiều IDE dựa trên trình duyệt phù hợp để lập trình trên đám mây. Hầu hết các công cụ trong số này có những hạn chế khi so sánh với những đối thủ ngoại tuyến, nhưng chúng đang dần cải thiện theo thời gian. Bất kể bạn định làm gì, đều có một IDE phù hợp cho hầu hết mọi mục đích sử dụng.<p/>Khi Amazon mua IDE Cloud9 vào năm 2016, nó đã được các nhà phát triển yêu thích. Việc tích hợp đầy đủ với Amazon Web Services khiến nó được cho là nền tảng phát triển trực tuyến mạnh mẽ và có thể mở rộng nhất hiện có. IDE trực tuyến kết hợp trình soạn thảo code với terminal và các công cụ gỡ lỗi mạnh mẽ.<p/>Cloud9 cũng có chế độ lập trình theo cặp tương tự như VS Live Share cho phép lập trình cộng tác từ xa theo nhóm. Nếu cần tạo mẫu nhanh, Cloud9 cung cấp cho bạn quyền truy cập trực tiếp vào những AWS service thông qua hỗ trợ terminal tích hợp.<p/>Tất cả các ngôn ngữ chính đều được hỗ trợ, cùng với linting (kiểm tra lỗi mã nguồn) và transpiling (chuyển mã nguồn từ ngôn ngữ này sang một ngôn ngữ khác, với điều kiện 2 ngôn ngữ có cùng cấp độ trừu tượng hóa) cho Typescript, v.v… Bản thân trình soạn thảo này là một môi trường phát triển ảo hoàn chỉnh với các cửa sổ terminal và đầu ra. CodeTasty là công cụ miễn phí và đầy đủ chức năng. Bên cạnh đó, các tùy chọn trả phí cũng có sẵn cho nhiều tùy chọn dự án và hợp tác nhóm.','andr-218x150.jpg','2020-05-02','ACTIVE','1'),(3,'Sharepoint là gì? Học SharePoint và cơ hội việc làm IT tốt hơn','Trong thập kỷ qua, SharePoint đã phát triển thành một nguồn lực vô cùng hùng hậu','Trong thập kỷ qua, SharePoint đã phát triển thành một nguồn lực vô cùng hùng hậu —hơn  250,000 organizations và gần 85% các công ty trong danh sách Forbes Fortune 500 đều đang sử dụng nó. Sự phát triển hùng hậu và ứng dụng của SharePoint trên toàn thế giới hiện đã xuất hiện nhiều hơn tại thị trường Việt Nam. Nhiều công ty và lập trình viên không khỏi tìm hiểu SharePoint là gì và tìm hiểu sâu hơn về lợi ích và cách học cho người mới bắt đầu SharePoint.<p/>SharePoint là một nền tảng cộng tác làm việc trên web (web-based) tích hợp đồng bộ với Microsoft Office. Ra mắt vào năm 2001, SharePoint chủ yếu được ra mắt dưới dạng hệ thống quản lý và lưu trữ tài liệu, tuy nhiên sản phẩm cũng có cấu hình cao và việc sử dụng có thể khác nhau đáng kể tuỳ vào mô hình tổ chức.<p/>Nói một cách dễ hiểu, SharePoint là một hệ thống website phối hợp nội dung và công việc trên trang web sử dụng các workflow application, danh sách cơ sở dữ liệu và các thành phần website và tính năng bảo mật khác để trao quyền cho các team làm việc cùng nhau. SharePoint cũng cung cấp cho doanh nghiệp một nền tảng để kiểm soát quyền truy cập vào thông tin và tự động hóa quy trình làm việc giữa các đơn vị kinh doanh.<p/>Không thiếu tài liệu ngon để khởi động đâu, tuy nhiên bước đầu tiên bạn phải làm đó là trực tiếp làm thử trên SharePoint. Sau khi chọn được source tài nguyên phù hợp, hãy thử cài đặt và sử dụng SharePoint luôn để hiểu hơn cấu trúc, cơ chế hoạt động và phối hợp trên platform. ','sharepoint-la-gi-218x150.png','2020-09-15','ACTIVE','2'),(4,'Khám phá Quy trình tuyển dụng Data Engineer','Đọc bài viết của TopDev từ kinh nghiệm của anh Calvin Cảnh Trần –\n                                Senior Data Engineer tại Grab.','Kỹ sư dữ liệu (Data Engineer) là người phát triển, xây dựng, kiểm tra và duy trì kiến trúc. Đồng thời, họ cũng là người đề xuất và đôi khi đảm nhậm việc cải thiện chất lượng dữ liệu. Để hoàn thiện và phát triển nguồn dữ liệu, nhóm những Data Engineer cần cải biến các quy trình thiết lập dữ liệu để mô hình hóa, khai thác và sản xuất dữ liệu.<p/>Bài viết là những trải nghiệm thực tế của quy trính tuyển dụng vị trí Data Engineer tại thị trường quốc tế. Tại Việt Nam, việc tuyển vị trí này vẫn chưa trở thành xu hướng. Tuy nhiên, mô hình tuyển dụng vẫn đảm bảo những vòng thi cơ bản. Vì thế, bài viết này sẽ khá hữu ích cho bạn dù bạn apply vị trí tại Việt Nam hay thị trường nước ngoài.<p/>Quy trình phỏng vấn tuyển dụng Data Engineer có thể thay đổi tùy vào các vị trí tuyển dụng. Nếu vị trí là fresher, kiến thức nền tảng và khả năng học hỏi sẽ được chú trọng nhiều hơn. Nếu vị trí cần tuyển là junior hoặc mid-level, tính trải nghiệm thực tế lại là yếu tố được nhà tuyển dụng ưu tiên khai thác. Do vậy, yêu cầu tuyển dụng sẽ khắc khe hơn.','DataEngineer-218x150.png','2020-08-20','ACTIVE','1');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article_status`
--

DROP TABLE IF EXISTS `article_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article_status` (
  `status_id` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_status`
--

LOCK TABLES `article_status` WRITE;
/*!40000 ALTER TABLE `article_status` DISABLE KEYS */;
INSERT INTO `article_status` VALUES ('ACTIVE','Active'),('DELETED','Deleted');
/*!40000 ALTER TABLE `article_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `comment_id` int NOT NULL AUTO_INCREMENT,
  `account_id` varchar(50) NOT NULL,
  `article_id` int NOT NULL,
  `comment` text,
  `date_posted` date DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `fk_article_interaction_idx` (`article_id`),
  KEY `fk_account_interaction_idx` (`account_id`),
  CONSTRAINT `fk_account_interaction` FOREIGN KEY (`account_id`) REFERENCES `account` (`email`) ON DELETE CASCADE,
  CONSTRAINT `fk_article_interaction` FOREIGN KEY (`article_id`) REFERENCES `article` (`article_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (3,'abc@gmail.com',1,'Good','2020-05-01'),(5,'michael@gmail.com',1,'Bad','2020-05-25'),(8,'victorng.dev@gmail.com',4,'Quy trình này khá phức tạp, level Dev hơi khó xơi','2020-07-03'),(13,'victorng.dev@gmail.com',2,'Thêm nhiều phần nữa đi','2020-10-01'),(14,'victorng.dev@gmail.com',3,'Hơi ngắn nhưng khá nhiều thứ được cover, các bạn dev ít kinh nghiệm nên đọc','2020-08-20'),(17,'victorng.dev@gmail.com',4,'Nếu cuộc sống lập trình mà đơn giản vậy thì hay nhỉ','2020-09-28');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emotion`
--

DROP TABLE IF EXISTS `emotion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emotion` (
  `emotion_id` int NOT NULL AUTO_INCREMENT,
  `is_like` tinyint DEFAULT NULL,
  `is_dislike` tinyint DEFAULT NULL,
  `account_id` varchar(50) NOT NULL,
  `article_id` int NOT NULL,
  PRIMARY KEY (`emotion_id`),
  KEY `fk_emotion_account_idx` (`account_id`),
  KEY `fk_emotion_article_idx` (`article_id`),
  CONSTRAINT `fk_emotion_account` FOREIGN KEY (`account_id`) REFERENCES `account` (`email`) ON DELETE CASCADE,
  CONSTRAINT `fk_emotion_article` FOREIGN KEY (`article_id`) REFERENCES `article` (`article_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emotion`
--

LOCK TABLES `emotion` WRITE;
/*!40000 ALTER TABLE `emotion` DISABLE KEYS */;
INSERT INTO `emotion` VALUES (1,1,0,'victorng.dev@gmail.com',1),(2,1,0,'victorng.dev@gmail.com',2),(3,1,0,'hoangloi669@gmail.com',1),(4,1,1,'michael@gmail.com',1),(5,1,0,'victorng.dev@gmail.com',3),(6,1,0,'victorng.dev@gmail.com',4);
/*!40000 ALTER TABLE `emotion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `is_default` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES ('ADMIN','ADMIN',0),('MEMBER','MEMBER',1);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-28 23:00:56
