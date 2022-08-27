
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SavedRecord")
public class SavedRecord extends HttpServlet
{
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
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
        String deposit=req.getParameter("dept");        
        String due=req.getParameter("dues");
        String address=req.getParameter("address");
        String contact=req.getParameter("contact");
        try
        {
            
out.println("<h1 style='color:Blue;text-align:center;'>Your Record Saved Successfully.....</h1>");
out.println("<html>");
out.println("<table>");
out.println("<tr><td><button style='background-color:blue;border-radius:30px;color:white;'><a href='index.html' style='color:white;'>"
        + "<b style='color:white;'>Home</b></a></button></td><td><button style='background-color:blue;border-radius:30px;'>"
        + "<a href='AccountentPortal.html'><b style='color:white;'>Add_Accountent</b></a></button></td><td>"
        + "<button style='background-color:blue;border-radius:30px;color:white;'><a href='Student.html' style='color:white;'>"
        + "<b style='color:white;'>Add_Student</b></a></button></td><td><button style='background-color:blue;border-radius:30px;color:white;'>"
        + "<a href='ViewStudent' style='color:white;'>"
        + "<b style='color:white;'>View_Student</b></a></button></td></tr>");

out.println("<body style='background-color:yellow;'>");
out.println("<table border=1 width=40% ");
out.println("<tr><th>Id's</th><th>Details</th></tr>");
out.println("<tr><th>Id</th><td>"+a+"</td></tr>");
out.println("<tr><th>Name</th><td>"+name+"</td></tr>");
out.println("<tr><th>Gmail</th><td>"+gmail+"</td></tr>");
out.println("<tr><th>Sex</th><td>"+sex+"</td></tr>");
out.println("<tr><th>Cource</th><td>"+cource+"</td></tr>");
out.println("<tr><th>Fee</th><td>"+fee+"</td></tr>");
out.println("<tr><th>Deposit</th><td>"+deposit+"</td></tr>");
out.println("<tr><th>Due</th><td>"+due+"</td></tr>");
out.println("<tr><th>Address</th><td>"+address+"</td></tr>");
out.println("<tr><th>Contact</th><td>"+contact+"</td></tr>");
out.println("</table>");
out.println("<br>");
out.println("<br>");
out.println("<br>");
out.println("<br>");
out.println("<br>");
out.println("<br>");
out.println("<br>");
out.println("<br>");
out.println("<br>");
out.println("<br>");
out.println("<br>");
out.println("<h2><marquee>Hello "+name+" Welcome ...You Are Registerd....Thanks....</marquee></h2>");
out.println("</body>");
out.println("</html>");
    }
    
    catch(Exception e)
    {
        out.println(e);
    }
}
}