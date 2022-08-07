 --4.Create a function that takes as inputs a SalesOrderID, a Currency Code, and a date, and returns a table of all the SalesOrderDetail rows 
--for that Sales Order including Quantity, ProductID, UnitPrice, and the unit price converted to the target currency based on the end of 
--day rate for the date provided. Exchange rates can be found in the Sales.CurrencyRate table. (Use AdventureWorks)

CREATE FUNCTION dbo.currencyExchange(
@SalesOrderId int,
@TargetCurrencyCode nchar(3),
@CurrencyRateDate DATETIME)
returns @outTable TABLE(
SalesOrderDetailID INT,
 OrderQty SMALLINT,
 ProductID INT,
 UnitPrice MONEY,
 UnitPriceConverted MONEY
 )
 AS
 BEGIN
 DECLARE @EndOfDayRate MONEY;
 select @EndOfDayRate=EndOfDayRate
 from Sales.CurrencyRate
 where CurrencyRateDate=@CurrencyRateDate
 AND ToCurrencyCode=@TargetCurrencyCode;
 insert @outTable
 SELECT SalesOrderDetailID,
 OrderQty,
 ProductID,
 UnitPrice,
 UnitPrice * @EndOfDayRate
 FROM Sales.SalesOrderDetail
 WHERE SalesOrderID = @SalesOrderID
 RETURN;
END
GO

SELECT *
FROM dbo.currencyEXchange(43659,'EUR','2005-07-05 00:00:00.000');

