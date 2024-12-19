package com.javaacademy.store_management.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/shop/good")
@Tag(name = "Update good controller", description = "Контроллер изменения наименования и цены  товара")
public class GoodController {


    @PatchMapping
    @Operation(summary = "Изменение товара", description = "Изменение наименования и цены товара")
    public List<String> updateGood(@RequestParam String name, @RequestParam BigDecimal new_price) throws IOException {
        OkHttpClient client = new OkHttpClient();

        String jsondata = "{\"name\": \"Хлеб\", \"new_price\": 200 \"}";
        byte[] bytes = jsondata.getBytes(StandardCharsets.UTF_8);

        Request request1 = new Request.Builder()
                .patch(RequestBody.create(bytes))
                .url("http://localhost:8081/shop/good")
                .addHeader("Content-Type", "application/json")
                .build();

        String response1 = client.newCall(request1).execute().body().string();
        Response resp1 = client.newCall(request1).execute();
        if (resp1.isSuccessful()) {
            System.out.println("Изменения цены и названия товара в \"Семерочке\" прошли!");
        }

        Request request2 = new Request.Builder()
                .patch(RequestBody.create(bytes))
                .url("http://localhost:8082/shop/good")
                .addHeader("content-type", "application/json")
                .build();

        String response2 = client.newCall(request2).execute().body().string();
        Response resp2 = client.newCall(request1).execute();
        if (resp2.isSuccessful()) {
            System.out.println("Изменения цены и названия товара в \"Девяточке\" прошли!");
        }

        return List.of(response1, response2);
    }
}
