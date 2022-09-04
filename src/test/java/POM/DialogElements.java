package POM;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class DialogElements extends BasePOM{

    public DialogElements(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//li//button)[1]")
    private WebElement welcomeMessageButton;

    @FindBy(xpath = "(//button[@type='button']//span)[4]")
    private WebElement addNewAddress;

    @FindBy(xpath = "(//ul//a)[1]")
    private WebElement myAccountButton;

    @FindBy(xpath = "//span[text()='Manage Addresses']")
    private WebElement manageAddressesButton;

    @FindBy(id = "telephone")
    private WebElement phoneNumberInput;

    @FindBy(id = "street_1")
    private WebElement streetAddressInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "zip")
    private WebElement zipInput;

    @FindBy(css = "button[title='Save Address']")
    private WebElement saveAddressButton;

    @FindBy(id = "region_id")
    private WebElement stateDropDown;

    @FindBy(css = "div[role='alert']>div")
    private WebElement successMessage;

    @FindBy(xpath = "(//span//span//img)[3]")
    private WebElement productSelection;

    @FindBy(id = "option-label-size-143-item-169")
    private WebElement largeSizeButton;

    @FindBy(id = "product-addtocart-button")
    private WebElement addToCartButton;

    @FindBy(id = "option-label-color-93-item-52")
    private WebElement colorButton;

    @FindBy(xpath = "(//div[@class='messages']//div)[2]")
    private WebElement productAdded;

    @FindBy(xpath = "(//div[@data-block='minicart']//a)[1]")
    private WebElement basket;

    @FindBy(id = "top-cart-btn-checkout")
    private WebElement checkoutButton;

    @FindBy(name = "ko_unique_1")
    private WebElement shippingRadioButton;

    @FindBy(xpath = "//button//span[text()='Next']")
    private WebElement nextButton;

    @FindBy(xpath = "//button//span[text()='Place Order']")
    private WebElement placeOrderButton;

    @FindBy(xpath = "//span[text()='Thank you for your purchase!']")
    private WebElement purchaseSuccessMessage;

    @FindBy(xpath = "(//li/span)[2]")
    private WebElement reviewAndPayments;

    @FindBy(xpath = "//*[@id='checkout-payment-method-load']/div/div/div[2]/div[2]/div[4]/div/button")
    public WebElement placeOrderButton2;

    @FindBy(css = "body[class='checkout-index-index page-layout-checkout']")
    private WebElement mainBody;


    public void createANewAddress(String phoneNumber,String streetAddress,String city,String zip){
        wait.until(ExpectedConditions.elementToBeClickable(welcomeMessageButton)).click();
        wait.until(ExpectedConditions.visibilityOf(myAccountButton)).click();
        wait.until(ExpectedConditions.visibilityOf(manageAddressesButton)).click();
        wait.until(ExpectedConditions.visibilityOf(addNewAddress)).click();
        phoneNumberInput.sendKeys(phoneNumber);
        streetAddressInput.sendKeys(streetAddress);
        cityInput.sendKeys(city);
        Select select = new Select(stateDropDown);
        select.selectByVisibleText("California");
        zipInput.sendKeys(zip);
        wait.until(ExpectedConditions.visibilityOf(saveAddressButton)).click();
    }

    public void validateSuccessMessage(){
        wait.until(ExpectedConditions.urlContains("index"));
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        Assert.assertTrue(successMessage.isDisplayed());
        Assert.assertTrue(successMessage.getText().contains("saved".toLowerCase()));
    }

    public void selectProduct()  {
        wait.until(ExpectedConditions.visibilityOf(productSelection)).click();
        wait.until(ExpectedConditions.urlContains("tank"));
        wait.until(ExpectedConditions.elementToBeClickable(largeSizeButton)).click();

        wait.until(ExpectedConditions.visibilityOf(colorButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    public void validateProductAddedMessage() {
        Assert.assertTrue(productAdded.isDisplayed());
        Assert.assertTrue(productAdded.getText().toLowerCase().contains("added"));
    }

    public void proceedToCheckout()  {
        wait.until(ExpectedConditions.elementToBeClickable(basket)).click();
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(shippingRadioButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
        BasePOM.Wait(3);
        wait.until(ExpectedConditions.attributeContains(mainBody,"aria-busy","false"));
        Actions actions = new Actions(driver);
        actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton2))).click().build().perform();

    }

    public void validatePurchase() {
        Assert.assertTrue(purchaseSuccessMessage.isDisplayed());
        Assert.assertTrue(purchaseSuccessMessage.getText().toLowerCase().contains("thank you"));
    }


}
