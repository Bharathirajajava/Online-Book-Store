package Com.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class App {
	public static void main(String[] args) throws SQLException {
        Scanner in=new Scanner(System.in);
		String url="jdbc:mysql://localhost:3307/bookstore";
		String username="root";
		String password="ravijava";
		Connection con=DriverManager.getConnection(url,username,password);
		Statement statement;
        statement = con.createStatement();
        ResultSet resultSet;   
		int numberRow = 0,bookid,bookcost,bookcount;
		String Bookname,Bookather,booktype;
		 PreparedStatement st =con.prepareStatement("select COUNT(*) from bookdetails");
		    ResultSet rs = st.executeQuery();
		    while(rs.next()){
		        numberRow = rs.getInt("count(*)");
		     }
        boolean flag=true;
	while(flag) {
		System.out.println("1.available book,\n2.Enter the book Type");
	int	chooice=in.nextInt();
		
	switch(chooice) {
	case 1:{
		

		try {
				
	        resultSet = statement.executeQuery(
	                 "select * from bookdetails");              
	        for(int i=1;i<=numberRow;i++) {
	        while (resultSet.next()) {
	                 bookid = resultSet.getInt("Bookid");
	                 Bookname = resultSet.getString("Bookname").trim();
	                 Bookather=resultSet.getString("BookAtherl").trim();
	                 bookcount=resultSet.getInt("Booktotalcount");
	                 bookcost=resultSet.getInt("Bookcost");
	                 booktype=resultSet.getString("BookType").trim();
	                 System.out.println("Bookid : " + bookid
	                                    + "\nBook Nmae : " + Bookname+"\nBook Type : "+booktype+"\nBook Ather : "+Bookather+"\nBook Quantity : "+ bookcount+
	                                  "\nBookcost : "+bookcost+ "\n- - - - - - - - - - - - - - - -");
           }
	        }
	             resultSet.close();
	             statement.close();
	             con.close();
	        }
	        catch(Exception e) {
	        	System.out.println("Dont connect");
	        }
		break;
	}

	case 2:{

		try {
				
	        resultSet = statement.executeQuery(
	                 "select * from bookstore.bookdetails where BookType='Comedy'"); 
	        
	        
	        
	        for(int i=1;i<=numberRow;i++) {
		        while (resultSet.next()) {
		                 bookid = resultSet.getInt("Bookid");
		                 Bookname = resultSet.getString("Bookname").trim();
		                 Bookather=resultSet.getString("BookAtherl").trim();
		                 bookcount=resultSet.getInt("Booktotalcount");
		                 bookcost=resultSet.getInt("Bookcost");
		                 booktype=resultSet.getString("BookType").trim();
		                 System.out.println("Bookid : " + bookid
		                                    + "\nBook Nmae : " + Bookname+"\nBook Type : "+booktype+"\nBook Ather : "+Bookather+"\nBook Quantity : "+ bookcount+
		                                  "\nBookcost : "+bookcost+ "\n- - - - - - - - - - - - - - - -");
	           }
		        }
            resultSet.close();
            statement.close();
            con.close();
		}
	catch (Exception e) {
		System.out.println("Case-2 Error");
	}
}
	}
}
}
}