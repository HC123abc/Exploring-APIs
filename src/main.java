import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class main {

    public static String request = "potato"; // user request, we will concatenate for now, however in future we will make sure to set reqeust parameter
    private static final String API_URL = "https://www.themealdb.com/api/json/v1/1/search.php?s=" + request; // replace with your URL

    public static void main(String[] args) throws Exception {
        URL url = new URL(API_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");

        //conn.setRequestProperty("s", "katsu");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        // close connections
        in.close();
        conn.disconnect();

        System.out.println("Response content: " + content.toString());
    }
}