package StepDefinition;

import POM.NavigationElements;
import io.cucumber.java.en.*;

public class LoginLumaSteps {

    NavigationElements navigationElements;

    @Given("User is on Login Page")
    public void user_is_on_login_page() {
     navigationElements = new NavigationElements();
     navigationElements.userOnLoginPage();

    }

    @When("User enter admin credentials")
    public void user_enter_admin_credentials() {
        navigationElements = new NavigationElements();
        navigationElements.userLoginCredentials();
    }
    @Then("User should successfully login")
    public void user_should_successfully_login() {
      navigationElements = new NavigationElements();
      navigationElements.validateUserSuccessfullyLoggedIn();
    }


}
