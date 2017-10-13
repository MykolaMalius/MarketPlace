package com.epam.lab.marketplacetest;
import com.epam.lab.bussinesobjects.CategoryBO;
import com.epam.lab.bussinesobjects.SearchBO;
import com.epam.lab.utils.SingletonDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MarketPlaceTest {
    private CategoryBO categoryBO;
    private SearchBO searchBO;
    @BeforeClass
    public void initializeBO(){
      categoryBO = new CategoryBO();
      searchBO = new SearchBO();
    }

    @Test
    public void testMarketPlace(){
      categoryBO.testCategoryPages();
      searchBO.testSearch();
    }
    @AfterClass
    public void closeDriver(){
        SingletonDriver.getInstance().quit();
    }
}
