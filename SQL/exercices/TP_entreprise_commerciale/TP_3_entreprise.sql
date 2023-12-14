USE classicmodels;

-- Question 1
SELECT 
    lastName, firstName, jobTitle
FROM
    employees
ORDER BY lastName;

-- Question 2
SELECT DISTINCT
    lastName
FROM
    employees;

-- Question 3
SELECT 
    customerName, contactFirstName, contactLastName
FROM
    customers
WHERE
    country = 'USA';

-- Question 4
SELECT 
    email
FROM
    employees
WHERE
    firstName LIKE '%y'
        AND reportsTo LIKE '105%';

-- Question 5
SELECT 
    lastName, email
FROM
    employees
WHERE
    firstName LIKE 'L%';

-- Question 6
SELECT 
    *
FROM
    customers
ORDER BY contactLastName;

-- Question 7
SELECT 
    *
FROM
    employees
ORDER BY officeCode;

-- Question 8
SELECT 
    customerNumber, customerName
FROM
    customers
        JOIN
    payments USING (customerNumber)
GROUP BY customerNumber
HAVING SUM(amount) > 100000;

-- Question 9
SELECT 
	orders.orderNumber,
    status,
    SUM(quantityOrdered * priceEach)
FROM
    orders
        JOIN
    orderdetails USING (orderNumber)
GROUP BY orderNumber
ORDER BY orderNumber AND status;

-- Question 10
SELECT 
    orderNumber, productName, MSRP, priceEach
FROM
    orderdetails
        JOIN
    products USING (productCode)
WHERE
    productCode = 'S10_1678'
        AND MSRP > priceEach;

-- Question 11
SELECT 
    email
FROM
    employees
        JOIN
    offices USING (officeCode)
WHERE
    firstName LIKE '%y'
        OR city = 'San Francisco';

-- Question 12
SELECT 
    COUNT(*) AS number_of_customers
FROM
    employees
        JOIN
    customers ON employeeNumber = salesRepEmployeeNumber
WHERE
    firstName = 'Leslie'
        AND lastName = 'Jennings';

-- Question 13
SELECT 
    lastName, firstName
FROM
    employees
WHERE
    jobTitle = 'President';

-- Question 14
SELECT 
    SUM(amount) AS somme_paiements
FROM
    payments
WHERE
    paymentDate LIKE '2005-03%';

-- Question 15
/*Pas bon*/
SELECT 
    SUM(amount) AS total_paiements
FROM
    payments
        JOIN
    customers USING (customerNumber)
GROUP BY customerName;
/**/

-- Question 16
SELECT 
    orderDate, customerNumber
FROM
    orders
WHERE
    status = 'Cancelled';

-- Question 17
SELECT 
    firstName, lastName
FROM
    employees
WHERE
    reportsTo = (SELECT 
            employeeNumber
        FROM
            employees
        WHERE
            lastName = 'Bow'
                AND firstName = 'Anthony');

-- Question 18
SELECT 
    lastName, firstName
FROM
    employees
WHERE
    reportsTo IS NULL;

-- Question 19
/*Pas bon*/
SELECT 
    *
FROM
    orderdetails
ORDER BY quantityOrdered
LIMIT 1;
/**/
-- Correction
SELECT 
    *
FROM
    orderdetails
WHERE
    orderdetails.quantityOrdered = (SELECT 
            MIN(quantityOrdered)
        FROM
            orderdetails);

-- Question 20
SELECT 
    *
FROM
    orders
        JOIN
    orderdetails USING (orderNumber)
WHERE
    orderDate = '2003-04-21';

-- Question 21
SELECT 
    CONCAT(managers.lastName,
            ' ',
            managers.firstName) AS Manager,
    CONCAT(subordinates.lastName,
            ' ',
            subordinates.firstName) AS 'Employée'
FROM
    employees AS managers
        JOIN
    employees AS subordinates
ON
    subordinates.reportsTo = managers.employeeNumber;

-- Question 22
SELECT 
    managers.lastName, COUNT(subordinates.employeeNumber)
FROM
    employees AS managers
        JOIN
    employees AS subordinates ON subordinates.reportsTo = managers.employeeNumber
GROUP BY managers.employeeNumber;