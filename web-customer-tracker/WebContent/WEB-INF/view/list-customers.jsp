<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>

<head>

<title>List Customers</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body id="wrapper">

	<div id="header">
		<h2>CRM - Customer Relationship Manager</h2>
	</div>


	<div id="container">
		<div id="content">

			<!-- Add button -->
			<input type="button" value="Add Customer"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button" />
			<!-- adding the html table here -->
			<table>
				<tr>
					<th>First Name</th>

					<th>Last Name</th>

					<th>Email</th>

					<th>Action</th>

				</tr>



				<c:forEach var="tempCustomer" items="${customers}">

					<!-- construct update link with customer Id -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}"></c:param>
					</c:url>
					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<td><a href="${updateLink}">Update</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>