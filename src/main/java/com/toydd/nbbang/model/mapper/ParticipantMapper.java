package com.toydd.nbbang.model.mapper;

import com.toydd.nbbang.model.request.ParticipantCreateDto;
import com.toydd.nbbang.participant.Participant;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ParticipantMapper {
    ParticipantMapper INSTANCE = Mappers.getMapper(ParticipantMapper.class);
    Participant toEntity(ParticipantCreateDto body);

}
