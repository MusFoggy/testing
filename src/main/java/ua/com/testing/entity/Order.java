package ua.com.testing.entity;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Order {
    private Long Id;
    private Data datatest;
    private Data datatime;
    private String image;
    private Student student;
    private List<Testhasorder> testhasorderList;

}
