#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: CRM Application Functional Test

  #Background: Given Login into CRM Application
  @sample
  Scenario: CRM Login and Logout test
    Given Login into CRM Application
    Then Logout the Application
    
  Scenario: CRM Login , Navigate and Logout test
    Given Login into CRM Application
    When Navigate the Menu
    Then Logout the Application  

  Scenario: CRM Create New Contact
    Given Login into CRM Application
    When Navigate the Menu
    #Then Find all the Broken links in the Home Page
    Then Create new Contacts based on below details
      | FieldName   | FieldValue        |
      | FirstName   | Anil              |
      | LastName    | Madishetty        |
      | MiddleName  | Kumar             |
      | Company     | SCB               |
      | Email       | anils78@yahoo.com |
      | Category    | Lead              |
      | Status      | Active            |
      | Description | Test Description  |
    #Then Logout the Application