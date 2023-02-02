package ua.com.testing.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "testhasorder")

public class Testhasorder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne
    @JoinColumn(name = "test_Id")
    private Test test;
    @ManyToOne
    @JoinColumn(name = "order_Id")
    private Order order;
    private int quantity;
}
