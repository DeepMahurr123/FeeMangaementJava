

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SaveServlet extends HttpServlet 

    {
    //@Override
         public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
        {
          res.setContentType("text/html");
          PrintWriter out=res.getWriter();
          String id=req.getParameter("Id2");
          String name=req.getParameter("Name2");
          String password=req.getParameter("Pass2");
          String gmail=req.getParameter("Gmail2");
          String address=req.getParameter("Address2");
          String contect=req.getParameter("Contect2");
          
          Pujo e=new Pujo();
          e.setId(id);
          e.setName(name);
          e.setPassword(password);
          e.setGmail(gmail);
          e.setAddress(address);
          e.setContact(contect);
          
         
            int i=Adm.save(e);  
          
            if(i>0)
            {
                
                out.println("<h1>Hello "+name+" Your Record Saved Successfully</h1>");
                req.getRequestDispatcher("AddAccountent.html").include(req, res);
                
            }
            else
            {
                out.println("<h1>Sorry to Saved Record</h1>");
                  req.getRequestDispatcher("AddAccountent.html").include(req, res);
                
            }
          }
          
        }
    