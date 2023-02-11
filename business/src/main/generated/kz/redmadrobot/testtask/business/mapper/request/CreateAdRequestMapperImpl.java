package kz.redmadrobot.testtask.business.mapper.request;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.processing.Generated;
import kz.redmadrobot.testtask.business.model.request.CreateAdRequest;
import kz.redmadrobot.testtask.dao.entity.ad.Ad;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-11T13:03:43+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class CreateAdRequestMapperImpl implements CreateAdRequestMapper {

    @Override
    public Ad toEntity(CreateAdRequest arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Ad.AdBuilder ad = Ad.builder();

        ad.title( arg0.getTitle() );
        ad.description( arg0.getDescription() );
        ad.minimalPrice( arg0.getMinimalPrice() );
        byte[] imageData = arg0.getImageData();
        if ( imageData != null ) {
            ad.imageData( Arrays.copyOf( imageData, imageData.length ) );
        }

        return ad.build();
    }

    @Override
    public List<Ad> toEntityList(List<CreateAdRequest> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<Ad> list = new ArrayList<Ad>( arg0.size() );
        for ( CreateAdRequest createAdRequest : arg0 ) {
            list.add( toEntity( createAdRequest ) );
        }

        return list;
    }
}
