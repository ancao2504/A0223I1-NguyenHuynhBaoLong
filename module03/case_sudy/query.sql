use case_study;

-- 2
select * from employee 
where (`name` like '%h%' or `name` like '%t%' or `name` like '%k%')
and length(`name`) <=15;

-- 3
select * from employee 
where (year(now()) - year(day_of_birth) between 18 and 50) 
and (address = 'da nang' or address = 'quang tri');

-- 4
select count(c.customer_id) as so_lan, name_customer 
from customer c
join type_customer tc on c.type_customer_id = tc.type_customer_id
join contract ct on c.customer_id = ct.customer_id
where tc.name_type_customer = 'diamond'
group by c.customer_id, name_customer
order by so_lan;

-- 5 
select c.customer_id, c.name_customer, tc.name_type_customer, ct.contract_id, ct.start_contract, ct.end_contract, s.name_service,  s.rental_fee + (dct.quantity * acs.price) AS total
from customer c
join type_customer tc on c.type_customer_id = tc.type_customer_id
left join contract ct on c.customer_id = ct.customer_id
left join service s on ct.service_id = s.service_id
left join detail_contract dct on ct.contract_id = dct.contract_id
left join accompanied_service acs on dct.accompanied_service_id = acs.accompanied_service_id;

-- 6
select s.service_id, s.name_service, s.area, s.rental_fee, ts.name_type_service
 from service s
 join type_service ts on s.type_service_id = ts.type_service_id
 where s.service_id not in (
select ct.service_id 
from contract ct 
join service s on ct.service_id = s.service_id
where month(ct.start_contract) in (1,2,3) 
and year(ct.start_contract) in(2021)
);

-- 7
select s.service_id, s.name_service, s.area, s.max_people, s.rental_fee, tc.name_type_service
from service s
join type_service tc on s.type_service_id = tc.type_service_id
where s.service_id in (
select s.service_id 
from service s
join contract ctr on s.service_id = ctr.service_id
where year(ctr.start_contract)='2020' )
and
s.service_id not in (
select s.service_id 
from service s
join contract ctr on s.service_id = ctr.service_id
where year(ctr.start_contract)='2021'
);


-- 8
select distinct(name_customer) 
from customer ;

select name_customer 
from customer
group by name_customer;

-- 9 
select count((ct.start_contract)) as thong_ke, month( ct.start_contract) as thang
from contract ct 
join customer c on ct.customer_id = c.customer_id
where year(ct.start_contract) = 2021
group by (ct.start_contract);

-- 10 
select ct.contract_id, ct.start_contract, ct.end_contract, ct.advance_deposit, SUM( dct.quantity) as so_luong
from accompanied_service acc 
right join detail_contract dct on acc.accompanied_service_id = dct.accompanied_service_id
left join contract ct on ct.contract_id = dct.contract_id
group by  ct.contract_id, ct.start_contract, ct.end_contract, ct.advance_deposit;

-- 11 
select acc.accompanied_service_id as ma_dich_vu_di_kem, acc.name_accompanied_service as dich_vu_di_kem,  c.name_customer,ctr.contract_id
from accompanied_service acc 
join detail_contract dct on acc.accompanied_service_id = dct.accompanied_service_id
join contract ctr on dct.contract_id = ctr.contract_id
join customer c on c.customer_id = ctr.customer_id 
join type_customer tc on c.type_customer_id = tc.type_customer_id 
where tc.name_type_customer ='diamond' and (c.address ='quang ngai' or c.address ='vinh');

-- 12
select ctr.contract_id, e.`name`, c.name_customer, c.phone_number, s.name_service, ctr.advance_deposit
from service s
join contract ctr on ctr.service_id = s.service_id
join customer c on ctr.customer_id = c.customer_id
join employee e on ctr.employee_id = e.employee_id
join detail_contract dct on ctr.contract_id = dct.contract_id
join accompanied_service acc on dct.accompanied_service_id = acc.accompanied_service_id
where month(ctr.start_contract) in (10,11,12) and  year(ctr.start_contract) ='2020' 
and s.service_id not in (
select s.service_id
from service s
join contract ctr on ctr.service_id = s.service_id
join detail_contract dct on ctr.contract_id = dct.contract_id
join accompanied_service acc on dct.accompanied_service_id = acc.accompanied_service_id
where month(ctr.start_contract) in (1,2,3,4,5,6)
 and  year(ctr.start_contract) ='2021'
);

