package ua.com.testing.entity;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString


public class Test {
    private Long id;
    private String name;
    private String description;
    private BigDecimal points;
    private String image;
    private Category category;
    private List<Testhasorder> testhasorderList;
    private List<Attributehastest> attributehastestList;
}
