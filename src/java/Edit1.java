

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Deep Mahur
 */
@WebServlet("/Edit1")
public class Edit1 extends HttpServlet {

   public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
   {
       res.setContentType("text/html");
       PrintWriter out=res.getWriter();
       String sid=req.getParameter("id");
       int id=Integer.parseInt(sid);
         Pujo e=new Pujo();
    
  try
  {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/feemanagement","root","Deep@123");
      PreparedStatement ps=con.prepareStatement("select * from student1 where id='"+id+"'");
      //ps.setInt(1, id);
      ResultSet rs=ps.executeQuery();
      while(rs.next())
      {
          
          e.setId(rs.getInt(1));
          e.setName(rs.getString(2));
          e.setGmail(rs.getString(3));
          e.setSex(rs.getString(4));
          e.setCource(rs.getString(5));
          e.setFee(rs.getInt(6));
          e.setDeposit(rs.getInt(7));
          e.setDues(rs.getInt(8));
          e.setAddress(rs.getString(9));
          e.setContact(rs.getString(10));
      }

       
       
     
      out.println(e.getName());
       out.println("<htm> ");
        out.println("<head> ");
         out.println("<title>Update</title> ");
          out.println("</head> ");
           out.println("<body> ");
           out.println("<form action='Edit2' method='post'>");
            out.println("<table> ");
             out.println("<tr><td>Id:</td><td><input type='text' name='id1' value='"+e.getId()+"'></td></tr>");
             out.println("<tr></tr>");
             out.println("<tr></tr>");
             out.println("<tr></tr>");
              out.println("<tr><td>Name:</td><td><input type='text' name='name1' value='"+e.getName()+"'></td></tr>");
              out.println("<hr>");
               out.println("<tr></tr>");
             out.println("<tr></tr>");
             out.println("<tr></tr>");
               out.println("<tr><td>Gmail:</td><td><input type='text' name='gmail1' value='"+e.getGmail()+"'></td></tr>");
                out.println("<tr></tr>");
             out.println("<tr></tr>");
             out.println("<tr></tr>");
                        out.println("<tr><td>Sex:</td><td><select name='sex1' value='"+e.getSex()+"'>");
                        out.println("<option>        </option>");
                        out.println("<option>Male</option>");
                        out.println("<option>Female</option>");
                        out.println("<option>Common</option>");
                        out.println("</select></td></tr>");
                         out.println("<tr></tr>");
             out.println("<tr></tr>");
             out.println("<tr></tr>");
                         out.println("<tr><td>Cource:</td><td><select name='cource1' value='"+e.getCource()+"'>");
                         out.println("<option>          </option>");
                         out.println("<option>Python</option>");
                         out.println("<option>Java Expert</option>");
                         out.println("<option>C,C++</option>");
                         out.println("<option>Php</option>");
                         out.println("<option>JavaScript</option>");
                         out.println("<option>Web Designing</option>");
                         out.println("<option>Mearn</option>");
                         out.println("<option>Android</option>");
                         out.println("<option>Hotel Management</option>");
                         out.println("<option>Bsc(Physics)</option>");
                         out.println("<option>Bsc(Chemistry)</option>");
                         out.println("<option>Bsc(Bio)</option>");
                         out.println("<option>Fluter</option>");
                         out.println("</select></td></tr>");
                          out.println("<tr></tr>");
             out.println("<tr></tr>");
             out.println("<tr></tr>");
                          out.println("<tr><td>Fee:</td><td><input type='text' name='fee1' value='"+e.getFee()+"'></td></tr>");
                           out.println("<tr></tr>");
             out.println("<tr></tr>");
             out.println("<tr></tr>");
                           out.println("<tr><td>Deposit:</td><td><input type='text' name='deposit1' value='"+e.getDeposit()+"'></td></tr>");
                            out.println("<tr></tr>");
             out.println("<tr></tr>");
             out.println("<tr></tr>");
                            out.println("<tr><td>Due:</td><td><input type='text' name='due1' value='"+e.getDues()+"'></td></tr>");
                             out.println("<tr></tr>");
             out.println("<tr></tr>");
             out.println("<tr></tr>");
                             out.println("<tr><td>Address:</td><td><input type='text' name='address1' value='"+e.getAddress()+"'></td></tr>");
                              out.println("<tr></tr>");
             out.println("<tr></tr>");
             out.println("<tr></tr>");
                              out.println("<tr><td>Contact:</td><td><input type='text' name='contact1' value='"+e.getContact()+"'></td></tr>");
                               out.println("<tr></tr>");
             out.println("<tr></tr>");
             out.println("<tr></tr>");
                              out.println(" <tr><td></td><td><input type='submit' value='Edit & Save '/></td></tr> ");
                             // out.println("<a href='Edit2'>edit</a>");
                             out.println("</table>");
                               out.println("</form> ");
                                out.println(" </body>");
                                 out.println("</html> ");
       
       
         }
  catch(Exception s)
  {
      out.println(s);
  }
                                        
   }
     
                                  
   
}
