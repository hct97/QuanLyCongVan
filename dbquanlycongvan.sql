-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th9 08, 2018 lúc 07:03 AM
-- Phiên bản máy phục vụ: 10.1.34-MariaDB
-- Phiên bản PHP: 7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `dbquanlycongvan`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblcongvan`
--

CREATE TABLE `tblcongvan` (
  `id_congvan` int(10) NOT NULL,
  `loai_congvan` int(10) NOT NULL,
  `nguoinhan` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `id_coquan` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ngay_nhap` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ngay_thuchien` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `noidung` text COLLATE utf8_unicode_ci NOT NULL,
  `ten_congvan` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tblcongvan`
--

INSERT INTO `tblcongvan` (`id_congvan`, `loai_congvan`, `nguoinhan`, `id_coquan`, `ngay_nhap`, `ngay_thuchien`, `noidung`, `ten_congvan`) VALUES
(1, 1, 'Người nhận 1', 'cq1', '2018-09-07 05:42:43', '2018-09-29 17:00:00', 'Nội dung gì đó', 'Công văn 1'),
(2, 2, 'Người nhận 2', 'cq2', '2018-09-07 05:42:43', '2018-09-05 17:00:00', 'Nội dung 2', 'Công văn 2'),
(3, 2, 'test', 'C? quan 2', '2018-09-08 04:57:58', '2018-09-05 17:00:00', 'test', 'Cong van 3.'),
(5, 2, 'test', 'cq3', '2018-09-08 05:02:02', '2018-09-05 17:00:00', 'testtest', 'Cong van 3 test');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblcoquan`
--

CREATE TABLE `tblcoquan` (
  `id_coquan` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ten_coquan` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tblcoquan`
--

INSERT INTO `tblcoquan` (`id_coquan`, `ten_coquan`) VALUES
('cq1', 'Cơ quan 1'),
('cq2', 'Cơ quan 2'),
('cq3', 'Cơ quan 3');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblloaicongvan`
--

CREATE TABLE `tblloaicongvan` (
  `id_loaicongvan` int(10) NOT NULL,
  `ten_loaicongvan` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tblloaicongvan`
--

INSERT INTO `tblloaicongvan` (`id_loaicongvan`, `ten_loaicongvan`) VALUES
(1, 'Loại công văn 1'),
(2, 'Loại công văn 2');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblnguoidung`
--

CREATE TABLE `tblnguoidung` (
  `id_user` int(11) NOT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `hoten` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tblnguoidung`
--

INSERT INTO `tblnguoidung` (`id_user`, `username`, `password`, `hoten`) VALUES
(1, 'trunghc', '123456', 'Trung'),
(2, 'hct', 'huynhchitrung123', 'HCT');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `tblcongvan`
--
ALTER TABLE `tblcongvan`
  ADD PRIMARY KEY (`id_congvan`);

--
-- Chỉ mục cho bảng `tblcoquan`
--
ALTER TABLE `tblcoquan`
  ADD PRIMARY KEY (`id_coquan`);

--
-- Chỉ mục cho bảng `tblloaicongvan`
--
ALTER TABLE `tblloaicongvan`
  ADD PRIMARY KEY (`id_loaicongvan`);

--
-- Chỉ mục cho bảng `tblnguoidung`
--
ALTER TABLE `tblnguoidung`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `tblcongvan`
--
ALTER TABLE `tblcongvan`
  MODIFY `id_congvan` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `tblloaicongvan`
--
ALTER TABLE `tblloaicongvan`
  MODIFY `id_loaicongvan` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `tblnguoidung`
--
ALTER TABLE `tblnguoidung`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
