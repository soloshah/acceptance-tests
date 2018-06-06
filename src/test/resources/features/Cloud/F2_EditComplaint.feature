@editcomplaint @regression
Feature: Edit an existing Complaint functionality

@cipipeline @heruko
  Scenario Outline: Edit an existing Complaint for edit complaint link
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "signin" 
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
	Then I search for "Surname" by '<SearchName>'
    And I click the button "Search"
    And I am redirected to "search result" page
    Then I click the link "customerReference" 
    And I am redirected to "view customer" page
    Then I click the link "cemsReference"
    And I am redirected to "view complaint" page
    Then I click the link "edit complaint"
   	And I am redirected to "edit complaint" page
    Then I populate edit complaint with '<Type>' and '<Priority>' and '<Reference>' and '<AssignedBy>' and '<Team>' and '<Summary>' and '<Upheld>' and '<Status>' and '<MICategory>' and '<MIOption>'
    And I click the button "SaveComplaint"
    And I am redirected to "view complaint" page
    Then I click the link "Dashboard"
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|SearchName		|Type			|Priority	|Reference		|AssignedBy	|Team	|Summary						|Upheld		|Status	|MICategory	|MIOption	|
	|TESTB		|Password1	|test			|SocialMedia	|2 			|CMP511456789	|Tpman		|29		|Customer not happy 			|	yes		|1		|2			|3			|
	|TESTB		|Password1	|test			|Letter			|1 			|CMP6789111		|Risld		|46		|Customer called three times 	|	yes		|1		|3			|2			|

	
