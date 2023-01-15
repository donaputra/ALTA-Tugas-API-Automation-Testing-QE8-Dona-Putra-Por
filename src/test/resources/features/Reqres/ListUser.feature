Feature: Testing List Users Reqres API
  @Latihan
  Scenario Outline: Get list users with valid parameter page reqres API
    Given Get list user with page <page>
    When Send request get list user
    Then Should return status code 200
    And Response body page should be <page>
    And Validate json schema list user
    Examples:
      | page |
      | 1    |
      | 2    |

  @Tugas @NegativeCase
  Scenario Outline: Get list users with invalid parameter page reqres API
    Given Get list user with page "<page>"
    When Send request get list user
    Then Should return status code 200
    And Response body page should be <page>
    Examples:
      |page     |
      |%^*      |
      |abcjet   |

  @Tugas @NegativeCase
  Scenario Outline: Get list users with invalid parameter page and bad requset status code reqres API
    Given Get list user with page "<page>"
    When Send request get list user
    Then Should return status code 400
    Examples:
      |page     |
      |%^*      |
      |abcjet   |

  @Tugas @NegativeCase
  Scenario Outline: Get list users with valid parameter page bad requset status code reqres API
    Given Get list user with page "<page>"
    When Send request get list user
    Then Should return status code 400
    Examples:
      | page |
      | 1    |
      | 2    |