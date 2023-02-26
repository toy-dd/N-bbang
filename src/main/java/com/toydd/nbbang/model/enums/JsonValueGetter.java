package com.toydd.nbbang.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public interface JsonValueGetter {

	@JsonValue
	String getJsonValue();
}
