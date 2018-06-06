@regression @cases @cipipeline @heruko
Feature: Successful view active and resolved cases in CCCHS application
  Demo feature User can view active and resolved cases


  Scenario Outline: Valid user login and view active cases
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "signin" 
    And I am redirected to "home" page
	Then I click the tab "Case Management" 
    And I click the tab "Active Cases" 
    And I am redirected to "active cases" page
    Then I click the link "active case number"
   	And I am redirected to "view complaint" page
    Then I click the link "Dashboard"
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|
	|TESTA		|Password1	|
	|TESTB		|Password1	|
	|TESTC		|Password1	|


  Scenario Outline: Valid user login and view resolved cases
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "signin" 
    And I am redirected to "home" page
    Then I click the tab "Case Management" 
    And I click the tab "Resolved Cases" 
    And I am redirected to "resolved cases" page
    Then I click the link "resolved case number"
   	And I am redirected to "view complaint" page
    Then I click the link "Dashboard"
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|
	|TESTA		|Password1	|
	|TESTB		|Password1	|
	|TESTC		|Password1	|


  Scenario Outline: Valid user login and view red cases
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "signin" 
    And I am redirected to "home" page
    And I click the tab "Red Cases" 
    And I am redirected to "red cases" page
    Then I click the link "slacase"

 	
 	Examples:
	|username 	|password	|
	|TESTA		|Password1	|
	|TESTB		|Password1	|
	|TESTC		|Password1	|


  Scenario Outline: Valid user login and view amber cases
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "signin" 
    And I am redirected to "home" page
    And I click the tab "Amber Cases" 
    And I am redirected to "amber cases" page
   	Then I click the link "slacase"

 	
 	Examples:
	|username 	|password	|
	|TESTA		|Password1	|
	|TESTB		|Password1	|
	|TESTC		|Password1	|


  Scenario Outline: Valid user login and view green cases
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "signin" 
    And I am redirected to "home" page
    And I click the tab "Green Cases" 
    And I am redirected to "green cases" page
    Then I click the link "slacase"

 	
 	Examples:
	|username 	|password	|
	|TESTA		|Password1	|
	|TESTB		|Password1	|
	|TESTC		|Password1	|
	