package ua.com.testing.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "testhasquestion")

public class Testhasquestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne
    @JoinColumn(name = "test_Id_1")
    private Test test;
    @ManyToOne
    @JoinColumn(name = "question_Id")
    private Question question;
    private int quantity;
}
