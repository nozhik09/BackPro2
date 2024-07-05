package de.aittr.demo.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


@Data
@AllArgsConstructor
public class User {

    private String name;
    private String email;
}
