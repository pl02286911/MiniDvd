<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>添加主题--管理后台</title>
<link href="css/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%@ include file="jsp/top.jsp" %>
<div id="main">
<%@ include file="jsp/left.jsp" %>
  <div id="opt_area">
   		<h1>添加主题</h1>
   		<form action="addtopic.do" method="post">
   			<p><label>主题名称：</label><input type="text" value="" name="name" /></p>
   			<input type="submit" value="提交" /><input type="reset" value="重置" /> 
      	</form>
  </div>
</div>
<%@ include file="jsp/bottom.jsp" %>
</body>
</html>



