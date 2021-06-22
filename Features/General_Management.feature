Feature: General Management
Scenario: Add Role,Add Geography & Add franchises
Given User launch browser
And Enter url "https://testingadvance.advancesfe.com/Home/Login"
Then User Enter Email "kunal.rawat@sia-digital.com" and password "123456789"
And User click on login button
Then Select Company Logo and add product
Then Add Role name and Select Role type
Then Add Geography and franchises
Then fill user detail and map with franchises
And Select model according franchises and User
