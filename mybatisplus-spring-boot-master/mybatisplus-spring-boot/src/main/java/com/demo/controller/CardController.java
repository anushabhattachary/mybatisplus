package com.demo.controller;

import com.common.Result;
import com.common.Results;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author:qjj
 * @create: 2024-10-16 17:58
 * @Description: card
 */
@RestController
@RequestMapping("/card")
public class CardController {

    @GetMapping("/createCard")
    public Result createCard() throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
//        just a test
        okhttp3.RequestBody body = okhttp3.RequestBody.create(mediaType, "{\"type\":\"VIRTUAL\",\"memo\":\"New Card\",\"spend_limit\":1000,\"spend_limit_duration\":\"TRANSACTION\",\"state\":\"OPEN\"}");
        Request request = new Request.Builder()
                .url("https://sandbox.lithic.com/v1/cards")
                .post(body)
                .addHeader("accept", "application/json")
                .addHeader("content-type", "application/json")
                .addHeader("Authorization", "5d428b62-a000-4aeb-8129-99476284d8fd")
                .build();

        Response response = client.newCall(request).execute();
        return Results.success(response.body().string());
    }

    @GetMapping("/getCardBalances")
    public Result getCardBalances(@RequestParam String cardId) throws IOException {
        OkHttpClient client = new OkHttpClient();
        if(cardId == null || cardId.isEmpty()){
            throw new RuntimeException("cardId is required");
        }

        String url = "https://sandbox.lithic.com/v1/cards/" + cardId + "/balances";

        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "5d428b62-a000-4aeb-8129-99476284d8fd")
                .build();

        Response response = client.newCall(request).execute();
        return Results.success(response.body().string());
    }
}
