package connection;

/**
 *
 * @author Jakson
 */

import java.sql.Connection; 
import java.sql.SQLException; 

public class testConnection {
    public static void main(String[] args) throws SQLException {
         Connection connection = new connection().getConnection();
         System.out.println("Conexão aberta!");
         connection.close();
     }
}