-- 13
select acc.accompanied_service_id, acc.name_accompanied_service, acc.price, acc.`status`, count(acc.accompanied_service_id) as so_lan_su_dung
from accompanied_service acc
join detail_contract dct on acc.accompanied_service_id = dct.accompanied_service_id
join contract ctr on dct.contract_id = ctr.contract_id
group by acc.accompanied_service_id, acc.name_accompanied_service, acc.price, acc.`status`
having so_lan_su_dung = all (select count(acc.accompanied_service_id) from accompanied_service acc );

SET @@sql_mode = SYS.LIST_DROP(@@sql_mode, 'ONLY_FULL_GROUP_BY');
SELECT @@sql_mode;

-- 14
select ctr.contract_id, tc.name_type_service , acc.name_accompanied_service, count(dct.accompanied_service_id) as quantity
from accompanied_service acc
join detail_contract dct on dct.accompanied_service_id = acc.accompanied_service_id
join contract ctr on ctr.contract_id = dct.contract_id
join service s on s.service_id = ctr.service_id
join type_service tc on tc.type_service_id = s.type_service_id
group by acc.accompanied_service_id
having quantity=1 ;

-- 15
select e.employee_id, e.`name`, e.phone_number, p.`name`, e.address, count(e.employee_id) as quantity
from employee e
join position p on p.position_id = e.position_id
join contract ctr on ctr.employee_id = e.employee_id
where year(ctr.start_contract) between 2020 and 2021
group by e.employee_id
having quantity <= 3;

-- 16 (xóa nhân viên chưa lập được hợp đồng từ 2019 tới 2021)

SET SQL_SAFE_UPDATES = 0;
delete from employee 
where employee.employee_id not in(
select contract.employee_id
from contract 
where year(contract.start_contract) between 2019 and 2021
group by contract.employee_id
);
SET SQL_SAFE_UPDATES = 1;

-- 17 (Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet) s.rental_fee + (dct.quantity * acs.price) AS total
update customer 
set customer.type_customer_id =1
where customer.type_customer_id =2 
and customer.customer_id in (
	select temp.customer_id
    from(
    select c.customer_id
	from customer c
	join type_customer tc on c.type_customer_id = tc.type_customer_id
	 join contract ct on c.customer_id = ct.customer_id
	 join service s on ct.service_id = s.service_id
	 join detail_contract dct on ct.contract_id = dct.contract_id
	 join accompanied_service acs on dct.accompanied_service_id = acs.accompanied_service_id
	and year(ct.start_contract) = 2021
    and c.type_customer_id =2
	and  (s.rental_fee + (dct.quantity *  acs.price))  >2100 
    ) as temp
);

-- 18
delete from contract 
where year(contract.start_contract) < 2021 ;

-- 19
SET SQL_SAFE_UPDATES = 0;
update accompanied_service
set accompanied_service.price =accompanied_service.price *2
where  accompanied_service.accompanied_service_id in (
select temp.accompanied_service_id
from(
	select acc.accompanied_service_id
	from accompanied_service acc 
	join detail_contract dct on dct.accompanied_service_id = acc.accompanied_service_id
	join contract ctr on ctr.contract_id = dct.contract_id
	where year(ctr.start_contract) = 2020
	group by acc.accompanied_service_id, acc.name_accompanied_service,price
	having sum(dct.quantity)  >=10 
	) as temp
);
SET SQL_SAFE_UPDATES = 1;

-- 20 
select c.customer_id as id, c.name_customer as `name`, c.email as email, c.phone_number as phone_number, c.day_of_birth as date_of_birth, c.address as address
from customer c
union 
select e.employee_id, e.`name`, e.email, e.phone_number, e.day_of_birth , e.address
from employee e;


-- 21
create view v_employee as
select e.*
from employee e
join contract ctr on ctr.employee_id = e.employee_id
where ctr.start_contract ='2019-12-12';





