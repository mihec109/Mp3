
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mihah
 */
public class database {
    private Connection con;
    
    public database(){    
    }
    public void Open(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/Lljiz5TwKv","Lljiz5TwKv", "JWHmQAazfw"
            );
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Cant connect to the database");
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void closeDB(){
        try {
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Negre zapret baze supak");
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
