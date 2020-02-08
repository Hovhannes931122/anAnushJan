package com.example.common.service;

import com.example.common.model.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    List<ProductCategory> findAll();
    void addCategory(ProductCategory productCategory);

    void deleteById(long id);
}
