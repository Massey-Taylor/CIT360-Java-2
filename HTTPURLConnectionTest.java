package defaultpackage;

import java.net.*;
import java.io.*;

// shows you how to upload content from a specific URL address
public class HTTPURLConnectionTest {

    private final String userAgent = "Mozilla/5.0";

    public static void main(String[] args) {

        HTTPURLConnectionTest connection = new HTTPURLConnectionTest();

        try {
            connection.run();
            connection.testUrl();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void run() throws Exception {

        URL myUrl = new URL("https://my.byui.edu/ics");
        HttpURLConnection connection = (HttpURLConnection) myUrl.openConnection();
        connection.setDoOutput(true);

        connection.setRequestProperty("agent", userAgent);

        int rc = connection.getResponseCode();
        System.out.println("\nSending the response to the specified URL: " + myUrl);
        System.out.println("Response Code = " + rc);
        System.out.println();
    }

    private void testUrl(){

        String myUrl = "https://my.byui.edu/ics";
        URL byuiUrl;

        try {
            byuiUrl = new URL(myUrl);
            HttpURLConnection httpConnection = (HttpURLConnection)byuiUrl.openConnection();

            print(httpConnection);

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void print(HttpURLConnection httpConnection){
        if(httpConnection != null){

            try {
                System.out.println("URL Content of https://my.byui.edu/ics:");
                BufferedReader buffer = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));

                String s;

                while ((s = buffer.readLine()) != null){
                    System.out.println(s);
                }
                buffer.close();

            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
