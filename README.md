#Ndigital - API Automation
This project is using serenity cucumber framework and using Rest Assured library to handling the API interaction

##Execution
 - To execute all of test cases, run command : `mvn clean verify`
 - To execute specific `Task 1` test case, run command : `mvn clean verify -Dtags="@Task1"`
 - To execute specific `Task 2` test case, run command : `mvn clean verify -Dtags="@Task2"`

##Reporting
The report automatically generated when test execution finished, check on : `target/site/serenity/index.html`