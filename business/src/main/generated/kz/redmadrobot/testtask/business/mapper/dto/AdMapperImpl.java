package kz.redmadrobot.testtask.business.mapper.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.processing.Generated;
import kz.redmadrobot.testtask.business.model.dto.ad.AdDto;
import kz.redmadrobot.testtask.business.model.dto.ad.CategoryDto;
import kz.redmadrobot.testtask.business.model.dto.enums.AdStatusDto;
import kz.redmadrobot.testtask.dao.entity.ad.Ad;
import kz.redmadrobot.testtask.dao.entity.ad.Category;
import kz.redmadrobot.testtask.dao.entity.enums.AdStatus;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-11T05:09:17+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class AdMapperImpl implements AdMapper {

    @Override
    public AdDto toDto(Ad entity) {
        if ( entity == null ) {
            return null;
        }

        String title = null;
        String description = null;
        BigDecimal minimalPrice = null;
        AdStatusDto adStatus = null;
        CategoryDto category = null;
        byte[] imageData = null;

        title = entity.getTitle();
        description = entity.getDescription();
        minimalPrice = entity.getMinimalPrice();
        adStatus = adStatusToAdStatusDto( entity.getAdStatus() );
        category = categoryToCategoryDto( entity.getCategory() );
        byte[] imageData1 = entity.getImageData();
        if ( imageData1 != null ) {
            imageData = Arrays.copyOf( imageData1, imageData1.length );
        }

        AdDto adDto = new AdDto( title, description, minimalPrice, adStatus, category, imageData );

        return adDto;
    }

    @Override
    public List<AdDto> toDtoList(List<Ad> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AdDto> list = new ArrayList<AdDto>( entityList.size() );
        for ( Ad ad : entityList ) {
            list.add( toDto( ad ) );
        }

        return list;
    }

    @Override
    public Ad toEntity(AdDto dto) {
        if ( dto == null ) {
            return null;
        }

        Ad.AdBuilder ad = Ad.builder();

        ad.title( dto.title() );
        ad.description( dto.description() );
        ad.minimalPrice( dto.minimalPrice() );
        ad.adStatus( adStatusDtoToAdStatus( dto.adStatus() ) );
        ad.category( categoryDtoToCategory( dto.category() ) );
        byte[] imageData = dto.imageData();
        if ( imageData != null ) {
            ad.imageData( Arrays.copyOf( imageData, imageData.length ) );
        }

        return ad.build();
    }

    @Override
    public List<Ad> toEntityList(List<AdDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Ad> list = new ArrayList<Ad>( dtoList.size() );
        for ( AdDto adDto : dtoList ) {
            list.add( toEntity( adDto ) );
        }

        return list;
    }

    protected AdStatusDto adStatusToAdStatusDto(AdStatus adStatus) {
        if ( adStatus == null ) {
            return null;
        }

        AdStatusDto adStatusDto;

        switch ( adStatus ) {
            case ACTIVE: adStatusDto = AdStatusDto.ACTIVE;
            break;
            case WITHDRAWN: adStatusDto = AdStatusDto.WITHDRAWN;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + adStatus );
        }

        return adStatusDto;
    }

    protected CategoryDto categoryToCategoryDto(Category category) {
        if ( category == null ) {
            return null;
        }

        String name = null;
        CategoryDto parentCategory = null;

        name = category.getName();
        parentCategory = categoryToCategoryDto( category.getParentCategory() );

        CategoryDto categoryDto = new CategoryDto( name, parentCategory );

        return categoryDto;
    }

    protected AdStatus adStatusDtoToAdStatus(AdStatusDto adStatusDto) {
        if ( adStatusDto == null ) {
            return null;
        }

        AdStatus adStatus;

        switch ( adStatusDto ) {
            case ACTIVE: adStatus = AdStatus.ACTIVE;
            break;
            case WITHDRAWN: adStatus = AdStatus.WITHDRAWN;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + adStatusDto );
        }

        return adStatus;
    }

    protected Category categoryDtoToCategory(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        Category.CategoryBuilder category = Category.builder();

        category.name( categoryDto.name() );
        category.parentCategory( categoryDtoToCategory( categoryDto.parentCategory() ) );

        return category.build();
    }
}
