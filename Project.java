
import java.io.File;
import java.io.FileReader;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.Scanner;

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
		Scanner sc = new Scanner(System.in);		
		WeatherThread wt = new WeatherThread();
		ForecastThread ft = new ForecastThread();
		ft.getForecastAPIOutput(city);
		wt.getWeatherAPIOutput(city);
		
		

	}

}
