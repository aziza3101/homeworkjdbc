package peaksoft;

import peaksoft.model.User;
import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        UserServiceImpl userService = new UserServiceImpl();
      // userService.createUsersTable();
       // userService.dropUsersTable();
//        userService.saveUser("Aziza","Arzykulova", (byte) 30);
//        userService.saveUser("Datka", "Mamatjanova", (byte) 20);
//        userService.saveUser("Maksat", "Bekmurza uulu", (byte) 31);
//        userService.saveUser("Nursultan", "Askarov", (byte) 25);
//        userService.saveUser("Klara", "Azimova", (byte) 30);
        //userService.removeUserById(2);
        userService.getAllUsers().forEach(System.out::println);
//

        //userService.cleanUsersTable();

    }
}
