
package servlets;

import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;
import services.UserService;


public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UserService us = new UserService();

        try {
            List<User> users = us.getAll();
            request.setAttribute("users", users);
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);

    }
    
 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        UserService us = new UserService();
        
        String email = request.getParameter("email");
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String password = request.getParameter("password");
        boolean active = true;
        int role = 1;
        
        try {
            switch (action) {
                case "add":
                    us.insert(email, active, firstName, lastName, password, role);
                    break;
                
                case "edit":
                    // if click edit, add user changes to edit user
                    break;    
                    
                case "save":
                    us.update(email,active,firstName, lastName, password, role);
                    break;
                
                case "delete":
                    us.delete(email);
            }          
        }
        catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            List<User> users = us.getAll();
            request.setAttribute("users", users);
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);

    }

    

}
