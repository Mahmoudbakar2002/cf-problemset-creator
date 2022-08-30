package com.example.codeforcestool.controllers;

import com.example.codeforcestool.api.CodeForcesRequest;
import com.example.codeforcestool.api.CodeForcesResponse;
import com.example.codeforcestool.models.Contest;
import com.example.codeforcestool.models.Submission;
import com.example.codeforcestool.models.User;
import com.example.codeforcestool.models.containers.ContestStandingContainer;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.checkerframework.checker.units.qual.C;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ContestHandler {
    public static  ArrayList<Contest> getAllContest() {
        try {
            CodeForcesRequest cfRequest = CodeForcesRequest
                    .getBuilder(CodeForcesRequest.Method.CONTEST_LIST)
                    .build();

            Type userResponseType=new TypeToken<CodeForcesResponse<ArrayList<Contest>>>(){}.getType();
            CodeForcesResponse<ArrayList<Contest>> cfResponse = new Gson().fromJson(cfRequest.doRequest().body(),userResponseType);

            return cfResponse.getResult();
        }catch (URISyntaxException | IOException |InterruptedException ex){
            ex.printStackTrace();
            return null;
        }

    }
    public static  ArrayList<Contest> getAllGymContest() {
        try {
            CodeForcesRequest cfRequest = CodeForcesRequest
                    .getBuilder(CodeForcesRequest.Method.CONTEST_LIST)
                    .addParameter("gym","true")
                    .build();

            Type userResponseType=new TypeToken<CodeForcesResponse<ArrayList<Contest>>>(){}.getType();
            CodeForcesResponse<ArrayList<Contest>> cfResponse = new Gson().fromJson(cfRequest.doRequest().body(),userResponseType);

            return cfResponse.getResult();
        }catch (URISyntaxException | IOException |InterruptedException ex){
            ex.printStackTrace();
            return null;
        }

    }
    public  static Contest getContestByID(int id){
        try {
            CodeForcesRequest cfRequest = CodeForcesRequest
                    .getBuilder(CodeForcesRequest.Method.CONTEST_STANDING)
                    .addParameter("contestId",Integer.toString(id))
                    .addParameter("from","1")
                    .addParameter("count","1")
                    .build();

            Type userResponseType=new TypeToken<CodeForcesResponse<ContestStandingContainer>>(){}.getType();
            CodeForcesResponse<ContestStandingContainer> cfResponse = new Gson().fromJson(cfRequest.doRequest().body(),userResponseType);

            return cfResponse.getResult().getContest();
        }catch (URISyntaxException | IOException |InterruptedException ex){
            ex.printStackTrace();
            return null;
        }
    }


    public static  HashMap<Integer,Contest> getAllContestAnfGymHashed() {
        ArrayList<Contest> contestsArrayList=getAllContest();
        HashMap<Integer,Contest> contestHashMap=new HashMap<>();
        for(int i=0;i<contestsArrayList.size();i++){
            contestHashMap.put(contestsArrayList.get(i).getId(),contestsArrayList.get(i));
        }
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        contestsArrayList=getAllGymContest();
//        for(int i=0;i<contestsArrayList.size();i++){
//            contestHashMap.put(contestsArrayList.get(i).getId(),contestsArrayList.get(i));
//        }

        return contestHashMap;
    }

    public static  ArrayList<Contest> getNotJoined(User user, List<User>others){
        HashSet<Integer> joined=new HashSet<>();
        ArrayList<Submission> subs= SubmissionHandler.getUniqueSubmission(user);

        HashMap<Integer, Contest> allContests=getAllContestAnfGymHashed();




        for(int i=0;i<subs.size();i++){
            Submission s=subs.get(i);
            int id=s.getProblem().getContestId();
            if(!joined.contains(id))joined.add(id);
        }

        ArrayList<Contest> contests=new ArrayList<>();
        HashSet<Integer> added=new HashSet<>();

        for(int i=0;i<others.size();i++){
            ArrayList<Submission> oth= SubmissionHandler.getUniqueSubmission(others.get(i));

            for (int j=0;j< oth.size();j++){
                Submission s=oth.get(j);
                int id=s.getProblem().getContestId();
//                System.out.println(id);
                if(!joined.contains(id)  && !added.contains(id)){
                    added.add(id);
//                    System.out.println("Added"+id);
                    if(allContests.get(id)!=null)
                        contests.add(allContests.get(id));
                }

            }
        }

        return contests;
    }
}
