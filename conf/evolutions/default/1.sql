# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table registration (
  id                        bigint auto_increment not null,
  first_name                varchar(255),
  last_name                 varchar(255),
  email                     varchar(255),
  phone                     varchar(255),
  constraint pk_registration primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table registration;

SET FOREIGN_KEY_CHECKS=1;

