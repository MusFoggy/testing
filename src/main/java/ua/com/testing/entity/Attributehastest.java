package ua.com.testing.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "attributehastest")

public class Attributehastest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne
    @JoinColumn(name = "attribute_Id")
    private Attribute attribute;
    @ManyToOne
    @JoinColumn(name = "test_Id")
    private Test test_2;
}
