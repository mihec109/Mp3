import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    public Connection con;
    
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

    public void Registration(String firstname, String lastname, String pass, String mail)
    {
        try {
        String sql = "INSERT INTO users(firstname, lastname, pass, mail) VALUES(?,?,?,?)";
        PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
        ps.setString(1, firstname);
        ps.setString(2, lastname);
        ps.setString(3, pass);
        ps.setString(4, mail);
        ps.execute();
        
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage());
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
        public User Login(String mail, String pass){
        User u;
        try{
            String sql = "SELECT id, firstname, lastname, mail, pass FROM users WHERE mail = ? AND pass = ?";
            PreparedStatement rs = (PreparedStatement) con.prepareStatement(sql);
            rs.setString(1, mail);
            rs.setString(2, pass);
            ResultSet rS = rs.executeQuery();
            while(rS.next()){
                u = new User(rS.getInt(1), rS.getString(2), rS.getString(3), rS.getString(4));
                return u;
            }
        } catch(SQLException ex){
        }
         return null;
        }
        
    public void DodajS(String name, String url, String author, String album, User u)
    {
        try {
        String sql = "INSERT INTO music (name, url, author_id, album_id, user_id) VALUES (\n" +
"        ?, ?,\n" +
"        (SELECT id FROM authors WHERE authors.name = ?),\n" +
"        (SELECT id FROM albums WHERE albums.name = ?),\n" +
"        ?\n" +
"    );";
        PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, url);
        ps.setString(3, author);
        ps.setString(4, album);
        ps.setInt(5, u.GetId());
        ps.execute();
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Izpolni!");

        } 
    }
    
    public void DodajA(String name)
    {
        try {
        String sql = "INSERT INTO authors(name) VALUES (?)";
        PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
        ps.setString(1, name);
        ps.execute();
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage());
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void CreateA(String name, User u)
    {
        
        try {
        String sql = "INSERT INTO albums (name, user_id) VALUES (?,?)";
        PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
        ps.setString(1, name);
        ps.setInt(2, u.GetId());
        ps.execute();
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage());
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void EditA()
    {
        try {
        String sql = "";
        PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
        ps.execute();
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage());
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void DeleteA()
    {
        try {
        String sql = "";
        PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
        ps.execute();
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage());
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

        

}