@cipipeline @heruko
  Scenario Outline: Edit an existing Complaint by clicking complaint number link
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "signin" 
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
	Then I search for "Surname" by '<SearchName>'
    And I click the button "Search"
    And I am redirected to "search result" page
    Then I click the link "customerReference" 
    And I am redirected to "view customer" page
    Then I click the link "cemsReference"
    And I am redirected to "view complaint" page
    Then I click the link "edit complaint"
    Then I am redirected to "edit complaint" page
    Then I populate edit complaint with '<Type>' and '<Priority>' and '<Reference>' and '<AssignedBy>' and '<Team>' and '<Summary>' and '<Upheld>' and '<Status>' and '<MICategory>' and '<MIOption>'
    And I click the button "SaveComplaint"
    And I am redirected to "view complaint" page
    Then I click the link "Dashboard"
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|SearchName		|Type			|Priority	|Reference		|AssignedBy		|Team		|Summary						|Upheld		|Status	|MICategory	|MIOption	|
	|TESTB		|Password1	|test			|SocialMedia	|2 			|CMP511456789	|opman			|89			|Customer not happy 			|	yes		|1		|2			|3			|
	|TESTB		|Password1	|test			|Letter			|1 			|CMP6789111		|Rland			|69			|Customer called three times 	|	yes		|1		|3			|2			|
	
	
	
  Scenario Outline: CEMS Dashboard - Edit an existing Complaint by viewing red cases for complaint number
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    Then I click the button "signin" 
    And I am redirected to "home" page
    And I click the tab "Red Cases" 
    And I am redirected to "red cases" page
    Then I check for sla case and edit complaint number with '<Type>' and '<Priority>' and '<Reference>' and '<AssignedBy>' and '<Team>' and '<Summary>' and '<Upheld>' and '<Status>' and '<MICategory>' and '<MIOption>'
 	
 	Examples:
	|username 	|password	|Type			|Priority	|Reference		|AssignedBy		|Team	|Summary						|Upheld		|Status	|MICategory	|MIOption	|
	|TESTB		|Password1	|SocialMedia	|2 			|CMP511456789	|Topma			|33		|Customer not happy 			|	yes		|1		|2			|3			|
	|TESTB		|Password1	|Letter			|1 			|CMP6789111		|Rilnd			|38		|Customer called three times 	|	yes		|1		|3			|2			|
	
	

	Scenario Outline: CEMS Dashboard - Edit an existing Complaint by viewing amber cases for complaint number
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "signin" 
    And I am redirected to "home" page
    And I click the tab "Amber Cases" 
    And I am redirected to "amber cases" page
    Then I check for sla case and edit complaint number with '<Type>' and '<Priority>' and '<Reference>' and '<AssignedBy>' and '<Team>' and '<Summary>' and '<Upheld>' and '<Status>' and '<MICategory>' and '<MIOption>'
 	
 	Examples:
	|username 	|password	|Type			|Priority	|Reference		|AssignedBy		|Team		|Summary						|Upheld		|Status	|MICategory	|MIOption	|
	|TESTB		|Password1	|SocialMedia	|2 			|CMP511456789	|Tpman			|47			|Customer not happy 			|	yes		|1		|2			|3			|
	|TESTB		|Password1	|Letter			|1 			|CMP6789111		|sland			|30			|Customer called three times 	|	yes		|1		|3			|2			|
	
	
  Scenario Outline: CEMS Dashboard - Edit an existing Complaint by viewing green cases for complaint number
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "signin" 
    And I am redirected to "home" page
    And I click the tab "Green Cases" 
    And I am redirected to "green cases" page
    Then I check for sla case and edit complaint number with '<Type>' and '<Priority>' and '<Reference>' and '<AssignedBy>' and '<Team>' and '<Summary>' and '<Upheld>' and '<Status>' and '<MICategory>' and '<MIOption>'
 	
 	Examples:
	|username 	|password	|Type			|Priority	|Reference		|AssignedBy		|Team	|Summary						|Upheld		|Status	|MICategory	|MIOption	|
	|TESTB		|Password1	|SocialMedia	|2 			|CMP511456789	|Toman			|52		|Customer not happy 			|	yes		|1		|2			|3			|
	|TESTB		|Password1	|Letter			|1 			|CMP6789111		|Risnd			|44		|Customer called three times 	|	yes		|1		|3			|2			|
	
		
  Scenario Outline: CEMS Dashboard - Edit an existing Complaint by viewing red cases for edit complaint link
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "signin" 
    And I am redirected to "home" page
    And I click the tab "Red Cases" 
    And I am redirected to "red cases" page
    Then I check for sla case and edit complaint link with '<Type>' and '<Priority>' and '<Reference>' and '<AssignedBy>' and '<Team>' and '<Summary>' and '<Upheld>' and '<Status>' and '<MICategory>' and '<MIOption>'
 	
 	Examples:
	|username 	|password	|Type			|Priority	|Reference		|AssignedBy		|Team	|Summary						|Upheld		|Status	|MICategory	|MIOption	|
	|TESTB		|Password1	|SocialMedia	|2 			|CMP511456789	|Tpman			|05		|Customer not happy 			|	yes		|1		|2			|3			|
	|TESTB		|Password1	|Telephone		|2 			|CMP689456789	|RIsnd			|16		|Customer very happy 			|	yes		|1		|3			|2			|
	
	

  Scenario Outline: CEMS Dashboard - Edit an existing Complaint by viewing amber cases for edit complaint link
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "signin" 
    And I am redirected to "home" page
    And I click the tab "Amber Cases" 
    And I am redirected to "amber cases" page
    Then I check for sla case and edit complaint link with '<Type>' and '<Priority>' and '<Reference>' and '<AssignedBy>' and '<Team>' and '<Summary>' and '<Upheld>' and '<Status>' and '<MICategory>' and '<MIOption>'
 	
 	Examples:
	|username 	|password	|Type			|Priority	|Reference		|AssignedBy		|Team	|Summary						|Upheld		|Status	|MICategory	|MIOption	|
	|TESTB		|Password1	|SocialMedia	|2 			|CMP511456789	|Topma			|16		|Customer not happy 			|	yes		|1		|2			|3			|
	|TESTB		|Password1	|Telephone		|2 			|CMP689456789	|River			|78		|Customer very happy 			|	yes		|1		|3			|2			|
	
	
	
  Scenario Outline: CEMS Dashboard - Edit an existing Complaint by viewing green cases for edit complaint link
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "signin" 
    And I am redirected to "home" page
    And I click the tab "Green Cases" 
    And I am redirected to "green cases" page
    Then I check for sla case and edit complaint link with '<Type>' and '<Priority>' and '<Reference>' and '<AssignedBy>' and '<Team>' and '<Summary>' and '<Upheld>' and '<Status>' and '<MICategory>' and '<MIOption>'
 	
 	Examples:
	|username 	|password	|Type			|Priority	|Reference		|AssignedBy		|Team	|Summary						|Upheld		|Status	|MICategory	|MIOption	|
	|TESTB		|Password1	|SocialMedia	|2 			|CMP511456789	|Topma			|70		|Customer not happy 			|	yes		|1		|2			|3			|
	|TESTB		|Password1	|Telephone		|2 			|CMP689456789	|River			|66		|Customer very happy 			|	yes		|1		|3			|2			|
	

  Scenario Outline: View Active Cases - Edit an existing Complaint by viewing Active Cases for complaint number
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    Then I click the button "signin" 
    And I am redirected to "home" page
    Then I click the tab "Case Management" 
    And I click the tab "Active Cases" 
    And I am redirected to "active cases" page
    Then I click the link "active case number"
   	And I am redirected to "view complaint" page
   	Then I click the link "edit complaint"
   	And I am redirected to "edit complaint" page
   	Then I check for active cases and edit complaint number with '<Type>' and '<Priority>' and '<Reference>' and '<AssignedBy>' and '<Team>' and '<Summary>' and '<Upheld>' and '<Status>' and '<MICategory>' and '<MIOption>'
 	
 	Examples:
	|username 	|password	|Type			|Priority	|Reference		|AssignedBy		|Team	|Summary						|Upheld		|Status	|MICategory	|MIOption	|
	|TESTB		|Password1	|SocialMedia	|2 			|CMP511456789	|Topma			|11		|Customer not happy 			|	yes		|1		|2			|3			|
	|TESTB		|Password1	|Letter			|1 			|CMP6789111		|Riand			|19		|Customer called three times 	|	yes		|1		|3			|2			|
	
   	
