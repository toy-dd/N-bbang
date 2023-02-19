package com.toydd.nbbang.participant;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    List<Participant> findParticipantsByPartyId(Long partyId);
}
