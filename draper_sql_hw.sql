/*
 * SQL Lab
 * David Draper
 */

--1. SQL Queries

--1.1

select "EmployeeId", "LastName", "Email"
from "Employee" 
where "LastName"='King';
-- Single quotes denote Strings (VarChars). Double quotes seem to be required for tables & columns

select "City", "State"
from "Employee"
where "FirstName" = 'Andrew' and "ReportsTo" is null;
-- Made a mistake at first. Something doesn't equal null, it IS null

--1.2
select *
from "Album"
where "ArtistId" = (select "ArtistId" from "Artist" where "Name" = 'AC/DC');
--The part in parentheses is used to get the artist ID of the band,
--which is then used to find all albums by said artist in the Album table

--1.3
select *
from "Album"
order by "Title" desc;
--desc is the keyword for descending order

select "FirstName"
from "Customer"
order by "City" asc;
--asc is the keyword for ascending order

--1.6
select *
from "Invoice"
where "BillingAddress" like 'T%';
-- If I understand what's happening correctly,
--'%' represents any number of characters, this command
-- selects all BillingAdresses that begin with T

--1.7
select *
from "Invoice"
where "Total" between 15 and 50;
-- 'between' makes it so you only select
-- rows where the values in the given column fall
-- into the given range

select *
from "Employee"
where "HireDate" between '2003-06-01' and '2004-03-01';
-- Inclusion of Time stamp in date is optional.
-- Dates follow YYYY-MM-DD Format, read as a string

--2. DML Statements

--2.1
insert into "Genre"
values (26, 'Death Metal'), (27, 'Grindcore');
--Blocks within parentheses seperated by commas allow for multiple inputs in one insert
--Complete entries means a value for each columns

insert into "Employee"
values (9,'Draper','David','Cool Guy',1,'1997-09-23','2020-08-17','100 My Street','Boston','MA','USA','02357','+1-800-555-6789','+1-800-555-6789','david.draper@revature.net'),
	   (10,'Whaley','Jack','Cool Guy',9,'1998-08-11','2020-08-18','101 My Street','Boston','MA','USA','02357','+1-800-555-7000','+1-800-555-7000','jack.whaley@revature.net');
	  
insert into "Customer"
values (60,'David','Draper','Revature','1000 Java St.','Franklin','MA','USA','02038','+1 (900) 411-1234','+1 (900) 411-1234','ddraper@stonehill.edu',1),
	   (61,'Jack','Whaley','Not Revature','1000 Java St.','Franklin','MA','USA','02038','+1 (900) 411-1235','+1 (900) 411-1235','jwhaley@stonehill.edu',1);
	  

--2.2
update "Customer" 
set "FirstName" = 'Robert', "LastName" = 'Walter'
where "FirstName" = 'Aaron' and "LastName" = 'Mitchell';
-- Update changes the values in the table
update "Artist"
set "Name" = 'CCR'
where "Name" ='Creedence Clearwater Revival';

--2.3
-- Customers have Invoices that are dependent on them, and Invoices have InvoiceLines that are dependent on them
-- When trying to delete a customer entry, we run into errors because of these dependencies
-- The solution here is to refactor these foreign key constraints so that when a record with dependencies is deleted,
-- the dependents entry are deleted as well. This is what 'on delete cascade' achieves
alter table public."InvoiceLine" 
drop constraint "FK_InvoiceLineInvoiceId",
add constraint "FK_InvoiceLineInvoiceId" foreign key ("InvoiceId") references "Invoice"("InvoiceId") on delete cascade;


alter table public."Invoice" 
drop constraint "FK_InvoiceCustomerId",
add constraint "FK_InvoiceCustomerId" foreign key ("CustomerId") references "Customer"("CustomerId") on delete cascade;

delete from "Customer" 
where "FirstName" = 'Robert' and "LastName" = 'Walter';

--3. SQL Functions

--3.1
select current_time;

select length("Name")
from "MediaType";
-- length() finds the length of strings in the given column

--3.2
select avg("Total") from "Invoice";
-- avg averages the values within a given column

select max("UnitPrice" ) from "Track";
-- max finds the highest value within a given column

--3.3
--This function gets the average unit price of all records in invoiceline.
--It returns a floating point value, under the variable name 'avg_price'
create or replace function invoiceline_avg() returns float(1) as $avg_price$
	begin
		--Instead of selecting, we return the query here
		return avg("UnitPrice") from "InvoiceLine";
	end;
