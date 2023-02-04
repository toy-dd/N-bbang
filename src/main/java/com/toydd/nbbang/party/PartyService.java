package com.toydd.nbbang.party;

import com.toydd.nbbang.common.exception.NotFoundException;
import com.toydd.nbbang.model.request.PartyUpdateDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public Party update(Long partyId, PartyUpdateDto body) {
        Party party = partyRepository.findById(partyId).orElseThrow(NotFoundException::new);
        party.update(body);
        return party;
    }
}
