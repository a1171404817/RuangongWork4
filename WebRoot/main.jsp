
<%@page import="java.text.SimpleDateFormat"%>
<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="model.LyTable" %>
<%@page import="DB.db" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
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
  background-image: url('https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1554809783749&di=21b4c919da2ab83521c10886808ce8fa&imgtype=0&src=http%3A%2F%2Fimg18.3lian.com%2Fd%2Ffile%2F201706%2F24%2Fc4b00fdd1248ede73d5fc461f61f895f.jpg');
				background-repeat: repeat;
			
	margin-left: 450px;
	margin-top: 0px;
}
  </style>
  </head>
  
  <body bgcolor=""white"">
  <form action="showresultServlet" method="post">
  
  	
  	
  	<table border="1">
  		<caption>Problems board</caption>
  		<tr>
  		<th>Problem</th>
  		<th>Blank</th>
  		
  		<%
  		ArrayList<ArrayList<String>> als=(ArrayList<ArrayList<String>>)session.getAttribute("als");
  		
  		for(int i=0;i<als.size();i++){
  		ArrayList<String> tmal=(ArrayList<String>) als.get(i);
  		%>
  		
  		<tr>
  			
  			<td><%=tmal.get(0)%></td>
  			<td><input type="text" name="fname<%=i%>"  /></td>
  			
  		</tr>
  		<%
  		}
  			
  			%>
  			
  				
  	</table>
  	</br>
  	<input type="submit" value="Sumbit" style=" margin-left:125px;width:150px;height:40px;"/>
  	
  </form>
    
    	<%
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String start = df.format(d);
		session.setAttribute("start",start);
		%>
	<div style="padding-left:50px">
	Starting time：<%=start %>
	</div>
  </body>
</html>
