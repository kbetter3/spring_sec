<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>회원리스트</h1>
	<table>
		<tr>
			<th>회원번호</th>
			<th>아이디</th>
			<th>이름</th>
			<th>회원등급</th>
		</tr>
		<c:forEach items="${memberList}" var="member">
			<tr>
				<td>${member.seq }</td>
				<td>${member.id }</td>
				<td>${member.name }</td>
				<td>
					<c:choose>
						<c:when test="${member.power == 1}">관리자</c:when>
						<c:otherwise>일반회원</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<div>
		<a href="./info">메인화면</a>
	</div>
</body>
</html>