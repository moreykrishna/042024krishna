package com.qa.opencart.tests;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
public class AccountsPageTest extends BaseTest 
{
	@BeforeClass
	public void accPageSetup()
	{
		//accpage=loginPage.doLogin("Nikhilesh@gmail.com", "Nikhilesh@123");
		accpage=loginPage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
	}
	@Test
	public void accPageTitleTest()
	{
		String actTitle=accpage.getAccPageTitle();
		Assert.assertEquals(actTitle, AppConstants.ACCOUNTS_PAGE_TITLE_VALUE);
	}
	@Test
	public void accPageURLTest()
	{
		String actURL = accpage.getAccPageURL();
		Assert.assertTrue(actURL.contains(AppConstants.ACCOUNTS_PAGE_URL_FRACTION_VALUE));
	}
	@Test
	public void isLogoutLinkExistTest()
	{
		Assert.assertTrue(accpage.isLogoutLinkExist());
	}
	@Test
	public void accPageHeadersCountTest()
	{
		List<String> actualAccPageHeadersList = accpage.getAccountsPageHeadersList();
		System.out.println("Acc page header list : " +actualAccPageHeadersList);
		Assert.assertEquals(actualAccPageHeadersList.size(), AppConstants.ACCOUNTS_PAGE_HEADERS_COUNT);
	}
	@Test
	public void accPageHeadersValueTest()
	{
		List<String> actualAccPageHeadersList = accpage.getAccountsPageHeadersList();
		System.out.println("Acc page header list : " +actualAccPageHeadersList);
		System.out.println("Acc page header list : " +AppConstants.EXPECTED_ACCOUNTS_PAGE_HEADERS_LIST);
		Assert.assertEquals(actualAccPageHeadersList.size(), AppConstants.EXPECTED_ACCOUNTS_PAGE_HEADERS_LIST);
	}
	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] { { "Macbook" }, 
			{ "iMac" }};
//			{ "Apple" }, 
//			{ "Samsung" } };
	}
	
	@Test(dataProvider = "getProductData")
	public void searchProductCountTest(String searchKey) {
		searchpage = accpage.performSearch(searchKey);
		Assert.assertTrue(searchpage.getSearchProductsCount() > 0);
	}
	@DataProvider
	public Object[][] getProductTestData() {
		return new Object[][] { { "Macbook", "MacBook Pro" }};
//			{ "Macbook", "MacBook Air" }, { "iMac", "iMac" },
//		
//				{ "Apple", "Apple Cinema 30\"" }, { "Samsung", "Samsung SyncMaster 941BW" },
//				{ "Samsung", "Samsung Galaxy Tab 10.1" }, };
	}

	@Test(dataProvider = "getProductTestData")
	public void searchProductTest(String searchKey, String productName)
	{
		searchpage=accpage.performSearch(searchKey);
		if(searchpage.getSearchProductsCount()>0)
		{
		ProductInfoPage=searchpage.selectProduct(productName);
		String actProductHeader=ProductInfoPage.getProductHeaderValue();
		Assert.assertEquals(actProductHeader, productName);
		}
	}
}
