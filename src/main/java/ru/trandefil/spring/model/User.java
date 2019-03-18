package ru.trandefil.spring.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User extends AbstractEntity {

    private String name;

    private String password;

    private Role role;

    public User(String id, String name, String password, Role role) {
        super(id);
        this.name = name;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", id='" + id + '\'' +
                '}';
    }

}
