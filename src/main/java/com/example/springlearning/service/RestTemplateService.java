package com.example.springlearning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.net.HttpURLConnection;
import java.net.http.HttpClient;

@Service
public class RestTemplateService {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RestClient restClient;

    public void callExternalApi() {
        String response = restTemplate.getForObject("http://localhost:8181/api/message",String.class);
        System.out.println(response);

        String respnse1= restClient
                .get()
                .uri("http://localhost:8181/api/message")
                .accept(MediaType.TEXT_PLAIN)
                .retrieve()
                .body(String.class);

        System.out.println(respnse1);


    }


}
