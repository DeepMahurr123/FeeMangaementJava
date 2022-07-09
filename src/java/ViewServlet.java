

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ViewServlet extends HttpServlet {
public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
{
    res.setContentType("text/html");
    PrintWriter out=res.getWriter();
    String id=req.getParameter("Id2");
          String name=req.getParameter("Name2");
          String password=req.getParameter("Pass2");
          String gmail=req.getParameter("Gmail2");
          String address=req.getParameter("Address2");
          String contect=req.getParameter("Contact2");
//           Pujo e=new Pujo();
//          e.setId(id);
//          e.setName(name);
//          e.setPassword(password);
//          e.setGmail(gmail);
//          e.setAddress(address);
//          e.setContact(contect);
          
    try 
    {
   Class.forName("com.mysql.jdbc.Driver");
   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/feemanagement","root","Deep@123");
   PreparedStatement ps=con.prepareStatement("select * from accountent");
   out.println("<h1>Accountent List</h1>");
   out.println("<body style='background-color:yellow;'>");
   out.println("<tr><td width=15%><button style='background-color:blue;border-radius:30px;color:white;'><a href='index.html' style='color:white;'>"
        + "<b style='color:white;'>Home</b></a></button></td><td width=15%><button style='background-color:blue;border-radius:30px;'>"
        + "<a href='AddAccountent.html'><b style='color:white;'>Add_Accountent</b></a></button></td><td>"
        + "<button style='background-color:blue;border-radius:30px;color:white;'><a href='AdminPortal.html' style='color:white;'>"
        + "<b style='color:white;'>AdminPannel</b></a></button></td><td><button style='background-color:blue;border-radius:30px;color:white;'>"
        + "<a href='Logout.html' style='color:white;'>"
        + "<b style='color:white;'>Logout</b></a></button></td></tr>");
   out.println("<br>");
   out.println("<br>");
   out.println("<table border=1 width=100%");
   out.println("<tr><th>Id</th><th>Name</th><th>Password</th><th>Gmail</th><th>Address</th><th>Contect</th></tr>");
  ResultSet rs=ps.executeQuery();
  while(rs.next())
  {
    String a=  rs.getString(1);
   String b=   rs.getString(2);
     String c =rs.getString(3);
     String d= rs.getString(4);
      String e=rs.getString(5);
      String f=rs.getString(6);
      out.println("<tr><td>"+a+"</td><td>"+b+"</td><td>********</td><td>"+d+"</td><td>"+e+"</td><td>"+f+"</td></tr>");
  }
    
    
    out.println("</tabl>");
    out.println("</body>");
    }
    catch(Exception e)
    {
        out.println(e);
    }
}}
