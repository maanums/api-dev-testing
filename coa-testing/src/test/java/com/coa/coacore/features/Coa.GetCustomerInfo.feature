@COATest @Get
Feature: Get Customer Information based on CustomerID

		@Success @GetSuccess
    Scenario Outline: Validate COA Get Method for success scenarios
        Given I select the CustomerId as "<CustId>"
        When I access the service "COA.GetCustomerInfo"
  	    Then I extract the customer information from response 
  
  			Examples:  
      |  CustId  			| 
      | 01_Zycus 		  | 
      | 02_LinkedIn   |
      
      
     @Failure @GetFailure
    Scenario Outline: Validate COA Get Method for failure scenarios
        Given I select the CustomerId as "<CustId>"
        When I access the service "COA.GetCustomerInfo"
  	    Then I extract the customer information from response 
  
  			Examples:  
      |  CustId  			| 
      | 03_Test_401   |
      | 04_Test_500   |
      
      
      
  
             
              
       
        
        
        
        
        

     