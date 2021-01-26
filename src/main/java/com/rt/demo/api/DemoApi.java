package com.rt.demo.api;

import com.rt.demo.service.DemoService;
import com.rt.model.Response;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("点击")
@RequestMapping("/test")
@Validated
@RestController
public class DemoApi {

    @Autowired
    DemoService demoService;

    @GetMapping("/")
    public Response click() {
        demoService.insert();
        return Response.success("成功");
    }
}