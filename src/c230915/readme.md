```java
package c230915;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;



public class Main {
   public static void main(String[] args) {
      try {   
      Class.forName("oracle.jdbc.OracleDriver");
      
      
      Connection con = DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521/xe",
            "java",
            "qwer"
            );
      
//         String query1 = "update select set student_id = 'kds' where id = 1";
//         Statement stmt1 = con.createStatement();  // 주고 받는 것에 있어서 상태를 적어달라!
//         ResultSet rs1 = stmt1.executeQuery(query1);
      
//         String insertQuery = "insert into student (name, student_id, student_password, age, git_address) values (?, ?, ?, ?, ?)";
//         PreparedStatement pstmt = con.prepareStatement(insertQuery);
//         pstmt.setString(1, "송성민");
//         pstmt.setString(2, "ssmk");
//         pstmt.setString(3, "2631o");
//         pstmt.setInt(4, 23);
//         pstmt.setString(5, "송성민1");
//         pstmt.executeUpdate();
         
      

         String query = "select * from student";
         Statement stmt = con.createStatement();  // 주고 받는 것에 있어서 상태를 적어달라!
         ResultSet rs = stmt.executeQuery(query); // 보낼거다!!!
         while(rs.next()) {
            System.out.println(rs.getString("name")+ " : " + rs.getInt("age"));
         }
         
//         rs.next();
//         System.out.println(rs.getString("name") + " : " + rs.getInt("age"));
//         rs.next();
//         System.out.println(rs.getString("name"));
         con.close();
         
      
      }catch(Exception e) {
         e.printStackTrace();
      }
            
   }
}
```