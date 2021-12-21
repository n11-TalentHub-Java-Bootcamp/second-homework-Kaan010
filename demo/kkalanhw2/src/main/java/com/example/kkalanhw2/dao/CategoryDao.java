package com.example.kkalanhw2.dao;

import com.example.kkalanhw2.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CategoryDao extends JpaRepository<Category, Long> {
    List<Category> findAllByParentLevelIsNullOrderByNameDesc();

    List<Category> findAllByNameEndsWith(String adi);
}
