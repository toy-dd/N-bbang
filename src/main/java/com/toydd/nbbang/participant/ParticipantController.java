package com.toydd.nbbang.participant;

import com.toydd.nbbang.model.request.ParticipantCreateDto;
import com.toydd.nbbang.model.response.IdDto;
import com.toydd.nbbang.model.response.ParticipantDto;
import com.toydd.nbbang.party.Party;
import com.toydd.nbbang.party.PartyService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/parties")
public class ParticipantController {

	private final ParticipantService participantService;
	private final PartyService partyService;

	@Operation(summary = "모임 참여자 목록 조회")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "partyId", value = "모임id", dataType = "long", required = true)
	})
	@GetMapping("/{partyId}/participants")
	public Flux<ParticipantDto> retrieveParticipant(@PathVariable Long partyId) {
		List<Participant> participantList = participantService.retrieveParticipants(partyId);

		return Flux.fromIterable(participantList.stream()
				.map(e -> ParticipantDto.builder()
						.id(e.getId())
						.name(e.getName())
						.email(e.getEmail())
						.build())
				.collect(toList()));
	}

	@Operation(summary = "모임 참여자 등록")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "partyId", value = "모임id", dataType = "long", required = true),
			@ApiImplicitParam(name = "body", dataTypeClass = ParticipantCreateDto.class, required = true)
	})
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/{partyId}/participants")
	public Flux<IdDto> createParticipant(@PathVariable Long partyId, @RequestBody List<ParticipantCreateDto> body) {
		try {
			List<IdDto> responseDtoList = participantService.saveParticipant(partyId, body);
			return Flux.fromIterable(responseDtoList);

		} catch (NoSuchElementException e) {
			return Flux.error(e); // 이렇게 하는게 아닐텐데...
		}
	}

	@Operation(summary = "모임 참여")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "partyId", value = "모임id", dataType = "long", required = true),
			@ApiImplicitParam(name = "participantId", value = "참여자id", dataType = "long", required = true)
	})
	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/{partyId}/participants/{participantId}")
	public void joinParty(@PathVariable Long partyId, @PathVariable Long participantId) {
		Party party = partyService.retrieveParty(partyId);
		Participant participant = participantService.retrieveParticipant(participantId);

		if (!Objects.equals(party.getId(), participant.getId())) {
			participant.setParty(party);
			participantService.saveParticipant(participant);
		}

		throw new NoSuchElementException();
	}

	@PostMapping("/{partyId}/participants/enter")
	public Mono<IdDto> enterParty(@PathVariable Long partyId,
	                              @Valid @RequestBody ParticipantCreateDto body) {
		Long participantId = participantService.enterPartyBy(partyId, body);
		return Mono.just(IdDto.of(participantId));
	}

}
