Feature: Test Best Buy API calls

  Scenario Outline: Verify user is able to get response for High Priced Products
    Given User wants to query product API with "<FilterCriteria>"
    When User hit the "<APIMethod>" API "<TestName>"
    Then User gets successful response
    And User is able to validate the Output
    Examples:
      | APIMethod |  FilterCriteria   | TestName         |
      | GET       |  $sort[price]=1   | HighPriceFilter  |


  Scenario Outline: Verify user is able to get product name and design only
    Given User wants to query product API with "<FilterCriteria>"
    When User hit the "<APIMethod>" API "<TestName>"
    Then User gets successful response
    And User is able to validate the Output
    Examples:
      | APIMethod |  FilterCriteria                         | TestName                  |
      | GET       |  $select[]=name&$select[]=description   | ProductNameAndDesignOnly  |


  Scenario Outline: Verify user is able to get TVs with free shipping and prices Between 500 and 800 dollars
    Given User wants to query product API with "<FilterCriteria>"
    When User hit the "<APIMethod>" API "<TestName>"
    Then User gets successful response
    And User is able to validate the Output
    Examples:
      | APIMethod |  FilterCriteria                                                    | TestName         |
      | GET       |  category.name=TVs&price[$gt]=500&price[$lt]=800&shipping[$eq]=0   |  FreeShippingTV  |


  Scenario Outline: Verify user is able to get details of category and name
    Given User wants to query category API with "<FilterCriteria>"
    When User hit the "<APIMethod>" API "<TestName>"
    Then User gets successful response
    And User is able to validate the Output
    Examples:
      | APIMethod |  FilterCriteria   | TestName          |
      | GET       |  $select[]=name   |  NameAndCategory  |


  Scenario Outline: Verify user is able to get details of category with TV in the name
    Given User wants to query category API with "<FilterCriteria>"
    When User hit the "<APIMethod>" API "<TestName>"
    Then User gets successful response
    And User is able to validate the Output
    Examples:
      | APIMethod |  FilterCriteria   | TestName           |
      | GET       |  name[$like]=*TV*  |  CategoryWithTV   |


  Scenario Outline: Verify user is able to get details of stores in Minnesota
    Given User wants to query stores API with "<FilterCriteria>"
    When User hit the "<APIMethod>" API "<TestName>"
    Then User gets successful response
    And User is able to validate the Output
    Examples:
      | APIMethod |  FilterCriteria   | TestName     |
      | GET       |  state=MN         |  StoresinMN  |


  Scenario Outline: Verify user is able to get details of stores in Beverly Hills within 10 miles
    Given User wants to query stores API with "<FilterCriteria>"
    When User hit the "<APIMethod>" API "<TestName>"
    Then User gets successful response
    And User is able to validate the Output
    Examples:
      | APIMethod |  FilterCriteria                                  | TestName          |
      | GET       |  near=90210&service.name=Windows%20Store         |  StoresinBeverly  |


  Scenario Outline: Verify user is able to create new product
    Given User wants to create new "Product" in the database
    When User hit the "<APIMethod>" API "<TestName>"
    Then User gets successful response
    And User is able to validate the Output
    Examples:
      | APIMethod  |   TestName       |
      | POST       | createProduct    |


  Scenario Outline: Verify user is able to create new store
    Given User wants to create new "Store" in the database
    When User hit the "<APIMethod>" API "<TestName>"
    Then User gets successful response
    And User is able to validate the Output
    Examples:
      | APIMethod  |   TestName       |
      | POST       | createStore      |


  Scenario Outline: Verify user is able to create new Service
    Given User wants to create new "Service" in the database
    When User hit the "<APIMethod>" API "<TestName>"
    Then User gets successful response
    And User is able to validate the Output
    Examples:
      | APIMethod  |   TestName       |
      | POST       | createService    |


  Scenario Outline: Verify user is able to create new Category
    Given User wants to create new "Category" in the database
    When User hit the "<APIMethod>" API "<TestName>"
    Then User gets successful response
    And User is able to validate the Output
    Examples:
      | APIMethod  |   TestName       |
      | POST       | createCategory   |
