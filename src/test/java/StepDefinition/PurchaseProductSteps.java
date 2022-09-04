package StepDefinition;

import POM.DialogElements;
import io.cucumber.java.en.*;

public class PurchaseProductSteps {

    DialogElements dialogElements;

    @Given("User select a product from homepage")
    public void user_select_a_product_from_homepage()  {
     dialogElements = new DialogElements();
     dialogElements.selectProduct();
     dialogElements.validateProductAddedMessage();

    }
    @Given("User purchase the product")
    public void user_purchase_the_product() throws InterruptedException {
        dialogElements = new DialogElements();
        dialogElements.proceedToCheckout();
    }
    @Then("User should see success message")
    public void user_should_see_success_message() {
     dialogElements = new DialogElements();
     dialogElements.validatePurchase();
    }

}
