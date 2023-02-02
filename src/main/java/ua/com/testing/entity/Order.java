package ua.com.testing.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "orders")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Date datatest;
    private Date datatime;
    private String image;
    @ManyToOne
    @JoinColumn(name = "student_Id")
    private Student student;
    @OneToMany(mappedBy = "order")
    private List<Testhasorder> testhasorderList;


}
