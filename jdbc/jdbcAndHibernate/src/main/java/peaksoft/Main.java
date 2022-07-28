package peaksoft;

import peaksoft.dao.UserDaoHibernateImpl;
import peaksoft.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) throws Exception {

        UserDaoHibernateImpl userDaoHibernate=new UserDaoHibernateImpl();
//        userDaoHibernate.saveUser("Aziza","Arzykulova", (byte) 30);
//        userDaoHibernate.saveUser("Klara","Azimova", (byte) 30);
//        userDaoHibernate.saveUser("Nursultan","Askarov", (byte) 25);
       // userDaoHibernate.createUsersTable();
//        userDaoHibernate.removeUserById(1);
//
//        System.out.println(userDaoHibernate.getAllUsers());
        userDaoHibernate.dropUsersTable();
       // UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();

        //userDaoHibernate.getAllUsers();
        //userDaoHibernate.cleanUsersTable();
//
      // UserServiceImpl userService = new UserServiceImpl();
//        userService.getAllUsers().forEach(System.out::println);


        //userDaoHibernate.saveUser("AZIZA", "Arzykulova", (byte) 30);
        //userService.createUsersTable();
 //        userService.dropUsersTable();
        //userDaoHibernate.saveUser("Aziza","Arzykulova", (byte) 30);
//        userService.saveUser("Datka", "Mamatjanova", (byte) 20);
//        userService.saveUser("Maksat", "Bekmurza uulu", (byte) 31);
//        userService.saveUser("Nursultan", "Askarov", (byte) 25);
//        userService.saveUser("Klara", "Azimova", (byte) 30);
//        userService.removeUserById(2);


        //userService.cleanUsersTable();
    }
}
