package kz.redmadrobot.dao.entity.ad;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Getter
@Setter
@Builder
@Audited
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_categories")
@AuditTable(value = "tb_categories_aud")
public class Category extends AbstractPersistable<Long> {

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_category_id", referencedColumnName = "id")
    private Category parentCategory;

}