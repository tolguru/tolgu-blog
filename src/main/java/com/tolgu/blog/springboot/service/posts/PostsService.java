package com.tolgu.blog.springboot.service.posts;

import com.tolgu.blog.springboot.domain.posts.Posts;
import com.tolgu.blog.springboot.domain.posts.PostsRepository;
import com.tolgu.blog.springboot.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository; // DAO

    @Transactional
    public Long save(PostsSaveRequestDTO requestDTO, Long authorID) {
        return postsRepository.save(requestDTO.toEntity(authorID)).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDTO requestDTO) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        posts.update(requestDTO.getTitle(), requestDTO.getContent());

        return id;
    }

    @Transactional
    public PostsResponseDTO findById (Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        // 조회와 동시에 조회수 상승. 더티체킹.
        entity.increaseViews();
        return new PostsResponseDTO(entity);
    }

    public PostsUpdateResponseDTO findByIdforUpdate (Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new PostsUpdateResponseDTO(entity);
    }

    // 트랜잭션 옵션 추가 어노테이션, readOnly 사용 시 조회 속도 상승
    @Transactional(readOnly = true)
    public List<PostsListResponseDTO> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDTO> findPagingDesc(Pageable page) {
        return postsRepository.findAll(page).stream()
                .map(PostsListResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        postsRepository.delete(posts);
    }
}
