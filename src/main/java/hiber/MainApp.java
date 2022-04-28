package hiber;

import hiber.config.HiberConfig;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(HiberConfig.class);
      UserService userService = context.getBean(UserService.class);
      List<User> userList = new ArrayList<>();
      String[] name = {"Иван", "Пётр", "Сидор", "Фёдор"};
      String[] lastName = {"Иванов", "Петров", "Сидоров", "Фёдоров"};
      Random rnd = new Random();

      for (int i = 0; i < 4; i++) {
         userService.addUser(name[rnd.nextInt(4)], lastName[rnd.nextInt(4)], (byte) rnd.nextInt(120));
      }


      List<User> users = userService.listUsers();
      System.out.println("---до удаления---");
      for (User user : users) {
         System.out.println(user);
      }
      userService.removeUser(2);
      System.out.println("---после удаления---");
      users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
      }
      userService.updateUser(3, "Uname", "Ulastname", 01);
      System.out.println("---после изменения---");
      users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
      }
      context.close();
   }
}
