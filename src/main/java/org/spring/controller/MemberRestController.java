package org.spring.controller;

import lombok.RequiredArgsConstructor;
import org.spring.springdockerpj2.dto.MemberDto;
import org.spring.springdockerpj2.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberRestController {

    private final MemberService memberService;

    //======================  회원 가입  ======================//
    @PostMapping("/join")       // @RequestBody  MemberDto memberDto  // json
    public ResponseEntity<?> join(@ModelAttribute MemberDto memberDto) {  // form
        memberService.memberInsert(memberDto);

        Map<String, MemberDto> map = new HashMap<>();

        map.put("result", memberDto);

        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

    //======================  회원 수정  ======================//
    @PutMapping("/update")
    public ResponseEntity<?> update(@ModelAttribute MemberDto memberDto) {
        memberService.memberUpdate(memberDto);
        Map<String, MemberDto> map = new HashMap<>();
        map.put("result", memberDto);

        // 상태 state, 값(body)
        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

    //======================  회원 삭제  ======================//
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        memberService.memberDelete(id);
        Map<String, String> map = new HashMap<>();
        map.put("result", "ok");

        // 상태 state, 값(body)
        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

    //======================  회원 (상세)목록  ======================//
    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detail(@PathVariable("id") Long id) {
        MemberDto memberDto = memberService.memberDetail(id);
        Map<String, MemberDto> map = new HashMap<>();
        map.put("result", memberDto);

        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

    //======================  회원 (전체)목록  ======================//
    @GetMapping("/memberList")
    public ResponseEntity<?> memberList() {
        Map<String, List<MemberDto>> map = new HashMap<>();
        List<MemberDto> memberList = memberService.memberList();
        map.put("result", memberList);

        return ResponseEntity.status(HttpStatus.OK).body(map);
    }
}
