package com.toydd.nbbang.repository;

import com.toydd.nbbang.service.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