@cipipeline @heruko
   Scenario Outline: View Resolved Cases - Edit an existing Complaint by viewing Resolved Cases for complaint number
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "signin" 
    And I am redirected to "home" page
    Then I click the tab "Case Management" 
    And I click the tab "Resolved Cases" 
    And I am redirected to "resolved cases" page
    Then I click the link "resolved case number"
   	And I am redirected to "view complaint" page
   	Then I click the link "edit complaint"
   	And I am redirected to "edit complaint" page
   	Then I check for resolved cases and edit complaint number with '<Type>' and '<Priority>' and '<Reference>' and '<AssignedBy>' and '<Team>' and '<Summary>' and '<Upheld>' and '<Status>' and '<MICategory>' and '<MIOption>'
 	
 	Examples:
	|username 	|password	|Type			|Priority	|Reference		|AssignedBy		|Team	|Summary						|Upheld		|Status	|MICategory	|MIOption	|
	|TESTB		|Password1	|SocialMedia	|2 			|CMP511456789	|Tpman			|10		|Customer not happy 			|	yes		|1		|2			|3			|
	|TESTB		|Password1	|Letter			|1 			|CMP6789111		|River			|50		|Customer called three times 	|	yes		|1		|3			|2			|
	
   	


  Scenario Outline: Edit an existing Complaint by viewing Active Cases for edit complaint link by user
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "signin" 
    And I am redirected to "home" page
    And I click the tab "Active Cases" 
    And I am redirected to "active cases" page
   Then I check for active cases and edit complaint link with '<Type>' and '<Priority>' and '<Reference>' and '<AssignedBy>' and '<Team>' and '<Summary>' and '<Upheld>' and '<Status>' and '<MICategory>' and '<MIOption>'
 	
 	Examples:
	|username 	|password	|Type			|Priority	|Reference		|AssignedBy		|Team	|Summary						|Upheld		|Status	|MICategory	|MIOption	|
	|TESTB		|Password1	|SocialMedia	|2 			|CMP511456789	|Topan			|22		|Customer not happy 			|	yes		|1		|2			|3			|
	|TESTB		|Password1	|Letter			|1 			|CMP6789111		|sland			|46		|Customer called three times 	|	yes		|1		|3			|2			|
	
   	
