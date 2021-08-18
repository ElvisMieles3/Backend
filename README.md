# Automation Fronted
Automation Fronted

Starting 🦼 ✒️

With this project we want to carry out an automation for WEB services based on the SOLID and FIRST principles, for a better understanding of the reports, BDD, Cucumber and serenity are used with the Maven dependency manager.

Pre requirements 📋

For the execution of this project we must bear in mind that we must have the java JDK installed and the environment variables, which are:

JAVA_HOME: Download the Java JDK and attach the path where the folder is located, in my case I have it in C:\Program Files (x86)\Java\jdk1.8.0_251

MAVEN_HOME: Download Apache Maven and the path where the folder is located is attached, in my case I have it in C:\Program Files\apache-maven-3.6.3-bin\apache-maven-3.6.3
Have an IDE installed for observing or modifying the code..

In the project root we must have 3 files, which are:

serenity.properties

chromedriver.exe : This file must be compatible with the version of the machine..

Running the tests ⚙️

For the execution of the project, you must keep in mind that the environment variables are well configured, additionally you must have the downloaded dependencies which can be found in the pom.xml file.

The test can be run through the package runners, which is located in src\test\java\co\certificacion\automatizacion\runner or through the project console with the command

   mvn clean verify
   
Reporte 📋

To generate the evidence report, execute the command mvn serenity: agregate, the evidence of the evidence is found in the path Report \ site \ serenity and look for the Index file that is in the folder.