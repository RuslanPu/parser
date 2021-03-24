package parser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import parser.service.QueryService;

import java.io.IOException;

@Controller
public class MainController {
    @Autowired
    QueryService service;

    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
    public ModelAndView mainPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("parser");
        return modelAndView;
    }

//    @GetMapping("/search")
//    public ModelAndView queryPage(@RequestParam("searchParam") String query) throws IOException {
//        String mess = service.parsing(query);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("query");
//        modelAndView.addObject("mess",mess);
//        return modelAndView;
//    }
}
