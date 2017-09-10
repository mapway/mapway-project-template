<%@page import="cn.ennwifi.solu.tools.Jsps"%>
<%@page import="cn.ennwifi.solu.ui.shared.repository.APP_DATAObj"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
APP_DATAObj app=Jsps.appInfo();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>解决方案</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	  *{
	    margin:0px;
	    padding:0px;
	  }
		.c1{
		text-align: center;
		font-weight: bold;
		font-size: 24px;
		padding: 30px;
		}
		.c2{
		padding: 10px;
		text-align: center;
		}
		.copy{
		 height: 64px;
		 background-color: #f0f0f0;
		 text-align: center;
		 position: fixed;
		 
		 bottom:0px;
		 width: 100%;
		 line-height: 64px;
		}
	</style>
  </head>
  
  <body>
			<div class="c1">泛能解决方案</div>
			<div class="c2"><a href="admin">数据录入</a></div>
			
			<div class="copy">
			
				<span>
						<%=app.getNAME() %> <%=app.getCOPYRIGHT() %>
				</span>
				<span><a href="doc/index">API文档</a></span>
			
			</div>
  </body>
</html>
