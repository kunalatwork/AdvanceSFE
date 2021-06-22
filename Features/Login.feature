Feature: Login
Scenario Outline: Login into Advance SFE
Given User launch browser
And Enter url "<url>"
Then User Enter Email "<email>" and password "<password>"
And User click on login button


Examples:
 | url | email | password |
 | https://testingadvance.advancesfe.com/Home/Login | kunal.rawat@sia-digital.com | 123456789 |