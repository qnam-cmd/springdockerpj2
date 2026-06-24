package org.spring.springdockerpj2.service;

import org.spring.springdockerpj2.dto.MemberDto;

import java.util.List;

public interface MemberService {
    void memberInsert(MemberDto memberDto);
    void memberUpdate(MemberDto memberDto);
    void memberDelete(Long id);
    List<MemberDto> memberList();
    MemberDto memberDetail(Long id);
}
