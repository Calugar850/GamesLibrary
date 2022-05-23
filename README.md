# GamesLibrary
This application is a game library, where users can buy games.
At first commit exist 4 packages (for controllers, for services, for repositories, and for models).
I realized the connection with the database.
The Service pack contains the logic for operation on the database.
Model pack contains the model for the database.
Repositories pack contains the interface for accessing the database.
Controllers pack contains the controller which maps the operation executed on db.

At a second commit the project was updated with junit tests for the majority of the classes from this project.
  First pack which was introduced was data which contained a single class (ReadData). This class was created with the purpose to implement CRUD operation for a table in case of lost connection with database and connection can't be established for a period of time.
  
  The second pack, FactoryPattern contain 5 classes, 1 abstract class, 1 enum and 1 interface. This files consist in a basic implementation of factory pattern, to be more exactly is an example. Factory pattern is one of the most used design patterns in Java. This type of design pattern comes under creational pattern as this pattern provides one of the best ways to create an object. In Factory pattern, we create object without exposing the creation logic to the client and refer to newly created object using a common interface. For this implementation we have an abstract class which extends 3 other classes for different types of people who have access in a building. In every class was override zile method. Also we have en enum with every type of person, and a class with a single method (to create a type of person based of value of enum parameter). also we have an interface and a class which to implements an interface for example of implementation of factory pattern with interface, because this pattern can be implemented with an abstract class or an interface.
  
  In the model pack was added an enum type, an interface, a class to create a type of user, this files was added for factory pattern implementation, also every type of user represents a table in our database. The main difference between these 3 types of users consist of a value of discount applied at every purchase which they do.
  
  The repository packet now contains 6 interfaces, 2 of them were added for accessing PremiumUser table and AdminUser table. And the last Repository interface was added for implementation when the connection with the database it's lost and it can't be restored for a while.
  
  The controllers and service packs contain the same number of files. In UserController was implemented a login functionality, adding and removing a game for a cart and generate a final bill for specific user, and the method for CRUD operations was modified for executing operations on only type of users table.The BillController was added a method for create a bill for an user with the final value. The GameController can retrieve a list of games based on a filter, was created 3 filter, based on publisher of the game, year when was released and type of game.The services layer implements the same method of the controllers layer, but here the data are retrieved form tables.
  
  In the test folder was created 4 packages, 1 for every layer of the projects. In controllers folder was testing all methods from every controller. In user controllers some methods was tested for every type of user. In services folder the testing was executed for every method and some method which is specified for an user was tested for every type of user. In repository folder was tested only 5 of 6 repositories because only this is used in the project. Here was tested the main operation, findAll, findById, deleteById and save. In modelTest exists only a class because the testing for models was implemented in only a file. I consider to do this because the majority of methods consist in getters and setters.
  
  For visualization of the ERD Diagram and UML Diagram this diagram is in the project folder under the names: ERD_DataBase_Diagram.pdf (ERD Diagram)  and UML_Class_Diagram.pdf (UML Diagram). Also you can see right here.


![image](https://user-images.githubusercontent.com/72302669/166143342-448cd8a2-b280-4216-9b31-54145475f711.png)

![image](https://user-images.githubusercontent.com/72302669/166143351-dadd1cd4-0c39-4b17-b127-4fd844976fc0.png)

  
# Games Library Frontend
  
  For this part of the project, an android app was creted for frontend development. The programming language in which app was written it's kotlin, and in the project we have 16 files, which represents activities for app, model class, data class and the interface for communication with the backend which was develop in java spring. This part of the project was pushed into another commit (here is the link: https://github.com/Calugar850/GamesLibraryFrontend) because this part was developed in android studio.
  
  Firstly we have 3 data class for mapping the data comes from the request. This 3 class are: User, Bill, Game2. Also we have 2 class for creating game object and user object for sending a POST or a PUT request. This class are UserFactory and Game. For identify a type of user in the project exist an enum class with all type of users (BaseUser, PremiumUser, AdminUser).
  
  For make an API request we have an interface (ApiInterface) where we have mapped all the necesarry requests for a normal behaviour of the app. In this interface exist 10 request witch retrieve data from and put data into database.

  For display the list of games to user and the buttons to add in cart and delete the game from list we have an adapter class GameAdapter which is responsible to create a new object of this type and display it.
  
  At the final we have 8 activities to develop application (UserDetailsActivity, RegisterActivity, MainActivity, FirstActivity, CreateGameActivity, CreateBillActivity, BillActivity, CompleteOrderActivity). RegisterActivity, CreateGameActivity, CreateBillActivity represent a form page to create a bill, create a game and register an user. This form create object and sending to database where wil be stored. UserDetailsActivity represent an activity where are displayed some data about user, this page works like a profile page. The user can se the username, email address, address, list of the games in library and list of all the bills. MainActivity consist in login page and validate the data which was introduced by user of the application. BillActivity is a page where you can see the game you added in the cart, and you can finish the order by pressing one button, and you will be redirect to CompletOrderActivity where a message wil be displayed for confirmation of the achisition you done. FirstActivity is the most important activity, here you can sort the games by publishers, or year of release and gen, you can see all the games from database and add to cart. You can navigate to bettween pages.
