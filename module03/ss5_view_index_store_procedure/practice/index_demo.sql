USE `classicmodels`;
explain select * from customers where customerName='Land of Toys Inc.';
alter table customers add index i_customer_name(customerName);
explain select * from customers where customerName='Land of Toys Inc.';