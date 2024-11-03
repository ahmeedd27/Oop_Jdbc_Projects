
package DbConnection;

import java.sql.*;
public class DbConnection {
    static Connection con;
    public static Connection createConnection(){
        try{
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            con=DriverManager.getConnection
        ("jdbc:mysql://localhost:3307/ahmedjdbc?zeroDateTimeBehavior=CONVERT_TO_NULL", 
                "root", "Aa8112003#");
        }catch(Exception e){
            System.out.println(e);
        }
       return con;
    }
}
