
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
public class Edit0 extends HttpServlet {

 public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
 {
     res.setContentType("text/html");
     PrintWriter out=res.getWriter();
     String sid=req.getParameter("id");
     int id=Integer.parseInt(sid);
     Pujo p=new Pujo();
     try
     {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/feemanagement","root","Deep@123");
        PreparedStatement ps=con.prepareStatement("select * from accountent where id='"+id+"'");
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
         p.setId(rs.getInt(1));
         p.setName(rs.getString(2));
         p.setPassword(rs.getString(3));
         p.setGmail(rs.getString(4));
         p.setAddress(rs.getString(5));
         p.setContact(rs.getString(6));
        }
     }
          catch(Exception s)
     {
         out.println(s);
     }
        out.println("<html>");
        out.println("<head><title>Update</title></head>");
        out.println("<body style='background-color:lightgreen'>");
        out.println("<h1 style='text-align:center;'>Update "+p.getName()+"'s Profile</h1>");
        out.println("<form action='Edit' method='post'>");
        out.println("<table>");
        out.println("<tr><td>Id:</td><td><input type='hidden' name='id' value='"+p.getId()+"'></td></tr>");
        out.println("<tr> </tr>");
        out.println("<tr> </tr>");
        out.println("<tr> </tr>");
        out.println("<tr><td>Name:</td><td><input type='text' name='name' value='"+p.getName()+"'></td></tr>");
        out.println("<tr> </tr>");
        out.println("<tr> </tr>");
        out.println("<tr> </tr>");
        out.println("<tr><td>Password:</td><td><input type='text' name='pass' value='"+p.getPassword()+"'></td></tr>");
        out.println("<tr> </tr>");
        out.println("<tr> </tr>");
        out.println("<tr> </tr>");
        out.println("<tr><td>Gmail:</td><td><input type='text' name='gmail' value='"+p.getGmail()+"'></td></tr>");
        out.println("<tr> </tr>");
        out.println("<tr> </tr>");
        out.println("<tr> </tr>");
        out.println("<tr><td>Address:</td><td><input type='text' name='address' value='"+p.getAddress()+"'></td></tr>");
        out.println("<tr> </tr>");
        out.println("<tr> </tr>");
        out.println("<tr> </tr>");
        out.println("<tr><td>Contact:</td><td><input type='text' name='contact' value='"+p.getContact()+"'></td></tr>");
        out.println("<tr> </tr>");
        out.println("<tr> </tr>");
        out.println("<tr> </tr>");
        out.println("<tr><td></td><td><input type='submit' value='Edit&Save'></td></tr>");
        out.println("</table>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
     

 }
}