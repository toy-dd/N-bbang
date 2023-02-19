package com.toydd.nbbang.participant;

import com.toydd.nbbang.model.response.ParticipantDto;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/v1/parties")
public class ParticipantController {

    private final ParticipantService participantService;

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

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
}
