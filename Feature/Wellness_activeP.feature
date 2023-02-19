Feature: Wellness_activeP

  Background: User is on active programs
    Given User is logged in to profile
    And User is able to enter Active Programs tab
    Then Verify user is on active programs page

  @wellness_activeProgram @positiveScenario
  Scenario: User is able to create program successfully
    When User click on add program
    And User enter "Cardio1" into Program Title
    And User enter "Cardio1 workout" into Description
    And User select "paid" from Program Type
    And User enter "200" into Price
    And User select start date from Start Date
    And User select end date from End Date
    #And User select member from Add Members
    And User update image in thumbnail
    And User click on Save and publish button
    Then Verify User is on module page
    When User click on Add new module
    And User enter "yoga" into module title
    And User enter "yoga1" into module description
    And User upload file in thumbnail
    And User enter "Yoga module" into content
    And User click on Add module
    Then Verify module has been created
    When User click on continue button
    Then Verify user is on Sessions page
    When User click on Add new session
    And User enter "yoga session" into session name
    And User select time in session time
    And User select session day
    And User select session date
    And User select "Eastern Standard Time - (EST)" timezone
    And User click on Create new session
    Then Verify session has been created
    When User click on continue button
    Then Verify user is on forums page
    When User click on Start a new topic
    And User enter "Hi" in text message box
    And User click on cancel button
    When User click on forums continue button
    Then Verify user is on members page
    #Then Verify user is able to see added members
    And User click on finish button
