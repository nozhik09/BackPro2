package de.aittr.demo1.controller;

import de.aittr.demo1.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRestController {
    private static List<User> serviceGetUser;


static {
    serviceGetUser = List.of(
            new User("Jack","jack@mai.com"),
            new User("Benn","benn@mail.com"),
            new User("Vasya","vasya@mail.com")
    );

}

@GetMapping("/api/user")
public List<User> getAllList(){
    return serviceGetUser;
}




}
