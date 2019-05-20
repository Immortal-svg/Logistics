<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
<title>区域设置</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/invalid.css" type="text/css"
	media="screen" />

	<script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.4.js"></script>
</head>
<body>
	<div id="maintitle">
		<div id="mainico"></div>
		<div id="maintip">
			<strong>位置：</strong>区域设置
		</div>
	</div>
	<div class="content-box role">
		<div class="content-box-content">
			<div class="tab-content default-tab" id="form">
				<div>
					<table style="width: 100%;" border="0" cellpadding="0"
						cellspacing="0">
						<tr>
							<td style="BORDER-BOTTOM: #c1dad7 1px solid">
								<table style="width: 100%; height: 55px;" border="0"
									cellpadding="0" cellspacing="0">
									<tr>
										<td width="10%" height="55" valign="middle"><img
											src="${pageContext.request.contextPath}/images/user-info.gif" /></td>
										<td width="70%">
											<p class="left_txt2">区域设置</p>
										</td>
										<td width="20%" align="right">
											<div align="center">
												<img src="${pageContext.request.contextPath}/images/ico_Form.gif" width="14" height="14" />&nbsp;<a
													href='javascript:self.location.reload();'>刷新</a>&nbsp;&nbsp;&nbsp;&nbsp;
												<img src="${pageContext.request.contextPath}/images/002.gif" width="14" height="14" /><A
													href="javascript:self.history.back();">返回</A>
											</div>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<script language="javascript">
									var i="1";
									$(function(){
										$("#areaName").blur(function () {
											var name=$(this).val();
											$.ajax({
												type:"post",
												url:"${pageContext.request.contextPath}/area/isAreaEixt",
												dataType:"json",
												data:{"areaName":name},
												success:function (data) {

													if(data.areaName!=null){
														i="1";
														$("#p").html("<font color='red'>已存在</font>");
													}else{
														i="0";
														$("#p").html("<font color='green'>可以使用</font>");
													}
												}
											});

										})
									});
								function check() {
									if (form1.areaName.value == "") {
										alert("请输入区域名称");
										form1.areaName.focus();
										return false;
									}
									if(i=="1"){
										alert("你输入的区域名已存在");
										form1.areaName.focus();
										return false;
									}
									return true;
								}
							</script>
								<form action="${pageContext.request.contextPath}/area/insArea"
									method="post" name="form1" onsubmit="return check();">
									<table width="70%" border="0" align="left" cellpadding="2"
										cellspacing="1">
										<tr>
											<td width="130" height="30" class="STYLE1" nowrap="nowrap"
												style="BORDER-BOTTOM: #c1dad7 1px solid"><div
													align="right">区域名称：</div></td>
											<td class="STYLE1" style="BORDER-BOTTOM: #c1dad7 1px solid"><input
												type="text" name="areaName" id="areaName"><span id="p"></span></td>
										</tr>
										<tr>
											<td width="130" height="30" class="STYLE1" nowrap="nowrap"
												style="BORDER-BOTTOM: #c1dad7 1px solid"><div
													align="right">&nbsp;</div></td>
											<td class="STYLE1" style="BORDER-BOTTOM: #c1dad7 1px solid"><input
												type="submit" value=" 保 存 "></td>
										</tr>
									</table>
								</form></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<SCRIPT src="js/transform.js" type=text/javascript></SCRIPT>
</body>
</html>
