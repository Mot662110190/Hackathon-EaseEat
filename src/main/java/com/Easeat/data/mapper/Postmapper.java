package com.Easeat.data.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.Easeat.data.Entity.Post;
import com.Easeat.data.dto.PostDTO;



@Mapper(componentModel = "spring")
public interface Postmapper {
  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public void updatePostFromDto( PostDTO dto, @MappingTarget  Post entity);
    
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public void updatePostFromEntity( Post entity,@MappingTarget  PostDTO dto);
}
