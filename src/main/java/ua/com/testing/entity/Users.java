// Пакет, в якому знаходиться клас
package ua.com.testing.entity;

// Імпорт необхідних пакетів
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

// Анотації Lombok для генерації геттерів, сеттерів, конструкторів та методу toString()
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

// Анотація JPA для позначення класу як сутності бази даних
@Entity
// Анотація JPA для вказівки назви таблиці
@Table(name = "users")
// Клас Users реалізує інтерфейс UserDetails
public class Users implements UserDetails {
    // Поле для унікального ідентифікатора
    @Id
    // Анотація JPA для генерації значення ідентифікатора автоматично
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Поле для імені користувача з вимогою мінімальної довжини 4 символи
    @Size(min=4)
    private String username;
    // Поле для пароля користувача з вимогою мінімальної довжини 4 символи
    @Size(min=4)
    private String password;

    // Поле для збереження ролей користувача (багато до багатьох з таблицею Roles)
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Roles> roles;

    // Конструктор класу
    public Users(String username, String password, Set<Roles> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    // Перевизначені методи інтерфейсу UserDetails

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}


