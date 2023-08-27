use case_study;

select * from employee 
where (`name` like '%h%' or `name` like '%t%' or `name` like '%k%')
and length(`name`) <=15;

select * from employee 
where (year(now()) - year(day_of_birth) between 18 and 50) 
and (address = 'da nang' or address = 'quang tri');

