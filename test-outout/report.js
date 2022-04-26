$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("aLogIn.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: mauli.baraskar@cognizant.com"
    }
  ],
  "line": 4,
  "name": "User LogIn",
  "description": "",
  "id": "user-login",
  "keyword": "Feature",
  "tags": [
    {
      "line": 3,
      "name": "@tag"
    }
  ]
});
formatter.scenario({
  "line": 7,
  "name": "User LogIn scenario",
  "description": "",
  "id": "user-login;user-login-scenario",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 6,
      "name": "@SmokeTest"
    },
    {
      "line": 6,
      "name": "@RegressionTest"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "User LogIn on BeCognizant",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "user enters username",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "clicks on next button",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "user enters password",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "user click on signIn button",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "selects verify with call option",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "clicks on sign button",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "page title is BeCognizant",
  "keyword": "Then "
});
formatter.match({
  "location": "LogInFeature.user_LogIn_on_BeCognizant()"
});
formatter.result({
  "duration": 7471596200,
  "status": "passed"
});
formatter.match({
  "location": "LogInFeature.user_enters_username()"
});
formatter.result({
  "duration": 3114074300,
  "status": "passed"
});
formatter.match({
  "location": "LogInFeature.clicks_on_next_button()"
});
formatter.result({
  "duration": 1427193700,
  "status": "passed"
});
formatter.match({
  "location": "LogInFeature.user_enters_password()"
});
formatter.result({
  "duration": 309266200,
  "status": "passed"
});
formatter.match({
  "location": "LogInFeature.user_click_on_signIn_button()"
});
formatter.result({
  "duration": 1021586200,
  "status": "passed"
});
formatter.match({
  "location": "LogInFeature.selects_verify_with_call_option()"
});
formatter.result({
  "duration": 269689800,
  "status": "passed"
});
formatter.match({
  "location": "LogInFeature.clicks_on_sign_button()"
});
formatter.result({
  "duration": 36905602000,
  "status": "passed"
});
formatter.match({
  "location": "LogInFeature.page_title_is_BeCognizant()"
});
formatter.result({
  "duration": 13052200,
  "status": "passed"
});
formatter.uri("bHomePage.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: mauli.baraskar@cognizant.com"
    }
  ],
  "line": 4,
  "name": "User validation and Time sheet search",
  "description": "",
  "id": "user-validation-and-time-sheet-search",
  "keyword": "Feature",
  "tags": [
    {
      "line": 3,
      "name": "@tag"
    }
  ]
});
formatter.scenario({
  "line": 7,
  "name": "User validation",
  "description": "",
  "id": "user-validation-and-time-sheet-search;user-validation",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 6,
      "name": "@SmokeTest"
    },
    {
      "line": 6,
      "name": "@RegressionTest"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "User should be on BeCognizant page",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "user should have logIn successfully",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "click on search box",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "search for timesheet",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "select ESATimesheet",
  "keyword": "And "
});
formatter.match({
  "location": "HomePageFeature.user_should_be_on_BeCognizant_page()"
});
formatter.result({
  "duration": 232603900,
  "status": "passed"
});
formatter.match({
  "location": "HomePageFeature.user_should_have_logIn_successfully()"
});
formatter.result({
  "duration": 908338000,
  "status": "passed"
});
formatter.match({
  "location": "HomePageFeature.click_on_search_box()"
});
formatter.result({
  "duration": 31903700,
  "status": "passed"
});
formatter.match({
  "location": "HomePageFeature.search_for_timesheet()"
});
formatter.result({
  "duration": 234444200,
  "status": "passed"
});
formatter.match({
  "location": "HomePageFeature.select_ESATimesheet()"
});
formatter.result({
  "duration": 1859847100,
  "status": "passed"
});
formatter.uri("cTimeSheet.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: mauli.baraskar@cognizant.com"
    }
  ],
  "line": 4,
  "name": "Time sheet page",
  "description": "",
  "id": "time-sheet-page",
  "keyword": "Feature",
  "tags": [
    {
      "line": 3,
      "name": "@tag"
    }
  ]
});
formatter.scenario({
  "line": 8,
  "name": "Time sheet validation",
  "description": "",
  "id": "time-sheet-page;time-sheet-validation",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 7,
      "name": "@SmokeTest"
    },
    {
      "line": 7,
      "name": "@RegressionTest"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "User should land on Timesheet page",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "print latest three weeks",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "validate current week",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "validate previous week",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "validate week before previous week",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "close browser",
  "keyword": "Then "
});
formatter.match({
  "location": "TimeSheetFeature.user_should_land_on_Timesheet_page()"
});
formatter.result({
  "duration": 12831311300,
  "status": "passed"
});
formatter.match({
  "location": "TimeSheetFeature.print_latest_three_weeks()"
});
formatter.result({
  "duration": 1387780800,
  "status": "passed"
});
formatter.match({
  "location": "TimeSheetFeature.validate_current_week()"
});
formatter.result({
  "duration": 483800,
  "status": "passed"
});
formatter.match({
  "location": "TimeSheetFeature.validate_previous_week()"
});
formatter.result({
  "duration": 647800,
  "status": "passed"
});
formatter.match({
  "location": "TimeSheetFeature.validate_week_before_previous_week()"
});
formatter.result({
  "duration": 458900,
  "status": "passed"
});
formatter.match({
  "location": "TimeSheetFeature.close_browser()"
});
formatter.result({
  "duration": 1886021400,
  "status": "passed"
});
});