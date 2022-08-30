package com.example.codeforcestool.models.containers;

import com.example.codeforcestool.models.Contest;
import com.example.codeforcestool.models.Problem;

import java.util.List;

public class ContestStandingContainer {
    private Contest contest;
    private List<Problem> problems;
//    private  List<int>rows;


    public Contest getContest() {
        return contest;
    }

    public void setContest(Contest contest) {
        this.contest = contest;
    }

    public List<Problem> getProblems() {
        return problems;
    }

    public void setProblems(List<Problem> problems) {
        this.problems = problems;
    }
}
