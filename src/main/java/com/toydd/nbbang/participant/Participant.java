package com.toydd.nbbang.participant;

import com.toydd.nbbang.party.Party;
import com.toydd.nbbang.domain.BaseEntity;
import com.toydd.nbbang.domain.PaymentParticipant;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Participant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String email;

    @ManyToOne (cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Party party;

    @OneToMany(mappedBy = "participant")
    private List<PaymentParticipant> paymentParticipantList;
}
