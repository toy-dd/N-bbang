package com.toydd.nbbang.service.domain;

import com.toydd.nbbang.repository.converter.CategoryConvertor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@Getter
@Setter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column
    private String place;
    @Column(nullable = false)
    private BigInteger amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Party party;

    @Convert(converter = CategoryConvertor.class)
    private Category category = Category.ETC;

    @OneToMany(mappedBy = "payment")
    private List<PaymentParticipant> paymentParticipantList;
}
