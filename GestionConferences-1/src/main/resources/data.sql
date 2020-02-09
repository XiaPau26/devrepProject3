
delete from TypeInscription;
delete from USERS;
delete from AUTHORITIES;
--delete from USERAUTHORITIES;

insert into USERS (username, password, enabled) values ('superadmin', '$2a$10$hbxecwitQQ.dDT4JOFzQAulNySFwEpaFLw38jda6Td.Y/cOiRzDFu', true);
insert into USERS (username, password, enabled) values ('admin1', '$2a$10$hbxecwitQQ.dDT4JOFzQAulNySFwEpaFLw38jda6Td.Y/cOiRzDFu', true);
insert into USERS (username, password, enabled) values ('admin2', '$2a$10$hbxecwitQQ.dDT4JOFzQAulNySFwEpaFLw38jda6Td.Y/cOiRzDFu', true);
insert into USERS (username, password, enabled) values ('admin3', '$2a$10$hbxecwitQQ.dDT4JOFzQAulNySFwEpaFLw38jda6Td.Y/cOiRzDFu', true);

insert into AUTHORITIES (username, authority) values ('superadmin', 'ROLE_ADMIN');
insert into AUTHORITIES (username, authority) values ('admin1', 'ROLE_STAFF');
insert into AUTHORITIES (username, authority) values ('admin2', 'ROLE_STAFF');
insert into AUTHORITIES (username, authority) values ('admin3', 'ROLE_STAFF');


--insert into USERAUTHORITIES (username, authority) values ('admin', 'USER');
-- insert into UserAuthorities (username, authority) values ('superadmin', 'ROLE_USER');
--  
insert into TypeInscription (libelle, tarifearly, tariflate, dateconf) values ('Workshop / Tutorial 1-Day Pass (Monday or Tuesday)', 180, 200, parsedatetime('01-02-2020 12:00:00', 'dd-MM-yy hh:mm:ss'));
insert into TypeInscription (libelle, tarifearly, tariflate, dateconf) values ('Workshop / Tutorial 2-Day Pass (Monday and Tuesday)', 280, 300, parsedatetime('01-02-2020 12:00:00', 'dd-MM-yy hh:mm:ss'));
insert into TypeInscription (libelle, tarifearly, tariflate, dateconf) values ('Additional Guest - Social Event', 120, 140, parsedatetime('01-02-2020 12:00:00', 'dd-MM-yy hh:mm:ss'));
insert into TypeInscription (libelle, tarifearly, tariflate, dateconf) values ('Main Conference (Wednesday to Friday)', 550, 570, parsedatetime('20-02-2020 20:00:00', 'dd-MM-yy hh:mm:ss'));
insert into TypeInscription (libelle, tarifearly, tariflate, dateconf) values ('Main Conference (Student with paper)', 380, 400, parsedatetime('20-02-2020 20:00:00', 'dd-MM-yy hh:mm:ss'));
insert into TypeInscription (libelle, tarifearly, tariflate, dateconf) values ('Industry Day', 200, 220, parsedatetime('01-02-2020 12:00:00', 'dd-MM-yy hh:mm:ss'));
insert into TypeInscription (libelle, tarifearly, tariflate, dateconf) values ('Student without paper', 400, 420, parsedatetime('01-02-2020 12:00:00', 'dd-MM-yy hh:mm:ss'));
insert into TypeInscription (libelle, tarifearly, tariflate, dateconf) values ('Main Conference + 1 Workshop/Tutorial', 650, 670, parsedatetime('01-02-2020 12:00:00', 'dd-MM-yy hh:mm:ss'));
insert into TypeInscription (libelle, tarifearly, tariflate, dateconf) values ('Main Conference + 2 Workshops/Tutorial', 700, 720, parsedatetime('01-02-2020 12:00:00', 'dd-MM-yy hh:mm:ss'));

insert into Conferences(name, description) values ('Conference1', 'description Conference1');
insert into Conferences(name, description) values ('Conference2', 'description Conference2');
insert into Conferences(name, description) values ('Conference3', 'description Conference3');
insert into Conferences(name, description) values ('Conference4', 'description Conference4');
insert into Conferences(name, description) values ('Conference5', 'description Conference5');


insert into AdminConf(admin, idConference) values ('superadmin', 1);
insert into AdminConf(admin, idConference) values ('superadmin', 2);
insert into AdminConf(admin, idConference) values ('superadmin', 3);
insert into AdminConf(admin, idConference) values ('superadmin', 4);
insert into AdminConf(admin, idConference) values ('superadmin', 5);
insert into AdminConf(admin, idConference) values ('admin1', 1);
insert into AdminConf(admin, idConference) values ('admin1', 2);
insert into AdminConf(admin, idConference) values ('admin1', 3);
insert into AdminConf(admin, idConference) values ('admin2', 3);
insert into AdminConf(admin, idConference) values ('admin2', 4);
insert into AdminConf(admin, idConference) values ('admin2', 5);
insert into AdminConf(admin, idConference) values ('admin3', 1);
insert into AdminConf(admin, idConference) values ('admin3', 2);
insert into AdminConf(admin, idConference) values ('admin3', 4);
insert into AdminConf(admin, idConference) values ('admin3', 5);
