package com.epam.lab.page;
import com.epam.lab.utils.SingletonDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NarrowResultsPage extends PageObject {
    static final Logger LOG = Logger.getLogger(NarrowResultsPage.class);
    private WebDriver driver = SingletonDriver.getInstance();
    private final Wait wait = new WebDriverWait(driver, 15, 1000);

    @FindBy(xpath = "//div[2]/aside/div[2]/div[1]/ul/li[1]/a")
    private WebElement phoneCategoryBtn;
    @FindBy(xpath = "//*[@id=\"mn_sr\"]/div[3]/div/div[2]/div/div[2]/div[1]/div[3]/span[1]/a")
    private WebElement resultBtn;
    @FindBy(xpath = "//div[2]/aside/div[2]/div[2]/ul/li[1]/a")
    private WebElement priceBelowBtn;
    @FindBy(xpath = "//*[@id=\"mn_sr\"]/div[3]/div/div[2]/div/div[2]/div[1]/div[3]/span[2]/a")
    private WebElement betweenResultBtn;
    @FindBy(xpath = "//div[2]/aside/div[2]/div[2]/ul/li[2]/a")
    private WebElement priceAboveBtn;
    @FindBy(xpath = "//div[2]/div/div[2]/div[1]/div[3]/span[2]/a")
    private WebElement aboveResultBtn;

    public void checkPhoneOption(){
        phoneCategoryBtn.click();
        if(resultBtn.getAttribute("title").contains("phones")){
            LOG.info("Phone category is ok");
        }
        else {
            LOG.debug("Phone category is not displayed");
        }
    }
    public void checkBelowPriceOption(){
        priceBelowBtn.click();
        wait.until(ExpectedConditions.visibilityOf(betweenResultBtn));
        if(resultBtn.getAttribute("title").contains("phones")){
            LOG.info("Phone category is ok");
        }
        else {
            LOG.debug("Phone category is not displayed");
        }
    }
    public void checkAbovePriceOption(){
        priceAboveBtn.click();
        wait.until(ExpectedConditions.visibilityOf(aboveResultBtn));
        if(aboveResultBtn.getAttribute("title").contains("above")){
            LOG.info("Above $25 category is allright");
        }
        else {
            LOG.debug("Above $25 category is not displayed");
        }
    }

}
