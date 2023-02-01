package ua.com.testing.entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Attributehastest {
    private Long Id;
    private Attribute attribute;
    private Test test;
}
