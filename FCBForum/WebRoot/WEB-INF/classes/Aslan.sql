
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET CHARACTER SET 'latin1' */;

# Host: localhost    Database: Aslan
# ------------------------------------------------------
# Server version 5.0.19-nt

DROP DATABASE IF EXISTS `Aslan`;
CREATE DATABASE `Aslan` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `Aslan`;


CREATE TABLE `user` (
  `username` varchar(20) NOT NULL,                   
  `password` varchar(20) NOT NULL,                    
  `sex` varchar(2) NOT NULL,                           
  `email` varchar(50) NOT NULL,                        
  `icq` varchar(20) default NULL,                    
  `signature` varchar(300) default NULL,            	
  `grade` varchar(20) default NULL,                  
  PRIMARY KEY  (`username`)                         
);

insert into user(`username`,`password` ,`grade`,`sex`,`email`) values ('user','user',0,'0','user');
insert into user(`username`,`password` ,`grade`,`sex`,`email`) values ('admin','admin',2,'1','admin');

CREATE TABLE `forum` (
  `id` int(4) NOT NULL,                                  
  `forumname` varchar(20) NOT NULL,                   
  `manager` varchar(20) default NULL,                 	
  PRIMARY KEY  (`id`)                                    	
) ENGINE=InnoDB DEFAULT CHARSET=GB2312;

CREATE TABLE `topic` (
  `id` int(4) NOT NULL,                                    
  `title` varchar(300) NOT NULL,                           
  `content` text,                                             
  `author` varchar(20) NOT NULL,                          
  `submittime` date NOT NULL,                             
  `forumid` int(4) NOT NULL,                               
  PRIMARY KEY  (`id`)                                        	
);


CREATE TABLE `response` (
  `id` int(4) NOT NULL,                                   
  `title` varchar(300) NOT NULL,                         
  `content` text,                                           
  `author` varchar(20) NOT NULL,                         
  `submittime` date NOT NULL,                              
  `topicid` int(4) NOT NULL,                              
  PRIMARY KEY  (`id`)                                      
);


