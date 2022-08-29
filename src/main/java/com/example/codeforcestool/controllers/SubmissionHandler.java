package com.example.codeforcestool.controllers;

import com.example.codeforcestool.api.CodeForcesRequest;
import com.example.codeforcestool.api.CodeForcesResponse;
import com.example.codeforcestool.models.Problem;
import com.example.codeforcestool.models.Submission;
import com.example.codeforcestool.models.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubmissionHandler {

    public static ArrayList<Submission> getSubmission(User user){
        try {
            CodeForcesRequest cfRequest = CodeForcesRequest
                    .getBuilder(CodeForcesRequest.Method.USER_STATUS)
                    .addParameter("handle", user.getHandle())
                    .build();

            Type userResponseType=new TypeToken<CodeForcesResponse<ArrayList<Submission>>>(){}.getType();
            CodeForcesResponse<ArrayList<Submission>> cfResponse = new Gson().fromJson(cfRequest.doRequest().body(),userResponseType);

            return cfResponse.getResult();
        }catch (URISyntaxException| IOException |InterruptedException ex){
            ex.printStackTrace();
            return null;
        }

    }

    public static  ArrayList<Submission> getUniqueSubmission(User user){
        ArrayList<Submission> full = getSubmission(user);
        ArrayList<Submission> unique = new ArrayList<Submission>();
        HashMap<Problem , Integer > founded=new HashMap<Problem,Integer>();
        full.forEach((e)->{
            if(!founded.containsKey(e.getProblem())){
                founded.put(e.getProblem(),unique.size());
                unique.add(e);
            }else if(
                    unique.get(founded.get(e.getProblem())).getVerdict() != Submission.Verdict.OK
                    && e.getVerdict()== Submission.Verdict.OK

            ){
                int idx = founded.get(e.getProblem());
                unique.set(idx,e);
            }



        });

//        System.out.println("Happen fucked");

        return unique;
    }

}
