package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.sql.SQLException;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        try {
            userService.createUsersTable();
            userService.saveUser("Иван", "Иванов", (byte) 25);
            userService.saveUser("Петр", "Петров", (byte) 30);
            userService.saveUser("Мария", "Сидорова", (byte) 28);
            userService.saveUser("Алексей", "Козлов", (byte) 35);
            List<User> userList = userService.getAllUsers();
            printTableOut();
            printTableBody(userList);
            userService.cleanUsersTable();
            userService.dropUsersTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printTableOut() {
        System.out.println(" ID |   Name   |  Last Name  | Age");
        System.out.println(" ---------------------------------");
    }

    public static void printTableBody(List<User> users) {
        for (User user : users) {
            System.out.println(user);
        }
    }

    }
