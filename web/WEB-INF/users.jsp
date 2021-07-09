<%-- 
    Document   : users
    Created on : Jun 29, 2021, 1:59:19 PM
    Author     : 839217
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
    </head>
    <body>
        <form action="user" method="POST">
            <h1>Manage Users</h1>
             <table border="1" cellpadding="5">
                <tr>
                    <th>Email</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Role</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.email}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.role}</td>
                        <td><a href="user?action=edit&amp;email=${user.email}">Edit</a></td>
                        <td><a href="user?action=delete&amp;email=${user.email}">Delete</a></td>
                    </tr>
                </c:forEach>         
            </table>
        </form>
 
        <c:if test="${selectedUser eq null}">   
            <form action="user" method="POST">
                <h1>Add User</h1>
                <input type="text" name="email" placeholder="Email"><br>
                <input type="text" name="first_name" placeholder="First Name"><br>
                <input type="text" name="last_name" placeholder="Last Name"><br>
                <input type="text" name="password" placeholder="Password"><br>
                <select name="role">
                    <option value="1">system admin</option>
                    <option value="2">regular user</option>
                    <option value="3">company admin</option>
                </select>
                <input type="checkbox" name="active" checked="checked"><br>
                <input type="hidden" name="action" value="add">
                <input type="submit" value="Save">
            </form>
        </c:if>

        <c:if test="${selectedUser ne null}">
            <form action="user" method="POST">
                <h1>Edit User</h1>
                <input type="text" name="email" value="${selectedUser.email}" readonly="readonly"><br>
                <input type="text" name="first_name" value="${selectedUser.firstName}"><br>
                <input type="text" name="last_name" value="${selectedUser.lastName}"><br>
                <input type="text" name="password" value="${selectedUser.password}"><br>
                <select name="role">
                    <option value="1">system admin</option>
                    <option value="2">regular user</option>
                    <option value="3">company admin</option>
                </select>
                <input type="checkbox" name="active" checked="checked"><br>
                <input type="hidden" name="email" value="${selectedUser.email}">
                <input type="hidden" name="action" value="update">
                <input type="submit" value="Save">
            </form>
        </c:if>
    
    
    </body>
</html>

