<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">

<title>Package Tracking System :: Add parcel</title>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

<style>
h1 {
	display: inline-block;
}
.container {
	width: 600px;
	margin: 50px auto;
	padding: 50px;
}
form button {
	width: 100%;
}
</style>
</head>
<body>
	<div class="container">
		<div>
			<h1>Add Parcel</h1>
			<button style="float: right" type="button" class="btn btn-info">Logout</button>
		</div>
	
		<form action="" method="post" autocomplete="off">
			<div class="form-group">
		    	<label for="inputName">Name</label>
		    	<input type="text" name="name" class="form-control" id="inputName" aria-describedby="nameHelp" placeholder="Enter name">
		    	<small id="Help" class="form-text text-muted"></small>
		  	</div>
		  	
		  	<div class="form-group">
		    	<label for="inputDescription">Description</label>
		    	<textarea name="description" class="form-control" id="inputDescription" aria-describedby="descriptionHelp" placeholder="Enter description"></textarea>
		    	<small id="descriptionHelp" class="form-text text-muted"></small>
		  	</div>
		  	
		  	<div class="form-group">
		    	<label for="inputSender">Sender</label>
			  	<select name="sender" class="form-control" id="inputSender" aria-describedby="senderHelp" placeholder="Enter sender">
			  		<option default hidden>--</option>
			  		<c:forEach items="${allUsers}" var="user">
			  			<option value="${user.username}">
			  				${user.fullName}
			  			</option>
			  		</c:forEach>	
			  	</select>
			  	<small id="senderHelp" class="form-text text-muted"></small>
		  	</div>
		  	
		  	<div class="form-group">
		    	<label for="inputSenderCity">Origin city</label>
			  	<select name="senderCity" class="form-control" id="inputSenderCity" aria-describedby="senderCityHelp" placeholder="Enter departure city">
			  		<option default hidden>--</option>
			  		<c:forEach items="${allCities}" var="city">
			  			<option value="${city.name}">
			  				${city.name}
			  			</option>
			  		</c:forEach>	
			  	</select>
			  	<small id="senderCityHelp" class="form-text text-muted"></small>
		  	</div>
		  	
		  	<div class="form-group">
		    	<label for="inputReceiver">Receiver</label>
			  	<select name="receiver" class="form-control" id="inputReceiver" aria-describedby="receiverHelp" placeholder="Enter receiver">
			  		<option default hidden>--</option>
			  		<c:forEach items="${allUsers}" var="user">
			  			<option value="${user.username}">
			  				${user.fullName}
			  			</option>
			  		</c:forEach>	
			  	</select>
			  	<small id="receiverHelp" class="form-text text-muted"></small>
		  	</div>
		  	
		  	<div class="form-group">
		    	<label for="inputReceiverCity">Destination city</label>
			  	<select name="receiverCity" class="form-control" id="inputReceiverCity" aria-describedby="receiverCityHelp" placeholder="Enter arrival city">
			  		<option default hidden>--</option>
			  		<c:forEach items="${allCities}" var="city">
			  			<option value="${city.name}">
			  				${city.name}
			  			</option>
			  		</c:forEach>	
			  	</select>
			  	<small id="receiverCityHelp" class="form-text text-muted"></small>
		  	</div>
		  	
		  	<button type="submit" class="btn btn-primary">Submit</button>
	  	</form>
  	</div>
</body>
</html>