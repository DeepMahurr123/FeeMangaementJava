

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
public class CheckRecord extends HttpServlet
{
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
    {
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        String name=req.getParameter("name");
        String password=req.getParameter("pass");
        int t=0;
        try
        {
           Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/feemanagement","root","Deep@123");
           PreparedStatement ps=con.prepareStatement("select * from accountent");
           ResultSet rs=ps.executeQuery();
           while(rs.next())
           {
                String b=rs.getString(2);
               String c=rs.getString(3);
              
               if(name.equals(rs.getString(2))&& password.equals(rs.getString(3)))
               {
                   req.getRequestDispatcher("AccountentPortal.html").include(req,res);
                   t++;
                   break;
               }
    
           }
           
             if(t==0)
             {
                 out.println("<h1>Sorry! Please Try Again User Name or Password is Incorrect..</h1>");
                 out.println("<br>");
                 req.getRequestDispatcher("index.html").include(req,res);
                
             }
          
           
        }
        catch(Exception e)
        {
            out.println(e);
        }
    }
}