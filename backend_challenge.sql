-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 07 Oca 2024, 01:29:18
-- Sunucu sürümü: 10.4.27-MariaDB
-- PHP Sürümü: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `backend_challenge`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `company`
--

CREATE TABLE `company` (
  `cid` bigint(20) NOT NULL,
  `name` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `company`
--

INSERT INTO `company` (`cid`, `name`) VALUES
(1, 'A Company'),
(2, 'B Company'),
(4, 'C Company');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `employee`
--

CREATE TABLE `employee` (
  `eid` bigint(20) NOT NULL,
  `age` int(11) NOT NULL,
  `email` varchar(150) NOT NULL,
  `name` varchar(150) NOT NULL,
  `password` varchar(150) NOT NULL,
  `surname` varchar(150) NOT NULL,
  `company_cid` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `employee`
--

INSERT INTO `employee` (`eid`, `age`, `email`, `name`, `password`, `surname`, `company_cid`) VALUES
(1, 29, 'onder@mail.com', 'Önder', '12345', 'Şener', 1),
(2, 24, 'ali@mail.com', 'Ali', '12345', 'Bilmem', 1),
(6, 44, 'ayse@mail.com', 'Ayşeee', '12345', 'Bilmem', 1),
(7, 32, 'zehra@mail.com', 'Zehra', '12345', 'Bilmem', 2);

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`cid`),
  ADD UNIQUE KEY `UK_niu8sfil2gxywcru9ah3r4ec5` (`name`);

--
-- Tablo için indeksler `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`eid`),
  ADD UNIQUE KEY `UK_fopic1oh5oln2khj8eat6ino0` (`email`),
  ADD KEY `FKch6v6brxqmv53vd7k18fd0lg9` (`company_cid`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `company`
--
ALTER TABLE `company`
  MODIFY `cid` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Tablo için AUTO_INCREMENT değeri `employee`
--
ALTER TABLE `employee`
  MODIFY `eid` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Dökümü yapılmış tablolar için kısıtlamalar
--

--
-- Tablo kısıtlamaları `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `FKch6v6brxqmv53vd7k18fd0lg9` FOREIGN KEY (`company_cid`) REFERENCES `company` (`cid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
