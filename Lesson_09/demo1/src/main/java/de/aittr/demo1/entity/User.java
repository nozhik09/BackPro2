package de.aittr.demo1.entity;



import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class User {

    private String name;
    private String email;
}
