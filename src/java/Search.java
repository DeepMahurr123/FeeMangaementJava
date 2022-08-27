

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Search extends HttpServlet {
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
    {
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        String search=req.getParameter("search");
        int t=0;
        try
        {
           Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/feemanagement","root","Deep@123");
        PreparedStatement ps=con.prepareStatement("select * from student1 "); 
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            Pujo s=new Pujo();
         String a= rs.getString(1);  
         String b= rs.getString(2);
         String c= rs.getString(3);
         String d= rs.getString(4);
         String e= rs.getString(5);
          String f=rs.getString(6);
         String g= rs.getString(7);
          String h=rs.getString(8);
         String i= rs.getString(9);
         String j=rs.getString(10);
         
          if(search.equals(a))
          {
              out.println("<body style='background-color:pink'");
              out.println("<br>");
              out.println("<h1 style='text-align:center'> The Details of   "+b+"....</h1> ");
              out.println("<table border=1 width=100%>");
              out.println("<tr><th>Id</th><th>Name</th><th>Gmail</th><th>Sex</th><th>Cource</th><th>Fee</th>"
                      + "<th>Deposit</th><th>Dues</th><th>Address</th><th>Contact</th></tr>");
              out.println("<tr><td>"+a+"</td><td>"+b+"</td><td>"+c+"</td><td>"+d+"</td><td>"+e+"</td><td>"+f+"</td><td>"+g+"</td><td>"+h+"</td><td>"+i+"</td><td>"+j+"</td></tr>");
              out.println("</table>");
              out.println("</body>");
           
              t++;
              break;
          }
//out.println(a);
         
        }
        if(t==0)
          {
              out.println("sorry no Record Found");
          }
        }
        catch(Exception e)
        {
            out.println(e);
        }
    }
}