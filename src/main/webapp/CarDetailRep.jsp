<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
<title>订单查询</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/invalid.css" type="text/css"
	media="screen" />

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/js/jquery-easyui-1.3.0/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/js/jquery-easyui-1.3.0/themes/icon.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-easyui-1.3.0/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-easyui-1.3.0/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/DateFormat.js"></script>

</head>
<body>
	<div id="maintitle">
		<div id="mainico"></div>
		<div id="maintip">
			<strong>位置：</strong>订单查询
		</div>
	</div>
	<div class="content-box role">
		<div class="content-box-content">
			<div class="tab-content default-tab" id="form">
				<div>
					<table style="width: 100%;" border="0" cellpadding="0"
						cellspacing="0">
						<tr>
							<td style="BORDER: #c1dad7 1px solid">
								<table style="width: 100%; height: 55px;" border="0"
									cellpadding="0" cellspacing="0">
									<tr>
										<td width="10%" height="55" valign="middle"><img
											src="${pageContext.request.contextPath}/images/user-info.gif" /></td>
										<td width="70%">
											<p class="left_txt2">订单查询===请选择查询条件</p>
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
								<form
									action="${pageContext.request.contextPath}/cardetail/selCarDetailOrderall"
									method="post" name="form1">
									<table align="center" border="1" cellpadding="2"
										cellspacing="1">
										<tr>
											<td align="right">订单号：</td>
											<td><input type="text" name="detailID" size="49"></td>
											<td align="right">订单状态：</td>
											<td><select name="orderID" style="width: 330px">
													 <option value="">不选择</option>
													<option value="已到站"  >已到站</option>
												   <option value="未发车"  >未发车</option>
												<option value="已发车"  >已发车</option>
											</select></td>
										</tr>
										<tr>
											<td align="right">运输车辆：</td>
											<td colspan="3"><select name="transID"
												style="width: 890px">
													<option value="">------------------------------不选择------------------------------------</option>
													<c:forEach items="${transCars}" var="car">
														<option value="${car.transID }">${car.car.cardNo }，
															<fmt:formatDate value="${car.sendTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
																<%--<fmt:formatDate value="${car.sendTime }" pattern="yyyy-MM-dd HH:mm:ss"/>--%>==${car.areasendName.areaName }--->${car.arereceCity.areaName }</option>
													</c:forEach>
											</select></td>
										</tr>
										<tr>
											<td align="right">发货单位：</td>
											<td><select name="sendCustID" style="width: 330px">
													<option value="">------------------------------不选择------------------------------------</option>
													<c:forEach items="${custs}" var="custs">
														<option value="${custs.customerID }">${custs.customerName }|${custs.contactName }|${custs.phone }</option>
													</c:forEach>
											</select></td>
											<td align="right">发货城市：</td>
											<td><select name="sendCity" style="width: 330px">
													<option value="">------------------------------不选择------------------------------------</option>
													<c:forEach items="${areas}" var="area">
														<option value="${area.areaID }">${area.areaName }</option>
													</c:forEach>
											</select></td>
										</tr>
										<tr>
											<td align="right">收货单位：</td>
											<td><select name="receCustID" style="width: 330px">
													<option value="">------------------------------不选择------------------------------------</option>
													<c:forEach items="${custs}" var="custs">
														<option value="${custs.customerID }">${custs.customerName }|${custs.contactName }|${custs.phone }</option>
													</c:forEach>
											</select></td>
											<td align="right">收货城市：</td>
											<td><select name="receCity" style="width: 330px">
													<option value="">------------------------------不选择------------------------------------</option>
													<c:forEach items="${areas}" var="area">
														<option value="${area.areaID }">${area.areaName }</option>
													</c:forEach>
											</select></td>
										</tr>
										<tr>
											<td colspan="6" align="center"><input type="submit"
												value="  查询 "></td>
										</tr>
									</table>
								</form>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<SCRIPT src="js/transform.js" type=text/javascript></SCRIPT>
</body>
</html>
