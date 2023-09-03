import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the base currency: ");
        String baseCurrency = scanner.next().toUpperCase();
        System.out.print("Enter the target currency: ");
        String targetCurrency = scanner.next().toUpperCase();
        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();
        scanner.close();

        try {
            double convertedAmount = convertCurrency(baseCurrency, targetCurrency, amount);
            System.out.printf("%.2f %s is equal to %.2f %s%n", amount, baseCurrency, convertedAmount, targetCurrency);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static double convertCurrency(String baseCurrency, String targetCurrency, double amount)
            throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://api.exchangeratesapi.io/v1/latest?access_key=148f0d9177fb8a6bef8a008272466360"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject json = new JSONObject(response.body());
        JSONObject rates = json.getJSONObject("rates");

        // Convert the user-provided base currency to EUR
        double eurRate = rates.getDouble("EUR");
        double eurAmount = amount / rates.getDouble(baseCurrency);
        // Convert EUR to the target currency
        double targetRate = rates.getDouble(targetCurrency);
        return eurAmount * targetRate;
    }
}
