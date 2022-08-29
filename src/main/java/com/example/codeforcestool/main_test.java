package com.example.codeforcestool;


import com.example.codeforcestool.api.CodeForcesRequest;
import com.example.codeforcestool.controllers.SubmissionHandler;
import com.example.codeforcestool.controllers.UserHandler;
import com.example.codeforcestool.models.Problem;
import com.example.codeforcestool.models.Submission;
import com.example.codeforcestool.api.CodeForcesResponse;
import com.example.codeforcestool.models.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class main_test {

    public static String getUriForUser(String handle){
        return "https://codeforces.com/api/user.info?handles="+handle;
    }
    public static String getUriForUsers(String[] handles){
        String  ret ="https://codeforces.com/api/user.info?handles=";
        for(String e:handles)ret+=e+";";
        return ret;
    }

    public static void main(String[] args) throws Exception{


//        Gson gson = new Gson();
//        Object decoded = gson.fromJson((String)userJson, User_Result.class);
//
//        User_Result decodedObject = (User_Result)decoded;
//        System.out.println(decodedObject.status);
//        List<User> userArray = decodedObject.result;
//        for(User user : userArray) {
//            System.out.println(user.getFirstName()+" "+
//                                user.getLastName()+
//                                "("+user.getCountry()+")");
//
//
//        }


//        String res="{\n" +
//                "    \"status\": \"OK\",\n" +
//                "    \"result\": [\n" +
//                "        {\n" +
//                "            \"lastName\": \"Atef\",\n" +
//                "            \"country\": \"Egypt\",\n" +
//                "            \"lastOnlineTimeSeconds\": 1661725894,\n" +
//                "            \"city\": \"Giza\",\n" +
//                "            \"rating\": 1374,\n" +
//                "            \"friendOfCount\": 23,\n" +
//                "            \"titlePhoto\": \"https://cdn-userpic.codeforces.com/2000676/title/6804137afd905a78.jpg\",\n" +
//                "            \"handle\": \"mahmoudatef.coder\",\n" +
//                "            \"avatar\": \"https://cdn-userpic.codeforces.com/2000676/avatar/a20355292baa6a50.jpg\",\n" +
//                "            \"firstName\": \"Mahmoud\",\n" +
//                "            \"contribution\": 0,\n" +
//                "            \"organization\": \"Faculty of Sciences Cairo university\",\n" +
//                "            \"rank\": \"pupil\",\n" +
//                "            \"maxRating\": 1374,\n" +
//                "            \"registrationTimeSeconds\": 1616377471,\n" +
//                "            \"maxRank\": \"pupil\"\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"lastName\": \"elspagh\",\n" +
//                "            \"country\": \"Egypt\",\n" +
//                "            \"lastOnlineTimeSeconds\": 1661524574,\n" +
//                "            \"city\": \"Cairo\",\n" +
//                "            \"rating\": 1140,\n" +
//                "            \"friendOfCount\": 40,\n" +
//                "            \"titlePhoto\": \"https://cdn-userpic.codeforces.com/1189790/title/82d84f22e3916aa8.jpg\",\n" +
//                "            \"handle\": \"zalapya\",\n" +
//                "            \"avatar\": \"https://cdn-userpic.codeforces.com/1189790/avatar/e0c12a5c723d141d.jpg\",\n" +
//                "            \"firstName\": \"mostafa\",\n" +
//                "            \"contribution\": 0,\n" +
//                "            \"organization\": \"Faculty of Sciences Cairo university\",\n" +
//                "            \"rank\": \"newbie\",\n" +
//                "            \"maxRating\": 1377,\n" +
//                "            \"registrationTimeSeconds\": 1562614633,\n" +
//                "            \"email\": \"mostafaelspagh0@gmail.com\",\n" +
//                "            \"maxRank\": \"pupil\"\n" +
//                "        }\n" +
//                "    ]\n" +
//                "}";


        String handle="Mahmoudatef.coder";
//        String handles[]={ "mahmoudatef.coder","hassan_fouad"};



//        HttpRequest httpRequest = HttpRequest.newBuilder()
//                .uri(new URI("https://codeforces.com/api/user.status?handle=mahmoudatef.coder"))
//                .build();
//
//
//        HttpClient httpClient=HttpClient.newHttpClient();
//        HttpResponse<String> response=httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
//
//        Gson gson =new Gson();
//        Type userResponseType=new TypeToken<CodeForcesResponse<ArrayList<Submission>>>(){}.getType();
//        CodeForcesResponse<ArrayList<Submission>> response1 = gson.fromJson(response.body(),userResponseType);


//        CodeForcesRequest<ArrayList<User>> request = CodeForcesRequest.getBuilder(CodeForcesRequest.Method.USER_INFO).
//                addParameter("handles", handle).build();
//
//        CodeForcesResponse<ArrayList<User>> response1 = request.doRequest();

//        CodeForcesRequest<ArrayList<User>> request = CodeForcesRequest.getBuilder(CodeForcesRequest.Method.USER_INFO).
//                addParameter("handles", handle).build();
////
//
////        HttpClient httpClient=HttpClient.newHttpClient();
////        HttpResponse<String> response=request.doRequest();
//
////        Gson gson =new Gson();
////        Type userResponseType=new TypeToken<CodeForcesResponse<ArrayList<User>>>(){}.getType();
//        CodeForcesResponse<ArrayList<User>> response1 = request.doRequest();

//        User user= UserHandler.getUser(handle);
//        System.out.println(user.getFirstName());


//        System.out.println(response1.getStatus());
//        for(User e :response1.getResult() )
//            System.out.println(e.getFirstName()+" "+e.getLastName());
//




        User user;
        ArrayList<Submission> subs=new ArrayList<Submission>();
        user= UserHandler.getUser(handle);
        System.out.println(user.getHandle());

        if(user!=null)
            subs= SubmissionHandler.getSubmission(user);

        subs.forEach((e)->{
            System.out.println(e.getProblem().getName());
        });

        if(user !=null){
            for (int i=0;i<subs.size();i++){
                Problem problem=subs.get(i).getProblem();

                String probUrl="https://codeforces.com/problemset/problem/"+problem.getContestId()+"/"+problem.getIndex();
                String tags="";
                for(String e: problem.getTags())tags+=e+" , ";

                String colorRow=subs.get(i).getVerdict()== null?"":
                        subs.get(i).getVerdict()== Submission.Verdict.OK?"table-success"
                                :"table-danger";

                String html= "<tr class=\""+colorRow+"\">\n" +
                        "   <td>"+i+"</td>\n" +
                        "   <td>"+problem.getName()+"</td>\n" +
                        "   <td>"+problem.getRating()+"</td>\n" +
                        "   <td>"+tags+"</td>\n" +
                        "   <td><a href=\""+probUrl+"\"> problem link</a></td>\n" +
                        "</tr>\n"
                        ;
                System.out.println(html);
            }

        }




    }
}

