package com.hiddn.users.application;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/users")
@Api(tags = "Hello Controller for Testing")
public class HelloWorldController {

    @GetMapping(path = "/hello")
    @ApiOperation(value = "Getting Hello World Message")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Getting Hello World Message"),
                    @ApiResponse(code = 400, message = "Bad request"),
                    @ApiResponse(code = 500, message = "Something went wrong")
            })
    public String helloWorld() {
        return "Hello World!";
    }

}
