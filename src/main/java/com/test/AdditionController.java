package com.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdditionController {

    @RequestMapping(method = { RequestMethod.GET }, value = { "/sum" })
    public Integer getSum(Integer value1, Integer value2) {
        return value1+value2;
    }
}
