Feature: Login Page
  @Sanity
  Scenario:login with valid credentials
    Given open the login page
    When enter username "penumarthigeetasree13003@gmail.com"
    And enter password "Geeta@1528"
    Then click login and redirect
  Scenario: Go to products
    Given products url
    When enter Shirt
    Then open related results