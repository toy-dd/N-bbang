package com.toydd.nbbang.participant;

import com.toydd.nbbang.model.enums.ParticipantRole;
import com.toydd.nbbang.party.Party;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    List<Participant> findParticipantsByPartyId(Long partyId);

	Optional<Participant> findTop1ByPartyAndNameAndRole(Party party, String name, ParticipantRole role);

}
