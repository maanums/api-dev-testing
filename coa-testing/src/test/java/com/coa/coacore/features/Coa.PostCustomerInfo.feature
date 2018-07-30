@COATest @Post
Feature: Insert Customer Information in json format

		@Success @PostSuccess
    Scenario Outline: Validate COA Post Method for success scenarios
        Given I create customization for "<Customer>"
        When I access the service "COA.PostCustomerInfo"
  	    Then I extract the response information
  
  			Examples:  
      |  Customer 		| 
      | 01_Zycus 		  | 
      | 02_LinkedIn   |
      
      
     @Failure @PostFailure
    Scenario Outline: Validate COA Post Method for failure scenarios
        Given I create customization for "<Customer>"
        When I access the service "COA.PostCustomerInfo"
  	    Then I extract the response information
  
  			Examples:  
      |  Customer  		| 
      | 03_Test_400   |