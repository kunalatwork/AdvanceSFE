Feature: LRC Management and Audit trail 
Scenario: Select Date Range, Show limit and Seach data
Given User launch browser
And Enter url "https://testingadvance.advancesfe.com/Home/Login"
Then User Enter Email "kunal.rawat@sia-digital.com" and password "123456789"
And User click on login button
Then Select Company Logo and Select LRC Management
Then select Parent and topic
Then Language and upload file 
And add URL
Then click on audit trail
And Seach data according date