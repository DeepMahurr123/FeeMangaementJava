
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ViewStudent extends HttpServlet
{
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
    {
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        try
        {
             out.println("<html> ");
        out.println("<head> ");
        out.println("<title>ViewStudent</title> ");
        out.println("</head> ");
        out.println("<body style='background-color:pink;'> ");
            //out.println("<input type='currenttime' name='date'>");
            out.println("<h1 style='text-align:center'>Student List</h1>");
            out.println("<a href='AccountentPortal.html'>Back</a>");
            out.println("<br>");
        List<Pujo> list=Adm.getAll();
       
        out.println("<table border=1 width=100% ");
        out.println("<tr><th>Id</th><th>Name</th><th>Gmail</th><th>Sex</th><th>Cource</th><th>Fee</th><th>"
                + "Deposit</th><th>Dues</th><th>Address</th><th>Contact</th><th>Edit</th><th>Delete</th></tr> ");
        for(Pujo e:list)
        {
        out.println(" <tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getGmail()+"</td><td>"+e.getSex()+"</td><td>"+e.getCource()+"</td><td>"+e.getFee()+"</td><td>"+e.getDeposit()+"</td><td>"+e.getDues()+
                "</td><td>"+e.getAddress()+"</td><td>"+e.getContact()+"</td><td><a href='Edit1?id="+e.getId()+"'>Edit</a></td><td>"
                        + "<a href='Delete?id="+e.getId()+"'>Delete</a></td></tr>");

        }
                out.println("</table> ");
        out.println(" </body>");
        out.println("</html> ");
        }
        catch(Exception r)
        {
            System.out.println(r);
        }
    }
}
