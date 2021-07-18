
package services;

import dataaccess.RoleDB;
import java.util.List;
import models.User;
import dataaccess.UserDB;
import models.Role;

public class UserService {
    public  List<User> getAll() throws Exception {
        UserDB userDB = new UserDB();
        List<User> users = userDB.getAll();
        return users;
    }
    public User get(String email) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        return user;
    }

    public void insert(String email, Boolean active, String firstName, String lastName, String password, int roleID) throws Exception {
        User user = new User(email, active , firstName, lastName, password);
        RoleDB roleDB = new RoleDB();
        Role role =  roleDB.get(roleID);
        user.setRole(role);
        
        UserDB userDB = new UserDB();
        userDB.insert(user);
    }
    
    public void update(String email, boolean active, String firstName, String lastName, String password, int roleID) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        RoleDB roleDB = new RoleDB();
        Role role =  roleDB.get(roleID);
        user.setRole(role);
        
        user.setActive(active);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setRole(role);
          
        userDB.update(user);
    }
    
    
    public void delete(String email) throws Exception {        
        UserDB userDB = new UserDB();
        User user = userDB.get(email);        
        userDB.delete(user);
    }

}