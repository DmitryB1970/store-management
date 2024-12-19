package com.javaacademy.store_management.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/application/status")
@Tag(name = "Shop status controller", description = "Контроллер статуса работы магазинов")
public class ShopController {

    @GetMapping()
    @Operation(summary = "Получение статуса магазина", description = "Получение статуса магазина")
    public List<String> getShopStatus() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request1 = new Request.Builder()
                .get()
                .url("http://localhost:8081/application/status")
                .addHeader("Content-Type", "application/json")
                .build();

        String response1 = client.newCall(request1).execute().body().string();

        Request request2 = new Request.Builder()
                .get()
                .url("http://localhost:8082/application/status")
                .addHeader("Content-Type", "application/json")
                .build();

        String response2 = client.newCall(request2).execute().body().string();

        return List.of(response1, response2);

    }
}
