package ua.com.testing.entity;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Attribute {
    private Long Id;
    private String name;
    private String description;
    private String unit;
    private List<Attributehastest> attributehastestList;
}
