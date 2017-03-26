<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@page session="true"%>
<html lang="pl">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Dodaj psa do schroniska</title>

<link href="<c:url value="css/main.css"/>" rel="stylesheet"
	type="text/css">
<link href="<c:url value="css/buttons.css"/>" rel="stylesheet"
	type="text/css">
<link href="<c:url value="css/topPanel.css"/>" rel="stylesheet"
	type="text/css">
<link href="<c:url value="css/add.css"/>" rel="stylesheet"
	type="text/css">
</head>
<body>

	<div class="panel">
		<c:url value="/logout" var="logoutUrl" />
		<sec:authorize var="loggedIn" access="isAuthenticated()" />

		<c:if test="${loggedIn}">
			<form action="${logoutUrl}" class="right" method="post">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" /> <input type="submit"
					class="loginButton logout" value="Wyloguj" />
			</form>
		</c:if>

		<a class="button" href="/shelterwebapp/">Powrót do panelu głównego</a>

		<c:if test="${message!=null}">
			<div class="message">${message}</div>
		</c:if>
	</div>

	<div class="addingDiv">
		<form:form commandName="dogForm" cssClass="addingForm" action="addDog"
			method="post">

			<div class="element">
				<div class="text">Podaj imię:</div>
				<form:input path="name" type="text" placeholder="tu wprowadź imię" />
				<form:errors path="name" cssClass="error"></form:errors>
			</div>
			<div class="element">
				<div class="text">Wybierz płeć:</div>
				<form:radiobutton path="sex" value="M" label="męska"
					checked="checked" />
				<form:radiobutton path="sex" value="Ż" label="żeńska" />
			</div>

			<div class="element">
				<div class="text">Podaj rasę:</div>
				<form:input path="race" type="text" placeholder="tu wprowadź rasę" />
				<form:errors path="race" cssClass="error"></form:errors>
			</div>

			<div class="element">
				<div class="text">Podaj wagę kilogramach:</div>
				<form:input path="weight" type="text" placeholder="tu wprowadź wagę" />
				<form:errors path="weight" cssClass="error"></form:errors>
			</div>

			<div class="element">
				<div class="text">Podaj miejsce znalezienia:</div>
				<form:input path="placeOfFind" type="text"
					placeholder="tu wprowadź miejsce znalezienia" />
				<form:errors path="placeOfFind" cssClass="error"></form:errors>
			</div>

			<div class="element">
				<div class="text">Podaj datę znalezienia:</div>
				<form:input path="dateOfFind" type="date" />
				<form:errors path="dateOfFind" cssClass="error"></form:errors>
			</div>

			<div class="element">
				<div class="text">Wybierz kojec dla psa</div>
				<form:select path="penId">
					<c:forEach var="p" items="${penList}">
						<form:option value="${p.id}" label="${p.name}"></form:option>
					</c:forEach>
				</form:select>
			</div>

			<div class="element">
				<input type="submit" class="add" value="Dodaj" />
			</div>

		</form:form>
	</div>

</body>
</html>