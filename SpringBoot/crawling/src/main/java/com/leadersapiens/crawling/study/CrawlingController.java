package com.leadersapiens.crawling.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//crawling Controller
@RestController
@RequestMapping("/crawling")
public class CrawlingController {

    @Autowired
    private CrawlingService service;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String getData() {


        return service.getData();
    }
}
