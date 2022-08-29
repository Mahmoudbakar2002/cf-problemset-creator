package com.example.codeforcestool.models;

public class Submission {
    public static enum  Verdict{
        FAILED, OK, PARTIAL, COMPILATION_ERROR,
        RUNTIME_ERROR, WRONG_ANSWER, PRESENTATION_ERROR,
        TIME_LIMIT_EXCEEDED, MEMORY_LIMIT_EXCEEDED, IDLENESS_LIMIT_EXCEEDED,
        SECURITY_VIOLATED, CRASHED, INPUT_PREPARATION_CRASHED, CHALLENGED,
        SKIPPED, TESTING, REJECTED;
    }
    public static enum TesTset{
        /* Testset used for judging the submission. */
        SAMPLES, PRETESTS, TESTS, CHALLENGES, TESTS1,TESTS2,
        TESTS3,TESTS4,TESTS5,TESTS6,TESTS7,TESTS8,TESTS9,TESTS10;
    }

    private int id,contestId,creationTimeSeconds,relativeTimeSeconds;
    private Problem problem;
    private Party author;
    private String programmingLanguage;
    private Verdict verdict;
    private TesTset testset;
    private int passedTestCount;
    private int timeConsumedMillis;
    private int memoryConsumedBytes;
    private double points;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContestId() {
        return contestId;
    }

    public void setContestId(int contestId) {
        this.contestId = contestId;
    }

    public int getCreationTimeSeconds() {
        return creationTimeSeconds;
    }

    public void setCreationTimeSeconds(int creationTimeSeconds) {
        this.creationTimeSeconds = creationTimeSeconds;
    }

    public int getRelativeTimeSeconds() {
        return relativeTimeSeconds;
    }

    public void setRelativeTimeSeconds(int relativeTimeSeconds) {
        this.relativeTimeSeconds = relativeTimeSeconds;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public Party getAuthor() {
        return author;
    }

    public void setAuthor(Party author) {
        this.author = author;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public Verdict getVerdict() {
        return verdict;
    }

    public void setVerdict(Verdict verdict) {
        this.verdict = verdict;
    }

    public TesTset getTestset() {
        return testset;
    }

    public void setTestset(TesTset testset) {
        this.testset = testset;
    }

    public int getPassedTestCount() {
        return passedTestCount;
    }

    public void setPassedTestCount(int passedTestCount) {
        this.passedTestCount = passedTestCount;
    }

    public int getTimeConsumedMillis() {
        return timeConsumedMillis;
    }

    public void setTimeConsumedMillis(int timeConsumedMillis) {
        this.timeConsumedMillis = timeConsumedMillis;
    }

    public int getMemoryConsumedBytes() {
        return memoryConsumedBytes;
    }

    public void setMemoryConsumedBytes(int memoryConsumedBytes) {
        this.memoryConsumedBytes = memoryConsumedBytes;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }
}
