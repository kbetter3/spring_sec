<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
	<title>Home</title>
	<style>
		span {
			width: 50%;
			white-space: nowrap;
		}
	</style>
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
	</table>
	
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<div><a href="./admin">회원관리</a></div>
	</sec:authorize>
	
	<form action="./logout" method="post">
		<sec:csrfInput/>
		<button type="submit">logout</button>
	</form>
	
	<div>
		<img alt="filterchain" src="./resources/security_filter_chain.png">
	</div>
	<div>
		<ol>
			<li>SecurityContextPersistenceFilter : SecurityContextRepository에서 SecurityContext를 가져오거나 저장하는 역할을 한다. (SecurityContext는 밑에)</li>
			<li>LogoutFilter : 설정된 로그아웃 URL로 오는 요청을 감시하며, 해당 유저를 로그아웃 처리</li>
			<li>(UsernamePassword)AuthenticationFilter : (아이디와 비밀번호를 사용하는 form 기반 인증) 설정된 로그인 URL로 오는 요청을 감시하며, 유저 인증 처리
				<ol>
					<li>AuthenticationManager를 통한 인증 실행</li>
					<li>인증 성공 시, 얻은 Authentication 객체를 SecurityContext에 저장 후 AuthenticationSuccessHandler 실행</li>
					<li>인증 실패 시, AuthenticationFailureHandler 실행</li>
				</ol>
			</li>
			<li>DefaultLoginPageGeneratingFilter : 인증을 위한 로그인폼 URL을 감시한다.</li>
			<li>BasicAuthenticationFilter : HTTP 기본 인증 헤더를 감시하여 처리한다.</li>
			<li>RequestCacheAwareFilter : 로그인 성공 후, 원래 요청 정보를 재구성하기 위해 사용된다.</li>
			<li>SecurityContextHolderAwareRequestFilter : HttpServletRequestWrapper를 상속한<br/>SecurityContextHolderAwareRequestWapper 클래스로 HttpServletRequest 정보를 감싼다.<br/>SecurityContextHolderAwareRequestWrapper 클래스는 필터 체인상의 다음 필터들에게 부가정보를 제공한다.</li>
			<li>AnonymousAuthenticationFilter : 이 필터가 호출되는 시점까지 사용자 정보가 인증되지 않았다면 인증토큰에 사용자가 익명 사용자로 나타난다.</li>
			<li>SessionManagementFilter : 이 필터는 인증된 사용자와 관련된 모든 세션을 추적한다.</li>
			<li>ExceptionTranslationFilter : 이 필터는 보호된 요청을 처리하는 중에 발생할 수 있는 예외를 위임하거나 전달하는 역할을 한다.</li>
			<li>FilterSecurityInterceptor : 이 필터는 AccessDecisionManager 로 권한부여 처리를 위임함으로써 접근 제어 결정을 쉽게해준다.</li>
		</ol>
		<p>[출처] http://sjh836.tistory.com/165</p>
	</div>
</body>
</html>
