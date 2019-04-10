package Servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import DB.db;
import model.User;
import sizeyunsuan.*;
import java.lang.*;
public class showresultServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws UnsupportedEncodingException,IOException
	{	
		
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		
		HttpSession session=req.getSession();
		ArrayList<ArrayList<String>> als=(ArrayList<ArrayList<String>>)session.getAttribute("als");
	
		
		ArrayList<String> userAnswer=new ArrayList<String>();
		for(int i=0;i<als.size();i++)
		{
			userAnswer.add(req.getParameter("fname"+i));
		}
		session.setAttribute("userAnswer", userAnswer);
		
		ArrayList<String> duiCuo=new ArrayList<String>();
		
		int fenzi=0;
		for(int i=0;i<als.size();i++)
		{
			if(als.get(i).get(1).equals(userAnswer.get(i)))
			{
				duiCuo.add("¡Ì");
				fenzi++;
			}
			else {
				duiCuo.add("¡Á");
			}
		}
		session.setAttribute("duiCuo", duiCuo);
		
		ArrayList<Double> fenshu=new ArrayList<Double>();

		fenshu.add((double) (((double)fenzi/(double)als.size())*100));

		session.setAttribute("fenshu", fenshu);

			res.sendRedirect("showr.jsp");

		}
		 
		
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws UnsupportedEncodingException,IOException
	{
		doGet(req,res);
	}
}
