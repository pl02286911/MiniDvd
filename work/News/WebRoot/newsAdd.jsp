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
		<div id="header">
	  <div id="welcome">e欢迎使用新闻管理系统！</div>
	  <div id="nav">
	    <div id="logo"><img src="images/logo.jpg" alt="新闻中国" /></div>
	    <div id="a_b01"><img src="images/a_b01.gif" alt="" /></div>
	 	 </div>
		</div>
		<div id="main">
		
			<div id="opt_area">
				<h1>
					添加新闻：
				</h1>
				<form action="addnews.do" method="post" enctype="multipart/form-data">
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
		<div id="site_link"> <a href="#">关于我们</a><span>|</span> <a href="#">Aboue Us</a><span>|</span> <a href="#">联系我们</a><span>|</span> <a href="#">广告服务</a><span>|</span> <a href="#">供稿服务</a><span>|</span> <a href="#">法律声明</a><span>|</span> <a href="#">招聘信息</a><span>|</span> <a href="#">网站地图</a><span>|</span> <a href="#">留言反馈</a> </div>
<div id="footer">
  <p class="">24小时客户服务热线：010-68988888  &#160;&#160;&#160;&#160; <a href="#">常见问题解答</a> &#160;&#160;&#160;&#160;  新闻热线：010-627488888<br />
    文明办网文明上网举报电话：010-627488888  &#160;&#160;&#160;&#160;  举报邮箱：<a href="#">jubao@163.com.cn</a></p>
  <p class="copyright">Copyright &copy; 1999-2009 News China gov, All Right Reserver<br />
    新闻中国   版权所有</p>
</div>
	</body>
</html>



