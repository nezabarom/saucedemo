@Ui-Tests

Feature: Login and Logout Feature
  
  @Smoke
  Scenario: Login as valid user
    Given Login as user
    Then Start Page is displayed
  
  @Smoke
  Scenario: Login as valid user with invalid password
    Given Login with invalid password
    Then Check error message "Epic sadface: Username and password do not match any user in this service"
  
  @Smoke
  Scenario: Logout as user
    Given Login as user
    Then Start Page is displayed
    When Logout user
    Then Log Out page is displayed
    
  @Regression
  Scenario: Login as locked user
    Given Login as locked user
    Then Check error message "Epic sadface: Sorry, this user has been locked out."
  
  @Regression
  Scenario: Login as problem user
    Given Login as problem user
    Then Check that error 404 is present