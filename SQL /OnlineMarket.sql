CREATE TABLE  `OnlineMarket`.`Role` (
  `RoleId` int(11) NOT NULL AUTO_INCREMENT,
  `RoleName` varchar(45) NOT NULL,
  PRIMARY KEY (`RoleId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

INSERT INTO `OnlineMarket`.`Role` VALUES  (1,'Farmer'),
 (2,'WholeSeller'),
 (3,'Retailer'),
 (4,'Civilian'),
 (5,'Admin'),
 (6,'ComputerProfession');
 
 CREATE TABLE  `OnlineMarket`.`UserDetails1` (
  `UserId` int(11) NOT NULL AUTO_INCREMENT,
  `RoleId` int(11) DEFAULT NULL,
  `UserName` varchar(45) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `Address` varchar(45) DEFAULT NULL,
  `PhoneNumber` varchar(13) DEFAULT NULL,
  `Name` varchar(15) NOT NULL,
  PRIMARY KEY (`UserId`),
  KEY `fk_UserDetails_1_idx` (`RoleId`),
  CONSTRAINT `fk_UserDetails_1` FOREIGN KEY (`RoleId`) REFERENCES `Role` (`RoleId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

INSERT INTO `OnlineMarket`.`UserDetails1` VALUES  (1,1,'suresh@gmail.com','suresh','hyderabad','83748374','suresh'),
 (3,1,'srujan@gmail.com','srujan','hyderabad','1263234','srujan'),
 (4,3,'sravan@gmail.com','sravan','hyderabad','3434','sravan'),
 (5,5,'vikas@gmail.com','vikas','hyderabad','345784','vikas'),
 (6,6,'vikas1@gmail.com','vikas1','hyderabad','874857','vikas1'),
 (7,2,'mounika@gmail.com','mounika','hyderabad','987459','mounika'),
 (8,4,'roopa@gmail.com','roopa','hyderabad','0','roopacharym'),
 (9,4,'tejo@gmail.com','tejo','hyderabad','87458675','tejo'),
 (10,1,'neha@mail.com','123456','kjhljhj','0','neha'),
 (15,2,'vinnu@mail.com','vinnu123','hyderabad','9999999999','vinnu'),
 (16,1,'vijay@gmail.com','vijay','hyderabad','9885858585','vijay'),
 (17,6,'buddy@gmail.com','buddy','hyderabad','984905292','buddy'),
 (18,2,'anusha.yerra@yahoo.com','anusha','srngr','9999999999','anusha');
 
 CREATE TABLE  `OnlineMarket`.`VegetableDetails` (
  `VegetableId` int(11) NOT NULL AUTO_INCREMENT,
  `VegetableName` varchar(45) NOT NULL,
  PRIMARY KEY (`VegetableId`),
  UNIQUE KEY `VegitableId_UNIQUE` (`VegetableId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

INSERT INTO `OnlineMarket`.`VegetableDetails` VALUES  (1,'tomato'),
 (2,'potato'),
 (3,'beans'),
 (4,'ladyfinger'),
 (5,'brinjal'),
 (6,'drumstics'),
 (7,'cabbage'),
 (8,'califlower'),
 (11,'carrot'),
 (12,'sahdh');

CREATE TABLE  `OnlineMarket`.`VegetableQuantity` (
  `UserId` int(11) NOT NULL,
  `VegetableId` int(11) NOT NULL,
  `VegetableQuantity` int(11) DEFAULT NULL,
  `AvailableQuantity` int(11) NOT NULL,
  `VegetableQuantityId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`VegetableQuantityId`),
  KEY `constraintV` (`VegetableId`),
  KEY `constraintu` (`UserId`),
  CONSTRAINT `constraintu` FOREIGN KEY (`UserId`) REFERENCES `UserDetails1` (`UserId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `constraintV` FOREIGN KEY (`VegetableId`) REFERENCES `VegetableDetails` (`VegetableId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

INSERT INTO `OnlineMarket`.`VegetableQuantity` VALUES  (1,6,1000,1000,7),
 (1,5,1000,1000,8),
 (1,4,1000,940,9),
 (1,3,1000,1000,10),
 (1,2,1000,820,11),
 (1,1,1300,601,13),
 (3,1,518,1380,14),
 (3,2,1100,220,15),
 (3,3,1000,1000,16),
 (3,4,1000,1000,17),
 (3,4,1000,1000,18),
 (3,5,1000,1000,19),
 (3,6,1000,1000,20),
 (3,8,1000,1000,23),
 (1,7,1000,1000,24),
 (1,8,1000,980,25),
 (1,11,1000,1000,26),
 (10,1,1000,1000,27),
 (16,1,23,40,29),
 (1,7,500,500,30),
 (18,1,500,0,31);

CREATE TABLE  `OnlineMarket`.`Booking` (
  `BookingId` int(11) NOT NULL AUTO_INCREMENT,
  `UserId` int(11) DEFAULT NULL,
  `RoleId` int(11) DEFAULT NULL,
  `BookingQuantity` int(11) DEFAULT NULL,
  `VegetableId` int(11) DEFAULT NULL,
  `BookingDate` date DEFAULT NULL,
  `BookingTo` int(11) DEFAULT NULL,
  PRIMARY KEY (`BookingId`),
  KEY `fk_Booking_1_idx` (`VegetableId`),
  KEY `fk_Booking_2_idx` (`RoleId`),
  KEY `fk_Booking_3_idx` (`UserId`),
  CONSTRAINT `fk_Booking_1` FOREIGN KEY (`VegetableId`) REFERENCES `VegetableDetails` (`VegetableId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Booking_2` FOREIGN KEY (`RoleId`) REFERENCES `Role` (`RoleId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Booking_3` FOREIGN KEY (`UserId`) REFERENCES `UserDetails1` (`UserId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



CREATE TABLE  `OnlineMarket`.`Status` (
  `StatusId` int(11) NOT NULL AUTO_INCREMENT,
  `Status` varchar(10) NOT NULL,
  `Date` varchar(15) NOT NULL,
  `UserId` int(11) NOT NULL,
  `BookedTo` int(11) NOT NULL,
  `VegetableId` int(11) DEFAULT NULL,
  `BookingQuantity` int(11) NOT NULL,
  PRIMARY KEY (`StatusId`),
  KEY `new_fk_constraint` (`UserId`),
  KEY `_constraint` (`VegetableId`),
  KEY `constraint` (`BookedTo`),
  CONSTRAINT `constraint` FOREIGN KEY (`BookedTo`) REFERENCES `UserDetails1` (`UserId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `new_fk_constraint` FOREIGN KEY (`UserId`) REFERENCES `UserDetails1` (`UserId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `_constraint` FOREIGN KEY (`VegetableId`) REFERENCES `VegetableDetails` (`VegetableId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=latin1;

INSERT INTO `OnlineMarket`.`Status` VALUES  (32,'accepted','2012-11-01',1,3,2,20),
 (33,'accepted','2012-11-01',1,3,8,20),
 (34,'Declined','2012-11-01',9,1,6,20),
 (35,'accepted','2012-11-01',9,1,6,20),
 (36,'accepted','2012-11-01',10,1,2,20),
 (37,'accepted','2012-11-01',10,1,2,100),
 (39,'accepted','2012-11-05',1,3,2,100),
 (40,'accepted','2012-11-05',1,3,2,100),
 (41,'accepted','2012-11-05',1,3,2,700),
 (42,'Declined','2012-11-05',16,1,1,100),
 (43,'accepted','2012-11-05',1,3,1,700),
 (44,'accepted','2012-11-05',1,3,1,100),
 (45,'accepted','2012-11-05',1,3,1,100),
 (46,'accepted','2012-11-05',1,3,1,100),
 (47,'accepted','2012-11-05',16,3,1,20),
 (48,'accepted','2012-11-05',16,3,1,20),
 (49,'accepted','2012-11-05',3,16,1,100),
 (50,'Declined','2012-11-05',3,16,1,100),
 (51,'accepted','2012-11-07',16,3,1,20),
 (52,'Declined','2012-11-08',18,1,5,1000),
 (53,'Declined','2012-11-08',3,1,3,1000),
 (54,'accepted','2012-11-08',18,3,1,500),
 (55,'accepted','2012-11-08',3,18,1,500);
 
 CREATE TABLE  `OnlineMarket`.`State` (
  `StateId` int(11) NOT NULL AUTO_INCREMENT,
  `StateName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`StateId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

INSERT INTO `OnlineMarket`.`State` VALUES  (1,'California'),
 (2,'Texas'),
 (3,'Arizona'),
 (4,'Ohio'),
 (5,'Missouri'),
 (6,'NewJersy'),
 (7,'Washington');
 
 CREATE TABLE  `OnlineMarket`.`Distict` (
  `DisticId` int(11) NOT NULL AUTO_INCREMENT,
  `DistictName` varchar(45) DEFAULT NULL,
  `StateId` int(11) DEFAULT NULL,
  PRIMARY KEY (`DisticId`),
  KEY `fk_Distict_1_idx` (`StateId`),
  CONSTRAINT `fk_Distict_1` FOREIGN KEY (`StateId`) REFERENCES `State` (`StateId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

INSERT INTO `OnlineMarket`.`Distict` VALUES  (1,'SFO',1),
 (2,'San antonio',2),
 (3,'Phoneix',3),
 (4,'Cincinnati',4),
 (5,'St.louis',5),
 (6,'Albany',6),
 (7,'Seattle',7);
 
 CREATE TABLE  `OnlineMarket`.`Region` (
  `RegionId` int(11) NOT NULL AUTO_INCREMENT,
  `RegionName` varchar(45) DEFAULT NULL,
  `DistictId` int(11) DEFAULT NULL,
  PRIMARY KEY (`RegionId`),
  KEY `fk_Region_1_idx` (`DistictId`),
  CONSTRAINT `fk_Region_1` FOREIGN KEY (`DistictId`) REFERENCES `Distict` (`DisticId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

 INSERT INTO `OnlineMarket`.`Region` VALUES  (1,'Fremont',1),
 (2,'Bandera',2),
 (3,'cleveland',3),
 (4,'Farmers Branch',4);

CREATE TABLE  `OnlineMarket`.`ComputerProfessional` (
  `ComputerProffesionalId` int(11) NOT NULL AUTO_INCREMENT,
  `RoleId` int(11) DEFAULT NULL,
  `ComputerProfessionalName` varchar(45) DEFAULT NULL,
  `ComputerProfessionalInTime` time DEFAULT NULL,
  `ComputerProfessionalOutTime` time DEFAULT NULL,
  `ComputerProfessionalDate` int(11) DEFAULT NULL,
  PRIMARY KEY (`ComputerProffesionalId`),
  KEY `fk_ComputerProfessional_1_idx` (`RoleId`),
  CONSTRAINT `fk_ComputerProfessional_1` FOREIGN KEY (`RoleId`) REFERENCES `Role` (`RoleId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE  `OnlineMarket`.`FeedBackType` (
  `TypeId` int(11) NOT NULL AUTO_INCREMENT,
  `TypeName` varchar(10) NOT NULL,
  PRIMARY KEY (`TypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

INSERT INTO `OnlineMarket`.`FeedBackType` VALUES  (1,'WebSite'),
 (2,'Vegetables'),
 (3,'suggestion');

CREATE TABLE  `OnlineMarket`.`FeedBack` (
  `UserId` int(11) DEFAULT NULL,
  `Feedback` varchar(300) NOT NULL,
  `FeedbackId` int(11) NOT NULL AUTO_INCREMENT,
  `TypeId` int(11) NOT NULL,
  PRIMARY KEY (`FeedbackId`),
  KEY `fk_FeedBack_2_idx` (`UserId`),
  KEY `new_fk_constraint12` (`TypeId`),
  CONSTRAINT `fk_FeedBack_2` FOREIGN KEY (`UserId`) REFERENCES `UserDetails1` (`UserId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `new_fk_constraint12` FOREIGN KEY (`TypeId`) REFERENCES `FeedBackType` (`TypeId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

CREATE TABLE  `OnlineMarket`.`PriceDetails` (
  `PriceId` int(11) NOT NULL AUTO_INCREMENT,
  `VegetableId` int(11) DEFAULT NULL,
  `RegionId` int(11) DEFAULT NULL,
  `GovernmentPrice` int(11) DEFAULT NULL,
  `FarmerPrice` int(11) DEFAULT NULL,
  `WholeSellerPrice` int(11) DEFAULT NULL,
  `RetailerPrice` int(11) DEFAULT NULL,
  PRIMARY KEY (`PriceId`),
  KEY `fk_PriceDetails_1_idx` (`RegionId`),
  KEY `fk_PriceDetails_2_idx` (`VegetableId`),
  CONSTRAINT `fk_PriceDetails_1` FOREIGN KEY (`RegionId`) REFERENCES `Region` (`RegionId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_PriceDetails_2` FOREIGN KEY (`VegetableId`) REFERENCES `VegetableDetails` (`VegetableId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

INSERT INTO `OnlineMarket`.`PriceDetails` VALUES  (1,1,1,100,100,100,100),
 (2,2,1,56,56,56,56),
 (3,3,1,5,6,7,7),
 (4,4,1,56,56,56,56),
 (5,5,1,56,56,56,56),
 (6,6,1,56,56,56,56),
 (7,1,1,5,3,2,1);

CREATE TABLE  `OnlineMarket`.`QuantityRequest` (
  `VegetableId` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `UserId` int(11) NOT NULL,
  `QuantityRequestId` int(11) NOT NULL AUTO_INCREMENT,
  `Status` varchar(15) NOT NULL,
  PRIMARY KEY (`QuantityRequestId`),
  KEY `new_fk_constraint123` (`VegetableId`),
  KEY `new_fk_constraint4354` (`UserId`),
  CONSTRAINT `new_fk_constraint123` FOREIGN KEY (`VegetableId`) REFERENCES `VegetableDetails` (`VegetableId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `new_fk_constraint4354` FOREIGN KEY (`UserId`) REFERENCES `UserDetails1` (`UserId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1 ROW_FORMAT=FIXED;

INSERT INTO `OnlineMarket`.`QuantityRequest` VALUES  (1,1000,3,2,'Accepted'),
 (1,1000,3,4,'Accepted'),
 (1,1000,3,5,'Accepted'),
 (1,1000,3,6,'Accepted'),
 (1,100,3,7,'Accepted'),
 (2,100,3,8,'Pending');

