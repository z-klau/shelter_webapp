

 CREATE TABLE `pens`(
  `id` INT NOT NULL auto_increment,
  `name` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`)
  );
 
 
  CREATE TABLE `dogs`(
  `id` INT NOT NULL auto_increment,
  `name` VARCHAR(25) NOT NULL,
  `sex` VARCHAR(1) NOT NULL,
  `race` VARCHAR(25) NOT NULL,
  `weight` DECIMAL NOT NULL,
  `place_of_find` VARCHAR(30) NOT NULL,
  `date_of_find` DATE NOT NULL, 
  `pen_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY(`pen_id`) REFERENCES pens(`id`)
  );


insert into pens (name) values ('s�oneczny');
insert into pens (name) values ('sosnowy');
insert into pens (name) values ('brzozowy');
insert into pens (name) values ('le�ny');
insert into pens (name) values ('polny');
insert into pens (name) values ('d�bowy');

insert into dogs (name, sex, race, weight, place_of_find, date_of_find, pen_id) values ('Fred', 'M', 'mieszaniec', 20.0, 'Warszawa-Wola', '20131103', 1);
insert into dogs (name, sex, race, weight, place_of_find, date_of_find, pen_id) values ('Jackie', 'M', 'owczarek szkocki', 45.9, 'Warszawa-Ochota', '20100201', 5);
insert into dogs (name, sex, race, weight, place_of_find, date_of_find, pen_id) values ('Piku�', 'M', 'beagle', 60.0, 'Warszawa-W�ochy', '20120220', 4);
insert into dogs (name, sex, race, weight, place_of_find, date_of_find, pen_id) values ('Burek', 'M', 'mieszaniec', 23.7, 'Warszawa-Centrum', '20100612', 3);
insert into dogs (name, sex, race, weight, place_of_find, date_of_find, pen_id) values ('Fruzia', '�', 'pudel', 15.0, 'Otwock', '20101001', 5);
insert into dogs (name, sex, race, weight, place_of_find, date_of_find, pen_id) values ('Lassie', '�', 'shih tzu', 32.8, 'Warszawa-Praga', '20150816', 6);
insert into dogs (name, sex, race, weight, place_of_find, date_of_find, pen_id) values ('Peggy', '�', 'mieszaniec', 12.5, 'Warszawa-�oliborz', '20141107', 2);
insert into dogs (name, sex, race, weight, place_of_find, date_of_find, pen_id) values ('Aldo', 'M', 'pudel', 7.5, 'Warszawa-Praga', '20120106', 4);
insert into dogs (name, sex, race, weight, place_of_find, date_of_find, pen_id) values ('Kajman', 'M', 'jamnik', 4.8, 'Warszawa-Centrum', '20140919', 1);
insert into dogs (name, sex, race, weight, place_of_find, date_of_find, pen_id) values ('Misia', '�', 'mieszaniec', 17.2, 'Warszawa-Bielany', '20130430', 4);
insert into dogs (name, sex, race, weight, place_of_find, date_of_find, pen_id) values ('�apka', '�', 'malta�czyk', 3.9, 'Warszawa-�oliborz', '20120812', 4);
insert into dogs (name, sex, race, weight, place_of_find, date_of_find, pen_id) values ('Bella', '�', 'husky', 29.0, 'Warszawa-Ursyn�w', '20130517', 3);
insert into dogs (name, sex, race, weight, place_of_find, date_of_find, pen_id) values ('Muminek', 'M', 'pudel', 11.0, 'Warszawa-Centrum', '20151010',  1);
insert into dogs (name, sex, race, weight, place_of_find, date_of_find, pen_id) values ('Migotka', '�', 'mieszaniec', 6.0, 'Warszawa-Bia�o��ka', '20130730', 1);
insert into dogs (name, sex, race, weight, place_of_find, date_of_find, pen_id) values ('�bik', 'M', 'buldog', 22.0, 'Warszawa-Ok�cie', '20100327', 4);
insert into dogs (name, sex, race, weight, place_of_find, date_of_find, pen_id) values ('Viva', '�', 'bokser', 25.0, 'Warszawa-W�ochy', '20110713', 2);
insert into dogs (name, sex, race, weight, place_of_find, date_of_find, pen_id) values ('Trusia', '�', 'pinczer', 2.8, 'Marki', '2015', '20160327', 1);
insert into dogs (name, sex, race, weight, place_of_find, date_of_find, pen_id) values ('Melman', 'M',  'pudel', 9.0, 'Warszawa-Bia�o��ka', '20120515', 2);
insert into dogs (name, sex, race, weight, place_of_find, date_of_find, pen_id) values ('Greta', '�', 'hart', 19.0, 'Warszawa-Ursyn�w', '20161219', 6);
insert into dogs (name, sex, race, weight, place_of_find, date_of_find, pen_id) values ('Pusia', '�', 'dog', 55.8, 'Z�bki', 'Warszawa-Bielany', '20161205', 1);
insert into dogs (name, sex, race, weight, place_of_find, date_of_find, pen_id) values ('Groszek', 'M' 'mieszaniec', 22.9, 'O�ar�w Mazowiecki', '20130912', 2);
insert into dogs (name, sex, race, weight, place_of_find, date_of_find, pen_id) values ('Hektor', 'M', 'terier', 26.7, 'Warszawa-Bia�o��ka', '20120126', 3);
insert into dogs (name, sex, race, weight, place_of_find, date_of_find, pen_id) values ('Szrama', '�', 'spaniel', 18.0, 'Warszawa-Ok�cie', '20111109', 3);
insert into dogs (name, sex, race, weight, place_of_find, date_of_find, pen_id) values ('Porto', 'M', 'pudel', 12.6, 'Warszawa-Bielany', '20160727',  4);
insert into dogs (name, sex, race, weight, place_of_find, date_of_find, pen_id) values ('Sandy', '�', 'chihuahua' 2.5, 'Warszawa-W�ochy', '20110929', 1);
insert into dogs (name, sex, race, weight, place_of_find, date_of_find, pen_id) values ('Maniek', 'M', 'jamnik', 3.5, 'Warszawa-Ursyn�w', '20150331', 6);
insert into dogs (name, sex, race, weight, place_of_find, date_of_find, pen_id) values ('Kaja', '�', 'mieszaniec', 18.9, 'Warszawa-Praga', '20160515', 5);
insert into dogs (name, sex, race, weight, place_of_find, date_of_find, pen_id) values ('Mila', '�', 'bulterier', 12.4, 'Warszawa-Ok�cie', '20121111', 6);
insert into dogs (name, sex, race, weight, place_of_find, date_of_find, pen_id) values ('Bary', 'M', 'mops', 3.0, 'Warszawa-Bia�o��ka', '20150514', 5);
insert into dogs (name, sex, race, weight, place_of_find, date_of_find, pen_id) values ('Je�yna', '�', 'szpic', 3.5, 'Warszawa-Bielany', '20111208', 4);
insert into dogs (name, sex, race, weight, place_of_find, date_of_find, pen_id) values ('Lutek', 'M' 'akita', 35.8, 'Piaseczno', '20160112', 3);
insert into dogs (name, sex, race, weight, place_of_find, date_of_find, pen_id) values ('�aba', '�', 'beagle', 14.4, 'Warszawa-W�ochy', '20160819', 2);
insert into dogs (name, sex, race, weight, place_of_find, date_of_find, pen_id) values ('Bobek', 'M', 'bokser', 28.4, 'Legionowo', '20111019', 1);