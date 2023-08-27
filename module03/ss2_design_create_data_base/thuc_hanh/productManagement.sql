create database if not exists product_management;
use product_management;

create table customer (
customer_id int primary key,
`name` varchar(255),
age int
);

create table `order`(
order_id int primary key,
`date` date,
total_price float,
customer_id int,
foreign key(customer_id) references customer(customer_id)
);

create table product(
product_id int primary key,
name_product varchar(255),
price float
);

create table order_detail(
order_id int,
product_id int,
foreign key(order_id) references `order`(order_id),
foreign key(product_id) references product(product_id),
primary key(order_id, product_id)
);



