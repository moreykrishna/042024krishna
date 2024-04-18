package com.qa.opencart.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Util;
public class LoginPage 
{
	  //1.declare private driver
		private WebDriver driver;
		private Util eleUtil;
		//page constructor
		public  LoginPage(WebDriver driver)
		{
			this.driver=driver;
			eleUtil=new Util(driver);
		}
		// 3.By Locators
		private By emailId=By.xpath("//input[@id='input-email']");
		private By password=By.xpath("//input[@id='input-password']");
		private By loginBtn=By.xpath("//input[@type='submit']");
		private By registerLink=By.xpath("//a[@class='list-group-item'][normalize-space()='Register']");
		private By forgotPwdLink=By.xpath("//a[@class='list-group-item'][normalize-space()='Register']");
		//Page Actions
		public String getLoginPageTitle()
		{
			String title=eleUtil.waitForTitleIsAndFetch(10, "Account Login");
			System.out.println("login page title " + title);
//			//return eleUtil.doGetTitle(Constants.LOGIN_PAGE_TITLE,Constants.DEFAULT_TIME_OUT);
//			String title= driver.getTitle();
//			System.out.println("login page title is :"+title);
			return title;
			//return util.dogetTitle(Constants.LOGIN_PAGE_TITLE,Constants.DEFAULT_TIME_OUT) check this one
		}
		public String getLoginPageUrl()
		{
			//return util.waitForUrlToContain(Constants.LOGIN_PAGE_URL_FRACTION,Constants.DEFAULT_TIME_OUT);
//			String url=driver.getCurrentUrl();
//			System.out.println("login page title is :"+url);
//			return url;
			String url =eleUtil.waitForURLContainsAndFetch(10, "route=account/login");
			System.out.println("login page url : " + url);
			return url;
		}
		//.check below one also 1:08 2nd video pom
//		public boolean getLoginPageUrl()
//		{
//			//return util.waitForUrlToContain(Constants.LOGIN_PAGE_URL_FRACTION,Constants.DEFAULT_TIME_OUT);
//		}
		public boolean isForgotPwdLinkExist()
		{
			//check is displayed method is there or not
			//return driver.findElement(forgotPwdLink).isDisplayed();
			return eleUtil.waitForElementVisible(forgotPwdLink, 10).isDisplayed();
		}
//		public boolean isRegisterLinkExist()
//		{
//			return driver.findElement(registerLink).isDisplayed();
//		}
		public AccountsPage doLogin(String un, String pwd)
		{
			System.out.println("App cred are :" +un+ ":" +pwd);
			eleUtil.waitForElementVisible(emailId, 10).sendKeys(un);
			eleUtil.doSendKeys(password, pwd);
			eleUtil.doClick(loginBtn);
//			System.out.println("login with : "+un+ " : "+pwd);
////			util.doSendKeys(emailId, un);
////			util.doSendKeys(password, pwd);
////			util.doClick(loginBtn);
//			driver.findElement(emailId).sendKeys(un);
//			driver.findElement(password).sendKeys(pwd);
//			driver.findElement(loginBtn).click();
			return new AccountsPage(driver);
		}
		//@Step("navigating to register page")
		public RegisterPages navigateToRegisterPage() {
			eleUtil.doClick(registerLink);
			return new RegisterPages(driver);
		}
		}
