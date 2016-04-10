<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2016/4/9
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="jquery-1.10.2.js"></script>
    <script type="text/javascript">
        $(function(){
            var url="/webProject/testServlet.do";

//            var url="http://qb4kr1att8.proxy.qqbrowser.cc/webproject/FirstServletDemo";

            $("#getTest").on("click",function(){
                $.get(url,function(data){
                    console.log(data);
                },"json");
            });
            $("#postTest").on("click",function(){
                $.post(url,{username:$("#username").val(),userpwd:$("#userpwd").val()},function(data){
                    console.log(data);
                });
            });

        });

    </script>
</head>
<body>
<form id="myform" method="post" action="/webProject/testServlet.do">
    <table>
        <tr>
            <td>用户名</td>
            <td>
                <input type="text" name="username" id="username">
            </td>
        </tr>
        <tr>
            <td>密码</td>
            <td>
                <input type="password" name="userpwd" id="userpwd">
            </td>
        </tr>
        <tr>
            <td>提交</td>
            <td>
                <input type="submit" name="submit" value="提交">
            </td>
        </tr>
    </table>

</form>
<button id="getTest">get</button>
<button id="postTest">post</button>
</body>
</html>
