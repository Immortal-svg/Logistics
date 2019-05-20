<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1"><title>
	修改密码
</title><meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css" type="text/css" media="screen" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" media="screen" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/invalid.css" type="text/css" media="screen" />
</head>
<body>
     <div id="maintitle"><div id="mainico"></div>
    <div id="maintip"><strong>位置：</strong>修改密码</div></div>
    <div class="content-box role">
	<div class="content-box-content">
	<div class="tab-content default-tab" id="form">
    <div>
    <table style="width:100%;" border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td  style="BORDER-BOTTOM: #c1dad7 1px solid">
            <table style="width:100%;height:55px;" border="0" cellpadding="0" cellspacing="0">
            <tr>
            <td width="10%" height="55" valign="middle"><img src="${pageContext.request.contextPath}/images/user-info.gif" /></td>
            <td width="70%">
                <p class="left_txt2">修改密码</p>
            </td>
            <td width="20%" align="right">
            <div align="center">
            <img src="${pageContext.request.contextPath}/images/ico_Form.gif" width="14" height="14" />&nbsp;<a href='javascript:self.location.reload();' >刷新</a>&nbsp;&nbsp;&nbsp;&nbsp;
            <img src="${pageContext.request.contextPath}/images/002.gif" width="14" height="14" /><A href="javascript:self.history.back();">返回</A></div>
           </td>
            </tr>
            </table>
            </td>
        </tr>
        <tr>
            <td  colspan="2">
<script type="text/javascript">
	function check(){
		if(form1.oldpwd.value=="")
		{
			alert("请输入旧密码");
			form1.oldpwd.focus();
			return false;
		}
		if(form1.oldpwd.value!=form1.old.value)
		{
			alert("你输入的旧密码不正确");
			form1.oldpwd.focus();
			return false;
		}


		if(form1.password.value=="")
		{
			alert("请输入新密码");
			form1.password.focus();
			return false;
		}
		if(form1.password.value!=form1.cfgpwd.value)
		{
			alert("新密码与确认密码不符");
			form1.cfgpwd.focus();
			return false;
		}
		alert("修改成功！")
		return true;
		
	}
</script>
            <form action="${pageContext.request.contextPath}/users/uppass" method="post" name="form1" onsubmit="return check();">
            <table width="70%" border="0" align="left" cellpadding="2" cellspacing="1" >
            <caption>
   		<font color="red" size="2">
   			<%
   				String ret = request.getParameter("ret");
   				if(ret !=null && ret.equals("failed")){
   					out.print("旧密码错误，请确认");
   				}
   				if(ret !=null && ret.equals("succ")){
   					out.print("修改密码成功！");
   				}
   				
   			 %>
   		</font>
   	</caption>
			     	<tr>
   				<td align="right" class="STYLE1"  style="BORDER-BOTTOM: #c1dad7 1px solid">用户名称：</td>
   				<td class="STYLE1"  style="BORDER-BOTTOM: #c1dad7 1px solid">${users.userName }
				<input type="hidden" name="id" value="${users.id}">
				</td>
   			</tr>
   			<tr>
   				<td align="right" class="STYLE1"  style="BORDER-BOTTOM: #c1dad7 1px solid">旧密码：</td>
   				<td class="STYLE1"  style="BORDER-BOTTOM: #c1dad7 1px solid">
					<input type="password" name="oldpwd">
					<input type="hidden" name="old" value="${users.password}">
				</td>
   			</tr>
   			<tr>
   				<td align="right" class="STYLE1"  style="BORDER-BOTTOM: #c1dad7 1px solid">新密码：</td>
   				<td class="STYLE1"  style="BORDER-BOTTOM: #c1dad7 1px solid"><input type="password" name="password"></td>
   			</tr>
   			<tr>
   				<td align="right" class="STYLE1"  style="BORDER-BOTTOM: #c1dad7 1px solid">确认密码：</td>
   				<td class="STYLE1"  style="BORDER-BOTTOM: #c1dad7 1px solid"><input type="password" name="cfgpwd"></td>
   			</tr>
   			<tr>
   				<td colspan="2" align="center"><input type="submit" value="  修改  "></td>
   			</tr>
			</table>
	</form>
            </td>
        </tr>
    </table>
  </div></div></div></div>
    <SCRIPT src="${pageContext.request.contextPath}/js/transform.js" type=text/javascript></SCRIPT>
</body>
</html>
