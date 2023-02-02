package ua.com.testing.entity;

import jakarta.persistence.*;
import lombok.*;
import org.aspectj.weaver.ast.Or;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "student")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    @OneToOne
    @MapKey
    @MapsId
    @JoinColumn(name = "Id")
    private Users users;
    @OneToMany(mappedBy = "student")
    private List<Order> orderList;
}
