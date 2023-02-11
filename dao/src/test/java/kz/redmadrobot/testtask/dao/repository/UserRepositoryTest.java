package kz.redmadrobot.testtask.dao.repository;

import kz.redmadrobot.testtask.dao.config.DaoConfig;
import kz.redmadrobot.testtask.dao.entity.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

@DataJpaTest
@ContextConfiguration(classes = DaoConfig.class)
class UserRepositoryTest {

    // TODO: 2/9/2023 Integration test for repositories

    private final UserRepository userRepository;

    @Autowired
    public UserRepositoryTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Test
    void shouldSaveUser() {
        User user = User.builder().email("john@gmail.com").password("12345").build();

        userRepository.save(user);

        System.out.println(user);
    }

}