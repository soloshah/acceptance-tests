@errmsg1 @regression
Feature: Validate error messages for New customers


  Scenario Outline: Validate BLANK error messages for Create a New Customer for Customer Details section
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "login" 
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
    Then I search for "Name" by '<SearchName>'
    And I click the button "Search"
    And I click the button "Create New Customer" 
    And I send address details
    And I send contact details  
    Then I send and verify empty details for customer details
    Then I click the link "Dashboard" 
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
    
    Examples:
    |username 	|password	|SearchName |
 	|TESTB		|Password1	|test		|


  Scenario Outline: Validate error messages for Create a New Customer for Customer Details section
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "login" 
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
    Then I search for "Name" by '<SearchName>'
    And I click the button "Search"
    And I click the button "Create New Customer" 
    And I send address details
    And I send contact details  
    Then I send and verify error message '<text>' for customer details
    Then I click the link "Dashboard" 
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|SearchName |text									|
	|TESTB		|Password1	|test		|@#$									|
	|TESTB		|Password1	|test		|@*12%									|
	|TESTB		|Password1	|test		|tester789								|
	|TESTB		|Password1	|test		|thegreattesterlikestotestthetextbox	|



  Scenario Outline: Validate error message for DOB for Create a New Customer for Customer Details section
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "login" 
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
    Then I search for "Name" by '<SearchName>'
    And I click the button "Search"
    And I click the button "Create New Customer" 
    And I send customer details by name
    And I send address details
    And I send contact details  
    Then I send and verify dob '<text>' for customer details
    Then I click the link "Dashboard" 
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
    |username 	|password	|SearchName |text		|
 	|TESTB		|Password1	|test		|01/01/198	|
 	|TESTB		|Password1	|test		|01-01-1980	|
 	|TESTB		|Password1	|test		|01\01\1980	|
 	|TESTB		|Password1	|test		|01/15/1974	| 
 	|TESTB		|Password1	|test		|32/05/1966	|


  Scenario Outline: Validate BLANK error messages for Create a New Customer for Address Details section
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "login" 
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
    Then I search for "Name" by '<SearchName>'
    And I click the button "Search"
    And I click the button "Create New Customer" 
    And I send customer details by name
    And I send contact details  
    Then I send and verify Blank details for address details
    Then I click the link "Dashboard" 
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
    |username 	|password	|SearchName |
 	|TESTB		|Password1	|test		|
 	

  Scenario Outline: Validate error messages for Create a New Customer for Address Details section
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "login" 
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
    Then I search for "Name" by '<SearchName>'
    And I click the button "Search"
    And I click the button "Create New Customer" 
    And I send customer details by name
    And I send contact details  
    Then I send and verify error message for address1 '<addr1_text>' for address details
    Then I send and verify error message for address2 '<addr2_text>' for address details
    Then I send and verify error message for town '<town_text>' for address details
    Then I send and verify error message for postcode '<postcode_text>' for address details
    Then I click the link "Dashboard" 
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|SearchName |addr1_text												|addr2_text 	|town_text		|postcode_text 	|
	|TESTB		|Password1	|test		|@#$													|@#$			|@#$			|@#$			|
	|TESTB		|Password1	|test		|@#$^&													|@#$^&			|@#$^&			|@#$^&			|
	|TESTB		|Password1	|test		|89 street&lane											|89 street&lane	|89 street&lane	|89 street&lane	|
	|TESTB		|Password1	|test		|iamstandingonthestreetandcalledlovelanestreetlovely	|89 street&lane	|89 street&lane	|89 street&lane	|
	

  Scenario Outline: Validate error messages for Create a New Customer for Address Details section
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "login" 
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
    Then I search for "Name" by '<SearchName>'
    And I click the button "Search"
    And I click the button "Create New Customer" 
    And I send customer details by name
    And I send contact details  
    Then I send and verify error message for address1 '<text>' for address details
    Then I send and verify error message for address2 '<text>' for address details
    Then I send and verify error message for town '<text>' for address details
    Then I send and verify error message for postcode '<postcode_text>' for address details
    Then I click the link "Dashboard" 
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|SearchName |text														|postcode_text 	|
	|TESTB		|Password1	|test		|iamstandingonthestreetandcalledlovelanestreetlovely		|DH12DFFRT		|
	|TESTB		|Password1	|test		|34/39 on-the street and called lovelane.lovely happy days	|DH12-DFF		|
	|TESTB		|Password1	|test		|34_bridgehouse												|123456jury		|
	
	

  Scenario Outline: Validate error messages for Create a New Customer for Contact Details section
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "login" 
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
    Then I search for "Name" by '<SearchName>'
    And I click the button "Search"
    And I click the button "Create New Customer" 
    And I send customer details by name
    And I send address details  
    Then I send and verify incorrect details '<text>' for contact details
    Then I click the link "Dashboard" 
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|SearchName |text		|
	|TESTB		|Password1	|test		|@#$		|
	|TESTB		|Password1	|test		|@$45&*(	|
	|TESTB		|Password1	|test		|$45&*^		|
	|TESTB		|Password1	|test		|test@		|
	|TESTB		|Password1	|test		|test@.com	|
	|TESTB		|Password1	|test		|test.com	|
	

  Scenario Outline: Validate max characters error messages for Create a New Customer for Contact Details section
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "login" 
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
    Then I search for "Name" by '<SearchName>'
    And I click the button "Search"
    And I click the button "Create New Customer" 
    And I send customer details by name
    And I send address details  
    Then I send and verify incorrect details '<text>' for contact details
    Then I click the link "Dashboard" 
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|SearchName |text													|
	|TESTB		|Password1	|test		|6777777777777677777777777767777777777776777777777777	|
	|TESTB		|Password1	|test		|mytesingskillsarenotthatbad@upgradeskillstonewone.com	|
