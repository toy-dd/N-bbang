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

    @Transactional
    public void delete(Long partyId) {
        partyRepository.deleteById(partyId);
        // TODO 모임이 삭제되었음을 모임원들에게 알려주는 알림 기능 넣기?
        // TODO 모임원이 만장일치 삭제 동의하지 않았으면 삭제 못하게 하기?
    }
}
