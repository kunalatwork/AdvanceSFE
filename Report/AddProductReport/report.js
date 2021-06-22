$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./Features/Sales_Model_Management.feature");
formatter.feature({
  "line": 1,
  "name": "Sales Model Management",
  "description": "",
  "id": "sales-model-management",
  "keyword": "Feature"
});
formatter.before({
  "duration": 20506081600,
  "status": "passed"
});
formatter.scenario({
  "line": 2,
  "name": "Add All fields of Sales Model Management",
  "description": "",
  "id": "sales-model-management;add-all-fields-of-sales-model-management",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 3,
  "name": "User launch browser",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "Enter url \"https://testingadvance.advancesfe.com/Home/Login\"",
  "keyword": "And "
});
formatter.step({
  "line": 5,
  "name": "User Enter Email \"kunal.rawat@sia-digital.com\" and password \"123456789\"",
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "User click on login button",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Select Company Logo and add Catagory",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "Add compentency Element and Add Element",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "Add Assignment option and Catagory Element Mapping",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "Add model and Scale factory",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "All model group and view mapping",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "check Model Managament",
  "keyword": "And "
});
formatter.match({
  "location": "AdminSteps.user_launch_browser()"
});
formatter.result({
  "duration": 912261200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "https://testingadvance.advancesfe.com/Home/Login",
      "offset": 11
    }
  ],
  "location": "AdminSteps.enter_url(String)"
});
formatter.result({
  "duration": 5555864700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "kunal.rawat@sia-digital.com",
      "offset": 18
    },
    {
      "val": "123456789",
      "offset": 61
    }
  ],
  "location": "AdminSteps.user_Enter_Email_and_password(String,String)"
});
formatter.result({
  "duration": 3290322700,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.user_click_on_login_button()"
});
formatter.result({
  "duration": 160429200,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.select_Company_Logo_and_add_Catagory()"
});
formatter.result({
  "duration": 14716707100,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.add_compentency_Element_and_Add_Element()"
});
formatter.result({
  "duration": 15521959500,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.add_Assignment_option_and_Catagory_Element_Mapping()"
});
formatter.result({
  "duration": 22526063500,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.add_model_and_Scale_factory()"
});
