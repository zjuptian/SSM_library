<%--
  Created by IntelliJ IDEA.
  User: tianpeng
  Date: 2020/11/20
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>账号列表页面</h3>
    <a href="/account/findAll.do">查询所有</a>

    <h3>测试新增</h3>
    <form action="/account/save.do" method="post">
        姓名： <input type="text" name="name"/><br/>
        金额： <input type="text" name="money"/><br/>
        <input type="submit" value="保存"/>
    </form>
</body>
</html>
