Feature: Login Functionalities
  @smoke1
  Scenario: Valid Admin login
    #Given open the browser and launch HRMS application
    When user enters valid "admin" and valid "Hum@nhrm123"
    And click on login button
    Then user is logged in successfully into the application
    #And Close the browser

  #Parameterization  / Data Driven
  @ScenarioOutline
  Scenario Outline: Valid Admin login
    #Given open the browser and launch HRMS application
    When user enters valid "<username>" and valid "<password>"
    And click on login button
    Then user is logged in successfully into the application
    #And Close the browser
  Examples:
    |username|password|
    |admin   |Hum@nhrm123|
    |admin   |Hum@nhrm123|
    |admin   |Hum@nhrm123|


    @datatable
    Scenario: Login with multiple  credentials using data table
      When user enters username and password  and verifies login
        |username|password|
        |admin   |Hum@nhrm123|
        |ADMIN   |Hum@nhrm123|
        |admin   |Hum@nhrm123|