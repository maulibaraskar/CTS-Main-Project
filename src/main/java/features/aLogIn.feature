#Author: mauli.baraskar@cognizant.com

@tag
Feature: User LogIn 

  @tag1
  Scenario: User LogIn scenario
    Given User LogIn on BeCognizant
    And user enters username
    When clicks on next button
    And user enters password
    And user click on signIn button
    Then selects verify with call option
    And clicks on sign button
    Then page title is BeCognizant
