create database if not exists import_export;
use import_export;

create table supplier(
id varchar(20) primary key,
name varchar(255),
address varchar(255),
phone varchar(10)
);

create table `order` (
id_order int primary key,
`date` date,
supplier_id varchar(20),
foreign key (supplier_id) references supplier(id)
);

create table product(
id int primary key,
name varchar(50)
);

create table detail_order (
id_order int,
id_product int,
`date` date,
quantity int,
foreign key (id_order) references `order` (id_order),
foreign key (id_product) references product (id),
primary key(id_order,id_product)
);

create table export_bill (
id int primary key auto_increment,
`date` date
);

create table detail_export(
id_product int,
export_id int,
quantity int,
price float,
foreign key (export_id) references export_bill (id),
foreign key (id_product) references product (id),
primary key(export_id,id_product)
);

create table import_bill(
id int primary key auto_increment,
`date` date
);

create table detail_import(
id_product int,
import_id int,
quantity int,
price float,
foreign key (import_id) references import_bill (id),
foreign key (id_product) references product (id),
primary key(import_id,id_product)
);








