<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>

	<form action="j_spring_security_check" method="post">
		<label for="j_username">Login</label>: <input id="j_username"
			name="j_username" size="20" maxlength="50" type="text" /> <br /> <label
			for="j_password">Password</label>: <input id="j_password"
			name="j_password" size="20" maxlength="50" type="password" /> <br />
		<input id="_spring_security_remember_me"
			name="_spring_security_remember_me" type="checkbox" value="true" />
		<label for="_spring_security_remember_me">Remember Me?</label> <br />
		<input type="submit" value="Login" />
	</form>

</body>
</html>