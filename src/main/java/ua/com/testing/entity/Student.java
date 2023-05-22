// Пакет, в якому знаходиться клас
package ua.com.testing.entity;

// Імпорт необхідних класів
import jakarta.persistence.*;
import lombok.*;
import org.aspectj.weaver.ast.Or;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

// Анотація, що позначає клас як сутність бази даних
@Entity

// Анотація, що вказує на назву таблиці, в якій буде зберігатися об'єкт
@Table(name = "student")
public class Student {
    // Анотація, що позначає поле як ідентифікатор
    @Id

    // Анотація, що вказує на спосіб генерації значення ідентифікатора
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Поля класу
    private String name;
    private String surname;
    private String email;

    // Анотація, що вказує на відношення один до одного з сутністю Users
    @OneToOne

    // Анотація, що вказує на спільне використання ідентифікатора з сутністю Users
    @MapsId

    // Анотація, що вказує на зв'язок зовнішнього ключа
    @JoinColumn(name = "Id")
    private Users users;

    // Конструктори класу
    public Student(String name, String surname, String email, Users users) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.users = users;
    }
}


