
package util.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafael
 */
public class Conexao {
    
    private final String driver = "com.mysql.jdbc.Driver";
    //private final String url = "jdbc:mysql://10.28.15.53/keywords";
//    private final String url = "jdbc:mysql://rogerio-pc/comentarios";
    private final String url = "jdbc:mysql://localhost/comentarios";
    private final String login = "root";
    private final String pass = "root";
    private Connection con = null;
    
    public Conexao() {
        
    }
    
    public Connection getConnection() {
        try {        
            Class.forName(driver);
            con = DriverManager.getConnection(url, login, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        return con;
    }
    
    public void remove(Connection con) {
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
