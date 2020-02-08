package com.example.admin.controller;

import com.example.common.model.ProductCategory;
import com.example.common.service.ProductCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/admin/materialCategories")
@Controller
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }


    @PostMapping("/addMaterialCategory")
    public String addMaterialCategory(ProductCategory productCategory) {
        productCategoryService.addCategory(productCategory);
        return "redirect:/boxed-layout";
    }

    @DeleteMapping("/deleteById")
    public String deleteById(@RequestParam("id") long id){
        productCategoryService.deleteById(id);
        return "redirect:/boxed-layout";
    }
}
