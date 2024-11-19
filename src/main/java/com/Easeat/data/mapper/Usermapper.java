package com.Easeat.data.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.Easeat.data.Entity.User;
import com.Easeat.data.dto.UserDTO;

@Mapper(componentModel = "spring")
public interface Usermapper {
    
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public void updateUserFromDto( UserDTO dto, @MappingTarget User entity);
    
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public void updateUserFromEntity( User entity,@MappingTarget  UserDTO dto);
}

