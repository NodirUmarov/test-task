package kz.redmadrobot.testtask.business.mapper.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.processing.Generated;
import kz.redmadrobot.testtask.business.model.dto.ad.AdDto;
import kz.redmadrobot.testtask.business.model.dto.ad.BetDto;
import kz.redmadrobot.testtask.business.model.dto.ad.CategoryDto;
import kz.redmadrobot.testtask.business.model.dto.enums.AdStatusDto;
import kz.redmadrobot.testtask.business.model.dto.user.UserDto;
import kz.redmadrobot.testtask.dao.entity.ad.Ad;
import kz.redmadrobot.testtask.dao.entity.ad.Bet;
import kz.redmadrobot.testtask.dao.entity.ad.Category;
import kz.redmadrobot.testtask.dao.entity.enums.AdStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-11T13:03:43+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class BetMapperImpl implements BetMapper {

    @Autowired
    private UserMapper userMapper;

    @Override
    public BetDto toDto(Bet arg0) {
        if ( arg0 == null ) {
            return null;
        }

        AdDto ad = null;
        BigDecimal offeredPrice = null;
        Boolean isPrimary = null;

        ad = adToAdDto( arg0.getAd() );
        offeredPrice = arg0.getOfferedPrice();
        isPrimary = arg0.getIsPrimary();

        BetDto betDto = new BetDto( ad, offeredPrice, isPrimary );

        return betDto;
    }

    @Override
    public List<BetDto> toDtoList(List<Bet> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<BetDto> list = new ArrayList<BetDto>( arg0.size() );
        for ( Bet bet : arg0 ) {
            list.add( toDto( bet ) );
        }

        return list;
    }

    @Override
    public Bet toEntity(BetDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Bet.BetBuilder bet = Bet.builder();

        bet.ad( adDtoToAd( arg0.ad() ) );
        bet.offeredPrice( arg0.offeredPrice() );
        bet.isPrimary( arg0.isPrimary() );

        return bet.build();
    }

    @Override
    public List<Bet> toEntityList(List<BetDto> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<Bet> list = new ArrayList<Bet>( arg0.size() );
        for ( BetDto betDto : arg0 ) {
            list.add( toEntity( betDto ) );
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

    protected AdDto adToAdDto(Ad ad) {
        if ( ad == null ) {
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

        title = ad.getTitle();
        description = ad.getDescription();
        minimalPrice = ad.getMinimalPrice();
        adStatus = adStatusToAdStatusDto( ad.getAdStatus() );
        category = categoryToCategoryDto( ad.getCategory() );
        byte[] imageData1 = ad.getImageData();
        if ( imageData1 != null ) {
            imageData = Arrays.copyOf( imageData1, imageData1.length );
        }
        createdBy = userMapper.toDto( userMapper.toUser( ad.getCreatedBy() ) );
        createdDate = toLocalDateTime( ad.getCreatedDate() );

        AdDto adDto = new AdDto( title, description, minimalPrice, adStatus, category, imageData, createdBy, createdDate );

        return adDto;
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

    protected Ad adDtoToAd(AdDto adDto) {
        if ( adDto == null ) {
            return null;
        }

        Ad.AdBuilder ad = Ad.builder();

        ad.title( adDto.title() );
        ad.description( adDto.description() );
        ad.minimalPrice( adDto.minimalPrice() );
        ad.adStatus( adStatusDtoToAdStatus( adDto.adStatus() ) );
        ad.category( categoryDtoToCategory( adDto.category() ) );
        byte[] imageData = adDto.imageData();
        if ( imageData != null ) {
            ad.imageData( Arrays.copyOf( imageData, imageData.length ) );
        }

        return ad.build();
    }
}
