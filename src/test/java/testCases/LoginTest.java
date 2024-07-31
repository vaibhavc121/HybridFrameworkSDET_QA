package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.LoginPage;

public class LoginTest extends BaseClass
{
	@Test
	public void login()
	{

		LoginPage pg = new LoginPage(driver); // driver object created in base class using everywhere

		// driver.get(baseurl);
		pg.setUname(username);
		pg.setPwd(password);
		pg.clkLogin();

		Assert.assertEquals(driver.getTitle(), "GTPL Bank Manager HomePage");

		// using below assertion, on console, not able to compare expected and actual
		// result
		/*
		 * if (driver.getTitle().equals(" GTPL Bank Manager HomePage ")) {
		 * Assert.assertTrue(true); } else { Assert.assertTrue(false); }
		 */

	}

}
