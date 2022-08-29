package com.example.codeforcestool.controllers;

import com.example.codeforcestool.api.CodeForcesClient;
import com.example.codeforcestool.api.CodeForcesRequest;
import com.example.codeforcestool.models.User;
import com.example.codeforcestool.api.CodeForcesResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class UserHandler {

    public static User getUser(String handle)throws Exception {
        CodeForcesRequest cfRequest = CodeForcesRequest.getBuilder(CodeForcesRequest.Method.USER_INFO).
                addParameter("handles", handle).build();

        Gson gson =new Gson();
        Type userResponseType=new TypeToken<CodeForcesResponse<ArrayList<User>>>(){}.getType();
        CodeForcesResponse<ArrayList<User>> cfResponse = gson.fromJson(cfRequest.doRequest().body(),userResponseType);


        if (cfResponse.getResult() != null && !cfResponse.getResult().isEmpty()) {
            return cfResponse.getResult().get(0);
        }

        return null;
    }
    public static ArrayList<User> getUsers(String[] handles)throws Exception {
        String handlesStr = "";
        for (String e:handles) handlesStr+=e+";";

        CodeForcesRequest cfRequest = CodeForcesRequest.getBuilder(CodeForcesRequest.Method.USER_INFO).
                addParameter("handles", handlesStr).build();

        Gson gson =new Gson();
        Type userResponseType=new TypeToken<CodeForcesResponse<ArrayList<User>>>(){}.getType();
        CodeForcesResponse<ArrayList<User>> cfResponse = gson.fromJson(cfRequest.doRequest().body(),userResponseType);


        return cfResponse.getResult();
    }



}
