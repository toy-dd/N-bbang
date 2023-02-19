package com.toydd.nbbang.participant;

import com.toydd.nbbang.domain.BaseEntity;
import com.toydd.nbbang.domain.PaymentParticipant;
import com.toydd.nbbang.party.Party;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@DynamicUpdate
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "id", callSuper = true)
@ToString
public class Participant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String email;

    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(nullable = false)
    private Party party;

    @OneToMany(mappedBy = "participant")
    private List<PaymentParticipant> paymentParticipantList;

    @Builder
    public Participant(String name, String email, Party party, List<PaymentParticipant> paymentParticipantList) {
        this.name = name;
        this.email = email;
        this.party = party;
        this.paymentParticipantList = paymentParticipantList;
    }
}
