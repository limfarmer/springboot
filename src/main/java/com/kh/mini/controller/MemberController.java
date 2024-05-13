package com.kh.mini.controller;


import com.kh.mini.dao.MemberDao;
import com.kh.mini.vo.MemberVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users")
@Slf4j
public class MemberController {
    /**
     * 개별 회원정보 조회하는 메소드
     */
    @GetMapping("/search")
    public ResponseEntity<List<MemberVo>> getMemberInfo(@RequestParam String name){
        log.debug("회원 이름으로 조회 : " + name);
        MemberDao memDao = new MemberDao();
        List<MemberVo> list = memDao.memberSelect(name);
        return ResponseEntity.ok(list);
    }
    /**
     * POST 방식, 회원 가입
     */
    @PostMapping("/signUp")
    public ResponseEntity<Boolean> memberReg(@RequestBody MemberVo member){
        MemberDao dao = new MemberDao();
        boolean isTrue = dao.memberRegister(member);
        return ResponseEntity.ok(isTrue);
    }

}
