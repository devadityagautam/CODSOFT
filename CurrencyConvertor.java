package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import org.json.JSONObject;
public class CurrencyConvertor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the currency you want to convert (e.g. EUR) : ");
        String curr1 = sc.nextLine().toUpperCase();

        System.out.println("Enter the currency to which you want to convert (e.g. USD) : ");
        String curr2 = sc.nextLine().toUpperCase();

        System.out.println("Enter the amount you want to convert : ");
        double amt = sc.nextDouble();

        convert(curr1, curr2, amt);
    }

    public static void convert(String curr1, String curr2, double amt) {
        try {
            String apiKey = "4e627939312213d0390abca5";  // replace with your actual key
            String url = String.format(
                    "https://v6.exchangerate-api.com/v6/%s/pair/%s/%s/%.2f",
                    apiKey, curr1, curr2, amt);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());



            JSONObject json = new JSONObject(response.body());

            if (json.has("conversion_result")) {
                double result = json.getDouble("conversion_result");
                System.out.printf("%.2f %s = %.2f %s%n", amt, curr1, result, curr2);
            } else {
                System.out.println(" 'conversion_result' field not found.");
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }


}
