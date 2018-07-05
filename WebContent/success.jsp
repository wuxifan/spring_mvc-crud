<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
</script>
<script>
	$(function(){
		$('a:first').click(function (){
			$('form').attr('action',$(this).attr('href')).submit();
			return false;
		});
	});
</script>
</head>
<body>
	<c:if test="${empty requestScope.emps }">
		<h3 align="center">No Employees</h3>
	</c:if>
	<c:if test="${!empty requestScope.emps }">
		<h3 align="center">The Employees List</h3>
		<table width="500px" border="1" align="center">
			<tr>
				<td>ID</td>
				<td>NAME</td>
				<td>MAIL</td>
				<td>GENDER</td>
				<td>DEPTNAME</td>
				<td>DELETE</td>
				<td>UPDATE</td>
			</tr>
			<c:forEach items="${requestScope.emps }" var="emp">
				<tr>
				<td>${emp.id }</td>
				<td>${emp.name }</td>
				<td>${emp.mail }</td>
				<td>${emp.gender ==0?'MALE':'FEMALE'}</td>
				<td>${emp.dept.deptName }</td>
				<td><a href="emp/${emp.id}">DELETE</a></td>
				<td><a href="input/${emp.id }">UPDATE</a></td>
			</tr>
			</c:forEach>
		</table>
	</c:if>
	<!-- Get请求转为springmvc中的delete以及put请求
			
			post转为delete put
			HiddenHttpMethodFilter ,post请求  _method ,delete
	 -->
	 
	 <form action="" method="post">
	 	<input type="hidden" name="_method" value="delete"/>
	 </form>
</body>
</html>