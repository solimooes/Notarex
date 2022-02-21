import java.sql.Connection;
import java.sql.DriverManager;


public class MyConnection {
    
    public static Connection getConnection()
    {
        Connection con = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/notarex_db";
            String login = "root";
            String password = "";
            con = DriverManager.getConnection(url, login, password);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return con;
    } 
            
    
}
