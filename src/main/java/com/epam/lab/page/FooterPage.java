package com.epam.lab.page;
import com.epam.lab.utils.EnvProperties;
import com.epam.lab.utils.SingletonDriver;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class FooterPage extends PageObject {
    static final Logger LOG = Logger.getLogger(FooterPage.class);
    private boolean isFooterLinkValid = true;
    private WebDriver driver = SingletonDriver.getInstance();
    private final Wait wait = new WebDriverWait(driver, 15, 1000);
    private EnvProperties envProperties = new EnvProperties();

    @FindBy(xpath = "//*[@id=\"pb-iframe1\"]")
    public WebElement iFrame;
    public void checkFooteLinks(){
        driver.get(envProperties.getBaseUrl());

        for(int i = 1;i<6;i++){
            List<WebElement> listOfLiniks = driver.switchTo().frame(iFrame).findElements(By.xpath("/html/body/footer/div/section[1]/div/nav[1]/ul/li/a"));
            ((JavascriptExecutor)driver).executeScript("window.scrollBy(" + 100000 + ","
                    + 100000 + ");");
                wait.until(ExpectedConditions.visibilityOf(listOfLiniks.get(i)));
                listOfLiniks.get(i).click();
                /*if(driver.getCurrentUrl().equals("https://marketplace.plenti.com/h____.htm")){
                    isFooterLinkValid = false;
                    LOG.debug("Link is not valid");
                }
                Assert.assertTrue(isFooterLinkValid);*/
                LOG.info("Number of link:"+ i + ".Name of link:" + driver.getCurrentUrl());
                driver.navigate().back();

        }

    }
}
