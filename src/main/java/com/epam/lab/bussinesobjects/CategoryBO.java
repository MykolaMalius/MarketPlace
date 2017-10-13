package com.epam.lab.bussinesobjects;
import com.epam.lab.page.CategoryPage;
import com.epam.lab.page.FooterPage;
import com.epam.lab.page.SearchBoxPage;

public class CategoryBO {
    private FooterPage footerPage = new FooterPage();
    private SearchBoxPage searchBoxPage = new SearchBoxPage();
    private CategoryPage categoryPage = new CategoryPage();

    public void testCategoryPages() {
        footerPage.checkFooteLinks();
        searchBoxPage.verifyFindBox();
        searchBoxPage.checkPresentOfResults();
        categoryPage.chooseProductFromMenu();
        categoryPage.buyChosenProduct();
    }
}
