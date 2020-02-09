
create table if not exists USERS (
  username varchar_ignorecase(255) not null primary key,
  password varchar_ignorecase(255) not null,
  -- enabled varchar(25) not null
  enabled TINYINT NOT NULL DEFAULT 1
);

create table if not exists AUTHORITIES (
  username varchar_ignorecase(255) not null,
  authority varchar_ignorecase(255) not null
  -- constraint fk_authorities_users foreign key(username) references users(username)
);

create table if not exists TypeInscription (
  id identity,
  libelle varchar(255) not null,
  tarifearly int not null,
  tariflate int not null, 
  dateconf datetime not null
);

alter table AUTHORITIES add foreign key (username) references USERS(username);
create unique index ix_auth_username on AUTHORITIES (username,authority);

create table if not exists Formulaires (
  id identity,
  title varchar(255) not null,
  firstname varchar(255) not null,
  lastname varchar(255) not null,
  institution varchar(255) not null,
  address varchar(255) not null,
  zip varchar(255) not null,
  city varchar(255) not null,
  country varchar(255) not null,
  email varchar(255) not null,
  phone varchar(255) not null,
  idconference int not null,
  idtype int not null,
  validated int not null
);

alter table Formulaires add foreign key (idtype) references TypeInscription(id);
    
create table if not exists FormulairesPayes (
  id identity,
  title varchar(255) not null,
  firstname varchar(255) not null,
  lastname varchar(255) not null,
  institution varchar(255) not null,
  address varchar(255) not null,
  zip varchar(255) not null,
  city varchar(255) not null,
  country varchar(255) not null,
  email varchar(255) not null,
  phone varchar(255) not null,
  idconference int not null,
  idtype int not null,
  datepaiement datetime not null,
  ccnumber long not null,
  cccv int not null,
  ccexpiration varchar(20) not null,
  recuEnvoye boolean not null
);


create table if not exists Conferences (
  id identity,
  name varchar(255) not null,
  description varchar(255) not null
);


create table if not exists URLs (
  url varchar(255) not null primary key,
  dateExpiration varchar(255) not null
);

create table if not exists AdminConf (
  admin varchar_ignorecase(255) not null,
  idConference long not null
);


