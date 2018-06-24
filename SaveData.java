import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

/*
 * SaveData class is used to display and store current temperature as well as city name in the database  
 * DataBase is accessed using MongoClient method.
 * I have used localhost port 27017 which is default for MongoDB
 * Created DataBase "WeatherDataBase" and "weather" as a collection of the DataBase "WeatherDataBase"
 */


public class SaveData {

 
	public static void saveData(Double currentTempratureInCelsius, String cityName ){
		try{
			
			/* display current city and temperature*/
			System.out.println("\nCurrent Weather in "+cityName+": "+ currentTempratureInCelsius+"\n");
					
			MongoClient mongoClient = new MongoClient("localhost",27017);
			DB db = mongoClient.getDB("WeatherDataBase");
			DBCollection coll = db.getCollection("weather");
			
			/*Storing city name and temperature */
			BasicDBObject basicDBObject = new BasicDBObject();
			basicDBObject.put("City_name", cityName);
			basicDBObject.put("Temp",currentTempratureInCelsius);
			
			coll.insert(basicDBObject);
			DBCursor cursor = coll.find();
			
			/* Output of DataBase*/
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
