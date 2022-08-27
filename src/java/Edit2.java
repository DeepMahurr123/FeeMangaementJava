
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Deep Mahur
 */
public class Edit2 extends HttpServlet 
{
public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
{
    res.setContentType("text/html");
    PrintWriter out=res.getWriter();

      String sid=req.getParameter("id1");
    int id=Integer.parseInt(sid);  

    String name=req.getParameter("name1");
    String gmail=req.getParameter("gmail1");
    String sex=req.getParameter("sex1");
    String cource=req.getParameter("cource1");
    String fe=req.getParameter("fee1");
    int fee=Integer.parseInt(fe);
    String depos=req.getParameter("deposit1");
    int deposit=Integer.parseInt(depos);
    String du=req.getParameter("due1");
    int due=Integer.parseInt(du);
    String address=req.getParameter("address1");
    String contact=req.getParameter("contact1");
    Pujo p=new Pujo();
out.println(id);
    p.setId(id);
    p.setName(name);
    p.setGmail(gmail);
    p.setSex(sex);
    p.setCource(cource);
    p.setFee(fee);
    p.setDeposit(deposit);
    p.setDues(due);
    p.setAddress(address);
    p.setContact(contact);
    //int status=Adm.Update(p);
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/feemanagement","root","Deep@123");
        PreparedStatement ps=con.prepareStatement("update student1 set name=?,gmail=?,sex=?,cource=?,fee=?,deposit=?,due=?,address=?,contact=? where id='"+id+"'");
       // ps.setInt(1,id);
        ps.setString(1,name);
        ps.setString(2,gmail);
        ps.setString(3,sex);
        ps.setString(4,cource);
        ps.setInt(5,fee);
        ps.setInt(6,deposit);
        ps.setInt(7,due);
        ps.setString(8,address);
        ps.setString(9,contact);
        int s=ps.executeUpdate();
  
    
    if(s>0)
    {
        res.sendRedirect("ViewStudent");
    }
    else
    {
        out.println("Update is not Successfully. Sorry!.");
    }
      }
    catch(Exception m)
    {
        out.println(m);
    }
}
}
