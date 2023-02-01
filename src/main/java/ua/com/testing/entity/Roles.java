package ua.com.testing.entity;

import lombok.*;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Roles {
    private Long id;
    private String name;
    private Set<Users> usersSet;
}
