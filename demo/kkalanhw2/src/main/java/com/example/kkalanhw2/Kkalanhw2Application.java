package com.example.kkalanhw2;

import com.example.kkalanhw2.entity.Category;
import com.example.kkalanhw2.service.CategoryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class Kkalanhw2Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Kkalanhw2Application.class, args);
        CategoryService service = applicationContext.getBean(CategoryService.class);

        List<Category> categoryList=service.findAll();
        for(Category category:categoryList){
            System.out.println(category.getId());
        }
    }

}
