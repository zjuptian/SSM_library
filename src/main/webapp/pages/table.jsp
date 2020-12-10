<%@ page import="com.alibaba.fastjson.JSONArray" %>
<%@ page import="com.alibaba.fastjson.JSONObject" %>
<%@ page import="java.math.BigDecimal" %><%--
  Created by IntelliJ IDEA.
  User: tianpeng
  Date: 2020/11/21
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3 align="center">测试新增</h3>
    <div align="center">
    <form action="/account/save.do" method="post">
        姓名： <input type="text" name="name"/><br/>
        金额： <input type="text" name="money"/><br/>
        <input type="submit" value="保存"/>
    </form>
    </div>
    <table width="80%" border="1" align="center" >
        <caption align="top">User Info</caption>
        <tr>
            <td>id</td>
            <td>姓名</td>
            <td>金额</td>
            <td>操作</td>
        </tr>

        <%
            String str = (String) request.getAttribute("result");
            JSONArray jsonArray = JSONArray.parseArray(str);
            for(int i = 0 ; i<jsonArray.size();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Integer id = (Integer) jsonObject.get("id");
                String name = (String) jsonObject.get("name");
                BigDecimal money = (BigDecimal) jsonObject.get("money");
                out.print("<tr><td>"+id.toString()+"</td>"+"<td>"+name+"</td>"+"<td>"+money.toString()+"</td>"+"<td>"+"<a href=/account/delete.do?id="+id.toString()+">删除</a></td></tr>");

            }
        %>
    </table>
</body>
</html>
