create table product(
id int auto_increment primary key,
name varchar(255),
price double,
color varchar(255),
`description` varchar(255),
category_id int,
foreign key (category_id) references category(id)
);
create table category (
id int primary key auto_increment,
name varchar(255)
);