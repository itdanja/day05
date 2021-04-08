package com.jojo.book.web.admin.domain.posts;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PostsRepository extends JpaRepository<Posts, Long> {
    //  조회 결과를 리스트에 담기
    @Query("select p from Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}

