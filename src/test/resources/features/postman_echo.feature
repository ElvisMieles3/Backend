# Author: elvismieles@gmail.com
@Backend
Feature: API postman-echo
  As: A Quality Analyst
  I Want: Validate and verify the functionality of the endpoint https://postman-echo.com
  To: Ensure that users can consult

  @get @HappyPath
  Scenario: The Quality Analyst verifies the response of the service with the GET method
    When The analyst performs the query of the service 'get' with the following parameters foo1 = 'bar1' and foo2 = 'bar1'
    Then should return the status code '200'

  @get @InvalidPath
  Scenario Outline: The Quality Analyst verifies the response of the service with the GET method
    When The analyst performs the query of the service 'get' with the following parameters foo1 = '<foo1>' and foo2 = '<foo2>'
    Then should return the status code '200'

    Examples:
      | foo1  | foo2   |
      | Elvis | Mieles |
      |       | Mieles |
      | Elvis |        |

  @post @HappyPath
  Scenario: The Quality Analyst verifies the response of the service with POST method
    When The Analyst sends the request with the data:
      | foo1 | foo2 |
      | bar1 | bar2 |
    Then the Analyst must consume the service 'post'
    Then should return the status code '200'
    Then validate response schema

  @post @InvalidPath
  Scenario Outline: The Quality Analyst verifies the response of the service with POST method
    When The Analyst sends the request with the data:
      | foo1   | foo2   |
      | <foo1> | <foo2> |
    Then the Analyst must consume the service 'post'
    Then should return the status code '200'
    Then validate response schema

    Examples:
      | foo1  | foo2   |
      | Elvis | Mieles |
      |       | Mieles |
      | Elvis |        |
