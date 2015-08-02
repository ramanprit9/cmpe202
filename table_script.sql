
use cmpe202;

drop table if exists member_registration;
create table member_registration
(member_no INT NOT NULL AUTO_INCREMENT,
member_fname varchar(50),
member_lname varchar(50),
member_address1 varchar(50),
member_address2 varchar(50),
member_address3 varchar(50),
member_zip varchar(10),
member_type varchar(50),
member_card_number varchar(15),
member_card_type varchar(15),
member_id varchar(20),
member_pwd varchar(20),
PRIMARY KEY (member_no));


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
PRIMARY KEY (request_id));

drop table if exists dispatcher;
create table dispatcher
(dispatch_id INT NOT NULL AUTO_INCREMENT,
request_id integer,
dispatch_vehicle_type varchar(15),
dispatch_vehicle_number varchar(15),
dispatch_strategy_no integer,
PRIMARY KEY (dispatch_id,request_id));

drop table if exists communication;
create table communication
(communication_id INT NOT NULL AUTO_INCREMENT,
request_id integer,
communication_type varchar(20),
Communication_sent_to varchar(50),
Communication_message varchar(100),
PRIMARY KEY (communication_id,request_id));

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
license_num varchar (15),
vehicle_type varchar(15),
min_passengers integer, 
max_passengers integer,
max_luggages integer,
pay_per_hour varchar(15),
pay_per_mile varchar(15),
vehicle_state varchar(4),
vehicle_avalible_2miles varchar(1),
vehicle_avalible_5miles varchar(1),
vehicle_sharable varchar(1),
PRIMARY KEY (vehicle_id));

INSERT INTO user_requests (member_id, request_pickup_loc, request_pickup_time, request_destination, request_state, request_shareable, request_type, request_sub_type, request_vehicle_type, request_no_passengers_travelling, request_no_luggages, request_flag) VALUES ('guest', 'Bunker Hill Lane, Santa Clara CA, 95054', '', 'San Jose State , San Jose CA, 95112', '', 'false', '', '', '', 1, 0, 'Y');