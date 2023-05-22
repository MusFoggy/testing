// Підключення необхідних пакетів
package ua.com.testing.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category")
public class Category {
    // Поле, що є унікальним ідентифікатором категорії
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Поле з назвою категорії
    private String name;
    // Поле з описом категорії
    private String description;
    // Поле з посиланням на зображення категорії
    private String image;
    // Поле зі списком тестів, що належать до цієї категорії
    @OneToMany(mappedBy = "category")
    private List<Test> testList;

    // Перевизначений метод toString для повернення назви категорії
    @Override
    public String toString() {
        return name;
    }
}
