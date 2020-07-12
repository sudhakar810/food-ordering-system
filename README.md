# food-ordering-system
Spring Boot and REST API

## Overview
This project is done using Spring Boot web application 

## Run the Application
## Prerequistes
1. Install Eclipse/STS
2. Start PostGreSqp
3. Use foodordering backup file available in resource folder,import in postGres and run the database

### PsotGres DataBase Connection
In the folder src/main/resources/application.properties, config your database url, username and password correctly.
### Start the Application
1. Import project as maven project
2. When the dependencies specified in the file pom.xml are automatically downloaded , run the application.
3. right click on FoodOrderingApp.java clas and run as Java Application 
3. use Postman collection Json end-points available in  in src/main/resources/Food-Ordering-System.postman_collection.json
4. import Food-Ordering-System.postman_collection.json file in Postman 
5. test all available APIs end-points

## EndPoints
####Restaurant Service APIs
####first Login and generate the jwtToken and pass it to each api call
1. POST- http://localhost:8080/restaurants/login 
2. GET - http://localhost:8080/restaurants/logout
3. GET - http://localhost:8080/restaurants/getOrders/{restaurantId}<br />
			 example:http://localhost:8080/restaurants/getOrders/res1 
4. GET - http://localhost:8080/restaurants/printInvoice/{restaurantId}<br />
			  example:	http://localhost:8080/restaurants/printInvoice/res1

####Customer Service APIs
1. POST - http://localhost:8080/customer/login
2. GET - http://localhost:8080/customer/logout
3. GET - http://localhost:8080/customer/findRestaurant
4. GET - http://localhost:8080/customer/getMenuItem/{restaurantId}<br />
		example: http://localhost:8080/customer/getMenuItem/res1
5. POST - http://localhost:8080/customer/foodOrder   

####Driver Service APIs
1. POST - http://localhost:8080/driver/login
2. GET - http://localhost:8080/driver/logout
3. GET - http://localhost:8080/driver/getOrderInfo/{restaurantId} <br />
		http://localhost:8080/driver/getOrderInfo/res1
4. PUT - http://localhost:8080/driver/updateOrderInfo/{orderId}/{pickedUp} <br />
		example:http://localhost:8080/driver/updateOrderInfo/1273700145/true
5. PUT - http://localhost:8080/driver/updateDeliveryStatus/{orderId}/{delivered}<br />
		 example: http://localhost:8080/driver/updateDeliveryStatus/1273700145/true


## Testing
Unit tests are not written because of time constraint. But, POSTMAN is used to test all end-points.

