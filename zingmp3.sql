-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th3 10, 2023 lúc 07:51 AM
-- Phiên bản máy phục vụ: 10.4.27-MariaDB
-- Phiên bản PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `zingmp3`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `authority`
--

CREATE TABLE `authority` (
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `authority`
--

INSERT INTO `authority` (`name`) VALUES
('ROLE_ADMIN'),
('ROLE_USER');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(2, 'Tình Yêu'),
(6, 'EDM'),
(8, 'Rap'),
(9, 'Pop');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `country`
--

CREATE TABLE `country` (
  `id` bigint(20) NOT NULL,
  `image_background` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `country`
--

INSERT INTO `country` (`id`, `image_background`, `name`) VALUES
(1, NULL, 'Việt Nam'),
(2, NULL, 'Hàn Quốc'),
(3, NULL, 'Trung Quốc');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `favorites`
--

CREATE TABLE `favorites` (
  `id` bigint(20) NOT NULL,
  `music_and_mv_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `favorites`
--

INSERT INTO `favorites` (`id`, `music_and_mv_id`, `user_id`) VALUES
(52, 28, 10),
(58, 30, 10),
(53, 31, 10),
(57, 33, 10),
(59, 35, 10),
(60, 36, 10),
(56, 28, 11),
(55, 30, 11),
(54, 32, 11);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `music_mv`
--

CREATE TABLE `music_mv` (
  `id` bigint(20) NOT NULL,
  `block` int(11) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `image_banner` varchar(255) DEFAULT NULL,
  `link_music` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `num_views` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `country_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `music_mv`
--

INSERT INTO `music_mv` (`id`, `block`, `created_date`, `image_banner`, `link_music`, `name`, `num_views`, `type`, `category_id`, `country_id`) VALUES
(28, 0, '2023-03-08', 'http://res.cloudinary.com/duqqesvgq/image/upload/v1678235966/zzha7rpfblmisqfrlwkg.jpg', 'http://res.cloudinary.com/duqqesvgq/video/upload/v1678235985/mofevgpltjvk7tor0dvq.mp3', 'MỘT BƯỚC YÊU VẠN DẶM ĐAU', 0, 1, 2, 1),
(29, 0, '2023-03-08', 'http://res.cloudinary.com/duqqesvgq/image/upload/v1678236003/e3d8zlyzt4jsazzhofom.jpg', 'http://res.cloudinary.com/duqqesvgq/video/upload/v1678236105/brkohbtd3sp6iwjnnp39.mp4', 'MỘT BƯỚC YÊU VẠN DẶM ĐAU', 0, 0, 2, 1),
(30, 0, '2023-03-08', 'http://res.cloudinary.com/duqqesvgq/image/upload/v1678236141/khy30dzqz7f1ct5uzp0h.jpg', 'http://res.cloudinary.com/duqqesvgq/video/upload/v1678236159/ckre1ar6mlgty7dpwfqq.mp3', 'LẠC TRÔI', 0, 1, 9, 1),
(31, 0, '2023-03-08', 'http://res.cloudinary.com/duqqesvgq/image/upload/v1678236246/s6lajscj41zcuamvy7zz.jpg', 'http://res.cloudinary.com/duqqesvgq/video/upload/v1678236337/pshynh05fhm59ufptewe.mp4', 'LẠC TRÔI', 0, 0, 9, 1),
(32, 0, '2023-03-08', 'http://res.cloudinary.com/duqqesvgq/image/upload/v1678236357/dirgdpwbdkwpy6kus1kr.jpg', 'http://res.cloudinary.com/duqqesvgq/video/upload/v1678236375/wg33p3n5ivlslrwyjw2v.mp3', 'Tháng Tư Là Lời Nói Dối Của Em', 0, 1, 2, 1),
(33, 0, '2023-03-08', 'http://res.cloudinary.com/duqqesvgq/image/upload/v1678236707/phkqyx7zncrx28nz9rv8.jpg', 'http://res.cloudinary.com/duqqesvgq/video/upload/v1678236719/tj7fu46ci3uxwxiatkcb.mp3', 'PHÍA SAU MỘT CÔ GÁI', 0, 1, 2, 1),
(34, 0, '2023-03-08', 'http://res.cloudinary.com/duqqesvgq/image/upload/v1678237023/i9ccmpkuyb04pingcuyf.jpg', 'http://res.cloudinary.com/duqqesvgq/video/upload/v1678237052/w3lzuyrkao0qjkncnaxq.mp3', 'Anh Đếch Cần Gì Nhiều Ngoài Em', 0, 1, 8, 1),
(35, 0, '2023-03-08', 'http://res.cloudinary.com/duqqesvgq/image/upload/v1678237104/xzs1vgs9wgyxbm9vzved.jpg', 'http://res.cloudinary.com/duqqesvgq/video/upload/v1678237128/yr5fuau7fefntilll35l.mp3', 'Faded', 0, 1, 6, 3),
(36, 0, '2023-03-08', 'http://res.cloudinary.com/duqqesvgq/image/upload/v1678241163/kktiucqp8btmnrhzzsu4.jpg', 'http://res.cloudinary.com/duqqesvgq/video/upload/v1678241182/idqqmxq0q3o6edtn9ece.mp3', 'Rap God', 0, 1, 8, 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `music_singer`
--

CREATE TABLE `music_singer` (
  `id` bigint(20) NOT NULL,
  `music_and_mv_id` bigint(20) DEFAULT NULL,
  `singer_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `music_singer`
--

INSERT INTO `music_singer` (`id`, `music_and_mv_id`, `singer_id`) VALUES
(46, 28, 1),
(47, 29, 1),
(48, 30, 4),
(49, 31, 4),
(50, 32, 5),
(51, 33, 7),
(52, 34, 9),
(53, 35, 10);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `singer`
--

CREATE TABLE `singer` (
  `id` bigint(20) NOT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `birth_year` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `singer`
--

INSERT INTO `singer` (`id`, `avatar`, `birth_year`, `name`) VALUES
(1, 'http://res.cloudinary.com/dolpjquqw/image/upload/v1677325080/yjjqcm5c9dappi6aagvx.jpg', 1989, 'Mr Siro'),
(4, 'http://res.cloudinary.com/dolpjquqw/image/upload/v1678005678/agbemcew98j1k4t0tbjm.jpg', 1989, 'Sơn tùng'),
(5, 'http://res.cloudinary.com/dolpjquqw/image/upload/v1678005860/rjx4uovejqqdzsqu1bmy.jpg', 1900, 'Hà Anh Tuấn'),
(7, 'http://res.cloudinary.com/dolpjquqw/image/upload/v1678006317/q3lbqtyoukxpmlcdwyvt.jpg', 1920, 'Soobin Hoàng Sơn'),
(9, 'http://res.cloudinary.com/dtuv1ftmh/image/upload/v1678088481/tknvvozhnorcmnak3img.jpg', 1989, 'Đen Vâu'),
(10, 'http://res.cloudinary.com/dtuv1ftmh/image/upload/v1678088647/qlfptflo6ygmathszqqx.jpg', 1997, 'Alan Walker');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `activation_key` varchar(255) DEFAULT NULL,
  `actived` int(11) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `remember_key` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `activation_key`, `actived`, `avatar`, `created_date`, `email`, `password`, `remember_key`, `username`, `fullname`) VALUES
(1, NULL, 1, NULL, NULL, NULL, '$2a$10$VxMMKz0dN8bLAKtMpS2Qx.mrhML22dqO0v.zW82rgvnbkaQrn1Mqq', NULL, 'admin', NULL),
(10, NULL, 1, 'http://res.cloudinary.com/dtuv1ftmh/image/upload/v1678072798/z5rfa0om8yvvluj7zknn.png', '2023-03-06 10:19:59', 'giahoa01giathieu@gmail.com', '$2a$10$ob1uItnoyHww/xsNaI0CW.sVyoF8LKlhyOUlf7xXmgHTN28W6VdqW', NULL, 'hoa', 'hoa'),
(11, NULL, 0, 'http://res.cloudinary.com/dtuv1ftmh/image/upload/v1678194426/cyc9rfv5qk2vn8iozykr.png', '2023-03-07 20:07:07', '123@gmail.com', '$2a$10$yeonBCkbaF/r5R9NttVZked0V3GiYbmRJUvqWLyEDvO6tuwTeMewm', NULL, 'thanh', 'tan thanh');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user_authority`
--

CREATE TABLE `user_authority` (
  `user_id` bigint(20) NOT NULL,
  `authority_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `user_authority`
--

INSERT INTO `user_authority` (`user_id`, `authority_name`) VALUES
(1, 'ROLE_ADMIN'),
(10, 'ROLE_USER'),
(11, 'ROLE_USER');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `authority`
--
ALTER TABLE `authority`
  ADD PRIMARY KEY (`name`);

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `country`
--
ALTER TABLE `country`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `favorites`
--
ALTER TABLE `favorites`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `duplli` (`user_id`,`music_and_mv_id`),
  ADD KEY `FK5opxks3m24fo5ko73hx3wtuc0` (`music_and_mv_id`);

--
-- Chỉ mục cho bảng `music_mv`
--
ALTER TABLE `music_mv`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKfyjblnk53386nj13rjpd6ccr2` (`category_id`),
  ADD KEY `FKdcbmpe4od1jr1oou7e22s115i` (`country_id`);

--
-- Chỉ mục cho bảng `music_singer`
--
ALTER TABLE `music_singer`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKl7boqd8v6h7vm3asq87ysdk0o` (`music_and_mv_id`),
  ADD KEY `FKcaydooxw5y7xmcdxq2w3fb6cg` (`singer_id`);

--
-- Chỉ mục cho bảng `singer`
--
ALTER TABLE `singer`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `user_authority`
--
ALTER TABLE `user_authority`
  ADD PRIMARY KEY (`user_id`,`authority_name`),
  ADD KEY `FK6ktglpl5mjosa283rvken2py5` (`authority_name`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `country`
--
ALTER TABLE `country`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `favorites`
--
ALTER TABLE `favorites`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

--
-- AUTO_INCREMENT cho bảng `music_mv`
--
ALTER TABLE `music_mv`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT cho bảng `music_singer`
--
ALTER TABLE `music_singer`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT cho bảng `singer`
--
ALTER TABLE `singer`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `favorites`
--
ALTER TABLE `favorites`
  ADD CONSTRAINT `FK1uphh0glinnprjknyl68k1hw1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK5opxks3m24fo5ko73hx3wtuc0` FOREIGN KEY (`music_and_mv_id`) REFERENCES `music_mv` (`id`);

--
-- Các ràng buộc cho bảng `music_mv`
--
ALTER TABLE `music_mv`
  ADD CONSTRAINT `FKdcbmpe4od1jr1oou7e22s115i` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`),
  ADD CONSTRAINT `FKfyjblnk53386nj13rjpd6ccr2` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

--
-- Các ràng buộc cho bảng `music_singer`
--
ALTER TABLE `music_singer`
  ADD CONSTRAINT `FKcaydooxw5y7xmcdxq2w3fb6cg` FOREIGN KEY (`singer_id`) REFERENCES `singer` (`id`),
  ADD CONSTRAINT `FKl7boqd8v6h7vm3asq87ysdk0o` FOREIGN KEY (`music_and_mv_id`) REFERENCES `music_mv` (`id`);

--
-- Các ràng buộc cho bảng `user_authority`
--
ALTER TABLE `user_authority`
  ADD CONSTRAINT `FK6ktglpl5mjosa283rvken2py5` FOREIGN KEY (`authority_name`) REFERENCES `authority` (`name`),
  ADD CONSTRAINT `FKpqlsjpkybgos9w2svcri7j8xy` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
