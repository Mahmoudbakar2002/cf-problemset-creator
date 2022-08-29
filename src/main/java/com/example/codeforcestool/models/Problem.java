package com.example.codeforcestool.models;

import java.util.Objects;

public class Problem {
    public static enum ProblemType {
        PROGRAMMING, QUESTION;
    }

    private int contestId;
    private String problemsetName,index,name;
    private ProblemType type;
    private double points;
    private int rating;
    private String[] tags;


    public boolean hasTopic(String topic){
        for (String e:
             tags) {
            if(e.equalsIgnoreCase(topic))return true;
        }
        return false;
    }

    public int getContestId() {
        return contestId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Problem problem = (Problem) o;
        return contestId == problem.contestId && index.equals(problem.index) && name.equals(problem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contestId, index, name);
    }

    public void setContestId(int contestId) {
        this.contestId = contestId;
    }

    public String getProblemsetName() {
        return problemsetName;
    }

    public void setProblemsetName(String problemsetName) {
        this.problemsetName = problemsetName;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProblemType getType() {
        return type;
    }

    public void setType(ProblemType type) {
        this.type = type;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }
}
