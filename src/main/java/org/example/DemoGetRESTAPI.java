
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
//αποστολή αιτήματος GET σε REST API
public class DemoGetRESTAPI {
    //Μέθοδος εκτέλεσης αιτήματος GET
    public static void demoGetRESTAPI() {
        Scanner scanner = new Scanner(System.in);

        // Εισαγωγή παραμέτρων από τον χρήστη
        System.out.println("Enter the number of questions (amount): ");
        int amount = scanner.nextInt();

        System.out.println("Enter category ID (or 0 for any category): ");
        int category = scanner.nextInt();

        System.out.println("Enter difficulty (easy, medium, hard or leave empty): ");
        scanner.nextLine(); // Καθαρισμός του scanner
        String difficulty = scanner.nextLine();

        System.out.println("Enter type (multiple, boolean or leave empty): ");
        String type = scanner.nextLine();

        // Δημιουργία URL βάσει παραμέτρων
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
        // Δημιουργία HTTP client
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            // Δημιουργία αιτήματος GET
            HttpGet getRequest = new HttpGet(url);
            getRequest.addHeader("accept", "application/json");
            // Εκτέλεση αιτήματος
            HttpResponse response = httpClient.execute(getRequest);
            Example c = null;
            // Ανάλυση απόκρισης JSON
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            c = mapper.readValue(response.getEntity().getContent(), Example.class);
            // Εμφάνιση αποτελέσματος
            System.out.println(c.toString());
        } catch (JsonMappingException e) {
            // Σφάλμα αντιστοίχισης JSON
            System.out.println("JsonMappingException ERROR");
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            // Σφάλμα πρωτοκόλλου
            System.out.println("ClientProtocolException ERROR");
            e.printStackTrace();
        } catch (IOException e) {
            // Σφάλμα εισόδου/εξόδου
            System.out.println("IOException ERROR");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        demoGetRESTAPI();
    }

}

