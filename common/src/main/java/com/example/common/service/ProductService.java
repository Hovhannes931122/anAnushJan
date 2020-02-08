package com.example.common.service;

import com.example.common.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    List<Product> findAll();
    List<Product> findAllByCategory(String title);
    List<Product> findAllByMaterials(String materials_title);
    Product findById(long id);
    Page<Product> findByPageable(Pageable pageable);
    void save(Product product);
    void deleteById(long id);
    Product createProduct(MultipartFile [] multipartFile, double height, double width, List<Long> materials,
                          Product product, String answer, Category category,String title,String desc,int count,User user);
    List<Product>addProducts(List<Long> products);

    List<Product> findAllByUserId(long id);

    List<Product> findAllByName(String keyword);

    void save(Product product, MultipartFile[] multipartFile, long category_id);
}
