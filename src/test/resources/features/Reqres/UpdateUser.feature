Feature: Testing Update user Reqres API

  @Tugas @PositiveCase
  Scenario: Put update user with valid json
    Given Put update user with valid json with id 1
    When Send request put update user
    Then Should return status code 200
    And Response update user body name should be "Dona Putra Por" and job "QA Engineer"
    And Validate json schema update user

  @Tugas @PositiveCase
  Scenario: Put update user job with valid json
    Given Put update user job with valid json with id 1
    When Send request put update user
    Then Should return status code 200
    And Response update job body name should be "Dona Putra Por" and job "Product Manager"
    And Validate json schema update user

  @Tugas @PositiveCase
  Scenario: Put update user name with valid json
    Given Put update user name with valid json with id 1
    When Send request put update user
    Then Should return status code 200
    And Response update name body name should be "Putra Dona" and job "Product Manager"
    And Validate json schema update user

  #______________________________BELOW HERE ARE NEGATIVE CASES______________________________#

  @Tugas @NegativeCase
  Scenario: Put update user with invalid null name json
    Given Put update user with invalid null name json with id 2
    When Send request put update user
    Then Should return status code 400

  @Tugas @NegativeCase
  Scenario: Put update user with invalid null job json
    Given Put update user with invalid null job json with id 2
    When Send request put update user
    Then Should return status code 400

  @Tugas @NegativeCase
  Scenario: Put update user with invalid string json
    Given Put update user with invalid string json with id 2
    When Send request put update user
    Then Should return status code 400

  @Tugas @NegativeCase
  Scenario: Put update user with invalid null name and null job json
    Given Put update user with invalid null name and null job json with id 2
    When Send request put update user
    Then Should return status code 400



