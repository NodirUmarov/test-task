package kz.redmadrobot.testtask.dao.repository;

import java.time.LocalDateTime;
import kz.redmadrobot.testtask.dao.entity.ad.Ad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdRepository extends JpaRepository<Ad, Long> {

    Page<Ad> findAllByTitleOrDescriptionContainingAndUntilAfterOrUntilIsNull(Pageable pageable, String content1, String content2, LocalDateTime localDateTime);
    Page<Ad> findAllByTitleContainingAndUntilAfterOrUntilIsNull(Pageable pageable, String title, LocalDateTime localDateTime);
    Page<Ad> findAllByDescriptionContainingAndUntilAfterOrUntilIsNull(Pageable pageable, String description, LocalDateTime localDateTime);

}
