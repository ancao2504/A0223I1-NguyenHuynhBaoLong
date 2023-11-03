
  create table position (
 id int primary key auto_increment

 );
  create table a(
 id int primary key auto_increment,
 position_id int,
 foreign key(position_id) references position (id)
 );
 
