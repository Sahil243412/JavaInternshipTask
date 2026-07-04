import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Base Currency (USD, INR, EUR): ");
        String base = sc.next().toUpperCase();

        System.out.print("Target Currency: ");
        String target = sc.next().toUpperCase();

        System.out.print("Amount: ");
        double amount = sc.nextDouble();

        try {

            String api = "https://open.er-api.com/v6/latest/" + base;

            URL url = new URL(api);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                response.append(line);
            }

            br.close();

            String json = response.toString();

            String key = "\"" + target + "\":";
            int index = json.indexOf(key);

            if (index == -1) {
                System.out.println("Currency Not Found");
                return;
            }

            int start = index + key.length();
            int end = json.indexOf(",", start);

            double rate = Double.parseDouble(json.substring(start, end));

            double converted = amount * rate;

            System.out.println("\nExchange Rate : " + rate);
            System.out.println("Converted Amount : " + converted + " " + target);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
