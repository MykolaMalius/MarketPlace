package com.epam.lab.page;
import com.epam.lab.utils.EnvProperties;
import com.epam.lab.utils.SingletonDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryPage extends PageObject {
    static final Logger LOG = Logger.getLogger(CategoryPage.class);
    private WebDriver driver = SingletonDriver.getInstance();
    private EnvProperties envProperties = new EnvProperties();
    private final Wait wait = new WebDriverWait(driver, 15, 1000);
    private Actions actions = new Actions(driver);

    @FindBy(xpath = "//div/div[1]/div[2]/div[2]/ul/li[1]/span")
    private WebElement categoryMenu;
    @FindBy(xpath = "//div[1]/div[2]/div[2]/ul/li[1]/div/ul/li[1]/a")
    private WebElement firstResult;
    @FindBy(xpath = "//*[@id=\"mn_bc\"]/div[3]/div/div[2]/div/div[2]/div[2]/div/div[1]/div/div[1]/a/img")
    private WebElement buyFirstResult;
    @FindBy(css = "a.mn_button.mn_shopBtn")
    private WebElement buyButton;
    @FindBy(xpath = "//*[@id=\"mmLightboxBtn\"]")
    private WebElement okButton;

    public void chooseProductFromMenu() {
        SingletonDriver.getInstance().get(envProperties.getCategoryURL());
        wait.until(ExpectedConditions.visibilityOf(categoryMenu));
        actions.moveToElement(categoryMenu).perform();
        firstResult.click();
    }
    public void buyChosenProduct(){
        wait.until(ExpectedConditions.visibilityOf(buyFirstResult));
        buyFirstResult.click();
        okButton.click();
        wait.until(ExpectedConditions.visibilityOf(buyButton));
        buyButton.click();
    }
}
