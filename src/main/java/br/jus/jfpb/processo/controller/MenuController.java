package br.jus.jfpb.processo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MenuController {
    @RequestMapping(method = RequestMethod.GET, value = "menu")
    public String menu(ModelMap map){
        return "menu";
    }
}
