
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
import java.util.Scanner;

public class DemoGetRESTAPI {

    public static void demoGetRESTAPI() {
        Scanner scanner = new Scanner(System.in);

        // 1. Ζήτα από τον χρήστη να εισάγει τα κριτήρια
        System.out.println("Enter the number of questions (amount): ");
        int amount = scanner.nextInt();

        System.out.println("Enter category ID (or 0 for any category): ");
        int category = scanner.nextInt();

        System.out.println("Enter difficulty (easy, medium, hard or leave empty): ");
        scanner.nextLine(); // Καθαρισμός του scanner
        String difficulty = scanner.nextLine();

        System.out.println("Enter type (multiple, boolean or leave empty): ");
        String type = scanner.nextLine();

        // 2. Δημιουργία του URL με βάση τα κριτήρια
        StringBuilder urlBuilder = new StringBuilder("https://opentdb.com/api.php?");
        urlBuilder.append("amount=").append(amount);

        if (category > 0) {
            urlBuilder.append("&category=").append(category);
        }
        if (!difficulty.isEmpty()) {
            urlBuilder.append("&difficulty=").append(difficulty);
        }
        if (!type.isEmpty()) {
            urlBuilder.append("&type=").append(type);
        }

        String url = urlBuilder.toString();
        System.out.println("Generated URL: " + url);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpGet getRequest = new HttpGet(url);
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

    public static void main(String[] args) {
        demoGetRESTAPI();
    }

}

