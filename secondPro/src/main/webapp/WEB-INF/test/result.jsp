<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>스프링 web MVC구축하기</h1>
	<hr/>
	<h3>jsp로 코드 출력하기:<%= request.getAttribute("msg") %></h3>
	<h3>EL로 출력하기: ${msg}</h3>
</body>
</html>