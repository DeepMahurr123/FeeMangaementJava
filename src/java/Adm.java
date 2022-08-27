
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
    public static int save1(Pujo s)
    {
        int status=0;
        Connection con=Adm.getConnection();
        try
        {
        PreparedStatement ps=con.prepareStatement("insert into accountent values(?,?,?,?,?,?)");
        ps.setInt(1,s.getId());
        ps.setString(2,s.getName());
        ps.setString(3,s.getPassword());
        ps.setString(4,s.getGmail());
        ps.setString(5,s.getAddress());
        ps.setString(6,s.getContact());
        status=ps.executeUpdate();
        }
        catch(Exception r)
        {
            System.out.println(r);
        }
        return status;
    }
    public static int save(Pujo e)
    {
        int status=0;
        try{
       Connection con=Adm.getConnection();
           PreparedStatement ps=con.prepareStatement("insert into student1 values(?,?,?,?,?,?,?,?,?,?)");
        ps.setInt(1,e.getId());
        ps.setString(2,e.getName());
        ps.setString(3,e.getGmail());
        ps.setString(4,e.getSex());
        ps.setString(5,e.getCource());
        ps.setInt(6,e.getFee());
        ps.setInt(7,e.getDeposit());
        ps.setInt(8,e.getDues());
        ps.setString(9,e.getAddress());
        ps.setString(10,e.getContact());
       
       status=ps.executeUpdate();
       
        }
        catch(Exception s)
        {
            System.out.println(s);
        }
        return status;
    }
    public static Pujo getstudentbyId(int id) throws SQLException
    {
      Pujo p=new Pujo();
      try
      {
            Connection con=null;
            PreparedStatement ps=con.prepareStatement("select * from student1 where id=?");
           ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                   //p=new Pujo();
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setGmail(rs.getString(3));
                p.setSex(rs.getString(4));
                p.setCource(rs.getString(5));
                 p.setFee(rs.getInt(6));
                  p.setDeposit(rs.getInt(7));
                   p.setDues(rs.getInt(8));
                   p.setAddress(rs.getString(9));
                   p.setContact(rs.getString(10));
                   
            }
            con.close();
      }
      catch(Exception s)
      {
          System.out.println(s);
      }
        return p;
    }
    public static int Update(Pujo e)
    {
        
        int status=0;
        try
        {
           Connection con=Adm.getConnection();
            PreparedStatement ps=con.prepareStatement("update student1 set  Name=?,gmail=?,sex=?,cource=?,fee=?,deposit=?,due=?,address=?,contact=? where id='"+e.getId()+"'");
            
            ps.setInt(1,e.getId());
            ps.setString(2,e.getName() );
            ps.setString(3,e.getGmail());
            ps.setString(4,e.getSex());
            ps.setString(5,e.getCource());
            ps.setInt(6,e.getFee());
            ps.setInt(7,e.getDeposit());
            ps.setInt(8,e.getDues());
            ps.setString(9, e.getAddress());
            ps.setString(10, e.getContact());
            status=ps.executeUpdate();
            con.close();
                    
        }
        catch(Exception r)
        {
           System.out.println(r);
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
     e.setId(s.getInt(1));
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
    public static int Delete(int id)
    {
        int status=0;
        Connection con=null;
        
        try
        {
            con=Adm.getConnection();
            PreparedStatement ps=con.prepareStatement("delete from student1 where id=?");
            ps.setInt(1, id);
            status=ps.executeUpdate();
            con.close();
        }
        catch(Exception r)
        {
            System.out.println(r);
        }
        return status;
    }
    public static List<Pujo> getAll() throws SQLException
    {
        List<Pujo> list=new ArrayList<Pujo>();
        try
        {
        Connection con=Adm.getConnection();
        PreparedStatement ps=con.prepareStatement("select * from student1");
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            Pujo p=new Pujo();
            p.setId(rs.getInt(1));
            p.setName(rs.getString(2));
            p.setGmail(rs.getString(3));
            p.setSex(rs.getString(4));
            p.setCource(rs.getString(5));
            p.setFee(rs.getInt(6));
            p.setDeposit(rs.getInt(7));
            p.setDues(rs.getInt(8));
            p.setAddress(rs.getString(9));
            p.setContact(rs.getString(10));
            list.add(p);
        }
        }
        catch(Exception r)
        {
            System.out.println(r);
        }
        return list;
    }
}
