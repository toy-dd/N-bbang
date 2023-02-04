package com.toydd.nbbang.party;

import com.toydd.nbbang.model.request.PartyUpdateDto;
import io.github.benas.randombeans.EnhancedRandomBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartyTest {

	@DisplayName("모임 내용 업데이트 동작 확인")
	@Test
	void update() {
		// given
		PartyUpdateDto body = EnhancedRandomBuilder.aNewEnhancedRandom().nextObject(PartyUpdateDto.class);
		Party party = EnhancedRandomBuilder.aNewEnhancedRandom().nextObject(Party.class);

		// when
		party.update(body);

		// then
		assertEquals(body.getName(), party.getName());
		assertEquals(body.getDescription(), party.getDescription());
		assertEquals(body.getStartAt(), party.getStartAt());
		assertEquals(body.getEndAt(), party.getEndAt());
	}

}
