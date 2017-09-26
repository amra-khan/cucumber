Feature: Login Action

  Scenario: Successful login into application
    Given navigate to GoalPlan
    When User enters Credentials to log in
      | amrak | amra@tester |
    Then User should see the home page
    
     Scenario: Successful Logout
    When User logout from application
    Then user should see the Login page
    

  Scenario Outline: Unsuccessful login
    Given navigate to GoalPlan
    When User enters  Username as "<username>"  and  Password as "<password>"
    Then User should see the approriate message

    Examples: 
      | username | password    |
      | amrag    | amra@tester |
      | amrak    | khan        |

 