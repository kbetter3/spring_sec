<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>회원정보</h1>
	<table>
		<tr>
			<th>회원번호</th>
			<th>아이디</th>
			<th>이름</th>
			<th>회원등급</th>
		</tr>
		<tr>
<%-- 			<td>${member.seq }</td> --%>
<%-- 			<td>${member.id }</td> --%>
<%-- 			<td>${member.name }</td> --%>
		</tr>
	</table>
	
	<form action="./logout" method="post">
		<sec:csrfInput/>
		<button type="submit">logout</button>
	</form>
</body>
</html>
