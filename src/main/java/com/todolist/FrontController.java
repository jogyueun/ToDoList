package com.todolist;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontController {

    private final ToDoService toDoService;

    public FrontController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }


    @GetMapping({"", "/"})
    public String home(Model model) {
        model.addAttribute("todoList", toDoService.findAll());
        System.out.print(toDoService.findAll());
        return "home";
    }
}
