package uz.boom.citizens.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import uz.boom.citizens.configs.security.SessionUser;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    protected Long id;

    @Column(name = "created_at", updatable = false)
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    @Generated(GenerationTime.INSERT)
    private LocalDateTime createdAt;

    @Column(name = "created_by")
//    @ColumnDefault(value = "")
    private Long createdBy;

    @Convert(disableConversion = true)
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "updated_by")
    private Long updatedBy;

}