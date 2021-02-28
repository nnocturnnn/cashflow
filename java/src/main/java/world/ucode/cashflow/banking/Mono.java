// package world.ucode.cashflow.banking;

// import java.net.URI;
// import java.net.URLEncoder;
// import java.net.http.HttpClient;
// import java.net.http.HttpRequest;
// import java.net.http.HttpResponse;
// import java.nio.charset.StandardCharsets;
// import java.util.HashMap;
// import java.util.Map;

// public class Java11HttpClientExample {

//     private final HttpClient httpClient = HttpClient.newBuilder()
//             .version(HttpClient.Version.HTTP_2)
//             .build();

//     public static void main(String[] args) throws Exception {

//         Java11HttpClientExample obj = new Java11HttpClientExample();

//         System.out.println("Testing 1 - Send Http GET request");
//         obj.sendGet();

//     }

//     private void sendGet() throws Exception {

//         HttpRequest request = HttpRequest.newBuilder()
//                 .GET()
//                 .uri(URI.create("https://api.monobank.ua/personal/client-info"))
//                 .setHeader("X-Token", "u9z0t-MyklvB8QOuNxjWaf9wAPe93Uy_eQEAEsFYrZdM")
//                 .build();

//         HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

//         System.out.println(response.statusCode());

//         System.out.println(response.body());

//     }

// }