package com.example.codeforcestool.api;

import com.example.codeforcestool.models.Submission;
import com.example.codeforcestool.models.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import static com.google.common.base.Preconditions.checkNotNull;

public class CodeForcesRequest {
    public static enum Method{
//        NOT_SET_YET("error"),
        USER_STATUS("user.status"),
        USER_INFO("user.info"),
        CONTEST_LIST("contest.list"),
        CONTEST_STANDING("contest.standings");

        private String name;
        Method(String name){this.name=name;}
    }
    public static class Parameter{
        String key,value;
        public  Parameter(String key,String value){
            checkNotNull(key);
            checkNotNull(value);

            this.key=key;
            this.value=value;
        }
    }

    private static final String API_URL="https://codeforces.com/api";
    private static HttpClient httpClient;
    static {
        httpClient=HttpClient.newHttpClient();
    }

    private CodeForcesRequest(){}
    private Method method;
    private ArrayList<Parameter> parameters;

    private CodeForcesRequest(Method method, ArrayList<Parameter> parameters) {
        this.method = method;
        this.parameters = parameters;
    }
    public static Builder getBuilder(Method method){return  new Builder(method);};

    public static class Builder{

        private Method method;
        private ArrayList<Parameter> parameters;

        private Builder(Method method){
            this.method=method;
            checkNotNull(method);
            parameters=new ArrayList<Parameter>();
        }
        public Builder addParameter(Parameter parameter){
            checkNotNull(parameter);

            parameters.add(parameter);
            return this;
        }
        public Builder addParameter(String key,String value){
            return addParameter(new Parameter(key,value));
        }
        public CodeForcesRequest build(){

            return new CodeForcesRequest(method,parameters);
        }

    }



    public HttpResponse<String> doRequest() throws URISyntaxException, IOException, InterruptedException {
        String req=API_URL+"/" + method.name;
        if(!parameters.isEmpty()){
            req+="?";
            for(Parameter par:parameters)
                req+= par.key+"="+ par.value+"&";
        }


        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI(req))
                .build();
        HttpResponse<String> response=httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return  response;

    }


}
