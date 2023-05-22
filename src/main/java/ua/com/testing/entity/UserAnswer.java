// Пакет, в якому знаходиться клас
package ua.com.testing.entity;

// Імпорт необхідних класів
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

// Анотації для автоматичного генерації коду
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
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Question question;

    @Column(name = "answer")
    private String answer;
}

