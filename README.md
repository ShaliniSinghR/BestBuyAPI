TestAPI

This test suite is build using cucumber, gradle, java, HTTP Client lib to automate API responses and Json Assert to compare the json responses.

The detail description and usage is highlighted below:

1. Resources folder under src/main contains feature file with all the scenarios to test the GET API and create a new object in the DB using POST API.
2. Resources folder also contains a properties file to read request payload for POST calls.
3. In the main folder the whole project is divided as :
        
        
        a. main folder containing DTO/POJO objects to render objects in run time 
        
        b. Stepdefinition class contains the implementation of .feature file
        
        c. TestRunner is the class from where you can run the test suit directly. This can also be executed using run symbol shown at indiviual feature file. 
        
        d. APIBase class contains logic to execute GET/POST call using HTTP Client
         
        e. JSONIgnoreAttribute class contains custom implementation if you wish to ignore few tags while comparing the two json O/Ps 
        
        f. StoredReports Folder under root directory is used to compare the json for differences and displaying them. For example, for one test case ABC -> two .json files 
        will be created ABC_set1.json and ABC_set2.json and once generated these files will be put to comparison for differences. This is being achieved using JSON assert Lib.

 
    
