package utilities;

import org.testng.ITestContext;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;

public class Reporting extends TestListenerAdapter
{
	public ExtentReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	public void onStart(ITestContext testContext)
	{
		/*
		 * String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new
		 * Date()); // time stamp String repName = "Test-Report-" + timeStamp + ".html";
		 * 
		 * htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") +
		 * "/test-output/" + repName); // specify // location ((ExtentSparkReporter)
		 * htmlReporter).loadXMLConfig(System.getProperty("user.dir") +
		 * "/extent-config.xml");
		 * 
		 * extent = new ExtentReports();
		 * 
		 * extent.attachReporter(htmlReporter); extent.setSystemInfo("Host name",
		 * "localhost"); extent.setSystemInfo("Environment", "QA");
		 * extent.setSystemInfo("user", "pavan");
		 * 
		 * ((ExtentSparkReporter)
		 * htmlReporter).config().setDocumentTitle("InetBanking Test Project"); // Title
		 * of report ((ExtentSparkReporter)
		 * htmlReporter).config().setReportName("Functional Test Report"); // name of
		 * the report ((ExtentSparkReporter)
		 * htmlReporter).config().setTestViewChartLocation(ChartLocation.TOP); //
		 * location of the chart
		 */
	}

}
