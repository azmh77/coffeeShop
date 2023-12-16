package com.rhpm.coffeeShop.service.serviceImpl;

import com.rhpm.coffeeShop.model.convertEntityToDto.ConvertEntityToDto;
import com.rhpm.coffeeShop.model.dto.requestDto.CommentRequestDto;
import com.rhpm.coffeeShop.model.dto.responseDto.CommentResponseDto;
import com.rhpm.coffeeShop.model.entity.CommentEntity;
import com.rhpm.coffeeShop.model.entity.ProductEntity;
import com.rhpm.coffeeShop.model.entity.UserEntity;
import com.rhpm.coffeeShop.model.exceptions.MasterException;
import com.rhpm.coffeeShop.repository.CommentRepository;
import com.rhpm.coffeeShop.repository.ProductRepository;
import com.rhpm.coffeeShop.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CommentService implements com.rhpm.coffeeShop.service.CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Override
    public CommentResponseDto createComment(CommentRequestDto commentRequestDto) throws MasterException {
        CommentEntity comment = new CommentEntity();
        UserEntity user = userRepository.findById(commentRequestDto.getUserId())
                .orElseThrow(() -> new MasterException("کاربری با این آیدی وجود ندارد!"));
        ProductEntity product = productRepository.findById(commentRequestDto.getProductId())
                .orElseThrow(() -> new MasterException("محصولی با این آیدی وجود ندارد!"));
        if (!user.getIsActive()) {
            throw new MasterException("حساب کاربری شما مسدود شده است!");
        } else {
            if (commentRequestDto.getBody().isEmpty()) {
                throw new MasterException("فیلد نباید خالی باشد!");
            } else if (commentRequestDto.getBody().length() > 600) {
                throw new MasterException("تعداد کارکتر برای نطر باید کمتر از 600 کاراکتر باشد!");
            } else {
                List<CommentEntity> oldComments = product.getComments();
                product.setCommentCount(product.getCommentCount() + 1);
                comment.setBody(commentRequestDto.getBody());
                comment.setUserCreated(user);
                if (commentRequestDto.getParentId() != null) {
                    List<CommentEntity> children = new ArrayList<>();
                    CommentEntity commentParent = commentRepository.findById(commentRequestDto.getParentId())
                            .orElseThrow(() -> new MasterException("کامنتی با این آیدی وجود ندارد!"));
                    comment.setParent(commentParent);
                    children.add(comment);
                    comment.setChildren(children);
                }
                commentRepository.save(comment);
                oldComments.add(comment);
                product.setComments(oldComments);
                productRepository.save(product);
            }
        }
        return ConvertEntityToDto.convertCommentEntityToDto(comment);
    }

    @Override
    public List<CommentResponseDto> getAllComment(Long productId) throws MasterException {
        List<CommentEntity> comments;
        ProductEntity product = productRepository.findById(productId)
                .orElseThrow(() -> new MasterException("محصولی با این آیدی وجود ندارد!"));
        comments = product.getComments();
        return comments.stream().map(ConvertEntityToDto::convertCommentEntityToDto).toList();
    }

    @Override
    public void deleteComment(Long commentId, Long productId) throws MasterException {
        CommentEntity comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new MasterException("کامنتی با این آیدی وجود ندارد!"));
        ProductEntity product = productRepository.findById(productId)
                .orElseThrow(() -> new MasterException("محصولی با این آیدی پیدا نشد!"));
        List<CommentEntity> oldCommentList = product.getComments();
        oldCommentList.remove(comment);
        product.setComments(oldCommentList);
        productRepository.save(product);
        commentRepository.delete(comment);
    }
}