--I don't know what this does, I just know it needs to be here
--From my understanding, it just assures that the return value
--matches up with the database language
$avg_price$ language plpgsql;

--This calls our new function
select invoiceline_avg();

-- to return a table, you must set return type of a table with identical column values, which you set
-- as the query you want to return.
create or replace function get_employees() returns table(f1 int4, f2 varchar, f3 varchar, f4 varchar, f5 int4, f6 timestamp, f7 timestamp, f8 varchar, f9 varchar, f10 varchar, f11 varchar, f12 varchar, f13 varchar, f14 varchar, f15 varchar)
	as $$ select * from "Employee" where "BirthDate" > '1968-12-31'; $$
	language sql;

select * from get_employees();

--4. Triggers

--4.1
create or replace function set_number() returns trigger as $set_number$
	begin 
		update "Employee"
		set "Phone" = '867-5309'
		where "EmployeeId" = new."EmployeeId";--New is the inserted row, so we can update it but updating where the id is equals to new.id
		return new;
	end;
$set_number$ language plpgsql;

create trigger set_number --This trigger calls a function after a new row is inserted into the Employee table
after insert on "Employee"
for each row
execute function set_number();

insert into "Employee"
values (11,'Draper','David','Cool Guy',1,'1997-09-23','2020-08-17','100 My Street','Boston','MA','USA','02357','+1-800-555-6789','+1-800-555-6789','david.draper@revature.net');

delete from "Employee"
where "EmployeeId" > 10;

--4.2
create or replace function set_company() returns trigger as $set_company$
	begin
		new."Company" := 'Revature'; --We don't need to do the full query here, as we are modifying the entry BEFORE it is being entered
		return new;
	end
$set_company$ language plpgsql;

create trigger set_company
before insert on "Customer" --The before keyword changes our approach to the problem
for each row
execute function set_company();

insert into "Customer"
values (63,'Jack','Whaley','Not Revature','1000 Java St.','Franklin','MA','USA','02038','+1 (900) 411-1235','+1 (900) 411-1235','jwhaley@stonehill.edu',1);

delete from "Customer"
where "CustomerId" > 62;

--5. Joins

--5.1
--The tables are joined on their shared values, the Customer ID
--As an inner join, it only includes records that are complete (including both sides of the equation)
select "Customer"."FirstName", "Customer"."LastName", "Invoice"."InvoiceId" from "Customer" inner join "Invoice"
on "Customer"."CustomerId" = "Invoice"."CustomerId";

--5.2
--The tables are joined on their shared values, the Customer ID
--As a full outer join, it will include any records in either table.
--However, because an Invoice MUST have a customer attached to it, we don't see any records without a customer
select "Customer"."CustomerId", "Customer"."FirstName", "Customer"."LastName", "Invoice"."InvoiceId", "Invoice"."Total" from "Customer" full join "Invoice"
on "Customer"."CustomerId" = "Invoice"."CustomerId";

--5.3
--The tables are joined on their shared values, the Artist ID
--As a right join, it will include all entries in the right table (Artist)
--This is why we see artists without albums
select "Artist"."Name", "Album"."Title" from "Album" right join "Artist"
on "Album"."ArtistId" = "Artist"."ArtistId";

--5.4
--Cross join crosses every record of one table with another
--Effectively here we're multiplying each artist by how many artists there are
select "Artist"."Name" from "Album" cross join "Artist"
order by "Name" asc;

--5.5
--By joining a table with it self, we can connect entries
--that have a reference to another entry. The example here is connecting
--a given employee to the person they report to, showing the worker-boss relationship
select a."FirstName" as worker, b."FirstName" as boss
from "Employee" a join "Employee" b
on a."ReportsTo" = b."EmployeeId";

--6. Set Operations

--6.1
--we select the given columns from each table (All that matters is that the count is the same)
--The following display is one select followed by the other vertically
select "LastName", "FirstName","Phone" from "Employee"
union
select "LastName", "FirstName","Phone" from "Customer";

--6.2
--This except statement prevents us from selecting values in the employee table
--that are duplicates of values in the customer table
select "City","State","PostalCode" from "Customer"
except all
select "City","State","PostalCode" from "Employee";
