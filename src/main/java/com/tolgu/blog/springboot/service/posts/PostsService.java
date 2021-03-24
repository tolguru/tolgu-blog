package com.tolgu.blog.springboot.service.posts;

import com.tolgu.blog.springboot.config.auth.LoginUser;
import com.tolgu.blog.springboot.config.auth.dto.SessionUser;
import com.tolgu.blog.springboot.domain.posts.Posts;
import com.tolgu.blog.springboot.domain.posts.PostsRepository;
import com.tolgu.blog.springboot.web.dto.PostsListResponseDTO;
import com.tolgu.blog.springboot.web.dto.PostsResponseDTO;
import com.tolgu.blog.springboot.web.dto.PostsSaveRequestDTO;
import com.tolgu.blog.springboot.web.dto.PostsUpdateRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
    } // 왜 repository에 save를 안 하지..??? -> JPA는 영속성 컨텍스트(엔티티 영구 저장) 환경이기 때문에
    // 트랜잭션 안에서 데이터베이스의 데이터를 가져오면 영구 저장이 유지되기 때문에 가져온 데이터의 값을 변경하면 트랜잭션이 끝나는 시점에
    // 변경된 부분을 반영한다. 더티 체킹이라고도 한다고 함.

    public PostsResponseDTO findById (Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new PostsResponseDTO(entity);
    }

    // 트랜잭션 옵션 추가 어노테이션, readOnly 사용 시 조회 속도 상승
    @Transactional(readOnly = true)
    public List<PostsListResponseDTO> findAllDesc() {
        return postsRepository.findAllDesc().stream()
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
