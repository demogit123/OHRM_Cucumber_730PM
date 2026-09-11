Feature: Admin Login

@login_valid
Scenario: Check Admin Login with valid credentials
Given I Open Browser with URL "http://orangehrm.qedgetech.com"
Then I should see Login Page
When I Enter Username as "Admin"
And I Enter Password as "Qedge123!@#"
And I Click Login
Then I sholud see Admin Module
When I Click Logout
Then I should see Login Page
When I Close Browser

@login_invalid
Scenario Outline: Check Admin Login with invalid credentials
Given I Open Browser with URL "http://orangehrm.qedgetech.com"
Then I should see Login Page
When I Enter Username as "<username>"
And I Enter Password as "<password>"
And I Click Login
Then I Should see Error Message
When I Close Browser

Examples:
|username|password  |
|Admin	 |  xyz     |
|xyz	 |	Qedge123|
|abc	 |  xyz     |
|		 |		    |  
