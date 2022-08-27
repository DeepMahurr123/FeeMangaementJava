
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Logout extends HttpServlet {

 public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException ,ServletException
 {
     res.setContentType("text/html");
     PrintWriter out=res.getWriter();
    out.println(" <button style='text-aligen:center'><a href='index.html'>Home</a></button>");
    out.println(" <button style='text-aligen:center'><a href='AdminPortal.html'>Portal</a></button>");
    Cookie c=new Cookie("deep","");
    c.setMaxAge(0);
    res.addCookie(c);
    out.println("<h1>You Are Successfully Logout...");
 }
}
