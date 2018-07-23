The application is developed in two different ways.<br>
1. Without UI.<br>
2. With UI.<br> 
<br>
<br>
Without UI<br>
•    This is the list of classes for Without UI part<br>
  o    Project.java<br>
  o    WeatherThread.java<br>
  o    ForecastThread.java<br>
  o    Output.java<br>
  o    JSONToMap.java<br>
  o    SaveData.java<br>
  o    Config.properties<br>
•    Without UI I am taking input (City Name) from Config file.<br>
•    Then this city name is passed from main class(Project.java) to two different classes (WeatherThread.java and ForecastThread.java) where I have created threads for API’s calls.<br>
•    Using city name and APP_ID I have created a URL for API call in respected class (Weather and Forecast).<br> 
•    I have created an object of Output class in both WeatherThread and ForecastThread classes.<br>
•    Output class is responsible for getting JSON format output from API endpoint. <br>
•    From both WeatherThread and ForecastThread I have called Output.java for JSON format output by passing their respective URL’s.<br>
•     Once I have received JSON format output in WeatherThread.java, I have parsed this data from JSON to Map using JSONToMap.java class.<br>  
•    Class JSONToMap.java concerts the JSON format to Maps.<br>
•    By using Maps properties, I have extracted the Current Temperature of the city.<br>
•    Once I get the city name and current temperature, I stored this data to the local MongoDB Database using SaveData.java class.<br>
•    In SaveData.java class I have created a WeatherDataBase database and weather Collection using MongoClient method.<br>
•    Once City name and Current Temperature is stored, I have displayed the Entire Database in the WeatherThread.java class.<br>
<br>
 <br>
<br>
With UI<br>
•    This is the list of classes for With UI part<br>
  o    WeatherUI.java<br>
  o    Output.java<br>
  o    JSONToMap.java<br>
•    In this part of the project, I have created an application window with Textbox and a submit button.<br>
•    For this part, I am taking input as city name from a user not from the config file.<br>
•    Once a user enters a city name and submits the button. We get the temperature of the entered city as our output.<br>
•    All the process like calling API’s, parsing, etc. is same as Without UI part. <br>

<br><br>
<b>With_UI_1<b><br><br>
![with_ui_1](https://user-images.githubusercontent.com/25624988/43090771-4cefdbc6-8e76-11e8-8210-3773e60ca40c.png)<br><br>
<b>With_UI_2<b><br><br>
![with_ui_2](https://user-images.githubusercontent.com/25624988/43090773-4cfeb3f8-8e76-11e8-88f8-1ee265f82882.png)<br><br>
<b>With_UI_3<b><br><br>
![with_ui_3](https://user-images.githubusercontent.com/25624988/43090774-4d0f0186-8e76-11e8-97dc-67c056a83019.png)<br><br>
<b>With_UI_4<b><br><br>
![with_ui_4](https://user-images.githubusercontent.com/25624988/43090775-4d19fa28-8e76-11e8-9556-eaf97356bc9b.png)<br><br>
<b>Without_UI<b><br><br>
![without_ui](https://user-images.githubusercontent.com/25624988/43090776-4d28790e-8e76-11e8-8a73-08f9909774dd.png)




