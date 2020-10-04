The application is build using Spring boot.
The application uses an embedded h2 database. 
Data is populated in the table using the data.sql file.

To run the application please use the following command from the root of the project:
mvn spring-boot:run

The url to get offer details:
http://localhost:8080/api/offers/AllOffers
http://localhost:8080/api/offers/reads/10001
http://localhost:8080/api/offers/create
http://localhost:8080/api/offers/cancel/10002



To Accept H2 DB Console, please use the following
URL 
http://localhost:8080/h2-console/

spring.datasource.url=jdbc:h2:mem:smartOffer
USERNAME : sa
Password :
<Password is Empty>







