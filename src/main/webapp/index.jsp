<%@ page import="com.example.codeforcestool.models.User" %>
<%@ page import="com.example.codeforcestool.controllers.UserHandler" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.codeforcestool.models.Submission" %>
<%@ page import="com.example.codeforcestool.controllers.SubmissionHandler" %>
<%@ page import="com.example.codeforcestool.models.Problem" %>
<%@ page import="com.example.codeforcestool.models.containers.ProblemContainer" %>
<%@ page import="com.example.codeforcestool.controllers.ProblemHandler" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    User user=null;
//    ArrayList<Submission> subs = new ArrayList<>();
    ArrayList<ProblemContainer> data = new ArrayList<>();
    if(request.getParameter("userhandle")!=null){
        String handle=request.getParameter("userhandle").trim();
        user= UserHandler.getUser(handle);
        if(user!=null) {
            String users[]=new String[0] ;
//            {
////                    "tourist",
////                    "jiangly",
////                    "Um_nik",
////                    "slime",
////                    "djq_cpp",
////                    "maroonrk",
////                    "MiracleFaFa",
////                    "Radewoosh",
////                    "Petr",
//                    "Yousef_Salama",
//                    "abdelkarim",
//                    "abdou_93",
//                    "AhmedMorgan",
//                    "-Green",
//                   "mahmoudbadawy",
//                    "mohammedehab2002",
//                    "AbdullahAlabd",
////                    "DeadlyPillow",
//                    "Uzumaki_Narutoo",
//                    "OBITO",
//                    "Yossef",
////                    "Amr_elmowaled",
////                    "Abdelshakour",
////                    "3bdo_Farah",
//            };
            ArrayList<String> tags = new ArrayList<>();
            if(!request.getParameter("others").trim().isEmpty()){
                users = request.getParameter("others").trim().split(",");
            }

            ArrayList<User> usersList = UserHandler.getUsers(users);
            if (usersList != null){
                int from = request.getParameter("from").trim().isEmpty() ? 0 : Integer.parseInt(request.getParameter("from"));
                int to = request.getParameter("to").trim().isEmpty() ? 99999 : Integer.parseInt(request.getParameter("to"));

                data = ProblemHandler.getAllProblem(user, usersList, tags, from, to);
            }
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
        <link rel="stylesheet" href="assets/fonts/jf-flat-font.css"/>
        <link rel="stylesheet" href="assets/css/style.css"/>

        <title>JSP - Hello World</title>
    </head>
    <body>
        <h1>Codeforces Problem list Creator</h1>
        <p style="color: #b2bec3;">
            application create to get problems that others solve it in topics
        </p>
        <br/>
        <div class="container h-100" style="min-height: 70vh;">
            <div class="mb-3">
                <form action="${pageContext.request.requestURL}" method="post">
                    <div class="w-25 d-inline-block">
                        <label class="fw-bolder">
                            Your Handle
                        </label>
                        <br>
                        <input type="text" class="form-control text-center" name="userhandle" placeholder="Your Handle" value="<%= user!=null?(user.getHandle()):"" %>">

                    </div>
                    <div class="w-25 d-inline-block">
                        <label class="fw-bolder">
                            Rating
                        </label>
                        <br>
                        <div class="d-inline-block">
                            from:
                            <input type="number" class="form-control text-center d-inline" style="width: 100px!important;" name="from" placeholder="1200" value="<%=user!=null?request.getParameter("from").trim():"" %>">
                        </div>
                        <div class="d-inline-block">
                            to:
                            <input type="number" class="form-control text-center d-inline" style="width: 100px!important;" name="to" placeholder="1800" value="<%=user!=null?request.getParameter("to").trim():"" %>">
                        </div>
                    </div>
                    <input type="submit" class=" text-center btn btn-cf"  value="check">
                    <div class="w-100 mt-3">
                        other users:
                        <input type="text" class="form-control text-center d-inline" style="width: 500px!important;" name="others" placeholder="sperate users with (,)" value="<%=user!=null?request.getParameter("others").trim():"" %>">

                    </div>
                </form>
                <br>
                <div class="border  d-inline-block p-3 mb-3" style="width: 500px; border-radius: 20px;;">
                    <img src="<%= user!=null?(user.getTitlePhoto()):"https://cdn-userpic.codeforces.com/no-title.jpg" %>" class="rounded-circle float-start" style="width: 80px; height: 80px;"/>
                    <h4 class="" style="color: <%= user!=null?(user.getRankColor()):"black" %>">
                        <%= user!=null?(user.getFirstName()+" "+user.getLastName()):"" %>
                    </h4>
                    <p class="">

                        <%= user!=null?(user.getCountry()+","+user.getCity()):"" %>
                        <br>
                        <%= user!=null?(user.getOrganization()):"" %>

                    </p>
                </div>
                <table class="table">
                    <thead class="table-dark">
                        <th>#</th>
                        <th>name</th>
                        <th>rating</th>
                        <th>tags</th>
                        <th>link</th>
                    </thead>
                    <tbody>
                        <%
                            if(user !=null){
                                for (int i=0;i<data.size();i++){
                                    Problem problem=data.get(i).getProblem();

                                    String probUrl="https://codeforces.com/problemset/problem/"+problem.getContestId()+"/"+problem.getIndex();
                                    String gymUrl="https://codeforces.com/gym/"+problem.getContestId()+"/problem/"+problem.getIndex();

                                    String tags="";
                                    for(String e: problem.getTags())tags+=e+" , ";

                                    String colorRow=data.get(i).getStatus()== ProblemContainer.Status.UNSOLVED?"table-danger":
                                            data.get(i).getStatus()== ProblemContainer.Status.SOLVED?"table-success"
                                            :"";

                                    String html= "<tr class=\""+colorRow+"\">\n" +
                                                "   <td>"+i+"</td>\n" +
                                                "   <td>"+problem.getName()+"</td>\n" +
                                                "   <td>"+problem.getRating()+"</td>\n" +
                                                "   <td>"+tags+"</td>\n" +
                                                "   <td><a href=\""+probUrl+"\"> problem link</a>" +
                                                    "<br><b>if GYM:</b> <a href=\""+gymUrl+"\"> problem link</a>       " +
                                                    "</td>\n" +
                                                "</tr>\n"
                                            ;
                                   out.println(html);
                                }

                            }

                        %>



                    </tbody>
                </table>
            </div>
        </div>



        <footer dir="ltr" style="font-size: 0.9rem; color: #98a0a3; padding: 5px; float: bottom;">

            Developed BY <a href="mailto:MahmoudAtef.coder@gmail.com">Mahmoud Atef</a>
        </footer>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
    </body>
</html>