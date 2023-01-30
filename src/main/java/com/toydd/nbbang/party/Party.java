package com.toydd.nbbang.party;

import com.toydd.nbbang.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
}
