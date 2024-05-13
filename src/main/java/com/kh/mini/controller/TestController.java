package com.kh.mini.controller;

import com.kh.mini.vo.MemberVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
public class TestController {
    @GetMapping("/name")
    public String getName(){
        return "get방식의 통신이며 , api/name url로 이름을 받아오는 요청";
    }
    /**
     * @pathVariable의 연습 메소드
     * 매개 변수를 URL자체에 값을 담아 요청하는 방식, 경로 변수
     */
    @GetMapping("/varibale/{var}")
    public String getVar(@PathVariable String var){
        return "요청한 var(값?)은 " + var + "입니다.";
    }
    /**
     * @RequestParm이란 Get방식으로 정보를 전할하는 방식 연습 메소드
     */
    @GetMapping("/requset")
    public String getReqParm(@RequestParam String name,
                             @RequestParam String email,
                             @RequestParam String company){
        return name + " " + email + " " + company;
    }
    @GetMapping("/members")
    public List<Map<String, Object>> findMembers(){
        List<Map<String, Object>> members = new ArrayList<>();
        for(int i = 1; i <= 20; i++){
            Map<String,Object> member = new HashMap<>();
            member.put("id",i);
            member.put("name",i + "번 개발자");
            member.put("age",10 +i);
            members.add(member);
        }
        return members;
    }
    /**
     * 위 메소드의 다른방식
     * ResponseEntry를 쓰는 방식
     */
    @GetMapping("/members2")
    public ResponseEntity<List<MemberVo>> getMemberInfo(){
        List<MemberVo> members = new ArrayList<>();
        for (int i =0; i < 10; i++){
            MemberVo member = new MemberVo();
            member.setId("dla");
            member.setPwd("9575");
            member.setEmail("qqqnqlt123@naver.com");
            member.setName("임정후");
            members.add(member);
        }
        return ResponseEntity.ok(members);
    }
}
