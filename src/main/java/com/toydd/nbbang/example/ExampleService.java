package com.toydd.nbbang.example;

import org.springframework.stereotype.Service;

@Service
public class ExampleService {

    public String getSampleExample1() {
        System.out.println("e1");
        return "Example1";
    }

    public String getSampleExample2() {
        return "Example2";
    }

    public String getSampleExample3() {
        return "Example3";
    }

    public String getSampleExample4() {
        return "Example4";
    }
}