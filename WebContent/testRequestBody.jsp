<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
</script>
<script type="text/javascript">
	$(function(){
		$('#testRequestBody').click(function (){
			$.ajax({
				url:'http://localhost:8080/spring_mvc-crud/testRequestBody',
				type:'post',
				contentType:'application/json;charset=utf-8',
				data:'[{"age":16,"qname":"xifan"},{"age":26,"qname":"qianying"}]',
				success:function(result){
					$.each(result,function(index,value){
						alert(value.qname+","+value.age);
					})
				}
			});
			return false;
		});
	});
</script>
</head>
<body>
<a id="testRequestBody" href="testRequestBody.jsp">Test RequestBody</a>

</body>
</html>