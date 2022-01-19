package com.blueorange.fx;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FXRealTimeDataClientRequest {

    public JSONObject getQuote() throws NumberFormatException {
        HttpResponse<String> response = sendHttpRequest();
        return new JSONObject(response.body());
    }

    private HttpResponse<String> sendHttpRequest() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.twelvedata.com/price?symbol=EUR/USD,EUR/GBP&apikey=763795ccaa744e4fb2211fb40c27f267&dp=4"))
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            System.out.println("DONE!");
            return HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

}