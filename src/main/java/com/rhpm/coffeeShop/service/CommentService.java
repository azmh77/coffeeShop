package com.rhpm.coffeeShop.service;

import com.rhpm.coffeeShop.model.dto.requestDto.CommentRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.CommentResponseDto;
import com.rhpm.coffeeShop.model.exceptions.MasterException;

import java.util.List;

public interface CommentService {
    CommentResponseDto createComment(CommentRequestDto commentRequestDto) throws MasterException;

    List<CommentResponseDto> getAllComment(Long productId) throws MasterException;

    void deleteComment(Long commentId,Long productId) throws MasterException;
}
