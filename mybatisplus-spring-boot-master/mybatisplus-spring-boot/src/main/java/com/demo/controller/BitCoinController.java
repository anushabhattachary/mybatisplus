package com.demo.controller;

import cn.hutool.json.JSONObject;
import com.common.Result;
import com.common.Results;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author:qjj
 * @create: 2024-10-16 17:37
 * @Description: bitCorn
 */
@RestController
@RequestMapping("/bitCorn")
public class BitCoinController {

        @RequestMapping("/getChangeCoinPrice")
        public Result<JSONObject> getChangeCoinPrice() throws IOException {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    // u can change the url to get more price info
//                    ids = bitcoin,ethereum,ripple
//                    vs_currencies = usd,eur,cny
                    .url("https://api.coingecko.com/api/v3/simple/price?ids=bitcoin&vs_currencies=usd")
                    .get()
                    .addHeader("accept", "application/json")
                    .addHeader("x-cg-pro-api-key", "CG-JDB4gpSxHu3cLg14j7sHPEaV")
                    .build();

            Response response = client.newCall(request).execute();
            JSONObject jsonObject = new JSONObject(response.body().string());
            return Results.success(jsonObject);
        }
}
