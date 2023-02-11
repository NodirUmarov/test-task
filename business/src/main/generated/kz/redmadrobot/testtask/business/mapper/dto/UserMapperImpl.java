package kz.redmadrobot.testtask.business.mapper.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kz.redmadrobot.testtask.business.model.dto.user.UserDto;
import kz.redmadrobot.testtask.dao.entity.user.User;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-11T05:09:17+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        String email = null;
        String password = null;
        String firstName = null;
        String lastName = null;
        String patronymic = null;
        LocalDate dob = null;

        email = entity.getEmail();
        password = entity.getPassword();
        firstName = entity.getFirstName();
        lastName = entity.getLastName();
        patronymic = entity.getPatronymic();
        dob = entity.getDob();

        UserDto userDto = new UserDto( email, password, firstName, lastName, patronymic, dob );

        return userDto;
    }

    @Override
    public List<UserDto> toDtoList(List<User> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( entityList.size() );
        for ( User user : entityList ) {
            list.add( toDto( user ) );
        }

        return list;
    }

    @Override
    public User toEntity(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.email( dto.email() );
        user.password( dto.password() );
        user.firstName( dto.firstName() );
        user.lastName( dto.lastName() );
        user.patronymic( dto.patronymic() );
        user.dob( dto.dob() );

        return user.build();
    }

    @Override
    public List<User> toEntityList(List<UserDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( dtoList.size() );
        for ( UserDto userDto : dtoList ) {
            list.add( toEntity( userDto ) );
        }

        return list;
    }
}
