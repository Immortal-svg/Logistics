<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
<title>汽车资料列表 </title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/invalid.css" type="text/css"
	media="screen" />
</head>
<body>
	<div id="maintitle">
		<div id="mainico"></div>
		<div id="maintip">
			<strong>位置：</strong>汽车资料列表
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
											<p class="left_txt2">
												汽车资料列表&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="red">${delErrror }
											</p>
										</td>
										<td width="20%" align="right">
											<div align="center">
												<img src="${pageContext.request.contextPath}/images/ico_Form.gif" width="14" height="14" />&nbsp;<a
													href='${pageContext.request.contextPath}/car/insCar'>新增</a>&nbsp;&nbsp;&nbsp;&nbsp;
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
				<%--		<tr>
							<td colspan="2"><a
								href="./CarServlet?action=list&currPage=1&opr=first">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;
								<a
								href="./CarServlet?action=list&currPage=${pages.currPage }&opr=prev">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
								<a
								href="./CarServlet?action=list&currPage=${pages.currPage }&opr=next">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
								<a
								href="./CarServlet?action=list&currPage=${pages.pageCount }&opr=last">末页</a>&nbsp;&nbsp;&nbsp;&nbsp;
								第${pages.currPage }页&nbsp;&nbsp;&nbsp;&nbsp; 共${pages.pageCount }页&nbsp;&nbsp;&nbsp;&nbsp;
								共${pages.rowCount }辆车&nbsp;&nbsp;&nbsp;&nbsp;</td>
						</tr>--%>
						<tr>
							<td colspan="2">

								<table align="center" width="800" cellpadding="3"
									cellspacing="1" border="1">
									<tr>
										<td align="center" class="STYLE1" nowrap="nowrap"
											style="BORDER: #c1dad7 1px solid">车牌号</td>
										<td align="center" class="STYLE1" nowrap="nowrap"
											style="BORDER: #c1dad7 1px solid">车主姓名</td>
										<td align="center" class="STYLE1" nowrap="nowrap"
											style="BORDER: #c1dad7 1px solid">型号</td>
										<td align="center" class="STYLE1" nowrap="nowrap"
											style="BORDER: #c1dad7 1px solid">公司名称</td>
										<td align="center" class="STYLE1" nowrap="nowrap"
											style="BORDER: #c1dad7 1px solid">联系人</td>
										<td align="center" class="STYLE1" nowrap="nowrap"
											style="BORDER: #c1dad7 1px solid">联系电话</td>
										<td align="center" class="STYLE1" nowrap="nowrap"
											style="BORDER: #c1dad7 1px solid">QQ号码</td>
										<td align="center" class="STYLE1" nowrap="nowrap"
											style="BORDER: #c1dad7 1px solid">邮箱地址</td>
										<td align="center" class="STYLE1" nowrap="nowrap"
											style="BORDER: #c1dad7 1px solid">所属城市</td>
										<td align="center" class="STYLE1" nowrap="nowrap"
											style="BORDER: #c1dad7 1px solid">车辆状态</td>
										<td align="center" class="STYLE1" nowrap="nowrap"
											style="BORDER: #c1dad7 1px solid">操作</td>
									</tr>
									<c:forEach items="${carPage.getRecords()}" var="car">
										<tr>
											<td class="STYLE1" nowrap="nowrap"
												style="BORDER: #c1dad7 1px solid">${car.cardNo }</td>
											<td class="STYLE1" nowrap="nowrap"
												style="BORDER: #c1dad7 1px solid">${car.carName }</td>
											<td class="STYLE1" nowrap="nowrap"
												style="BORDER: #c1dad7 1px solid">${car.model }</td>
											<td class="STYLE1" nowrap="nowrap"
												style="BORDER: #c1dad7 1px solid">${car.customer.customerName }</td>
											<td class="STYLE1" nowrap="nowrap"
												style="BORDER: #c1dad7 1px solid">${car.contact }</td>
											<td class="STYLE1" nowrap="nowrap"
												style="BORDER: #c1dad7 1px solid">${car.mobile }</td>
											<td class="STYLE1" nowrap="nowrap"
												style="BORDER: #c1dad7 1px solid">${car.qq }</td>
											<td class="STYLE1" nowrap="nowrap"
												style="BORDER: #c1dad7 1px solid">${car.email }</td>
											<td class="STYLE1" nowrap="nowrap"
												style="BORDER: #c1dad7 1px solid">${car.area.areaName }</td>
											<td class="STYLE1" nowrap="nowrap"
												style="BORDER: #c1dad7 1px solid">${car.status }</td>
											<td class="STYLE1" nowrap="nowrap"
												style="BORDER: #c1dad7 1px solid" align="center"><a
												href="${pageContext.request.contextPath}/car/selectCarByid?carID=${car.carID }">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
												<a
												href="${pageContext.request.contextPath}/car/deleCar?carID=${car.carID }"
												onclick="return confirm('删除确认')">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;
											</td>
										</tr>
									</c:forEach>
								</table>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<a href="${pageContext.request.contextPath}/car/selectCarall?thispage=1">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;
								<c:if test="${carPage.hasPrevious()==true}">
								<a href="${pageContext.request.contextPath}/car/selectCarall?thispage=${carPage.getCurrent() <= carPage.getPages()? carPage.getCurrent()-1:carPage.getCurrent()}">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
								</c:if>
								<c:if test="${carPage.hasNext()==true}">
								<a href="${pageContext.request.contextPath}/car/selectCarall?thispage=${carPage.getCurrent() <= carPage.getPages()? carPage.getCurrent()+1:carPage.getCurrent()}">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
								</c:if>
								<a href="${pageContext.request.contextPath}/car/selectCarall?thispage=${carPage.getPages()}">末页</a>&nbsp;&nbsp;&nbsp;&nbsp;
								第${carPage.current }页&nbsp;&nbsp;&nbsp;&nbsp;
								共${carPage.getPages() }页&nbsp;&nbsp;&nbsp;&nbsp;
								共${carPage.total}辆车&nbsp;&nbsp;&nbsp;&nbsp;</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<SCRIPT src="js/transform.js" type=text/javascript></SCRIPT>
</body>
</html>
