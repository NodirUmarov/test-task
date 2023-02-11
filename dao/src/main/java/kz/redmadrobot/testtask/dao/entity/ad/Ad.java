package kz.redmadrobot.testtask.dao.entity.ad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import kz.redmadrobot.testtask.dao.entity.enums.AdStatus;
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
@Table(name = "tb_ads")
@AuditTable("tb_ads_audit")
public class Ad extends AbstractAuditable<User, Long> {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private BigDecimal minimalPrice;

    @Column(nullable = false)
    private AdStatus adStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private Category category;

    @Lob
    @Column(length = 1000)
    private byte[] imageData;

    @Column
    private LocalDateTime until;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Ad ad = (Ad) o;
        return getId() != null && Objects.equals(getId(), ad.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
