package com.example.httpclientdemo.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class SdrService {
    private static final String IMF_URL = "https://www.imf.org/external/np/fin/data/rms_sdrv.aspx";

    public static void getSdrRate() {
        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .GET()
                    .header("Content-Type", "text/html")
                    .uri(URI.create(IMF_URL))
                    .build();

            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            String htmlContent = String.valueOf(response.body());
            Document document = Jsoup.parse(htmlContent);
            Element srdRate = document.select("div.fancy table tbody tr:nth-child(8) td").get(0);

            System.out.println(srdRate.text().substring(0, 6));

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
