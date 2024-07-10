package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig
{
	Properties pro;

	public ReadConfig() // constructor which is load the file
	{
		File src = new File("./src/test/resources/configfiles/config.properties"); // get the file path
		try
		{
			pro = new Properties();
			FileInputStream fis = new FileInputStream(src); // open the file in the read mode
			pro.load(fis);

		}
		catch (Exception e)
		{
			System.out.println("exception is: " + e.getMessage());
		}
	}

	public String getApplicationUrl()
	{
		String url = pro.getProperty("baseurl");
		return url;
	}

	public String getUserName()
	{
		String username = pro.getProperty("username");
		return username;
	}

	public String getPassword()
	{
		String password = pro.getProperty("password");
		return password;
	}
}
