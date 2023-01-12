Feature: Create User feature
  @Latihan
  Scenario: Post create new user with valid json
    Given Post create user with valid json
    When Send request post create user
    Then Should return status code 201
    And Response body name should be "Dona Putra Por" and job "QA Engineer"



