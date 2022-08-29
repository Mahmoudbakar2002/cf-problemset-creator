package com.example.codeforcestool.models.containers;

import com.example.codeforcestool.models.Problem;

public class ProblemContainer {
    public enum Status {
        SOLVED,UNSOLVED,NOT_SUBMIT;
    }
    private Problem problem;
    private Status status;

    public ProblemContainer(Problem problem, Status status) {
        this.problem = problem;
        this.status = status;
    }
    public ProblemContainer(Problem problem) {
       this(problem,Status.NOT_SUBMIT);
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
