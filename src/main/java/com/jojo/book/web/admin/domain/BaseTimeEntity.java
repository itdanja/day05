package com.jojo.book.web.admin.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter // get 메소드
@MappedSuperclass // jpa 엔티티 클래스에 상속을 주기위한
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {

    @CreatedDate // 엔티티가 생성되어 저장할때 시간이 자동 저장
    private LocalDateTime createDate;  // 게시물 생성 시간


    @LastModifiedDate // 엔티티의 값이 변경될때 시간이 자동 저장
    private LocalDateTime modifiedDate; // 게시물 변경 시간


}
