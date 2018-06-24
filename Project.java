import java.io.File;
import java.io.FileReader;
import java.net.UnknownHostException;
import java.util.Properties;


/*
 * Project is main class
 * Here we are getting city name that is store in config file 
 * once city name is extracted from config file it is passed as a input for cityName to complete URL's and access the API  
 */
public class Project {	
	public static void main(String[] args) throws UnknownHostException {
		
	File configFile = new File("/Users/asingh72/Documents/workspace/Project/src/config.properties");
	
		String city = "";
		try {
		    FileReader reader = new FileReader(configFile);
		    Properties props = new Properties();
		    props.load(reader);
		    city = props.getProperty("city");  
		    reader.close();
		} catch (Exception ex) {
			  System.out.print(ex);
		} 		
		WeatherThread wt = new WeatherThread();
		ForecastThread ft = new ForecastThread();
	
		ft.getForecastAPIOutput(city);
		wt.getWeatherAPIOutput(city);
		
	}

}
