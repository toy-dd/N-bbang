package com.toydd.nbbang.party;

import org.springframework.stereotype.Service;

@Service
public class  PartyService {

    private final PartyRepository partyRepository;

    public PartyService(PartyRepository partyRepository) {
        this.partyRepository = partyRepository;
    }

    public Party retrieveParty(Long partyId) {
        return partyRepository.getReferenceById(partyId);
    }

    public Party saveParty(Party party) {
        return partyRepository.save(party);
    }
}