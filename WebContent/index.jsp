<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<!-- 如果当前时间为9-17点  可以访问当前页面 -->
	<a href="allEmps">LIST ALL EMPLOYEE</a>
	<br/>
	<br/>
	<a href="input/0">add</a>
	<br/>
	<a href="testGlobal"> TEST Global</a>
	<br/>
	<br/>
	<span style="font-family:SimSun;font-size:24px;"> 
	<form action="testFileUpload" method="POST" enctype="multipart/form-data">
		File: <input type="file" name="file"/>
		Desc: <input type="text" name="desc"/>
		<input type="submit" value="Submit"/>
</form></span>
	
</body>
</html>