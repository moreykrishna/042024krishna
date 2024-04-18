package com.qa.opencart.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class LoginPageTest extends BaseTest 
{
	//private static final String LoginPage = null;
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String actTitle=loginPage.getLoginPageTitle();
		System.out.println("page title is : "+actTitle);
		Assert.assertEquals(actTitle,AppConstants.ACCOUNTS_PAGE_TITLE_VALUE);
	}
@Test(priority=2)
public void loginPageUrlTest()
{
	//Assert.assertTrue(LoginPage.getLoginPageUrl());
String actUrl=loginPage.getLoginPageUrl();
System.out.println("page url: " + actUrl);
Assert.assertTrue(actUrl.contains(AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE));
}
@Test(priority=3)
public void forgotPwdLinkTest()
{
	Assert.assertTrue(loginPage.isForgotPwdLinkExist());
}
//@Test(priority=4)
//public void registerLinkTest() {
//	Assert.assertTrue(loginPage.isRegisterLinkExist());
//}
@Test(priority=4)
public void loginTest() {
//	loginPage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
//	Assert.assertEquals(accountPage.getAccountPageTitle(),Constants.ACCOUNTS_PAGE_TITLE);
	//accpage=loginPage.doLogin("Nikhilesh@gmail.com", "Nikhilesh@123");
	accpage=loginPage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
	Assert.assertTrue(accpage.isLogoutLinkExist());
}
	
}
