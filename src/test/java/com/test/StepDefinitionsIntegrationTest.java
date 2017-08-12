package com.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.springframework.http.HttpStatus;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitionsIntegrationTest extends SpringIntegrationTest {

    @When("^the client calls /sum with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void the_client_calls_sum_with_and(String arg1, String arg2) throws Throwable {
        executeGet("http://localhost:8080/sum?value1="+arg1+"&value2="+arg2+"");
    }

    @Then("^the client receives status code of (\\d+)$")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
        final HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();
        assertThat(currentStatusCode.value(), is(statusCode));
    }

    @And("^the client receives sum (\\d+)$")
    public void the_client_receives_sum_body(int sum) throws Throwable {
        assertThat(Integer.valueOf(latestResponse.getBody()), is(sum));
    }
}