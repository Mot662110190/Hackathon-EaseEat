package com.Easeat.data.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.Easeat.data.Entity.Bmr;
import com.Easeat.data.dto.BmrDTO;



@Mapper(componentModel = "spring")
public interface Bmrmapper {
@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public void updateBmrFromDto( BmrDTO dto, @MappingTarget  Bmr entity);
    
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public void updateBmrFromEntity( Bmr entity,@MappingTarget  BmrDTO dto);
}
