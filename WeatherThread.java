import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

	public class WeatherThread {
		
		public static void getWeatherAPIOutput(String cityName){
	
			Output opt = new Output();
			JSONToMap jtm = new JSONToMap();
			SaveData saveData = new SaveData();
			String app_id = "6fb5265c1772baedbb525f0fa149b99d";		
	
			String url2 = "http://api.openweathermap.org/data/2.5/weather?q="+ cityName +"&appid="+ app_id;
	
	
	

			Thread t2 = new Thread(() ->
			{
				String weatherData= opt.output(url2);
					
				System.out.println("\nEnd Pint of Weather API:\n"+weatherData);
			
				Map<String, Object> respMap = jtm.jsonToMap(weatherData.toString());
				Map<String, Object> mainMap = jtm.jsonToMap(respMap.get("main").toString());
		
				Double currentTempratureInCelsius= (Double) ((Double) mainMap.get("temp")-273.15);
		
				saveData.saveData(currentTempratureInCelsius, cityName);
		

			}

			);
	
	
			t2.start();
		}

}
