@login @regression @smoke @cipipeline @heruko
Feature: Successful login to CCCHS application
  Demo feature for User Can Successful login
  
  
  #Scenario Outline: Check DB Connection by clearing Notes and Complaints
 #	Given I open the login page
 #	When I enter '<username>' and '<password>'
  #Then I click the button "signin" 
  #And I check db connection by clearing Notes and Complaints
  #Then I click the button "logout" 
  #And I am redirected to "logout" page
 #	
 #	Examples:
#	|username 	|password	|
#	|TESTA		|Password1	|
	

  Scenario Outline: Valid user login
 	Given I open the login page
 	When I enter '<username>' and '<password>'
  And I click the button "signin" 
  And I am redirected to "home" page
  And I click the button "logout" 
  And I am redirected to "logout" page
 	
 	Examples:
	|username |password	|
	|TESTA		|Password1	|
	|TESTB		|Password1	|
	|TESTC		|Password1	|
	
	
	
  Scenario Outline: Blank username and password login
 	Given I open the login page
  When I send and verify blank details '<text>' for login 
  Then I am redirected to "login error" page
    	
 	
 	Examples:
	|text 	|
	|dummy	|
	
	
  Scenario Outline: Invalid username and password login
 	Given I open the login page
 	When I enter '<username>' and '<password>'
  And I click the button "signin"
  Then I get login error message
  And I am redirected to "login error" page
    	

 	Examples:
	|username 	|password	|
	|TESTUSER10	|Password1	|
	|TESTA		|TEMP10		|
	