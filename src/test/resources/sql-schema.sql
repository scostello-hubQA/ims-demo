create database if not exists imstest;
create table if not exists imstest.customers(customer_id int primary key auto_increment, first_name varchar(40), surname varchar(40));
create table if not exists imstest.items(item_id int primary key auto_increment, item_name varchar(40), price double (7,2), stock int not null default 0);
create table if not exists imstest.orders(order_id int primary key auto_increment, customer_id int not null, date_placed varchar(20) not null, foreign key (customer_id) references imstest.customers(customer_id));
create table if not exists imstest.orderline(orderline_id int primary key auto_increment, item_id int, order_id int, quantity int, foreign key(item_id) references imstest.items(item_id), foreign key(order_id) references imstest.orders(order_id));
