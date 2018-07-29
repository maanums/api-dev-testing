@COATest
Feature: Get Customer Information based on CustomerID

		@Success
    Scenario Outline: Validate COA Get Method
        Given I select the CustomerId as "<CustId>"
        When I access the service "COA.GetCustomerInfo"
  	    Then I extract the customer information from response 
  
  			Examples:  
      |  CustId  			| 
      | 01_Zycus 		  | 
      | 02_LinkedIn   |
      | 03_Test       |
      
      
      
  
             
              
       
        
        
        
        
        

     