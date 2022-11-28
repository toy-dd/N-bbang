package com.toydd.nbbang.service.domain;

import com.toydd.nbbang.repository.converter.BooleanToYnConverter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class PaymentParticipant {

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