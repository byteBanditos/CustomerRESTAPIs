create schema customer_db_local;

create table customer(
id int not null auto_increment,
first_name varchar(40),
last_name varchar(40),
email varchar(40),
phone varchar(15),
created_at datetime,
updated_at datetime,
primary key (id)
);



create table customer_login(
id int not null auto_increment,
user_name varchar(50) not null,
password varchar(50) not null,
last_sign_in datetime,
customer_id int,
created_at datetime,
updated_at datetime,
primary key(id),
foreign key(customer_id) references customer(id)
);



create table billing_address(
id int not null auto_increment,
address1 varchar(30),
address2 varchar(30),
city varchar(20),
state varchar(20),
zip_code varchar(12),
customer_id int,
primary key (id),
foreign key (customer_id)  references customer(id)
);