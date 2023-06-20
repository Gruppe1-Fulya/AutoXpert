package Objects;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SpringHttpClient {
    private static final String BASE_URL = "http://localhost:8080";
    private static boolean successful;
    private static int errorCode;

    public static String getFahrzeug(String plaka) {
        HttpClient client = HttpClient.newHttpClient();
        String url = BASE_URL + "/araba/getKFZ/" + plaka;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                successful = true;
                return response.body();
            } else {
                // Handle error response
                successful = false;
                System.out.println("Error: " + response.statusCode());
            }
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }

        return null;
    }

    public static void updateFahrzeug(String plaka, String reparatur, String kosten) {
        try {
            // Güncelleme isteğini oluştur
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/araba/fahrzeugAktu/" + plaka))
                    .header("Content-Type", "application/json")
                    .PUT(HttpRequest.BodyPublishers.ofString("{\"reparaturen\":\"" + reparatur + "\",\"kosten\":\"" + kosten + "\"}"))
                    .build();

            // İsteği gönder ve cevabı al
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // İsteğin yanıtını kontrol et
            if (response.statusCode() == 200) {
                successful = true;
                System.out.println("Fahrzeug güncellendi.");
            } else {
                successful = false;
                System.out.println("Fahrzeug güncelleme başarısız oldu. Hata kodu: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isSuccessful() {
        return successful;
    }

    public static int getErrorCode() {
        return errorCode;
    }
}
