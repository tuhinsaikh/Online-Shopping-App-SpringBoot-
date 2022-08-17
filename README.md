# Online-Shoping-App-SpringBoot
Intro..
-----
This project is based on Online Shopping App using Java, Spring, SpringBoot, MySQL and Hibernate. There are 6 model classes in the project User, Customer, Address, Product, Cart and Order. The main goal of this project is to create a series of backend API’s so that the user can access the functionalities of the various types of functions of the models just like the functionalities one can get while shopping from any online website. This members responsible for the completion of this project are :

1. Tuhin Saikh  (User functionalities)
-----------

2. Animesh Roy (Customer functionalities)
-----------

3. Sampanna Chatterjee (Address functionalities)
-------------------

4. Sourav Dhawa (Order functionalities)
------------

5. Shubham Mishra (Cart functionalities)
--------------

6. Chandankumar Surendra Mourya (Product functionalities)
----------------------------

Entity Relationship Diagram
---------------------------

![Annotation 2022-08-17 114603](https://user-images.githubusercontent.com/101566519/185047965-4bca8f2f-a99b-42bb-98e9-ecd71934242e.png)

Tech Stacks & Tools Used 
------------------------

Tech Stacks:

1. Java

2. MySQL

3. Spring

4. SpringBoot

5. Hibernate

Tools:

1. Spring Tool Suite

2. Swagger

3. Postman

Classes under the Model package
-------------------------------

1. Address.java

2. User.java

3. Customer.java

4. MyOrder.java

5. Products.java

6. CategoryEnum

7. Cart.java

Some Endpoints to access the functionalities
--------------------------------------------

Link to Swagger: http://localhost:8088/swagger-ui/index.html#/

To register as a user:

http://localhost:8088/regisrtration

To login as a user:

http://localhost:8088/login

To add new products

http://localhost:8088/newproducts

To get customer

http://localhost:8088/{customerId}

To add products to cart:

http://localhost:8088/Cart/addtocart/{id}/{custId}

To get all address:

http://localhost:8088/getAll

THANK YOU 
---------




