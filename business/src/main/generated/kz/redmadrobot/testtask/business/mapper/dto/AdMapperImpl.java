package kz.redmadrobot.testtask.business.mapper.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.processing.Generated;
import kz.redmadrobot.testtask.business.model.dto.ad.AdDto;
import kz.redmadrobot.testtask.business.model.dto.ad.CategoryDto;
import kz.redmadrobot.testtask.business.model.dto.enums.AdStatusDto;
import kz.redmadrobot.testtask.business.model.dto.user.UserDto;
import kz.redmadrobot.testtask.dao.entity.ad.Ad;
import kz.redmadrobot.testtask.dao.entity.enums.AdStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-11T13:03:43+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class AdMapperImpl implements AdMapper {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public AdDto toDto(Ad arg0) {
        if ( arg0 == null ) {
            return null;
        }

        String title = null;
        String description = null;
        BigDecimal minimalPrice = null;
        AdStatusDto adStatus = null;
        CategoryDto category = null;
        byte[] imageData = null;
        UserDto createdBy = null;
        LocalDateTime createdDate = null;

        title = arg0.getTitle();
        description = arg0.getDescription();
        minimalPrice = arg0.getMinimalPrice();
        adStatus = adStatusToAdStatusDto( arg0.getAdStatus() );
        category = categoryMapper.toDto( arg0.getCategory() );
        byte[] imageData1 = arg0.getImageData();
        if ( imageData1 != null ) {
            imageData = Arrays.copyOf( imageData1, imageData1.length );
        }
        createdBy = userMapper.toDto( userMapper.toUser( arg0.getCreatedBy() ) );
        createdDate = toLocalDateTime( arg0.getCreatedDate() );

        AdDto adDto = new AdDto( title, description, minimalPrice, adStatus, category, imageData, createdBy, createdDate );

        return adDto;
    }

    @Override
    public List<AdDto> toDtoList(List<Ad> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<AdDto> list = new ArrayList<AdDto>( arg0.size() );
        for ( Ad ad : arg0 ) {
            list.add( toDto( ad ) );
        }

        return list;
    }

    @Override
    public Ad toEntity(AdDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Ad.AdBuilder ad = Ad.builder();

        ad.title( arg0.title() );
        ad.description( arg0.description() );
        ad.minimalPrice( arg0.minimalPrice() );
        ad.adStatus( adStatusDtoToAdStatus( arg0.adStatus() ) );
        ad.category( categoryMapper.toEntity( arg0.category() ) );
        byte[] imageData = arg0.imageData();
        if ( imageData != null ) {
            ad.imageData( Arrays.copyOf( imageData, imageData.length ) );
        }

        return ad.build();
    }

    @Override
    public List<Ad> toEntityList(List<AdDto> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<Ad> list = new ArrayList<Ad>( arg0.size() );
        for ( AdDto adDto : arg0 ) {
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
}
