<%@ page language="java" import="java.util.*,org.zucc.entity.*" pageEncoding="UTF-8"%>
<%

List<Topic> topicList =(List)request.getAttribute("topicList");

%>

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
				<h1>
					添加新闻：
				</h1>
				<form action="news.do" method="post" >
					<input type="hidden" name="flag" value="add" />
					<p>
						<label>
							主题
						</label>
						<select name="topicId">
								<% 
								 for(int i=0;i<topicList.size();i++){
								  Topic topic =topicList.get(i);
								%>
								<option value="<%=topic.getId() %>"><%=topic.getName() %></option>
								<% 
									}
								%>
						</select>
					</p>
					<p>
						<label>
							标题
						</label>
						<input name="title" type="text" />
					</p>
					<p>
						<label>
							作者
						</label>
						<input name="author" type="text" />
					</p>
					<p>
						<label>
							摘要
						</label>
						<input name="summary" type="text" />
					</p>
					<p>
						<label>
							内容
						</label>
						<textarea name="content" cols="70" rows="10"></textarea>
					</p>
					
					<p>
						<label>
							上传图片
						</label>
						<input name="fileName" type="file" />
					</p>
					<input type="submit" value="提交" />
					<input type="reset" value="重置" />
				</form>
			</div>
		</div>
	<%@ include file="jsp/bottom.jsp" %>
	</body>
</html>



