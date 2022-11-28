package com.toydd.nbbang.repository;

import com.toydd.nbbang.service.domain.Party;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepository extends JpaRepository<Party, Long> {
}
