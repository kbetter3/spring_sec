<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h1>회원가입</h1>
	<form action="./register" method="post" name="member">
		<sec:csrfInput/>
		<input type="text" name="id" placeholder="아이디"><br/>
		<input type="password" name="pw" placeholder="비밀번호"><br/>
		<input type="text" name="name" placeholder="이름"><br/>
		<button type="submit">회원가입</button>
		<button type="button" id="cancel">취소</button>
	</form>
	
	<script>
		$(function(){
			$("#cancel").on("click", function(){
				history.go(-1);
			});
		});
	</script>
</body>
</html>