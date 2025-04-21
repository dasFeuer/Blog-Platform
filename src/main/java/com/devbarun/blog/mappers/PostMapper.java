package com.devbarun.blog.mappers;

import com.devbarun.blog.domian.CreatePostRequest;
import com.devbarun.blog.domian.UpdatePostRequest;
import com.devbarun.blog.domian.dtos.CreatePostRequestDto;
import com.devbarun.blog.domian.dtos.PostDto;
import com.devbarun.blog.domian.dtos.UpdatePostRequestDto;
import com.devbarun.blog.domian.entities.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {

    @Mapping(target = "author", source = "author")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "tags", source = "tags")
    @Mapping(target = "status", source = "status")
    PostDto toDto(Post post);

    CreatePostRequest toCreatePostRequest(CreatePostRequestDto dto);

    UpdatePostRequest toUpdatePostRequest(UpdatePostRequestDto dto);

}