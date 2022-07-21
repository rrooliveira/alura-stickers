import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ClientHttp {
    public String getData(String url) {
        URI address = URI.create(url);
        var client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder(address).GET().build();
        HttpResponse<String> response;
        
        try {
            response = client.send(request, BodyHandlers.ofString());
        } catch (IOException | InterruptedException exception) {
            throw new RuntimeException(exception);
        }

        return response.body();
    }
}
