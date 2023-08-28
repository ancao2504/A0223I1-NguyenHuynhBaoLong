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
group by c.customer_id, name_customer;

-- 5 
select c.customer_id, c.name_customer, tc.name_type_customer, ct.contract_id, ct.start_contract, ct.end_contract, s.name_service,  s.rental_fee + (dct.quantity * acs.price) AS tong_tien
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
-- select s.service_id, s.name_service, s.area, s.max_people, s.rental_fee, ts.name_type_service
-- from service s
-- join type_service ts on s.type_service_id = ts.type_service_id
-- left join contract ct on  ct.service_id = s.service_id
-- where year(ct.start_contract)  in(2020) and  year(ct.start_contract) not in(2021)
-- and s.service_id not in (
-- select ct.service_id 
-- from contract ct 
-- join service s on ct.service_id = s.service_id
-- and year(ct.start_contract) in(2021)
-- );

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


select ctr.contract_id, e.`name` as ten_nhan_vien ,c.name_customer, c.phone_number, s.name_service, ctr.advance_deposit, sum(dct.quantity)
from contract ctr
left join employee e on ctr.employee_id = e.employee_id
left join customer c on ctr.customer_id = c.customer_id
left join service s on ctr.service_id = s.service_id
left join detail_contract dct on dct.contract_id = ctr.contract_id
left join accompanied_service acc on dct.accompanied_service_id = acc.accompanied_service_id
where month(start_contract) in (10,11,12) and year(start_contract)=2020 and ctr.advance_deposit is not null
group by ctr.contract_id, e.`name` ,c.name_customer, c.phone_number, s.name_service, ctr.advance_deposit

