package com.toydd.nbbang.repository;

import com.toydd.nbbang.service.domain.Participant;
import com.toydd.nbbang.service.domain.Party;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ParticipantRepositoryTest {
    @Autowired
    private ParticipantRepository participantRepository;
    @Autowired
    private PartyRepository partyRepository;

    @Test
    void saveParticipant() {
        Participant participant = new Participant();
        participant.setName("delf");

        Party party = new Party();
        party.setName("group_name");

        participant.setParty(party);

        participantRepository.save(participant);
    }

    @Test
    void removeParticipant() {
        List<Participant> participants = participantRepository.findAll();
        Participant deleteTarget = participants.get(0);
        participantRepository.delete(deleteTarget);

        assertThrows(JpaObjectRetrievalFailureException.class, () -> {
            participantRepository.getReferenceById(deleteTarget.getId());
        });

        assertDoesNotThrow(() -> {
            partyRepository.findById(deleteTarget.getParty().getId());
        });
    }

    @Test
    void dummyDataCheckTest() {
        long count = participantRepository.count();
        assertNotEquals(0, count);
    }
}
