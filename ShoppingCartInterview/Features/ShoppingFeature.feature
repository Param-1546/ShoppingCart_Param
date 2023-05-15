Feature: Shopping cart

@Test
Scenario: Add items to shopping cart and remove the lowest price item from cart
	Given I add four random items to my cart
	When I view my cart
	Then I find total four items listed in my cart
	When I searched for the lowest price item 
	And I am able to remove the lowest price item from my cart
	Then I am able to verify three items in my cart
	Then close the browser