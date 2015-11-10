<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登陆</title>
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    	<form action="login.do" method="post">
    	<input type="hidden" name="flag" value="login"/>
    		<table>
    			<tr>
    				<td>用户名：</td>
    				<td><input type="text"  name="name" /></td>
    			</tr>
    			<tr>
    				<td>密码：</td>
    				<td><input type="password"  name="password" /></td>
    			</tr>
    			<tr>
    				<td><input type="submit" value="登陆" /></td>
    				<td><input type="button" value="注册" onclick="location.href='regist.jsp'"/></td>
    			</tr>
    		</table>
    	</form>
  </body>
</html>
