<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
</head>
<body>
	<c:if test="${error == true}">
		<p>로그인 실패</p>
	</c:if>
	<h1>로그인</h1>
<!-- 	<form action="./j_spring_security_check" method="post"> -->
	<form action="login" method="post">
		<sec:csrfInput/>
		아이디: <input type="text" name="id"><br/>
		비밀번호: <input type="password" name="pw"><br/>
		<button type="submit">로그인</button>
	</form>
	<a href="./register">회원가입</a>

</body>
</html>