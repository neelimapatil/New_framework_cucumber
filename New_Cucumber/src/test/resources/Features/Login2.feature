Feature: login feature by config reader

@EndToEnd
Scenario Outline: Login Functionality for valid username and valid password using json data
Given User is on Login Page
When user login with username and password with data from json file <Index>
Then do nothing
Examples: 
| Index |
| 0 |
| 1 |



@SmokeTest
 Scenario Outline: Login Functionality for invalid credentials json data
 Given User is on Login Page
When user login with "valid" username and password with data from json file <Index>
Then user should display error message

Examples: 
| Index |
| 0 |
| 1 |
