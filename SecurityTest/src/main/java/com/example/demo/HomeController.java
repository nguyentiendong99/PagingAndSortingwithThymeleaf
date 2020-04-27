package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private DongService service;
    @RequestMapping("/")
    public String ShowMap(Model model){
        return ListByPages(model , 1);
    }
    @GetMapping("/page/{pageNumber}")
    public String ListByPages(Model model , @PathVariable("pageNumber") int currentPages){
        Page<Dong> page = service.list(currentPages);
        int totalitems = (int) page.getTotalElements();
        int totalpages = page.getTotalPages();
        List<Dong> dong = page.getContent();
        model.addAttribute("currentPages" ,currentPages);
        model.addAttribute("totalitems" ,totalitems);
        model.addAttribute("totalpages" ,totalpages);
        model.addAttribute("dong" , dong);
        return "home";
    }
    @RequestMapping(value = "/new")
    public String New(Model model){
        Dong dong = new Dong() ;
        model.addAttribute("dong" , dong);
        return "new";
    }
    @RequestMapping(value = "/save" , method = RequestMethod.POST )
    public String save(@ModelAttribute("dong") Dong dong){
        service.save(dong);
        return "redirect:/";
    }
    @RequestMapping(value = "/edit/{id}")
    public ModelAndView get(@PathVariable("id") int id){
        ModelAndView model = new ModelAndView("edit");
        Dong dong = service.get(id);
        model.addObject("dong" , dong);
        return model;
    }
    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") int id){
        service.delete(id);
        return "redirect:/";
    }
    @RequestMapping(value = "/search")
    public ModelAndView search(@RequestParam("keyword") String keyword){
        ModelAndView model = new ModelAndView("search");
        List<Dong> dong = service.find(keyword);
        model.addObject("dong" , dong);
        return model;
    }
}
