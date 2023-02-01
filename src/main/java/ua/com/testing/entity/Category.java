package ua.com.testing.entity;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Category {
    private Long id;
    private String name;
    private String description;
    private String image;
    private List <Test> testList;
}
