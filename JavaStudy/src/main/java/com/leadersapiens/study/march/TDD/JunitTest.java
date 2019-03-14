package com.leadersapiens.study.march.TDD;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class JunitTest {
    private String name;
    private int age;
    private float tall;
}
