<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>注册</title>

		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function formCheck()
		{
			if(!checkName())
			{
				alert("用户名输入不正确");
				document.getElementById("name").focus();
				return false;
			}

			if(!checkPassword())
			{
				alert("密码格式不正确");
				document.getElementById("checkPassword").focus();
				return false;
			}

			if(!checkEmail())
			{
				alert("邮箱格式不正确");
				document.getElementById("email").focus();
				return false;
			}

			var pw1 = document.getElementById("password1");
			var pw2 = document.getElementById("password2");
			if(pw1.value != pw2.value)
			{
				alert("两次密码输入不一致");
				pw1.value = "";
				pw2.value = "";
				pw1.focus();
				return false;
			}
			return true;
		}

	
		function checkName()
		{
			var name = document.getElementById("name").value;
			var check = /^\w+$/;
			if(name.length < 4 || name.length > 16 || !check.test(name))
			{
				document.getElementById("checkName").style.display = "";
				return false;
			}
			document.getElementById("checkName").style.display = "none";
			return true;
		}

		function checkPassword()
		{
			var password = document.getElementById("password1").value;
			if(password.length < 6 || password.length > 12)
			{
				document.getElementById("checkPassword").style.display = "";
				return false;
			}
			document.getElementById("checkPassword").style.display = "none";
			return true;
		}

		function checkEmail()
		{
			var email = document.getElementById("email").value;
			var check = /^\w+@\w+\.(com|cn)$/;
			if(!check.test(email))
			{
				document.getElementById("checkEmail").style.display = "";
				return false;
			}
			document.getElementById("checkEmail").style.display = "none";
			return true;
		}
		
	</script>
	</head>

	<body>
		<form action="regist.do" method="post" >
		  <input type="hidden" name="flag" value="regist"/>
			<table>
				<tr>
					<td>用户名：</td>
					<td><input type="text" value="" id="name" name="name" onblur="checkName()" /></td>
					<td><span style="display:none" id="checkName">只能输入字母或数字，4~16个字符</span></td>
				</tr>
				<tr>
					<td>密	码：</td>
					<td><input type="password" value="" name="password" id="password1" onblur="checkPassword()" /></td>
					<td><span style="display:none" id="checkPassword">密码长度6~12位</span></td>
				</tr>
				<tr>
					<td>确认密码：</td>
					<td><input type="password" value="" id="password2" /></td>
					<td></td>
				</tr>
				<tr>
					<td>性别：</td>
					<td><input type="radio" value="1" name="sex" />男<input type="radio" value="0" name="sex" />女</td>
					<td></td>
				</tr>
				<tr>
					<td>电子邮件</td>
					<td><input type="text" value="" id="email" name="email" onblur="checkEmail()" /></td>
					<td><span style="display:none" id="checkEmail">输入正确的Email地址</span></td>
				</tr>
				<tr>
					<td>兴趣爱好</td>
					<td>
						<input type="checkbox" name="hobby" value="体育" />体育
						<input type="checkbox" name="hobby" value="读书" />读书
						<input type="checkbox" name="hobby" value="音乐" />音乐
						<input type="checkbox" name="hobby" value="旅游" />旅游
					</td>
					<td></td>
				</tr>
				<tr>
					<td colspan="3"><input type="submit" value="同意一下协议条款并提交" /></td>
				</tr>
				
				<tr>
					<td colspan="3"><textarea disabled="disabled">1. 特别提示

1.1
北京微梦创科网络技术有限公司、微梦创科网络科技（中国）有限公司及相关关联企业（以下合称"微梦公司"）同意按照本协议的规定及其不时发布的操作规则提供基于互联网以及移动网的新浪网微博客服务（以下称"微博服务"），为获得微博服务，微博服务使用人（以下称"用户"）应当基于了解本协议全部内容，在独立思考的基础上认可、同意本协议的全部条款并按照页面上的提示完成全部的注册程序。用户在进行注册程序过程中点击"同意" 按钮即表示用户完全接受《新浪网络服务使用协议》、《微博服务使用协议》、《微博社区公约（试行）》及微梦公司公示的各项规则、规范。

1.2
用户注册成功后，微梦公司将为用户基于微博服务使用的客观需要而在申请、注册微博服务时，按照注册要求提供的帐号开通微博服务，用户有权在微梦公司为其开通、并同意向其提供服务的基础上使用微博服务。该用户帐号和密码由用户负责保管；用户使用微博服务过程中，须对自身使用微博服务的行为，对任何由用户通过微博服务服务发布、公开的信息，及对由此产生的任何后果承担全部责任。用户提交、发布或显示的信息将对其他微博服务用户及第三方服务及网站可见(用户可通过设置功能自行控制、把握可查阅其信息的帐号类型)。

1.3
为提高用户的微博服务使用感受和满意度，用户同意微梦公司将基于用户的操作行为对用户数据进行调查研究和分析，从而进一步优化微博服务。
2. 服务内容

2.1
微博服务的具体内容由微梦公司根据实际情况提供，包括但不限于授权用户通过其帐号，使用微博服务发布观点、评论、图片、视频、转发链接等，微梦公司有权对其提供的服务或产品形态进行升级或其他调整，并将及时更新页面/告知用户。

2.2
微梦公司提供的部分网络服务为收费的网络服务，用户使用收费网络服务需要向微梦公司支付一定的费用。对于收费的网络服务，微梦公司会在用户使用之前给予用户明确的提示，只有用户根据提示确认其愿意支付相关费用，用户才能使用该等收费网络服务。如用户拒绝支付相关费用，则微梦公司有权不向用户提供该等收费网络服务。

2.3
用户理解，微梦公司仅提供与微博服务相关的技术服务等，除此之外与相关网络服务有关的设备（如个人电脑、手机、及其他与接入互联网或移动网有关的装置）及所需的费用（如为接入互联网而支付的电话费及上网费、为使用移动网而支付的手机费）均应由用户自行负担。</textarea></td>
				</tr>
			</table>
		</form>
	</body>
</html>
