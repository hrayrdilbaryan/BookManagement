package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Registration {

    private String name;
    private String surname;
    private int years;
    private String login;
    private String password;


}
