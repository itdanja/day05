package com.jojo.book.web.admin.service;


import com.jojo.book.web.admin.domain.posts.Posts;
import com.jojo.book.web.admin.domain.posts.PostsRepository;
import com.jojo.book.web.admin.web.dto.PostsListResponseDto;
import com.jojo.book.web.admin.web.dto.PostsResponseDto;
import com.jojo.book.web.admin.web.dto.PostsSaveRequestDto;
import com.jojo.book.web.admin.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor // 자동 생성자
@Service // 현재 클래스는 서비스 역할 => db접근된 데이터를 java 로직
public class PostsService {

    private final PostsRepository postsRepository; // Repository :  db접근

    ///// 저장 로직
    @Transactional // db접근된 병렬 처리
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save( requestDto.toEntity() ).getId();
    }
    /////  수정 로직
    @Transactional
    public Long update(Long id , PostsUpdateRequestDto requestDto ){

        Posts posts = postsRepository.findById( id ).orElseThrow(
                () -> new IllegalArgumentException( "해당 게시물이 없습니다  id = " + id ) );
        // 연결된 기본키 찾기
        // 만약에 찾는 키가 없으면 = orElseThrow
        //  람다식(  인수 -> 코드 ) : 익명메소드
        posts.update( requestDto.getTitle() , requestDto.getContent()   );
        return id;
    }
    ////// 삭제 로직
    @Transactional // 트랜잭션
    public void delete( Long id ){

        Posts posts = postsRepository.findById( id ).orElseThrow(
                ()-> new IllegalArgumentException("해당 게시물이 없습니다 id = "+id));

        postsRepository.delete( posts );
    }
    ////// 검색 로직
    @Transactional(readOnly = true)
    public PostsResponseDto findById( long id ){

        Posts entity = postsRepository.findById( id ).orElseThrow(
                () -> new IllegalArgumentException( "해당 게시물이 없습니다 id" + id)
        );
        return new PostsResponseDto(entity); // 검색 결과를 리턴
    }
    ////// 리스트트 로직
    //db 에 모든 게시물 리스트에 담아서 반환
    @Transactional( readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc()
                .stream()
                .map( PostsListResponseDto::new )
                .collect(Collectors.toList());
    }

}
