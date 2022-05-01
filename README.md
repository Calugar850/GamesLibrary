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
  
  In model pack was added an enum type, an interface, a class to create a type of user, this files was added for factory pattern implementation, also every type of user represent a table in our database. The main difference between this 3 type of users consist into a value of discount applied at every purchase which they do.
  
  The repository packet contain now 6 interfaces, 2 of them was added for accesing PremiumUser table and AdminUser table. And the last Repository interface was added for implementation when the conncection with database it's lost and it can't be restored for a while.
  
  The controllers and services packs contains the same number of files. In UserController was implemented a login functionality, adding and removing a game for a cart and generate a final bill for specific user, and the method for CRUD operations was modified for executing opearions on only type of users table.The BillController was added a method for create a bill for an user with the final value. The GameController can retrieve a list of games based on a filter, was created 3 filter, based on publisher of the game, year when was released and type of game.The services layer implements same method of the controllers layer, but here the data are retrieved form tables.
  
  In the test folder was created 4 packages, 1 for every layer of the projects. In controllers folder was testing all method from every conroller. In user controllers some methods was tested for every type of users. In services folder the testing was executed for every method and some method which is specified for an user was tested for every type of user. In respository folder was tested only 5 of 6 repository because only this is used in project. Here was tested the main opeartion, findAll, findById, deleteById and save. In modelTest exist only a class because the testing for models was implemted in only a file. I consider to do this because the majority of methods consist in getters and setters.
  
  
  
