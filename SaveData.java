import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class SaveData {

 
	public static void saveData(Double currentTempratureInCelsius, String cityName ){
		try{
			//Object obj = parser.parse(weatherData);
			//JSONObject jsonObject = (JSONObject) obj;
					
			//Map<String, Object> respMap = jsonToMap(weatherData.toString());
			//Map<String, Object> mainMap = jsonToMap(respMap.get("main").toString());
		
			//Double currentTempratureInCelsius= (Double) ((Double) mainMap.get("temp")-273.15);
					
			System.out.println("\nCurrent Weather in "+cityName+": "+ currentTempratureInCelsius+"\n");
					
			MongoClient mongoClient = new MongoClient("localhost",27017);
			DB db = mongoClient.getDB("newDataBase");
			DBCollection coll = db.getCollection("weather");
					
						//coll.drop();
						
			BasicDBObject basicDBObject = new BasicDBObject();
			basicDBObject.put("City_name", cityName);
			basicDBObject.put("Temp",currentTempratureInCelsius);
			
			coll.insert(basicDBObject);
			DBCursor cursor = coll.find();
				
			System.out.println("\nOutput of Database :\n");
			while(cursor.hasNext()){
				int i=1;
				System.out.println(cursor.next());
				i++;
			}
				
	} catch (Exception e) {
		System.out.println(e);
		}
	}
}
