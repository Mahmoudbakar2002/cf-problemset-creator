package com.example.codeforcestool.api;

public class CodeForcesResponse<T> {
    public enum Status {
        OK,FAILED;

        @Override
        public String toString() {
            switch (this){
                case OK:return "OK";
                case FAILED:return "FAILD";
                default: return "NOT-KNOWN-Type";
            }
        }
    }


    private Status status;
    private String comment ;
    private T result;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
