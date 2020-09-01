/*
 * This file is used to set up the DataBase Structure for Project 0 Part 2
 */

-- Define Tables
create table customers (
	customerid serial primary key,
	firstname varchar(12),
	lastname varchar (24)
);


create table accounts (
	accountid serial primary key,
	balance float(1),
	customerid int
);

create table transactions (
	transactionid serial primary key,
	transactiontype varchar(12),
	amount float(1),
	accountid int
);

create table logins(
	username varchar(12) primary key,
	lastname varchar(24),
	usertype varchar(12),
	customerid int
);

-- Set Constraints
alter table accounts
add constraint fk_account_customer
foreign key (customerid) references customers(customerid) on delete cascade;

alter table transactions
add constraint fk_transaction_account
foreign key (accountid) references accounts(accountid) on delete cascade;

alter table logins
add constraint fk_login_customer
foreign key (customerid) references customers(customerid) on delete cascade;

-- Add data
insert into logins values ('davemd', 'admin1', 'Admin', null);