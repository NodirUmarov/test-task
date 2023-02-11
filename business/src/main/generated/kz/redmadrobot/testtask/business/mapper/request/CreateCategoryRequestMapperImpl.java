package kz.redmadrobot.testtask.business.mapper.request;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kz.redmadrobot.testtask.business.model.request.CreateCategoryRequest;
import kz.redmadrobot.testtask.dao.entity.ad.Category;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-11T13:19:35+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class CreateCategoryRequestMapperImpl implements CreateCategoryRequestMapper {

    @Override
    public Category toEntity(CreateCategoryRequest arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Category.CategoryBuilder category = Category.builder();

        category.name( arg0.getName() );

        return category.build();
    }

    @Override
    public List<Category> toEntityList(List<CreateCategoryRequest> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<Category> list = new ArrayList<Category>( arg0.size() );
        for ( CreateCategoryRequest createCategoryRequest : arg0 ) {
            list.add( toEntity( createCategoryRequest ) );
        }

        return list;
    }
}
