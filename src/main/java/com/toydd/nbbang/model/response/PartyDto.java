package com.toydd.nbbang.model.response;

import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@ApiModel
@Builder
@Getter
public class PartyDto {

    @Schema(description = "아이디", required = true)
    private Long id;

    @Schema(description = "이름", required = true)
    private String name;

    @Schema(description = "시작일", required = true)
    private LocalDateTime startAt;

    @Schema(description = "종료일", required = true)
    private LocalDateTime endAt;
}
