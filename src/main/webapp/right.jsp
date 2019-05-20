<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
<title>管理中心</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<LINK media=screen href="${pageContext.request.contextPath}/css/index.css" type=text/css rel=stylesheet>
	<SCRIPT src="${pageContext.request.contextPath}/js/jquery-1.7.2.js" type=text/javascript></SCRIPT>

	<STYLE>
.kjmenu {
	BORDER-RIGHT: #c0dcf2 1px solid;
	PADDING-RIGHT: 0px;
	BORDER-TOP: #c0dcf2 1px solid;
	PADDING-LEFT: 11%;
	PADDING-BOTTOM: 9px;
	MARGIN: 0px 5px 2px 0px;
	BORDER-LEFT: #c0dcf2 1px solid;
	PADDING-TOP: 9px;
	BORDER-BOTTOM: #c0dcf2 1px solid;
	HEIGHT: 353px ! important
}

.newtitle {
	BORDER-RIGHT: #c0dcf2 1px solid;
	PADDING-RIGHT: 0px;
	BORDER-TOP: #c0dcf2 1px solid;
	PADDING-LEFT: 15px;
	FONT-SIZE: 14px;
	BACKGROUND: url(${pageContext.request.contextPath}/pics/maintitle.jpg);
	PADDING-BOTTOM: 4px;
	MARGIN: 0px 5px 2px 0px;
	BORDER-LEFT: #c0dcf2 1px solid;
	LINE-HEIGHT: 20px;
	PADDING-TOP: 4px;
	BORDER-BOTTOM: #c0dcf2 1px solid;
	HEIGHT: 20px ! important
}

.newborder {
	BORDER-RIGHT: #c0dcf2 1px solid;
	PADDING-RIGHT: 0px;
	BORDER-TOP: #c0dcf2 1px solid;
	PADDING-LEFT: 9px;
	PADDING-BOTTOM: 9px;
	MARGIN: 0px 5px 2px 0px;
	BORDER-LEFT: #c0dcf2 1px solid;
	PADDING-TOP: 9px;
	BORDER-BOTTOM: #c0dcf2 1px solid;
	HEIGHT: 353px ! important
}

#tishi_ P {
	PADDING-RIGHT: 0px;
	MARGIN-TOP: 0px;
	PADDING-LEFT: 0px;
	MARGIN-BOTTOM: 0px;
	PADDING-BOTTOM: 0px;
	LINE-HEIGHT: 28px;
	PADDING-TOP: 0px
}

.newborder P {
	PADDING-RIGHT: 0px;
	MARGIN-TOP: 0px;
	PADDING-LEFT: 0px;
	MARGIN-BOTTOM: 0px;
	PADDING-BOTTOM: 0px;
	LINE-HEIGHT: 28px;
	PADDING-TOP: 0px
}
</STYLE>
	<SCRIPT language=javascript type=text/javascript>
		$(function() {
			$(".t").click(function() {
				$(".c").hide();
				$(this).next(".c").show();
			});
		});
	</SCRIPT>

	<STYLE type=text/css>
.DivNotice {
	MARGIN: 5px;
	BORDER-BOTTOM: #ddd 1px dotted
}

.DivNotice .t {
	CURSOR: pointer;
	COLOR: #395a7b
}

