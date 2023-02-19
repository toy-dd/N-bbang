package com.toydd.nbbang.participant;

import com.toydd.nbbang.model.mapper.ParticipantMapper;
import com.toydd.nbbang.model.request.ParticipantCreateDto;
import com.toydd.nbbang.party.PartyService;
import io.github.benas.randombeans.EnhancedRandomBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ParticipantTest {
    @Autowired
    ParticipantService participantService;
    @Autowired
    PartyService partyService;

    @DisplayName("ParticipantMapper 테스트")
    @Test
    void mapperTest() {
        ParticipantCreateDto body = EnhancedRandomBuilder.aNewEnhancedRandom().nextObject(ParticipantCreateDto.class);
        Participant participant = ParticipantMapper.INSTANCE.toEntity(body);

        assertEquals(body.getName(), participant.getName());
        assertEquals(body.getEmail(), participant.getEmail());
    }

    @Test
    void joinTest() {
        List<ParticipantCreateDto> participantCreateDtoList = new ArrayList<>();
        final Long savedSamplePartyId = 3L;

        for (int i = 0; i < 3; i++) {
            ParticipantCreateDto body = EnhancedRandomBuilder.aNewEnhancedRandom().nextObject(ParticipantCreateDto.class);
            participantCreateDtoList.add(body);
        }

        Assertions.assertDoesNotThrow(() -> {
            participantService.saveParticipant(savedSamplePartyId, participantCreateDtoList);
        });
    }

}