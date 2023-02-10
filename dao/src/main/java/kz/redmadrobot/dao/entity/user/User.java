package kz.redmadrobot.dao.entity.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "tb_users")
@AuditTable(value = "tb_users_aud")
public class User extends AbstractPersistable<Long> {

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

}
