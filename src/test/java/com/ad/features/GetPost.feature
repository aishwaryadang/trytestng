Feature:
  Verify GET operations using REST-assured


  Scenario: Verify total one page num
    Given I perform GET operation for total on "/api/users" with path parameters
    |page|
    |2|
    Then I should see total as 12


  Scenario: Verify POST Operation
    Given I perform POST operation for "/api/users" with body
      |name|job|
      |Goku|Saiyan|
    Then I should see body has name "Goku"

  Scenario: Verify DELETE Operation
    Given I perform DELETE operation for "/api/users/2"
    And I perform GET operation for "/api/users/2"
    Then I should not see body with first_name "Janet"


