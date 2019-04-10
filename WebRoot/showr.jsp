<%@page import="java.util.logging.SimpleFormatter"%>
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
	margin-left: 400px;
	margin-top: 0px;
}
  </style>
  </head>
  
  <body bgcolor="white">
  <form action="showresultServlet" method="post">
  
  	
  	
  	<table border="1">
  		<caption>Result board</caption>
  		<tr>
  		<th>Problem</th>
  		<th>Correct answer</th>
  		<th>Your answer</th>
  		<th>Judge</th>
  		<%
  		ArrayList<ArrayList<String>> als=(ArrayList<ArrayList<String>>)session.getAttribute("als");
  		ArrayList<String> userAnswer=(ArrayList<String>)session.getAttribute("userAnswer");
  		ArrayList<String> duiCuo=(ArrayList<String>)session.getAttribute("duiCuo");
  		for(int i=0;i<als.size();i++){
  		ArrayList<String> tmal=(ArrayList<String>) als.get(i);
  		%>
  		
  		<tr>
  			
  			<td><%=tmal.get(0)%></td>
  			<td><%=tmal.get(1)%></td>
  			<td><%=userAnswer.get(i) %></td>
  			<td><%=duiCuo.get(i) %></td>
  			
  		</tr>
  		<%
  		}
  			
  			%>
  		
  	</table>
  	</br>
  	<%ArrayList<Double> fenshu=(ArrayList<Double>)session.getAttribute("fenshu");%>
  	<p style=" margin-left:190px;">Mark：<%=fenshu.get(0) %></p>
  	<a href="login.jsp" style=" margin-left:190px;">Back</a>
  	
  </form>
   		
   		
   		<%
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String end= df.format(d);
		
		String start=(String)session.getAttribute("start");
		
		long dt1 = df.parse(start).getTime();
		long dt2 = df.parse(end).getTime();
		int second = (int) ((dt2 - dt1) / 1000); // 秒钟差
		%>
	
	<div style="padding-left:100px">
		Starting time：<%=end %></br>
		End Time：<%=start %></br>
		Cost：<%=second %>s
	</div>
		
  </body>
</html>
