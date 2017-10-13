package com.epam.lab.page;
import com.epam.lab.utils.EnvProperties;
import com.epam.lab.utils.SingletonDriver;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchBoxPage extends FooterPage {
    static final Logger LOG = Logger.getLogger(SearchBoxPage.class);
    private WebDriver driver = SingletonDriver.getInstance();
    private EnvProperties envProperties = new EnvProperties();
    private final Wait wait = new WebDriverWait(driver, 15, 1000);

    @FindBy(xpath = "//*[@id=\"mn_quickFindBox\"]")
    public WebElement searchLable;
    @FindBy(css = "div.mn_quickFindResults")
    public WebElement listOfResults;
    @FindBy(xpath = "//*[@id=\"mn_b\"]/div[3]/div/div[2]/div[3]/form/div/ul/li[1]/a")
    public WebElement firstResult;
    @FindBy(id = "mmLightboxClose")
    WebElement okButton;
    @FindBy(css = "div.mn_innerWrap")
    WebElement firstShop;
    public void verifyFindBox() {
        driver.get(envProperties.getSearchURL());
        wait.until(ExpectedConditions.visibilityOf(searchLable));
        searchLable.click();
        searchLable.sendKeys("a");

    }
    public void checkPresentOfResults(){
        boolean presentOfResults = listOfResults.isDisplayed();
        LOG.info("Present of results:"+presentOfResults);
        firstResult.click();
        okButton.click();
        driver.navigate().back();
        boolean presentOfShop = firstShop.isDisplayed();
        Assert.assertTrue(presentOfShop);
        LOG.info("Present of shop:" + presentOfShop);
    }

}
