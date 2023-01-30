package com.toydd.nbbang.model.response;

import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@ApiModel
@Builder
@Getter
public class IdDto {
    @Schema(description = "아이디", required = true)
    private Long id;
}
