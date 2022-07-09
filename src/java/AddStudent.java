

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class AddStudent extends HttpServlet
{
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        String name=req.getParameter("name");
        String gmail=req.getParameter("gmail");
        String sex=req.getParameter("Gender");
        String cource=req.getParameter("select");
        String fee=req.getParameter("Fee");
       // int a=Integer.parseInt(fee);
        String deposit=req.getParameter("dept");
        //int b=Integer.parseInt(deposit);
       String due=req.getParameter("dues");
       //int c=Integer.parseInt(due);
       String address=req.getParameter("address");
       String contact=req.getParameter("contact");
       //int d=Integer.parseInt(contact);
       try
       {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/feemanagement","root","Deep@123");
        PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?,?,?,?,?,?,?)");
        ps.setString(1,name);
        ps.setString(2,gmail);
        ps.setString(3,sex);
         ps.setString(4,cource);
        ps.setString(5,fee);
        ps.setString(6,deposit);
         ps.setString(7,due);
        ps.setString(8,address);
        ps.setString(9,contact);
        int status=ps.executeUpdate();
        if(status>0)
        {
            
            //res.sendRedirect("AddStudent");
            
           RequestDispatcher dis= req.getRequestDispatcher("SavedRecord");
           dis.forward(req, res);
            //out.println(" <h1>Record Not Saved!..jkkhkjh.</h1>");
        }
        else
        {
          out.println("<h1>Record Not Saved!...</h1>");
        }
       }
       catch(Exception e)
       {
           out.println(e);
       }
    }
}
