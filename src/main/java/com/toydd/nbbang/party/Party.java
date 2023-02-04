package com.toydd.nbbang.party;

import com.toydd.nbbang.domain.BaseEntity;
import com.toydd.nbbang.model.mapper.PartyMapper;
import com.toydd.nbbang.model.request.PartyUpdateDto;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@DynamicUpdate
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "id", callSuper = true)
public class Party extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column
    private LocalDateTime startAt;

    @Column
    private LocalDateTime endAt;

    @Builder
    public Party(String name, String description, LocalDateTime startAt, LocalDateTime endAt) {
        this.name = name;
        this.description = description;
        this.startAt = startAt;
        this.endAt = endAt;
    }

    public void update(PartyUpdateDto body) {
        PartyMapper.INSTANCE.updateFromDto(this, body);
    }

}
