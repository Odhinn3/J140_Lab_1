package Repositories;
import Data.User;
import MainPack.ApplicationProperties;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static MainPack.App.getUser;
import static MainPack.App.getPassword;

/**
 *
 * @author A.Konnov <github.com/Odhinn3>
 */

public class Repository implements RepositoryInterface{
    
    public static String loginstatus;
   
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
        Repository repo = new Repository();
        List users = repo.getUsers();
        Iterator iterator = users.iterator();
        while(iterator.hasNext()){
            User user = (User) iterator.next();
            if(user.getName().equals(getUser())&user.getPassword().equals(getPassword())){
                setLoginstatus("Login success!");
                return user;
            } else setLoginstatus("Login failed!");
        }
        return null;
    }

    public static String getLoginstatus() {
        return loginstatus;
    }

    public static void setLoginstatus(String loginstatus) {
        Repository.loginstatus = loginstatus;
    }
}