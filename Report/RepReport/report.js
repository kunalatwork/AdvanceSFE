$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./Features/Rep.feature");
formatter.feature({
  "line": 1,
  "name": "Sales Model Management",
  "description": "",
  "id": "sales-model-management",
  "keyword": "Feature"
});
formatter.before({
  "duration": 11936549500,
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
  "name": "User Enter Email \"QASales@gmail.com\" and password \"123456789\"",
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "User click on login button",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Select Company Logo",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "Choose model",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "Select Graph ploter and select required data",
  "keyword": "Then "
});
formatter.match({
  "location": "RepSteps.user_launch_browser()"
});
formatter.result({
  "duration": 696449100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "https://testingadvance.advancesfe.com/Home/Login",
      "offset": 11
    }
  ],
  "location": "RepSteps.enter_url(String)"
});
formatter.result({
  "duration": 4359426500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "QASales@gmail.com",
      "offset": 18
    },
    {
      "val": "123456789",
      "offset": 51
    }
  ],
  "location": "RepSteps.user_Enter_Email_and_password(String,String)"
});
formatter.result({
  "duration": 2567421800,
  "status": "passed"
});
formatter.match({
  "location": "RepSteps.user_click_on_login_button()"
});
formatter.result({
  "duration": 93690500,
  "status": "passed"
});
formatter.match({
  "location": "RepSteps.select_Company_Logo()"
});
formatter.result({
  "duration": 10626204900,
  "status": "passed"
});
formatter.match({
  "location": "RepSteps.choose_model()"
});
formatter.result({
  "duration": 4002740600,
  "status": "passed"
});
formatter.match({
  "location": "RepSteps.select_Graph_ploter_and_select_required_data()"
});
formatter.result({
  "duration": 4664032900,
  "status": "passed"
});
});