@cipipeline @heruko
   Scenario Outline: Edit an existing Complaint by edit complaint link by user
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "signin" 
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
    Then I search for "Surname" by '<SearchName>'
    And I click the button "Search"
    Then I click the link "customerReference"
    And I click the link "edit complaint for Complaint History"
   	And I am redirected to "edit complaint" page
   	Then I check for resolved cases and edit complaint link with '<Type>' and '<Priority>' and '<Reference>' and '<AssignedBy>' and '<Team>' and '<Summary>' and '<Upheld>' and '<Status>' and '<MICategory>' and '<MIOption>'
 	
 	Examples:
	|username |password		|SearchName	|Type					|Priority	|Reference		|AssignedBy	|Team	|Summary											|Upheld		|Status	|MICategory	|MIOption	|
	|TESTB		|Password1	|test				|SocialMedia	|2 				|CMP511456789	|Topma			|25		|Customer not happy 					|	yes			|1			|2					|3				|
	|TESTB		|Password1	|test				|Letter				|1 				|CMP6789111		|River			|56		|Customer called three times 	|	yes			|1			|3					|2				|
	
	
	
  Scenario Outline: Search Dashboard - Edit an existing Complaint by searching cems ref for edit complaint link
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "signin" 
    And I am redirected to "home" page
	Then I search for "Search CEMS Number" by '<cems_ref>'
   	Then I check for search cases and edit complaint link with '<Type>' and '<Priority>' and '<Reference>' and '<AssignedBy>' and '<Team>' and '<Summary>' and '<Upheld>' and '<Status>' and '<MICategory>' and '<MIOption>'
 	
 	Examples:
	|username 	|password	|cems_ref	|Type			|Priority	|Reference		|AssignedBy		|Team	|Summary						|Upheld		|Status	|MICategory	|MIOption	|
	|TESTB		|Password1	|10000		|SocialMedia	|2 			|CMP25656781	|Topma			|02		|Customer not happy 			|	yes		|1		|2			|3			|
	|TESTB		|Password1	|00080		|Letter			|1 			|CMP67891110	|Islnd			|63		|Customer called three times 	|	yes		|1		|3			|2			|
	


  Scenario Outline: Search Dashboard - Edit an existing Complaint by searching cems ref for complaint number
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "signin" 
    And I am redirected to "home" page
	Then I search for "Search CEMS Number" by '<cems_ref>'
   	Then I check for search cases and complaint number with '<Type>' and '<Priority>' and '<Reference>' and '<AssignedBy>' and '<Team>' and '<Summary>' and '<Upheld>' and '<Status>' and '<MICategory>' and '<MIOption>'
 	
 	Examples:
	|username 	|password	|cems_ref	|Type			|Priority	|Reference		|AssignedBy		|Team	|Summary						|Upheld		|Status	|MICategory	|MIOption	|
	|TESTB		|Password1	|00080		|SocialMedia	|2 			|CMP51156789	|Tpman			|15		|Customer not happy 			|	yes		|1		|2			|3			|
	|TESTB		|Password1	|00080		|Letter			|1 			|CMP67891110	|RvrId			|34		|Customer called three times 	|	yes		|1		|3			|2			|
