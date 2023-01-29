package com.toydd.nbbang.domain;

import com.toydd.nbbang.participant.Participant;
import com.toydd.nbbang.payment.Payment;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class PaymentParticipant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "participant_id")
    private Participant participant;

    @Column(columnDefinition = "TINYINT")
    private Boolean paymentFlag = false;

    @Column(columnDefinition = "TINYINT")
    private Boolean withFlag = false;
}