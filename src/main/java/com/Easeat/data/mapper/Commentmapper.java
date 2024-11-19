package com.Easeat.data.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.Easeat.data.Entity.Comment;
import com.Easeat.data.dto.CommentDTO;

@Mapper(componentModel = "spring")
public interface Commentmapper {
@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public void updateCommentFromDto( CommentDTO dto, @MappingTarget  Comment entity);
    
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public void updateCommentFromEntity( Comment entity,@MappingTarget  CommentDTO dto);
}
