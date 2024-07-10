package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import utilities.ReadConfig;

public class BaseClass
{
	ReadConfig rc = new ReadConfig();
	public static WebDriver driver;
	public String baseurl = rc.getApplicationUrl();
	public String username = rc.getUserName();
	public String password = rc.getPassword();

	@Parameters("browser") // received parameter and value-br from testng.xml file(testrunner folder)
	@BeforeClass
	public void setup(String br)
	{
		if (br.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			// driver.get("https://demo.guru99.com/V1/index.php");
		}
		else if (br.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			// driver.get("https://demo.guru99.com/V1/index.php");
		}

		driver.get(baseurl);
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
