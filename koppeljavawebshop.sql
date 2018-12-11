-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 10, 2018 at 11:14 PM
-- Server version: 10.1.35-MariaDB
-- PHP Version: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `koppeljavawebshop`
--

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `ID` bigint(20) NOT NULL,
  `ACTIVE` tinyint(1) DEFAULT '0',
  `COUNT` int(11) DEFAULT NULL,
  `DESCRIPTION` text,
  `IMAGE` varchar(255) DEFAULT NULL,
  `NAMEPRODUCT` text,
  `PRICE` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`ID`, `ACTIVE`, `COUNT`, `DESCRIPTION`, `IMAGE`, `NAMEPRODUCT`, `PRICE`) VALUES
(1, 1, 9999, 'Producer: Corsair; Product class: Computer; Computer case type: Mini Tower; Products\' Family Name: CORSAIR ONE PRO; Installed processors qty: 1 Pcs; Maximal number of processors: 1 Pcs; Installed processor type: Intel Core i7; Processor code: i7-7700K; Installed processor\'s clock speed: 4.2 GHz, 4.5 GHz; QPI/DMI bus frequency: 8 GT/s; Cache memory capacity [L3]: 8 MB; Intel vPro technology: No; Number of installed hard disks: 2 Pcs; Installed disk capacity: 2 TB, 480 GB; Installed hard disk type: SATA, SSD M.2; Engine rotation speed: 7200 rpm; Installed memory capacity: 16384 MB; Maximal memory capacity: no data; Installed memory type: DDR4; Type of memory: N/A; Memory bus frequency: 2400 MHz; Number of memory banks: no data; Producer of installed mainboard\'s chipset: Intel; Installed chipset type: Z270; Integrated graphic card: Yes; Integrated graphic card type: Intel HD Graphics 630; Installed graphic card type: Nvidia GeForce GTX 1080; Integrated sound card: Yes; Integrated sound card type: Integrated; Integrated network adapter: Yes; Wireless network card: Yes; Wireless network card type: IEEE 802.11a/b/g/n/ac; Bluetooth: Yes; Interfaces (connectors): 1x USB 3.1 Gen 2 Type-A , 1x USB 3.1 Gen 2 Type-C, 2x USB 3.1 Gen 1 Type-A , 2 x USB 2.0, 1 x PS-2, 1 x HDMI, 2 x DisplayPort, 1 x SPDIF, 1 x DC-in; Operating system: Windows 10 Home; Power supply (supplies) power: 400 Watt; Width: 176 mm; Height: 380 mm; Depth: 200 mm; Net weight: 7.4 kg;', 'CS-9000011-EU.jpg', 'Corsair PC ONE', 2365),
(2, 1, 9999, 'INTERNAL MEMORY: 16; Total Storage Capacity: 512 GB SSD; Processor family: Intel Xeon W; Operating system provided: Windows 10 Pro; Processor number of cores: 6; Processor clock speed, GHz: 3.60; Connections: USB 3.1. Gen 2; Graphic adapter: No; Maximum internal memory, GB: 256 GB; MOTHERBOARD CHIPSET: Intel C422; Memory slots (available): 6; Processor model: Intel Xeon W-2133 (Max. 3.90 GHz, 8.25 M, 6C); Solid State Disk drive type: M.2 PCIe NVMe; Processor manufacturer: Intel; Intel Virtualization technology: VT-x / VT-d; Internal memory type: DDR4; Memory clock speed, MHz: 2666; Height, mm: 433; Width, mm: 180; Depth, mm: 476; Memory slots: 8; Number of hard drives installed: 1; Ethernet LAN (RJ-45) ports quantity: 1; USB-A (USB 2.0) ports quantity: 2; Intel Turbo Boost, GHz: 3.90 GHz; Intel Smart Cache, MB: 8.25; Speaker/ headphone/ line-out jack: 1; PCI Express x4: 2; USB-A (USB 3.1) ports quantity: 2; Weight, kg: 18; Optical Drive: DVD+/-RW; INTEGRATED MEMORY CARD READER: Yes; Wireless LAN (WLAN): No; PCI Express x1: 2; PCI Express x16: 2; Intel vPro: Yes; Intel HyperThreading: Yes; Ethernet LAN data transfer rates, Mbit/s: 10/100/1000; RAID levels: 0/1/5/10; Raid Controller: Yes;', 'VFYM7700W38GPNC.jpg', 'FUJITSU CELS M770POWER W-2133', 2675),
(3, 1, 9999, 'Producer: Zotac; Product class: Barebone computer;  Processor producer: Intel; Processor type: Core i7; Processor socket type: FCLGA1151; Supported Hyper-Threading technology: Yes; Number of processor slots: 0; Chipset producer: Intel, NVIDIA; Chipset type: B150; Memory type: SODIMM DDR4; Number of DDR4 slots: 2; Memory bus frequency: 2400 MHz; Max memory size: 32 GB; Graphic card type: Nvidia GeForce GTX 1080; Supports VGA systems integrated in the processors: No; HDMI connector: 3 Pcs; DVI connector: 0 Pcs; D-Sub connector: 0 Pcs; LAN controller: Yes; Type of integrated network adapter: 2 x 10/100/1000 Mbit/s; Wireless network card: Yes; Wireless network card type: IEEE 802.11b/g/n/ac; Bluetooth: Yes; Interfaces (connectors): 1 x line out, 1 x Microphone input, 2 x USB 3.1, 4 x USB 3.0, 2 x RJ-45, 2 x DisplayPort, 3 x HDMI; USB 2.0 connectors: 0; USB 3.0 connectors: 4; FireWire (IEEE 1394) connectors: 0 Pcs; Memory card reader: Yes; Types of supported memory cards: SecureDigital Card, SecureDigital Card High-Capacity (SDHC), SecureDigital eXtended Capacity Card (SDXC); Maximal number of Serial ATA devices: 1 Pcs; Serial ATA Hard Disks interface speed: 600 MB/s; Type of computer case: no data; Case type (motherboard type): no data; Number of internal 2,5\" bays: 1; Power supply (supplies) power: 180 Watt; Width: 225 mm; Height: 203 mm; Length: 128 mm; Colour: Black; Additional features: Bluetooth 4.2, Kensington lock, 1 x M2 SSD slot;', 'ZBOX-EN1080K-BE.jpg', 'ZOTAC MAGNUS EN1080K', 1965),
(4, 1, 9999, 'Total Storage Capacity: 256 GB SSD; Graphics adapter family: NVIDIA Quadro; Graphic adapter: NVIDIA Quadro P2000 5GB; Power supply, W: 250; Operating system provided: Windows 10 Pro; Processor model: Intel Core i7-7700 (Max. 4.20 GHz, 8M, 4C); Intel vPro: Yes; Intel Virtualization technology: VT-x / VT-d; Intel HyperThreading: Yes; Intel Turbo Boost, GHz: 4.20; Intel Smart Cache, MB: 8; Memory clock speed, MHz: 2400; INTERNAL MEMORY: 16 GB; Optical Drive: Yes; INTEGRATED MEMORY CARD READER: Yes; Processor family: Intel Core i7; Processor manufacturer: Intel;', '30BH0008MH.jpg', 'LENOVO THINKSTATION P320', 1640),
(5, 1, 9999, 'Product Description: ASUS ROG GR8 II 6GT016Z - mini PC - Core i5 7400 - 16 GB - 1.128 TB; Type: Personal computer - mini PC; Processor: 1 x Intel Core i5 (7th Gen) 7400 (Quad-Core); RAM: 16 GB (installed) / 32 GB (max) - DDR4 SDRAM; Storage Controller: SATA (SATA 6Gb/s); Hard drive: 1 x SSD 128 GB - SATA - M.2; Hard Drive (2nd): 1 x 1 TB - SATA 6Gb/s - 7200 rpm; Optical storage: No optical drive; Graphics Controller: NVIDIA GeForce GTX 1060; Video memory: 6 GB GDDR5 SDRAM; Networking: GigE, Bluetooth 4.0, 802.11ac; OS Provided: Windows 10 64-bit Edition; Dimensions (WxDxH): 8.8 cm x 28.13 cm x 29.9 cm; Weight: 4 kg;', '90MS0161-M00160.jpg', 'ASUS ROG GR8 II 6GT016Z', 1015);

