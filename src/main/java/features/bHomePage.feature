#Author: mauli.baraskar@cognizant.com

@tag
Feature: User validation and Time sheet search

  @tag1
  Scenario: User validation
    Given User should be on BeCognizant page
    And user should have logIn successfully
    When click on search box
    And search for timesheet 
    And select ESATimesheet
     
    
