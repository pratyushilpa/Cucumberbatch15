Feature: Admin user access and edit employee's job details (USER STORY 13)

  @AddJobDetails
  Scenario: Admin access employee's job details
     #Given open browser and launch HRMS website
    #And user enters valid username and valid password combination
    #And user clicks on log in button
    #Then user is logged in successfully on correct dashboard
    #--- Added by Pratyush--------
    When user enters valid "admin" and valid "Hum@nhrm123"
    And click on login button
    Then user is logged in successfully into the application
    When user clicks on PIM option
    When user accesses the list of employees in the system.
    And user enters Id
    Then user clicks on search button
    When select a specified employee Id from the list
    And navigate to the employee's job page
    When user clicks on edit button
    And user selects Job TiTle
    And user selects Employment Status
    And user selects Job Category
    And user selects Joined Date
    And user selects Sub Unit
    And user selects Location
    And user selects Start Date
    And user selects End Date
    Then user uploads Contract Details
      #When system validates mandatory fields
    And  user clicks on save button
    And specified employee's job added