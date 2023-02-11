package kz.redmadrobot.testtask.dao.repository;

import java.util.Optional;
import kz.redmadrobot.testtask.dao.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String username);
}
