import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/*
 * Output class is used to get end point of API's
 * 
 */



public class Output {

	
	public static String output(String urlS){		
		try{
				StringBuilder result = new StringBuilder();
				URL url = new URL(urlS);
				URLConnection conn = url.openConnection();
				BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line;
				
				
				while((line = rd.readLine()) != null){
					result.append(line);
				}
				rd.close();						
				String json = result.toString();		
				return json;
										
			} catch(Exception e){
				
				return "Invalid City";
			}			
	}
	
	
}
