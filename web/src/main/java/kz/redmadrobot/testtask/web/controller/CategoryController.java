package kz.redmadrobot.testtask.web.controller;

import kz.redmadrobot.testtask.business.model.dto.ad.CategoryDto;
import kz.redmadrobot.testtask.business.model.request.CreateCategoryRequest;
import kz.redmadrobot.testtask.business.service.CategoryService;
import kz.redmadrobot.testtask.web.assembler.CategoryAssembler;
import kz.redmadrobot.testtask.web.model.CategoryResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryAssembler categoryAssembler;

    @PostMapping
    public ResponseEntity<CategoryResource> create(@RequestBody CreateCategoryRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(categoryAssembler.toModel(categoryService.create(request)));
    }

}
