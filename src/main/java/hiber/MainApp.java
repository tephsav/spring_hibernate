package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("Car1", 100)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("Car2", 200)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("Car3", 300)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("Car4", 400)));
      userService.add(new User("User5", "Lastname5", "user5@mail.ru", new Car("Car5", 500)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      User findUser = userService.getUserByModelSeries("Car3", 300);
      System.out.println("Id = " + findUser.getId());
      System.out.println("First Name = " + findUser.getFirstName());
      System.out.println("Last Name = " + findUser.getLastName());
      System.out.println("Email = " + findUser.getEmail());
      System.out.println();

      context.close();
   }
}
