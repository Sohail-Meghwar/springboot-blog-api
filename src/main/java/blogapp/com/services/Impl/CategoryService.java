package blogapp.com.services.Impl;

import java.util.List;

import blogapp.com.payloads.CategoryDto;

public interface CategoryService {

    // create
    public CategoryDto createCategory(CategoryDto categoryDto);

    // update
     CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    
    // delete
     void deleteCategory(Integer categoryId);

    // get single category
    CategoryDto getCategoryById(Integer categoryId);

    // get all category
     List<CategoryDto> getAllCategories();
    
}
