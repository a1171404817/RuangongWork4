package DB;

import java.sql.*;
import java.util.*;
import model.LyTable;
import model.User;


public class db {
	Connection ct;
	PreparedStatement pstmt;
	
	public db()
	{
		try{
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=JSP","sa","123456");//链接对象
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}


public User checkUser(String username,String password)
{
	try {
		pstmt=ct.prepareStatement("select*from[userTable]where username=? and password=?");
		pstmt.setString(1,username);
		pstmt.setString(2, password);
		ResultSet rs=pstmt.executeQuery();
		User user=new User();
		while(rs.next())
		{
			user.setId(rs.getInt(1));
			user.setUsername(rs.getString(2));
			user.setPassword(rs.getString(3));
			return user;
		}
		return null;
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		return null;
	}
}

public ArrayList findLyInfo(){
	
	try {
		ArrayList al=new ArrayList();
		pstmt=ct.prepareStatement("select*from[Lytable]");
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			LyTable ly =new LyTable();
			ly.setId(rs.getInt(1));
			ly.setUserId(rs.getInt(2));
			ly.setDate(rs.getDate(3));
			ly.setTitle(rs.getString(4));
			ly.setContent(rs.getString(5));
			al.add(ly);
		}
		return al;
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		return null;
	}
}

public String getUserName(int id){
	String username=null;
	
	try{
		pstmt=ct.prepareStatement("select username from [userTable] where id=?");
		
		pstmt.setInt(1, id);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			username=rs.getString(1);
		}
		return username;
		
		
	}catch(Exception e)
	{
		e.printStackTrace();
		return null;
	}
	
	
}

public boolean addInfo(LyTable ly)
{
	try{
		pstmt=ct.prepareStatement("insert into [lyTable] values(?,?,?,?)");
		pstmt.setInt(1, ly.getUserId());
		pstmt.setDate(2, ly.getDate());
		pstmt.setString(3, ly.getTitle());
		pstmt.setString(4, ly.getContent());
		pstmt.executeUpdate();
		return true;
		
		
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		return false;
	}

}


private String getTitle() {
	// TODO Auto-generated method stub
	return null;
}

}