package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	WebDriver ldriver;

	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	// identify the elements which are present in the login page
	@FindBy(xpath = "//input[@name='uid']")
	WebElement uid;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//input[@name='btnLogin']")
	WebElement btnLogin;

	@FindBy(xpath = "//a[normalize-space()='Log out']")
	WebElement logOut;

	public void setUname(String uname)
	{
		uid.sendKeys(uname);
	}

	public void setPwd(String pwd)
	{
		password.sendKeys(pwd);
	}

	public void clkLogin()
	{
		btnLogin.click();
	}

	public void clkLogout()
	{
		logOut.click();
	}

}
