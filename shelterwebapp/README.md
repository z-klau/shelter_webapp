# ShelterWebapp

Simple webapplication written in Java using among others Spring MVC/Security/Data, Hibernate, Tomcat Server and MySQL database to managing dogs in a shelter. It provides adding, reading, updating and deleting operations.

It works with following database properties: 

	DriverClassName("com.mysql.jdbc.Driver");
	Url("jdbc:mysql://localhost:3306/shelter_webapp");
	Username("root");
	Password("1234"); 
		
which can be modify here:

	/shelterwebapp/src/main/java/pl/shelterwebapp/configuration/PersistanceContext.java
	
	
The username and password required in application are "admin", "1111".
