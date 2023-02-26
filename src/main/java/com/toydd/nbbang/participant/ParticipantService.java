package com.toydd.nbbang.participant;

import com.toydd.nbbang.common.exception.NotFoundException;
import com.toydd.nbbang.model.enums.ParticipantRole;
import com.toydd.nbbang.model.mapper.ParticipantMapper;
import com.toydd.nbbang.model.request.ParticipantCreateDto;
import com.toydd.nbbang.model.response.IdDto;
import com.toydd.nbbang.party.Party;
import com.toydd.nbbang.party.PartyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ParticipantService {
    private final ParticipantRepository participantRepository;
    private final PartyService partyService;

    public List<Participant> retrieveParticipants(Long partyId) {
        return participantRepository.findParticipantsByPartyId(partyId);
    }

    public Participant retrieveParticipant(Long participantId) {
        return participantRepository.findById(participantId).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public List<IdDto> saveParticipant(Long partyId, List<ParticipantCreateDto> participantCreateDtoList) {
        Party party = partyService.retrieveParty(partyId);

        List<IdDto> responseDto = new ArrayList<>();
        for (ParticipantCreateDto dto : participantCreateDtoList) {
            Participant participant = ParticipantMapper.INSTANCE.toEntity(dto);
            participant.setParty(party);
            participant = this.saveParticipant(participant);

            responseDto.add(IdDto.of(participant));
        }

        return responseDto;
    }

    public Participant saveParticipant(Participant participant) {
        return participantRepository.save(participant);
    }

	@Transactional
	public Long enterPartyBy(Long partyId, ParticipantCreateDto body) {
		Party party = partyService.retrieveParty(partyId);
		Participant participant = participantRepository
				.findTop1ByPartyAndNameAndRole(party, body.getName(), ParticipantRole.EMPTY)
				.orElseThrow();
		participant.entered();
		return participant.getId();
	}

}
