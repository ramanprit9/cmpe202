drop table if exists member_registration;
create table member_registration
(member_id INT NOT NULL AUTO_INCREMENT,
member_fname varchar(50),
member_lname varchar(50),
member_housenum varchar(50),
member_buildingnum varchar(50),
member_street varchar(50),
member_city varchar(50),
member_state varchar(50),
member_zip varchar(10),
member_type varchar(50),
member_card_type varchar(15),
member_card_number varchar(15),
member_card_cvs_number varchar(15),
member_payment_balance double,
member_username varchar(20),
member_pwd varchar(20),
id_read varchar (3),
member_active varchar (3),
PRIMARY KEY (member_id));

drop table if exists user_requests;
create table user_requests
(request_id INT NOT NULL AUTO_INCREMENT,
member_id varchar(50),
request_pickup_loc varchar(50),
request_pickup_time varchar(50),
request_destination varchar(50),
request_state varchar(20),
request_shareable varchar(20),
request_type varchar(20),
request_sub_type varchar(20),
request_vehicle_type varchar(20),
request_no_passengers_travelling integer,
request_no_luggages integer,
request_flag varchar(1),
vehicle_id int,
vehicle_type varchar(10),
PRIMARY KEY (request_id));

drop table if exists payment;
create table payment
(payment_id INT NOT NULL AUTO_INCREMENT,
request_id integer,
payment_method varchar(15),
payment_strategy varchar(50),
payment_amount_calculated integer,
payment_amount_paid integer,
PRIMARY KEY (payment_id,request_id));

drop table if exists vehicle;
create table vehicle
(vehicle_id INT NOT NULL AUTO_INCREMENT,
request_id int,
vehicle_license_num varchar(15),
vehicle_type varchar(15), 
min_passengers int,
max_passengers int,
max_luggages int,
vehicle_state varchar(20),
vehicle_avalible_2miles varchar(1),
vehicle_avalible_5miles varchar(1),
vehicle_shareable varchar(1),
pay_per_minute varchar(15),
pay_per_mile varchar(15),
additional_pay varchar (15), 
vehicle_active varchar(1),
PRIMARY KEY (vehicle_id));



insert into member_registration (member_fname, member_lname, member_housenum, member_buildingnum, member_street, 
member_city, member_state, member_zip, member_type, member_card_type, member_card_number, member_card_cvs_number,
member_payment_balance, member_username, id_read, member_active)
values
('Jane', 'Smith', '1550', '', 'Happy Lane', 'Milpitas', 'CA', '95035', 'SILVER', 'CREDITCARD', 
  '12345678', '456', 0.00, 'janesmith', 'Y', 'Y');

insert into vehicle (vehicle_type,vehicle_state,request_id,vehicle_avalible_2miles,vehicle_avalible_5miles,vehicle_shareable,vehicle_active,pay_per_minute,pay_per_mile,min_passengers,max_passengers,max_luggages)
values ('sedan','AVAILABLE',0,'Y','N','N','Y','5','3',0,0,0);
insert into vehicle (vehicle_type,vehicle_state,request_id,vehicle_avalible_2miles,vehicle_avalible_5miles,vehicle_shareable,vehicle_active,pay_per_minute,pay_per_mile,min_passengers,max_passengers,max_luggages)
values ('sedan','AVAILABLE',0,'Y','N','N','Y','5','3',0,0,0);
insert into vehicle (vehicle_type,vehicle_state,request_id,vehicle_avalible_2miles,vehicle_avalible_5miles,vehicle_shareable,vehicle_active,pay_per_minute,pay_per_mile,min_passengers,max_passengers,max_luggages)
values ('sedan','AVAILABLE',0,'Y','N','N','Y','5','3',0,0,0);
insert into vehicle (vehicle_type,vehicle_state,request_id,vehicle_avalible_2miles,vehicle_avalible_5miles,vehicle_shareable,vehicle_active,pay_per_minute,pay_per_mile,min_passengers,max_passengers,max_luggages)
values ('van','AVAILABLE',0,'Y','N','N','Y','5','3',0,0,0);
insert into vehicle (vehicle_type,vehicle_state,request_id,vehicle_avalible_2miles,vehicle_avalible_5miles,vehicle_shareable,vehicle_active,pay_per_minute,pay_per_mile,min_passengers,max_passengers,max_luggages)
values ('van','AVAILABLE',0,'Y','N','N','Y','5','3',0,0,0);
insert into vehicle (vehicle_type,vehicle_state,request_id,vehicle_avalible_2miles,vehicle_avalible_5miles,vehicle_shareable,vehicle_active,pay_per_minute,pay_per_mile,min_passengers,max_passengers,max_luggages)
values ('van','AVAILABLE',0,'Y','N','N','Y','5','3',0,0,0);
insert into vehicle (vehicle_type,vehicle_state,request_id,vehicle_avalible_2miles,vehicle_avalible_5miles,vehicle_shareable,vehicle_active,pay_per_minute,pay_per_mile,min_passengers,max_passengers,max_luggages)
values ('bus','AVAILABLE',0,'Y','N','N','Y','5','3',0,0,0);
insert into vehicle (vehicle_type,vehicle_state,request_id,vehicle_avalible_2miles,vehicle_avalible_5miles,vehicle_shareable,vehicle_active,pay_per_minute,pay_per_mile,min_passengers,max_passengers,max_luggages)
values ('bus','AVAILABLE',0,'Y','N','N','Y','5','3',0,0,0);
insert into vehicle (vehicle_type,vehicle_state,request_id,vehicle_avalible_2miles,vehicle_avalible_5miles,vehicle_shareable,vehicle_active,pay_per_minute,pay_per_mile,min_passengers,max_passengers,max_luggages)
values ('bus','AVAILABLE',0,'Y','N','N','Y','5','3',0,0,0);
insert into vehicle (vehicle_type,vehicle_state,request_id,vehicle_avalible_2miles,vehicle_avalible_5miles,vehicle_shareable,vehicle_active,pay_per_minute,pay_per_mile,min_passengers,max_passengers,max_luggages)
values ('sedan','AVAILABLE',0,'Y','N','Y','Y','5','3',0,0,0);

insert into vehicle (vehicle_type,vehicle_state,request_id,vehicle_avalible_2miles,vehicle_avalible_5miles,vehicle_shareable,vehicle_active,pay_per_minute,pay_per_mile,min_passengers,max_passengers,max_luggages)
values ('van','AVAILABLE',0,'Y','N','Y','Y','5','3',0,0,0);

insert into vehicle (vehicle_type,vehicle_state,request_id,vehicle_avalible_2miles,vehicle_avalible_5miles,vehicle_shareable,vehicle_active,pay_per_minute,pay_per_mile,min_passengers,max_passengers,max_luggages)
values ('bus','AVAILABLE',0,'Y','N','Y','Y','5','3',0,0,0);


INSERT INTO user_requests (member_id, request_pickup_loc, request_pickup_time, request_destination, request_state, request_shareable, request_type, request_sub_type, request_vehicle_type, request_no_passengers_travelling, request_no_luggages, request_flag) VALUES ('guest', 'Bunker Hill Lane, Santa Clara CA, 95054', '', 'San Jose State , San Jose CA, 95112', '', 'false', '', '', '', 1, 0, 'Y');


 