-- --------------------------------------------------------

--
-- Table structure for table `purchase`
--

CREATE TABLE `purchase` (
  `ID` bigint(20) NOT NULL,
  `DATEBEGIN` datetime DEFAULT NULL,
  `DATERETURN` datetime DEFAULT NULL,
  `QUANTITY` int(11) DEFAULT NULL,
  `TOTAL` bigint(20) DEFAULT NULL,
  `PRODUCT_ID` bigint(20) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`ID`, `NAME`) VALUES
(1, 'ADMIN'),
(2, 'USER');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `ID` bigint(20) NOT NULL,
  `CITY` varchar(255) DEFAULT NULL,
  `LOGIN` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `PHONE` varchar(255) DEFAULT NULL,
  `SALTS` varchar(255) DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT '0',
  `SURNAME` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`ID`, `CITY`, `LOGIN`, `NAME`, `PASSWORD`, `PHONE`, `SALTS`, `STATUS`, `SURNAME`) VALUES
(1, '', 'admin', 'Admin', '363e8e9d825190d0bfeedd0986eeee4952b6476aae7774c2ebf04cc7db8ad4a4', '', 'a421d84b7f2fc4776c1751e3a3c69679', 1, ''),
(2, 'NY', 'tester1', 'Tester1 Name', 'bfdc69253ad725de0a72268b1d2992e23f18be2498751adaadfff2e4827994b2', '555555', '5f8ae70f981aa337668b54cae5fc78fe', 1, 'Tester1 Lastname'),
(3, 'NY', 'tester2', 'tester2Name ', 'effcfbb3822befae3da7d3fa30cc3c80d2344c33637916d387093d60bf472633', '4444', '2724c94349f62f5427adbc1e1560be64', 1, 'tester2 LastName');

