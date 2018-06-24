package WithUI;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

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
				String re=result.toString();		
				return re;
										
			} catch(Exception e){
				
				return "error";
			}			
	}
	
	
}
