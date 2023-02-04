package com.toydd.nbbang.model.response;

import com.toydd.nbbang.model.marker.IdGettable;
import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@ApiModel
@Builder(access = AccessLevel.PRIVATE)
@Getter
public class IdDto {
    @Schema(description = "아이디", required = true)
    private final Long id;

    public static IdDto of(IdGettable idGetter) {
        return new IdDto(idGetter.getId());
    }

    public static IdDto of(Long id) {
        return new IdDto(id);
    }
}
