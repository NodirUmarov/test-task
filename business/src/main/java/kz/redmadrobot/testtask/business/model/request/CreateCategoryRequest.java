package kz.redmadrobot.testtask.business.model.request;

import lombok.Data;

@Data
public class CreateCategoryRequest {
    private String name;
    private Long parentCategoryId;
}