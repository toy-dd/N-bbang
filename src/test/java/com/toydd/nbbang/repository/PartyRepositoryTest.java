package com.toydd.nbbang.repository;

import com.toydd.nbbang.party.Party;
import com.toydd.nbbang.party.PartyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class PartyRepositoryTest {

    @Autowired
    private PartyRepository partyRepository;

    @Test
    Party saveParty() {
        Party party = Party.builder().name("test-party").build();
        assertEquals(party, partyRepository.save(party));

        return party;
    }

    @Test
    void removeParty(Party party) {

        partyRepository.delete(party);
//        ParameterResolutionException
    }

    @Test
    void updateParty() {

    }


}
