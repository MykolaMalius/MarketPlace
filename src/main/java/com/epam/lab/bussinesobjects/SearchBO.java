package com.epam.lab.bussinesobjects;
import com.epam.lab.page.NarrowResultsPage;
import com.epam.lab.page.ProductSearchPage;

public class SearchBO {
    private ProductSearchPage productSearchPage = new ProductSearchPage();
    private NarrowResultsPage narrowResultsPage = new NarrowResultsPage();

    public void testSearch(){
        productSearchPage.searchSomeProducts();
        productSearchPage.switchBetweenViews();
        narrowResultsPage.checkPhoneOption();
        narrowResultsPage.checkBelowPriceOption();
        narrowResultsPage.checkAbovePriceOption();
    }
}
