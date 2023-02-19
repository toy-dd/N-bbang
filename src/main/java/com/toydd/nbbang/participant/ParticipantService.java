package com.toydd.nbbang.participant;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService {
    private final ParticipantRepository participantRepository;

    public ParticipantService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    public List<Participant> retrieveParticipants(Long partyId) {
        return participantRepository.findParticipantsByPartyId(partyId);
    }
}
