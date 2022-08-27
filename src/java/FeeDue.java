
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

/**
 *
 * @author Deep Mahur
 */
public class FeeDue extends HttpServlet {
public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
    res.setContentType("text/html");
    PrintWriter out=res.getWriter();
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/feemanagement", "root","Deep@123");
      PreparedStatement ps=con.prepareStatement("select * from student1");
      ResultSet rs=ps.executeQuery();
      out.println("<head><title>FeeDue</title></head>");
      out.println("<body style='background-color:lightblue;'>");
      out.println("<h1 style='text-align:center'>WELCOME TO DUE PAGE</h1>");
      
      out.println("<table border=1 width=50% style='margin-left:20%;'>");
      out.println("<tr><th>Id</th><th>Name</th><th>Fee</th><th>Deposit</th><th>Due</th><tr>");
      
      while(rs.next())
      {
          int id=rs.getInt(1);
          String name=rs.getString(2);
          int a=rs.getInt(6);
          int b=rs.getInt(7);
          int c=rs.getInt(8);
          if(c>0)
          {
              
              
              out.println("<tr><td>"+id+"</td><td>"+name+"</td><td>"+a+"</td><td>"+b+"</td><td style='color:red;'>"+c+"</td><tr>");
              
          }
      }
      out.println("</table>");
      out.println("</body>");
    }
    catch(Exception e)
    {
        out.println(e);
    }
}
}
