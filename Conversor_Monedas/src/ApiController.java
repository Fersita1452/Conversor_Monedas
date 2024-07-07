import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiController {

    private String endpoint = "https://v6.exchangerate-api.com/v6";
    private String token = "352e52d1c0f11b3dbc1f55d5";
    private HttpClient client = HttpClient.newHttpClient();
    private HttpRequest request;
    private HttpResponse<String> response;


    public String getCodes() {
        try {
            request = HttpRequest.newBuilder()
                    .uri(new URI(endpoint + "/codes"))
                    .header("Authorization", "Bearer " + token)
                    .GET()
                    .build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return response.body();
    }

    public String getExchange(String exchangeFromCode, String exchangeToCode, float amount) {
        try {
            request= HttpRequest.newBuilder()
                    .uri(new URI(endpoint + "/pair/" + exchangeFromCode + "/" + exchangeToCode + "/" + amount))
                    .header("Authorization", "Bearer " + token)
                    .GET()
                    .build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return response.body();
    }
}
