package org.spring.springdockerpj2.service.impl;

import lombok.RequiredArgsConstructor;
import org.spring.springdockerpj2.dto.MemberDto;
import org.spring.springdockerpj2.entity.MemberEntity;
import org.spring.springdockerpj2.repository.MemberRepository;
import org.spring.springdockerpj2.service.MemberService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    // =================== 회원 가입 =================//
    @Override
    public void memberInsert(MemberDto memberDto) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findByUserEmail(memberDto.getUserEmail());
        if (optionalMemberEntity.isPresent()) {
            throw new IllegalArgumentException("중복이메일");
        }
        memberRepository.save(MemberEntity.builder()
                .userEmail(memberDto.getUserEmail())
                .userName(memberDto.getUserName())
                .userPw(memberDto.getUserPw())
                .build());
    }

    // =================== 회원 수정 =================//
    @Override
    public void memberUpdate(MemberDto memberDto) {
        memberRepository.findById(memberDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("해당 멤버 없음"));

        memberRepository.save(MemberEntity.builder()
                .id(memberDto.getId())
                .userEmail(memberDto.getUserEmail())
                .userName(memberDto.getUserName())
                .userPw(memberDto.getUserPw())
                .build());
    }

    // =================== 회원 삭제 =================//
    @Override
    public void memberDelete(Long id) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findById(id);

        if (!optionalMemberEntity.isPresent()) {
            throw new IllegalArgumentException("회원이 존재하지 않습니다.");
        }
        memberRepository.deleteById(id);
    }

    // =================== 회원 (전체)목록 =================//
    @Override
    public List<MemberDto> memberList() {
        return memberRepository.findAll().stream().map(el -> MemberDto.builder()
                .id(el.getId())
                .userEmail(el.getUserEmail())
                .userName(el.getUserName())
                .userPw(el.getUserPw())
                .build()).toList();
    }

    // =================== 회원 (상세)목록 =================//
    @Override
    public MemberDto memberDetail(Long id) {
        MemberEntity member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 멤버 없음"));

        return MemberDto.builder()
                .id(member.getId())
                .userEmail(member.getUserEmail())
                .userName(member.getUserName())
                .userPw(member.getUserPw())
                .build();
    }
}
