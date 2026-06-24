//package org.spring.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.spring.springdockerpj2.service.MemberService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/member")
//@RequiredArgsConstructor
//public class MemberController {
//
//
//    private final MemberService memberService;
//
//    @GetMapping("/join")
//    public String join() {
//        return "member/join";
//    }
//
//    @GetMapping("/memberList")
//    public String list(Model model) {
//
//        model.addAttribute("memberList", memberService.memberList());
//
//        return "member/memberList";
//    }
//
//    @GetMapping("/detail/{id}")
//    public String detail(@PathVariable Long id, Model model) {
//
//        model.addAttribute("member", memberService.memberDetail(id)
//        );
//
//        return "member/detail";
//    }
//
//}
