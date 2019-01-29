package ftc.shift.scheduler.controller;

import ftc.shift.scheduler.models.Category;
import ftc.shift.scheduler.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class CategoryController {

    private static final String CATEGORY_PATH = Resources.CATEGORY_PREFIX;

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public CategoryService getCategoryService() {
        return categoryService;
    }

    @CrossOrigin
    @GetMapping(CATEGORY_PATH)
    public @ResponseBody
    BaseResponse<Collection<Category>> provideAllCategories() {

        return new BaseResponse<>(categoryService.provideCategories());
    }

    @CrossOrigin
    @PostMapping(CATEGORY_PATH)
    public @ResponseBody
    BaseResponse<Category> createCategory(@RequestBody Category category) {

        return new BaseResponse<>(categoryService.createCategory(category));
    }

    @CrossOrigin
    @DeleteMapping(CATEGORY_PATH + "/{idCategory}")
    public @ResponseBody
    BaseResponse deleteCategory(@PathVariable(name = "idCategory") String idCategory) {

        return new BaseResponse<>(categoryService.deleteCategory(idCategory));
    }
}