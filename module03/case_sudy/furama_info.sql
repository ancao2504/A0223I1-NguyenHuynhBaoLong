use case_study;

insert into `level` (`name`) 
values ('trung cap'),
	   ('cao dang'),
	   ('dai hoc'),
	   ('sau dai hoc');

insert into `position` (`name`) 
values ('le tan'),
	   ('phuc vu'),
	   ('chuyen vien'),
	   ('giam sat'),
	   ('quan ly'),
	   ('giam doc');
       
insert into part (`name`) 
values ('sale - marketing'),
	   ('hanh chinh'),
	   ('phuc vu'),
	   ('quan ly');
       
insert into employee (`name`, day_of_birth, employee_code, salary, phone_number, email, address, position_id, level_id, part_id ) 
values ('le huu hoang', '2000-03-01', '1234567890',120, '0912346789',null,'h02/9 van cao', 1,1,1),
	   ('ho huu hau', '2000-03-10', '1234567890',120, '0912346789',null,'h02/9 van cao', 2,2,2),
	   ('nguyen long', '2004-04-13', '1234567800',10, '0912346789',null,'h02/9 van cao', 3,3,3);
       
insert into employee (`name`, day_of_birth, employee_code, salary, phone_number, email, address, position_id, level_id, part_id ) 
values ('pham xuan dieu', '1992-03-01', '1234567890',120, '0912346789',null,'da nang', 1,1,1),
	   ('duong van quan', '1998-03-01', '1234567890',120, '0912346789',null,'da nang', 3,2,1),
	   ('nguyen tam dac', '2002-03-12', '1234567890',120, '0912346789',null,'quang tri', 3,2,1);
       
insert into employee (`name`, day_of_birth, employee_code, salary, phone_number, email, address, position_id, level_id, part_id ) 
values ('pham xuan dieu', '1992-03-01', '1234567890',120, '0912346789',null,'da nang', 1,1,1),
	   ('pham xuan dieu', '1998-03-01', '1234567890',120, '0912346789',null,'da nang', 3,2,1),
	   ('nguyen tam dac', '2002-03-12', '1234567890',120, '0912346789',null,'quang tri', 3,2,1);
       
insert into type_customer (name_type_customer) 
values('diamond'),
	  ('platinum'),
	  ('gold'),
	  ('silver'),
	  ('member');
      

insert into type_service (name_type_service)
values('villa'),
		('house'),
		('room');

insert into customer (name_customer, day_of_birth, gender, customer_code, phone_number, email, address, type_customer_id)
values('nguyen thi hong dao', '2004-04-10', 0, '09012345612', '0901239871', null, 'quang ngai',1),
		('nguyen my kiem', '1999-03-11', 1, '09012345612', '0901239871', null, 'ho chi minh',1),
		('nguyen  kiem', '1989-03-15', 0, '09012345612', '0901239871', null, 'ho chi minh',4),
		('nguyen my ', '1989-03-11', 1, '09012345612', '0901239871', null, 'Vt',2),
		('ho son duong', '1993-08-12', 0, '09012345612', '0901239871', null, 'da lat',3),
		('ho son duong', '1993-08-12', 0, '09012345612', '0901239871', null, 'da lat',5);
        
insert into accompanied_service (name_accompanied_service, price, measure, `status`) 
values ('massage', 30, null,'open'),
		('karaoke', 20, null,'open'),
		('thức ăn', 15,null,'open'),
		('nước uống', 15, null,'open'),
		('thuê xe', 40, null,'open');

insert into service (name_service, rental_fee, max_people, standard_room, `description`, area_pool, floor, free_service, rental_type_id, type_service_id) 
values('villa view beach',2000, 12,'normal', null, 125, 3, null, 6, 1),
		('house',2000, 12,'big', null, 125, 3, null, 2, 2),
		('Room twin 01',2000, 12,'normal', null, 125, 3, null, 1, 3);

insert into contract (start_contract, end_contract, advance_deposit, employee_id, customer_id, service_id)
values ('2020-06-01', '2020-06-04', 1000, 3,5,4),       
		('2020-03-01', '2020-03-04', 2000, 2,4,5),       
		('2021-06-01', '2020-06-04', 3000, 3,1,6),       
		('2021-06-01', '2020-06-04', 3000, 3,1,4),       
		('2022-01-01', '2020-01-04', 5000, 3,2,5),           
		('2022-01-01', '2020-01-04', 5000, 3,3,6);    
       
insert into contract (start_contract, end_contract, advance_deposit, employee_id, customer_id, service_id)
values ('2021-03-01', '2021-03-04', 1000, 3,5,4),       
		('2021-01-01', '2021-01-04', 2000, 2,4,5);
        
insert into contract (start_contract, end_contract, advance_deposit, employee_id, customer_id, service_id)
values ('2020-10-01', '2021-10-04', 1000, 3,6,4),       
		('2021-11-01', '2021-11-04', 2000, 2,4,5);
        
insert into detail_contract (quantity, contract_id, accompanied_service_id )
values (1,7,4),
		(2,8,5),
		(3,9,5),
		(4,8,1);
        

insert into detail_contract (quantity, contract_id, accompanied_service_id )
values (5,7,4),
		(4,8,5),
		(19,9,5),
		(1,8,1);
              
insert into detail_contract (quantity, contract_id, accompanied_service_id )
values (5,10,4),
		(4,12,null);


insert into detail_contract (quantity, contract_id, accompanied_service_id )
values (5,15,2),
		(4,16,3);
        
insert into rental_type (name_rental_type) 
values('dai han'),
	  ('ngan han');

 insert into rental_type (name_rental_type) 
values('nguyen can');

update detail_contract
set quantity =null 
where detail_contract_id =26;

update contract
set start_contract = '2020-11-01'
where contract_id =16;

update contract
set advance_deposit = null
where contract_id =14;

alter table detail_contract
modify column quantity int default 0;
set sql_safe_updates = 0;
delete from rental_type ;
