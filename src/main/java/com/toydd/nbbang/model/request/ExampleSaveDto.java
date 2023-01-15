package com.toydd.nbbang.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@ApiModel
@Getter
public class ExampleSaveDto {

	@Schema(description = "아이디", required = true)
	private Long id;

	@Schema(description = "이름", required = true)
	private String name;

}
