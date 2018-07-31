# api-dev-testing

Welcome to Customer Onboarding Application API dev-testing !

This repository contains code for mocking API and testing those API's

1. COA - Code for Mocking API : Developed using Spring boot
   1. Post API - Which provides customization of the fields, views, sub views, customer details.. etc to be saved as JSON
   2. GET API - Which provides customer information based on the given customer Id
   
2. coa-testing - Code for validating the APIs : Developed using Cucumber and Rest Assured combination
  (Please find the test scenarios in Wiki Page)

To get started follow below steps!

1. Clone/download the project ( git clone https://github.com/maanums/api-dev-testing.git)
2. Make sure JDK is installed in your machine
3. Open command prompt in project's root directory
4. Change the directory to COA to start the application - Use "CD COA"
5. Build application using "mvn clean install"
6. Start the application using "mvn spring-boot:run"
7. Now Application will be started in port 8080 and ready for testing
8. Import maven project coa-testing into Eclipse IDE/any IDE used for JAVA
9. Select project-Run as- Maven build and goal as "clean install"
10. Select testng.xml file present in project root path and run as TestNg Suite
11. tesng.xml file internally picks cucumber feature files from Test Runner class present in com.coa.runner package
12. Tag "@COATest" is used to execute all Get and Post requests with both Success and Failure scenarios
13. Change the tag to @Get/@Post/@Success/@Failure based on the requirement
14. To generate the cucumber report, select the project-Run as-Maven build and goal as "mvn verify"
15. Please find the genearted HTML reports in the path : <project root path>\target\cucumber-reports\advanced-reports\cucumber-html-reports
