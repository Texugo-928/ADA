--Antes de executar essas queries, execute o arquivo Northwind.sql

USE Northwind;

--Visualizando as tabelas:
--Categories, CustomerCustomerDemo, CustomerDemographics, Customers, Employees,
--EmployeeTerritories, [Order Details], Orders, Products, Region, Shippers,
--Suppliers, Territories

SELECT * FROM Categories;
SELECT * FROM CustomerCustomerDemo;
SELECT * FROM CustomerDemographics;
SELECT * FROM Customers;
SELECT * FROM Employees;
SELECT * FROM EmployeeTerritories;
SELECT * FROM [Order Details];
SELECT * FROM Orders;
SELECT * FROM Products;
SELECT * FROM Region;
SELECT * FROM Shippers;
SELECT * FROM Suppliers;
SELECT * FROM Territories;

--Trabalhando com essas funções:
--MIN(), MAX(), COUNT(*), SUM(), AVG(), HAVING

SELECT COUNT(*) AS quantidade_linhas_categories FROM Categories;
SELECT COUNT(*) AS quantidade_linhas_customercustomerdemo FROM CustomerCustomerDemo;
SELECT COUNT(*) AS quantidade_linhas_customerdemographics FROM CustomerDemographics;
SELECT COUNT(*) AS quantidade_linhas_customers FROM Customers;
SELECT COUNT(*) AS quantidade_linhas_employees FROM Employees;
SELECT COUNT(*) AS quantidade_linhas_employeeterritories FROM EmployeeTerritories;
SELECT COUNT(*) AS quantidade_linhas_order_details FROM [Order Details];
SELECT COUNT(*) AS quantidade_linhas_orders FROM Orders;
SELECT COUNT(*) AS quantidade_linhas_products FROM Products;
SELECT COUNT(*) AS quantidade_linhas_region FROM Region;
SELECT COUNT(*) AS quantidade_linhas_shippers FROM Shippers;
SELECT COUNT(*) AS quantidade_linhas_suppliers FROM Suppliers;
SELECT COUNT(*) AS quantidade_linhas_territories FROM Territories;


SELECT MAX(UnitPrice) AS valor_maximo FROM [Order Details];
SELECT MIN(UnitPrice) AS valor_minimo FROM [Order Details];
SELECT AVG(UnitPrice) AS valor_medio FROM [Order Details];
SELECT SUM(UnitPrice) AS valor_da_soma FROM [Order Details];
SELECT SUM(UnitPrice)/COUNT(*) AS valor_medio FROM [Order Details];



