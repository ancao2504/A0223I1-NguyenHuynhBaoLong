create database quan_ly_diem_thi;
use quan_ly_diem_thi;
create table hoc_sinh(
MaHS varchar(20) primary key,
TenHS varchar(50),
NgaySinh date,
Lop varchar(20),
GT varchar(20)
);

create table mon_hoc(
MaMH varchar(20) primary key,
TenMH varchar(50)
);

create table bang_diem(
MaHS varchar(20),
MaMH varchar(20),
DiemThi int,
NgayKT datetime,
foreign key (MaHS) references hoc_sinh(MaHS),
foreign key (MaMH) references mon_hoc(MaMH)
);

create table giao_vien(
MaGV varchar(20) primary key,
TenGV varchar(50),
SDT varchar(10)
);
alter table mon_hoc add MaGV varchar(20);
alter table mon_hoc add constraint FK_MaGV foreign key (MaGV) references giao_vien(MaGV);
select * from bang_diem;