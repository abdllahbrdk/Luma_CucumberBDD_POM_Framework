package StepDefinition;

import POM.NavigationElements;
import POM.DialogElements;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AddNewAddressSteps {

    NavigationElements navigationElements;
    DialogElements dialogElements;

    @And("User Create a New Address with {string} {string} {string} {string}")
    public void userCreateANewAddressWith(String phoneNumber, String streetAddress, String city, String zip) {
     navigationElements = new NavigationElements();
     dialogElements = new DialogElements();
     dialogElements.createANewAddress(phoneNumber,streetAddress,city,zip);
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
       dialogElements = new DialogElements();
       dialogElements.validateSuccessMessage();
    }
}
