package kz.redmadrobot.testtask.dao.repository;

import kz.redmadrobot.testtask.dao.entity.ad.Bet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BetRepository extends JpaRepository<Bet, Long> {
}
