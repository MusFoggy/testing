// Пакет, в якому знаходиться клас
package ua.com.testing.entity;

// Імпорт необхідних класів
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthoritiesContainer;

import java.util.Collection;
import java.util.Set;

// Анотації Lombok для автоматичного генерації коду
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

// Анотація, що вказує, що цей клас є сутністю JPA
@Entity
// Вказує назву таблиці в базі даних, з якою асоціюється цей клас
@Table(name = "fix_role")
public class Roles implements GrantedAuthority {
    // Поле, яке є первинним ключем у таблиці
    @Id
    // Вказує спосіб генерації значення для цього поля
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Поле з назвою ролі
    private String name;

    // Відношення багато-до-багатьох між класами Roles і Users
    // Вказує, що це поле є зворотнім (mappedBy) для поля roles у класі Users
    @ToString.Exclude
    @ManyToMany(mappedBy = "roles")
    private Set<Users> usersSet;

    // Реалізація методу з інтерфейсу GrantedAuthority
    // Повертає назву ролі в якості авторитету
    @Override
    public String getAuthority() {
        return getName();
    }
}

