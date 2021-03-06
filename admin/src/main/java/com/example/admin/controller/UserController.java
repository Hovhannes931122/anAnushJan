package com.example.admin.controller;


import com.example.admin.security.CurrentUser;
import com.example.common.model.Product;
import com.example.common.model.User;
import com.example.common.service.CategoryService;
import com.example.common.service.EmailService;
import com.example.common.service.ProductService;
import com.example.common.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/users")
public class UserController {

    private final ProductService productService;

    private final UserService userService;

    private final CategoryService categoryService;


    @Value("${image.upload.dir}")
    private String imageUploadDir;

    private final EmailService emailService;

    public UserController(ProductService productService, EmailService emailService, UserService userService, CategoryService categoryService) {
        this.productService = productService;
        this.emailService = emailService;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @GetMapping("/register")
    public String register(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {
        if(currentUser != null) {
            modelMap.addAttribute("user", currentUser.getUser());
        }
        return "form-elemnents";
    }

    @PostMapping("/register")
    public String registerPost(@ModelAttribute User user) {
        if (userService.isEmailExists(user.getEmail())) {
            userService.save(user);
            return "redirect:/boxed-layout";
        }
        return "redirect:/form-elements";
    }

    @GetMapping("/activate")
    public String activate(@RequestParam("token") String token) {
        userService.activate(token);
        return "redirect:/boxed-layout";
    }


    //find all users
    @GetMapping("/allUsers")
    public String findAll(ModelMap modelMap){
        List<User> all = userService.findAll();
        modelMap.addAttribute("all",all);
        return "data-table-user";
    }

    @DeleteMapping("/deleteById")
    public String deleteById(@RequestParam("id") long id){
        userService.deleteById(id);
        return "redirect:/data-table-user";
    }
}
