<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SIGNUP PAGE</title>
</head>
<body>
	<form name="resgistrationForm" action="registration" method="post">
		AssociateId: <input type="text" name="associateId"
			placeholder="Create your associateId" required> <br>
		<br> Password: <input type="password" name="password"
			placeholder="Enter Password" required> <br>
		<br> 
		First name: <input type="text" name="firstName" required> <br>
		<br> Last name: <input type="text" name="lastName" required>
		<br>
		<br>Email: <input type="email" name="email"> <br>
		Hobbies:
<input type="checkbox" name="hobbies" value="painting"> Painting<br>
<input type="checkbox" name="hobbies" value="dancing">dancing<br>
  <input type="checkbox" name="hobbies" value="singing" checked="checked">Singing<br>
  <br><br>
  Date of birth:
<input type="date" min="2018-01-01" max="2018-12-31" name="date" required>
<br><br> 
Submit: <input type="submit" value="Submit" /> <br>
		<br> Reset: <input type="reset" value="Reset" />
	</form>
</body>
</html>