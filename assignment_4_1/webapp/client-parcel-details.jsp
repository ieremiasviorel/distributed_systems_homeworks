<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">

<title>Package Tracking System :: Register</title>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

<style>
.card {
	width: 500px;
	margin: 50px;
	padding: 50px;
}
button {
	width: 100%;
}
</style>
</head>
<body>
	<div class="card">
		<form action="" method="post" autocomplete="off">
		
			<h2>Parcel details</h2>
		
			<div class="form-group">
		    	<label for="name">Name</label>
		    	<input type="text" id="name" class="form-control" disabled value="${parcel.name}">
		  	</div>
		  	
			<div class="form-group">
		    	<label for="description">Description</label>
		    	<textarea id="description" class="form-control" disabled>${parcel.description}</textarea>
		  	</div>
		  	
		  	<div class="form-group">
		    	<label for="name">Sender</label>
		    	<input type="text" id="name" class="form-control" disabled value="${parcel.sender.fullName}">
		  	</div>
		  	
		  	<div class="form-group">
		    	<label for="name">Receiver</label>
		    	<input type="text" id="name" class="form-control" disabled value="${parcel.receiver.fullName}">
		  	</div>
		  	
		  	<div class="form-group">
		    	<label for="name">Sent from</label>
		    	<input type="text" id="name" class="form-control" disabled value="${parcel.delivery.originCity.name}">
		  	</div>
		  	
		  	<div class="form-group">
		    	<label for="name">Arriving at</label>
		    	<input type="text" id="name" class="form-control" disabled value="${parcel.delivery.destinationCity.name}">
		  	</div>
		  	
		  	<div class="form-group">
		    	<label for="description">Route</label>
		    	<div id="description" class="form-control">
		    		<ul>
			    		<c:forEach items="${routeCities}" var="routeCity">
			    			<li>${routeCity.name}</li>
			    		</c:forEach>
		    		</ul>
		    	</div>
		  	</div>
		  	
		  	<br><br>
		  	<button type="button" onclick="location.href = 'http://localhost:8090/assignment_4_1/client'" class="btn btn-seconday">Back</button>
	  	</form>
  	</div>
</body>
</html>