package kz.redmadrobot.dao.repository;

import kz.redmadrobot.dao.entity.ad.Bet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BetRepository extends JpaRepository<Bet, Long> {
}
