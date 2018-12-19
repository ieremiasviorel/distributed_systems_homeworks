<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">

<title>Package Tracking System :: Register</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

<style>
.card {
	width: 500px;
	margin: 50px auto;
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
		
			<div class="form-group">
		    	<label for="inputFullname">Full name</label>
		    	<input type="text" name="fullname" class="form-control" id="inputFullname" aria-describedby="fullnameHelp" placeholder="Enter full name">
		    	<small id="fullnameHelp" class="form-text text-muted"></small>
		  	</div>
		  	
			<div class="form-group">
		    	<label for="inputUsername">Username</label>
		    	<input type="text" name="username" class="form-control" id="inputUsername" aria-describedby="usernameHelp" placeholder="Enter username">
		    	<small id="usernameHelp" class="form-text text-muted"></small>
		  	</div>
		  	
		  	<div class="form-group">
		    	<label for="inputPassword">Password</label>
		    	<input type="password" name="password" class="form-control" id="inputPassword" aria-describedby="passwordHelp" placeholder="Enter password">
		    	<small id="passwordHelp" class="form-text text-muted"></small>
		  	</div>
		  	
		  	<br><br>
		  	<button type="submit" class="btn btn-success">Register</button>
		  	<br><br>
		  	<button type="button" onclick="location.href = 'http://localhost:8090/assignment_4_1'" class="btn btn-seconday">Back</button>
	  	</form>
  	</div>
</body>
</html>