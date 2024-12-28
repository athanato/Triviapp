
package org.example;

import com.fasterxml.jackson.databind.JsonMappingException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;
import org.example.Result;

import java.io.IOException;

public class DemoGetRESTAPI {

    public static void demoGetRESTAPI() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpGet getRequest = new HttpGet("https://opentdb.com/api.php?amount=10");
            getRequest.addHeader("accept", "application/json");
            HttpResponse response = httpClient.execute(getRequest);
            Example c = null;
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            c = mapper.readValue(response.getEntity().getContent(), Example.class);
            System.out.println(c.toString());
        } catch (JsonMappingException e) {
            System.out.println("JsonMappingException ERROR");
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            System.out.println("ClientProtocolException ERROR");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException ERROR");
            e.printStackTrace();
        }
    }

}

