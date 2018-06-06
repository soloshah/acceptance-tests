@regression @cipipeline @heruko
Feature: Successful login to CCCHS application
  Demo feature for User Can Successful login
 	

  Scenario Outline: Check access for the user types
 	Given I open the login page
 	When I enter '<username>' and '<password>'
  	Then I click the button "signin" 
  	And I am redirected to "home" page
  
  	And I check dasboard tab for '<role>' user
  	And I check customer search tab for '<role>' user
  	And I check case management tab for '<role>' user
  	And I check user management tab for '<role>' user
  	And I check metrics tab for '<role>' user
  
  	And I click the button "logout" 
  	And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|role		|
	|TESTA		|Password1	|admin		|
	|TESTD		|Password1	|manager	|
	|TESTC		|Password1	|standard	|
	|TESTB		|Password1	|super		|
	

	