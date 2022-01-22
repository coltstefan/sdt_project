package com.example.demo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class StringEncap {

    String name;

    public StringEncap(String name) {
        this.name = name;
    }
}
