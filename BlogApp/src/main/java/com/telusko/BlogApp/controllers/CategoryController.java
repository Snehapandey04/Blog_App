package com.telusko.BlogApp.controllers;


import com.telusko.BlogApp.payloads.ApiResponse;
import com.telusko.BlogApp.payloads.CategoryDto;
import com.telusko.BlogApp.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
@Autowired
    private CategoryService categoryService;
@PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){

    CategoryDto createCategoryDto = this.categoryService.createCategory(categoryDto);
    return new ResponseEntity<>(createCategoryDto, HttpStatus.CREATED);

    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto , @PathVariable("categoryId") Integer catId) {

        CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto,catId);
        return  ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("categoryId") Integer catId){
        this.categoryService.deleteCategory(catId);
        return new  ResponseEntity(new ApiResponse("Category is  deleted Successfully" , true), HttpStatus.OK);
}

    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getCategories(){
   // List<CategoryDto> categories = this.categoryService.getCategories();

        return  ResponseEntity.ok(this.categoryService.getCategories());

    }
    @GetMapping("/{catId}")
    public ResponseEntity<CategoryDto>getSingleCategory(@PathVariable Integer categoryId){
  //  CategoryDto categoryDto = this.categoryService.getCategory(catId);

        return  ResponseEntity.ok(this.categoryService.getCategory(categoryId));

    }






}
