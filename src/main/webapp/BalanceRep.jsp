<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
<title>客户账目往来明细</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/invalid.css" type="text/css"
	media="screen" />
	<script  src="${pageContext.request.contextPath}/js/jquery-2.1.4.js"></script>
	<script  src="${pageContext.request.contextPath}/laydate/laydate.js"></script>
	<script src="${pageContext.request.contextPath}/layui/layui.all.js"></script>
	<script >
		laydate.render({
			elem: '#paidTime1'
		});

		laydate.render({
			elem: '#paidTime2'
		});


	</script>
</head>
<body>
	<div id="maintitle">
		<div id="mainico"></div>
		<div id="maintip">
			<strong>位置：</strong>客户账目往来明细
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
								<form
									action="${pageContext.request.contextPath}/balance/selBalanceCustDetail"
									method="post" name="form1">
									<table border="0" align="left" cellpadding="2" cellspacing="1">
										<tr>
											<td height="30" class="STYLE1" nowrap="nowrap"
												style="BORDER-BOTTOM: #c1dad7 1px solid"><div
													align="right">客户名称：</div></td>
											<td class="STYLE1" style="BORDER-BOTTOM: #c1dad7 1px solid"><input
												type="text" name="customerName"></td>
											<td height="30" class="STYLE1" nowrap="nowrap"
												style="BORDER-BOTTOM: #c1dad7 1px solid"><div
													align="right">收付款类别：</div></td>
											<td class="STYLE1" style="BORDER-BOTTOM: #c1dad7 1px solid">
												<select name="paidType" style="width: 100px">
													<option value="">-----不选-----</option>
													<option value="收款">收款</option>
													<option value="付款">付款</option>
											</select>
											</td>
											<td height="30" class="STYLE1" nowrap="nowrap"
												style="BORDER-BOTTOM: #c1dad7 1px solid"><div
													align="right">状态：</div></td>
											<td class="STYLE1" style="BORDER-BOTTOM: #c1dad7 1px solid">
												<select name="isvalID" style="width: 100px">
													<option value="" selected>不选</option>
													<option value="有效" >有效单据</option>
													<option value="作废">作废单据</option>
											</select>
											</td>
											<td height="30" class="STYLE1" nowrap="nowrap"
												style="BORDER-BOTTOM: #c1dad7 1px solid"><div
													align="right">付款时间：</div></td>
											<td class="STYLE1" style="BORDER-BOTTOM: #c1dad7 1px solid">
											<%--	<%
													Calendar cal = Calendar.getInstance();//获取当前时间
													int maxday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
													int nyear = cal.get(Calendar.YEAR) - 1900;
													int nmonth = cal.get(Calendar.MONTH);

													String strmin = nyear + "-" + nmonth + "-01";
													String strmax = nyear + "-" + nmonth + "-" + maxday;
													Date date1 = new Date(nyear, nmonth, 1);
													Date date2 = new Date(nyear, nmonth, maxday);
													SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
													strmin = sdf.format(date1);
													strmax = sdf.format(date2);
												%> --%>
												<input type="text" name="paidTime1" id="paidTime1" size="10"
												value="" readonly="readonly" />到 <input type="text" name="paidTime2" id="paidTime2" readonly="readonly"
												size="10" value="" />
											</td>
											<td><input type="submit" value=" 搜 索 "></td>
										</tr>
										<tr>
											<td class="STYLE1" style="BORDER-BOTTOM: #c1dad7 1px solid"
												colspan="9" align="center"><h3>客&nbsp;&nbsp;户&nbsp;&nbsp;收&nbsp;&nbsp;（付）&nbsp;&nbsp;款&nbsp;&nbsp;明&nbsp;&nbsp;细</h3></td>
										</tr>
									</table>
								</form>
							</td>
						</tr>
				<%--		<tr>
							<td colspan="2"><a
								href="./BalanceServlet?action=search&currPage=1&opr=first&customerid=1">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;
								<a
								href="./BalanceServlet?action=search&currPage=${pages.currPage }&opr=prev&customerid=1">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
								<a
								href="./BalanceServlet?action=search&currPage=${pages.currPage }&opr=next&customerid=1">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
								<a
								href="./BalanceServlet?action=search&currPage=${pages.pageCount }&opr=last&customerid=1">末页</a>&nbsp;&nbsp;&nbsp;&nbsp;
								第${pages.currPage }页&nbsp;&nbsp;&nbsp;&nbsp; 共${pages.pageCount }页&nbsp;&nbsp;&nbsp;&nbsp;
								共${pages.rowCount }笔记录&nbsp;&nbsp;&nbsp;&nbsp;</td>
						</tr>--%>
						<tr>
							<td colspan="2">

								<table align="center" width="800" cellpadding="3"
									cellspacing="1" border="1">
									<tr>
										<td align="center" class="STYLE1" nowrap="nowrap"
											style="BORDER: #c1dad7 1px solid">客户名称</td>
										<td align="center" class="STYLE1" nowrap="nowrap"
											style="BORDER: #c1dad7 1px solid">收(付)款类别</td>
										<td align="center" class="STYLE1" nowrap="nowrap"
											style="BORDER: #c1dad7 1px solid">收(付)款金额</td>
										<td align="center" class="STYLE1" nowrap="nowrap"
											style="BORDER: #c1dad7 1px solid">是否有效</td>
										<td align="center" class="STYLE1" nowrap="nowrap"
											style="BORDER: #c1dad7 1px solid">收(付)款时间</td>
										<td align="center" class="STYLE1" nowrap="nowrap"
											style="BORDER: #c1dad7 1px solid">操作用户</td>
										<td align="center" class="STYLE1" nowrap="nowrap"
											style="BORDER: #c1dad7 1px solid">其他说明</td>
									</tr>
									<c:forEach items="${selectfinance.getRecords()}" var="bal">
										<tr>
											<td class="STYLE1" nowrap="nowrap"
												style="BORDER: #c1dad7 1px solid">${bal.customer.customerName }</td>
											<td class="STYLE1" nowrap="nowrap"
												style="BORDER: #c1dad7 1px solid">${bal.paidType }</td>
											<td class="STYLE1" nowrap="nowrap"
												style="BORDER: #c1dad7 1px solid">${bal.faceFee }</td>
											<td class="STYLE1" nowrap="nowrap"
												style="BORDER: #c1dad7 1px solid"><font color="red">${bal.isvalID }</font></td>
											<td class="STYLE1" nowrap="nowrap"
												style="BORDER: #c1dad7 1px solid">
												<fmt:formatDate value="${bal.paidTime }" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
											</td>
											<td class="STYLE1" nowrap="nowrap"
												style="BORDER: #c1dad7 1px solid">${bal.users.userName }</td>
											<td class="STYLE1" nowrap="nowrap"
												style="BORDER: #c1dad7 1px solid">${bal.demo }</td>
										</tr>
									</c:forEach>
								</table>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<a href="${pageContext.request.contextPath}/balance/selBalanceCustDetail?thispage=1">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;
								<c:if test="${selectfinance.hasPrevious()==true}">
									<a href="${pageContext.request.contextPath}/balance/selBalanceCustDetail?thispage=${selectfinance.getCurrent() <= selectfinance.getPages()? selectfinance.getCurrent()-1:userspage.getCurrent()}">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
								</c:if>
								<c:if test="${selectfinance.hasNext()==true}">
									<a href="${pageContext.request.contextPath}/balance/selBalanceCustDetail?thispage=${selectfinance.getCurrent() <= selectfinance.getPages()? selectfinance.getCurrent()+1:userspage.getCurrent()}">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
								</c:if>
								<a href="${pageContext.request.contextPath}/balance/selBalanceCustDetail?thispage=${selectfinance.getPages()}">末页</a>&nbsp;&nbsp;&nbsp;&nbsp;
								第${selectfinance.current }页&nbsp;&nbsp;&nbsp;&nbsp;
								共${selectfinance.getPages() }页&nbsp;&nbsp;&nbsp;&nbsp;
								共${selectfinance.total}笔记录&nbsp;&nbsp;&nbsp;&nbsp;</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<SCRIPT src="js/transform.js" type=text/javascript></SCRIPT>
</body>
</html>
