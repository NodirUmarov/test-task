package kz.redmadrobot.testtask.dao.entity.ad;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import kz.redmadrobot.testtask.dao.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractAuditable;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_bets")
public class Bet extends AbstractAuditable<User, Long> {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ad_id", referencedColumnName = "id")
    private Ad ad;

    @Column(nullable = false)
    private BigDecimal offeredPrice;

    @Column(nullable = false)
    private Boolean isPrimary;
}