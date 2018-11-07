CREATE DATABASE  IF NOT EXISTS `landlord` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `landlord`;

create or replace table if not exists estates
(
  EstateID    int auto_increment
  constraint `PRIMARY`
  primary key,
  Description varchar(45)                          null,
  Address     text                                 not null,
  Landlord    varchar(15)                          not null,
  Tenant      varchar(15)                          not null,
  OwedAmount  decimal                              not null,
  DueDate     datetime default current_timestamp() null,
  imageUrl    varchar(255)                         null
);

create or replace table if not exists hibernate_sequence
(
  next_not_cached_value bigint(21)          not null,
  minimum_value         bigint(21)          not null,
  maximum_value         bigint(21)          not null,
  start_value           bigint(21)          not null
  comment 'start value when sequences is created or value if RESTART is used',
  increment             bigint(21)          not null
  comment 'increment value',
  cache_size            bigint(21) unsigned not null,
  cycle_option          tinyint(1) unsigned not null
  comment '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  cycle_count           bigint(21)          not null
  comment 'How many cycles have been done'
);

create or replace table if not exists messages
(
  MessageID  varchar(15) not null
  constraint `PRIMARY`
  primary key,
  message    text        not null,
  tenantID   varchar(15) not null,
  landlordID varchar(15) not null,
  date       date        not null,
  sender     varchar(15) not null
);

create or replace table if not exists users
(
  UserID    int auto_increment
  constraint `PRIMARY`
  primary key,
  UserName  varchar(45)      not null,
  UserType  int              not null,
  FirstName varchar(45)      not null,
  LastName  varchar(45)      not null,
  Rating    double default 0 null,
  Picture   blob             null,
  constraint users_UserName_uindex
  unique (UserName)
);

create or replace table if not exists chatmessages
(
  MessageID int          not null
  constraint `PRIMARY`
  primary key,
  Date      datetime(6)  null,
  Message   varchar(255) null,
  EstateID  int          null,
  UserID    int          null,
  constraint FKdy1tvh9fgxcso23t7s38snemt
  foreign key (EstateID) references estates (EstateID),
  constraint FKon07bk7byxusilwek5h0ekcye
  foreign key (UserID) references users (UserID)
);

create or replace table if not exists usersestates
(
  EstateID int not null,
  UserID   int not null,
  constraint FKp8jdyw8c8v25wpxaktxixtpgd
  foreign key (EstateID) references estates (EstateID),
  constraint FKqnki7fxn6y5hlh75l9mekcvjh
  foreign key (UserID) references users (UserID)
);

INSERT INTO landlord.estates (EstateID, Description, Address, Landlord, Tenant, OwedAmount, DueDate, imageUrl) VALUES (1, 'firstApartment', 'new address', 'rumi1', 'rumi', 600, null, null);
INSERT INTO landlord.estates (EstateID, Description, Address, Landlord, Tenant, OwedAmount, DueDate, imageUrl) VALUES (2, 'second try', 'some address', 'kosio1', 'rumi', 300, '2018-10-23 14:12:01', null);
INSERT INTO landlord.estates (EstateID, Description, Address, Landlord, Tenant, OwedAmount, DueDate, imageUrl) VALUES (4, 'third Apartment', 'address', 'rumi1', 'kosio', 800, '2018-10-24 18:38:55', null);
INSERT INTO landlord.estates (EstateID, Description, Address, Landlord, Tenant, OwedAmount, DueDate, imageUrl) VALUES (5, 'fourth Apartment', 'addres4', 'kosio1', 'kosio', 750, '2018-10-24 18:38:55', null);

INSERT INTO landlord.users (UserID, UserName, UserType, FirstName, LastName, Rating, Picture) VALUES (1, 'rumi', 0, 'Rumyana', 'Paneva', 0, null);
INSERT INTO landlord.users (UserID, UserName, UserType, FirstName, LastName, Rating, Picture) VALUES (2, 'rumi1', 1, 'Rumyana', 'Paneva', 0, null);
INSERT INTO landlord.users (UserID, UserName, UserType, FirstName, LastName, Rating, Picture) VALUES (3, 'kosio', 0, 'Konstantin', 'Merdzanov', 0, null);
INSERT INTO landlord.users (UserID, UserName, UserType, FirstName, LastName, Rating, Picture) VALUES (4, 'kosio1', 1, 'Konstantin', 'Merdzanov', 0, null);

