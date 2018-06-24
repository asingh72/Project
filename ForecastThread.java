
public class ForecastThread {

	
	public static void getForecastAPIOutput(String cityName){
		
		String app_id = "6fb5265c1772baedbb525f0fa149b99d";	
		String url1 = "http://api.openweathermap.org/data/2.5/forecast?q="+ cityName +"&mode=json&appid="+ app_id;
		Output opt = new Output();
		
		Thread t1 = new Thread(() ->
		{ 
			
			System.out.println("\nEnd Point of Forcast API :\n"+opt.output(url1));
				
		}
	);
		
		t1.start();
	}
}
