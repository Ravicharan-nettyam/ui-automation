Feature: Telus Internet Search Exploration

 
    
@Telus_Search_001
Scenario: Exploration of Telus Internet service

	Given Launch the Telus.com application
	When Click the Search bar
	And Enter "internet" in search field
	And Select 3rd option from drop-down list
	Then Comparison of text in search field with heading of results Page
	And Check minimum six hyperlinks are present in search page
	And Click the relevant Hyperlink Page to explore further
