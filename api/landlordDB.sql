CREATE DATABASE  IF NOT EXISTS `landlord` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `landlord`;

create or replace table if not exists estates
(
  EstateID    int            not null
    primary key,
  Address     varchar(255)   null,
  Description varchar(255)   null,
  DueDate     datetime(6)    null,
  imageUrl    varchar(255)   null,
  Name        varchar(255)   null,
  OwedAmount  decimal(19, 1) null,
  MonthlyRent decimal(19, 1) null,
  image       tinyblob       null
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

create or replace table if not exists users
(
  UserID    int          not null
    primary key,
  Rating    double       null,
  UserName  varchar(255) null,
  UserType  int          null,
  FirstName varchar(255) null,
  LastName  varchar(255) null
);

create or replace table if not exists chatmessages
(
  MessageID int auto_increment
    primary key,
  Date      date default current_timestamp() null,
  Text      varchar(255)                     null,
  EstateID  int                              null,
  UserID    int                              null,
  constraint FKdy1tvh9fgxcso23t7s38snemt
  foreign key (EstateID) references estates (EstateID),
  constraint FKon07bk7byxusilwek5h0ekcye
  foreign key (UserID) references users (UserID)
);

create or replace table if not exists ratingvote
(
  RatingVoteID int          not null
    primary key,
  RatingVoted  float        null,
  VotingDate   datetime(6)  null,
  UserID       int          null,
  Voter        varchar(255) null,
  constraint FK3nynsmwamhi5xjxtrvugu3yo2
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


