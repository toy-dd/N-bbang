package com.toydd.nbbang.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@ApiModel
@Getter
@ToString
public class PartyCreateDto {

    @Schema(description = "이름", required = true)
    private String name;

    @Schema(description = "설명", required = true)
    private String description;

    @Schema(description = "시작일", required = true)
    private LocalDateTime startAt;

    @Schema(description = "종료일", required = true)
    private LocalDateTime endAt;
}
