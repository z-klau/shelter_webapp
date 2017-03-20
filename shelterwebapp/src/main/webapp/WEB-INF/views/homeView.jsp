<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html lang="pl">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Witamy w schronisku</title>

<link href="<c:url value="css/main.css"/>" rel="stylesheet"
	type="text/css">
<link href="<c:url value="css/buttons.css"/>" rel="stylesheet"
	type="text/css">
<link href="<c:url value="css/login.css"/>" rel="stylesheet"
	type="text/css">

</head>
<body>

	<sec:authorize var="loggedIn" access="isAuthenticated()" />
	<c:url value="/logout" var="logoutUrl" />

	<div class="top">
		<c:choose>
			<c:when test="${!loggedIn}">
				<div class="loginContainer">
					<form action="${loginUrl}" method="post">
						<input type="text" name="name" placeholder="Nazwa użytkownika">
						<input type="password" name="password" placeholder="Hasło">
						<input type="submit" class="loginButton" value="Zaloguj">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>
				</div>
			</c:when>
			<c:otherwise>
				<form action="${logoutUrl}" method="post">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
					<input type="submit" class="loginButton logout" value="Wyloguj"/>
				</form>
			</c:otherwise>
		</c:choose>
	</div>

	<div class="container">
		<div class="login-panel">
			<div class="title">Witaj w panelu zarządzania schroniskiem</div>

			<div class="">
				<c:choose>
					<c:when test="${loggedIn}">
						<a class="button" href="/shelterwebapp/add">Dodaj psa</a>
					</c:when>
					<c:otherwise>
						<a class="button disabled">Aby dodać psa należy się zalogować
						</a>
					</c:otherwise>
				</c:choose>
				<a class="button" href="/shelterwebapp/list">Psy do adopcji</a>
			</div>
		</div>
	</div>

</body>
</html>