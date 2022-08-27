
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Deep Mahur
 */
public class Edit extends HttpServlet {

   public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
   {
       res.setContentType("text/html");
       PrintWriter out=res.getWriter();
       String sid=req.getParameter("id");
       int id=Integer.parseInt(sid);
       String name=req.getParameter("name");
       String password=req.getParameter("pass");
       String gmail=req.getParameter("gmail");
       String address=req.getParameter("address");
       String contact=req.getParameter("contact");
        
       try
       {
           Connection con=Adm.getConnection();
           PreparedStatement ps=con.prepareStatement("update accountent set Name=?,Password=?,gmail=?,address=?,contect=? where id='"+id+"'");
           ps.setString(1, name);
           ps.setString(2,password);
           ps.setString(3,gmail);
           ps.setString(4,address);
           ps.setString(5,contact);
           int status=ps.executeUpdate();
           if(status>0)
           {
               res.sendRedirect("ViewServlet");
           }
           else
           {
               out.println("Sorry! to saved Record");
           }
       }
       catch(Exception s)
       {
           out.println(s);
       }
   }
}
