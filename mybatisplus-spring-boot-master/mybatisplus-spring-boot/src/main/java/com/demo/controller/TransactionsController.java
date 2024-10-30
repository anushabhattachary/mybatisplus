package com.demo.controller;

import com.common.Result;
import com.common.Results;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author:qjj
 * @create: 2024-10-16 17:32
 * @Description: transactions
 */
@RestController
@RequestMapping("/transactions")
public class TransactionsController {


    @GetMapping("/simulateTransaction")
    public Result simulateTransaction() throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        okhttp3.RequestBody body = okhttp3.RequestBody.create(mediaType, "{\"status\":\"FINANCIAL_CREDIT_AUTHORIZATION\",\"amount\":3831,\"descriptor\":\"COFFEE SHOP\",\"mcc\":\"5812\",\"merchant_acceptor_id\":\"OODKZAPJVN4YS7O\",\"merchant_amount\":100,\"merchant_currency\":\"USD\",\"pan\":\"4111111758269503\",\"partial_approval_capable\":false}");
        Request request = new Request.Builder()
                .url("https://sandbox.lithic.com/v1/simulate/authorize")
                .post(body)
                .addHeader("accept", "application/json")
                .addHeader("content-type", "application/json")
                .addHeader("Authorization", "5d428b62-a000-4aeb-8129-99476284d8fd")
                .build();

        Response response = client.newCall(request).execute();
        return Results.success(response.body().string());
    }
}
