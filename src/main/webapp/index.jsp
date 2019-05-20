<%@ page language="java" import="java.util.List" pageEncoding="utf-8"%>
<%@page import="java.net.URLDecoder"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" >

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>系统登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.4.js"></script>
<link media="screen" href="${pageContext.request.contextPath}/css/login.css" type="text/css"
	rel="stylesheet" />
<script language="javascript">

	function check() {

		if (form1.userName.value == "") {
			alert("请输入用户名");
			form1.userName.focus();
			return false;
		}
		if (form1.password.value == "") {
			alert("请输入密码");
			form1.password.focus();
			return false;
		}

		if (form1.yzm.value == "") {
			alert("请输入验证码");
			form1.yzm.focus();
			return false;
		}

		return true;
	}
</script>
</head>
<BODY class=bg>
<script type="application/javascript">
	$(function(){
        $("#randImage").click(function () {
            $(this).load("<%=path%>/enimg.jsp");
            $(this).attr("src","<%=path%>/enimg.jsp");
        })
    })



</script>
	<%
		String userName = "", password = "";
		Cookie[] cookies = request.getCookies();
		/*System.out.println("cookies ="+cookies.length);*/
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				System.out.println(cookies[i].getName());
				System.out.println(cookies[i].getValue());
				System.out.println(cookies[i].getMaxAge());
				if (cookies[i].getName().equals("userName")) {
					//读取有中文的cookie
					userName = URLDecoder.decode(cookies[i].getValue(), "utf-8");
				}
				if (cookies[i].getName().equals("password")) {
					password = cookies[i].getValue();
				}
			}
		}
		if (userName == null)
			userName = "";
		if (password == null)
			password = "";
	%>
	<form name="form1" method="post" action="${pageContext.request.contextPath}/users/login.action"
		id="form1" onsubmit="return check();">
		<DIV class=loginmian></DIV>
		<DIV style="MARGIN: -55px auto 0px; WIDTH: 1024px; HEIGHT: 231px">
			<DIV></DIV>
			<DIV class=logininner>
				<DIV id=logintip>
					<%
						String log =(String)request.getAttribute("islogin");

						if (log != null && log.equals("failed")) {
							out.print("用户名或密码错误，请重新登录.");
						}
						if (log != null && log.equals("dis")) {
							out.print("用户名已禁止登录.");
						}
						if (log != null && log.equals("expire")) {
							out.print("系统已过期，QQ：21257638");
						}
						if(log != null && log.equals("yzm")){
							out.print("请输入正确的验证码");
						}
					%>
				</DIV>
				<DIV class=login>
					<DIV style="LINE-HEIGHT: 35px; HEIGHT: 35px">
						<LABEL>用户名</LABEL> <input name="userName" type="text" maxlength="25"
							id="userName" class="text-input" style="height: 18px;"
							value="<%=userName%>" />
					</DIV>
					<DIV style="LINE-HEIGHT: 35px; HEIGHT: 35px">
						<LABEL>密 码</LABEL> <input name="password" type="password"
							maxlength="25" id="password" class="text-input"
							style="height: 18px;" value="<%=password%>" />
					</DIV>
					<DIV style="LINE-HEIGHT: 35px; HEIGHT: 35px">
						<LABEL>验证码</LABEL> <input name="yzm" type="text" maxlength="4"
							id="yzm" class="text-input text_auth" style="height: 18px;" />&nbsp;
						<span style="color: Red; font-size: 14px; HEIGHT: 35px;"><span
							id="code"> <img name="randImage" id="randImage"
								src="${pageContext.request.contextPath}/enimg.jsp" width="60" height="25" border="1"
								align="absmiddle" />
						</span></span> &nbsp;&nbsp;<span style="display: none"> <input name="yz"
							type="text" id="yz" />
						</span>
					</DIV>
					<DIV style="LINE-HEIGHT: 30px; HEIGHT: 30px">
						<LABEL>&nbsp;</LABEL> <input type="submit" name="dl" value="登录系统"
							onclick="return sub();" id="dl" class="buttonsubmit" /> <input
						    checked="checked" type="checkbox" name="remember" value="1"  />记住密码
					</DIV>
				</DIV>
			</DIV>
			<div style="width: 100%; text-align: center;">版权所有&copy;
				2019-2022&nbsp;&nbsp;&nbsp;&nbsp; 联系电话: 13576051848
				&nbsp;&nbsp;&nbsp;&nbsp; 中国 江西 南昌</div>
		</DIV>
	</form>
</BODY>
</html>