-- --------------------------------------------------------

--
-- Table structure for table `userroles`
--

CREATE TABLE `userroles` (
  `ID` bigint(20) NOT NULL,
  `ROLE_ID` bigint(20) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `userroles`
--

INSERT INTO `userroles` (`ID`, `ROLE_ID`, `USER_ID`) VALUES
(1, 1, 1),
(2, 2, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `purchase`
--
ALTER TABLE `purchase`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_PURCHASE_PRODUCT_ID` (`PRODUCT_ID`),
  ADD KEY `FK_PURCHASE_USER_ID` (`USER_ID`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `NAME` (`NAME`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `LOGIN` (`LOGIN`);

--
-- Indexes for table `userroles`
--
ALTER TABLE `userroles`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_USERROLES_USER_ID` (`USER_ID`),
  ADD KEY `FK_USERROLES_ROLE_ID` (`ROLE_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `purchase`
--
ALTER TABLE `purchase`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `userroles`
--
ALTER TABLE `userroles`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `purchase`
--
ALTER TABLE `purchase`
  ADD CONSTRAINT `FK_PURCHASE_PRODUCT_ID` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `product` (`ID`),
  ADD CONSTRAINT `FK_PURCHASE_USER_ID` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`ID`);

--
-- Constraints for table `userroles`
--
ALTER TABLE `userroles`
  ADD CONSTRAINT `FK_USERROLES_ROLE_ID` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ID`),
  ADD CONSTRAINT `FK_USERROLES_USER_ID` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
