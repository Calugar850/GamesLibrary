# GamesLibrary
This application is a game library, where user can buy games.
At first commit exist 4 packeges (for controllers, for services, for repositories, and for models).
I realized the connection with database.
Services pack contains the logic for operation on database.
Model pack contains the model for database.
Repositories pack contains the interface for accesing the database.
Controllers pack contains the controller which map the operation executed on db.

At a second commit the project was update with junit tests for the majority of the classes from this project.
  First pack which was introduced was data which contain a single class (ReadData). This class was created with the purpose to implement CRUD operation for a table in case of lost connection with database and connection can't be restabilshed for a period of time.
  
  The second pack, FactoryPattern contain 5 classes, 1 abstract class, 1 enum and 1 interface. This files consist in a basic implementation of factory pattern, to be more exactly is an example. Factory pattern is one of the most used design patterns in Java. This type of design pattern comes under creational pattern as this pattern provides one of the best ways to create an object. In Factory pattern, we create object without exposing the creation logic to the client and refer to newly created object using a common interface. For this implementation we have an abstract class which extends 3 other classes for different type of people who has an acces in a building. In every class was override zile method. Also we have en enum with every type of person, and a class with a single method (to create a type of person based of value of enum parameter). also we have an interface and a class wihich to implements an interface for eample of implementation of factory pattern with interface, because this pattern can be implemented with an abstract class or an interface.
  
