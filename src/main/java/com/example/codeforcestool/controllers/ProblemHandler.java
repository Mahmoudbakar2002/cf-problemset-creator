package com.example.codeforcestool.controllers;

import com.example.codeforcestool.models.Problem;
import com.example.codeforcestool.models.Submission;
import com.example.codeforcestool.models.User;
import com.example.codeforcestool.models.containers.ProblemContainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProblemHandler {


    public static ArrayList<ProblemContainer> getAllProblem(User user, List<User> other,List<String> tags,int from,int to){
        ArrayList<ProblemContainer> ret=new ArrayList<>();
        HashMap<Problem,Integer> viewed=new HashMap<>();
        other.forEach(e->{
                ArrayList<Submission> subs= SubmissionHandler.getUniqueSubmission(e);
                subs.forEach((sub)->{
                    if(!viewed.containsKey(sub.getProblem())){
                        if(sub.getProblem().getRating()<from||sub.getProblem().getRating()>to)return;
                        viewed.put(sub.getProblem(),ret.size());
                        ret.add(new ProblemContainer(sub.getProblem()));
                    }
                });
                }
        );

        ArrayList<Submission> subs= SubmissionHandler.getUniqueSubmission(user);
        subs.forEach((sub)->{
            if(viewed.containsKey(sub.getProblem())){
                if(ret.get(viewed.get(sub.getProblem())).getStatus()==ProblemContainer.Status.SOLVED)return;

                ProblemContainer.Status status=(sub.getVerdict()== Submission.Verdict.OK)? ProblemContainer.Status.SOLVED: ProblemContainer.Status.UNSOLVED;
                ret.get(viewed.get(sub.getProblem())).setStatus(status);
            }
        });

    return ret;
    }

}
