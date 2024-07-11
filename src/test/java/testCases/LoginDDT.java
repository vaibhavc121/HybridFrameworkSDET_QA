package testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.LoginPage;
import utilities.XLUtils;

public class LoginDDT extends BaseClass
{
	@Test(dataProvider = "logindata")
	public void loginddtTest(String user, String pwd) throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver); // using the driver object below to call the methods
		lp.setUname(user);
		// logger.info("user name is provided");
		lp.setPwd(pwd);
		// logger.info("pwd is provided");
		lp.clkLogin();
		Thread.sleep(3000);

		if (isAlertPresent() == true)
		{
			driver.switchTo().alert().accept(); // close alert
			driver.switchTo().defaultContent(); // focus on main page
			Assert.assertTrue(false); // failure case
			// logger.warn("login failed");
		}
		else
		{
			Assert.assertTrue(true);
			// logger.info("login passed");
			lp.clkLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept(); // close the logout alert
			driver.switchTo().defaultContent();
		}
	}

	public boolean isAlertPresent() // user defined method is created to check alert is present or not
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch (NoAlertPresentException e)
		{
			return false;
		}

	}

	@DataProvider(name = "logindata")
	String[][] getData() throws IOException
	{
		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\testdata.xlsx";
		// to read the data from excel, 1st we need to count no of rows and no of cols
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rownum][colcount];
		for (int i = 1; i <= rownum; i++)
		{
			for (int j = 0; j < colcount; j++)
			{
				// in 2d array we have to start from 0 (i-1)
				// in excel we exclude the header so we start from 1st index (1)
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j); // 1 0
			}
		}

		return logindata;
	}

}
