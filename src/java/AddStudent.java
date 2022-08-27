

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
        String id=req.getParameter("id");
        int a=Integer.parseInt(id);
        String name=req.getParameter("name");
        String gmail=req.getParameter("gmail");
        String sex=req.getParameter("Gender");
        String cource=req.getParameter("select");
        String fee=req.getParameter("Fee");
       int fees=Integer.parseInt(fee);
        String deposit=req.getParameter("dept");
        int b=Integer.parseInt(deposit);
       String due=req.getParameter("dues");
       int c=Integer.parseInt(due);
       String address=req.getParameter("address");
       String contact=req.getParameter("contact");
       //int d=Integer.parseInt(contact);
      Pujo p=new Pujo();
      p.setId(a);
      p.setName(name);
      p.setGmail(gmail);
      p.setSex(sex);
      p.setCource(cource);
      p.setFee(fees);
      p.setDeposit(b);
      p.setDues(c);
      p.setAddress(address);
      p.setContact(contact);
      
        int status=Adm.save(p);
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
     
    }

