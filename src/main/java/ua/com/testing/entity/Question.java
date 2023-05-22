// Пакет, в якому знаходиться клас Question
package ua.com.testing.entity;

// Імпорт необхідних класів
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

// Анотація, що позначає клас Question як сутність для зберігання в базі даних
@Entity

// Назва таблиці, в якій будуть зберігатися дані про питання
@Table(name = "questions")
public class Question {

    // Конструктор класу Question
    public Question(String text, Test test) {
        this.text = text;
        this.test = test;
    }

    // Анотація, що позначає поле id як первинний ключ
    @Id

    // Анотація, що вказує на автоматичне генерування значення id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Поле, що зберігає текст питання
    private String text;

    // Анотація, що позначає зв'язок "багато до одного" з класом Test
    @ManyToOne

    // Анотація, що вказує на зовнішній ключ test_id
    @JoinColumn(name = "test_id")
    private Test test;

    // Перевизначений метод toString(), який повертає текст питання
    @Override
    public String toString() {
        return text;
    }
}

