package com.blueorange.fx;

import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FXRealTimeDataDemo {

    private static final FXRealTimeDataUI dataUI = new FXRealTimeDataUI();
    private static final FXRealTimeDataClientRequest request = new FXRealTimeDataClientRequest();

    public static void main(String[] args) {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        Runnable simulator = FXRealTimeDataDemo::updateData;
        scheduledExecutorService.scheduleAtFixedRate(simulator, 1, 30, TimeUnit.SECONDS);

    }

    private static void updateData() {
        JSONObject json = request.getQuote();
        System.out.println(json);
        dataUI.getField1().setText("" + json.getJSONObject("EUR/USD").getString("price"));
        dataUI.getTime1().setText(String.valueOf(LocalDateTime.now()));
        dataUI.getField2().setText("" + json.getJSONObject("EUR/GBP").getString("price"));
        dataUI.getTime2().setText(String.valueOf(LocalDateTime.now()));
    }

}