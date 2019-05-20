 <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<
<head id="Head1">
<title>权限设置</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/invalid.css" type="text/css"
	media="screen" />
	<script src="${pageContext.request.contextPath}/js/jquery-2.1.4.js"></script>

</head>
<body >
	<div id="maintitle">
		<div id="mainico"></div>
		<div id="maintip">
			<strong>位置：</strong>权限设置
		</div>
	</div>
	<div class="content-box role">
		<div class="content-box-content">
			<div class="tab-content default-tab" id="form">
				<div>
					<table style="width: 100%;" border="0" cellpadding="0"
						cellspacing="0">

						<tr>
							<td colspan="2">
								<form action="${pageContext.request.contextPath}/accmodule/selAccModule" method="post"
									name="form1">
									<table border="0" align="left" cellpadding="2" cellspacing="1">
										<tr>
											<td height="30" class="STYLE1" nowrap="nowrap"
												style="BORDER-BOTTOM: #c1dad7 1px solid" colspan="3"
												align="right">用户名称：
												<select name="userID" style="width: 100px">
													<c:forEach items="${userList}" var="user">
														<c:if test="${userID==user.id}">
															<option value="${user.id }" selected>${user.userName }</option>
														</c:if>
														<c:if test="${userID !=user.id}">
															<option value="${user.id }">${user.userName }</option>
														</c:if>
													</c:forEach>
											</select> <input type="submit" value="查看权限"></td>
										</tr>

										<script language="javascript">
											function selAll() {
												var len = form2.moduleID.length;
												for (var i = 0; i < len; i++) {
													form2.moduleID[i].checked = true;
												}
											}
											function unselAll() {
												var len = form2.moduleID.length;
												for (var i = 0; i < len; i++) {
													form2.moduleID[i].checked = false;
												}
											}
											function chk1state() {
												if (form2.chk1.checked) {
													selAll();
												} else {
													unselAll();
												}
											}
											//accid
											function UserselAll() {
												var len = form3.accid.length;
												for (var i = 0; i < len; i++) {
													form3.accid[i].checked = true;
												}
											}
											function UserunselAll() {
												var len = form3.accid.length;
												for (var i = 0; i < len; i++) {
													form3.accid[i].checked = false;
												}
											}
											function chk2state() {
												if (form3.chk2.checked) {
													UserselAll();
												} else {
													UserunselAll();
												}
											}
									/*		function exit(){
												if(${exit.size()!=0}){
													 alert("你选择的权限存在！");
												}
											}*/

											 function inset(){
												 var len = form2.moduleID.length;
												 var j=0;
												 for (var i = 0; i < len; i++) {
													if( form2.moduleID[i].checked == false){
														j++;
													}
												 }
												 if(j==form2.moduleID.length){
												 	alert("请选择权限");
												 	return false;
												 }
													 return true;
											 }
											function  dele(){
											 	alert(form3.accid.length);
												var len = form3.accid.length;
												var j=0;
												for (var i = 0; i < len; i++) {
													if(form3.accid[i].checked == false)
													{
														j++;
													}
												}
												if (j==form3.accid.length){
													alert("请选择权限");
													return false;
												}
												return true;
											}
										$(function(){

											$("#userID").change(function(){
													var id=$(this).val();
												window.location.href = "${pageContext.request.contextPath}/accmodule/selAccModule?userID="+id;
											});
											$("#userID1").change(function(){
												var id=$(this).val();
												window.location.href = "${pageContext.request.contextPath}/accmodule/selAccModule?userID="+id;
											});

										});
										</script>

									</table>
								</form>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<form action="${pageContext.request.contextPath}/accmodule/insAccModule" method="post"
									name="form2"  onsubmit=" return inset()">

									<table align="center" width="800" cellpadding="3"
										cellspacing="1" border="1">
										<tr>
											<td class="STYLE1" style="BORDER-BOTTOM: #c1dad7 1px solid"
												colspan="5">
												<h3>系&nbsp;&nbsp;统&nbsp;&nbsp;权&nbsp;&nbsp;限</h3>
											</td>
											<td class="STYLE1" style="BORDER-BOTTOM: #c1dad7 1px solid"
												align="right"><input type="checkbox" name="chk1"
												value="全选" onclick="chk1state();" />全选 用户名称： <select
											 id="userID1"	name="userID" style="width: 100px">
													<c:forEach items="${userList}" var="user">
														<c:if test="${userID==user.id}">
															<option value="${user.id }" selected>${user.userName }</option>
														</c:if>
														<c:if test="${userID!=user.id}">
															<option value="${user.id }">${user.userName }</option>
														</c:if>
													</c:forEach>
											</select> <input type="submit" value="授于权限" ></td>
										</tr>
										<c:forEach items="${Modules}" var="module" varStatus="m">
											<c:if test="${m.index % 6==0}">
												<tr>
											</c:if>
											<td class="STYLE1" nowrap="nowrap"
												style="BORDER: #c1dad7 1px solid">
												<input type="checkbox" name="moduleID" value="${module.moduleID}" />${module.moduleName}
											</td>
											<c:if test="${m.index % 6==5}">
												</tr>
											</c:if>
										</c:forEach>
									</table>
								</form>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<form action="${pageContext.request.contextPath}/accmodule/delAccModule" method="post"
									name="form3" onsubmit="return dele()">
									<script type="javascript">

									</script>
									<table align="center" width="800" cellpadding="3"
										cellspacing="1" border="1">
										<tr>
											<td class="STYLE1" style="BORDER-BOTTOM: #c1dad7 1px solid"
												colspan="5">
												<h3>当&nbsp;&nbsp;前&nbsp;&nbsp;用&nbsp;&nbsp;户&nbsp;&nbsp;权&nbsp;&nbsp;限</h3>
											</td>
											<td class="STYLE1" style="BORDER-BOTTOM: #c1dad7 1px solid"
												align="right"><input type="checkbox" name="chk2"
												value="全选" onclick="chk2state();" />全选 用户名称： <select
												 id="userID"  name="userID" style="width: 100px">
													<c:forEach items="${userList}" var="user">
														<c:if test="${userID==user.id}">
															<option value="${user.id }" selected>${user.userName }</option>
														</c:if>
														<c:if test="${userID != user.id}">
															<option value="${user.id }">${user.userName }</option>
														</c:if>
													</c:forEach>
											</select> <input type="submit" value="删除权限"></td>
										</tr>

										<c:forEach items="${usermod}" var="module" varStatus="m">
											<c:if test="${m.index % 6==0}">
												<tr>
											</c:if>
											<td class="STYLE1" nowrap="nowrap"
												style="BORDER: #c1dad7 1px solid"><input
												type="checkbox" name="accid" value="${module.module.moduleID}" />${module.module.moduleName}
											</td>
											<c:if test="${m.index % 6==5}">
												</tr>
											</c:if>
										</c:forEach>
									</table>
								</form>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<SCRIPT src="${pageContext.request.contextPath}/js/transform.js" type=text/javascript></SCRIPT>
</body>
</html>
