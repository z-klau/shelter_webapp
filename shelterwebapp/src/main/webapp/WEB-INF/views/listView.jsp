<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@page session="true"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Wszystkie psy w schronisku</title>
<link href="<c:url value="css/main.css"/>" rel="stylesheet"
	type="text/css">
<link href="<c:url value="css/table.css"/>" rel="stylesheet"
	type="text/css">
<link href="<c:url value="css/buttons.css"/>" rel="stylesheet"
	type="text/css">
<link href="<c:url value="css/topPanel.css"/>" rel="stylesheet"
	type="text/css">

<link href="<c:url value="css/edit.css"/>" rel="stylesheet"
	type="text/css">

<script src="<c:url value="js/edit.js" />"></script>
</head>
<body>

	<div class="panel">

		<sec:authorize var="loggedIn" access="isAuthenticated()" />
		<c:url value="/logout" var="logoutUrl" />

		<c:if test="${loggedIn}">
			<form action="${logoutUrl}" class="right" method="post">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" /> <input type="submit"
					class="loginButton logout" value="Wyloguj" />
			</form>
		</c:if>

		<a class="button" href="/shelterwebapp/">Powrót do panelu głównego</a>

		<c:if test="${message!=null}">
			<div class="messageContainer">
				<div class="message">${message}</div>
			</div>
		</c:if>

		<sec:authorize access="${!loggedIn}">
			<div class="messageContainer">
				<div class="message">Opcja edycji i usuwania dostępna tylko
					dla zalogowanych</div>
			</div>
		</sec:authorize>
	</div>


	<div class="middleContainer">
		<div class="header">Lista psów</div>

		<c:if test="${dogList!=null}">

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
							<c:if test="${loggedIn}">
							<th>Edytuj</th>
							<th>Usuń</th>
						</c:if>
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
							
							<c:if test="${loggedIn}">
								<td><input type="button" class="confirm" value="Edytuj"
									onclick="editDog('${d.name}', '${d.sex}', '${d.race}', '${d.weight}',
							'${d.placeOfFind}', '${d.dateOfFind}', '${d.penId}', '${d.id}')" />
								</td>

								<td>
									<form action="deleteDog" method="post" class="cancel">
										<input type="hidden" name="${_csrf.parameterName}"
											value="${_csrf.token}" /> <input type="hidden" name="dogId"
											value="${d.id}" /> <input type="submit" class="confirm"
											value="Usuń" />
									</form>
								</td>
							</c:if>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>


		<div id="greenContainer" class="greenContainer">

			<div class="formContainer">
				<form:form commandName="editDogForm" cssClass="editForm"
					action="editDog" method="post">

					<form:hidden path="id" id="dogId" value="" />
					<div class="element">
						<div class="text">Imię:</div>
						<form:input path="name" id="name" type="text" />
					</div>

					<div class="element">
						<div class="text">Płeć:</div>
						<form:radiobutton path="sex" id="sexM" value="M" label="męska"
							checked="" />
						<form:radiobutton path="sex" id="sexŻ" value="Ż" label="żeńska"
							checked="" />
					</div>

					<div class="element">
						<div class="text">Rasa:</div>
						<form:input path="race" id="race" type="text" />
					</div>

					<div class="element">
						<div class="text">Waga w kilogramach:</div>
						<form:input path="weight" id="weight" type="text" />
					</div>

					<div class="element">
						<div class="text">Miejsce znalezienia:</div>
						<form:input path="placeOfFind" id="placeOfFind" type="text" />
					</div>

					<div class="element">
						<div class="text">Data znalezienia:</div>
						<form:input path="dateOfFind" id="dateOfFind" type="date" />
					</div>

					<div class="element">
						<div class="text">Kojec</div>
						<form:select path="penId" id="penId">
							<c:forEach var="p" items="${penList}">
								<form:option value="${p.id}" label="${p.name}"></form:option>
							</c:forEach>
						</form:select>
					</div>

					<input type="submit" class="confirm" value="Zatwierdź zmiany" />

					<input type="button" class="confirm" value="Anuluj"
						onclick="hideForm()" />

				</form:form>
			</div>
		</div>
	</div>

</body>
</html>