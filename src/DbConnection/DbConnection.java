package DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbConnection
{
    public Statement statement;

    public void Connect(){
        String url="jdbc:mysql://localhost:3306/gra";
        String username="root";
        String password="";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);
            statement  = connection.createStatement();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
