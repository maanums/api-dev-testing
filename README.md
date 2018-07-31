# Customer on-boarding Application

Welcome to Customer On-boarding Application API dev-testing!

This repository contains code for mocking the APIs and testing those APIs.

## Contents
### COA 

Code for the mock APIs. Developed using Spring Boot.
   1. **POST API** - provides customization of the fields, views, sub views, customer details etc. to be saved as JSON.
   2. **GET API** - provides customer information based on the given customer ID.
   
### coa-testing 

Code for validating the APIs. Developed using Cucumber and Rest Assured combination. 
Please find the test scenarios in the [Wiki](https://github.com/maanums/api-dev-testing/wiki/Test-Scenarios-for-API-testing) page.

To get started follow below steps:

1. Clone/download the project: `git clone https://github.com/maanums/api-dev-testing.git`.
2. Dependencies: JDK 8 or above, Eclipse, Maven, TentNg plugin for Eclipse, Cucumber plugin for Eclipse (optional).
3. Open command prompt in project's root directory.
4. Change the directory to COA to start the application: `cd COA`.
5. Build application using Maven: `mvn clean install`.
6. Start the application: `mvn spring-boot:run`.
7. Now Application will be started in port `8080` and ready for testing.
8. Import maven project coa-testing into Eclipse IDE (or any IDE of your choice).
9. Right click on project. Select `Run as -> Maven build` and enter the goal as `clean install`.
10. Select *testng.xml* file present in project root path and run as `TestNg Suite`.
11. *tesng.xml* file internally picks Cucumber feature files from Test Runner class present in com.coa.runner package.
12. Tag `@COATest` is used to execute all GET and POST requests with both Success and Failure scenarios.
13. Change the tag to `@Get`,`@Post`,`@Success`,`@Failure` etc. based on the requirement.
14. To generate the Cucumber report, right click on project `Run as -> Maven build` and goal as `mvn verify`.
15. Please find the generated HTML reports in the path: `<project_root_path>\target\cucumber-reports\advanced-reports\cucumber-html-reports`.
