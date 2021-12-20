package com.example.kkalanhw2.dao;

import com.example.kkalanhw2.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category, Long> {
}
