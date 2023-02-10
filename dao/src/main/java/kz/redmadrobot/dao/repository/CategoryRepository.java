package kz.redmadrobot.dao.repository;

import kz.redmadrobot.dao.entity.ad.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
