package kz.redmadrobot.testtask.business.mapper.dto;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kz.redmadrobot.testtask.business.model.dto.ad.CategoryDto;
import kz.redmadrobot.testtask.dao.entity.ad.Category;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-11T05:09:16+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDto toDto(Category entity) {
        if ( entity == null ) {
            return null;
        }

        String name = null;
        CategoryDto parentCategory = null;

        name = entity.getName();
        parentCategory = categoryToCategoryDto( entity.getParentCategory() );

        CategoryDto categoryDto = new CategoryDto( name, parentCategory );

        return categoryDto;
    }

    @Override
    public List<CategoryDto> toDtoList(List<Category> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CategoryDto> list = new ArrayList<CategoryDto>( entityList.size() );
        for ( Category category : entityList ) {
            list.add( toDto( category ) );
        }

        return list;
    }

    @Override
    public Category toEntity(CategoryDto dto) {
        if ( dto == null ) {
            return null;
        }

        Category.CategoryBuilder category = Category.builder();

        category.name( dto.name() );
        category.parentCategory( categoryDtoToCategory( dto.parentCategory() ) );

        return category.build();
    }

    @Override
    public List<Category> toEntityList(List<CategoryDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Category> list = new ArrayList<Category>( dtoList.size() );
        for ( CategoryDto categoryDto : dtoList ) {
            list.add( toEntity( categoryDto ) );
        }

        return list;
    }

    protected CategoryDto categoryToCategoryDto(Category category) {
        if ( category == null ) {
            return null;
        }

        String name = null;
        CategoryDto parentCategory = null;

        name = category.getName();
        parentCategory = toDto( category.getParentCategory() );

        CategoryDto categoryDto = new CategoryDto( name, parentCategory );

        return categoryDto;
    }

    protected Category categoryDtoToCategory(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        Category.CategoryBuilder category = Category.builder();

        category.name( categoryDto.name() );
        category.parentCategory( toEntity( categoryDto.parentCategory() ) );

        return category.build();
    }
}
