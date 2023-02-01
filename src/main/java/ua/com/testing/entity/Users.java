package ua.com.testing.entity;

import lombok.*;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Users {
    private Long id;
    private String username;
    private String password;
    private Set<Roles> rolesSet;
}
