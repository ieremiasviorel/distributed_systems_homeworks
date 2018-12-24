<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Package Tracking System :: Home</title>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

<style>
h1 {
	display: inline-block;
}
.container {
	width: 100%;
	padding: 50px;
}
.table {
	width: 100%;
}
tbody tr {
	cursor: pointer;
}
</style>
<script>
var dataType='html';
$('tr').click(function(){        
   $.get('/assignment_4_1/client/parcel-details', { id: $(this).data('parcel_id') }, function(response){
       /* do something with response be it html, xml or JSON response*/
   }, dataType)
});
</script>
</head>
<body>

	<div class="container">
		<div>
			<h1>Welcome CLIENT!</h1>
			<button style="float: right" type="button" class="btn btn-info"
				onclick="location.href = 'http://localhost:8090/assignment_4_1/'">Logout</button>
		</div>
		
		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th scope="row">Name</th>
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
					<tr data-parcel_id="${clientPackage.id}"
					onclick="$.get('/assignment_4_1/client/parcel-details', { id: $(this).data('parcel_id') }, function(response){  $('div').html(response) }, dataType)">
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
	</div>
</body>
</html>