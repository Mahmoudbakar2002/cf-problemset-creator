package com.example.codeforcestool.api;

import com.example.codeforcestool.models.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class CodeForcesClient {
    private static HttpClient httpClient;
    static {
        httpClient=HttpClient.newHttpClient();
    }



//    public static CodeForcesResponse send(CodeForcesRequest cfrequest) throws URISyntaxException, IOException, InterruptedException{
//        HttpRequest httpRequest=cfrequest.doRequest();
//        HttpResponse<String> response=httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
////        return  response;
//
//
////        req.getClass()
//
//        Gson gson =new Gson();
//        Type userResponseType=new TypeToken<CodeForcesResponse>(){}.getType();
//        CodeForcesResponse cfresponse = gson.fromJson(response.body(),userResponseType);
//
//        return cfresponse;
//    }
}
