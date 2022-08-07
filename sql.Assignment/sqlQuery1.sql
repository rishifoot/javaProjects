
--1.Display the number of records in the [SalesPerson] table. (Schema(s) involved: Sales)

select count(*)as totalrecords from Sales.SalesPerson

--2.Select both the FirstName and LastName of records from the Person table where the FirstName begins with the letter ‘B’. 

select FirstName,LastName from Person.Person where FirstName like 'B%';

--3.Select a list of FirstName and LastName for employees where Title is one of Design Engineer, Tool Designer or Marketing 
--Assistant. (Schema(s) involved: HumanResources, Person)

select person.person.FirstName,
person.person.LastName,
HumanResources.Employee.JobTitle
from person.person
inner join HumanResources.Employee on(person.BusinessEntityID=HumanResources.Employee.BusinessEntityID)
where HumanResources.Employee.JobTitle='Design Engineer'or
HumanResources.Employee.JobTitle='Tool Engineer'or
HumanResources.Employee.JobTitle='Marketing Assiftant'

--4.Display the Name and Color of the Product with the maximum weight. (Schema(s) involved: Production)

select Name,color from Production.product
where Weight=(select max(Weight)from production.Product)

--5.Display Description and MaxQty fields from the SpecialOffer table. Some of the MaxQty values are NULL, in this case display 
--the value 0.00 instead. (Schema(s) involved: Sales)
 
 select Description,ISNULL(MaxQty,0.00) as MaxQty from Sales.SpecialOffer

 --6.Display the overall Average of the [CurrencyRate].[AverageRate] values for the exchange rate ‘USD’ to ‘GBP’ for the year 2005 
--i.e. FromCurrencyCode = ‘USD’ and ToCurrencyCode = ‘GBP’. Note: The field [CurrencyRate].[AverageRate] is defined as 
--'Average exchange rate for the day.' (Schema(s) involved: Sales)

select avg(AverageRate) as 'average for exchange rate' from sales.CurrencyRate
where FromCurrencyCode='USD'
and ToCurrencyCode='GBP'
and YEAR(currencyRateDate)=2005

--7.Display the FirstName and LastName of records from the Person table where FirstName contains the letters ‘ss’. Display an 
--additional column with sequential numbers for each row returned beginning at integer 1. (Schema(s) involved: Person)

select ROW_NUMBER() over(order by FirstName,LastName) as 'sr.no', FirstName,LastName from Person.Person
where FirstName like '%ss%'

--8.Sales people receive various commission rates that belong to 1 of 4 bands. (Schema(s) involved: Sales)
--Display the [SalesPersonID] with an additional column entitled ‘Commission Band’ indicating the appropriate band as above.
select BusinessEntityID as SalesPersonId,
case
     when commissionpct<=0.0 then 'Band 0'
     when commissionpct >0.0 and commissionpct<=0.01 then 'Band 1'
     when commissionpct >0.01 and commissionpct<=0.015 then 'Band 2'
     when commissionpct >0.015 then 'Band 3'
     end as 'commission band'
from sales.salesperson

--10.. Display the ProductId of the product with the largest stock level. Hint: Use the Scalar-valued function [dbo]. [UfnGetStock]. 
--(Schema(s) involved: Production)
select * from production.product
select max(dbo.ufnGetStock(productId))as'product id with largest stock level' from production.product
 
