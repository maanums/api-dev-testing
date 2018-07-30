@COATest @Post
Feature: Insert Customer Information in json format

		@Success
    Scenario Outline: Validate COA Post Method for success scenarios
        Given I create customization for "<Customer>"
        When I access the service "COA.PostCustomerInfo"
  	    Then I extract the response information
  
  			Examples:  
      |  CustId  			| 
      | 01_Zycus 		  | 
      | 02_LinkedIn   |
      
      
     @Failure
    Scenario Outline: Validate COA Post Method for failure scenarios
        Given I create customization for "<Customer>"
        When I access the service "COA.PostCustomerInfo"
  	    Then I extract the response information
  
  			Examples:  
      |  CustId  			| 
      | 03_Test_400   |
      | 04_Test_404   |