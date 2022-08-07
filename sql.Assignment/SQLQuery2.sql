use AdventureWorks2008R2
--2.Write separate queries using a join, a subquery, a CTE, and then an EXISTS to list all AdventureWorks customers who have not placed 
--an order.
--using join
select * from Sales.Customer 
left join Sales.SalesOrderHeader on
SalesOrderHeader.CustomerID=Customer.CustomerID
where SalesOrderHeader.SalesOrderID is null;

 --using cte
with s as
(
select *
from Sales.SalesOrderHeader
)
select * from Sales.Customer
left join s on Customer.CustomerID=s.CustomerID
where s.SalesOrderID is null;

--using subqueries

select * from Sales.Customer
where Customer.CustomerID not in(select  SalesOrderHeader.CustomerId from Sales.SalesOrderHeader)
--where SalesOrderHeader.SalesOrderID is null);


--3.Show the most recent five orders that were purchased from account numbers that have spent more than $70,000 with 
--AdventureWorks.
SELECT TOP 5 SalesOrderID AS 'Order ID',
	   OrderDate AS 'Date Of Order',
	   AccountNumber AS 'Account Number',
	   SUM(TotalDue) AS 'Amount Spent'
FROM Sales.SalesOrderHeader
GROUP BY AccountNumber,
		 OrderDate,
		 SalesOrderID
HAVING SUM(TotalDue) > 70000
ORDER BY OrderDate DESC;
  
 
