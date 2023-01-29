package com.toydd.nbbang.party;

import com.toydd.nbbang.model.request.PartyCreateDto;
import com.toydd.nbbang.model.response.IdDto;
import com.toydd.nbbang.model.response.PartyDto;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/parties")
public class PartyController {
    private final PartyService partyService;

    public PartyController(PartyService partyService) {
        this.partyService = partyService;
    }

    @Operation(summary = "모임 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "partyId", value = "모임id", dataType = "long", required = true)
    })
    @GetMapping("/{partyId}")
    public Mono<PartyDto> retrieveParty(@PathVariable Long partyId) {

        Party party = partyService.retrieveParty(partyId);

        String startAt = "";
        String endAt = "";

        // todo: 예외처리, 그에 따른 적절한 응답
        return Mono.just(PartyDto.builder()
                .id(party.getId())
                .name(party.getName())
                .startAt(party.getStartAt())
                .endAt(party.getEndAt())
                .build());
    }

    @Operation(summary = "모임 생성")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "body", dataTypeClass = PartyCreateDto.class, required = true)
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Mono<IdDto> createParty(@RequestBody PartyCreateDto body) {
        Party party = Party.builder()
                .name(body.getName())
                .description(body.getDescription())
                .build();

        party = partyService.saveParty(party);
        // todo: 예외처리, 그에 따른 적절한 응답
        return Mono.just(IdDto.builder().id(party.getId()).build());
    }
}