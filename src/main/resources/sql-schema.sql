create database if not exists ims;
create table if not exists ims.customers(customer_id int primary key auto_increment, first_name varchar(40), surname varchar(40));
create table if not exists ims.items(item_id int primary key auto_increment, item_name varchar(40), price double (7,2), stock int not null default 0);
create table if not exists ims.orders(order_id int primary key auto_increment, customer_id int not null, date_placed datetime default now(), foreign key (customer_id) references customers(customer_id)); 