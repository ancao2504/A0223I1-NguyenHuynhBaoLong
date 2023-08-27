use product_management;

alter table order_detail add quantity int;

insert into customer (customer_id, `name`, age ) 
values(1, 'minh quan', 10),
	   (2, 'ngoc oanh', 20),
	   (3, 'hong ha', 50);
	
insert into `order` (order_id, customer_id, `date`, total_price ) 
values(1,1,'2006-03-21',null), 
	  (2,2,'2006-03-23',null), 
	  (3,1,'2006-03-15',null); 
      
insert into product (product_id, name_product, price)
values (1,'may giat', 3),
		(2,'tu lanh', 5),
		(3,'dieu hoa', 7),
		(4,'quat', 1),
		(5,'bep dien', 2);
        
insert into order_detail (order_id, product_id,  quantity)
values (1,1,3),
		(1,3,7),
		(1,4,2),
		(2,1,1),
		(3,1,8),
		(2,5,7),
		(2,2,3);
        
select order_id, `date`, total_price from `order`;

select p.name_product,c.`name` from product p
join order_detail od on p.product_id = od.product_id
join `order` o on od.order_id = o.order_id
 join customer c on c.customer_id = o.customer_id;


SELECT c.`name`
FROM customer c
LEFT JOIN `order` o ON c.customer_id = o.customer_id
LEFT JOIN order_detail od ON o.order_id = od.order_id
WHERE od.product_id IS NULL;

select o.order_id, o.`date`, p.price * od.quantity as total_price 
from `order` o 
join order_detail od on o.order_id = od.order_id
join product p on od.product_id = p.product_id; 
