create database models;
use models;
--
-- Table structure for table customers
--

DROP TABLE IF EXISTS customers;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE customers (
    customerNumber INT NOT NULL,
    customerName VARCHAR(50) NOT NULL,
    contactLastName VARCHAR(50) NOT NULL,
    contactFirstName VARCHAR(50) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    addressLine1 VARCHAR(50) NOT NULL,
    addressLine2 VARCHAR(50) DEFAULT NULL,
    city VARCHAR(50) NOT NULL,
    state VARCHAR(50) DEFAULT NULL,
    postalCode VARCHAR(15) DEFAULT NULL,
    country VARCHAR(50) NOT NULL,
    salesRepEmployeeNumber INT DEFAULT NULL,
    creditLimit DECIMAL(10 , 2 ) DEFAULT NULL,
    PRIMARY KEY (customerNumber),
    KEY salesRepEmployeeNumber (salesRepEmployeeNumber),
    CONSTRAINT customers_ibfk_1 FOREIGN KEY (salesRepEmployeeNumber)
        REFERENCES employees (employeeNumber)
)  ENGINE=INNODB DEFAULT CHARSET=LATIN1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table employees
--

DROP TABLE IF EXISTS employees;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE employees (
    employeeNumber INT NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    firstName VARCHAR(50) NOT NULL,
    extension VARCHAR(10) NOT NULL,
    email VARCHAR(100) NOT NULL,
    officeCode VARCHAR(10) NOT NULL,
    reportsTo INT DEFAULT NULL,
    jobTitle VARCHAR(50) NOT NULL,
    PRIMARY KEY (employeeNumber),
    KEY reportsTo (reportsTo),
    KEY officeCode (officeCode),
    CONSTRAINT employees_ibfk_1 FOREIGN KEY (reportsTo)
        REFERENCES employees (employeeNumber),
    CONSTRAINT employees_ibfk_2 FOREIGN KEY (officeCode)
        REFERENCES offices (officeCode)
)  ENGINE=INNODB DEFAULT CHARSET=LATIN1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table offices
--

DROP TABLE IF EXISTS offices;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE offices (
    officeCode VARCHAR(10) NOT NULL,
    city VARCHAR(50) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    addressLine1 VARCHAR(50) NOT NULL,
    addressLine2 VARCHAR(50) DEFAULT NULL,
    state VARCHAR(50) DEFAULT NULL,
    country VARCHAR(50) NOT NULL,
    postalCode VARCHAR(15) NOT NULL,
    territory VARCHAR(10) NOT NULL,
    PRIMARY KEY (officeCode)
)  ENGINE=INNODB DEFAULT CHARSET=LATIN1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table orderdetails
--

DROP TABLE IF EXISTS orderdetails;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE orderdetails (
    orderNumber INT NOT NULL,
    productCode VARCHAR(15) NOT NULL,
    quantityOrdered INT NOT NULL,
    priceEach DECIMAL(10 , 2 ) NOT NULL,
    orderLineNumber SMALLINT NOT NULL,
    PRIMARY KEY (orderNumber , productCode),
    KEY productCode (productCode),
    CONSTRAINT orderdetails_ibfk_1 FOREIGN KEY (orderNumber)
        REFERENCES orders (orderNumber),
    CONSTRAINT orderdetails_ibfk_2 FOREIGN KEY (productCode)
        REFERENCES products (productCode)
)  ENGINE=INNODB DEFAULT CHARSET=LATIN1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table orders
--

DROP TABLE IF EXISTS orders;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE orders (
    orderNumber INT NOT NULL,
    orderDate DATE NOT NULL,
    requiredDate DATE NOT NULL,
    shippedDate DATE DEFAULT NULL,
    status VARCHAR(15) NOT NULL,
    comments TEXT,
    customerNumber INT NOT NULL,
    PRIMARY KEY (orderNumber),
    KEY customerNumber (customerNumber),
    CONSTRAINT orders_ibfk_1 FOREIGN KEY (customerNumber)
        REFERENCES customers (customerNumber)
)  ENGINE=INNODB DEFAULT CHARSET=LATIN1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table payments
--

DROP TABLE IF EXISTS payments;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE payments (
    customerNumber INT NOT NULL,
    checkNumber VARCHAR(50) NOT NULL,
    paymentDate DATE NOT NULL,
    amount DECIMAL(10 , 2 ) NOT NULL,
    PRIMARY KEY (customerNumber , checkNumber),
    CONSTRAINT payments_ibfk_1 FOREIGN KEY (customerNumber)
        REFERENCES customers (customerNumber)
)  ENGINE=INNODB DEFAULT CHARSET=LATIN1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table productlines
--

DROP TABLE IF EXISTS productlines;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE productlines (
    productLine VARCHAR(50) NOT NULL,
    textDescription VARCHAR(4000) DEFAULT NULL,
    htmlDescription MEDIUMTEXT,
    image MEDIUMBLOB,
    PRIMARY KEY (productLine)
)  ENGINE=INNODB DEFAULT CHARSET=LATIN1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table products
--

DROP TABLE IF EXISTS products;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE products (
    productCode VARCHAR(15) NOT NULL,
    productName VARCHAR(70) NOT NULL,
    productLine VARCHAR(50) NOT NULL,
    productScale VARCHAR(10) NOT NULL,
    productVendor VARCHAR(50) NOT NULL,
    productDescription TEXT NOT NULL,
    quantityInStock SMALLINT NOT NULL,
    buyPrice DECIMAL(10 , 2 ) NOT NULL,
    MSRP DECIMAL(10 , 2 ) NOT NULL,
    PRIMARY KEY (productCode),
    KEY productLine (productLine),
    CONSTRAINT products_ibfk_1 FOREIGN KEY (productLine)
        REFERENCES productlines (productLine)
)  ENGINE=INNODB DEFAULT CHARSET=LATIN1;

