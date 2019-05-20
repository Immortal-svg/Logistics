<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1"><title>
	修改客户资料
</title><meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css" type="text/css" media="screen" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" media="screen" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/invalid.css" type="text/css" media="screen" />
</head>
<body>
     <div id="maintitle"><div id="mainico"></div>
    <div id="maintip"><strong>位置：</strong>修改客户资料</div></div>
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
                <p class="left_txt2">修改客户资料</p>
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
			if(form1.customerName.value==""){
				alert("请输入客名称");
				form1.customerName.focus();
				return false;
			}
			if(form1.faceMoney.value==""){
				alert("应收账款不能为空");
				form1.faceMoney.focus();
				return false;
			}
			if(isNaN(form1.faceMoney.value)){
				alert("应收账款含有非法字符");
				form1.faceMoney.focus();
				return false;
			}
			if(form1.paidMoney.value==""){
				alert("应付账款不能为空");
				form1.paidMoney.focus();
				return false;
			}
			if(isNaN(form1.paidMoney.value)){
				alert("应付账款含有非法字符");
				form1.paidMoney.focus();
				return false;
			}
			
			return true;
		}
	</script>
			
			
	<form action="${pageContext.request.contextPath}/customer/updCust" method="post" name="form1" onsubmit="return check();">
    	<input type ="hidden" name="customerID" value="${cust.customerID}"/>
    	<table align="center" border="1" cellpadding="2" cellspacing="1">
    		<tr>
    			<td align="right">客户名称：</td>
    			<td><input type="text" name="customerName"  value="${cust.customerName }"></td>
    			<td><font size="2" color="red">*公司名称，必填</font></td>
    		</tr>
    		<tr>
    			<td align="right">联系人：</td>
    			<td><input type="text" name="contactName"  value="${cust.contactName }"></td>
    			<td><font size="2" color="red">*必填</font></td>
    		</tr>
    		<tr>
    			<td align="right">联系电话：</td>
    			<td><input type="text" name="phone"  value="${cust.phone }"></td>
    			<td><font size="2" color="red">*必填</font></td>
    		</tr>
    		<tr>
    			<td align="right">客户类型：</td>
    			<td>
						<select name="customerTypeID" style="width:155px">
						<c:forEach items="${custtypes}" var="custtype">
							<c:if test="${cust.customerTypeID==custtype.customerTypeID }">
								<option value="${custtype.customerTypeID }" selected>${custtype.customerTypeName }</option>
							</c:if>
							<c:if test="${cust.customerTypeID != custtype.customerTypeID }">
								<option value="${custtype.customerTypeID }">${custtype.customerTypeName }</option>
							</c:if>
						</c:forEach>							

						</select>
				</td>
    			<td><font size="2" color="red">*必填</font></td>
    		</tr>
    		<tr>
    			<td align="right">结算方式：</td>
    			<td>
						<select name="paidID" style="width:155px">
						<c:forEach items="${paidtypes}" var="paidtype">
						<c:if test="${cust.paidID==paidtype.paidID }">
							<option value="${paidtype.paidID }" selected>${paidtype.paidName }</option>
						</c:if>
						<c:if test="${cust.paidID != paidtype.paidID }">
							<option value="${paidtype.paidID }">${paidtype.paidName }</option>
						</c:if>
						</c:forEach>							
						</select>
				</td>
    			<td><font size="2" color="red">*必填</font></td>
    		</tr>
    		<tr>
    			<td align="right">用户区域：</td>
    			<td>
						<select name="areaID" style="width:155px">
						<c:forEach items="${areas}" var="area">
						<c:if test="${cust.areaID==area.areaID }">
							<option value="${area.areaID }" selected>${area.areaName }</option>
						</c:if>
						<c:if test="${cust.areaID != area.areaID }">
							<option value="${area.areaID }">${area.areaName }</option>
						</c:if>
						</c:forEach>							
						</select>
				</td>
    			<td><font size="2" color="red">*必填</font></td>
    		</tr>
    		<tr>
    			<td align="right">应收账款：</td>
    			<td><input type="text" name="factMoney"  value="${cust.factMoney}" disabled="disabled"></td>
    			<td><font size="2" color="red">&nbsp;</font></td>
    		</tr>
    		<tr>
    			<td align="right">应付账款：</td>
    			<td><input type="text" name="paidMoney"  value="${cust.paidMoney }" disabled="disabled"></td>
    			<td><font size="2" color="red">&nbsp;</font></td>
    		</tr>
    		<tr>
    			<td align="right">通讯地址：</td>
    			<td><input type="text" name="addr"  value="${cust.addr }"></td>
    			<td><font size="2" color="red">&nbsp;</font></td>
    		</tr>
    		<tr>
    			<td colspan="3" align="center"><input type="submit" value="  保 存 "></td>
    		</tr>
    	</table>
    </form>
            </td>
        </tr>
    </table>
  </div></div></div></div>
    <SCRIPT src="js/transform.js" type=text/javascript></SCRIPT>
</body>
</html>
