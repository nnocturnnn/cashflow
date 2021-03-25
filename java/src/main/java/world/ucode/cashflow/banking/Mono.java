package world.ucode.cashflow.banking;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.time.Instant;

public class Mono {

    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    public static void main(String[] args) throws Exception {

        Mono obj = new Mono();
        obj.sendGet();

    }
    
    public List<MonoTransaction> sendGet() throws Exception{
        long unixTimestamp = Instant.now().getEpochSecond() - 2419200;
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api.monobank.ua/personal/statement/mjFVwB_e7hQDlUv2hrsL3A/" + Long.toString(unixTimestamp)))
                .setHeader("X-Token", "u9z0t-MyklvB8QOuNxjWaf9wAPe93Uy_eQEAEsFYrZdM")
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper mapper = new ObjectMapper();
        List<MonoTransaction> participantJsonList = mapper.readValue(response.body(), new TypeReference<List<MonoTransaction>>(){});
        return  participantJsonList;
        

    }

}