.DivNotice .c {
	PADDING-RIGHT: 10px;
	DISPLAY: none;
	PADDING-LEFT: 10px;
	PADDING-BOTTOM: 5px;
	PADDING-TOP: 5px
}
</STYLE>
</head>
<BODY style="MARGIN: 0px; BACKGROUND-COLOR: #ffffff">

	<form name="form1" method="post" action="right.aspx" id="form1">
		<div>
			<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE"
				value="/wEPDwUKMjA1MjgyNTk2N2RkTUlr0dwXEnXR7Hm6dhwPYB29qJc=" />
		</div>


		<DIV id=maintitle>
			<DIV id=mainico></DIV>
			<DIV id=maintip>
				<STRONG>位置：</STRONG>首页
			</DIV>
		</DIV>
		<DIV id=tishi_
			style="FONT-SIZE: 13px; BACKGROUND: #ffe38e; MARGIN: 10px auto 0px; WIDTH: 97%; COLOR: #359a30; TEXT-INDENT: 20px; LINE-HEIGHT: 28px; HEIGHT: 28px">
			<P style="FLOAT: left; WIDTH: 94%">
				<%
					if (request.getAttribute("noAccnoAcc") != null) {
				%>
				<font color="red">对不起，您没有使用该功能的权限，请与系统管理员联系</font>
				<%
					} else {
				%>
				很感谢您一直支持我们，为了让您得到更好的服务，希望您能提出宝贵的意见或建议，我们将为您打造一个功能齐全的平台！联系电话：13576051848
				&nbsp; 客服QQ:21257638
				<%
					}
				%>
			</P>
			<IMG style="CURSOR: pointer"
				onclick="document.getElementById('tishi_').style.display='none';"
				src="${pageContext.request.contextPath}/images/close.png"></SPAN>
		</DIV>
		<DIV style="MARGIN: 10px auto 0px; WIDTH: 97%">
			<TABLE style="FLOAT: left" cellSpacing=0 cellPadding=0 width="100%"
				border=0>
				<TBODY>
					<TR>
						<TD vAlign=top width="60%">
							<DIV class=newtitle>
								&nbsp;&nbsp;<B>快捷菜单</B>
							</DIV>
							<DIV class=kjmenu>
								<TABLE cellSpacing=0 cellPadding=0 width="100%">
									<TBODY>
										<TR>
											<TD vAlign=center align=left width="50%" height=70>
												<TABLE cellSpacing=0 cellPadding=0 width=160>
													<TBODY>
														<TR>
															<TD width=35 height=40><IMG height=31 alt=订单管理
																src="${pageContext.request.contextPath}/images/01.gif" width=31></TD>
															<TD vAlign=center width=85><A
																href="./CarDetailServlet?action=list&currPage=1&opr=first">订单管理</A></TD>
														</TR>
														<TR>
															<TD align=left colSpan=2 height=30>添加更新订单资料</TD>
														</TR>
													</TBODY>
												</TABLE>
											</TD>
											<TD vAlign=center align=left width="50%" height=70>
												<TABLE cellSpacing=0 cellPadding=0 width=160>
													<TBODY>
														<TR>
															<TD width=35><IMG height=32 alt=运输管理
																src="${pageContext.request.contextPath}/images/20.gif" width=32></TD>
															<TD vAlign=center align=left width=85><A
																href="./TransCarServlet?action=list&currPage=1&opr=first">运输管理</A></TD>
														</TR>
														<TR>
															<TD align=left colSpan=2 height=30>添加修改运输管理</TD>
														</TR>
													</TBODY>
												</TABLE>
											</TD>
										</TR>
										<TR>
											<TD vAlign=center height=70>
												<TABLE cellSpacing=0 cellPadding=0 width=160>
													<TBODY>
														<TR>
															<TD width=35 height=40><IMG height=30 alt=客户管理
																src="${pageContext.request.contextPath}/images/08.gif" width=30></TD>
															<TD vAlign=center width=85><A
																href="./CustomerServlet?action=list&currPage=1&opr=first">客户管理</A></TD>
														</TR>
														<TR>
															<TD align=left colSpan=2 height=30>新增修改客户资料</TD>
														</TR>
													</TBODY>
												</TABLE>
											</TD>
											<TD vAlign=center align=left width="50%" height=70>
												<TABLE cellSpacing=0 cellPadding=0 width=160>
													<TBODY>
														<TR>
															<TD width=35><IMG height=32 alt=添加用户
																src="${pageContext.request.contextPath}/images/04.gif" width=32></TD>
															<TD vAlign=center width=85><A
																href="./UserServlet?action=list&currPage=1&opr=first">添加用户</A></TD>
														</TR>
														<TR>
															<TD align=left colSpan=2 height=30>添加登录账号</TD>
														</TR>
													</TBODY>
												</TABLE>
											</TD>
										</TR>
										<TR>
											<TD vAlign=center height=70>
												<TABLE cellSpacing=0 cellPadding=0 width=160>
													<TBODY>
														<TR>
															<TD width=35><IMG height=32 alt=运输工具管理
																src="${pageContext.request.contextPath}/images/03.gif" width=32></TD>
															<TD vAlign=center align=left width=85><A
																href="./CarServlet?action=list&currPage=1&opr=first">运输工具管理</A></TD>
														</TR>
														<TR>
															<TD align=left colSpan=2 height=30>查看与维护运输工具</TD>
														</TR>
													</TBODY>
												</TABLE>
											</TD>
											<TD vAlign=center align=left width="50%" height=70>
												<TABLE cellSpacing=0 cellPadding=0 width=160>
													<TBODY>
														<TR>
															<TD width=35 height=40><IMG height=32 alt=财务管理
																src="${pageContext.request.contextPath}/images/02.gif" width=32></TD>
															<TD vAlign=center width=85><A
																href="./CustomerServlet?action=rep">财务管理</A></TD>
														</TR>
														<TR>
															<TD align=left colSpan=2 height=30>收款/付款及明细查询</TD>
														</TR>
													</TBODY>
												</TABLE>
											</TD>
										</TR>
										<TR>
											<TD vAlign=center align=left width="50%" height=70>
												<TABLE cellSpacing=0 cellPadding=0 width=160>
													<TBODY>
														<TR>
															<TD width=35><IMG height=32 alt=未发车情况
																src="${pageContext.request.contextPath}/images/21.gif" width=32></TD>
															<TD vAlign=center align=left width=85><A
																href="./TransCarServlet?action=initstart&currPage=1&opr=first">未发车情况</A></TD>
														</TR>
														<TR>
															<TD align=left colSpan=2 height=30>查看未发车的订单情况</TD>
														</TR>
													</TBODY>
												</TABLE>
											</TD>
											<TD vAlign=center align=left width="50%" height=70>
												<TABLE cellSpacing=0 cellPadding=0 width=160>
													<TBODY>
														<TR>
															<TD width=35><IMG height=28 alt=已到站情况
																src="${pageContext.request.contextPath}/images/22.gif" width=28></TD>
															<TD vAlign=center align=left width=85><A
																href="./TransCarServlet?action=over&currPage=1&opr=first">已到站情况</A></TD>
														</TR>
														<TR>
															<TD align=left colSpan=2 height=30>查看已到站的订单情况</TD>
														</TR>
													</TBODY>
												</TABLE>
											</TD>
										</TR>
										<TR>
											<TD vAlign=center align=left width="50%" height=70>
												<TABLE cellSpacing=0 cellPadding=0 width=160
													style="display: none;">
													<TBODY>
														<TR>
															<TD width=35><IMG height=40 alt=生日提醒
																src="${pageContext.request.contextPath}/images/10_1.gif" width=32></TD>
															<TD vAlign=center align=left width=85><A
																href="birthday.aspx">生日提醒</A></TD>
														</TR>
														<TR>
															<TD align=left colSpan=2 height=30>联系人生日提醒设置</TD>
														</TR>
													</TBODY>
												</TABLE>
											</TD>
											<TD vAlign=center align=left width="50%" height=70>
												<TABLE cellSpacing=0 cellPadding=0 width=160
													style="display: none;">
													<TBODY>
														<TR>
															<TD width=35><IMG height=32 alt=个性化发送
																src="${pageContext.request.contextPath}/images/21.gif" width=32></TD>
															<TD vAlign=center align=left width=85><A
																href="kgxhdxfs.aspx">个性化发送</A></TD>
														</TR>
														<TR>
															<TD align=left colSpan=2 height=30>发送个性化短信</TD>
														</TR>
													</TBODY>
												</TABLE>
											</TD>
										</TR>
									</TBODY>
								</TABLE>
							</DIV>
						</TD>
						<TD vAlign=top width="40%">
							<DIV class=newtitle style="MARGIN-RIGHT: 0px">
								&nbsp;&nbsp;<B>公司网点</B>
							</DIV>
							<DIV class=newborder style="MARGIN-RIGHT: 0px">
								<img src="${pageContext.request.contextPath}/images/map.jpg" / width="440" border="0"><DIV
										class=DivNotice></DIV>
							</DIV>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
		</DIV>
	</form>

</body>
<SCRIPT src="js/transform.js" type=text/javascript></SCRIPT>

</html>
