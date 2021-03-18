package world.ucode.cashflow.banking;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

import java.io.IOException;
import java.time.Instant;

public class Mono {

    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    public static void main(String[] args) throws Exception {

        Mono obj = new Mono();

        System.out.println("Testing 1 - Send Http GET request");
        obj.sendGet();

    }

    public String sendGet() throws Exception{
        long unixTimestamp = Instant.now().getEpochSecond() - 2419200;
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api.monobank.ua/personal/statement/mjFVwB_e7hQDlUv2hrsL3A/" + Long.toString(unixTimestamp)))
                .setHeader("X-Token", "u9z0t-MyklvB8QOuNxjWaf9wAPe93Uy_eQEAEsFYrZdM")
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();

    }

}