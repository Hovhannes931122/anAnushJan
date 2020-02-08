package com.example.common.repository;

import com.example.common.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ImageRepository extends JpaRepository<Image, Long> {

    List<Image> findAllByProductsId(long products_id);
}
