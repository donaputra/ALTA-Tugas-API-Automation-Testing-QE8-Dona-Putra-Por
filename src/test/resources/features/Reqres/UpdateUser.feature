Feature: Testing Update user Reqres API
  @Tugas
  Scenario: Put update user with valid json
    Given Put update user with valid json with id 2
    When Send request put update user
    Then Should return status code 200
    And Response body name should be "Dona Putra Por" and job "QA Engineer"
    And Validate json schema update user

  @Tugas @NegativeCase
  Scenario: Put update user with invalid json
    Given Put update user with invalid json with id 2
    When Send request put update user
    Then Should return status code 400
    And Response body name should be "Dona Putra Por" and job "QA Engineer"