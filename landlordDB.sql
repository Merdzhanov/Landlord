CREATE DATABASE  IF NOT EXISTS `landlord` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `landlord`;

CREATE TABLE `estates` (
  `EstateID` int(11) NOT NULL AUTO_INCREMENT,
  `Description` varchar(45) DEFAULT NULL,
  `Address` text NOT NULL,
  `LandlordID` varchar(15) NOT NULL,
  `TenantID` varchar(15) NOT NULL,
  `OwedAmount` decimal(10,0) NOT NULL,
  `DueDate` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`EstateID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `messages` (
  `MessageID` varchar(15) NOT NULL,
  `message` text NOT NULL,
  `tenantID` varchar(15) NOT NULL,
  `landlordID` varchar(15) NOT NULL,
  `date` date NOT NULL,
  `sender` varchar(15) NOT NULL,
  PRIMARY KEY (`MessageID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `users` (
  `UserID` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(45) NOT NULL,
  `UserType` int(11) NOT NULL,
  `FirstName` varchar(45) NOT NULL,
  `LastName` varchar(45) NOT NULL,
  `Rating` double DEFAULT 0,
  `Picture` blob DEFAULT NULL,
  PRIMARY KEY (`UserID`),
  UNIQUE KEY `users_UserName_uindex` (`UserName`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


INSERT INTO landlord.users (UserID, UserName, UserType, FirstName, LastName, Rating, Picture) VALUES (1, 'rumi', 0, 'Rumyana', 'Paneva', 0, null);
INSERT INTO landlord.users (UserID, UserName, UserType, FirstName, LastName, Rating, Picture) VALUES (2, 'rumi1', 1, 'Rumyana', 'Paneva', 0, null);
INSERT INTO landlord.estates (EstateID, Description, Address, LandlordID, TenantID, OwedAmount, DueDate) VALUES (1, 'firstApartment', 'new address', '4', '1', 600, null);
INSERT INTO landlord.estates (EstateID, Description, Address, LandlordID, TenantID, OwedAmount, DueDate) VALUES (2, 'second try', 'some address', '4', '1', 300, '2018-10-23 14:12:01');