

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewServlet extends HttpServlet
{
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        String Name1=req.getParameter("name");
        String Password1=req.getParameter("pass");
        //out.println("<h1>Hello Deep</h1>");
       // Cookie cookie=new Cookie("mahur",Name1);
      //  res.addCookie(cookie);
//        try
//        {
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/feemanagement","root","Deep@123");
//        PreparedStatement ps=con.prepareStatement("insert into feemanagement values(?,?)");
//        ps.setString(1,Name1);
//        ps.setString(2,Password1);
//        int i=ps.executeUpdate();
//        if(i>0)
//        {
            if(Name1.equals("Deep") && Password1.equals("deepmahur@123"))
            {
//            RequestDispatcher dis=req.getRequestDispatcher("AdminPortal.html");
//            dis.include(req,res);
                res.sendRedirect("AdminPortal.html");
            }
            else
            {
                out.println("<h2>Sorry! User Name or Password id incorrect..</h2>");
                            RequestDispatcher dis=req.getRequestDispatcher("index.html");
           dis.include(req,res);
            }
        
//        else
//        {
//            out.println("<h1>sorry to saved Record</h1>");
//             RequestDispatcher dis=req.getRequestDispatcher("index.html");
//            dis.include(req,res);
//        }
        }
//        catch(Exception e)
//        {
//            out.println(e);
//        }
    //}
}