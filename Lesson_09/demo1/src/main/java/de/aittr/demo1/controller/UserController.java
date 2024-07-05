package de.aittr.demo1.controller;

import de.aittr.demo1.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class UserController {
    private static List<User> serviceGetUser;

static {
    serviceGetUser = List.of(
            new User("Jack","jack@mai.com"),
            new User("Benn","benn@mail.com"),
            new User("Vasya","vasya@mail.com")
    );

}


@GetMapping("/user")
public String getAllList(Model model){
    model.addAttribute("users",serviceGetUser);
    model.addAttribute("column1","имя пользователя");
    model.addAttribute("column2","Email пользователя");
    return "user_list_view";
}




}
