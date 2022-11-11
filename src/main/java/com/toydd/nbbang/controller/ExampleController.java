package com.toydd.nbbang.controller;

import com.toydd.nbbang.service.ExampleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/test/api")
public class ExampleController {
    private ExampleService exampleService;
    // https://milenote.tistory.com/67
    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @GetMapping("/example")
        public Flux getExample() {
        System.out.println("start");
        String s = exampleService.getSampleExample1();
        System.out.println(s);

        Flux examples = Flux.just(exampleService.getSampleExample1(),
                        exampleService.getSampleExample2(),
                        exampleService.getSampleExample3(),
                        exampleService.getSampleExample4())
                        .doOnNext(el -> System.out.println("getExample : " + el));

        return examples;
    }
}
