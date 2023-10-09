create database if not exists case_study;
use case_study;

create table position (
position_id int primary key auto_increment,
`name` varchar(45)
);

create table `level` (
level_id int primary key auto_increment,
`name` varchar(45)
);

create table part (
part_id int primary key auto_increment,
`name` varchar(45)
);

create table employee (
employee_id int primary key auto_increment,
`name` varchar(45),
day_of_birth date,
employee_code varchar(45),
salary double,
phone_number varchar(45),
email varchar(45),
address varchar(45),
position_id int,
level_id int,
part_id int,
foreign key(position_id) references position (position_id),
foreign key(level_id) references `level` (level_id),
foreign key(part_id) references part (part_id)
);

create table type_customer (
type_customer_id int primary key auto_increment,
name_type_customer varchar(45)
);

create table customer (
customer_id int primary key auto_increment,
name_customer varchar(45),
day_of_birth date,
gender bit(1),
customer_code varchar(45),
phone_number varchar(45),
email varchar(45),
address varchar(45),
type_customer_id int,
foreign key(type_customer_id) references type_customer(type_customer_id)
);




create table type_service (
type_service_id int primary key auto_increment,
name_type_service varchar(45)
);

create table rental_type (
rental_type_id int primary key auto_increment,
name_rental_type varchar(45)
);

create table service (
service_id int primary key auto_increment,
name_service varchar(45),
area int,
rental_fee double,
max_people int,
standard_room varchar(45),
`description` varchar(45),
area_pool double,
floor int,
free_service text,
rental_type_id int,
type_service_id int,
foreign key (rental_type_id) references rental_type (rental_type_id),
foreign key (type_service_id) references type_service (type_service_id)
);

create table contract (
contract_id int primary key auto_increment,
start_contract datetime,
end_contract datetime, 
advance_deposit double,
employee_id int,
customer_id int,
service_id int,
foreign key (employee_id) references employee (employee_id),
foreign key (customer_id) references customer (customer_id),
foreign key (service_id) references service (service_id)
);

create table accompanied_service (
accompanied_service_id int primary key auto_increment,
name_accompanied_service varchar(45),
price double,
measure varchar(45),
`status` varchar (45)
);

create table detail_contract (
detail_contract_id int primary key auto_increment,
quantity int,
contract_id int,
accompanied_service_id int,
foreign key (accompanied_service_id) references accompanied_service (accompanied_service_id),
foreign key (contract_id) references contract (contract_id)
);
-- create table detail_customer (
-- customer_id int primary key auto_increment,
-- name_customer varchar(45),
-- day_of_birth date,
-- gender bit(1),
-- customer_code varchar(45),
-- phone_number varchar(45),
-- email varchar(45),
-- address varchar(45),
-- type_customer_id int,
-- foreign key(type_customer_id) references type_customer(type_customer_id),
-- foreign key(type_customer_id) references type_customer(type_customer_id),

-- );


delimiter //
create procedure customer_are_using()
begin
select c.* ,s.service_id,ts.type_service_id,a.accompanied_service_id from customer c
join type_customer tc on c.type_customer_id = tc.type_customer_id
join contract ctr on ctr.customer_id = c.customer_id
join service s on s.service_id = ctr.service_id
join type_service ts on ts.type_service_id = s.type_service_id
join rental_type rt on rt.rental_type_id = s.rental_type_id
join detail_contract dc on dc.contract_id = ctr.contract_id
join accompanied_service a on a.accompanied_service_id = dc.accompanied_service_id;
end //
delimiter //
call customer_are_using();

