package com.example.study.service.mapper;

import com.example.study.domain.Pet;
import com.example.study.service.DTO.PetDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring",uses = {})
public interface PetMapper extends  EntityMapper<PetDTO, Pet> {
}
