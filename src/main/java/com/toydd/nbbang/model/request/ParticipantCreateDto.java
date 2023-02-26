package com.toydd.nbbang.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@ApiModel
@Getter
@Builder
@ToString
public class ParticipantCreateDto {

	@NotBlank
	@Schema(description = "참여자명", required = true)
	private String name;

	@Email
	@Schema(description = "참여자 이메일")
	private String email;
}
