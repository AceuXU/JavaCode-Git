import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    private static final String API_KEY = VOw4dKtPci2FSICxKUqRIEHcAnIH7Epb;

    public static void main(String[] args) {
        try {
            String city = "New York";
            String weatherData = getWeatherData(city);
            displayWeather(weatherData);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    private static String getWeatherData(String city) throws IOException{
        String apiUrl = 'https://api.tomorrow.io/v4/timelines?location=40.75872069597532,-73.98529171943665&fields=temperature&timesteps=1h&units=metric&apikey=key'
                URL url = new URL(apiUrl);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null){
            response.append(line);
        }
        reader.close();
        return response.toString();
    }
    private static void displayWeather(String weatherData){
        JSONObject jsonObject = new JSONObject(weatherData);

        String cityName = jsonObject.getString("name");
        JSONObject main = jsonObject.getJSONObject("main");
        double temperature = main.getDouble("temp");
        double humidity = main.getDouble("humidity");

        System.out.println("City: " + cityName);
        System.out.println("Temperature: " + (temperature - 273.15) + "C");
        System.out.println("Humidity:");
        System.out.println("Humidity " + humidity + "%");

    }
}
