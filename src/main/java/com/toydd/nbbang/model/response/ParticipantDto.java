package com.toydd.nbbang.model.response;

import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@ApiModel
@Builder
@Getter
public class ParticipantDto {
    @Schema(description = "아이디", required = true)
    private Long id;

    @Schema(description = "이름", required = true)
    private String name;

    @Schema(description = "이메일", required = true)
    private String email;
}
