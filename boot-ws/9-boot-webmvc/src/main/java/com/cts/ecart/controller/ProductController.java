package com.cts.ecart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
@RequestMapping(value = "/products")
public class ProductController {

    @RequestMapping(value = "/s1")
    public void f1(){
        System.out.println(">>>> ProductController :: f1 method");
    }

    @RequestMapping(value = "/s2")
    public String f2(){
        System.out.println(">>>> ProductController :: f2 method");
        // view ...
        return "one"; // one is the view name

    }
    @RequestMapping(value = "/s3")
    public String f3(Model model){
        model.addAttribute("user","Admin");
        model.addAttribute("city","London");
        model.addAttribute("date", LocalDate.now());
        return "two"; // one is the view name
    }
    // or

    @GetMapping(value = "/loadData")
    public ModelAndView f4(){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("display");
        mav.addObject("name","Praveen");
        mav.addObject("info","Information for something...");
        return  mav;
    }

    // using modelMap

    @GetMapping(value = "/getData")
    public String f5(ModelMap map){
        map.put("productName","Dell Laptop");
        map.put("price",450000);
        return "product";
    }

    @GetMapping(value = "/info")
    @ResponseBody
    public String showMessage(){
        String template="<div> <p>Name: </p> <p>City: </p></div>";
        return template;
    }

}
