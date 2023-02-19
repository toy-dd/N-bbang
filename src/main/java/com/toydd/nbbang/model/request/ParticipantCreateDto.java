package com.toydd.nbbang.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ApiModel
@Getter
@Builder
@ToString
public class ParticipantCreateDto {

    @Schema(description = "이름", required = true)
    private String name;

    @Schema(description = "이메일", required = true)
    private String email;
}
