package de.ait;

import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
//@NoArgsConstructor
@ToString
@Builder
@Getter
@Setter
@EqualsAndHashCode(of={"name"})
@Data
@NonNull
public class Person {


    private final String name;
    private int age;
    private String cod;

}
