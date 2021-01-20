#Author: Karthick Chitty

@Scope_and_CURD
Feature: Application scope and Create/Update/Read/Delete options feature validation

#Background: I start up a ripleapp session

  @sessionscope @scope
  Scenario: Verify session scope value gets retained and destroyed when session ends
    Given rippleapp scope session is up and running
    When I perfrom a "GET" method on endpoint "ScopeSession"
    Then I should see session current message "Karthiga"
    	And I should see session previous message "null"
    When I perfrom a "GET" method on endpoint "ScopeSession"
    Then I should see session current message "Karthiga"
    	And I should see session previous message "Karthiga"
    When I logout from the session
    And I perfrom a "GET" method on endpoint "ScopeSession"
    Then I should see session current message "Karthiga"
    	And I should see session previous message "null"
    
  @applicationscope @scope
  Scenario: Verify application scope value gets retained and not destroyed when session ends
    Given rippleapp scope session is up and running
    When I perfrom a "GET" method on endpoint "ScopeApplication"
    Then I should see session current message "Karthiga"
    	And I should see session previous message "null"
    When I perfrom a "GET" method on endpoint "ScopeApplication"
    Then I should see session current message "Karthiga"
    	And I should see session previous message "Karthiga"
    When I logout from the session
    And I perfrom a "GET" method on endpoint "ScopeApplication"
    Then I should see session current message "Karthiga"
    	And I should see session previous message "Karthiga"
    	
    	
  @createUser @CURD
  Scenario: Verify application create user creats an entry
    Given rippleapp scope session is up and running
    When I perfrom a "POST" method on endpoint "CreateUser"
    Then I should see new user got added
    When I perfrom a "GET" method on endpoint "GetUser"
    Then I should see new user as part of response
    
    
