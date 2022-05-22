Feature: Adding the employees in HRMS Application'

  Background:
    #Given user is navigated to HRMS application
    When user enters valid admin credentials
    And user clicks on login button
    Then admin user is successfully logged in
    When user clicks on PIM option
    And user clicks on add employee option

  #add data แบบ basic/ add ตอน implement ----> hard code
  @regression
  Scenario: Adding one employees from feature file
    And user enters firstname middlename and lastname
    And user clicks on save button
    Then employee added successfully

 # add data โดย ผ่าน cucumber feature ---> no hard code
  @testGigi
  Scenario: Adding one employee using cucumber feature file
    And user enters "Crispy" "Crazy" and "Funny"
    And user clicks on save button
    Then employee added successfully

   #add multiple data by using cucumber feature // Scenario Outline
  @testGigi
  Scenario Outline: Adding multiple employees
    And user provides "<firstName>" "<middleName>" and "<lastName>"
    And user clicks on save button
    Then employee added successfully
    Examples:
      | firstName | middleName | lastName|
      | Apple     | AA         | Ruby    |
      | Banana    | BB         | Yellow  |
      | Cheery    | CC         | Scarlet |
      | Durian    | DD         | Custard |

# add multiple data by using @datatable
# datatable ช่วยให้ hooks execute only one time
  @testGigi @datatable
  Scenario: Add employee using data table
    When user provides multiple employee data and verify they are added
      | firstName | middleName | lastName|
      | Apple     | AA         | Ruby    |
      | Banana    | BB         | Yellow  |
      | Cheery    | CC         | Scarlet |
      | Durian    | DD         | Custard |

@excel
  Scenario:Adding multiple employees from excel file
    When user and multiple employees from excel file using "EmployeeData" sheet and verify the user added