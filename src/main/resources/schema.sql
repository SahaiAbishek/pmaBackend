CREATE TABLE `PROJECTS` 
(  
	`PROJECT_ID` integer not null AUTO_INCREMENT,
	`PROJECT` varchar(20),
	`START_DATE` DATE,
	`END_DATE` DATE,
	`PRIORITY` INTEGER,
	PRIMARY KEY (`PROJECT_ID`)
);

CREATE TABLE `PARENT_TASKS` 
(  
	`PARENT_ID` integer not null AUTO_INCREMENT,
	`PARENT_TASK` varchar(2000),
	PRIMARY KEY (`PARENT_ID`) 
);

CREATE TABLE `TASKS` 
(  
	`TASK_ID` integer not null AUTO_INCREMENT,
	`PARENT_ID` INTEGER,
	`PROJECT_ID` INTEGER,
	`TASK` VARCHAR(2000),
	`START_DATE` DATE,
	`END_DATE` DATE,
	`PRIORITY` INTEGER,
	`STATUS` VARCHAR(30),
	PRIMARY KEY (`TASK_ID`), 
	FOREIGN KEY (`PROJECT_ID`) REFERENCES `PROJECTS` (`PROJECT_ID`),
	FOREIGN KEY (`PARENT_ID`) REFERENCES `PARENT_TASKS` (`PARENT_ID`)
);

CREATE TABLE `USERS` 
(  
	`USER_ID`  integer not null auto_increment,
	`FIRST_NAME` varchar(20),  
	`LAST_NAME` varchar(20),  
	`EMPLOYEE_ID` varchar(20),  
	`PROJECT_ID` INTEGER,  
	`TASK_ID` INTEGER, 
	PRIMARY KEY (`USER_ID`),
	FOREIGN KEY (`PROJECT_ID`) REFERENCES `PROJECTS` (`PROJECT_ID`),
	UNIQUE KEY `EMPLOYEE_ID` (`EMPLOYEE_ID`)
) ;