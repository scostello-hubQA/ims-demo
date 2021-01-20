Coverage: 76.1% on src/main/java  
# Inventory Management System

This is a simple database that enables the user to connect to at local MySQL server (currently) and to perform basic  
CRUD funtions through the use of a CLI. 

This project allowed me to experience several new and different technologies such as IDE's, build tools, version control and programming languages. 

The project document folder contains my daily updates to certain files, such as the risk assessment and the jira board, as well as my presentation in .pdf format. 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

1. **_Step one_** You can fork and clone this to your local computer  
2. **_Step two_** Open the project in your IDE as a Maven project  
3. **_Step three_** You will need to change the JDBCconnection url
### Prerequisites

What things you need to install the software and how to install them

```
* Java JRE
* Eclipse or other IDE
* Maven 
* Git Bash
```

### Installing

A step by step series of examples that tell you how to get a development env running

Say what the step will be

```
Give the example
```

And repeat

```
until finished
```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

Explain how to run the automated tests for this system. Break down into which tests and what they do

### Unit Tests 

Unit testing tests individual parts of the program to check they are correct

```
Each of the classes have its own respective partner in the src/test/java folder  
If you wish to run the tests:
*Right click on the class in the test folder
 *Then 'run as' 
  *Then 'JUnit test'  
```

### Integration Tests 
This pulls the unit tests together to test the behaviours between the individual units;

```
Give an example
```

### And coding style tests

Here we have SonarQube, this tests the viability of our whole source code.  
It gives us a break down of 'code smells', 'vunerability', 'Bugs' and 'Security Hotspots'. 

```
Give an example
```

## Deployment

Once the repo has been forked/cloned,
1. open a CLI in the folder where the project is located
2. Run the ```mvn clean```
3. This has removed the target folder, now you want to run ```mvn package``` to create the jar file
4. After this you can see the targt folder is back run ```cd target```
5. In order to run the program ```java -jar sam-ims-0.0.1-jar-with-dependencies.jar``` _tab will also autocomplete_
## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Vinesh 
* Aswene
* Nick
