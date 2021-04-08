package com.jojo.book.web.admin.web;

import com.jojo.book.web.admin.config.auth.LoginUser;
import com.jojo.book.web.admin.config.auth.dto.SessionUser;
import com.jojo.book.web.admin.service.PostsService;
import com.jojo.book.web.admin.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor // 롬북 : 자동 생성자
@Controller
public class indexController {

    private final PostsService postsService; // 서비스 연결


    @GetMapping("/")  // 메인 페이지 get
    public String index(Model model , @LoginUser SessionUser user){

        model.addAttribute( "posts", postsService.findAllDesc());
                // 모델 : 모델명[ 리스트명 ] , 모델값[ 리스트 객체 ]




        if (user != null) {
            model.addAttribute("logName", user.getName());
        }



        return "index";
    }
    @GetMapping("/posts/save") // 저장 페이지 get
    public String postsSave(   Model model  ){



        return "posts-save";  }

    @GetMapping("/posts/update/{id}") // 수정 페이지 get
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }



}


