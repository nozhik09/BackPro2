package de.aittr.demo.controller;

import de.aittr.demo.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @GetMapping("/users")
public List<User> getAllUsers(){
return List.of(
        new User("Jack","dasdas@ds.dsa"),
        new User("John","dasdadsss@ds.dsa")

);


}



}
