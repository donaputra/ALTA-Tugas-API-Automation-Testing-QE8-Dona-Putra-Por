Feature: Login User feature
  @Tugas
  Scenario: Post login with user valid json
    Given Login with valid user json
    When Send request post login user
    And Response body name should be token "QpwL5tke4Pnpja7X4"
    Then Should return status code 200
    And Validate json schema login user

