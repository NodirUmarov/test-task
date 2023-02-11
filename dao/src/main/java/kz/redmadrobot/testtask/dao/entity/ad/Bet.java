package kz.redmadrobot.testtask.dao.entity.ad;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;
import kz.redmadrobot.testtask.dao.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.AbstractAuditable;

@Entity
@Getter
@Setter
@Audited
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_bets")
@AuditTable("tb_bets_audit")
public class Bet extends AbstractAuditable<User, Long> {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ad_id", referencedColumnName = "id")
    private Ad ad;

    @Column(nullable = false)
    private BigDecimal offeredPrice;

    @Column(nullable = false)
    private Boolean isPrimary;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Bet bet = (Bet) o;
        return getId() != null && Objects.equals(getId(), bet.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}