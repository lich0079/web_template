<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login page</title>


</head>
<body>

	<form action="login.do" method="post">
		<center>
			<div class="main" ></div>
			<table  class="loginDiv" >
				
				<tr>
					<td colspan="2" >Username</td>
				</tr>
				<tr>
					<td colspan="2"><input name="userName" type="text" class="login-text"></td>
				</tr>
				<tr>
					<td colspan="2" >Password</td>
				</tr>
				<tr>
					<td colspan="2"><input name="password" type="password"  class="login-text"></td>
				</tr>
				<tr>
					<td><input type="reset" value="rest" class="btn-reset" /></td>
					<td align="right"><input type="submit" value="login" class="btn-submit" /></td>
				</tr>
			</table>
		</center>
	</form>

</body>
</html>