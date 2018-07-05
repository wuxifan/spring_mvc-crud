<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	<h3>${abc.id!=null ?'Updata':'add' }</h3>
	<c:if test="${abc.id != null }">
		<input type="hidden" name="_method" value="put" />
		<form:hidden path="id"/>
	</c:if>
	<form:form action="../emp" method="post" modelAttribute="abc">
		
		<table>
			<tr>
				<td>NAME</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>MAIL</td>
				<td><form:input path="mail" /></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><form:radiobuttons path="gender" items="${requestScope.genders}"/></td>
			</tr>
			<tr>
				<td>DEPARTNAME</td>
				<td>
					<form:select path="dept.deptId" items="${requestScope.depts}" itemLabel="deptName" ></form:select>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="${abc.id!=null ? 'updata':'add' }"/></td>
			</tr>
		</table>
	</form:form>

</body>
</html>