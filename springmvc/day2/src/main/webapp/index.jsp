<%--
  Created by IntelliJ IDEA.
  User: shich
  Date: 2021/2/24
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    <h3>文件上传</h3>--%>
<%--    <form action="user/fileupload2" method="post" enctype="multipart/form-data">--%>
<%--        选择文件：<input type="file" name="upload"/><br/>--%>
<%--        <input type="submit" value="上传文件"/>--%>
<%--    </form>--%>
    <h3>跨服务器的文件上传</h3>
    <form action="user/fileupload3" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="upload"/><br/>
    <input type="submit" value="上传文件"/>
</form>
</body>
</html>
