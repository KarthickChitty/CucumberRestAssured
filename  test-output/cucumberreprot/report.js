$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/testapi.feature");
formatter.feature({
  "name": "Accessing / Adding and Edit Employee details",
  "description": "  I want to use this feature file to write sceanrios for all Employee related Endpoint",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@APITest"
    }
  ]
});
formatter.scenario({
  "name": "Verify Employee Endpoint returns all employee details",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@APITest"
    },
    {
      "name": "@employeInfo"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have employee base URI",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.i_have_employee_endpoint()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I perfrom a \"GET\" method on endpoint \"/api/v1/employee/1\"",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.i_perfrom_a_method(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should be able to get response for 1 employee",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.i_should_be_able_to_get_response_for_employee(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should be able to verify employee name \"Tiger KSJ Nixon\"",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.i_should_be_able_to_verify_employee_name(String)"
});
formatter.result({
  "error_message": "java.lang.AssertionError: 1 expectation failed.\nJSON path data.employee_name doesn\u0027t match.\nExpected: Tiger KSJ Nixon\n  Actual: Tiger Nixon\n\r\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:64)\r\n\tat java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:500)\r\n\tat java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:481)\r\n\tat org.codehaus.groovy.reflection.CachedConstructor.invoke(CachedConstructor.java:72)\r\n\tat org.codehaus.groovy.reflection.CachedConstructor.doConstructorInvoke(CachedConstructor.java:59)\r\n\tat org.codehaus.groovy.runtime.callsite.ConstructorSite$ConstructorSiteNoUnwrap.callConstructor(ConstructorSite.java:84)\r\n\tat org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCallConstructor(CallSiteArray.java:59)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callConstructor(AbstractCallSite.java:263)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callConstructor(AbstractCallSite.java:277)\r\n\tat io.restassured.internal.ResponseSpecificationImpl$HamcrestAssertionClosure.validate(ResponseSpecificationImpl.groovy:493)\r\n\tat io.restassured.internal.ResponseSpecificationImpl$HamcrestAssertionClosure$validate$1.call(Unknown Source)\r\n\tat io.restassured.internal.ResponseSpecificationImpl.validateResponseIfRequired(ResponseSpecificationImpl.groovy:674)\r\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:64)\r\n\tat java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.base/java.lang.reflect.Method.invoke(Method.java:564)\r\n\tat org.codehaus.groovy.runtime.callsite.PlainObjectMetaMethodSite.doInvoke(PlainObjectMetaMethodSite.java:43)\r\n\tat org.codehaus.groovy.runtime.callsite.PogoMetaMethodSite$PogoCachedMethodSiteNoUnwrapNoCoerce.invoke(PogoMetaMethodSite.java:193)\r\n\tat org.codehaus.groovy.runtime.callsite.PogoMetaMethodSite.callCurrent(PogoMetaMethodSite.java:61)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callCurrent(AbstractCallSite.java:185)\r\n\tat io.restassured.internal.ResponseSpecificationImpl.body(ResponseSpecificationImpl.groovy:261)\r\n\tat io.restassured.specification.ResponseSpecification$body$0.callCurrent(Unknown Source)\r\n\tat io.restassured.internal.ResponseSpecificationImpl.body(ResponseSpecificationImpl.groovy:108)\r\n\tat io.restassured.internal.ValidatableResponseOptionsImpl.body(ValidatableResponseOptionsImpl.java:244)\r\n\tat io.restassured.internal.ValidatableResponseImpl.super$2$body(ValidatableResponseImpl.groovy)\r\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:64)\r\n\tat java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.base/java.lang.reflect.Method.invoke(Method.java:564)\r\n\tat org.codehaus.groovy.reflection.CachedMethod.invoke(CachedMethod.java:107)\r\n\tat groovy.lang.MetaMethod.doMethodInvoke(MetaMethod.java:323)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:1268)\r\n\tat org.codehaus.groovy.runtime.ScriptBytecodeAdapter.invokeMethodOnSuperN(ScriptBytecodeAdapter.java:144)\r\n\tat io.restassured.internal.ValidatableResponseImpl.body(ValidatableResponseImpl.groovy:298)\r\n\tat io.restassured.internal.ValidatableResponseImpl.body(ValidatableResponseImpl.groovy)\r\n\tat step_definitions.StepDefinitions.i_should_be_able_to_verify_employee_name(StepDefinitions.java:47)\r\n\tat ✽.I should be able to verify employee name \"Tiger KSJ Nixon\"(features/testapi.feature:20)\r\n",
  "status": "failed"
});
formatter.write("Scenario is completed with Status: FAILED");
formatter.after({
  "status": "passed"
});
});