package kr.sooragenius.toy.changer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CurrencyController {
    @RequestMapping(value = {"/", ""})
    public String index() {
        return "index";
    }
}
