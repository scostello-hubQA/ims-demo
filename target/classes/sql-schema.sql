create database if not exists ims;
create table if not exists ims.customers(customer_id int primary key auto_increment, first_name varchar(40), surname varchar(40));
create table if not exists ims.items(item_id int primary key auto_increment, item_name varchar(40), price double (7,2), stock int not null default 0);
create table if not exists ims.orders(order_id int primary key auto_increment, customer_id int not null, date_placed varchar(20) not null, foreign key (customer_id) references ims.customers(customer_id));
create table if not exists ims.orderline(orderline_id int primary key auto_increment, item_id int, order_id int, quantity int, foreign key(item_id) references ims.items(item_id), foreign key(order_id) references ims.orders(order_id));
