package com.rhpm.coffeeShop.controller;

import com.rhpm.coffeeShop.model.dto.requestDto.CommentRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.CommentResponseDto;
import com.rhpm.coffeeShop.model.exceptions.MasterException;
import com.rhpm.coffeeShop.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product/comment")
@CrossOrigin("*")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/createComment")
    public CommentResponseDto createComment(@RequestBody CommentRequestDto commentRequestDto) throws MasterException {
        return commentService.createComment(commentRequestDto);
    }

    @GetMapping()
    public List<CommentResponseDto> getAllComment(@RequestParam Long ProductId) throws MasterException {
        return commentService.getAllComment(ProductId);
    }

    @DeleteMapping()
    public void deleteComment(@RequestParam Long commentId, @RequestParam Long productId) throws MasterException {
        commentService.deleteComment(commentId,productId);
    }
}
