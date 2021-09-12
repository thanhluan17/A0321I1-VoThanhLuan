use classicmodels;

-- hien thi thong tin khach hang ten Atelier Graphique
select * from customers 
where customerName = 'Atelier Graphique';

-- hien thi thong tin khach hang co ten chua ky tu A
select * from customers
where customerName like '%A%';

-- hien thi thong tin khach hang co city thuoc Nantes, Las Vegas, Warszawa, NYC
select * from customers
where city in('Nantes', 'Las Vegas', 'Warszawa', 'NYC');

-- hien thi thong tin khach hang co 10100 < ordernumber < 10110 
select c.*, o.orderNumber from customers as c, orders as o
where c.customerNumber = o.customerNumber and orderNumber between 10100 and 10110;

-- hien thi thong tin khach hang co orderdate nho hon hoac bang 2003-03-03 va co status la shiper
select c.*, o.orderDate from customers as c, orders as o
where c.customerNumber = o.customerNumber and o.orderDate <= '2003-03-03' and o.status = 'Shipped';