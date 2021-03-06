Feature: Adding licenses in qualifications

  @GG
    Scenario:
    When user enters valid admin credentials
    And user clicks on login button
    Then admin user is successfully logged in
    When user clicks on Admin option
    And user clicks on add QualificationsLicense option
    And user clicks on add license option
    And user enters license name
    And user clicks on save license button
    Then License added successfully


  @sprint1 @Gigi @datatable
  Scenario: adding multiple licenses in qualification using data table
    And admin user adds multiple license
      | LicensesName    |
      | JavaLicense     |
      | TestNgLicense   |
      | SeleniumLicense |
      | CucumberLicense |