Feature: Testing Create user Reqres API

  @Latihan
  Scenario: Post create new user with valid json reqres API
    Given Post create user with valid json
    When Send request post create user
    Then Should return status code 201
    And Response body name should be "Dona Putra Por" and job "QA Engineer"
    And validate json schema create user

  @Tugas @NegativeCase
  Scenario: Post create new user with invalid json_01 and bad request status code reqres API
    Given Post create user with invalid json_01
    When Send request post create user
    Then Should return status code 400

  @Tugas @NegativeCase
  Scenario: Post create new user with invalid json_01 and created status code reqres API
    Given Post create user with invalid json_01
    When Send request post create user
    Then Should return status code 201
    And Response body name should be "Dona Putra Por"

  @Tugas @NegativeCase
  Scenario: Post create new user with valid json and invalid status code reqres API
    Given Post create user with valid json
    When Send request post create user
    Then Should return status code 400
    And Response body name should be "Dona Putra Por" and job "QA Engineer"

    #With Another Json File

  @Tugas @NegativeCase
  Scenario: Post create new user with invalid json_02 and created status code reqres API
    Given Post create user with invalid json_02
    When Send request post create user
    Then Should return status code 201
    And Response body name should be "Dona Putra Por"

  @Tugas @NegativeCase
  Scenario: Post create new user with invalid json_02 and bad request status code reqres API
    Given Post create user with invalid json_02
    When Send request post create user
    Then Should return status code 400
    And Response body name should be "Dona Putra Por" and job "QA Engineer"

  @Tugas @NegativeCase
  Scenario: Post create new user with invalid json_02 and created status code reqres API
    Given Post create user with invalid json_02
    When Send request post create user
    Then Should return status code 201
    And Response body name should be "Dona Putra Por" and job "QA Engineer"



