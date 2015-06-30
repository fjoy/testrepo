import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ee on 25/06/15.
 */
public class SimpleRestClient {


    public static void main(String[] args) {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        CloseableHttpResponse response;
        BufferedReader reader;
        String line;
        StringBuilder builder = new StringBuilder();

        //HTTP Get
        HttpGet getRequest = new HttpGet("http://localhost:8080/customerService/customers;type=msisdn/447979000902");
//        HttpGet getRequest = new HttpGet("https://www.google.co.uk/search?q=chicken+recipes");

        getRequest.addHeader("X-TouchPoint", "cfu");
        getRequest.addHeader("Content-Type", "application/json");
        getRequest.addHeader("X-Channel", "ConsumerUpgrade");
        getRequest.addHeader("X-UserId", "ID-000100");
        getRequest.addHeader("X-IdType", "SomeKindOfId");
        getRequest.addHeader("X-PartnerId", "o2");


        try {
        response = client.execute(getRequest);

        //Below code is to convert the InputStream output from response to readable String format.
        InputStream in = response.getEntity().getContent();
        reader = new BufferedReader(new InputStreamReader(in));
            while ((line = reader.readLine()) != null) {
            builder.append(line);
            }
            System.out.printf("GET response Entity content: "+builder.toString());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        //HTTP Post
        HttpPost postRequest = new HttpPost("http://localhost:8080/auth/v1/auth/password_o2");
        postRequest.addHeader("Authorization", "Basic bXNwOmR1RjdhV2VD");
        postRequest.addHeader("Content-Type", "application/json");
        //setting post body
        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("preferred_username", "ID-000900@o2.com"));
        urlParameters.add(new BasicNameValuePair("password", "test123"));
        try {
            postRequest.setEntity(new UrlEncodedFormEntity(urlParameters));
            response = client.execute(postRequest);
            reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            while ((line=reader.readLine())!=null){
                builder.append(line);
            }
            System.out.println("POST response Entity content: " + builder.toString());
            System.out.println("POST response status: " + response.getStatusLine());

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
