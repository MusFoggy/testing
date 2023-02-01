package ua.com.testing.entity;

import lombok.*;
import org.aspectj.weaver.ast.Or;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Student {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private Users users;
    private List<Order> orderList;
}
