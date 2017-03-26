<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html lang="pl">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Szukaj psów</title>

<link href="<c:url value="css/main.css"/>" rel="stylesheet"
	type="text/css">
<link href="<c:url value="css/buttons.css"/>" rel="stylesheet"
	type="text/css">
<link href="<c:url value="css/topPanel.css"/>" rel="stylesheet"
	type="text/css">
<link href="<c:url value="css/table.css"/>" rel="stylesheet"
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

	<div class="bigContainer">
		<div id="toFloat">
			<div class="addingDiv">
				<form:form commandName="searchForm" action="searchFor"
					cssClass="addingForm" method="post">

					<div class="text bigger">Kryteria wyszukiwania</div>
					<div class="element">
						<div class="text">Imię:</div>
						<form:input path="name" placeholder="tu wprowadź imię" />
					</div>

					<div class="element">
						<div class="text">Płeć:</div>
						<form:radiobutton path="sex" value="M" label="męska" />
						<form:radiobutton path="sex" value="Ż" label="żeńska" />
					</div>

					<div class="element">
						<div class="text">Rasa:</div>
						<form:input path="race" placeholder="tu wprowadź rasę" />
					</div>

					<div class="element">
						<div class="text">Waga od:</div>
						<form:input path="weightFrom" placeholder="tu wprowadź wagę" />
					</div>

					<div class="element">
						<div class="text">Waga do:</div>
						<form:input path="weightTo" placeholder="tu wprowadź wagę" />
					</div>

					<div class="element">
						<div class="text">Miejsce znalezienia:</div>
						<form:input path="placeOfFind"
							placeholder="tu wprowadź miejsce znalezienia" />
					</div>

					<div class="element">
						<div class="text">Data znalezienia od:</div>
						<form:input path="dateOfFindFrom" type="date" />
					</div>

					<div class="element">
						<div class="text">Data znalezienia do:</div>
						<form:input path="dateOfFindTo" type="date" />
					</div>

					<div class="element">
						<div class="text">Kojec</div>
						<form:select path="penId">
							<form:option value="" label="Nie wybrano"></form:option>
							<c:forEach var="p" items="${penList}">
								<form:option value="${p.id}" label="${p.name}"></form:option>
							</c:forEach>
						</form:select>
					</div>

					<div class="element">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" /> <input type="submit" class="add"
							value="Szukaj" />
					</div>
				</form:form>
			</div>
		</div>

		<c:if test="${dogList!=null}">

			<script>
				document.getElementById('toFloat').className = "fix";
			</script>

			<table class="mid">
				<thead>
					<tr>
						<th>Nr</th>
						<th>Imię</th>
						<th>Płeć</th>
						<th>Rasa</th>
						<th>Waga</th>
						<th>Miejsce znalezienia</th>
						<th>Data znalezienia</th>
						<th>Kojec</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="d" items="${dogList}">
						<tr>
							<td></td>
							<td>${d.name}</td>
							<td>${d.sex}</td>
							<td>${d.race}</td>
							<td>${d.weight}</td>
							<td>${d.placeOfFind}</td>
							<td>${d.dateOfFind}</td>
							<td>${d.penName}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>


	</div>

</body>
</html>