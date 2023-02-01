package ua.com.testing.entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Testhasorder {
    private Long Id;
    private Test test;
    private Order order;
    private int quantity;
}
