package ua.com.testing.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "test")

public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private BigDecimal points;
    private String image;
    @ManyToOne
    @JoinColumn(name = "category_Id")
    private Category category;
    @OneToMany(mappedBy = "test")
    private List<Testhasorder> testhasorder;
    @OneToMany(mappedBy = "test_2")
    private List<Attributehastest> attributehastestList;
}
