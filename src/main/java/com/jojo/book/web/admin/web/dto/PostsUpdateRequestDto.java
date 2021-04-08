package com.jojo.book.web.admin.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {

    private String title;
    private String content;

    @Builder // 인수 순서 구분 x , null 제외 등
    public PostsUpdateRequestDto( String title , String content ){

        this.title = title;
        this.content = content;

    }







}
