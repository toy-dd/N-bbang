package com.toydd.nbbang.model.mapper;

import com.toydd.nbbang.model.request.PartyUpdateDto;
import com.toydd.nbbang.party.Party;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PartyMapper {
	PartyMapper INSTANCE = Mappers.getMapper(PartyMapper.class);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	@Mapping(target = "id", ignore = true)
	void updateFromDto(@MappingTarget Party entity, PartyUpdateDto body);
}
