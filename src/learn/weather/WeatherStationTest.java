package learn.weather;

public class WeatherStationTest {


    public static void main(String[] args) {

        WeatherStation myStation= new WeatherStation();


        String result=myStation.getOpenWeatherData("Wroclaw");

        System.out.println(result);

    }


}
