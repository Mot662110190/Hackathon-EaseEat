package com.Easeat.data.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.Easeat.data.Entity.Strain;
import com.Easeat.data.dto.StrainDTO;

@Mapper(componentModel = "spring")
public interface Strainmapper {
@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public void updateStrainFromDto( StrainDTO dto, @MappingTarget  Strain entity);
    
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public void updateStrainFromEntity( Strain entity,@MappingTarget  StrainDTO dto);
}
