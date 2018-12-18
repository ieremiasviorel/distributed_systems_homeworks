<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- <script src="js/admin-home.js" type="text/javascript"></script> -->
<!-- <link rel="stylesheet" href="css/admin-home.css" type="text/css"> -->

<title>Package Tracking System :: Home</title>
</head>
<body>

	Welcome ADMIN!
	
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
			<c:forEach items="${allParcels}" var="parcel">
				<tr>
					<td>${parcel.name}</td>
					<td>${parcel.description}</td>
					<td>${parcel.sender.fullName}</td>
					<td>${parcel.receiver.fullName}</td>
					<td>${parcel.delivery.originCity.name}</td>
					<td>${parcel.delivery.destinationCity.name}</td>
					<td>${parcel.delivery.tracked}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>