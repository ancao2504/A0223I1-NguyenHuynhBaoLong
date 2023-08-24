create database if not exists product_management;
use product_management;

create table orderer(
orderer_id int primary key,
`name` varchar(50),
address varchar(255) default 'Da Nang',
`date` date,
phone_number varchar(10) 
);

create table product(
product_id int primary key,
name_product varchar(255),
unit varchar(50),
detail text
);

create table office (
product_id int,
orderer_id int,
primary key(product_id,orderer_id),
quantity int,
`date` date
);

create table customer (
customer_id int primary key,
`name` varchar(255),
address varchar(50),
`date` date
);