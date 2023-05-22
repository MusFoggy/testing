// Пакет, в якому знаходиться клас Test
package ua.com.testing.entity;

// Імпорт необхідних класів
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;

// Анотація, що позначає клас як сутність (Entity)
@Entity
// Анотація, що вказує на ім'я таблиці, пов'язаної з класом
@Table(name = "test")
// Анотації для автоматичної генерації методів getter і setter
@Getter
@Setter
// Анотація для автоматичної генерації конструктора без аргументів
@NoArgsConstructor
// Анотація для автоматичної генерації конструктора з усіма аргументами
@AllArgsConstructor
// Клас, що представляє тест
public class Test {
    // Анотація, що вказує на поле як первинний ключ
    @Id
    // Анотація, що вказує на автоматичне генерування значення первинного ключа
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Поле для зберігання ідентифікатора тесту
    private Long id;

    // Поля для назви тесту, опису, кількості балів та зображення
    private String name;
    private String description;
    private BigDecimal points;
    private String image;

    // Анотація, що вказує на зв'язок багато-до-одного з сутністю Category через зовнішній ключ category_Id
    @ManyToOne
    @JoinColumn(name = "category_Id")
    private Category category;

    // Анотація, що вказує на зв'язок один-до-багатьох з сутністю Testhasquestion через поле test
    // Автоматичне видалення пов'язаних об'єктів здійснюється засобами каскадного видалення (CascadeType.REMOVE)
    @OneToMany(mappedBy = "test", cascade = CascadeType.REMOVE)
    private List<Testhasquestion> testhasquestionList;

    // Анотація, що вказує на зв'язок один-до-багатьох з сутністю Question через поле test
    // Автоматичне видалення пов'язаних об'єктів здійснюється засобами каскадного видалення (CascadeType.REMOVE)
    @OneToMany(mappedBy = "test", cascade = CascadeType.REMOVE)
    private List<Question> questions;

    // Перевизначений метод toString() для отримання рядкового представлення об'єкту Test
    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", points=" + points +
                ", image='" + image + '\'' +
                ", category=" + (category != null ? category.getId() : "null") +
                '}';
    }
}

