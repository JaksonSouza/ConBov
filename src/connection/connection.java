package connection;

/**
 *
 * @author Jakson
 */

import java.sql.Connection; 
import java.sql.DriverManager;  
import java.sql.SQLException; 

public class connection {
    public Connection getConnection() {
		 try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/conbov","root","0706");
		 }         
		 catch(SQLException excecao) {
			throw new RuntimeException(excecao);
		 }
     }
}
