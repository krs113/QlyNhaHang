-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 10, 2021 at 09:21 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 7.3.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `manager`
--

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `id` int(11) NOT NULL,
  `hoTen` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gioiTinh` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sdt` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ngaySinh` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ma` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `matKhau` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`id`, `hoTen`, `gioiTinh`, `sdt`, `ngaySinh`, `ma`, `matKhau`) VALUES
(8, 'Nghiêm Thị Hoa', 'Nữ', '0971438391', '2000-02-25', 'QL002', 'Matkhaumoi'),
(13, 'Châu Nam Thành', 'Nam', '0989678456', '2000-10-28', 'QL003', 'Matkhaumoi'),
(18, 'Vũ Tắc Thiên', 'Nam', '0903456789', '1999-10-28', 'QL004', '1Nam'),
(24, 'Vũ Hoàng Long', 'Nam', '0348789473', '2000-11-01', 'QL001', 'alo123'),
(25, 'Hoàng Thị Mai', 'Nữ', '0986537288', '1998-11-04', 'NV001', 'mai1'),
(27, 'Ngô Văn Tý', 'Nam', '0989776584', '1990-11-04', 'NV003', 'ty113'),
(28, 'Nguyễn Phương Anh', 'Nữ', '0987353871', '2000-02-23', 'NV027', 'phanh123'),
(32, 'Cao Hoàng Mai', 'Nữ', '0989456320', '2001-11-06', 'NV012', 'mk113'),
(34, 'Vũ Văn Hùng', 'Nam', '0384155204', '2000-06-06', 'NV021', 'mk123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
