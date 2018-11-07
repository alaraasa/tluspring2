package com.aasa.tluspring.Hello;

import lombok.Data;

@Data
public class Hello {
    private String name;

    public String say() {
        return "Hello, "  + name;
    }
}
