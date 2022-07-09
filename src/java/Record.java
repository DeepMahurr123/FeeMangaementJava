
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Record {
  public static Connection getCon()
  {
      Connection con=null;
      try
      {
         Class.forName("com.mysql.jdbc.Driver");
          con=DriverManager.getConnection("jdbc:mysql://localhost:3306/feemanagement","root","Deep@123");
      }
      catch (Exception e)
      {
          System.out.println(e);
      }
      return con;
  }
  public static int Delete(Pujo s) throws SQLException
  {
      int status=0;
      try
      {
      
      Connection con=Record.getCon();
      PreparedStatement ps=con.prepareStatement("update student Name=?,Gmail=?,Sex=?,Cource=?,Fee=?,Deposit=?,Dues=?,Address=?,Contact=? where id=?");
      ps.setString(1, s.getName());
      ps.setString(2, s.getGmail());
      ps.setString(3, s.getSex());
      ps.setString(4, s.getCource());
      ps.setString(5, s.getFee());
      ps.setString(6, s.getDeposit());
      ps.setString(7, s.getDues());
      ps.setString(8, s.getAddress());
      ps.setString(9,s.getContact());
      ps.setString(10,s.getId());
      status=ps.executeUpdate();
      //con.close();
      }
      catch(Exception e)
      {
          System.out.println(e);
      }
      return status;
  }
}
