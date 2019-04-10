<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <style type="text/css">
  body {
  	background-image: url('https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1554807375653&di=0bc458a1d413ea04e6606ebc5dc17e7c&imgtype=0&src=http%3A%2F%2Fwww.sinaimg.cn%2Fdy%2Fslidenews%2F21_img%2F2015_17%2F1197_4144944_569048.jpg');
				background-repeat: no-repeat;
				background-position:top center;
	margin-top: 135px;
	margin-left: 475px;
}
  </style>
  </head>
  
  <body bgcolor="white">
   <form action="mainServlet" method="post" >
 
   <table>
   <caption>
Configure settings
   </caption>
   
   <tr>
   
   <td>Number of problems</td>
   <td><input type="text" name="shuliang" size="20"/></td>
   </tr>
	  <tr>
	  
   <td>Number of operators</td>
   <td><input type="text" name="yunsfn" size="20"/></td>
   </tr>
   
   <tr>
	  
   <td>Numerical range</td>
   <td><input type="text" name="zuojie" size="5"/>
   	&nbsp;--&nbsp;
     <input type="text" name="youjie" size="5"/></td>
   <td>&nbsp;</td>
   <td>&nbsp;</td>
   </tr>
   
 <tr>
   <td>  
 <input type="checkbox" name="vehicle" value="havacc" checked="checked"/>Multiplication,division
  </td>
  
  <td>
  <input type="checkbox" name="vehicle" value="havakh" checked="checked" />Have brackets
  </td>
   </tr>
   
   <tr>

   <td>  
 <input type="submit" value="Submit" style=" width:150px;height:30px;">
  </td>
  
  <td>
  <input type="reset"  value="reset" style=" width:150px;height:30px;">
  </td>
   </tr>
   </table>
   
   
   
  </form>
</body>
</html>
