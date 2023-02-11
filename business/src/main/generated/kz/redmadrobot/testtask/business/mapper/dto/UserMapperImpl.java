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
    date = "2023-02-11T13:03:43+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toDto(User arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Long id = null;
        String email = null;
        String password = null;
        String firstName = null;
        String lastName = null;
        String patronymic = null;
        LocalDate dob = null;

        id = arg0.getId();
        email = arg0.getEmail();
        password = arg0.getPassword();
        firstName = arg0.getFirstName();
        lastName = arg0.getLastName();
        patronymic = arg0.getPatronymic();
        dob = arg0.getDob();

        UserDto userDto = new UserDto( id, email, password, firstName, lastName, patronymic, dob );

        return userDto;
    }

    @Override
    public List<UserDto> toDtoList(List<User> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( arg0.size() );
        for ( User user : arg0 ) {
            list.add( toDto( user ) );
        }

        return list;
    }

    @Override
    public User toEntity(UserDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.email( arg0.email() );
        user.password( arg0.password() );
        user.firstName( arg0.firstName() );
        user.lastName( arg0.lastName() );
        user.patronymic( arg0.patronymic() );
        user.dob( arg0.dob() );

        return user.build();
    }

    @Override
    public List<User> toEntityList(List<UserDto> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( arg0.size() );
        for ( UserDto userDto : arg0 ) {
            list.add( toEntity( userDto ) );
        }

        return list;
    }
}
