package learn.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Illustrates Observer design pattern. Provides methods foe retrieving
 * weather data
 *
 * @author mirek
 * @version 1
 */


public class WeatherStation {


    private String apiKey;


    public WeatherStation() {
        this.apiKey = "d27a121a351b15b5a7895cae383bbc97";
    }

    public WeatherStation(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getOpenWeatherData(String cityName) {


       String url= generateURL(cityName,"weather","metric");

       StringBuilder response =new StringBuilder(getResponseFromOWM(url).toString());

        return response.toString();


    }


    private String generateURL(String cityName, String requestType, String units) {
        StringBuilder sb = new StringBuilder("http://api.openweathermap.org/data/2.5/");
        sb.append(requestType);
        sb.append('?' + "q=" + cityName);
        sb.append("&units=" + units);
        sb.append("&APPID=" + apiKey);

        return sb.toString();
    }

    private StringBuffer getResponseFromOWM(String url) {

        StringBuffer response = new StringBuffer();

        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();

        } catch (MalformedURLException ex) {

            System.out.println("bad url");
        } catch (IOException ex) {

            System.out.println("Connection failed");

        }


        return response;


    }


}
