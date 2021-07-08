
package services;

import java.util.List;
import models.User;
import dataaccess.UserDB;

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
    public void insert(String email, Boolean active, String firstName, String lastName, String password, int roleId) throws Exception {
        User user = new User(email, active , firstName, lastName, password, roleId);
        UserDB userDB = new UserDB();
        userDB.insert(user);
    }
    
    public void update(String email, boolean isActive, String firstName, String lastName, String password, int roleId) throws Exception {
        UserDB db = new UserDB();
        User user = new User(email, isActive, firstName, lastName, password, roleId);
        db.update(user);
    }
    
    public void delete(String email) throws Exception {
        User user = new User();
        user.setEmail(email);
        UserDB userDB = new UserDB();
        userDB.delete(user);
    }
}