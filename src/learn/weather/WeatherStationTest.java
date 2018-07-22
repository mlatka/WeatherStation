package learn.weather;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.StringWriter;

public class WeatherStationTest {


    public static void main(String[] args) {

        WeatherStation myStation= new WeatherStation();


        String result=myStation.getOpenWeatherData("Wroclaw");
        System.out.println(result);

        //JSONObject obj = new JSONObject();
        JSONParser parser= new JSONParser();

        try {
            Object obj= parser.parse(result);
            System.out.println("\n" + obj + "\n");
            JSONObject json= (JSONObject) obj;
            System.out.println(((JSONObject)json.get("main")).get("temp"));


        } catch (ParseException e) {
            e.printStackTrace();
        }




//        JSONObject obj = new JSONObject();
//
//        obj.put("name","foo");
//        obj.put("num",100);
//        obj.put("balance",1000.21);
//        obj.put("is_vip",true);
//
//        StringWriter out = new StringWriter();
//        try {
//            obj.writeJSONString(out);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        String jsonText = out.toString();
//        System.out.print(jsonText);


    }


}
