package ua.com.testing.entity;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "questions")
public class Question {
    public Question(String text, Test test) {
        this.text = text;
        this.test = test;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

    @Override
    public String toString() {

        return text;
    }
}
