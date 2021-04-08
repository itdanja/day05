package com.jojo.book.web.admin.domain.posts;

import com.jojo.book.web.admin.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // get 메소드 사용
@NoArgsConstructor // 빈 생성자 사용
@Entity // 테이블에 대응하는 개체
public class Posts extends BaseTimeEntity {

    @Id // 기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 오토키
    private Long id;

    @Column(length = 500, nullable = false) // 열[필드] 속성
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false) // 열[필드] 속성
    private String content;

    private String author;

    @Builder // 객체 생성시 안정성 보장 => 인수 순서 구분x // null 제외 등
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }


    // 업데이트 메소드
    public void update( String title , String content ){

        this.title = title;
        this.content = content;

    }



}

