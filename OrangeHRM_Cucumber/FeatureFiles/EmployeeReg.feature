Feature: Employee Registration

Scenario: Check New Employee Registration with valid inputs
Given I Open Browser with URL "http://orangehrm.qedgetech.com"
Then I should see Login Page
When I Enter Username as "Admin"
And I Enter Password as "Qedge123!@#"
And I Click Login
Then I sholud see Admin Module
When I Goto Add Employee Page
And I Enter FirstName as "Richards"
And I Enter LastName as "John"
And I Click Save
Then I Should See Registred Employee in Employee List
When I Click Logout
Then I should see Login Page
When I Close Browser
