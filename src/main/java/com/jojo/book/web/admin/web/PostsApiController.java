package com.jojo.book.web.admin.web;

import com.jojo.book.web.admin.service.PostsService;
import com.jojo.book.web.admin.web.dto.PostsListResponseDto;
import com.jojo.book.web.admin.web.dto.PostsResponseDto;
import com.jojo.book.web.admin.web.dto.PostsSaveRequestDto;
import com.jojo.book.web.admin.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService; // 서비스 연결

    // 저장 컨트롤 = postmapping
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    // 변경 컨트롤 = putmapping
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }
    // 삭제 컨트롤 = deletemapping
    @DeleteMapping("/api/v1/posts/{id}")
    public Long Delete( @PathVariable  Long id ){
        postsService.delete(id);
        return id;
    }

    // 찾기 컨트롤 = getmapping
    @GetMapping("/api/v1/posts/{id}") // 메소드에 return결과를 mapping 주소에 요청
    public PostsResponseDto findById( @PathVariable Long id ){
        return postsService.findById(id);
    }

    // 리스트 컨트롤 = getmapping
    @GetMapping("/api/v1/posts/list")
    public List<PostsListResponseDto> findAll() {
        return postsService.findAllDesc();
    }


}
