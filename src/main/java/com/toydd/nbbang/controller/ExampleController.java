package com.toydd.nbbang.controller;

import com.toydd.nbbang.model.request.ExampleSaveDto;
import com.toydd.nbbang.service.ExampleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@Api(tags = "example")
@RestController
@RequestMapping("/test/api")
public class ExampleController {
    private ExampleService exampleService;
    // https://milenote.tistory.com/67
    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @Operation(summary = "example")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "ok"),
            @ApiResponse(responseCode = "400", description = "bad request"),
            @ApiResponse(responseCode = "500", description = "server error")
    })
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

    @Operation(summary = "example")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "exampleId", paramType = "", required = true, dataTypeClass = String.class, example = "")
    })
    @PutMapping("/examples/{exampleId}")
    public void update(@PathVariable Long exampleId,
                       @RequestBody ExampleSaveDto body) {
    }
}
// 12345
