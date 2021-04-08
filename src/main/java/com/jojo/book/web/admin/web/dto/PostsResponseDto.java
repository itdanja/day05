package com.jojo.book.web.admin.web.dto;


import com.jojo.book.web.admin.domain.posts.Posts;
import lombok.Getter;

@Getter // get 메소드 자동 생성
public class PostsResponseDto { // 조회 객체


    private Long id; // 게시물번호
    private String title; // 게시물 제목
    private String content; // 게시물 내용
    private String author; // 게시물 작성자

    public PostsResponseDto( Posts entity ){ // 조회 결과를 가져와서 생성자 생성3
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
