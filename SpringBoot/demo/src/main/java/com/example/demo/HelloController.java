package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/hoge", method = RequestMethod.GET)
    public String hoge(Model model) {
        Hoge hoge = new Hoge();
        hoge.setId(10);
        hoge.setValue("hoge");

        model.addAttribute("myData", hoge);

        return "hoge";
    }

    @RequestMapping(value = "/hogeList", method = RequestMethod.GET)
    public String hogeLsit(Model model) {

        ArrayList<Hoge> hogeList = new ArrayList<>();
        hogeList.add(new Hoge(10, "hoge1"));
        hogeList.add(new Hoge(20, "hoge2"));
        hogeList.add(new Hoge(30, "hoge3"));

        model.addAttribute("hogeList", hogeList);

        return "hogeList";
    }
}
