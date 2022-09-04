package POM;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavigationElements extends BasePOM{

    public NavigationElements(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//ul//a)[1]")
    private WebElement signInButton;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(css = "input[title='Password']")
    private WebElement passwordInput;

    @FindBy(xpath = "(//button[@name='send']//span)[1]")
    private WebElement submitButton;

    @FindBy(xpath = "(//span[text()='Welcome, ken kenn!'])[1]")
    private WebElement welcomeMessage;


    public void userOnLoginPage(){
        Assert.assertTrue(signInButton.isDisplayed());
        signInButton.click();
    }

    public void userLoginCredentials(){
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.sendKeys("ken@gmail.com");
        passwordInput.sendKeys("Ken123456.");
        submitButton.click();
    }

    public void validateUserSuccessfullyLoggedIn() {
        wait.until(ExpectedConditions.visibilityOf(welcomeMessage));
        Assert.assertTrue(welcomeMessage.isDisplayed());

    }
}
