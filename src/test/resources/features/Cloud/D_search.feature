@search @regression @cipipeline @heruko
Feature: Search functionality

  Scenario Outline: Search already created complaint
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    Then I click the button "signin" 
    And I am redirected to "home" page
    Then I search already created complaint number from home page
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
	
 	Examples:
	|username 	|password	|
	|TESTA		|Password1	|
	

  Scenario Outline: Search error messages
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "signin" 
    And I am redirected to "home" page
    And I search not created complaint number and get error message as '<text>' with '<error_msg>'
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username |password	|text			| error_msg 				|
	|TESTA		|Password1	|99999	| No such complaint | 
	|TESTA		|Password1	|&^%$!	| Not a number		| 
	|TESTA		|Password1	|nuhjtg	| Not a number		| 
	


  Scenario Outline: Create a New Customer By different Name
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "signin" 
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
    Then I search for "Surname" by '<SearchName>'
    And I click the button "Search"
    And I am redirected to "search result" page
    And I click the button "Create New Customer" 
    And I send customer details by name
    And I send address details
    And I send contact details  
    And I click the button "saveNewCustomer" 
    Then I click the link "Dashboard" 
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|SearchName |
	|TESTA		|Password1	|test		|
	
	
  Scenario Outline: Create a New Customer By entering different Surname
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "signin" 
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
    Then I search for "Surname" by '<SearchName>'
    And I click the button "Search"
    And I click the button "Create New Customer" 
    And I send customer details by surname
    And I send address details
    And I send contact details  
   	And I click the button "saveNewCustomer" 
    Then I click the link "Dashboard" 
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|SearchName |
	|TESTA		|Password1	|test		|
	
	
  Scenario Outline: Amend an Existing Customer for Customer Details only
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "signin" 
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
	Then I search for "Surname" by '<SearchSurname>'
    And I click the button "Search"
    Then I click the link "customerReference"
    And I am redirected to "view customer" page
	Then I click the link "editCustomer"
	And I am redirected to "edit existing customer" page
    And I send updated customer details
    And I click the button "SaveCustomer"
    And I am redirected to "view customer" page
    Then I click the link "Dashboard"
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|SearchSurname 	|
	|TESTA		|Password1	|test			|
	

	
  Scenario Outline: Amend an Existing Customer for Contact Details only
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "signin" 
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
	Then I search for "Postcode" by '<SearchPostcode>'
	And I click the button "Search"
    Then I click the link "customerReference"
    And I am redirected to "view customer" page
	Then I click the link "editCustomer"
	And I am redirected to "edit existing customer" page
    And I send updated contact details
    And I click the button "SaveCustomer"
    And I am redirected to "view customer" page
    Then I click the link "Dashboard"
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|SearchPostcode	|
	|TESTA		|Password1	|DH				|
	
	

  Scenario Outline: Amend an Existing Customer for Address Details only
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "signin" 
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
    Then I search for "Surname" by '<SearchName>'
    And I click the button "Search"
    Then I click the link "customerReference"
    And I am redirected to "view customer" page
	Then I click the link "editCustomer"
	And I am redirected to "edit existing customer" page
    And I send updated address details
    And I click the button "SaveCustomer"
    And I am redirected to "view customer" page
    Then I click the link "Dashboard" 
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|SearchName |
	|TESTA		|Password1	|test		|
