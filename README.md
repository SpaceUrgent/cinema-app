# Cinema-app

Application example that supports authentication, registration and CRUD operations.
Manage cinema by adding new movies, movie sessions, adding cinema halls.
With registering new user the shopping cart linked to user will be created. 
After login as user add movie sessions to shopping cart and create orders to purchase tickets. <br />
<sub>(to familiarize with detailed entities relations, please, refer to chart below)
</sub>

# Application functionality

- registration 
- authentication 
- add/get cinema hall;
- add/get movie
- add/get/get all by date movie sessions;
- add session to shopping cart;
- complete order after adding sessions to shopping cart;
- get order history for user

# Technologies used:

- Java 11
- MySQL
- Hibernate
- HQL
- Maven

# To install the app:

1) Clone the project to your machine 
2) Download MySQL and MySQL Workbench
3) In src/main/resources/hibernate.cfg.xml insert properties:
- hibernate.dialect &rarr; hibernate dialect (ex. "org.hibernate.dialect.MySQL8Dialect");
- connection.url &rarr; url of schema in MySQL database;
- connection.driver_class &rarr; (ex. com.mysql.cj.jdbc.Driver);
- connection.username &rarr; username according to DB settings;
- connection.password &rarr; password according to DB settings;
- show_sql &rarr; true to see queries executed by hibernate in console;
- hbm2ddl.auto &rarr; hibernate strategy of shema generation (recommended: "create-drop")
4) After configuring all stated before you can simply test the functionallity in Main class using psvm.

### Model structure 
![pic](Cinema_chart.png)
