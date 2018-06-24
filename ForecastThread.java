
/*
	 * This class is used to get end point of Forecast API and display the JSON format 
	 * method getForecastAPIOutput gets the input cityName from the main, and added to url.
	 * The final URL is the send to Output class with the help of output method of Output class
	 * And the result of this is stored in weatherData i.e point of Forecast API  
	 */

public class ForecastThread {

	
	public static void getForecastAPIOutput(String cityName){
		
		
		/* APP ID to access the API*/
		String app_id = "6fb5265c1772baedbb525f0fa149b99d";
		/* URL to access Forecast API*/
		String url1 = "http://api.openweathermap.org/data/2.5/forecast?q="+ cityName +"&mode=json&appid="+ app_id;
		Output opt = new Output();
		
		Thread t1 = new Thread(() -> { 
			String weatherData= opt.output(url1);
			
			if(weatherData!="Invalid City"){
				
				System.out.println("\nEnd Point of Forecast API :\n"+ weatherData);
				
			} else {
				System.out.println("Invalid City");
				
			}
			
	 	}
	    );
		
		t1.start();
	}
}
