package kz.redmadrobot.dao.entity.ad;

import jakarta.persistence.*;
import kz.redmadrobot.dao.entity.enums.AdStatus;
import kz.redmadrobot.dao.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.AbstractAuditable;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@Audited
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_ads")
@AuditTable(value = "tb_ads_aud")
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

}
