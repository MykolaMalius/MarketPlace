package com.epam.lab.page;
import com.epam.lab.utils.EnvProperties;
import com.epam.lab.utils.SingletonDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductSearchPage extends PageObject {
    static final Logger LOG = Logger.getLogger(ProductSearchPage.class);
    private WebDriver driver = SingletonDriver.getInstance();
    private EnvProperties envProperties = new EnvProperties();
    private final Wait wait = new WebDriverWait(driver, 15, 1000);

    @FindBy(xpath = "//div/div[2]/div/form/input")
    private WebElement searchInput;
    @FindBy(xpath = "//div/div[2]/div/form/button")
    private WebElement searchButton;
    @FindBy(xpath = "//div/div[2]/div/div[1]/div/a[2]")
    private WebElement listViewBtn;
    @FindBy(xpath = "//div/div[2]/div/div[1]/div/a[1]")
    private WebElement gridViewBtn;

    public void searchSomeProducts(){
      driver.get(envProperties.getCategoryURL());
      wait.until(ExpectedConditions.visibilityOf(searchInput));
      searchInput.click();
      searchInput.sendKeys("ipod");
      searchButton.click();
    }
    public void switchBetweenViews(){
        wait.until(ExpectedConditions.visibilityOf(listViewBtn));
        if(listViewBtn.getAttribute("aria-pressed").contains("true")){
            LOG.info("List view is displayed");
        }
        else {
            LOG.debug("List view is not displayed");
        }
        gridViewBtn.click();
        if(gridViewBtn.getAttribute("aria-pressed").contains("true")){
            LOG.info("Grid view is displayed");
        }
        else{
            LOG.debug("Grid view is not displayed");
        }
    }

}
