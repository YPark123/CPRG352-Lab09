
package services;

import dataaccess.UserDB;
import java.util.ArrayList;
import java.util.List;
import models.User;
import models.Role;
import dataaccess.RoleDB;

public class RoleService {

    public List<Role> getAll(int roleID) throws Exception {
        RoleDB roleDB = new RoleDB();
        List<Role> roles = roleDB.getAll(roleID);
        return roles;
    }
}
