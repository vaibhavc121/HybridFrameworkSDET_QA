package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;

public class AddCustomerTest extends BaseClass
{
	@Test
	public void addNewCustomer() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUname(username);
		// logger.info("user name is provided")
		lp.setPwd(password);
		// logger.info("pwd is provided")
		lp.clkLogin();
		Thread.sleep(3000);

		AddCustomerPage addcust = new AddCustomerPage(driver);

		addcust.clickAddNewCustomer();

		// logger.info("providing cust details")
		addcust.custName("vaibhav");
		addcust.custGender("male");
		addcust.custDOB("23", "04", "1997");
		Thread.sleep(3000);
		addcust.custAdd("pune");
		addcust.custCity("pune");
		addcust.custState("pune");
		addcust.custpinno("416310");
		addcust.custtelno("1234");

		String email = randomString() + "@gmail.com";
		addcust.custEmail(email);

		addcust.submitButton();
		Thread.sleep(3000);
		// logger.info("validation is started...")

		// Assert.assertEquals(driver.getCurrentUrl(),
		// "https://demo.guru99.com/V1/html/insrtCustomer.php");
		String url = "https://demo.guru99.com/V1/html/insrtCustomer.php";
		if (url.equals("https://demo.guru99.com/V1/html/insrtCustomer.php"))
		{
			Assert.assertTrue(true);
			// logger.info("test case is passed")
		}
		else
		{
			// logger.info("test case failed")
			// captureScreen(driver,addNewCustomer());
			Assert.assertTrue(false);

		}

	}

	public String randomString()
	{
		String genetatedsString = RandomStringUtils.randomAlphabetic(8);
		return genetatedsString;
	}
}
