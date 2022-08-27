
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
public class Delete1 extends HttpServlet {

    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
    {
        res.setContentType("html/text");
        PrintWriter out=res.getWriter();
        String sid=req.getParameter("id");
        int id=Integer.parseInt(sid);
        try
        {
            Connection con=Adm.getConnection();
            PreparedStatement ps=con.prepareStatement("delete from accountent where id='"+id+"'");
            int status=ps.executeUpdate();
            out.println("delete Successfully");
            res.sendRedirect("ViewServlet");
            out.println("delete Successfully");
            try
            {
                Thread.sleep(2000);
            }
            catch(Exception e)
            {
                out.println(e);
            }
        }
        catch(Exception s)
        {
            out.println(s);
        }
    }
}
