package com.example.personms.mapper;

import com.example.personms.dto.PersonDTO;
import com.example.personms.entity.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class PersonMapper {

    public static final PersonMapper Mapping = Mappers.getMapper(PersonMapper.class);

    public abstract PersonEntity mapToEntity(PersonDTO dto);

    public abstract PersonDTO mapToDto(PersonEntity entity);

    public abstract List<PersonDTO> mapToDtoList(List<PersonEntity> entities);
}
