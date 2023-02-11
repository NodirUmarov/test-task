package kz.redmadrobot.testtask.dao.repository;

import kz.redmadrobot.testtask.dao.entity.ad.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
