import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


/*	
 * This class is used to get end point of Weather API, parse the current temperature from the JSON format and store in the database. 
 * method getWeatherAPIOutput gets the input cityName from the main, and added to URL.
 * The final URL is the send to Output class with the help of output method of Output class.
 * And the result of this is stored in weatherData i.e point of Forecast API.  
 * Then weatherData is parsed using JSONToMap class, current temperature is extracted and stored currentTempratureInCelsius.
 * The current temperature and city name is passed to SaveData class with the help of saveData method to store in database.
 */



public class WeatherThread {
	
	public static void getWeatherAPIOutput(String cityName){
	
			Output opt = new Output();
			JSONToMap jtm = new JSONToMap();
			SaveData saveData = new SaveData();
			
			/* APP ID to access the API*/
			String app_id = "6fb5265c1772baedbb525f0fa149b99d";		
	
			/* Weather URL*/
			String url2 = "http://api.openweathermap.org/data/2.5/weather?q="+ cityName +"&appid="+ app_id;
	
			
			Thread t2 = new Thread(() -> {
				String weatherData= opt.output(url2);
				
				if(weatherData!="Invalid City"){	
					
					System.out.println("\nEnd Point of Weather API:\n"+weatherData);
			
					Map<String, Object> respMap = jtm.jsonToMap(weatherData.toString());
					Map<String, Object> mainMap = jtm.jsonToMap(respMap.get("main").toString());
		
					Double currentTempratureInCelsius= (Double) ((Double) mainMap.get("temp")-273.15);
					saveData.saveData(currentTempratureInCelsius, cityName);
					
				}else {
					System.out.println("Invalid City");
					
				}
				
			}

			);
			t2.start();
			
		}

}
