<%@ page import="com.example.codeforcestool.models.User" %>
<%@ page import="com.example.codeforcestool.models.Contest" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.codeforcestool.controllers.UserHandler" %>
<%@ page import="com.example.codeforcestool.controllers.ContestHandler" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Mahmoud Atef
  Date: 8/30/2022
  Time: 11:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    User user=null;
    ArrayList<Contest> data = new ArrayList<>();
    if(request.getParameter("userhandle")!=null&&request.getParameter("others")!=null){
        String handle=request.getParameter("userhandle");
        String othersHandleStr=request.getParameter("others");
        user= UserHandler.getUser(handle);
        List<User> others=UserHandler.getUsers(othersHandleStr.trim().split(","));


        if(others!=null&&user!=null){
            data= ContestHandler.getNotJoined(user,others);
        }


    }


%>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <link rel="stylesheet" href="assets/fonts/jf-flat-font.css"/>
    <link rel="stylesheet" href="assets/css/style.css"/>
    <title>Contest</title>
</head>
<body>
<h1>Codeforces Problem list Creator</h1>
<p style="color: #b2bec3;">
    application create to get Contest that others solve it and you Not (hassan fouad idea)
</p>
<br/>
<div class="container h-100" style="min-height: 70vh;">
    <div class="mb-3">
        <form action="${pageContext.request.requestURL}" method="post">
            <div class="w-75 d-inline-block">
                <label class="fw-bolder">
                    Your Handle
                </label>
                <br>
                <input type="text" class="form-control text-center" name="userhandle" placeholder="Your Handle" value="<%= user!=null?(user.getHandle()):"" %>">

            </div>
            <input type="submit" class=" text-center btn btn-cf"  value="check">
            <div class="w-100 mt-3">
                <b>other users:</b><br>
                <input type="text" class="form-control text-center d-inline" style="width: 800px!important;" name="others" placeholder="sperate users with (,)" value="<%=user!=null?request.getParameter("others").trim():"" %>">
            </div>
        </form>
        <br>
        <div class="border  d-inline-block p-3 mb-3" style="width: 500px; border-radius: 20px;;">
            <img src="<%= user!=null?(user.getTitlePhoto()):"https://cdn-userpic.codeforces.com/no-title.jpg" %>" class="rounded-circle float-start" style="width: 80px; height: 80px;"/>
            <h4 class="" style="color: <%= user==null?"black":user.getRank()==null?"black":user.getRankColor() %>">
                <%
                    String name ="";
                    if(user!=null){
                        if(user.getFirstName()!=null)
                            name+= user.getFirstName();
                        if(user.getLastName()!=null)
                            name+= " "+user.getLastName();
                    }
                %>
                <%= name %>
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
            </thead>
            <tbody>
            <%
                if(user !=null){
                    for (int i=0;i<data.size();i++){
                        Contest contest=data.get(i);
//
                        String contestUrl="https://codeforces.com/contest/"+contest.getId();
//                        String gymUrl="https://codeforces.com/gym/"+problem.getContestId()+"/problem/"+problem.getIndex();
//
//                        String tags="";
//                        for(String e: problem.getTags())tags+=e+" , ";
//
//                        String colorRow=data.get(i).getStatus()== ProblemContainer.Status.UNSOLVED?"table-danger":
//                                data.get(i).getStatus()== ProblemContainer.Status.SOLVED?"table-success"
//                                        :"";
//
                        String html= "<tr class=\""+""+"\">\n" +
                                "   <td>"+(i+1)+"</td>\n" +
                                "   <td><a href=\""+contestUrl+"\">"+contest.getName()+"</a></td>\n" +
                              "</tr>\n"
                                ;
                        out.println(html);
                    }

                }

            %>
<%--            <%=data.size()%>--%>



            </tbody>
        </table>
    </div>
</div>



<%--<footer dir="ltr" style="font-size: 0.9rem; color: #98a0a3; padding: 5px; float: bottom;">--%>

<%--    Developed BY <a href="mailto:MahmoudAtef.coder@gmail.com">Mahmoud Atef</a>--%>
<%--</footer>--%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>



</body>
</html>
