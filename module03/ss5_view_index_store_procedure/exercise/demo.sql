create database if not exists demo;
use demo;

create table products (
id int primary key auto_increment,
product_code int,
product_name varchar(50),
product_price float,
product_amount int,
product_description text,
product_status varchar(20)
);

create unique index i_product_code on products(product_code);
create index i_name_price on  products(product_name, product_price);

-- view
create view v_product as
select product_code, product_name, product_price
from products;

alter view v_product as
select product_code, product_name, product_price
from products
where product_price > 20;

drop view v_product;

-- store procedure
DELIMITER //

CREATE PROCEDURE GetAllProducts()
BEGIN
	SELECT *  FROM products;
END //

DELIMITER ;

-- add
DELIMITER //
CREATE PROCEDURE add_new_product(in product_code int, in product_name varchar(50), in product_price float, in product_amount int, in product_status varchar(20) , in product_description text)
BEGIN
	insert into products ( product_code, product_name, product_price, product_amount, product_status,product_description)
    values (product_code, product_name, product_price, product_amount, product_status, product_description);
END //
DELIMITER ;

-- update
DELIMITER //
CREATE PROCEDURE update_by_id (in product_code int, in product_name varchar(50), in product_price float, in product_amount int, in product_status varchar(20) , in product_description text)
BEGIN
	update products
    set product_name = new_product_name,
        product_price = new_product_price,
        product_amount = new_product_amount,
        product_status = new_product_status,
        product_description = new_product_description
	where id = products.id;
END //
DELIMITER 

-- delete
DELIMITER //

CREATE PROCEDURE delete_by_id(in id int)
BEGIN
		delete from products
        where id = products.id;
END //
DELIMITER 