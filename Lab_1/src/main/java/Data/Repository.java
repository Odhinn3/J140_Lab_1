/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import MainPack.ApplicationProperties;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author A.Konnov <github.com/Odhinn3>
 */
public class Repository implements RepositoryInterface{
    
    public List<User> getUsers(){
        String url = ApplicationProperties.get().getProperty("db.url");
        String dbUser = ApplicationProperties.get().getProperty("db.user");
        String dbPassword = ApplicationProperties.get().getProperty("db.password");
        List<User> list = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url, dbUser, dbPassword);
                Statement stm = connection.createStatement();
                ResultSet rs = stm.executeQuery("SELECT * FROM users")){
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String password = rs.getString(3);
                User user = new User(id, name, password);
                list.add(user);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public User checkUsers(String name, String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
