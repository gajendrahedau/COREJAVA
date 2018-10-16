<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN PAGE</title>
</head>
<body>
<form name="loginForm" action="login" method="post">
<table>
<tr>
<td>Associate ID:</td>
<td><input type="text" name="associateId" placeholder="enter your associate id" required></td>
</tr>
<tr>
<td>Password:</td>
<td><input type="password" name="password" placeholder="Enter Password" 
required></td>
</tr>
<tr>
<td>Submit:</td>
<td><input type="submit" value="Submit" /></td>
</tr>
<tr>
<td>Reset:</td>
<td><input type="reset" value="Reset" /></td>
</tr>
</table>
</form>

<div>
<font color='red'>
 ${requestScope.errorMessage}
</font></div>
</body>
</html>