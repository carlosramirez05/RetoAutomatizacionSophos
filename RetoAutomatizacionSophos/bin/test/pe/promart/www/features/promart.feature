Feature: Sophos Challenge refers to Promart page
  An user wants to get an item from Promart page

  Scenario Outline: Add an item to the shopping cart
    Given that user needs to enter the promart page
    When the user search a product <article>
    Then he should see the article in the shopping cart

    Examples: 
   	|article|
   	|televisor|
