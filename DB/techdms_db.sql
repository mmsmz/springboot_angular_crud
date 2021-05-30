-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 30, 2021 at 04:46 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `techdms_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `advertising_details`
--

CREATE TABLE `advertising_details` (
  `adv_Id` int(11) NOT NULL,
  `vac_Name` varchar(40) NOT NULL,
  `vac_Desc` varchar(40) NOT NULL,
  `vac_Type` varchar(40) NOT NULL,
  `email` varchar(30) NOT NULL,
  `start_Date` date NOT NULL,
  `end_Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `users_details`
--

CREATE TABLE `users_details` (
  `user_Id` int(11) NOT NULL,
  `user_Name` varchar(40) NOT NULL,
  `contact_Nr` varchar(12) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(60) NOT NULL,
  `reg_Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users_details`
--

INSERT INTO `users_details` (`user_Id`, `user_Name`, `contact_Nr`, `email`, `password`, `reg_Date`) VALUES
(1, 'sam', '0775896585', 'sam@gmail.com', '$2a$10$BeKb5ZklF.feao7ZduFCu.wSfGdXNb4cbFCIu3J9ZpWmsby2v6nwO', '2021-05-29'),
(2, 'Reddy', '0745856125', 'reddy@gmail.com', '$2a$10$pbOhknlDSYz1aLmylj.hO.fKIgShJvlYZ4lR9W.JdiWzgtUUE3uai', '2021-05-29');

-- --------------------------------------------------------

--
-- Table structure for table `user_advertising_details`
--

CREATE TABLE `user_advertising_details` (
  `ursadv_Id` int(11) NOT NULL,
  `user_Id` int(11) NOT NULL,
  `advertising_Id` int(11) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `advertising_details`
--
ALTER TABLE `advertising_details`
  ADD PRIMARY KEY (`adv_Id`);

--
-- Indexes for table `users_details`
--
ALTER TABLE `users_details`
  ADD PRIMARY KEY (`user_Id`);

--
-- Indexes for table `user_advertising_details`
--
ALTER TABLE `user_advertising_details`
  ADD PRIMARY KEY (`ursadv_Id`),
  ADD KEY `user_Id` (`user_Id`),
  ADD KEY `advertising_Id` (`advertising_Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `advertising_details`
--
ALTER TABLE `advertising_details`
  MODIFY `adv_Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users_details`
--
ALTER TABLE `users_details`
  MODIFY `user_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user_advertising_details`
--
ALTER TABLE `user_advertising_details`
  MODIFY `ursadv_Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `user_advertising_details`
--
ALTER TABLE `user_advertising_details`
  ADD CONSTRAINT `user_advertising_details_ibfk_1` FOREIGN KEY (`user_Id`) REFERENCES `users_details` (`user_Id`),
  ADD CONSTRAINT `user_advertising_details_ibfk_2` FOREIGN KEY (`advertising_Id`) REFERENCES `advertising_details` (`adv_Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
