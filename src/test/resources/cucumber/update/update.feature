Feature: Update

  Scenario: Update email address given a valid auth token and a valid new email
    Given an email address "updated-email@test.com"
    Given a request with a valid authorisation token
    When i update the email address
    Then the API returns the HTTP status code of 204
    
  Scenario: Update email address given a valid auth token but an invalid new email
    Given an email address "invalid.com"
    Given a request with a valid authorisation token
    When i update the email address
    Then the API returns the HTTP status code of 400
    
  Scenario: Update email address given a valid auth token but a duplicate new email
    Given an email address "duplicate-email@test.com"
    Given a request with a valid authorisation token
    When i update the email address
    Then the API returns the HTTP status code of 400