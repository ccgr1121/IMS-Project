# INVENTORY MANAGEMENT SYSTEM

This is a simple program which allows you to add, edit, update, and delete users, items and orders from a remote database.

## Description

This software is a java program which allows a user to interact with a MySQL database. It will allow you to
create, edit, view and delete customers, items or orders from a remote database.

It will also allow you to automatically create a .jar build of the project, using a fully automated CI process
involving a build tool, a test program, and an artifact repository.


Test analysis is currently at XX%.

## Getting Started

### Dependencies

*This software is best run on Windows 10, though could in theory be run on any OS.
*A java client is needed to use the software. This was built with Eclipse, but in theory any should work.
*An SQL server is needed for the database to run. The syntax used in this build is for MySQL.
*Maven will need to be installed, either on a remote machine or on your local machine.
*A Jenkins CI server needs to be utilised for the automatic building of .jar files.
*The software will run through Sonarqube for testing purposes.
*The software will deploy to Nexus.

### Installing

*To install this program, start by pulling the source folder and the pom.xml file from my Github.
*

### Executing program

*Once the installation is finished, press Ctrl+F11 to run the program.

*Enter in the commands that appear in the console to interact with the database. 
*You will first have a choice of selecting which table you wish to edit, and then which function you wish to run.

*Once this choice has been made, follow the onscreen commands to make your changes.

E.G. 
If I wanted to add a new customer to the database, I would first press Ctrl+F11 to run the software.
I would then enter in the word "customer" to tell the software to interact with the customer , and
the word "create" to tell the software that I wish to create a new entry.

Once I have done this, I would type in the first name of the new customer, followed by the last name.
The database would then automatically generate a unique ID for this customer, and add his or her details to the database.

## Software Build

If you wish to build your own .jar files from this software, you will need to run a build tool first.
Using the maven program you have already installed, you need to run the command 
```
mvn test
```

This will run a series of tests to ensure that your code not only compiles, but is adequately tested.

The easiest way to do this is to use Jenkins, or a similar build tool. When creating a new Jenkins build,
ensure that your Github repository is set in the configuration stage, and include 'mvn test' in the Build Execute Shell.

Underneath, you should include a reference to your sonarqube, which will test your code for bugs, vulnerabilities and
general mess. As of this build, the software is of a good quality, though any further changes made by the user
will need to be verified by the software. To achieve all this, simply add the following underneath:
```
mvn sonar:sonar -Dsonar.host.url=<your sonarqube url> -Dsonar.login=<your sonarqube login> -Dsonar.password=<your sonarqube password>  
```
This will allow you to investigate anything that is flagged up by Sonarqube.

Lastly, you should run the command
```
mvn delpoy
```

This will deploy the new .jar file to your nexus repository, which you will have defined in your pom.xml during the installation.


## Help


## Authors

Contributors names and contact info

Charlie Reddin
CharlieReddin@academytrainee.com

## Version History

* 0.1
    * Initial Release

## Acknowledgments

Chris, Rhys, and the whole trainer team at QA, who have been invaluable in their assisstence, dedication and generosity.
My classmates, who have been supportive and kind as we all approached D-Day.
James, who has admirably put up with my increasingly erratic ways as I worked on this.