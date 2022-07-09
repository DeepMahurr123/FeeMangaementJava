
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Adm {
    public static Connection getConnection()
    {
      Connection con=null;
      try
      {
       Class.forName("com.mysql.jdbc.Driver");
       con=DriverManager.getConnection("jdbc:mysql://localhost:3306/feemanagement","root","Deep@123");
      }
      catch(Exception e)
      {
          System.out.println(e);
      }
      return con;
    }
    public static int save(Pujo e)
    {
        int status=0;
        try{
       Connection con=Adm.getConnection();
       PreparedStatement ps=con.prepareStatement("insert into accountent values(?,?,?,?,?,?)");
       ps.setString(1,e.getId());
       ps.setString(2,e.getName());
       ps.setString(3, e.getPassword());
       ps.setString(4,e.getGmail());
       ps.setString(5,e.getAddress());
       ps.setString(6,e.getContact());
       
       status=ps.executeUpdate();
       con.close();
        }
        catch(Exception s)
        {
            System.out.println(s);
        }
        return status;
    }
    public static List<Pujo> view() throws SQLException
    {
       
            List<Pujo>list=new ArrayList<Pujo>();
            try
            {
        
        Connection con=Adm.getConnection();
        PreparedStatement ps=con.prepareStatement("select * from feemanagement5");
        ResultSet s=ps.executeQuery();
        while(s.next())
        {
            Pujo e=new Pujo();
     e.setId(s.getString(1));
     e.setName(s.getString(2));
     e.setPassword(s.getString(3));
     e.setGmail(s.getString(4));
     e.setAddress(s.getString(5));
     e.setContact(s.getString(6));
     list.add(e);
    }con.close();
        
        }
        catch(Exception m)
        {
            System.out.println(m);
        }
       return list; 
    }
    
}
