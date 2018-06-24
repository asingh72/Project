package WithUI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

//import JSONToMap;
//import Output;

import javax.swing.JLabel;

public class WeatherUI {

	private JFrame frame;
	private JLabel disTempCity;
	private JTextField cityInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WeatherUI window = new WeatherUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WeatherUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		
		JButton Submit = new JButton("Entert city name and submit ");
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Output opt = new Output();
				JSONToMap jtm = new JSONToMap();
				String app_id = "6fb5265c1772baedbb525f0fa149b99d";		
		
			
				Thread.UncaughtExceptionHandler h = new Thread.UncaughtExceptionHandler() {
				    public void uncaughtException(Thread th, Throwable ex) {
				        //System.out.println("Uncaught exception: " + ex);
				        disTempCity.setText("Invalid City Name ");
				    }
				};
				
		
			
				
				Thread t2 = new Thread(() ->
				{
					String cityName="";
					
						cityName= cityInput.getText();
					
					String url2 = "http://api.openweathermap.org/data/2.5/weather?q="+ cityName +"&appid="+ app_id;
					String weatherData= opt.output(url2);
						
					System.out.println("\nEnd Point of Weather API:\n"+weatherData);
					//x=456;
				
					Map<String, Object> respMap = jtm.jsonToMap(weatherData.toString());
					Map<String, Object> mainMap = jtm.jsonToMap(respMap.get("main").toString());
			
					Double currentTempratureInCelsius= (Double) ((Double) mainMap.get("temp")-273.15);
			
					//saveData.saveData(currentTempratureInCelsius,cityName);
					
					disTempCity.setText("Current Weather of "+cityName+" is "+ currentTempratureInCelsius );
					
				});
				
				t2.setUncaughtExceptionHandler(h);
				t2.start();
				
			}
		});
		Submit.setBounds(131, 59, 225, 29);
		frame.getContentPane().add(Submit);
		
	    disTempCity = new JLabel("Temprature ");
		disTempCity.setBounds(175, 180, 410, 98);
		frame.getContentPane().add(disTempCity);
		
		cityInput = new JTextField();
		cityInput.setBounds(374, 59, 211, 29);
		frame.getContentPane().add(cityInput);
		cityInput.setColumns(10);
	}
}
