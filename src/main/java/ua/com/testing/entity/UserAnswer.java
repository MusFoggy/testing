package ua.com.testing.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "user_answers")
public class UserAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "user_answers_test_id")
    private Test test;

    @ManyToOne
    @JoinColumn(name = "user_answers_question_id")
    private Question question;

    @Column(name = "answer")
    private String answer;
}

