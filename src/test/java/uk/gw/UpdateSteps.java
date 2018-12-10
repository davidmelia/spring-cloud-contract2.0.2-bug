package uk.gw;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public class UpdateSteps extends CucumberStep {

  private HttpEntity<Map<String, String>> requestEntity;
  private ResponseEntity<?> responseEntity;

  private String email;

  @Autowired
  private TestRestTemplate dao;

  @Given("^an email address \"([^\"]*)\"$")
  public void givenAnEmail(String email) {
    this.email = email;
  }

  @Given("^a request with a valid authorisation token$")
  public void givenARequestWithAValidAuthorizationToken() throws Throwable {
    Map<String, String> body = new HashMap<>();
    body.put("email", email);
    requestEntity = new HttpEntity<>(body);
  }

  @When("^i update the email address$")
  public void whenTheApiRequestsAnUpdate() {
    responseEntity = dao.exchange("/api/2/root", HttpMethod.PUT, requestEntity, String.class, new Object[] {});
  }

  @Then("^the API returns the HTTP status code of (\\d+)$")
  public void thenTheResponseIsTheStatusCode(int statusCode) throws Throwable {
    assertEquals(statusCode, responseEntity.getStatusCodeValue());
  }

}
