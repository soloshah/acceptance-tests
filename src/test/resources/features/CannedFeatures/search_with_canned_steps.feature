#@smoke 
#Feature: Search button functionality using canned steps
#	As a user
#	I want to be shown search results
#	So that I can find what I am looking for
#
#Scenario: Search functionality using canned steps
#	Given I navigate to "https://www.nhsbsa.nhs.uk/"
#	When I enter "pensions" into input field having id "edit-aggregated-field"
#		And I click on element having id "edit-submit-search"
#	Then element having class "js-quickedit-page-title" should have text as "Search results"
#		And element having class "search-listing-tags" should have text as "NHS Pensions"
#
#		
#Scenario: Search functionality reusing methods from predefined step definitions and cucumberMethods
#	Given I am on the nhsbsa homepage 
#	When I search nhsbsa site for "pensions"
#	Then I should see the nhsbsa search results page with "NHS Pensions" displayed