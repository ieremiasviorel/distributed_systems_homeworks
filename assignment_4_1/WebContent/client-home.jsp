<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- <script src="js/client-home.js" type="text/javascript"></script> -->
<link rel="stylesheet" type="text/css" href="css/client-home.css">

<title>Package Tracking System :: Home</title>
</head>
<body>

	Welcome CLIENT!
	
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Description</th>
				<th>Sender</th>
				<th>Receiver</th>
				<th>From</th>
				<th>To</th>
				<th>Tracked</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${clientPackages}" var="clientPackage">
				<tr>
					<td>${clientPackage.name}</td>
					<td>${clientPackage.description}</td>
					<td>${clientPackage.sender.fullName}</td>
					<td>${clientPackage.receiver.fullName}</td>
					<td>${clientPackage.delivery.originCity.name}</td>
					<td>${clientPackage.delivery.destinationCity.name}</td>
					<td>${clientPackage.delivery.tracked}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>