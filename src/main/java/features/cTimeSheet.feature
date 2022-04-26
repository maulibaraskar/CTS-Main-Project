#Author: mauli.baraskar@cognizant.com

@tag
Feature: Time sheet page 
  

  @tag1
  Scenario: Time sheet validation
    Given User should land on Timesheet page
    And print latest three weeks 
    When validate current week
    And validate previous week
    And validate week before previous week
    Then close browser
   
