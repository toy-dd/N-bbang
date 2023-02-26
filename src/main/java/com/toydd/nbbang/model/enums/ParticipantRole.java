package com.toydd.nbbang.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ParticipantRole {

	OWNER("owner", 1),
	PARTICIPANT("parcitipant", 2),
	EMPTY("empty", 3)
	;

	private final String jsonValue;
	private final Integer dbValue;
}
