/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act12;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import static java.time.Clock.system;

public class Act12 {


    public static void main(String[] args) {
  
            try{
        
      String myDriver = "org.gjt.mm.mysql.Driver";
      String myUrl = "jdbc:mysql://localhost:8080/act12";
      Class.forName(myDriver);
      Connection conn = (Connection) DriverManager.getConnection(myUrl, "root", "root");
      
      String query = "SELECT * FROM users";
      Statement st = (Statement) conn.createStatement();
      ResultSet rs = st.executeQuery(query);
      
      while(rs.next()){
        int id = rs.getInt("id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        Date dateCreated = rs.getDate("date_created");
        boolean isAdmin = rs.getBoolean("is_admin");
        int numPoints = rs.getInt("num_points");
        System.out.format("%s, %s, %s, %s, %s, %s\n", id, firstName, lastName, dateCreated, isAdmin, numPoints);
      }
      
      rs.close();
      
    }catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
     }
        
    }
    
}
